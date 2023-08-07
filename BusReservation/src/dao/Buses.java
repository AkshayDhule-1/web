package dao;

public class Buses{
	
	private int busId;
	private String busNumber;
	private String travelAgency;
	private String busType;
	private int totalSeats;
	private float fare;
	
	
	public Buses() {
		
	}
	
	public Buses(int busId, String busNumber, String travelAgency, String busType, int totalSeats, float fare) {
		super();
		this.busId = busId;
		this.busNumber = busNumber;
		this.travelAgency = travelAgency;
		this.busType = busType;
		this.totalSeats = totalSeats;
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Buses [busId=" + busId + ", busNumber=" + busNumber + ", travelAgency=" + travelAgency + ", busType="
				+ busType + ", totalSeats=" + totalSeats + ", fare=" + fare + "]";
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
	
	

}