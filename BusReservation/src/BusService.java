UserDAO userDAO = new UserDAOImplementation();
		
				
		User user = userDAO.selectUser(9);
		
		Ticket ticket = busService.selectBuses(avlBus.get(2),3,user);
		
		
		BookedTicket bTicket = busService.bookTicket(ticket);
		
		System.out.println(bTicket);



public BookedTicket bookTicket(int tid) {
		// TODO Auto-generated method stub
		
		TicketDAO ticketDAO = new TicketDAOImplementation();
		Ticket ticket  = ticketDAO.selectTicket(tid);
		BookedTicket bookTicket = new BookedTicket();
	
		UserDAO userDAO= new UserDAOImplementation();
		User user = userDAO.selectUser(ticket.getUid());
		
		BusesDAO busDAO = new BusesDAOImplementation();
		Buses bus = busDAO.selectBus(ticket.getBusId());
				
		TravelTimeDAO ttDAO = new TravelTimeDAOImplementation();
		TravelTime tt = ttDAO.selectTravel(bus.getBusId());
		
		RouteDAO routeDAO = new RouteDAOImplementation();
		 Route route = routeDAO.selectRoute(tt.getRouteId());
		
		bookTicket.setUserId(user.getUserId());
		bookTicket.setTid(ticket.getTid());
		bookTicket.setFirstName(user.getFirstName());
		bookTicket.setLastName(user.getLastName());
		bookTicket.setEmail(user.getEmail());
		bookTicket.setPhoneNumber(user.getPhoneNumber());
		bookTicket.setDateOfBirth(user.getDateOfBirth());
		bookTicket.setGender(user.getGender());
		bookTicket.setBusNumber(bus.getBusNumber());
		bookTicket.setTravelAgency(bus.getTravelAgency());
		bookTicket.setBusType(bus.getBusType());
		bookTicket.setFare(bus.getFare());
		bookTicket.setTime(tt.getTime());
		bookTicket.setJourneyDate(ticket.getJourneyDate());
		bookTicket.setStatus("Booked");
		bookTicket.setBookedDate(ticket.getBookedDate());
		bookTicket.setNoOfSeats(ticket.getNoOfSeats());
		bookTicket.setAmountPaid(ticket.getAmountPaid());
		bookTicket.setSrc(route.getSrc());
		bookTicket.setDest(route.getDest());
		bookTicket.setJourneyTime(route.getJourneyTime());
		bookTicket.setDistance(route.getDistance());
		
		
		
		
		return bookTicket;
	}
