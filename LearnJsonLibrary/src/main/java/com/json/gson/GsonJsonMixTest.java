package com.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class GsonJsonMixTest {

	public static void main(String[] args) {
		String json = "{\"name\":\"Tim\", \"age\": 25, \"lastName\" : \"Poston\"}";
		GsonBuilder builder = new GsonBuilder();
		//builder.excludeFieldsWithoutExposeAnnotation();
		Gson g = builder.create();
		Person p = g.fromJson(json, Person.class);
		System.out.println(p);

	}

	//@JsonIgnoreProperties(ignoreUnknown = false)
	static class Person {
		@Expose
		String name;
		@Expose
		int age;
		
		public String toString() {
			return "[ " + name + " , " + age + " ]";
		}

	}
	
}
