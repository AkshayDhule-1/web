
package testing;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import dao.BusesDAOImplementation;
import dao.Buses;
import dao.BusesDAO;
import dao.TicketDAO;
import dao.TicketDAOImplementation;
import dao.Ticket;

public class TicketTest {


	TicketDAO ticketDAO = new TicketDAOImplementation();
//	
//	@Test
//	public void selectTest() {
//		
//		System.out.println("Test started..");
//		
//		Assertions.assertTrue(ticketDAO!=null);
//		
//		System.out.println("Got the DAO : "+ticketDAO);
//
//		Ticket ticket = ticketDAO.selectTicket(103);
//		
//		Assertions.assertTrue(ticket!=null);
//		System.out.println("Ticket Obj : "+ticket);
//
//		System.out.println("Test over...");
//		
//	}
//	
//	
//	public void insertTest() {
//		TicketDAO ticketDAO = new TicketDAOImplementation();
//		Ticket ticket = new Ticket();
//		
//		System.out.println("Test started..");
//		Assertions.assertTrue(ticketDAO!=null);
//		ticketDAO.selectTickets();
//		
////		 3 |    3 | 10:45:00 |   103 | 2023-08-05  | conform | 2023-08-12 |         3 |        600 
//		
//		
//		ticket.setTid(3);
//		ticket.setUid(3);
//		ticket.setTime(Time.valueOf("10:45:00"));
//		ticket.setBusId(103);
//		ticket.setJourneyDate(Date.valueOf("2023-08-05"));
//		ticket.setBookedDate(Date.valueOf("2023-08-12"));
////		ticket.setJourneyDate(java.sql.Date.valueOf("2023-08-09")); // Use java.sql.Date
////		ticket.setBookedDate(java.sql.Date.valueOf("2023-08-06")); // Use java.sq
//		ticket.setStatus("Conform");
//		ticket.setNoOfSeats(3);
//		ticket.setAmountPaid(600.0f);
//		
//		System.out.println("Ticket Obj : "+ticket);
//		
//		ticketDAO.insertTicket(ticket);
//		
//		Ticket t = ticketDAO.selectTicket(ticket.getTid());
//		Assertions.assertTrue(t!=null);
//	
//		System.out.println("Ticket Obj : "+t);
//		
//		System.out.println("Test over...");
//	}
//	
//	public void updateTest() {
//		
//		TicketDAO ticketDAO = new TicketDAOImplementation();
//		Ticket ticket = new Ticket();
//		
//		System.out.println("Test started..");
//		Assertions.assertTrue(ticketDAO!=null);
//		ticketDAO.selectTickets();
//		
////		 3 |    3 | 10:45:00 |   103 | 2023-08-05  | conform | 2023-08-12 |         3 |        600 
//		
//		ticket.setTid(3);
//		ticket.setUid(3);
//		ticket.setTime(Time.valueOf("10:45:00"));
//		ticket.setBusId(103);
//		ticket.setJourneyDate(Date.valueOf("2023-08-05"));
//		ticket.setBookedDate(Date.valueOf("2023-08-12"));
////		ticket.setJourneyDate(java.sql.Date.valueOf("2023-08-09")); // Use java.sql.Date
////		ticket.setBookedDate(java.sql.Date.valueOf("2023-08-06")); // Use java.sq
//		ticket.setStatus("Conform");
//		ticket.setNoOfSeats(3);
//		ticket.setAmountPaid(600.0f);
//		
//		System.out.println("Ticket Obj : "+ticket);
//		
//		ticketDAO.updateTicket(ticket.getTid());
//		
//		Ticket t = ticketDAO.selectTicket(ticket.getTid());
//		System.out.println("Ticket Obj t : "+t);
//		
//		System.out.println("Test over...");
//	}

}




