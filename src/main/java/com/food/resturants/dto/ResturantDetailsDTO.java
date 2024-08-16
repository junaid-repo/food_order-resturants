package com.food.resturants.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResturantDetailsDTO {
	String resturantCode;
	
	String name;
	String gstNumber;
	AddressDTO address;
	String contactNumber;

}
