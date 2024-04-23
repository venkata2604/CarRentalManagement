CREATE TABLE Cars (
    CarID INT AUTO_INCREMENT PRIMARY KEY,
    Make VARCHAR(50) NOT NULL,
    Model VARCHAR(50) NOT NULL,
    Year INT CHECK (Year >= 1980),
    RegistrationNumber VARCHAR(20) UNIQUE NOT NULL,
    NumberOfSeats INT CHECK (NumberOfSeats >= 2 AND NumberOfSeats <= 15),
    PricePerDay DECIMAL(10, 2) CHECK (PricePerDay > 0),
    Status ENUM('Available', 'Rented', 'Under Maintenance') NOT NULL
);
