package com.java.dao;


import java.sql.Time;
import java.util.List;

public interface TravelTimeDAO {
	public void insertTravel(TravelTime travelTime); //C
	public TravelTime selectTravel(Time time);//R
	public TravelTime selectTravel(int busId);
	public List<TravelTime> selectTravels(); //RA
	public List<TravelTime> selectTravels(int rid); //RA
	public void updateTravel(TravelTime travelTime); //U
	public void deleteTravel(Time time);  //D
}