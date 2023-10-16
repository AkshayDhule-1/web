package com.java.dao;

import java.sql.Time;
import java.util.Date;

public class Ticket {
		
	private int tid;
	private int uid;
	private Time time;
	private int busId;
	private Date journeyDate;
	private String status;
	private Date bookedDate; 
	private int noOfSeats;
	private float amountPaid;
	
	
	
	public Ticket(int tid, int uid, Time time, int busId, Date journeyDate, String status, Date bookedDate,
			int noOfSeats, float amountPaid) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.time = time;
		this.busId = busId;
		this.journeyDate = journeyDate;
		this.status = status;
		this.bookedDate = bookedDate;
		this.noOfSeats = noOfSeats;
		this.amountPaid = amountPaid;
	}
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", uid=" + uid + ", time=" + time + ", busId=" + busId +
				 ", journeyDate=" + journeyDate + ", status=" + status + ", bookedDate=" + bookedDate + ", noOfSeats="
				+ noOfSeats + ", amountPaid=" + amountPaid + "]";
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time string) {
		this.time = string;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
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
	
		
	
}
