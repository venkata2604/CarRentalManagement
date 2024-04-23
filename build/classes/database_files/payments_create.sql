CREATE TABLE Payments (
    PaymentID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT NOT NULL,
    PaymentDate DATETIME NOT NULL,
    Amount DECIMAL(10, 2) CHECK (Amount > 0),
    PaymentMethod VARCHAR(50) NOT NULL,
    Status ENUM('Completed', 'Pending', 'Failed') NOT NULL,
    CONSTRAINT fk_Payment_Booking FOREIGN KEY (BookingID) REFERENCES Bookings(BookingID)
);
