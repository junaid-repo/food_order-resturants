package com.food.resturants.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.resturants.entities.Address;
import com.food.resturants.entities.ResturantMenu;
import com.food.resturants.entities.ResturantsDetails;
import com.food.resturants.entities.enums.FoodCat;
import com.food.resturants.entities.enums.FoodType;

public class Utility {

	public static Map<String, String> getCurrentAddress() throws IOException {

		Map<String, String> locationDetails = new HashMap<>();
		String location;
		String ipAddress = getIp();
		String url = "http://ip-api.com/json/" + getIp();
		URL whatismylocation = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismylocation.openStream()));

		location = in.readLine(); // you get the IP as a String
		System.out.println(location);

		Map<String, String> result = new ObjectMapper().readValue(location, HashMap.class);

		return result;

	}

	public static String getIp() throws IOException {
		String ip = "";
		try {
			URL whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

			ip = in.readLine(); // you get the IP as a String
			System.out.println(ip);
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}
		return ip;
	}

	public static Map<String, Object> getListOfObjects(String rl, String al) throws IOException {
		List<ResturantsDetails> rd = draftResurantDetails(rl);
		List<Address> ad = draftResturantAddress(al);

		Map<String, Object> retMap = new HashMap<>();

		retMap.put("resturantDetails", rd);
		retMap.put("addressDetails", ad);

		return retMap;
	}
	public static Map<String, Object> getListOfObjectsForMenu(String rl) throws IOException {
		List<ResturantMenu> rd = draftResurantMenuDetails(rl);

		Map<String, Object> retMap = new HashMap<>();

		retMap.put("resturantMenuDetails", rd);

		return retMap;
	}
	
	
	public static List<ResturantMenu> draftResurantMenuDetails(String fileIn) throws IOException {

		List<ResturantMenu> menuList = new ArrayList<>();
		String line = null;

		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			count++;
			if (count > 1) {
				try {
					String[] temp = line.split(",");
					String resturantCode = temp[0];
					String name = temp[1];
					String descriptions = temp[2];
					FoodCat category = FoodCat.valueOf(temp[3]);
					String price = temp[4];
					FoodType type = FoodType.valueOf(temp[5]);

					var resturantMenuDetails = ResturantMenu.builder().resturantCode(resturantCode).name(name)
							.descriptions(descriptions).category(category).price(Double.parseDouble(price)).type(type)
							.build();
					;
					menuList.add(resturantMenuDetails);

				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
			}

		}
		bufferedReader.close();
		return menuList;

	}

	public static List<ResturantsDetails> draftResurantDetails(String fileIn) throws IOException {

		List<ResturantsDetails> studentList = new ArrayList<>();
		// String fileIn = "/home/junaid/Documents/resturantRegister.csv";
		String line = null;

		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			count++;
			if (count > 1) {
				try {
					String[] temp = line.split(",");
					String name = temp[0];
					String ownerName = temp[1];
					String gstNumber = temp[2];
					String contactNumber = temp[3];

					var resturantDetails = ResturantsDetails.builder().name(name).ownerName(ownerName)
							.gstNumber(gstNumber).contactNumber(contactNumber).build();
					;
					studentList.add(resturantDetails);

				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
			}

		}
		bufferedReader.close();
		return studentList;

	}

	private static List<Address> draftResturantAddress(String fileIn) throws IOException {

		List<Address> addressList = new ArrayList<>();
		// String fileIn = "/home/junaid/Documents/resturantAddress.csv";
		String line = null;

		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count = 0;
		while ((line = bufferedReader.readLine()) != null) {
			count++;
			if (count > 1) {
				try {
					String[] temp = line.split("##");
					String area = temp[0];

					var address = Address.builder().area(area).build();
					;
					addressList.add(address);

				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
			}

		}
		bufferedReader.close();
		return addressList;

	}
}
