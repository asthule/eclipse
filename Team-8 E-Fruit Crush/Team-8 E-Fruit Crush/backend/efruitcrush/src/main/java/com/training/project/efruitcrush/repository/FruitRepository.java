package com.training.project.efruitcrush.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.efruitcrush.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

}
