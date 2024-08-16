package com.food.resturants.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class ResturantsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	String resturantCode;

	@NotBlank(message = "name cannot be blank")
	String name;
	@NotBlank(message = "ownerName cannot be blank")
	String ownerName;
	@Pattern(regexp = "[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9A-Za-z]{1}[Z]{1}[0-9a-zA-Z]{1}", message = "gst number is not valid")
	String gstNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	String contactNumber;
	
	LocalDateTime createdDate;
	LocalDateTime updatedDate;
}
