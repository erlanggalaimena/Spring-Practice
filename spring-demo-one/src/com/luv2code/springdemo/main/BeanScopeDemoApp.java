package com.luv2code.springdemo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.service.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file (Spring Container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are the same bean
		boolean result = (theCoach == alphaCoach);

		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

		context.close();
	}

}
