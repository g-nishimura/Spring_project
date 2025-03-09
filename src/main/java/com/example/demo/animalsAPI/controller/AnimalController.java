package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {

	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/animalSearch")
	public String animalSearch(Model model) throws IOException {

		List<AnimalData> animalList = animalService.getAnimalList();

		model.addAttribute("animalList", animalList);

		return "animal-search.html";

	}

	@GetMapping("/animalDetail")
	public String getPets(Model model, @RequestParam("animalId") String animalId) throws IOException {
		try {
			AnimalData animal = animalService.getAnimal(Integer.parseInt(animalId));
			model.addAttribute("animal", animal);
			return "animal-detail.html";
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage()); // デバッグ用のログ
			return "animal-search.html";
		}
	}

}