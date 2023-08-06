package dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImplementation extends BaseDAO implements TicketDAO {

//	Connection conn ; //GLOBAL

	public TicketDAOImplementation() {
		super();
	}


	public void insertTicket(Ticket ticket) {
		//3. make a desired statement (insert/update/delete/select)

		try {
			PreparedStatement pst =
			    conn.prepareStatement("INSERT INTO TICKET VALUES (?,?,?,?,?,?,?,?,?)");

			
			pst.setInt(1, ticket.getTid());
			pst.setInt(2, ticket.getUid());
			pst.setTime(3, ticket.getTime());
			pst.setInt(4, ticket.getBusId());
			java.sql.Date doj = new java.sql.Date(ticket.getJourneyDate().getTime());
			pst.setDate(5, doj);
//			pst.setDate(5, (Date) ticket.getJourneyDate());
			pst.setString(6, ticket.getStatus());
			
			java.sql.Date dob = new java.sql.Date(ticket.getBookedDate().getTime());
			pst.setDate(7, dob);
//			pst.setDate(7, (Date)ticket.getBookedDate());
			pst.setInt(8, ticket.getNoOfSeats());
			pst.setFloat(9, ticket.getAmountPaid());

			System.out.println("PreparedStatement is created : " + pst);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();

			System.out.println("Rows created : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Ticket selectTicket(int tid) {

		Ticket ticket = null;
		try {

			Statement statement = conn.createStatement();
			System.out.println("Statement is created : " + statement);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TICKET WHERE TID=" + tid);

			//5. process the result if any
			if (result.next()) {
				
				
				ticket = new Ticket(); //blank object

				ticket.setTid(result.getInt(1));
				ticket.setUid(result.getInt(2));
				ticket.setTime(result.getTime(3));
				ticket.setBusId(result.getInt(4)); 
				ticket.setJourneyDate((Date) result.getDate(5));
				ticket.setStatus(result.getString(6));
				ticket.setBookedDate((Date)result.getDate(7));
				ticket.setNoOfSeats(result.getInt(8));
				ticket.setAmountPaid(result.getFloat(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public List<Ticket> selectTickets() {

		List<Ticket> ticketList = new ArrayList<Ticket>();
		try {


			Statement statement = conn.createStatement();
			System.out.println("Statement is created : " + statement);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TICKET");

			//5. process the result if any
			while (result.next()) {
				Ticket ticket = new Ticket(); //blank object


				ticket.setTid(result.getInt(1));
				ticket.setUid(result.getInt(2));
				ticket.setTime(result.getTime(3));
				ticket.setBusId(result.getInt(4)); 
				ticket.setJourneyDate(result.getDate(5));
				ticket.setStatus(result.getString(6));
				ticket.setBookedDate(result.getDate(7));
				ticket.setNoOfSeats(result.getInt(8));
				ticket.setAmountPaid(result.getFloat(9));
				
				ticketList.add(ticket); // add this object to the LIST
				System.out.println(ticket);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		//3. make a desired statement (insert/update/delete/select)

		try {
			PreparedStatement pst =
			    conn.prepareStatement("UPDATE TICKET set tid=?, uid=?, time=?, busId=?, JourneyDate=?, status=?, BookedDate=?, NoOfSeats=?, amountPaid=? where tid=?");


			pst.setInt(1, ticket.getTid());
			pst.setInt(2, ticket.getUid());
			pst.setTime(3, ticket.getTime());
			pst.setInt(4, ticket.getBusId());
			pst.setDate(5, (Date) ticket.getJourneyDate());
			pst.setString(6, ticket.getStatus());
			pst.setDate(7, (Date)ticket.getBookedDate());
			pst.setInt(8, ticket.getNoOfSeats());
			pst.setFloat(9, ticket.getAmountPaid());



			System.out.println("PreparedStatement is created : " + pst);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();

			System.out.println("Row MODIFIED : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTicket(int tid) {
		//3. make a desired statement (insert/update/delete/select)

		try {
			PreparedStatement pst =
			    conn.prepareStatement("DELETE FROM TICKET where tid=?");

			pst.setInt(1, tid); //WHERE t id =? 

			System.out.println("PreparedStatement is created : " + pst);

			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();

			System.out.println("Row DELETED : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}