package com.mkyong.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		String input = "";
		while (!(s = br.readLine()).equals("]")) {
			input += s;
			// System.out.println(input);

		}
		input += "]";

		// Use this to print your answer
		System.out.println(input);
		System.out.println("Hello world");

		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(input);
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject json = (JSONObject) jsonArray.get(i);
			System.out.println(json.get("id").getClass());
			
			
		}

	}

}
