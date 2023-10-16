
package com.java.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.java.dao.Admin;
import com.java.dao.AdminDAO;
import com.java.dao.AdminDAOImplementation;
 

public class AdminTesting {


	AdminDAO adminTest= new AdminDAOImplementation();

	@Test
	public void createAdmin() {
		
		Admin admin = new Admin();
		Assertions.assertTrue(admin!=null);
		System.out.println("admin created....");
		
		admin.setAdminPassword("ABCDEFCDFEDC");
		
		adminTest.insertAdmin(admin);
		
	}
	
	@Test
	public void deleteAdmin() {
		Admin admin = new Admin();
		Assertions.assertTrue(admin!=null);
		System.out.println("admin created....");
		
		adminTest.deleteAdmin(1);
	}
}