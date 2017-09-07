package com.team6.leangoo.service;

import com.team6.leangoo.mapper.UserMapper;
import com.team6.leangoo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GetUserInfoService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfoById(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }
    public int changeUserInfo(User user){
        return userMapper.updateByPrimaryKey(user);
    }
    public int changeUserPasssword(String userPassword,Integer userId){
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserPassword(userPassword);
        return userMapper.updateByPrimaryKey(user);
    }
}
