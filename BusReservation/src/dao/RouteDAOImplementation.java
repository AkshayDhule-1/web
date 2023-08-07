package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImplementation extends BaseDAO implements RouteDAO{
	
	
	public RouteDAOImplementation ()
	{
		super();
	}
		
	

	@Override
	public void insertRoute(Route route) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO ROUTE (rid, src,dest,journeyTime,distance) VALUES  (?,?,?,?,?)");
			
			pst.setInt(1, route.getRid());
			pst.setString(2, route.getSrc());
			pst.setString(3,route.getDest());
			pst.setTime(4, route.getJourneyTime());
			pst.setFloat(5, route.getDistance());
			
			
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
	public Route selectRoute(int rid) {
		Route routeObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM ROUTE WHERE RID="+rid);
			
			if(result.next()) {
				 routeObj = new Route();
				
//			
				routeObj.setRid(result.getInt(1));
				routeObj.setSrc(result.getString(2));
				routeObj.setDest(result.getString(3));
				routeObj.setJourneyTime(result.getTime(4));
				routeObj.setDistance(result.getFloat(5));
				
	}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return routeObj;
		}

	@Override
	public List<Route> selectRoutes() {
		List<Route>routeList=new ArrayList();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM ROUTE");
			
			
			while(result.next()) 
			{
				Route routeObj= new Route();
			
				routeObj.setRid(result.getInt(1));
				routeObj.setSrc(result.getString(2));
				routeObj.setDest(result.getString(3));
				routeObj.setJourneyTime(result.getTime(4));
				routeObj.setDistance(result.getFloat(5));
				
				System.out.println(routeObj);
			}
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return routeList;
	}

	@Override
	public void updateRoutes(Route route) {
		
			try {
				PreparedStatement pst = 
						conn.prepareStatement("UPDATE ROUTE set src=?,dest=? JourneyTime=?,Distance=? where rid =?");
				
			
				pst.setInt(5, route.getRid());
				pst.setString(1, route.getSrc());
				pst.setString(2,route.getDest());
				pst.setTime(3, route.getJourneyTime());
				pst.setFloat(4, route.getDistance());
				

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
	public void deleteRoute(int rid) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM ROUTE where rid=?");
			
			pst.setInt(1, rid); 

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public int selectRouteId(String src, String dest) {
		Route routeObj = null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
//			ResultSet result = statement.executeQuery("SELECT * FROM ROUTE WHERE SRC=\""+src+"\" AND DEST=\""+dest+"\"");
			ResultSet result = statement.executeQuery("SELECT * FROM route WHERE SRC='" + src + "' AND DEST='" + dest + "'");

			while(result.next()) {
				 routeObj = new Route();
				
//			
				routeObj.setRid(result.getInt(1));
				routeObj.setSrc(result.getString(2));
				routeObj.setDest(result.getString(3));
				routeObj.setJourneyTime(result.getTime(4));
				routeObj.setDistance(result.getFloat(5));
				
	}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return routeObj.getRid();
	}

}


	
	
		
	

