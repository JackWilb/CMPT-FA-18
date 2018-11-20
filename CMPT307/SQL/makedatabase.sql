DROP DATABASE IF EXISTS restaurant;
CREATE DATABASE restaurant;

USE restaurant;

GRANT SELECT ON restaurant.* TO 'restaurant_user'@'localhost'
	IDENTIFIED BY 'super secret password';

GRANT ALL ON restaurant.* TO 'restaurant_admin'@'%' 
	IDENTIFIED BY 'extra super secret password';