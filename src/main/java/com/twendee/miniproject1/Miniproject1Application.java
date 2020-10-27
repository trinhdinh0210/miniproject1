package com.twendee.miniproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan("com.twendee.miniproject1.repository")
@ComponentScan("com.twendee.miniproject1.entity")
@SpringBootApplication
public class Miniproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Miniproject1Application.class, args);
	}

}
