package com.food.resturants.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "address")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer id;

	String type;
	String area;
	String city;
	String pincode;
	String state;
	@OneToOne(mappedBy = "address")
    private ResturantsDetails resturantDetails;
	LocalDateTime createdDate;
	LocalDateTime updatedDate;

}
