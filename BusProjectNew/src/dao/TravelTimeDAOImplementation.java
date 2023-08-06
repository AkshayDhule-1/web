package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TravelTimeDAOImplementation extends BaseDAO implements TravelTimeDAO{

	
	public TravelTimeDAOImplementation() {
		super();
	}
	@Override
	public void insertTravel(TravelTime travelTime) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO TRAVELTIME VALUES (?,?,?)");
			
			pst.setTime(1, travelTime.getTime());
			pst.setInt(2,travelTime.getRouteId());
			pst.setInt(3, travelTime.getBusId());
			
			
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
	public TravelTime selectTravel(Time time) {
		// TODO Auto-generated method stub
		TravelTime travelTime=null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TRAVELTIME WHERE TIME="+time);
			
			//5. process teh result if any
			if(result.next()) {
				travelTime=new TravelTime(); //blank object
				
				travelTime.setTime(result.getTime(1));
				travelTime.setRouteId(result.getInt(2));
				travelTime.setBusId(result.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return travelTime;
	}

	@Override
	public List<TravelTime> selectTravels() {
		// TODO Auto-generated method stub
		List<TravelTime> travelList = new ArrayList<TravelTime>();

		TravelTime travelObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TRAVELTIME");
			
			//5. process teh result if any
			while(result.next()) {
				travelObj = new TravelTime(); //blank object
				
				travelObj.setTime(result.getTime(1));
				travelObj.setRouteId(result.getInt(2));
				travelObj.setBusId(result.getInt(3));
				
				travelList.add(travelObj); //fill up the list
				
				System.out.println(travelObj);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return travelList;
	}

	@Override
	public void updateTravel(TravelTime travelTime) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pst = 
					conn.prepareStatement("UPDATE TRAVELTIME set ROUTEID=?,BUSID=? WHERE TIME=?");
			
			pst.setTime(3, travelTime.getTime());
			pst.setInt(1, travelTime.getRouteId());
			pst.setInt(2, travelTime.getBusId());
			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Rows UPDATED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTravel(Time time) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM TRAVELTIME where TIME=?");
			
			pst.setTime(1, time); //WHERE deptno=?

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS 
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TravelTime> selectTravels(int rid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List<TravelTime> travelList = new ArrayList<TravelTime>();

				TravelTime travelObj =null;
				try {
					
					Statement statement = conn.createStatement();
					System.out.println("Statement is created : "+ statement);
					
					//4. execute that statement //  UR TABLENAME IS MYDEPT120
					ResultSet result = statement.executeQuery("SELECT * FROM TRAVELTIME WHERE RID="+rid);
					
					//5. process teh result if any
					while(result.next()) {
						travelObj = new TravelTime(); //blank object
						
						travelObj.setTime(result.getTime(1));
						travelObj.setRouteId(result.getInt(2));
						travelObj.setBusId(result.getInt(3));
						
						travelList.add(travelObj); //fill up the list
						
						System.out.println(travelObj);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return travelList;
	}
	@Override
	public TravelTime selectTravel(int busId) {
				
		TravelTime travelTime=null;
		try {
					
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
					
					//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM TRAVELTIME WHERE BUSID="+busId);
					
					//5. process teh result if any
			if(result.next()) {
						travelTime=new TravelTime(); //blank object
						
						travelTime.setTime(result.getTime(1));
						travelTime.setRouteId(result.getInt(2));
						travelTime.setBusId(result.getInt(3));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return travelTime;
		
	}

}