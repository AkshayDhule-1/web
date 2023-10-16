package com.java.dao;

import java.util.List;

public interface RouteDAO {
		
	public void insertRoute( Route route);
	public Route selectRoute(int rid);
	public int selectRouteId(String src, String dest);
	public List<Route> selectRoutes();
	public void updateRoutes(Route route);
	public void deleteRoute(int rid);

}