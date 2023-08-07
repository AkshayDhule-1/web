package dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

//II. POJI
public interface TicketDAO { //POJI as per the POJO

	public void insertTicket(Ticket ticket); //C
	public Ticket selectTicket(int tid);//R
	public List<Ticket> selectTickets(); //RA
	public List<Ticket> selectTickets(Date date); //RA
	
	public int availableSeats(Time time, Date date,int busId);
	public void updateTicket(int tid);
	public void cancelTicket(int tid); //U
	public void deleteTicket(int tid);  //D
	
}