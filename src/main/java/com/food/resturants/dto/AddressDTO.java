package com.food.resturants.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	String area;
	String city;
	String pincode;
	String state;
}
