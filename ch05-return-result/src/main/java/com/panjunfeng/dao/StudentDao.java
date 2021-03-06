package com.panjunfeng.dao;

import com.panjunfeng.domain.MyStudent;
import com.panjunfeng.domain.Student;
import com.panjunfeng.vo.QueryParam;
import com.panjunfeng.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author panjunfeng
 */
public interface StudentDao {
    /**
     * 一个简单类型的参数：
     * 简单类型：mybatis把java的基本数据类型和String都叫简单类型
     * 在mapper文件获取简单类型的一个参数的值，使用#{任意字符}
     * @param id
     * @return
     */
    Student selectStudentById(@Param("id") Integer id);

    /**
     * 多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
     * @param name
     * @param age
     * @return
     */
    List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);
    ViewStudent selectStudentReturnViewStudent(@Param("id") Integer id);
    int countStudent();
    Map<Object,Object> selectMapById(@Param("id") Integer id);

    /**
     * 使用resultMap定义映射关系
     * @return
     */
    List<Student> selectAllStudents();
    List<MyStudent> selectMyStudents();
    List<MyStudent> selectDiffColProperty();
    /*第一种模糊查询，在java代码中指定like的内容*/
    List<Student> selectLikeOne(String name);
    /*name就是li这个值，在mapper中拼接like %li%*/
    List<Student> selectLikeTwo(String name);
}

