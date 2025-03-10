package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public String calculator(int num1, int num2, String operator) {
		String result = "演算子エラー";
		if ("+".equals(operator)) {
			result = String.valueOf(num1 + num2);
		} else if ("-".equals(operator)) {
			result = String.valueOf(num1 - num2);
		} else if ("*".equals(operator)) {
			result = String.valueOf(num1 * num2);
		} else if ("/".equals(operator)) {
			try {
				result = String.valueOf(num1 / num2);
			} catch (ArithmeticException e) {
				result = "ゼロ除算はできません";
			}
		}
		return result;
	}
}