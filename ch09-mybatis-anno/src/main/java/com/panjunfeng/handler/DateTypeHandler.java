package com.panjunfeng.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author panjunfeng
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {

    //将java对象转换成数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);


    }

    /**
     * 将数据库中类型转换成java类型
     * @param resultSet 查询结果集
     * @param s 数据库要转换的字段的名称
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获得结果集中需要的数据（bigint），转换成Date型返回
        long aLong = resultSet.getLong(s);
        return new Date(aLong);
    }

    //将数据库中类型转换成java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }

    //将数据库中类型转换成java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }
}
