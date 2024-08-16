package com.food.resturants.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResturantMenuDTO {

	private String name;
	private String descriptions;

	private String type;

	private String category;

	private Double price;

}
