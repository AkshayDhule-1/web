

CREATE TABLE BusStops (
    rid INT,
    StopId INT,
    StopName VARCHAR(255),
    SequenceNumber INT,
    distance FLOAT,
    price FLOAT,
    PRIMARY KEY (StopId, RouteId),
    FOREIGN KEY (rid) REFERENCES Routes(rid)
);



SELECT s.StopId, s.StopName, s.SequenceNumber
FROM Stops AS s
JOIN Stops AS start ON s.RouteId = start.RouteId AND start.StopName = 'Stop 2A'
JOIN Stops AS end ON s.RouteId = end.RouteId AND end.StopName = 'Stop 4A'
WHERE s.SequenceNumber BETWEEN start.SequenceNumber AND end.SequenceNumber
AND s.RouteId = start.RouteId  -- To ensure the same route
ORDER BY s.SequenceNumber;



CREATE TABLE ticket (
    tid INT PRIMARY KEY AUTO_INCREMENT,
    uid INT,
    rid INT, 
    FromStopId INT,
    ToStopId INT,
    time TIME,
    busId INT,
    JourneyDate DATE,
    status VARCHAR(10),
    BookedDate DATE,
    NoOfSeats INT,
    amountPaid FLOAT,
    FOREIGN KEY (uid) REFERENCES user(uid),
    FOREIGN KEY (busId) REFERENCES bus(busId),
    FOREIGN KEY (time, busId) REFERENCES travelTime(time, busId),
    FOREIGN KEY (FromStopId, rid) REFERENCES BusStops(StopId, rid),
    FOREIGN KEY (ToStopId, rid) REFERENCES BusStops(StopId, rid)
);


INSERT INTO BusStops (rid, stopid, stops, distance, price)
VALUES
    (113, 0, "Pune", 0, 0),
    (113, 1, "Nashik", 163, 345),
    (113, 2, "Aurangabad", 309, 651),
    (113, 3, "Jalna", 370, 780),
    (113, 4, "Mehkar", 452, 953),
    (113, 5, "Karanja", 567, 1196),
    (113, 6, "Pulgaon", 580, 1223),
    (113, 7, "Wardha", 615, 1297),
    (113, 8, "Nagpur", 765, 1615);


package service.stops;

import dao.stop.StopDAO;

import java.util.ArrayList;
import java.util.List;

import dao.stop.Stop;
import dao.stop.StopDAOImplementation;

public class RouteServiceTest {
	public static void main(String[] args) {
		
		
		
		RouteService routeService = new RouteServiceImplementation();
		routeService.insertIntoStops(113, 0, "Pune", 0, 0);
		routeService.insertIntoStops(113, 1, "Nashik", 163, 345);
		routeService.insertIntoStops(113, 2, "Aurangabad", 309, 651);
		routeService.insertIntoStops(113, 3, "Jalna", 370, 780);
		routeService.insertIntoStops(113, 4, "Mehkar", 452, 953);
		routeService.insertIntoStops(113, 5, "Karanja", 567, 1196);
		routeService.insertIntoStops(113, 6, "Pulgaon", 580, 1223);
		routeService.insertIntoStops(113, 7, "Wardha", 615, 1297);
		routeService.insertIntoStops(113, 8, "Nagpur", 765, 1615);
		
		
		
		
	}
}




---------------------------------------------------
CREATE TABLE BusStops (
    PRIMARY KEY (rid, stopid),
    FOREIGN KEY (rid) REFERENCES Route(rid),
    INDEX idx_stopId (stopid) 
);

