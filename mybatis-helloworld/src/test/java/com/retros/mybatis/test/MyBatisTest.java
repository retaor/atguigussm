package com.retros.mybatis.test;

import com.retros.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Hil
 * @Date: 2022/9/27 14 :17
 * @Description: Hello world!
 */
public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取字节输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuild 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql 的会话对象 SQLSession , 是 Mybatis 提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 UserMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用 mapper 接口 中的方法, 实现添加用户信息的功能
        int result = mapper.insertUser();
        System.out.println("结果: " + result);
        //提交事务
        sqlSession.commit();
        //关闭sqlSession 对象
        sqlSession.close();

    }
}
