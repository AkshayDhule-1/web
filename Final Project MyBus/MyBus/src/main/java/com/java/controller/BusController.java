package com.java.controller;


import java.sql.Date;
import java.sql.Time;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.dao.Ticket;
import com.java.service.AvailableBuses;
import com.java.service.BookedTicket;
import com.java.service.BusService;
import com.java.service.BusServiceImplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Path("/busService")
public class BusController {
	
	@GET
	@Path("/greet")
	public String welcome() {
		return"<h1>Welcome to web based controller....";
	}
	BusService busService = new BusServiceImplementation();
	
	

	@GET
	@Path("/showbuses/{src}/{dest}/{dt}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AvailableBuses> showAvailableBuses(
	    @PathParam("src") String src,
	    @PathParam("dest") String dest,
	    @PathParam("dt") String dateString) {
	    
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.sql.Date sqlDate = new java.sql.Date(dateFormat.parse(dateString).getTime());
	        
	        return busService.showAvailableBuses(src, dest, sqlDate);
	    } catch (ParseException e) {
	        // Handle the case where the date string is not in the expected format
	        // You can throw an exception or return an error response as needed.
	        return Collections.emptyList();
	    }
	}




	@GET 
	@Path("/selectBus/{bid}/{seats}/{uid}/{dt}/{tm}") 
	@Produces(MediaType.APPLICATION_JSON)
	public BookedTicket selectBus(@PathParam("bid") int busId, @PathParam("seats") int seats,  @PathParam("uid")int uid,  @PathParam("dt") Date date, @PathParam("tm") Time time) {
		System.out.println("CONTROLLER : ()...."+busId);		
			
		
		Ticket ticket = busService.selectBus(busId, seats, uid, date, time);
		BookedTicket bTicket = busService.bookTicket(ticket);
			
		return bTicket;
	}
	
	//
	@GET @Path("/ticket/{tid}") @Produces(MediaType.APPLICATION_JSON)
	public BookedTicket getTicket(@PathParam("tid") int x) {
		System.out.println("CONTROLLER : getTicket()...."+x);		

		
		BookedTicket bTicket = busService.bookTicket(x);
			
		return bTicket;
	}
	

	
	@GET
	@Path("/home")
	public String homePage() {
		
		return"<h1>Bus Reservation Portal</h1>";
	}
	
}


//	@POST 
//	@Path("/selectBus")  @Produces(MediaType.APPLICATION_JSON)
//	public Ticket createTicket(AvailableBuses bus, int noOfSeats, User user) {	
//		AvailableBuses bus1= BusesDAO.selectBus(201)
//			BusService.selectBuses(bus1, 5, user);
//			
//			
//	}
//	@GET()   @Produces(MediaType.APPLICATION_JSON)
//	@Path("/showTicket")
//	public void showGeneratedTicket(Ticket ticket) {
//		Ticket ticket1=TicketDAO.selectTicket(25);
//		
//	}

	
//	@GET @Path("/showbuses/{src}/{dest}/{dt}") @Produces(MediaType.APPLICATION_JSON)
//	public List<AvailableBuses> showAvailableBuses( @PathParam("src")String src,  @PathParam("dest")String dest,  @PathParam("dt") Date date){
//		
////		String htmlResponse = "<html><body><h1>Available Buses</h1><p>Bus 1 from Source to Destination</p><p>Bus 2 from Source to Destination</p></body></html>";
////	    return Response.ok(htmlResponse).build();
//		
//		return busService.showAvailableBuses(src,dest,date);
//	}
	
//	@GET()   @Produces(MediaType.APPLICATION_JSON)
//	@Path("/ticket")
//	public BookedTicket showTicket() {
//
//
//		
//		UserDAO userDAO = new UserDAOImplementation();
//		
//		
//		User user = userDAO.selectUser(9);
//		
//		
//		BookedTicket bTicket = busService.bookTicket(252);
//		
//		return bTicket;
//		}
//		public Ticket selectBus(int busId,int seats,int uid ,Date date, Time time) 
	
	


	
