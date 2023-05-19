package com.training.project.efruitcrush.service;

import java.util.List;

import com.training.project.efruitcrush.exception.FruitNotFoundException;
import com.training.project.efruitcrush.model.Fruit;

public interface FruitService {

	public List<Fruit> getAllFruits();

	public Fruit getFruitById(int fruitId) throws FruitNotFoundException;

	public Fruit addFruit(Fruit fruit);

	public Fruit updateFruit(int fruitId, Fruit fruit) throws FruitNotFoundException;

	public void deleteFruit(int fruitId);

}
