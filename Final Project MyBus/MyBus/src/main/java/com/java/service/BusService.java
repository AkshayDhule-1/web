package com.java.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.java.dao.*;

public interface BusService {
	
	List<AvailableBuses> showAvailableBuses(String src, String dest, Date date);
	public Ticket selectBus(int busId,int seats,int uid ,Date date, Time time) ;
	Ticket selectBuses(AvailableBuses bus, int seats, User user);	
	
	BookedTicket bookTicket(Ticket ticket);
	BookedTicket bookTicket(int tid);
}