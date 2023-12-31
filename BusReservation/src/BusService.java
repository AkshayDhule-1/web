public String toString() {
			System.out.println("  - - - Available Buses ---  ");
					
			System.out.println( "Bus Id=" + busId );
			System.out.println("Bus Number =" + busNumber);
			System.out.println("Travel Agency= " + travelAgency);
			System.out.println("Bus Type = "+ busType);
			System.out.println("No. of Available Seats= "+availableSeats);
			System.out.println("Total Seats = "+ totalSeats);
			System.out.println("Fare = "+fare);
			System.out.println("Source = "+ src);
			System.out.println("Destination= "+dest);
			System.out.println("Journey Date= "+journeyDate);
			System.out.println("Journey Time = "+ journeyTime);
			System.out.println("Distance = "+ distance);
			System.out.println("Time = "+time);
	
			
//				System.out.println("Available Seat Numbers = ");
//	
//				for(int i=0;i<availableSeatNumbers.length;i++) {
//					if(availableSeatNumbers[i]==false) {
//						System.out.println(i+1);
//					}
//					
//				}		
					return "";
		}



	@GET
	@Path("/ticket")
	public BookedTicket showTicket() {


	
	UserDAO userDAO = new UserDAOImplementation();
	
	
	User user = userDAO.selectUser(9);
	
	
	BookedTicket bTicket = busService.bookTicket(1);
	
	return bTicket;
	}
	


















package service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import dao.BusesDAO;
import dao.Buses;
import dao.Ticket;
import dao.TravelTime;
import dao.User;

public interface BusService {
	
	List<AvailableBuses> showAvailableBuses(String src, String dest, Date date);
	
	Ticket selectBuses(AvailableBuses bus, int seats, User user);	
	
	BookedTicket bookTicket(Ticket ticket);
	BookedTicket bookTicket(int tid);
}





UserDAO userDAO = new UserDAOImplementation();
		
				
		User user = userDAO.selectUser(9);
		
		Ticket ticket = busService.selectBuses(avlBus.get(2),3,user);
		
		
		BookedTicket bTicket = busService.bookTicket(ticket);
		
		System.out.println(bTicket);


package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dao.RouteDAO;
import dao.Buses;
import dao.BusesDAO;
import dao.BusesDAOImplementation;
import dao.Route;
import dao.RouteDAOImplementation;
import dao.Ticket;
import dao.TicketDAO;
import dao.TicketDAOImplementation;
import dao.TravelTime;
import dao.TravelTimeDAO;
import dao.TravelTimeDAOImplementation;
import dao.User;
import dao.UserDAO;
import dao.UserDAOImplementation;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
    

public class BusServiceImplementation implements BusService{

	
	
//	int getAvailableSeats(int busId,Time time, Date date) {
//		
//		Date currentDate =  new Date(System.currentTimeMillis());
//		
//		BusesDAO busDAO = new BusesDAOImplementation();
//	 	Buses bus = busDAO.selectBus(busId);
//		
//		List<Ticket> lt = new ArrayList();
//		TicketDAO ticketDAO = new TicketDAOImplementation();
//		int count =0;	
//		lt = ticketDAO.selectTickets(currentDate);
//		
//		for(Ticket t : lt) {
//			
//			System.out.println(t.getTime() +"=="+time + "&&" +t.getBusId() +"==" +busId+"&&"+t.getJourneyDate()+"=="+date+"\ns");
//			if(t.getTime() ==time && t.getBusId() == busId && t.getJourneyDate()==date) {
//				count = count + t.getNoOfSeats();
//			}
//			System.out.println(count);
//		}
//		
//		int seatAvailable = bus.getTotalSeats() - count;
//		
//		
//		return seatAvailable;
//	}
	
	@Override
	public List<AvailableBuses> showAvailableBuses(String src, String dest, Date date) {
		// TODO Auto-generated method stub
		
		List<AvailableBuses> avlBusesList = new ArrayList();
		
		
		 RouteDAO routeDAO = new RouteDAOImplementation();
		
		 int rid = routeDAO.selectRouteId(src, dest);
		 
		 System.out.println("SRC = "+src);
		 System.out.println("DEST = "+dest);
		 
		 TravelTimeDAO travelDAO = new TravelTimeDAOImplementation();
		 System.out.println("ROUTE ID = "+rid);
		 
		 Route route = routeDAO.selectRoute(rid);
		 
		 List<TravelTime> listTT = travelDAO.selectTravels(rid);
		 
		TicketDAO ticketDAO = new TicketDAOImplementation();
		
				
		 
		 for (TravelTime tobj : listTT) {
			    
			 	AvailableBuses avlbus = new AvailableBuses();
			 	
			 	BusesDAO busDAO = new BusesDAOImplementation();
			 	Buses bus = busDAO.selectBus(tobj.getBusId());
			 	Time tm = tobj.getTime();
			 	
			 	int availableSeats = ticketDAO.availableSeats(tm, date, bus.getBusId());
			 	
			 	if(availableSeats >= 0) {

			 		avlbus.setBusId(bus.getBusId());
				 	avlbus.setBusNumber(bus.getBusNumber());
				 	avlbus.setTravelAgency(bus.getTravelAgency());
				 	avlbus.setBusType(bus.getBusType());
				 	avlbus.setAvailableSeats(availableSeats);
				 	avlbus.setTotalSeats(bus.getTotalSeats());
				 	avlbus.setFare(bus.getFare());
				 	avlbus.setSrc(route.getSrc());
				 	avlbus.setDest(route.getDest());
				 	avlbus.setJourneyTime(route.getJourneyTime());
				 	avlbus.setDistance(route.getDistance());
				 	avlbus.setTime(tobj.getTime());
				 	avlbus.setJourneyDate(date);
				 	
				 	avlBusesList.add(avlbus);
			 	}
			 	
			}
		
		 
		 return avlBusesList;

	}

	@Override
	public Ticket selectBuses(AvailableBuses bus,int seats, User user) {
		
		TicketDAO ticketDAO = new TicketDAOImplementation();
		Ticket ticket = new Ticket();
		if(bus.getAvailableSeats()>=seats) {
				
			ticket.setUid(user.getUserId());
			ticket.setTime(bus.getTime());
			ticket.setBusId(bus.getBusId());
			ticket.setJourneyDate(bus.getJourneyDate());
			ticket.setStatus("Booked");
			ticket.setBookedDate(new Date(System.currentTimeMillis()));
			ticket.setNoOfSeats(seats);
			ticket.setAmountPaid(seats * bus.getFare());
			
			ticketDAO.insertTicket(ticket);
		}
	
//		System.out.println("\n\nTicket = "+ticket.getTid());
		
		return ticket;
	}

	
	@Override
	public BookedTicket bookTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
		
		BookedTicket bookTicket = new BookedTicket();
	
		UserDAO userDAO= new UserDAOImplementation();
		User user = userDAO.selectUser(ticket.getUid());
		
		BusesDAO busDAO = new BusesDAOImplementation();
		Buses bus = busDAO.selectBus(ticket.getBusId());
				
		TravelTimeDAO ttDAO = new TravelTimeDAOImplementation();
		TravelTime tt = ttDAO.selectTravel(bus.getBusId());
		
		RouteDAO routeDAO = new RouteDAOImplementation();
		 Route route = routeDAO.selectRoute(tt.getRouteId());
		
		bookTicket.setUserId(user.getUserId());
		bookTicket.setTid(ticket.getTid());
		bookTicket.setFirstName(user.getFirstName());
		bookTicket.setLastName(user.getLastName());
		bookTicket.setEmail(user.getEmail());
		bookTicket.setPhoneNumber(user.getPhoneNumber());
		bookTicket.setDateOfBirth(user.getDateOfBirth());
		bookTicket.setGender(user.getGender());
		bookTicket.setBusNumber(bus.getBusNumber());
		bookTicket.setTravelAgency(bus.getTravelAgency());
		bookTicket.setBusType(bus.getBusType());
		bookTicket.setFare(bus.getFare());
		bookTicket.setTime(tt.getTime());
		bookTicket.setJourneyDate(ticket.getJourneyDate());
		bookTicket.setStatus("Booked");
		bookTicket.setBookedDate(ticket.getBookedDate());
		bookTicket.setNoOfSeats(ticket.getNoOfSeats());
		bookTicket.setAmountPaid(ticket.getAmountPaid());
		bookTicket.setSrc(route.getSrc());
		bookTicket.setDest(route.getDest());
		bookTicket.setJourneyTime(route.getJourneyTime());
		bookTicket.setDistance(route.getDistance());
		
		
		
		
		return bookTicket;
	}
	
	public BookedTicket bookTicket(int tid) {
		// TODO Auto-generated method stub
		
		TicketDAO ticketDAO = new TicketDAOImplementation();
		Ticket ticket  = ticketDAO.selectTicket(tid);
		BookedTicket bookTicket = new BookedTicket();
	
		UserDAO userDAO= new UserDAOImplementation();
		User user = userDAO.selectUser(ticket.getUid());
		
		BusesDAO busDAO = new BusesDAOImplementation();
		Buses bus = busDAO.selectBus(ticket.getBusId());
				
		TravelTimeDAO ttDAO = new TravelTimeDAOImplementation();
		TravelTime tt = ttDAO.selectTravel(bus.getBusId());
		
		RouteDAO routeDAO = new RouteDAOImplementation();
		 Route route = routeDAO.selectRoute(tt.getRouteId());
		
		bookTicket.setUserId(user.getUserId());
		bookTicket.setTid(ticket.getTid());
		bookTicket.setFirstName(user.getFirstName());
		bookTicket.setLastName(user.getLastName());
		bookTicket.setEmail(user.getEmail());
		bookTicket.setPhoneNumber(user.getPhoneNumber());
		bookTicket.setDateOfBirth(user.getDateOfBirth());
		bookTicket.setGender(user.getGender());
		bookTicket.setBusNumber(bus.getBusNumber());
		bookTicket.setTravelAgency(bus.getTravelAgency());
		bookTicket.setBusType(bus.getBusType());
		bookTicket.setFare(bus.getFare());
		bookTicket.setTime(tt.getTime());
		bookTicket.setJourneyDate(ticket.getJourneyDate());
		bookTicket.setStatus("Booked");
		bookTicket.setBookedDate(ticket.getBookedDate());
		bookTicket.setNoOfSeats(ticket.getNoOfSeats());
		bookTicket.setAmountPaid(ticket.getAmountPaid());
		bookTicket.setSrc(route.getSrc());
		bookTicket.setDest(route.getDest());
		bookTicket.setJourneyTime(route.getJourneyTime());
		bookTicket.setDistance(route.getDistance());
		
		
		
		
		return bookTicket;
	}
	
	
	
	
	public static void main(String[] args) {
		BusService busService = new BusServiceImplementation();
		
		List<AvailableBuses> avlBus = busService.showAvailableBuses("Pune", "Nashik",Date.valueOf("2023-08-09"));
		
		for(AvailableBuses bus : avlBus) {
			System.out.println(bus);
		}
//		
		UserDAO userDAO = new UserDAOImplementation();
		
				
		User user = userDAO.selectUser(9);
		
		Ticket ticket = busService.selectBuses(avlBus.get(2),3,user);
		
		
		BookedTicket bTicket = busService.bookTicket(ticket);
		
		System.out.println(bTicket);
//		TicketDAO ticketDAO = new TicketDAOImplementation();
//		ticketDAO.cancelTicket(ticket.getTid());
//		
//		ticketDAO.cancelTicket(35);
//		ticketDAO.cancelTicket(36);
//		ticketDAO.cancelTicket(37);
//		ticket = ticketDAO.selectTicket(1);
//		bTicket = busService.bookTicket(ticket);
//		
//		System.out.println(bTicket);
		
//		
		
		
		
	}




}
