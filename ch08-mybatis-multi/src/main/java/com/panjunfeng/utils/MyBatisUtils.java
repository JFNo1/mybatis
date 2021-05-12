package com.panjunfeng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author panjunfeng
 */
public class MyBatisUtils {

    private static SqlSessionFactory factory=null;
    static {
        //需要和项目中的文件名一致
        String config="mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建sqlSessionFactory对象
             factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSession对象的方法
     * @return sqlSession对象
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }

    /**
     * 获取sqlSession对象的方法
     * @param b 选择是否自动提交事务
     * @return sqlSession对象
     */
    public static SqlSession getSqlSession(boolean b){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession=factory.openSession(b);
        }
        return sqlSession;
    }
}

