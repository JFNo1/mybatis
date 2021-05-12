package com.panjunfeng.dao;

import com.panjunfeng.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface RoleDao {
    @Select("select * from user_role ur join role r on ur.roleid=r.id where ur.userid=#{uid}")
    List<Role> findByUserId(int uid);
}
