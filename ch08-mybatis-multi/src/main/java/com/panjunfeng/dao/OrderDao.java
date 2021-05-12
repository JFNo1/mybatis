package com.panjunfeng.dao;

import com.panjunfeng.domain.Order;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface OrderDao {
    List<Order> findAll();
}
