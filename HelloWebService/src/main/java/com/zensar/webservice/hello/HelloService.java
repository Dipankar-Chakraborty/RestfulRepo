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
		return "Welcome to Zensar Hello Service";
	}
	
	@Path("/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<h1>Welcome to Zensar</h1>"; 
	}
	@Path("/xml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXmlHello(){
		return "<?xml version='1.0'?><hello>Welcome To Zensar XML</hello>";
	}
	@GET
	@Path("/{nm}")
	@Produces("text/plain")
	public String sayHelloUser(@PathParam("nm")String name) {
		return "Dear "+name+" Welcome to Zensar Hello Service";
	}
	@GET
	@Path("res/{nm}")
	@Produces("text/plain")
	public Response sayHelloUserResponse(@PathParam("nm")String name) {
		Response response=Response.status(200).entity("Dear "+name+" Welcome to Zensar Hello Service").build();
		return response;
	}
	@GET
	@Path("res/{nm}/{dd}/{mm}/{yy}")
	@Produces("text/plain")
	public Response sayHappyBirthday(@PathParam("nm")String name, @PathParam("dd")int day, @PathParam("mm")int month, @PathParam("yy")int year) {
		LocalDate birthDate=LocalDate.of(1997, 04, 30);
		Response response=Response.status(200).entity("Dear "+name+" Happy Birthday on "+birthDate+" Welcome to Zensar Hello Service").build();
		return response;
	}
}
