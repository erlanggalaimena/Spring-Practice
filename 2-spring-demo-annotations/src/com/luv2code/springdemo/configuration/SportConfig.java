package com.luv2code.springdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.luv2code.springdemo.service.Coach;
import com.luv2code.springdemo.service.FortuneService;
import com.luv2code.springdemo.service.SadFortuneService;
import com.luv2code.springdemo.service.SwimCoach;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(this.sadFortuneService());
	}

}
