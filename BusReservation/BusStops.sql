
CREATE TABLE admin (
    adminId INT PRIMARY KEY AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL
);

 CREATE TABLE user (
    uid INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    mobile VARCHAR(15),
    pass VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    addresss VARCHAR(255),
    dob DATE,
    gender varchar(10)
);


CREATE TABLE route (
    rid INT PRIMARY KEY,
    src VARCHAR(100) NOT NULL,
    dest VARCHAR(100) NOT NULL,
    journeyTime TIME,
    distance FLOAT
);

CREATE TABLE Stops (
    stopId INT PRIMARY KEY,
    stopName VARCHAR(255)
);

CREATE TABLE bus (
    busId INT PRIMARY KEY,
    busNumber VARCHAR(20) NOT NULL,
    travelAgency VARCHAR(100),
    busType VARCHAR(50),
    totalSeat INT NOT NULL,
    availableSeat INT,
    fare FLOAT
);


CREATE TABLE travelTime (
    time TIME,
    rid INT,
    busid INT,
    FOREIGN KEY (rid) REFERENCES route(rid),
    FOREIGN KEY (busid) REFERENCES bus(busid),
    PRIMARY KEY (time,busid)
);


CREATE TABLE BusStops (
    rid INT,
    StopId INT,
    StopName VARCHAR(255),
    Sequence INT,
    distance FLOAT,
    price FLOAT,
    PRIMARY KEY (StopId, rid),
    FOREIGN KEY (rid) REFERENCES Route(rid)
);


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


CREATE TABLE ticket_seat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tid INT,
    seatNumber INT,
    FOREIGN KEY (tid) REFERENCES ticket(tid)
);



INSERT INTO admin (password)
VALUES
    ('password1'),
    ('password2'),
    ('password3'),
    ('password4'),
    ('password5'),
    ('password6'),
    ('password7'),
    ('password8'),
    ('password9'),
    ('password10'),
    ('password11'),
    ('password12');



INSERT INTO user (username, firstName, lastName, mobile, pass, email, addresss, dob, gender)
VALUES
    ('user1', 'John', 'Doe', '1234567890', 'user1pass', 'user1@example.com', 'Address 1', '1990-01-01', 'Male'),
    ('user2', 'Jane', 'Smith', '9876543210', 'user2pass', 'user2@example.com', 'Address 2', '1985-05-15', 'Female'),
    ('user3', 'Michael', 'Johnson', '9998887776', 'user3pass', 'user3@example.com', 'Address 3', '1995-08-25', 'Male'),
    ('user4', 'Emily', 'Brown', '7776665554', 'user4pass', 'user4@example.com', 'Address 4', '1998-11-10', 'Female'),
    ('user5', 'David', 'Lee', '6665554443', 'user5pass', 'user5@example.com', 'Address 5', '1988-03-20', 'Male'),
    ('user6', 'Sophia', 'Williams', '5554443332', 'user6pass', 'user6@example.com', 'Address 6', '1992-06-05', 'Female'),
    ('user7', 'Matthew', 'Miller', '4443332221', 'user7pass', 'user7@example.com', 'Address 7', '1994-09-12', 'Male'),
    ('user8', 'Olivia', 'Wilson', '3332221110', 'user8pass', 'user8@example.com', 'Address 8', '1987-12-28', 'Female'),
    ('user9', 'Emma', 'Martinez', '2221110009', 'user9pass', 'user9@example.com', 'Address 9', '1996-02-17', 'Female'),
    ('user10', 'Noah', 'Anderson', '1110009998', 'user10pass', 'user10@example.com', 'Address 10', '1991-04-30', 'Male'),
    ('user11', 'Liam', 'Garcia', '1234567890', 'user11pass', 'user11@example.com', 'Address 11', '1997-07-23', 'Male'),
    ('user12', 'Ava', 'Rodriguez', '2345678901', 'user12pass', 'user12@example.com', 'Address 12', '1989-10-08', 'Female');








INSERT INTO bus (busId, busNumber, travelAgency, busType, totalSeat, availableSeat, fare)
VALUES
    (201, 'MH29EY7683', 'PURPLE Travels', 'AC', 40, 15, 910.00),
    (202, 'MH12UY876', 'NEETA Tours', 'Sleeper', 40, 35, 820.00),
    (203, 'MH32UHJ342', 'GOLDEN Transport', 'AC', 40, 10, 1850.00),
    (204, 'MH13KU2324', 'MAHARAJA Transport', 'Non-AC', 40, 40, 945.00),
    (205, 'MH12OK4354', 'SWAMI Transport', 'Non-AC', 40, 22, 610.00),
    (206, 'MH23JU4430', 'HIMALAYA Transport', 'Non-AC', 25, 35, 900.00),
    (207, 'MH13HJ4364', 'PAULO Transport', 'Non-AC', 40, 40, 450.00),
    (208, 'MH09LI6463', 'HUM,SAFAR Transport', 'Non-AC', 40, 40, 500.00),
    (209, 'MH08JH6325', 'SAHARA Transport', 'AC', 40, 2, 1200.00),
    (210, 'MH18SP2325', 'VRL Transport', 'AC', 40, 0, 2000.00),
    (211, 'MH09LI6465', 'HUM,SAFAR Transport', 'AC', 40, 5, 1500.00),
    (212, 'MH08JH6326', 'SAHARA Transport', 'Non-AC', 40, 18, 680.00);





INSERT INTO route (rid, src, dest, journeyTime, distance)
VALUES
    (101, 'Mumbai', 'Pune', '02:30:00', 150.5),
    (102, 'Pune', 'Nashik', '04:00:00', 200.2),
    (103, 'Nashik', 'Aurangabad', '03:30:00', 180.0),
    (104, 'Aurangabad', 'Nagpur', '06:15:00', 420.8),
    (105, 'Nagpur', 'Kolhapur', '09:30:00', 650.1),
    (106, 'Kolhapur', 'Solapur', '04:15:00', 340.6),
    (107, 'Solapur', 'Ahmednagar', '03:45:00', 270.9),
    (108, 'Ahmednagar', 'Jalgaon', '06:00:00', 400.3),
    (109, 'Jalgaon', 'Mumbai', '08:30:00', 500.0),
    (110, 'Mumbai', 'Ratnagiri', '05:30:00', 350.5),
    (111, 'Ratnagiri', 'Sangli', '06:15:00', 400.2),
    (112, 'Sangli', 'Kolhapur', '02:45:00', 150.7),
    (113, 'Pune', 'Nagpur', '14:30:00', 755);




INSERT INTO travelTime (time, rid, busid)
VALUES
    ('07:00:00', 101, 201),
    ('08:30:00', 102, 202),
    ('10:00:00', 103, 203),
    ('12:15:00', 104, 204),
    ('14:30:00', 105, 205),
    ('16:45:00', 106, 206),
    ('18:00:00', 107, 207),
    ('19:30:00', 108, 208),
    ('21:00:00', 109, 209),
    ('22:45:00', 110, 210),
    ('00:15:00', 111, 211),
    ('02:00:00', 112, 212),
    ('20:30:00', 113, 201),
    ('20:30:00', 113, 202);


INSERT INTO Stops (stopId, stopName)
VALUES
    (10, "Pune"),
    (11, "Nashik"),
    (12, "Aurangabad"),
    (13, "Jalna"),
    (14, "Mehkar"),
    (15, "Karanja"),
    (16, "Pulgaon"),
    (17, "Wardha"),
    (18, "Nagpur");


INSERT INTO BusStops (rid, stopid, stopName, sequence, distance, price)
VALUES
    (113, 10, "Pune", 0, 0, 0),
    (113, 11, "Nashik", 1, 163, 345),
    (113, 12, "Aurangabad", 2, 309, 651),
    (113, 13, "Jalna", 3, 370, 780),
    (113, 14, "Mehkar", 4, 452, 953),
    (113, 15, "Karanja", 5, 567, 1196),
    (113, 16, "Pulgaon", 6, 580, 1223),
    (113, 17, "Wardha", 7, 615, 1297),
    (113, 18, "Nagpur", 8, 765, 1615);

---------------------------------------------------------------------------------------

SELECT s.rid, s.StopId, s.StopName, s.Sequence
FROM BusStops AS s
JOIN BusStops AS start ON s.rid = start.rid AND start.StopName = 'Pune'
JOIN BusStops AS end ON s.rid = end.rid AND end.StopName = 'Nashik'
WHERE s.Sequence BETWEEN start.Sequence AND end.Sequence
AND s.rid = start.rid  
ORDER BY s.Sequence;

---------------------------------------------------------------------------------------
SELECT s.StopId, s.StopName, s.SequenceNumber
FROM Stops AS s
JOIN Stops AS start ON s.RouteId = start.RouteId AND start.StopName = 'Stop 2A'
JOIN Stops AS end ON s.RouteId = end.RouteId AND end.StopName = 'Stop 4A'
WHERE s.SequenceNumber BETWEEN start.SequenceNumber AND end.SequenceNumber
AND s.RouteId = start.RouteId  -- To ensure the same route
ORDER BY s.SequenceNumber;







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


I am calculating journey time in BusStops table by dividing the Distance by 50.
	example : Distance = 700 then 700 km /50  =   14 hr journey time

---------------------------------------------------
CREATE TABLE BusStops (
    PRIMARY KEY (rid, stopid),
    FOREIGN KEY (rid) REFERENCES Route(rid),
    INDEX idx_stopId (stopid) 
);

