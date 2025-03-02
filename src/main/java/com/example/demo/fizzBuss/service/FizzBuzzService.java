package com.example.demo.fizzBuss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	public List<String> fizzBuzz(int num) {
		List<String> numbersList = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			if (i % 15 == 0) {
				numbersList.add("FizzBuzz");
			} else if (i % 5 == 0) {
				numbersList.add("Buzz");
			} else if (i % 3 == 0) {
				numbersList.add("Fizz");
			} else {
				numbersList.add(String.valueOf(i));
			}
		}
		return numbersList;

	}

}