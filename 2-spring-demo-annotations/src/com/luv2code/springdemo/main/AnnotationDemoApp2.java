package com.luv2code.springdemo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.TennisCoach;

public class AnnotationDemoApp2 {

	public static void main(String[] args) {
		// read spring config file (initialize spring container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());

		context.close();
	}

}
