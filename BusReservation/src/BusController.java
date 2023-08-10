package com.java.controller;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.pojo.Currency;
import com.java.service.CurrencyService;
import com.java.service.CurrencyServiceImplementation;
//								web.xml
//				         ProjectFolder   |   @Path value
//							|			 |     |
@Path("/busService") // http://localhost:8080/MyRestAPI2/rest/currency
public class BusController {
	BusService busService = new busServiceImplementation();

	@GET				//action mappings
	@Path("/greet") //http://localhost:8080/MyRestAPI2/rest/currency/greet
	public String welcome() {
		return "<h1> Welcome to Web Based Controller </h1>";
	}
	@GET
	@Path("/search/{src}/{trg}/{dt}")
	public List<AvailableBuses> searhBuses(@PathParam("src") String source, @PathParam("trg") String target, @PathParam("dt")  Date date) {


		List<AvailableBuses> avlBuses = new ArrayList();
		try {
			avlBuses = busService.showAvailableBuses(source, target, amountToConvert);
		} catch (Exception e) {e.printStackTrace();}
		
		return avlBuses;
	}

