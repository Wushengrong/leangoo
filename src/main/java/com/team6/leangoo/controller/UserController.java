package com.team6.leangoo.controller;

import com.team6.leangoo.model.User;
import com.team6.leangoo.service.UserService;
import com.team6.leangoo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/getUserInfoById",method = RequestMethod.POST)
    public AjaxResult getUserInfoById(){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            User user = new User();
            user.setUserId(userId);
            user = userService.getUserInfoById(user);
            ajaxResult.setData(user);
            ajaxResult.seterrcode(0);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }

    @RequestMapping(value = "/changeUserInfo",method = RequestMethod.POST)
    public AjaxResult changeUserInfo(@RequestBody User userMsg){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            userMsg.setUserId(userId);
            if (userService.changeUserInfo(userMsg)==1) {
                ajaxResult.seterrcode(0);
            } else {
                ajaxResult.seterrcode(10);
                ajaxResult.setinfo("操作失败");
            }
            User user = new User();
            user.setUserId(userId);
            user = userService.getUserInfoById(user);
            ajaxResult.setData(user);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }

    @RequestMapping(value = "/changeUserPassword",method = RequestMethod.POST)
    public AjaxResult changeUserPassword(@RequestBody Map map){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            User user = new User();
            user.setUserId(userId);
            user = userService.getUserInfoById(user);
            String oldPwd = map.get("oldPwd").toString();
            String newPwd = map.get("newPwd").toString();
            String newPwdConfirm = map.get("newPwdConfirm").toString();
            if (user.getUserPassword().equals(oldPwd) && newPwd.equals(newPwdConfirm)){
                user.setUserPassword(newPwd);
                if(userService.changeUserInfo(user) == 1) ajaxResult.seterrcode(0);
                else {
                    ajaxResult.seterrcode(0);
                    ajaxResult.setinfo("修改失败");
                }
            }else {
                ajaxResult.seterrcode(0);
                ajaxResult.setinfo("密码错误，请重新输入");
            }
            map = new HashMap();
            map.put("userPassword",user.getUserPassword());
            ajaxResult.setData(map);
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }
}
