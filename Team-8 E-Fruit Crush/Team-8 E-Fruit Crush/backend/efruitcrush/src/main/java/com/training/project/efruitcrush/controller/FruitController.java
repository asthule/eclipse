package com.training.project.efruitcrush.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.efruitcrush.dto.FruitDto;
import com.training.project.efruitcrush.exception.FruitNotFoundException;
import com.training.project.efruitcrush.model.Fruit;
import com.training.project.efruitcrush.response.ApiResponse;
import com.training.project.efruitcrush.service.FruitService;

@RestController
@RequestMapping(path = { "/fruits", "/admin/fruits" })
public class FruitController {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public FruitService fruitService;

	@GetMapping
	public List<FruitDto> getAllFruits() {
		return fruitService.getAllFruits().stream().map(fruit -> modelMapper.map(fruit, FruitDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping("/addFruit")
	public ResponseEntity<FruitDto> addFruit(@RequestBody FruitDto fruitDto) {
		Fruit fruitRequest = modelMapper.map(fruitDto, Fruit.class);
		Fruit fruit = fruitService.addFruit(fruitRequest);
		FruitDto fruitResponse = modelMapper.map(fruit, FruitDto.class);
		return new ResponseEntity<>(fruitResponse, CREATED);

	}

	@PutMapping("/editFruit/{id}")
	public ResponseEntity<FruitDto> updateFruit(@PathVariable(name = "id") String id, @RequestBody FruitDto fruitDto)
			throws FruitNotFoundException {
		Fruit fruitRequest = modelMapper.map(fruitDto, Fruit.class);
		Fruit fruit = fruitService.updateFruit(Integer.parseInt(id), fruitRequest);
		FruitDto fruitResponse = modelMapper.map(fruit, FruitDto.class);
		return ResponseEntity.ok().body(fruitResponse);
	}

	@DeleteMapping("/deleteFruit/{id}")
	public ResponseEntity<ApiResponse> deleteFruit(@PathVariable int id) {
		fruitService.deleteFruit(id);
		ApiResponse apiResponse = new ApiResponse(OK, "Fruit deleted successfully");
		return new ResponseEntity<>(apiResponse, OK);
	}

}
