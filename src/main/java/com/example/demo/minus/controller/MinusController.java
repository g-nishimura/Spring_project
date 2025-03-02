package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {
	private final MinusService minusService;

	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("minus")
	public String minus() {
		return "minus.html";
	}

	@PostMapping("minusControll")
	public String minusControll(@RequestParam("num1") String num1, @RequestParam("num2") String num2, Model model) {

		String result = "";
		try {
			result = String.valueOf(minusService.minus(Integer.parseInt(num1), Integer.parseInt(num2)));
		} catch (NumberFormatException e) {
			result = "数値を入力してください";
		}
		model.addAttribute("result", result);

		return "minus.html";
	}
}