CREATE TABLE Bookings (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    CarID INT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    TotalPrice DECIMAL(10, 2) CHECK (TotalPrice > 0),
    Status ENUM('Active', 'Completed', 'Cancelled') NOT NULL,
    CONSTRAINT fk_Booking_User FOREIGN KEY (UserID) REFERENCES Users(UserID),
    CONSTRAINT fk_Booking_Car FOREIGN KEY (CarID) REFERENCES Cars(CarID)
);
ALTER TABLE Bookings
ADD COLUMN BookingTimestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;