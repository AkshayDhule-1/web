package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImplementation extends BaseDAO implements UserDAO {
	
	public UserDAOImplementation() {
		super();
	}

	@Override
	public void insertUser(User user) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO USER VALUES (?,?,?,?,?,?,?,?,?,?)");
			
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3,user.getPassword());
			pst.setString(4, user.getFirstName());
			pst.setString(5, user.getLastName());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getPhoneNumber());
			pst.setString(8, user.getAddress());
			pst.setDate(9, (Date) user.getDateOfBirth());
			pst.setString(10, user.getGender());
			
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
	public User selectUser(int userID) {
		User userObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM USER WHERE USERID="+userID);
			
				while(result.next()) {
					userObj = new User(); 
				
					userObj.setUserId(result.getInt(1));
					userObj.setUsername(result.getString(2));
					userObj.setPassword(result.getString(3));
					userObj.setFirstName(result.getString(4));
					userObj.setLastName(result.getString(5));
					userObj.setEmail(result.getString(6));
					userObj.setPhoneNumber(result.getString(7));
					userObj.setAddress(result.getString(8));
					userObj.setDateOfBirth(result.getDate(9));
					userObj.setGender(result.getString(10));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userObj;
		}
	

	@Override
	public List<User> selectUsers() {
		
		List<User>userList=new ArrayList();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM USER");
			
			//5. process teh result if any
			while(result.next()) {
				
				User userObj = new User(); 
				userObj.setUserId(result.getInt(1));
				userObj.setUsername(result.getString(2));
				userObj.setPassword(result.getString(3));
				userObj.setFirstName(result.getString(4));
				userObj.setLastName(result.getString(5));
				userObj.setEmail(result.getString(6));
				userObj.setPhoneNumber(result.getString(7));
				userObj.setAddress(result.getString(8));
				userObj.setDateOfBirth(result.getDate(9));
				userObj.setGender(result.getString(10));
				
				userList.add(userObj); // add this object to the LIST 
				
				System.out.println(userObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	

	@Override
	public void updateUser(User user) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("UPDATE USER set userName=? where userId=?");
			
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3,user.getPassword());
			pst.setString(4, user.getFirstName());
			pst.setString(5, user.getLastName());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getPhoneNumber());
			pst.setString(8, user.getAddress());
			pst.setDate(9, (Date) user.getDateOfBirth());
			pst.setString(10, user.getGender());
			
			
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
	public void deleteUser(int userID) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM USER where userId=?");
			
			pst.setInt(1, userID); //WHERE deptno=?

			
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
		
		UserDAO userDAO = new UserDAOImplementation();
		
		User user = new User();
		user.setUserId(5);
		user.setUsername("Ratan69");
		user.setPassword("Passs1234");
		user.setFirstName("Ratan");
		user.setLastName("Kudali");
		user.setEmail("ratantata57@gmail.com");
		user.setDateOfBirth(Date.valueOf("2023-05-03"));
		user.setPhoneNumber("7784643214");
		user.setGender("Male");
		user.setAddress("Hinjewadi Phase-1, Pune");
		
		userDAO.insertUser(user);
		
		userDAO.selectUsers();
		
		
	}

}
	
	