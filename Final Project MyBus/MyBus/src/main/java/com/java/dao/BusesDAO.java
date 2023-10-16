package com.java.dao;

import java.util.List;

//II. POJI
public interface BusesDAO { //POJI as per the POJO

	public void insertBus(Buses bus); //C
	public Buses selectBus(int busId);//R
	public List<Buses> selectBuses(); //RA
	public void updateBus(Buses bus); //U
	public void deleteBus(int busId);  //D
}