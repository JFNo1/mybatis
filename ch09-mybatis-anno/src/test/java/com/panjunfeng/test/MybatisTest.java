package com.panjunfeng.test;

import com.panjunfeng.dao.OrderDao;
import com.panjunfeng.dao.UserDao;
import com.panjunfeng.domain.Order;
import com.panjunfeng.domain.User;
import com.panjunfeng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/**
 * @author panjunfeng
 */
public class MybatisTest {
    @Test
    public void testUserDaoSave(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
         UserDao dao = sqlSession.getMapper(UserDao.class);
        User user=new User(1022,"zhaoliu","@123456789abc",new Date());
        dao.save(user);
        sqlSession.close();
    }
    @Test
    public void testUserDaoUpdate(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user=new User(1002,"smith","jkl0987",new Date());
        dao.update(user);
        sqlSession.close();
    }
    @Test
    public void testUserDaoDelete(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.delete(1021);
        sqlSession.close();
    }
    @Test
    public void testUserDaoFindById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = dao.findById(1001);
        System.out.println("--------->"+user);
        sqlSession.close();
    }
    @Test
    public void testUserDaoFindAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println("--------->"+user);
        }
        sqlSession.close();
    }

    @Test
    public void testOrderDaoFindAll() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        OrderDao dao = sqlSession.getMapper(OrderDao.class);
        List<Order> orders = dao.findAll();
        for (Order order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void testUserDaoFindUserAndOrderAll() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findUserAndOrderAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testUserDaofindUserAndRole() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findUserAndRole();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
