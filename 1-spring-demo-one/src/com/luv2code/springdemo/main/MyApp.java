package com.luv2code.springdemo.main;

import com.luv2code.springdemo.service.BaseballCoach;
import com.luv2code.springdemo.service.Coach;
import com.luv2code.springdemo.service.TrackCoach;

public class MyApp {

	public static void main(String[] args) {
		Coach theCoach = new TrackCoach();

		System.out.println(theCoach.getDailyWorkout());
	}

}
