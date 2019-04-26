--CREATE DATABASE Hotel

CREATE TABLE eigenschaften (
	
	HID int IDENTITY(1, 1) PRIMARY KEY,	--Identity: Automatischer Wert der sich um 1 erh�ht
	Kategorie varchar (5) NOT NULL,
	Name varchar (max) NOT NULL,
	Adresse varchar (max) NOT NULL,
	Plz varchar (10),
	Stadt varchar (max) NOT NULL,
	Besitzer varchar (max) NOT NULL,
	Telefon int,
	Kontakt varchar (max),
	Raumzahl int NOT NULL,
	Bettenzahl int NOT NULL
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
	('*', 'Beim Branntweiner', 'Weinberg 3', 'A-1234', 'Alkoh�tten', 'Ima Voll', 546456, 'Gretel', 1, 1),
	('**', 'Das ABC', 'Heinzelm�nnchenweg 3', 'A-BCDEF', 'Buchstaben', 'II.Literat', 9876, 'der b�se Wolf', 2, 2),
	('****', 'Drei Sterne und die Sonne', 'Sterngasse 5', 'A-1234', 'Alldorf', 'Sternwarte', 01234, 'H�nsel', 40, 4),
	('*****', 'Zum g�ldenen Hirsch', 'Hirschgasse 42/47/11', 'A-0815', 'Hirschhausen', 'Harry Hirsch', 1234, 'Susi', 5, 50),
	('***', 'Zum wilden Eber', 'Am Berg 7', 'A-007', 'Gro�ebersdorf', 'James Bond', 0987, 'Strolchi', 3, 3)

SELECT * FROM eigenschaften