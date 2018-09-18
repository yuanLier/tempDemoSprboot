package com.demo.tempsprboot.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class SessionFactoryConfig {
    @Value("${mybatis.config-location}")
    private String mybatisConfigPath;

    @Value("${mybatis.mapper-locations}")
    private String mapperPath;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Autowired
    private DataSource dataSource;

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置mybatis-config.xml的扫描路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
        //指定mapper（联系sql操作和实体类）路径，resolver用来处理文件流
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //指定mapper文件的扫描路径
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        //通过定义好的resolver读取mapper路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        //对应数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定实体类所在的package的扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

        return sqlSessionFactoryBean;
    }
}
