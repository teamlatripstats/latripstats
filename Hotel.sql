Drop Database hotel_db

go
CREATE DATABASE hotel_db
go

use hotel_db

CREATE TABLE eigenschaften (
	
	HID int IDENTITY(1, 1) PRIMARY KEY,	--Identity: Automatischer Wert der sich um 1 erhöht
	Kategorie varchar (5) NOT NULL,
	Name varchar (max) NOT NULL,
	Adresse varchar (max) NOT NULL,
	Plz varchar (10),
	Stadt varchar (max) NOT NULL,
	Besitzer varchar (max) NOT NULL,
	Telefon int,
	Kontakt varchar (max),
	Raumzahl int NOT NULL,
	Bettenzahl int NOT NULL,
	Familienfreundlich varchar (10),
	Hundefreundlich varchar (10),
	Spa varchar (10),
	Fitness varchar (10)

)

CREATE TABLE belegung (
	BID int IDENTITY (1,1) PRIMARY KEY,
	Monat date,
	Jahr date,
	Kategorie varchar (5) NOT NULL,
	Zimmer int,
	Zimmerauslastung int,
	Betten int,
	Bettenauslastung int,
	HID int REFERENCES eigenschaften (HID)
)

Insert into eigenschaften VALUES 
	('*', 'Beim Branntweiner', 'Weinberg 3', 'A-1234', 'Alkohütten', 'Ima Voll', 546456, 'Gretel', 1, 1,'Ja','Ja','Nein','Nein'),
	('**', 'Das ABC', 'Heinzelmännchenweg 3', 'A-BCDEF', 'Buchstaben', 'II.Literat', 9876, 'der böse Wolf', 2, 2,'Ja','Ja','Nein','Nein'),
	('****', 'Drei Sterne und die Sonne', 'Sterngasse 5', 'A-1234', 'Alldorf', 'Sternwarte', 01234, 'Hänsel', 40, 4,'Ja','Ja','Nein','Nein'),
	('*****', 'Zum güldenen Hirsch', 'Hirschgasse 42/47/11', 'A-0815', 'Hirschhausen', 'Harry Hirsch', 1234, 'Susi', 5, 50,'Ja','Ja','Nein','Nein'),
	('***', 'Zum wilden Eber', 'Am Berg 7', 'A-007', 'Großebersdorf', 'James Bond', 0987, 'Strolchi', 3, 3,'Ja','Ja','Nein','Nein')

SELECT * FROM eigenschaften 
