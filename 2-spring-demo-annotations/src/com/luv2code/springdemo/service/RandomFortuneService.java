package com.luv2code.springdemo.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = { "Beware of the wolf in sheep`s clothing", "Diligence is the mother of good luck",
			"The journey is the reward" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int index = this.myRandom.nextInt(this.data.length);

		String theFortune = this.data[index];

		return theFortune;
	}

}
