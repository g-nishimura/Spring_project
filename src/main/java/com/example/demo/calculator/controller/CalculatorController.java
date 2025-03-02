package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String calculator() {
		return "calculator.html";
	}

	@PostMapping("calculatorControll")
	public String calculatorControll(@RequestParam("num1") String num1, @RequestParam("num2") String num2,
			@RequestParam("operator") String operator, Model model) {
		String result = "";
		try {
			result = calculatorService.calculator(Integer.parseInt(num1), Integer.parseInt(num2), operator);
		} catch (NumberFormatException e) {
			result = "数値を入力してください";
		}
		model.addAttribute("result", result);
		return "calculator.html";
	}
}