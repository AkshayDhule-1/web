package service;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class AvailableBuses {
		
		private int busId;
		private String busNumber;
		private String travelAgency;
		private String busType;
		private int availableSeats;
		private int totalSeats;
		private float fare;
	    private String src;
	    private String dest;
	    private Date journeyDate;
	    private Time journeyTime;
	    private float distance;
	    private Time time;
	    private boolean[] availableSeatNumbers;
	    private boolean[] bookedSeatNumbers;
	    
	    
	    
		AvailableBuses(int busId, String busNumber, String travelAgency, String busType, int availableSeats,
				int totalSeats, float fare, String src, String dest, Date journeyDate, Time journeyTime, float distance,
				Time time, boolean[] availableSeatNumbers, boolean[] bookedSeatNumbers) {
			super();
			this.busId = busId;
			this.busNumber = busNumber;
			this.travelAgency = travelAgency;
			this.busType = busType;
			this.availableSeats = availableSeats;
			this.totalSeats = totalSeats;
			this.fare = fare;
			this.src = src;
			this.dest = dest;
			this.journeyDate = journeyDate;
			this.journeyTime = journeyTime;
			this.distance = distance;
			this.time = time;
			this.availableSeatNumbers = availableSeatNumbers;
			this.bookedSeatNumbers = bookedSeatNumbers;
		}
		public AvailableBuses() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			System.out.println("  - - - Available Buses ---  ");
					
			System.out.println( "Bus Id=" + busId );
			System.out.println("Bus Number =" + busNumber);
			System.out.println("T	ravel Agency= " + travelAgency);
			System.out.println("Bus Type = "+ busType);
			System.out.println("No. of Available Seats= "+availableSeats);
			System.out.println("Total Seats = "+ totalSeats);
			System.out.println("Fare = "+fare);
			System.out.println("Source = "+ src);
			System.out.println("Destination= "+dest);
			System.out.println("Journey Date= "+journeyDate);
			System.out.println("Journey Time = "+ journeyTime);
			System.out.println("Distance = "+ distance);
			System.out.println("Time = "+time);
	
			
				System.out.println("Available Seat Numbers = ");
	
				for(int i=0;i<availableSeatNumbers.length;i++) {
					if(availableSeatNumbers[i]==false) {
						System.out.println(i+1);
					}
					
				}		
					return "";
		}
		public int getBusId() {
			return busId;
		}
		public void setBusId(int busId) {
			this.busId = busId;
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
		public int getAvailableSeats() {
			return availableSeats;
		}
		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}
		public int getTotalSeats() {
			return totalSeats;
		}
		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}
		public float getFare() {
			return fare;
		}
		public void setFare(float fare) {
			this.fare = fare;
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
		public Date getJourneyDate() {
			return journeyDate;
		}
		public void setJourneyDate(Date journeyDate) {
			this.journeyDate = journeyDate;
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
		public Time getTime() {
			return time;
		}
		public void setTime(Time time) {
			this.time = time;
		}
		public boolean[] getAvailableSeatNumbers() {
			return availableSeatNumbers;
		}
		public void setAvailableSeatNumbers(boolean[] availableSeatNumbers) {
			this.availableSeatNumbers = availableSeatNumbers;
		}
		public boolean[] getBookedSeatNumbers() {
			return bookedSeatNumbers;
		}
		public void setBookedSeatNumbers(boolean[] bookedSeatNumbers) {
			this.bookedSeatNumbers = bookedSeatNumbers;
		}
	    
	    
	    
}
