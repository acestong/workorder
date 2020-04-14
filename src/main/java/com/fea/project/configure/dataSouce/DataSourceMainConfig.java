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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/24 11:31
 **/
@Configuration
@MapperScan(basePackages = {"com.fea.project.api.other.dao"}, sqlSessionFactoryRef = "mainSqlSessionFactory")
public class DataSourceMainConfig {


    @Autowired
    private PageHelpParamConfig pageHelpParamConfig;
    @Value("${mybatis.main.mapper-locations}")
    private String resourcePath;

    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.main")
    public HikariDataSource mainDataSource() {
        return (HikariDataSource) DataSourceBuilder.create().build();
    }

    @Bean(name = "mainSqlSessionFactory")
    public SqlSessionFactory mainSqlSessionFactory(@Qualifier("mainDataSource") HikariDataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(resourcePath));
        bean.setPlugins(new Interceptor[]{new MybatisPrimaryKeyAutoCreatePlugin()});
        return bean.getObject();
    }

    @Bean(name = "mainTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("mainDataSource") HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mainSqlSessionTemplate")
    public SqlSessionTemplate projectSqlSessionTemplate(@Qualifier("mainSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}