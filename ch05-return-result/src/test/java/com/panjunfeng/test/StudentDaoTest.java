package com.panjunfeng.test;
import com.panjunfeng.dao.StudentDao;
import com.panjunfeng.domain.MyStudent;
import com.panjunfeng.domain.Student;
import com.panjunfeng.utils.MyBatisUtils;
import com.panjunfeng.vo.QueryParam;
import com.panjunfeng.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panjunfeng
 */
public class StudentDaoTest {
    @Test
    public void studentDaoSelectTest() {
       /*
                使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
                getMapper能获取dao接口对应的实现类
        */
       SqlSession sqlSession=MyBatisUtils.getSqlSession();
       StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1002);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void selectMultiParamTest(){
      SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectMultiParam("lisi", 19);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void studentDaoSelectViewStudentTest() {
       /*
                使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
                getMapper能获取dao接口对应的实现类
        */
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        ViewStudent viewStudent = dao.selectStudentReturnViewStudent(1003);
        System.out.println(viewStudent);
        sqlSession.close();
    }

    @Test
    public void studentDaoCountStudentTest() {
       /*
                使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
                getMapper能获取dao接口对应的实现类
        */
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        int count = dao.countStudent();
        System.out.println("学生的数量：  "+count );
        sqlSession.close();
    }

    @Test
    public void selectMapByIdTest() {
       /*
                使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
                getMapper能获取dao接口对应的实现类
        */
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println("map---------------->"+map);
    }

    @Test
    public void selectAllStudentTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectAllStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }


    @Test
    public void selectselectMyStudentsTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectMyStudents();
        for (MyStudent myStudent : myStudents) {
            System.out.println("myStudent= "+myStudent);
        }
        sqlSession.close();
    }
    @Test
    public void selectDiffColPropertyTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectDiffColProperty();
        for (MyStudent myStudent : myStudents) {
            System.out.println("myStudent= "+myStudent);
        }
        sqlSession.close();
    }

    @Test
    public void selectLikeOneTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectLikeOne("%li%");
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectLikeTwoTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectLikeTwo("li");
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
