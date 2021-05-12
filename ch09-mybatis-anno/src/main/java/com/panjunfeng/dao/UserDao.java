package com.panjunfeng.dao;

import com.panjunfeng.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface UserDao {
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    int save(User user);
    @Select("select * from user")
    List<User> findAll();
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    int update(User user);
    @Delete("delete from user where id=#{id}")
    int delete(@Param("id") int id);
    @Select("select * from user where id=#{id};")
    User findById(@Param("id") int id);

    //注解一对多查询方式
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property ="id" ),
            @Result(column = "username",property ="username" ),
            @Result(column = "password",property ="password" ),
            @Result(column = "birthday",property ="birthday" ),
            @Result(
                    property = "orders",
                    //根据哪个条件查询封装
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.panjunfeng.dao.OrderDao.findByUid")
            )
    })
    List<User> findUserAndOrderAll();


    //注解多对多查询映射配置
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    property = "roles",
                    //根据哪个条件查询封装
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.panjunfeng.dao.RoleDao.findByUserId")
            )
    })
    List<User> findUserAndRole();

}
