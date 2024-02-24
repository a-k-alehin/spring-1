package ru.specialist.dbJDBC;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.apache.commons.dbcp.BasicDataSource;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("ru.specialist.dao")  // смешанная конфигурация: java_config + annotations
public class DaoConfig {

	// можно делать связывание и так:
    //@Value("${jdbc.url}")
    //private String url;

    @Autowired
    private Environment env;

    //@Bean(destroyMethod = "close") // no need for close() or shutdown()
    @Bean
    public DataSource webDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        //ds.setUrl(url);
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(webDataSource());  // webDataSource() будет заменено на обращение к Bean
    }

    /*
	@Bean  // так будет простой бин, а не Repository.
	       // И будет SQLException вместо спринговых exception-ов
    public CourseDAO courseDAO() {
        JdbcCourseDAO dao = new JdbcCourseDAO();
        //dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }

	@Bean
    public RowMapper<Course> courseRowMapper() {
        return new CourseRowMapper();
    }*/
}
