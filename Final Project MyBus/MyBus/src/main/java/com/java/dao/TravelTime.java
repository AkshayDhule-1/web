package com.java.dao;
import java.sql.Time;

public class TravelTime {
	private Time time;
	private int routeId;
	private int busId;
	
	public TravelTime() {
		
	}
	
	public TravelTime(Time time, int routeId, int busId) {
		super();
		this.time = time;
		this.routeId = routeId;
		this.busId = busId;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return "TravelTime [time=" + time + ", routeId=" + routeId + ", busId=" + busId + "]";
	}
	
	
}