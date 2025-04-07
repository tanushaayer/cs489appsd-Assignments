-- Address Table creation
CREATE TABLE `address` (
  `addressId` int NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ;

-- Dentist Table creation
CREATE TABLE `dentist` (
  `dentistId` int NOT NULL,
  `firstName` varchar(32) DEFAULT NULL,
  `lastName` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `specialization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dentistId`)
) ;

-- Patient Table creation
CREATE TABLE `patient` (
  `patientId` int NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `addressId` int DEFAULT NULL,
  PRIMARY KEY (`patientId`),
  KEY `addressId_idx` (`addressId`),
  CONSTRAINT `addressId` FOREIGN KEY (`addressId`) REFERENCES `address` (`addressId`)
) ;

-- Surgery Table creation
CREATE TABLE `surgery` (
  `surgeryId` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fk_addressId` int DEFAULT NULL,
  PRIMARY KEY (`surgeryId`),
  KEY `addressId_idx` (`fk_addressId`),
  CONSTRAINT `fk_addressId` FOREIGN KEY (`fk_addressId`) REFERENCES `address` (`addressId`)
);

-- Appointment Table creation
CREATE TABLE `appointment` (
  `appointmentId` int NOT NULL,
  `fk_dentistId` int DEFAULT NULL,
  `fk_patientId` int DEFAULT NULL,
  `fk_surgeryId` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`appointmentId`),
  KEY `fk_dentistId_idx` (`fk_dentistId`),
  KEY `fk_patientId_idx` (`fk_patientId`),
  KEY `fk_surgeryId_idx` (`fk_surgeryId`),
  CONSTRAINT `fk_dentistId` FOREIGN KEY (`fk_dentistId`) REFERENCES `dentist` (`dentistId`),
  CONSTRAINT `fk_patientId` FOREIGN KEY (`fk_patientId`) REFERENCES `patient` (`patientId`),
  CONSTRAINT `fk_surgeryId` FOREIGN KEY (`fk_surgeryId`) REFERENCES `surgery` (`surgeryId`)
) ;

-- Bill Table Creation
CREATE TABLE `bill` (
  `billId` int NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `paymentMethod` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `dateIssued` date DEFAULT NULL,
  `dateDue` date DEFAULT NULL,
  `fk_appointmentId` int DEFAULT NULL,
  PRIMARY KEY (`billId`),
  KEY `fk_appointmentId_idx` (`fk_appointmentId`),
  CONSTRAINT `fk_appointmentId` FOREIGN KEY (`fk_appointmentId`) REFERENCES `appointment` (`appointmentId`)
) ;

-- Inserting data
INSERT INTO Dentist (dentistId, firstName, lastName, phone, email, specialization) VALUES
(1, 'Tony', 'Smith', '1234567890', 'tony.smith@clinic.com', 'Orthodontist'),
(2, 'Helen', 'Pearson', '1234567891', 'helen.pearson@clinic.com', 'Prosthodontist'),
(3, 'Robin', 'Plevin', '1234567892', 'robin.plevin@clinic.com', 'Pediatric Dentist');

INSERT INTO Address (addressId, street, city, state, zip) VALUES
(1, '12 Elm St', 'Boston', 'MA', '02101'),
(2, '45 Oak St', 'Boston', 'MA', '02102'),
(3, '78 Maple Ave', 'Cambridge', 'MA', '02139'),
(4, '90 Pine Rd', 'Somerville', 'MA', '02144'),
(5, '22 Clinic St', 'Cambridge', 'MA', '02140'),
(6, '34 Dental Ave', 'Boston', 'MA', '02110'),
(7, '56 Tooth Rd', 'Somerville', 'MA', '02120');

INSERT INTO Patient (patientId, firstName, lastName, phone, email, dob, addressId) VALUES
(100, 'Gillian', 'White', '5551112222', 'gillian.white@mail.com', '1990-05-15', 1),
(105, 'Jill', 'Bell', '5551113333', 'jill.bell@mail.com', '1988-08-22', 2),
(108, 'Ian', 'MacKay', '5551114444', 'ian.mackay@mail.com', '1985-11-10', 3),
(110, 'John', 'Walker', '5551115555', 'john.walker@mail.com', '1992-01-01', 4);

INSERT INTO Surgery (surgeryId, name, location, phone, fk_addressId) VALUES
(10, 'Surgery 10', '1st Floor, Building A', '6171231000', 5),
(13, 'Surgery 13', '2nd Floor, Building B', '6171231013', 6),
(15, 'Surgery 15', '3rd Floor, Building C', '6171231015', 7);

INSERT INTO Appointment (appointmentId, fk_dentistId, fk_patientId, fk_surgeryId, date, status) VALUES
(1, 1, 100, 15, '2013-09-12', 'Scheduled'), -- Tony Smith, Gillian White
(2, 1, 105, 15, '2013-09-12', 'Scheduled'), -- Tony Smith, Jill Bell
(3, 2, 108, 10, '2013-09-12', 'Scheduled'), -- Helen Pearson, Ian MacKay
(4, 2, 108, 10, '2013-09-14', 'Scheduled'), -- Helen Pearson, Ian MacKay
(5, 3, 105, 15, '2013-09-14', 'Scheduled'), -- Robin Plevin, Jill Bell
(6, 3, 110, 13, '2013-09-15', 'Scheduled'); -- Robin Plevin, John Walker

INSERT INTO Bill (billId, amount, paymentMethod, status, dateIssued, dateDue, fk_appointmentId) VALUES
(1, 150.00, 'Card', 'Paid', '2013-09-12', '2013-09-19', 1),
(2, 200.00, 'Cash', 'Pending', '2013-09-12', '2013-09-19', 2),
(3, 180.00, 'Card', 'Paid', '2013-09-12', '2013-09-19', 3),
(4, 180.00, 'Insurance', 'Pending', '2013-09-14', '2013-09-21', 4),
(5, 160.00, 'Card', 'Paid', '2013-09-14', '2013-09-21', 5),
(6, 175.00, 'Cash', 'Paid', '2013-09-15', '2013-09-22', 6);

-- Table Queries

-- Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames 
SELECT * FROM dentist ORDER BY lastName ASC;

--  Display the list of ALL Appointments for a given Dentist by their dentist_Id number(here 1). Include in the result, the Patient information. 
SELECT 
    a.appointmentId,
    a.date AS appointmentDate,
    a.status AS appointmentStatus,
    p.patientId,
    p.firstName AS patientFirstName,
    p.lastName AS patientLastName,
    p.phone AS patientPhone,
    p.email AS patientEmail,
    p.dob AS patientDOB
FROM Appointment a
JOIN Patient p ON a.fk_patientId = p.patientId
WHERE a.fk_dentistId = 1;

-- Display the list of ALL Appointments that have been scheduled at a Surgery Location(here 3rd Floor, Building C)

SELECT 
    a.appointmentId,
    a.date AS appointmentDate,
    a.status AS appointmentStatus,

    s.surgeryId,
    s.name AS surgeryName,
    s.location AS surgeryLocation,
    s.phone AS surgeryPhone

FROM Appointment a
JOIN Surgery s ON a.fk_surgeryId = s.surgeryId
WHERE s.location = '3rd Floor, Building C'
ORDER BY a.date;

--  Display the list of the Appointments booked for a given Patient(here id 105) on a given Date(here 2013-09-14). 

SELECT 
    a.appointmentId,
    a.date AS appointmentDate,
    a.status AS appointmentStatus,

    d.firstName || ' ' || d.lastName AS dentistName,
    s.name AS surgeryName,
    s.location AS surgeryLocation

FROM Appointment a
JOIN Dentist d ON a.fk_dentistId = d.dentistId
JOIN Surgery s ON a.fk_surgeryId = s.surgeryId
WHERE a.fk_patientId = 105
AND a.date = '2013-09-14';
