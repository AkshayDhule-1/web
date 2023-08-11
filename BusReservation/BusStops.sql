

CREATE TABLE BusStops (
    rid INT,
    stopid INT,
    stops VARCHAR(255),
    distance FLOAT,
    price FLOAT,
    PRIMARY KEY (rid, stopid),
    FOREIGN KEY (rid) REFERENCES Route(rid)
);

CREATE TABLE ticket (
    tid INT PRIMARY KEY AUTO_INCREMENT,
    uid INT,
    rid INT, -- Adding rid as a foreign key
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
    FOREIGN KEY (rid) REFERENCES Route(rid) -- Adding the foreign key reference to Route table
);


INSERT INTO BusStops (rid, stopid, stops, distance, price)
VALUES
    (113, 0, 'Pune', ,10.00),
    (113, 1, 'Nashik', , 15.00),
    (113, 2, 'Aurangabad', , 20.00),
    (113, 3, 'Jalna', ,12.50),
    (113, 4, 'Mehkar', ,18.00),
    (113, 5, 'Karanja', ,10.00),
    (113, 6, 'Pulgaon', ,15.00),
    (113, 7, 'Wardha', ,20.00),
    (113, 8, 'Nagpur', ,12.50);
