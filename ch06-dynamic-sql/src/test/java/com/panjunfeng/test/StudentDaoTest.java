package com.panjunfeng.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panjunfeng.dao.StudentDao;
import com.panjunfeng.domain.Student;
import com.panjunfeng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panjunfeng
 */
public class StudentDaoTest {
    @Test
    public void testSelectStudentIf(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("lisi");
        student.setAge(22);
        List<Student> studentList = dao.selectStudentIf(student);
        for (Student s : studentList) {
            System.out.println("student--------------->"+s);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        //student.setName("lisi");
      //  student.setAge(22);
        List<Student> studentList = dao.selectStudentWhere(student);
        for (Student s : studentList) {
            System.out.println("student--------------->"+s);
        }
        sqlSession.close();
    }
    @Test
    public void testFor(){
        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        String sql="select * from student where id in";
        StringBuilder builder=new StringBuilder("");
        int init=0;
        int len=list.size();
        builder.append(" (");
        for (Integer i : list) {
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql=sql+builder.toString();
        System.out.println("sql---------->"+sql);
    }

    @Test
    public void testSelectForeachOne(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> studentList = dao.selectForeachOne(list);
        for (Student s : studentList) {
            System.out.println("student--------------->"+s);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectForeachTwo(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student s1=new Student();
        s1.setId(1001);
        list.add(s1);
        s1=new Student();
        s1.setId(1003);
        list.add(s1);
        s1=new Student();
        s1.setId(1005);
        list.add(s1);
        List<Student> studentList = dao.selectForeachTwo(list);
        for (Student s : studentList) {
            System.out.println("student--------------->"+s);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectAllPageHelper(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //??????PageHelper??????????????????
       PageHelper.startPage(1, 3);


        List<Student> studentList = dao.selectAllPageHelper();
        for (Student s : studentList) {
            System.out.println("student--------------->"+s);
        }
        PageInfo<Student> info = new PageInfo<>(studentList);
        System.out.println("????????????----------->"+info.getPageNum());
        System.out.println("?????????????????????----------->"+info.getPageSize());
        System.out.println("????????????---------->"+info.getTotal());
        System.out.println("????????????---------->"+info.getPages());
        System.out.println("????????????---------->"+info.getPrePage());
        System.out.println("????????????---------->"+info.getNextPage());
        System.out.println("?????????????????????---------->"+info.isIsFirstPage());
        System.out.println("????????????????????????---------->"+info.isIsLastPage());
        sqlSession.close();
    }
}
