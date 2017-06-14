package com.axmedbek.config;

import com.axmedbek.dao.PersonDao;
import com.axmedbek.dao.PersonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Created by axmedbek on 6/11/17.
 */
@Configuration
@ComponentScan("com.axmedbek")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setPrefix("/");
        view.setSuffix(".jsp");
        return view;
    }

    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/web");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean
    public PersonDao personDao()
    {
        return new PersonDaoImpl(getDataSource());
    }

}
