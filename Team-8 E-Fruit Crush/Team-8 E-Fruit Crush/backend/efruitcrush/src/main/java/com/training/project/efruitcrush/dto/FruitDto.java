package com.training.project.efruitcrush.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FruitDto {

	private int id;
	private String name;
	private int price;
	private int quantityAvailable;
	private String imageUrl;

}
