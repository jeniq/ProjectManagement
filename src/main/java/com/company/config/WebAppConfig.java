package com.company.config;

import com.company.filters.LoginPageInterceptor;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
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
@EnableTransactionManagement
@PropertySource("classpath:connection.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter implements TransactionManagementConfigurer{

    @Autowired
    private Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginPageInterceptor()).addPathPatterns("/");
    }

    // Initialize project View
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
        PGPoolingDataSource ds = new PGPoolingDataSource();

        // remote database
        //ds.setUrl(env.getProperty("jdbc.postgresql.url"));
        //ds.setUser(env.getProperty("jdbc.postgresql.username"));
        //ds.setPassword(env.getProperty("jdbc.postgresql.password"));

        // local database
        ds.setUrl(env.getProperty("jdbc.postgresql_local.url"));
        ds.setUser(env.getProperty("jdbc.postgresql_local.username"));
        ds.setPassword(env.getProperty("jdbc.postgresql_local.password"));

        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        try {
            return new DataSourceTransactionManager(getDataSource());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

}