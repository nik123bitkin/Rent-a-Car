CREATE DATABASE IF NOT EXISTS rent;
USE rent;
CREATE TABLE IF NOT EXISTS
	users
(
    id            INT(4) PRIMARY KEY NOT NULL,
    name          VARCHAR(50) NOT NULL,
    surname		    VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS
	cars
(
    id           INT(4) PRIMARY KEY NOT NULL,
    model        VARCHAR(50) NOT NULL,
    make 		     VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS
	orders
(
    id        	 INT(4) PRIMARY KEY NOT NULL,
    userId 		   INT(4) NOT NULL,
    carId    	   INT(4) NOT NULL,
    startDate    VARCHAR(32) NOT NULL,
    endDate		   VARCHAR(32) NOT NULL,
    status       VARCHAR(32) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (carId) REFERENCES cars (id)
);