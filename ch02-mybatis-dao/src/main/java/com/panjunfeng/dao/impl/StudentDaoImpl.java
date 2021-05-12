package com.panjunfeng.dao.impl;

import com.panjunfeng.dao.StudentDao;
import com.panjunfeng.domain.Student;
import com.panjunfeng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author panjunfeng
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectAllStudent() {
        //获取SqlSession
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlId="com.panjunfeng.dao.StudentDao.selectAllStudent";
        List<Student> studentList=sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlId="com.panjunfeng.dao.StudentDao.insertStudent";
        int count = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
