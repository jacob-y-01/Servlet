package com.test;

import com.test.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.io.IOException;
import java.util.List;

public class mybatis {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis核心配置文件，获取sqlsessionfactory
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlsession对象，执行sql
        List<User>Users= SqlSession.selectList("test.selectBlog");
        //SqlSession.selectOne();
        System.out.println(Users);

        SqlSession.close();
    }
}
