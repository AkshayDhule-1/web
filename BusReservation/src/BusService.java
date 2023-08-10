UserDAO userDAO = new UserDAOImplementation();
		
				
		User user = userDAO.selectUser(9);
		
		Ticket ticket = busService.selectBuses(avlBus.get(2),3,user);
		
		
		BookedTicket bTicket = busService.bookTicket(ticket);
		
		System.out.println(bTicket);
