package com.panjunfeng.dao;

import com.panjunfeng.domain.Student;

import java.util.List;

/**
 * @author panjunfeng
 */
public interface StudentDao {
    /**
     * 查询Student表的所有数据
     * @return student表数据的集合
     */
    public List<Student> selectAllStudent();

    /**
     * 插入方法
     * @param student 要插入数据的载体
     * @return 插入数据库后影响的行数
     */
    public int insertStudent(Student student);


}
