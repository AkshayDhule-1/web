package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

	Connection conn ; //GLOBAL 
	
	public BaseDAO() {
		try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
			//	DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());  


			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			//conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA", "");
//			conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root1234");
			conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_service","root","root1234");
			

			System.out.println("Connected : "+ conn);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection()
	{
		return this.conn;
	}
	
}
