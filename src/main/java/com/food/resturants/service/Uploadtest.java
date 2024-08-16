package com.food.resturants.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.food.resturants.entities.Address;
import com.food.resturants.entities.ResturantsDetails;

public class Uploadtest {
	public static void main(String[] args) throws IOException {
	
		System.out.println(draftResurantDetails());
		System.out.println("##################################################################");
		System.out.println(draftResturantAddress());
		
		 
		
	}
	
	private static List<Address> draftResturantAddress() throws IOException {
		
		
		List<Address> addressList = new ArrayList<>();
		String fileIn = "/home/junaid/Documents/resturantAddress.csv";
		String line = null;

		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count =0;
		while ((line = bufferedReader.readLine()) != null) {
			count++;
			if(count>1) {
			try {
				String[] temp = line.split("##");
				String area = temp[0];

				var address = Address.builder().area(area).build();
				;
				addressList.add(address);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}}
			
		}
		bufferedReader.close();
		return addressList;
		
	}

	public static List<ResturantsDetails>  draftResurantDetails() throws IOException{
		
		List<ResturantsDetails> studentList = new ArrayList<>();
		String fileIn = "/home/junaid/Documents/resturantRegister.csv";
		String line = null;

		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count =0;
		while ((line = bufferedReader.readLine()) != null) {
			count++;
			if(count>1) {
			try {
				String[] temp = line.split(",");
				String name = temp[0];
				String ownerName = temp[1];
				String gstNumber = temp[2];
				String contactNumber = temp[3];

				var resturantDetails = ResturantsDetails.builder().name(name).ownerName(ownerName).gstNumber(gstNumber)
						.contactNumber(contactNumber).build();
				;
				studentList.add(resturantDetails);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}}
			
		}
		bufferedReader.close();
		return studentList;
		
	}
}
