package com.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * Hello world!
 *
 */
public class LearnGson {
	public static void main(String[] args) {
		/**
		 * Creating gson object below. Also can be created using GsonBuilder (Using a
		 * GsonBuilder allows you to set configuration options on the GsonBuilder before
		 * creating the Gson object.) GsonBuilder builder = new GsonBuilder(); Gson gson
		 * = builder.create();
		 * 
		 */
		Gson gson = new Gson();

		// #1
		// Parsing JSON Into Java Objects
		// setting the values directly into fields and not by calling the setters
		String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
		Car car = gson.fromJson(json, Car.class);
		System.out.println(car);

		// #2
		// Generating JSON From Java Objects
		// By default the Gson instance created with new Gson() prints (generates) as
		// compact as possible JSON
		String carJsonString = gson.toJson(car);
		System.out.println(carJsonString);

		// Pretty Printing
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson2.toJson(car));

		// #3
		// Excluding Fields @Expose
		// 1. Using transient fields.transient fields then GSON will ignore it in both
		// serialization and deserialization.
		// 2. Using @Expose Annotation
		Person p1 = new Person("Tim", 25);
		System.out.println(gson.toJson(p1));
		//In order to get GSON to react to the @Expose annotations you must create a Gson instance using the GsonBuilder class. 
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson3 = builder.create();
		String p1Json = gson3.toJson(p1);
		System.out.println(p1Json);
		System.out.println(gson3.fromJson(p1Json, Person.class));
		
		//3. Exclude a field of a class from serialization or deserialization usingExclusionStrategy on a GsonBuilder, and use that GsonBuilder to build the Gson object with.
		
		// #4
		// Custom Field Names. Use @SerializedName("myCustomFieldName")
		
		// #5
		// Version Support in GSON @Since(1.2)
		
		
		// #6
		//Serializing Null Fields
		//By default the Gson object does not serialize fields with null values to JSON. If a field in a Java object is null, Gson excludes it.
		//You can force Gson to serialize null values via the GsonBuilder
		testNullGsonSerialization();
		
		// #7
		//Custom Instance Creators in GSON
		
		// #8
		//Custom Serialization and Deserialization
		
		
		

	}

	private static void testNullGsonSerialization() {
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
		Gson gson = builder.create();
		Car car = new Car();
		car.doors = 4;
		car.brand = null;
		String json = gson.toJson(car);
		System.out.println(json);
		
		System.out.println(gson.fromJson(json, Car.class));
	}

	static class Car {
		private String brand ;
		private int doors ;

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			System.out.println("In set brand");
			this.brand = brand;
		}

		public int getDoors() {
			return doors;
		}

		public void setDoors(int doors) {
			System.out.println("In set doors");
			this.doors = doors;
		}

		public String toString() {
			return "[ " + brand + " , " + doors + " ]";
		}
	}

	static class Person {
		
		@Expose
		private String name;
		@Expose(serialize = false, deserialize = false)
		private int age;

		Person(String name, int age){
			this.name = name;
			this.age = age;
		}
	/*	public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
*/
		public String toString() {
			return "[ " + name + " , " + age + " ]";
		}
	}
}
