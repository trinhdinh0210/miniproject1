package com.twendee.scrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.twendee.scrud.repository.UseRepository;

@EnableMongoRepositories(basePackageClasses = UseRepository.class)
@EnableJpaRepositories(excludeFilters = 
 @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = UseRepository.class))
	@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ScrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrudApplication.class, args);
    }

}
