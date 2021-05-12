package com.panjunfeng.dao;

import com.panjunfeng.domain.User;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface UserDao {
    int save(User user);
    List<User> selectAllUser();
}
