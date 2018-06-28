package com.student.crm.web;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

import java.io.IOException;

/**
 * Created by Administrator on 2017/10/14.
 */
public class SpringError extends SqlSessionFactoryBean
{
    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        try {
            return super.buildSqlSessionFactory();
        } catch (NestedIOException e) {
            e.printStackTrace(); // XML 有错误时打印异常。
            throw new NestedIOException(e.getMessage());
        } finally {
            ErrorContext.instance().reset();
        }
    }
}
