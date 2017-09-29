package com.team6.leangoo.service;

import com.team6.leangoo.mapper.UserMapper;
import com.team6.leangoo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfoById(User user){
        return userMapper.selectOne(user);
    }
    public int changeUserInfo(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
    public User selectUserByAccount(User user){
        return userMapper.selectOne(user);
    }
    public User findUserByAccount(String account){return userMapper.findByUserName(account);}
    public User selectUserPersonalBoardList(Integer userId){
        return userMapper.selectPersonalBoardList(userId);
    }
}
