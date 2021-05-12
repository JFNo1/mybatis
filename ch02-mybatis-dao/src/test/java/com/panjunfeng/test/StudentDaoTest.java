package com.panjunfeng.test;

import com.panjunfeng.dao.StudentDao;
import com.panjunfeng.dao.impl.StudentDaoImpl;
import com.panjunfeng.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author panjunfeng
 */
public class StudentDaoTest {
    @Test
    public void studentDaoSelectTest(){
        StudentDao dao=new StudentDaoImpl();
        /*
         * List<Student> studentList  = dao.selectStudents(); 调用
         * 1.dao对象，类型是StudentDao，全限定名称是：com.panjunfeng.dao.StudentDao
         *   全限定名称 和 namespace 是一样的。
         *
         * 2.方法名称，selectAllStudent， 这个方法就是 mapper文件中的 id值 selectAllStudent
         *
         * 3.通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *    如果返回值是List ，调用的是SqlSession.selectList()方法。
         *    如果返回值 int ，或是非List的， 看mapper文件中的 标签是<insert>，<update> 就会调用
         *    SqlSession的insert， update等方法
         *
         *  mybatis的动态代理： mybatis根据 dao的方法调用，获取执行sql语句的信息。
         *     mybatis根据你的dao接口，创建出一个dao接口的实现类， 并创建这个类的对象。
         *     完成SqlSession调用方法， 访问数据库。
         *
         */
        List<Student> studentList = dao.selectAllStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void studentDaoInsertTest(){
        StudentDao dao=new StudentDaoImpl();
        int count = dao.insertStudent(new Student(1007, "smith", "smith@163.com", 21));
        System.out.println(count);
    }
}
