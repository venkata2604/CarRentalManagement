ALTER TABLE Payments 
    MODIFY BookingID INT,
    MODIFY PaymentDate DATETIME,
    MODIFY Amount DECIMAL(10, 2) CHECK (Amount > 0),
    MODIFY Status ENUM('Completed', 'Pending', 'Failed') DEFAULT 'Failed';
