package com.food.resturants.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResturantFullDetails {
	
	ResturantDetailsDTO resturantDetails;
	List<ResturantMenuDTO> resturantMenuList;

}
