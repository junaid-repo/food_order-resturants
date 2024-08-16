package com.food.resturants.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

	public static void main(String[] args) throws IOException {

		try {
			URL whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

			String ip = in.readLine(); // you get the IP as a String
			System.out.println(ip);
			
			String location;
			//String ipAddress=getIp();
		 	String url = "http://ip-api.com/json/"+ip;
			URL whatismylocation = new URL(url);
			BufferedReader in2 = new BufferedReader(new InputStreamReader(whatismylocation.openStream()));

			location = in2.readLine(); // you get the IP as a String
			System.out.println(location);
			ObjectMapper mapper = new ObjectMapper();  
			
			Map<String,Object> result =
			        new ObjectMapper().readValue(location, HashMap.class);
	                
			System.out.println(result);
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}
	}

}
