package com.panjunfeng.dao;

import com.panjunfeng.domain.Student;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface StudentDao {
    //动态sql要使用java对象作为参数
   List<Student> selectStudentIf(Student student);
   //where的使用
   List<Student> selectStudentWhere(Student student);
   //foreach 用法1
    List<Student> selectForeachOne(List<Integer> idList);
    //foreach 用法2
    List<Student> selectForeachTwo(List<Student> studentList);
    //PageHelper使用
    List<Student> selectAllPageHelper();

}

