package model;

import java.sql.Timestamp;

public class Reservation {
    private int id;
    private int bookId;
    private int userId;
    private Timestamp reservationDate;
    private String studentName;
    private String bookTitle;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public Timestamp getReservationDate() { return reservationDate; }
    public void setReservationDate(Timestamp reservationDate) { this.reservationDate = reservationDate; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
}