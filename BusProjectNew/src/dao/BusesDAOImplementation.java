package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BusesDAOImplementation extends BaseDAO implements BusesDAO {

	public BusesDAOImplementation() {
		super();
	}
	
	
	@Override
	public void insertBus(Buses bus) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO bus VALUES (?,?,?,?,?,?,?)");
			
			pst.setInt(1, bus.getBusId());
			pst.setString(2, bus.getBusNumber());
			pst.setString(3,bus.getTravelAgency());
			pst.setString(4,bus.getBusType());
			pst.setInt(6,bus.getAvailableSeats());
			pst.setInt(5,bus.getTotalSeats());
			pst.setFloat(7,bus.getFare());

			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Rows created : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public Buses selectBus(int busId) {
		
		Buses busObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM bus WHERE busid="+busId);
			
			//5. process teh result if any
			if(result.next()) {
				busObj = new Buses(); //blank object
				
				busObj.setBusId(result.getInt(1));
				busObj.setBusNumber(result.getString(2));
				busObj.setTravelAgency(result.getString(3));
				busObj.setBusType(result.getString(4));
				busObj.setTotalSeats(result.getInt(5));
				busObj.setAvailableSeats(result.getInt(6));
				busObj.setFare(result.getFloat(7));
				
				System.out.println(busObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busObj;
	}

	@Override
	public List<Buses> selectBuses() {
		
		List<Buses> busList = new ArrayList<Buses>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM bus");
			
			//5. process teh result if any
			while(result.next()) {
				Buses busObj = new Buses(); //blank object
				
				busObj.setBusId(result.getInt(1));
				busObj.setBusNumber(result.getString(2));
				busObj.setTravelAgency(result.getString(3));
				busObj.setBusType(result.getString(4));
				busObj.setTotalSeats(result.getInt(5));
				busObj.setAvailableSeats(result.getInt(6));
				busObj.setFare(result.getFloat(7));
				busList.add(busObj); // add this object to the LIST 
				
				System.out.println(busObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busList;
	}

	@Override
	public void updateBus(Buses bus) {
		//3. make a desired statement (insert/update/delete/select)
		
				try {
					PreparedStatement pst = 
							conn.prepareStatement("UPDATE bus set busnumber=?, travelagency=? bustype=? totalseats=? availableseats=? fare=? where busid=?");
					
					
					pst.setInt(7, bus.getBusId());
					pst.setString(1, bus.getBusNumber());
					pst.setString(2,bus.getTravelAgency());
					pst.setString(3,bus.getBusType());
					pst.setInt(5,bus.getAvailableSeats());
					pst.setInt(4,bus.getTotalSeats());
					pst.setFloat(6,bus.getFare());

					
					System.out.println("PreparedStatement is created : "+ pst);
					
					//4. execute that statement //  UR TABLENAME IS MYDEPT120
					int rows = pst.executeUpdate();
					
					System.out.println("Row MODIFIED : "+rows);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void deleteBus(int busId) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM bus where busid=?");
			
			pst.setInt(1, busId); //WHERE deptno=?

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
		
	}

	
}