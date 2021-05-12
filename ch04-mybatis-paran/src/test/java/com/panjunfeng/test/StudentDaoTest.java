package com.panjunfeng.test;
import com.panjunfeng.dao.StudentDao;
import com.panjunfeng.domain.Student;
import com.panjunfeng.utils.MyBatisUtils;
import com.panjunfeng.vo.QueryParam;
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
    public void selectMultiObjectTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param=new QueryParam("lisi",22);
        List<Student> studentList = dao.selectMultiObjrct(param);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void selectMultiStudentTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
       Student s=new Student();
       s.setName("wangwu");
       s.setAge(25);
        List<Student> studentList = dao.selectMultiStudent(s);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void selectMultiPositionTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = dao.selectMultiPosition("lisi",22);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectMultiMapTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map=new HashMap<>();
        map.put("myName","zhangsan");
        map.put("myAge",22);
        List<Student> studentList = dao.selectMultiMap(map);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectUser$Test(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectUserBy$("'lisi'");
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void selectUser$OrderTest(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectUserBy$Order("age");
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
