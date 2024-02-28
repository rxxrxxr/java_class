package org.example.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
//components안에 있는 클래스 스캔
//ioc컨테이너에 저장
@ComponentScan("org.example.components")
public class MyConf {
    @Autowired
    ApplicationContext context;

    //커텍션 풀 생성
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();
        //bds.setInitialSize(10); 기본값이 10이라 생략 가능
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://192.168.0.38/gcw");
        bds.setUsername("root");
        bds.setPassword("1234");
        return bds;
    }

    // sql mopper 문장 sql 공장
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(
                (new PathMatchingResourcePatternResolver())
                        .getResources("classpath*:sql/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSession sqlSession() throws Exception{
        return new SqlSessionTemplate(sqlSessionFactoryBean());
    }

}
