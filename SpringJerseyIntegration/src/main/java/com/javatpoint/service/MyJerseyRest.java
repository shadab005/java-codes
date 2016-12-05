package com.javatpoint.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/jersey")
public class MyJerseyRest {

	@GET
	@Path("/sayhi")
	public String hi() {
		return "Hi from jersey service";
	}
}
