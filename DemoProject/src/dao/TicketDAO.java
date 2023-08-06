package dao;

import java.sql.Date;
import java.util.List;

//II. POJI
public interface TicketDAO { //POJI as per the POJO

	public void insertTicket(Ticket ticket); //C
	public Ticket selectTicket(int tid);//R
	public List<Ticket> selectTickets(); //RA
	public List<Ticket> selectTickets(Date date); //RA
	public void updateTicket(int tid); //U
	public void deleteTicket(int tid);  //D
	
}