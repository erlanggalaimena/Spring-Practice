package com.luv2code.springdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.springdemo.configuration.SportConfig;
import com.luv2code.springdemo.service.SwimCoach;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class (initialize spring container)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("Email: " + theCoach.getEmail());
		System.out.println("Team: " + theCoach.getTeam());

		context.close();
	}

}
