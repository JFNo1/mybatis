package com.panjunfeng.dao;

import com.panjunfeng.domain.Order;
import com.panjunfeng.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface OrderDao {

    //注解一对一查询方式一
/*    @Select("select o.id oid,o.ordertime,o.total,o.uid,u.username,u.password,u.birthday from orders o join user u on o.uid=u.id")
    @Results({
            @Result(column = "oid" ,property = "id"),
            @Result(column = "ordertime" ,property = "ordertime"),
            @Result(column = "total" ,property = "total"),
            @Result(column = "uid" ,property = "user.id"),
            @Result(column = "username" ,property = "user.username"),
            @Result(column = "password" ,property = "user.password"),
            @Result(column = "birthday" ,property = "user.birthday")
    })
     List<Order> findAll();*/


    //注解一对一查询方式二
    @Select("select * from orders")
    @Results({
        @Result(column = "oid" ,property = "id"),
        @Result(column = "ordertime" ,property = "ordertime"),
        @Result(column = "total" ,property = "total"),
        @Result(
                //要封装的属性名称
                property = "user",
                //根据哪个字段去查询user表的数据
                column = "uid",
                //要封装的实体类型
                javaType = User.class,
                //select属性代表查询哪个接口的方法获得数据
                one = @One(select = "com.panjunfeng.dao.UserDao.findById")
        )
    })
    List<Order> findAll();
    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(@Param("uid") int uid);
}
