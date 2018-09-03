package com.QFDC.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.QFDC.mapper",value="primarySqlSessionTemplate")
public class DataSourceConfig {
    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix="datasource")
    @Primary
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(primaryDataSource);
        return sessionFactory.getObject();
    }

    @Bean(name="primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryDataSourceTransactionManager(@Qualifier("primaryDataSource") DataSource primaryDataSource){
        return new DataSourceTransactionManager(primaryDataSource);
    }

    @Bean(name="primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory")SqlSessionFactory primarySqlSessionFactory){
        return new SqlSessionTemplate(primarySqlSessionFactory);
    }
}
