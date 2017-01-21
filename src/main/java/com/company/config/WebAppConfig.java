package com.company.config;

import com.company.filters.LoginPageInterceptor;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableWebMvc
@ComponentScan("com.company")
@PropertySource("classpath:connection.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    // Позволяет видеть все ресурсы в папке pages, такие как картинки, стили и т.п.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginPageInterceptor()).addPathPatterns("/");
    }

    // а этот бин инициализирует View нашего проекта
    // точно это же мы делали в mvc-dispatcher-servlet.xml
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() throws SQLException {
        OracleDataSource ds = new OracleDataSource();

     //   ds.setDriverClassName(env.getProperty("jdbc.oracle.driverClass"));
        //ds.setUser(env.getProperty("jdbc.oracle.username"));
        //ds.setPassword(env.getProperty("jdbc.oracle.password"));
        //ds.setURL(env.getProperty("jdbc.oracle.url"));
        ds.setDriverType("thin");
        ds.setServerName("localhost");
        ds.setDatabaseName("xe");
        ds.setPortNumber(1521);
        ds.setUser("ProjectManager");
        ds.setPassword("ProjectManager");

        return ds;
    }

}