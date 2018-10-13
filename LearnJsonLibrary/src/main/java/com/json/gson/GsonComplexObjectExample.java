package com.json.gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonComplexObjectExample {

	public static void main(String[] args) throws Exception {
		//testComplexObjectConstruction();
		
		testListObjectConstruction();


	}
	
	private static void testComplexObjectConstruction() throws IOException {

		Gson g = new Gson();
		String fileName = "src/main/resources/json_data.json";
		String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
		Car c = g.fromJson(jsonString, Car.class);
		
		System.out.println(c);
		
		System.out.println(g.toJson(c));
		
	}

	static class Car{
		String name;
		Engine engine;
		
		public String toString() {
			return "[ " + name + " , " + stringify(engine) + "]";
		}

		private String stringify(Engine engine) {
			if(engine!=null)return engine.toString();
			return null;
		}
	}
	
	static class Engine{
		String name;
		int speed;
		Company company;
		
		public String toString() {
			return "[ " + name + " , " + speed + " , " + stringify(company) ;
		}

		private String stringify(Company company) {
			if(company!=null)return company.toString();
			return null;
		}
	}
	
	static class Company{
		String name;
		List<String> locations;
		public String toString() {
			return "[ " + name + " , " + locations +  " ]";
		}
	}
	

	
	private static void testListObjectConstruction() throws IOException {
	//	List<Person> l = Arrays.asList(new Person("Tim", 5), new Person("Zim", 1));
		Gson gson = new Gson();
		String fileName = "src/main/resources/person_list.json";
		String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
		//System.out.println(jsonString);
		List<Person> persons = gson.fromJson(jsonString, new TypeToken<List<Person>>(){}.getType());
		System.out.println(persons);
	}
	
	static class Person {
		String name;
		int age;
		Person(String n, int a){
			name = n;
			age = a;
		}
		
		public String toString() {
			return "{ " + name + " , " + age + " }";
		}
	}


}
