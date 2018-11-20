-- Turn on strict mode while reading this file - warnings become errors
SET SESSION sql_mode = 'STRICT_ALL_TABLES';

DROP DATABASE IF EXISTS assignment06_part2;
CREATE DATABASE assignment06_part2;
USE assignment06_part2;

CREATE TABLE Author(
	id 	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	fname VARCHAR(64) NOT NULL,
	lname VARCHAR(64) NOT NULL,
	dob DATE NOT NULL,
	dod DATE
); 

CREATE TABLE Agency(
	id INT UNSIGNED PRIMARY KEY,
	name VARCHAR(128) NOT NULL
); 

CREATE TABLE Agent(
	id INT UNSIGNED PRIMARY KEY,
	fname VARCHAR(64) NOT NULL,
	lname VARCHAR(64) NOT NULL,
	agencyId INT UNSIGNED,

	FOREIGN KEY (agencyId) REFERENCES Agency (id)
); 

CREATE TABLE Publisher(
	name VARCHAR(128) PRIMARY KEY,
	city VARCHAR(128) NOT NULL,
	country VARCHAR(128) NOT NULL
); 

CREATE TABLE Book(
	isbn BIGINT PRIMARY KEY,
	title VARCHAR(256) NOT NULL,
	year YEAR NOT NULL,
	pages INT UNSIGNED NOT NULL,
	format ENUM('hardcover', 'paperback', 'audiobook') NOT NULL,
	publisher VARCHAR(128) NOT NULL,

	FOREIGN KEY (publisher) REFERENCES Publisher (name)
); 

CREATE TABLE Wrote(
	authorId INT UNSIGNED NOT NULL,
	isbn BIGINT NOT NULL,
	agentId INT UNSIGNED,

	PRIMARY KEY (authorId, isbn),
	FOREIGN KEY (authorId) REFERENCES Author (id),
	FOREIGN KEY (isbn) REFERENCES Book (isbn),
	FOREIGN KEY (agentId) REFERENCES Agent (id)
); 

CREATE TABLE BookSeries(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(256)
); 

CREATE TABLE InSeries(
	isbn BIGINT NOT NULL,
	id INT UNSIGNED NOT NULL,
	number INT NOT NULL,

	PRIMARY KEY (isbn, id),
	FOREIGN KEY (isbn) REFERENCES Book (isbn),
	FOREIGN KEY (id) REFERENCES BookSeries (id)
); 

INSERT INTO Author (fname, lname, dob, dod) VALUES
	('Collins', 'Suzanne', '1962-08-10', NULL);

INSERT INTO Publisher (name, city, country) VALUES
	('Scholastic Press', 'New York' , 'USA');

INSERT INTO Book (isbn, title, year, pages, format, publisher) VALUES
	(9780439023481, 'The Hunger Games', 2008, 384, 'paperback', 'Scholastic Press'),
	(9780439023511, 'Mockingjay', 2010, 391, 'paperback', 'Scholastic Press'),
	(9780439023498, 'Catching Fire', 2009, 391, 'paperback', 'Scholastic Press');

INSERT INTO Wrote (authorId, isbn) VALUES
	(1, 9780439023481),
	(1, 9780439023511),
	(1, 9780439023498);

INSERT INTO BookSeries (name) VALUES 
	('The Hunger Games');

INSERT INTO InSeries (isbn, id, number) VALUES
	(9780439023481, 1, 1),
	(9780439023511, 1, 3),
	(9780439023498, 1, 2);


