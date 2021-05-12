package com.panjunfeng.test;

import com.panjunfeng.dao.UserDao;
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
    public void testUserDaoSave(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        for (int i = 1020; i <=1020; i++) {
            User user=new User(i,"lisi"+i,"@1234"+i+"abc",new Date());
            int save = dao.save(user);
            sqlSession.commit();
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUserDaoSelectAllUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
