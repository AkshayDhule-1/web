package dao;

import java.util.Date;

public class User {
	
		private int userId;
		private String username;
		private String password;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private String address;
		private Date dateOfBirth;
		private String gender;
		
		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
					+ firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber
					+ ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
		}
		
		public User(int userId, String username, String password, String firstName, String lastName, String email,
				String phoneNumber, String address, Date dateOfBirth, String gender) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
		}
		public User() {
			// TODO Auto-generated constructor stub
		}

		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		
		
		
}
 


