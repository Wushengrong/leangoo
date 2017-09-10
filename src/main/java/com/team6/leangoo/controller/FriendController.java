package com.team6.leangoo.controller;

import com.team6.leangoo.model.User;
import com.team6.leangoo.model.UserFriend;
import com.team6.leangoo.service.FriendService;
import com.team6.leangoo.service.GetUserInfoService;
import com.team6.leangoo.util.AjaxResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lfxiui
 * Date: 2017/9/7
 * Time: 17:00
 */
@RestController
public class FriendController {
    private final FriendService friendService;
    private final GetUserInfoService getUserInfoService;

    public FriendController(FriendService friendService,GetUserInfoService getUserInfoService){
        this.friendService = friendService;
        this.getUserInfoService = getUserInfoService;
    }

    @RequestMapping(value = "/getFriendList",method = RequestMethod.POST)
    public AjaxResult getFriendList(){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            User user = getUserInfoService.getUserInfoById(userId);
            List friendList = friendService.getFriendList(user);
            ajaxResult.seterrcode(0);
            ajaxResult.setData(friendList);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }

    @RequestMapping(value = "/addFriend",method = RequestMethod.POST)
    public AjaxResult addFriend(@RequestBody Map map){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            String friendAccount = map.get("friendAccount").toString();
            User user = getUserInfoService.getUserInfoById(userId);
            User friend = friendService.selectUserByAccount(friendAccount);
            UserFriend userFriend = new UserFriend();
            userFriend.setUserId(user.getUserId());
            userFriend.setFriendTo(friend.getUserId());
            if (friendService.addFriend(userFriend) == 1){
                ajaxResult.seterrcode(0);
                ajaxResult.setinfo("添加成功");
            }else {
                ajaxResult.seterrcode(2);
                ajaxResult.setinfo("添加失败，好友已存在!");
            }
            ajaxResult.setData(friendService.getFriendList(user));
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }

    @RequestMapping(value = "/deleteFriend",method = RequestMethod.POST)
    public AjaxResult deleteFriend(@RequestBody Map map){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            String friendAccount = map.get("friendAccount").toString();
            User user = getUserInfoService.getUserInfoById(userId);
            User friend = friendService.selectUserByAccount(friendAccount);
            UserFriend userFriend = new UserFriend();
            userFriend.setUserId(user.getUserId());
            userFriend.setFriendTo(friend.getUserId());
            if (friendService.deleteFriend(userFriend) == 1){
                ajaxResult.seterrcode(0);
                ajaxResult.setinfo("删除成功");
            }else {
                ajaxResult.seterrcode(2);
                ajaxResult.setinfo("删除失败，好友不存在!");
            }
            ajaxResult.setData(friendService.getFriendList(user));
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }
}
