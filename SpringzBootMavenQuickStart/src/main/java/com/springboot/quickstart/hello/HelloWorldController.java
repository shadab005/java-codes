package com.springboot.quickstart.hello;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String sayHello() {
		
		Collection c;
		return "Hello World!!";
	}
}
