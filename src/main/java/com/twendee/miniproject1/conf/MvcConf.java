package com.twendee.miniproject1.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.twendee" })
public class MvcConf implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/META-INF/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/META-INF/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/META-INF/img/");
		registry.addResourceHandler("/vendor/**").addResourceLocations("classpath:/META-INF/vendor/");

		registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/META-INF/bootstrap/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/META-INF/plugins/");
		registry.addResourceHandler("/less/**").addResourceLocations("classpath:/META-INF/less/");

		registry.addResourceHandler("/summernote/**").addResourceLocations("classpath:/META-INF/summernote/");

		

	}

}
