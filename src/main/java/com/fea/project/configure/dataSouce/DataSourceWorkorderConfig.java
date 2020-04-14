package com.fea.project.configure.dataSouce;

import com.fea.project.configure.MybatisPrimaryKeyAutoCreatePlugin;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 
 **/
@Configuration
@MapperScan(basePackages = {"com.fea.project.workorder.dao"}, sqlSessionFactoryRef = "workorderSqlSessionFactory")
public class DataSourceWorkorderConfig {

    @Value("${mybatis.workorder.mapper-locations}")
    private String resourcePath;

    @Bean(name = "workorderDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.workorder")
    public HikariDataSource workorderDataSource() {
        return (HikariDataSource) DataSourceBuilder.create().build();
    }

    @Bean(name = "workorderSqlSessionFactory")
    public SqlSessionFactory workorderSqlSessionFactory(@Qualifier("workorderDataSource") HikariDataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(resourcePath));
        bean.setPlugins(new Interceptor[]{new MybatisPrimaryKeyAutoCreatePlugin()});
        return bean.getObject();
    }

    @Bean(name = "workorderTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("workorderDataSource") HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "workorderSqlSessionTemplate")
    public SqlSessionTemplate workorderSqlSessionTemplate(@Qualifier("workorderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}