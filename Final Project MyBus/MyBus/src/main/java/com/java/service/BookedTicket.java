package com.java.service;

import java.sql.Time;
import java.util.Date;

public class BookedTicket {
	
	private int tid;
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date dateOfBirth;
	private String gender;
	
	private String busNumber;
	private String travelAgency;
	private String busType;
	private float fare;	

	private Time time;
	private Date journeyDate;
	private String status;
	private Date bookedDate; 
	private int noOfSeats;
	private float amountPaid;	
    private String src;
    private String dest;
    private Time journeyTime;
    private float distance;
    
    
    public BookedTicket() {
    	
    }
    
    
	public BookedTicket(int tid, int userId, String firstName, String lastName, String email, String phoneNumber,
			Date dateOfBirth, String gender, String busNumber, String travelAgency, String busType, float fare,
			Time time, Date journeyDate, String status, Date bookedDate, int noOfSeats, float amountPaid, String src,
			String dest, Time journeyTime, float distance) {
		super();
		this.tid = tid;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.busNumber = busNumber;
		this.travelAgency = travelAgency;
		this.busType = busType;
		this.fare = fare;
		this.time = time;
		this.journeyDate = journeyDate;
		this.status = status;
		this.bookedDate = bookedDate;
		this.noOfSeats = noOfSeats;
		this.amountPaid = amountPaid;
		this.src = src;
		this.dest = dest;
		this.journeyTime = journeyTime;
		this.distance = distance;
	}
	
	
	@Override
	public String toString() {
		return "BookedTicket [tid=" + tid + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", busNumber=" + busNumber + ", travelAgency=" + travelAgency + ", busType=" + busType
				+ ", fare=" + fare + ", time=" + time + ", journeyDate=" + journeyDate + ", status=" + status
				+ ", bookedDate=" + bookedDate + ", noOfSeats=" + noOfSeats + ", amountPaid=" + amountPaid + ", src="
				+ src + ", dest=" + dest + ", journeyTime=" + journeyTime + ", distance=" + distance + "]";
	}
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getTravelAgency() {
		return travelAgency;
	}
	public void setTravelAgency(String travelAgency) {
		this.travelAgency = travelAgency;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public float getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public Time getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(Time journeyTime) {
		this.journeyTime = journeyTime;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
    
    
    
    
}
