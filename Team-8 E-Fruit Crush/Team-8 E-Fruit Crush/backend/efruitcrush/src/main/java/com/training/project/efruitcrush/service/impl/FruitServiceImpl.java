package com.training.project.efruitcrush.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.efruitcrush.exception.FruitNotFoundException;
import com.training.project.efruitcrush.model.Fruit;
import com.training.project.efruitcrush.repository.FruitRepository;
import com.training.project.efruitcrush.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {

	@Autowired
	public FruitRepository fruitRepository;

	@Override
	public List<Fruit> getAllFruits() {
		return fruitRepository.findAll();
	}

	@Override
	public Fruit getFruitById(int fruitId) throws FruitNotFoundException {
		return fruitRepository.findById(fruitId).orElseThrow(() -> new FruitNotFoundException("Fruit not found"));
	}

	@Override
	public Fruit addFruit(Fruit fruit) {
		return fruitRepository.save(fruit);
	}

	@Override
	public Fruit updateFruit(int fruitId, Fruit fruit) throws FruitNotFoundException {
		Fruit existingFruit = fruitRepository.findById(fruitId)
				.orElseThrow(() -> new FruitNotFoundException("Fruit not found"));
		existingFruit.setName(fruit.getName());
		existingFruit.setPrice(fruit.getPrice());
		existingFruit.setQuantityAvailable(fruit.getQuantityAvailable());
		existingFruit.setImageUrl(fruit.getImageUrl());
		return fruitRepository.save(existingFruit);
	}

	@Override
	public void deleteFruit(int fruitId) {
		fruitRepository.deleteById(fruitId);
	}

}
