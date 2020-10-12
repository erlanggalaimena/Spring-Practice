package com.luv2code.springdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.springdemo.configuration.SportConfig;
import com.luv2code.springdemo.service.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class (initialize spring container)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		context.close();
	}

}
