package com.team6.leangoo.service;

import com.team6.leangoo.mapper.UserMapper;
import com.team6.leangoo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class GetUserInfoService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfoById(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }
    public int changeUserInfo(User user,User userMsg){
        user.setUserIntro(userMsg.getUserIntro());
        user.setUserEmail(userMsg.getUserEmail());
        user.setUserSex(userMsg.getUserSex());
        return userMapper.updateByPrimaryKey(user);
    }
    public int changeUserPasssword(User user, Map map){
        String oldPwd = map.get("oldPwd").toString();
        String newPwd = map.get("newPwd").toString();
        String newPwdConfirm = map.get("newPwdConfirm").toString();
        if (user.getUserPassword().equals(oldPwd) && newPwd.equals(newPwdConfirm)){
            user.setUserPassword(newPwd);
            return userMapper.updateByPrimaryKey(user);
        }else return 0;

    }
}
