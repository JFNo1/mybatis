package com.panjunfeng.domain;

import java.util.Date;
import java.util.List;

/**
 * @author panjunfeng
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    /**
     * 描述的是当前用户存在哪些订单
     */
    private List<Order> orders;
    /**
     * 描述的是当前用户具有哪些角色
     */
    private  List<Role> roles;

    public User(Integer id, String username, String password, Date birthday, List<Order> orders, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.orders = orders;
        this.roles = roles;
    }

    public User() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", orders=" + orders +
                ", roles=" + roles +
                '}';
    }
}
