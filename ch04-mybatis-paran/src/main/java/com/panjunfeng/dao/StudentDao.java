package com.panjunfeng.dao;

import com.panjunfeng.domain.Student;
import com.panjunfeng.vo.QueryParam;
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

    /**
     *多个参数：使用java对象作为接口中方法的参数
     * @param param
     * @return
     */
    List<Student> selectMultiObjrct(QueryParam param);
    List<Student> selectMultiStudent(Student student);

    /**
     * 多个参数，简单类型，按位置传参
     * mybatis3.4之前使用#{0}，#{1}
     * mybatis3.4之后使用#{arg0}，#{arg1}
     * @param name
     * @param age
     * @return
     */
    List<Student> selectMultiPosition(String name, Integer age);

    /**
     * 多个参数：使用map存放多个值
     * @param map
     * @return
     */
    List<Student> selectMultiMap(Map<String, Object> map);

    /**
     * 使用$占位符，$占位符有sql注入的风险
     * @param name
     * @return
     */
    List<Student> selectUserBy$(@Param("name") String name);

    /**
     * 使用$占位符进行列名的替换
     * @param colName
     * @return
     */
    List<Student> selectUserBy$Order(@Param("colName") String colName);


}

