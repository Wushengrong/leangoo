package com.team6.leangoo.model;

import javax.persistence.*;

@Table(name = "user_friend")
public class UserFriend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "friend_to")
    private Integer friendTo;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return friend_to
     */
    public Integer getFriendTo() {
        return friendTo;
    }

    /**
     * @param friendTo
     */
    public void setFriendTo(Integer friendTo) {
        this.friendTo = friendTo;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}