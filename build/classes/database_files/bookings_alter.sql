ALTER TABLE Bookings 
    MODIFY UserID INT ,
    MODIFY CarID INT,
    MODIFY StartDate DATE,
    MODIFY EndDate DATE,
    MODIFY TotalPrice DECIMAL(10, 2) CHECK (TotalPrice > 0),
    MODIFY Status ENUM('Active', 'Completed', 'Cancelled') DEFAULT 'Active';
