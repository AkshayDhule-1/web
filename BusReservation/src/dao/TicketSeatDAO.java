package dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface TicketSeatDAO {
	boolean[] getBookedSeatNumbers(Time time, Date date, int busId);
	
}
