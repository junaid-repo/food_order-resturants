package com.food.resturants.entities;

import com.food.resturants.entities.enums.FoodCat;
import com.food.resturants.entities.enums.FoodType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResturantMenu {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull(message = "resturantCode cannot be blank")
	private String resturantCode;
	
	@NotBlank(message = "name cannot be blank")
	private String name;
	private String descriptions;
	
	@Enumerated(EnumType.STRING)
	@Column(name="resourceType")
	private FoodType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="resourceCategory")
	private FoodCat category;
	
	@NotNull(message = "price cannot be blank")
	private Double price;

}
