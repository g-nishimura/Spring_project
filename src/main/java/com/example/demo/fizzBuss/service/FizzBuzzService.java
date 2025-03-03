package com.example.demo.fizzBuss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	public List<String> fizzBuzz(int max) {
		List<String> numbersList = new ArrayList<>();
		for (int num = 0; num <= max; num++) {
			if (num % 15 == 0) {
				numbersList.add("FizzBuzz");
			} else if (num % 5 == 0) {
				numbersList.add("Buzz");
			} else if (num % 3 == 0) {
				numbersList.add("Fizz");
			} else {
				numbersList.add(String.valueOf(num));
			}
		}
		return numbersList;

	}

}