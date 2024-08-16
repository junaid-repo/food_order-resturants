package com.food.resturants.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.resturants.dto.ResturantFullDetails;
import com.food.resturants.entities.ResturantMenu;
import com.food.resturants.entities.ResturantProfile;
import com.food.resturants.entities.ResturantsDetails;
import com.food.resturants.service.RService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/resturant")
public class RController {

	@Autowired
	RService serv;

	@PostMapping("/register")
	ResponseEntity<Map<String, Object>> registerResturants(@Valid @RequestBody ResturantsDetails request) {
		Map<String, Object> response = new HashMap<>();
		response = serv.registerResturants(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/add/profile")
	ResponseEntity<String> addProfile(@Valid @RequestBody ResturantProfile request) {

		String response = serv.addResturantProfile(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/add/menuItems")
	ResponseEntity<String> addMenuItmes(@Valid @RequestBody ResturantMenu request) {

		String response = serv.addMenuItems(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/bulk/register")
	ResponseEntity<List<String>> bulkRegisterResturants(@RequestBody Map<String, String> filesLocations)
			throws IOException {

		List<String> idList = serv.saveBulkResurants(filesLocations);

		return ResponseEntity.status(HttpStatus.CREATED).body(idList);

	}

	@PostMapping("/bulk/add/menuItems")
	ResponseEntity<List<String>> addMenuItmes(@RequestBody Map<String, String> filesLocations) throws IOException {

		List<String> idList = serv.saveBulkAddMenuItmes(filesLocations);

		return ResponseEntity.status(HttpStatus.CREATED).body(idList);

	}

	@GetMapping("/get/resturantDetails")
	ResponseEntity<ResturantFullDetails> getResturantDetails(@RequestParam String resturantCode) {
		ResturantFullDetails response = new ResturantFullDetails();

		response = serv.getResturantFullDetails(resturantCode);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/resturantChecksWithPincode")
	ResponseEntity<List<ResturantFullDetails>> getResturantFilterPincode(
			@RequestParam String pincode/*
										 * ,
										 * 
										 * @RequestParam String category, @RequestParam String type
										 */) {

		List<ResturantFullDetails> resturantDetailsList = serv.getResturantDetailsList(pincode/* , category, type */);

		return ResponseEntity.status(HttpStatus.FOUND).body(resturantDetailsList);

	}

	@GetMapping("/get/resturantDetailsFilter")
	ResponseEntity<List<ResturantFullDetails>> getResturantTypeAndCat(

			@RequestParam String category, @RequestParam String type) {

		List<ResturantFullDetails> resturantDetailsList = serv.getResturantDetailsListOthers(category, type);

		return ResponseEntity.status(HttpStatus.FOUND).body(resturantDetailsList);

	}
	@GetMapping("/get/foodDetails/{id}")
	ResponseEntity<ResturantMenu> getFoodDetails(@PathVariable Integer id){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(serv.getMenuDetailsById(id));
	}

	@GetMapping("/get/foodDetailsFilter")
	ResponseEntity<List<ResturantFullDetails>> getfoodTypeAndCat(

			@RequestParam String category, @RequestParam String type) {

		List<ResturantFullDetails> resturantDetailsList = serv.getFoodDetailsListOthers(category, type);

		return ResponseEntity.status(HttpStatus.FOUND).body(resturantDetailsList);

	}

}
