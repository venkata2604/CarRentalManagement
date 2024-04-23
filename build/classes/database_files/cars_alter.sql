ALTER TABLE car_rental.cars
    MODIFY Make VARCHAR(50) NOT NULL,
    MODIFY Model VARCHAR(50) NOT NULL,
    MODIFY RegistrationNumber VARCHAR(20) UNIQUE NOT NULL,
    MODIFY NumberOfSeats INT CHECK (NumberOfSeats >= 2 AND NumberOfSeats <= 15),
    MODIFY PricePerDay DECIMAL(10, 2) CHECK (PricePerDay > 0),
    MODIFY Status ENUM('Available', 'Rented', 'Under Maintenance') DEFAULT 'Available'
;
