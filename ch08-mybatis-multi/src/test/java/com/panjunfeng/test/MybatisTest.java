package com.panjunfeng.test;

import com.panjunfeng.dao.OrderDao;
import com.panjunfeng.dao.UserDao;
import com.panjunfeng.domain.Order;
import com.panjunfeng.domain.User;
import com.panjunfeng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author panjunfeng
 */
public class MybatisTest {
    @Test
    public void testOrderDaofindAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        OrderDao dao = sqlSession.getMapper(OrderDao.class);
        List<Order> orders = dao.findAll();
        for (Order order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void testUserDaofindAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testUserDaofindUserAndRoleAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findUserAndRoleAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
