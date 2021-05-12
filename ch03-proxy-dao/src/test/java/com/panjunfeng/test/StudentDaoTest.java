package com.panjunfeng.test;
import com.panjunfeng.dao.StudentDao;
import com.panjunfeng.domain.Student;
import com.panjunfeng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author panjunfeng
 */
public class StudentDaoTest {
    @Test
    public void studentDaoSelectTest(){
       /*
                使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
                getMapper能获取dao接口对应的实现类
        */
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //com.sun.proxy.$Proxy2  :    jdk的动态代理
        System.out.println("dao------------------------------------------>"+dao.getClass().getName());
        List<Student> studentList = dao.selectAllStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }


    }

    @Test
    public void studentDaoInsertTest(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        int count = dao.insertStudent(new Student(1008, "alean", "@alean163.com", 18));
        sqlSession.commit();
        System.out.println("------------------------>"+count);
    }
}
