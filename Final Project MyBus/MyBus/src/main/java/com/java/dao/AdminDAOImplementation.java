package com.java.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImplementation extends BaseDAO implements AdminDAO {

	
	public AdminDAOImplementation() {
		super();
	}
	
	@Override
	public void insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO ADMIN VALUES (?,?)");
			
			pst.setInt(1, admin.getAdminId());
			pst.setString(2, admin.getAdminPassword());
			
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
	public Admin selectAdmin(int adminId) {
		// TODO Auto-generated method stub
		Admin admin=null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM ADMIN WHERE ADMINID="+adminId);
			
			//5. process teh result if any
			if(result.next()) {
				admin = new Admin(); //blank object
				
				admin.setAdminId(result.getInt(1));
				admin.setAdminPassword(result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public List<Admin> selectAdmin() {
		// TODO Auto-generated method stub
		List<Admin> adminList = new ArrayList<Admin>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM ADMIN");
			
			//5. process teh result if any
			while(result.next()) {
				Admin admin=new Admin();//blank object
				
				admin.setAdminId(result.getInt(1));
				admin.setAdminPassword(result.getString(2));
				adminList.add(admin); // add this object to the LIST 
				
				System.out.println(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminList;
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("UPDATE ADMIN set password=? where adminId=?");
			
			
			pst.setInt(1, admin.getAdminId());
			pst.setString(2,admin.getAdminPassword());

			
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
	public void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM ADMIN where adminId=?");
			
			pst.setInt(1, adminId); 

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}