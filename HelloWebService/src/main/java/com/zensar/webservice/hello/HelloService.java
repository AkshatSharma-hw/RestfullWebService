package com.zensar.webservice.hello;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHello() {

		return ("welcome to zensar hello service");
	}

	@Path("/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String htmlHello() {

		return "<h1> this is a good welcome page</h1>";
	}
	@Path("/xml")
	@GET
	@Produces(MediaType.TEXT_XML)
	
	public String xmlHello() {

		return "<?xml version = '1.0'><hello>hello in xml</hello>";
	}
	@GET
	@Path("/{anam}")
	@Produces("text/plain")
	public String sayHelloUser(@PathParam("anam")String name) {
		String s = "<p>dear "+ name +" welcome to hello user service</p>";
		return s;
	}
	@GET
	@Path("res/{am}")
	@Produces("text/plain")
	public Response sayHelloUserResponse(@PathParam("am")String name) {
		String s = "dear "+ name +" welcome to hello user service";
		Response res = Response.status(200).entity(s).build();
		return res;
	}
	@GET
	@Path("res/{aname}/{dd}/{mm}/{yy}")
	@Produces("text/plain")
	public Response sayHappyBithday(@PathParam("aname")String name,@PathParam("dd")int day,@PathParam("mm")int month,@PathParam("yy")int year) {
		
		
		LocalDate dob = LocalDate.of(year, month, day);
		String s = "dear "+ name +" hbd on"+ dob;
		Response res = Response.status(200).entity(s).build();
		return res;
	}
}
