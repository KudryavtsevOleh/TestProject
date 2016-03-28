package com.testproject.configuration;

import com.testproject.bootstrap.Bootstrap;
import com.testproject.dao.TodoDao;
import com.testproject.dao.UserDao;
import com.testproject.service.TodoService;
import com.testproject.service.UserService;
import com.testproject.util.CustomAuthenticationFilter;
import com.testproject.util.CustomAuthenticationProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.servlet.Filter;

@SpringBootApplication
@ComponentScan(basePackages = "com.testproject.controller")
@Import({
        MvcConfiguration.class,
        RepositoryConfiguration.class,
        SecurityConfiguration.class
})
public class ApplicationStart {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStart.class, args);
    }

    @Bean
    public TodoDao todoDao() {
        return new TodoDao();
    }

    @Bean
    public TodoService todoService() {
        return new TodoService();
    }

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public Filter customAuthenticationFilter() {
        return new CustomAuthenticationFilter();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public Bootstrap bootstrap() {
        return new Bootstrap();
    }

}
