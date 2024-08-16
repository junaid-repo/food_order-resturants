package com.food.resturants.entities;

import org.hibernate.validator.constraints.UniqueElements;

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
import jakarta.validation.constraints.NotEmpty;
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
public class ResturantProfile {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@NotNull(message = "resturantId cannot be blank")
	private Integer resturantId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="resourceType")
	private FoodType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="resourceCat")
	private FoodCat cat;
	
	@Column(name = "ratings")
	private Integer stars;

}
