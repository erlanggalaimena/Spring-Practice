package com.luv2code.springdemo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {
		// spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		// close the context / spring container
		context.close();
	}

}
