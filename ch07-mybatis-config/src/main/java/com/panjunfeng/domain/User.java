package com.panjunfeng.domain;

import java.util.Date;

/**
 * @author panjunfeng
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date birthday;

    public User(Integer id, String usernname, String password, Date birthday) {
        this.id = id;
        this.username = usernname;
        this.password = password;
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usernname='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
