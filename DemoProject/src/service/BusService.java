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
}
