package com.bootcamp.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@EnableSwagger
@Configuration
public class SwaggerSpringConfig {
	 @Autowired
	 private SpringSwaggerConfig swaggerSpringConfig;
	 
	 @Bean 
	 public SwaggerSpringMvcPlugin customImplementation(){
		 return new SwaggerSpringMvcPlugin(this.swaggerSpringConfig)
	            .apiInfo(apiInfo())
	            .includePatterns(".*users/*.*");
		 }

	 private ApiInfo apiInfo() {
		 ApiInfo apiInfo = new ApiInfo(
	              "Shopping cart API",
	              "A shopping cart APi for users can buy products",
	              "My Apps API terms of service",
	              "My Apps API Contact Email",
	              "My Apps API Licence Type",
	              "My Apps API License URL"
	     );
	    return apiInfo;
	 }

}
