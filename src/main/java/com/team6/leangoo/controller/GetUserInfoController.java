package com.team6.leangoo.controller;

import com.team6.leangoo.model.User;
import com.team6.leangoo.service.GetUserInfoService;
import com.team6.leangoo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetUserInfoController {
    private final GetUserInfoService getUserInfoService;

    @Autowired
    public GetUserInfoController(GetUserInfoService getUserInfoService){
        this.getUserInfoService = getUserInfoService;
    }

    @RequestMapping(value = "/getUserInfoById",method = RequestMethod.POST)
    public AjaxResult getUserInfoById(){
        Integer userId = 1;
        AjaxResult ajaxResult = new AjaxResult();
        try {
            ajaxResult.setData(getUserInfoService.getUserInfoById(userId));
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
            User user = getUserInfoService.getUserInfoById(userId);
            if (getUserInfoService.changeUserInfo(user,userMsg)==1) {
                ajaxResult.seterrcode(0);
            } else {
                ajaxResult.seterrcode(10);
                ajaxResult.setinfo("操作失败");
            }
            ajaxResult.setData(getUserInfoService.getUserInfoById(userId));
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
            User user = getUserInfoService.getUserInfoById(userId);
            if (getUserInfoService.changeUserPasssword(user,map) == 1) {
                ajaxResult.seterrcode(0);
            } else {
                ajaxResult.seterrcode(10);
                ajaxResult.setinfo("操作失败");
            }
            return ajaxResult;
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.seterrcode(10);
            ajaxResult.setinfo("请求失败");
            return ajaxResult;
        }
    }
}
