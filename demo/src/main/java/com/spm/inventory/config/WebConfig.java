package com.spm.inventory.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;


/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private MessageSource messageSource;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory("uploads", registry);
	}

	private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get(dirName);
		String uploadPath = uploadDir.toFile().getAbsolutePath();

		if (dirName.startsWith("../"))
			dirName = dirName.replace("../", "");

		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("memberArea/login");
		registry.addViewController("/contact").setViewName("contact");
		registry.addViewController("/403").setViewName("403");
	}

	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		return factory;
	}

//    @Bean
//    public SpringSecurityDialect securityDialect() {
//         return new SpringSecurityDialect();
//    }

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}