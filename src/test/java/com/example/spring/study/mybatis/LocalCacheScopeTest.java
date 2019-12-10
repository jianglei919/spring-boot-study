package com.example.spring.study.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by jianglei on 2019/12/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalCacheScopeTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() {

    }
}
