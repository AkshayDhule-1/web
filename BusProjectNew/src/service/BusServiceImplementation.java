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

	
	
	int getAvailableSeats(int busId,Time time, Date date) {
		
		Date currentDate =  new Date(System.currentTimeMillis());
		
		BusesDAO busDAO = new BusesDAOImplementation();
	 	Buses bus = busDAO.selectBus(busId);
		
		List<Ticket> lt = new ArrayList();
		TicketDAO ticketDAO = new TicketDAOImplementation();
		int count =0;	
		lt = ticketDAO.selectTickets(currentDate);
		
		for(Ticket t : lt) {
			
			System.out.println(t.getTime() +"=="+time + "&&" +t.getBusId() +"==" +busId+"&&"+t.getJourneyDate()+"=="+date+"\ns");
			if(t.getTime() ==time && t.getBusId() == busId && t.getJourneyDate()==date) {
				count = count + t.getNoOfSeats();
			}
			System.out.println(count);
		}
		
		int seatAvailable = bus.getTotalSeats() - count;
		
		
		return seatAvailable;
	}
	
	@Override
	public List<AvailableBuses> showAvailableBuses(String src, String dest, Date date) {
		// TODO Auto-generated method stub
		
		List<AvailableBuses> avlBusesList = new ArrayList();
		
		
		 RouteDAO routeDAO = new RouteDAOImplementation();
		
		 Route route = routeDAO.selectRoute(src,dest);
		 
		 TravelTimeDAO travelDAO = new TravelTimeDAOImplementation();
		 List<TravelTime> listTT = travelDAO.selectTravels(route.getRid());
		 
				 
		 
		 for (TravelTime tobj : listTT) {
			    
			 	AvailableBuses avlbus = new AvailableBuses();
			 	
			 	BusesDAO busDAO = new BusesDAOImplementation();
			 	Buses bus = busDAO.selectBus(tobj.getBusId());
			 	Time tm = tobj.getTime();
			 	
//			 	int seatAvl = getAvailableSeats(tobj.getBusId(),tm,date);
			 		
			
//			 	if(seatAvl>0) {
			 	
			 	if(bus.getAvailableSeats() >= 0) {
			 		
			 		avlbus.setBusId(bus.getBusId());
				 	avlbus.setBusNumber(bus.getBusNumber());
				 	avlbus.setTravelAgency(bus.getTravelAgency());
				 	avlbus.setBusType(bus.getBusType());
				 	avlbus.setAvailableSeats(bus.getAvailableSeats());
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
			ticket.setStatus("Conform");
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
		bookTicket.setStatus("Confirmed");
		bookTicket.setBookedDate(ticket.getBookedDate());
		bookTicket.setNoOfSeats(ticket.getNoOfSeats());
		bookTicket.setAmountPaid(ticket.getAmountPaid());
		bookTicket.setSrc(route.getSrc());
		bookTicket.setDest(route.getDest());
		bookTicket.setJourneyTime(route.getJourneyTime());
		bookTicket.setDistance(route.getDistance());
		
		
		bus.setAvailableSeats(bus.getAvailableSeats()-ticket.getNoOfSeats());
		
		return bookTicket;
	}
	
	
	
	public static void main(String[] args) {
		BusService busService = new BusServiceImplementation();
		
		List<AvailableBuses> avlBus = busService.showAvailableBuses("City A", "City B",Date.valueOf("2026-08-05"));
		
		for(AvailableBuses bus : avlBus) {
			System.out.println(bus);
		}
		
		UserDAO userDAO = new UserDAOImplementation();
		
				
		User user = userDAO.selectUser(2);
		
		Ticket ticket = busService.selectBuses(avlBus.get(0),1,user);
		
		
		BookedTicket bTicket = busService.bookTicket(ticket);
		
		System.out.println(bTicket);
		
		
		
		
	}


}
