package com.panjunfeng;


import com.panjunfeng.domain.Student;
import com.panjunfeng.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 测试查询方法
     */
    @Test
    public void testSelect(){
        //访问mybatis读取studen数据
        //1.定义mybatis主配置文件的位置，从类路径开始
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        try {
            InputStream in= Resources.getResourceAsStream(config);
            //3.创建sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            //4.创建SqlSessionFactory对象
            SqlSessionFactory factory=builder.build(in);
            System.out.println("--------------------->"+factory);
            //5.从SqlSessionFactory对象对象中获取SqlSession对象
            SqlSession sqlSession=factory.openSession();
            //6.指定要执行SQL语句的标识。sql映射文件中的namespace+"."+标签的id值
            String sqlId="com.panjunfeng.dao.StudentDao.selectAllStudent";
            //7.执行SQL语句，通过sqlId找到来执行
            List<Student> studentList = sqlSession.selectList(sqlId);
            //8.输出结果
            for (Student student : studentList) {
                System.out.println(student);
            }
            //9.关闭sqlSession对象
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试插入方法
     */
    @Test
    public void testInsert(){
        //访问mybatis读取studen数据
        //1.定义mybatis主配置文件的位置，从类路径开始
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        try {
            InputStream in= Resources.getResourceAsStream(config);
            //3.创建sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            //4.创建SqlSessionFactory对象
            SqlSessionFactory factory=builder.build(in);
            //5.从SqlSessionFactory对象对象中获取SqlSession对象
            SqlSession sqlSession=factory.openSession();
            //6.指定要执行SQL语句的标识。sql映射文件中的namespace+"."+标签的id值
            String sqlId="com.panjunfeng.dao.StudentDao.insertStudent";
            Student student=new Student(1005,"tianqi","tianqi@163.com",35);
            //7.执行SQL语句，通过sqlId找到来执行
            int result = sqlSession.insert(sqlId, student);
            //mybatis默认不是自动提交事务的，所以在insert，update，delete后要自己手动提交
            sqlSession.commit();

            //8.输出结果
            System.out.println("修改的数据行为： "+result);
            //9.关闭sqlSession对象
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试MyBatis工具类
     */
    @Test
    public void testMyBatisUtils(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlId="com.panjunfeng.dao.StudentDao.selectAllStudent";
        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach(student -> System.out.println(student));

    }
}
