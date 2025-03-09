package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.repository.AnimalRepository;

@Service
public class AnimalService {

	private final AnimalRepository AnimalRepository;

	public AnimalService(AnimalRepository AnimalRepository) {
		this.AnimalRepository = AnimalRepository;
	}

	public List<AnimalData> getAnimalList() throws IOException {

		AnimalData[] animalList = AnimalRepository.getAnimalList();

		return Arrays.asList(animalList);

	}

	public AnimalData getAnimal(int animalId) throws IOException {

		AnimalData animal = AnimalRepository.getAnimal(animalId);

		return animal;

	}
}