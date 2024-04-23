ALTER TABLE users 
MODIFY Username varchar(50) NOT NULL,
MODIFY Password varchar(255) NOT NULL,
MODIFY Email varchar(100),
MODIFY Role enum('customer', 'admin') DEFAULT 'customer',
MODIFY FirstName varchar(100),
MODIFY LastName varchar(100),
MODIFY MiddleName varchar(100);