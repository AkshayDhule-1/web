

CREATE TABLE BusStops (
    rid INT,
    stopid INT,
    stops VARCHAR(255),
    distance FLOAT,
    price FLOAT,
    PRIMARY KEY (rid, stopid),
    FOREIGN KEY (rid) REFERENCES Route(rid)
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
