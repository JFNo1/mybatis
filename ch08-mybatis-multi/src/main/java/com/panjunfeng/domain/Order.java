package com.panjunfeng.domain;

import java.util.Date;

/**
 * @author panjunfeng
 */
public class Order {
    private Integer id;
    private Date ordertime;
    private double total;
    /**
     * 当前订单属于哪个用户
     */
    private User user;

    public Order(Integer id, Date ordertime, double total, User user) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.user = user;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
