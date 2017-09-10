package com.team6.leangoo.mapper;

import com.team6.leangoo.model.UserFriend;
import com.team6.leangoo.util.MyMapper;

import java.util.List;

public interface UserFriendMapper extends MyMapper<UserFriend> {
    public List getFriendList(Integer userId);
}