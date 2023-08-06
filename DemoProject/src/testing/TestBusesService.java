package testing;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import dao.BusesDAOImplementation;
import dao.Buses;
import dao.BusesDAO;

public class TestBusesService {


	BusesDAO busDAO = new BusesDAOImplementation();
	
	@Test
	public void selectTest() {
		
		System.out.println("Test started..");
		Assertions.assertTrue(busDAO!=null);
		System.out.println("Got the DAO : "+busDAO);

		Buses bus = busDAO.selectBus(103);
		
		System.out.println("Buses Obj : "+bus);

		System.out.println("Test over...");
	}

}
