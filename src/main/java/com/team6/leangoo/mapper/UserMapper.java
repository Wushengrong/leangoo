package com.team6.leangoo.mapper;

import com.team6.leangoo.model.User;
import com.team6.leangoo.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {
    public User findByUserName(String username);
    public User selectPersonalBoardList(@Param("userId") Integer userId);

}