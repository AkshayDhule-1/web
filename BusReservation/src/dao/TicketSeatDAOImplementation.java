package dao;

import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TicketSeatDAOImplementation extends BaseDAO implements TicketSeatDAO {

	@Override
	public boolean[] getBookedSeatNumbers(Time time, Date date, int busId) {
		
		BusesDAO busDAO = new BusesDAOImplementation();
		Buses bus = busDAO.selectBus(busId);
		
		boolean[] seatNumber = new boolean[bus.getTotalSeats()];; // Initialize the availableSeats variable
		int seat = 0;
	    try {
	        Statement statement = conn.createStatement();
	        System.out.println("Statement is created: " + statement);

	        // Execute the query to calculate Booked seats number
	       
	        ResultSet result = statement.executeQuery(" SELECT ts.seatNumber  FROM ticket t  ticket_seat ts ON t.tid = ts.tid WHERE t.time = \""+time+"\" AND t.JourneyDate =\""+date+"\" AND t.busId ="+busId);

	        // Process the result if any
	        while (result.next()) {
	            // Get the available seats value from the result
	        	seat = result.getInt("ts.seatNumber");
	        	seatNumber[seat] = false;
	        }

	    } catch (SQLException e) {
	        // Handle the exception
	        e.printStackTrace();
	    }

	    return seatNumber;

	}

}
