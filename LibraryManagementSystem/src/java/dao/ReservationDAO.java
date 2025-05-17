package dao;

import model.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    public boolean reserveBook(int bookId, int userId) throws SQLException {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);
            
            // Insert reservation
            String reserveSql = "INSERT INTO reservations (book_id, user_id) VALUES (?, ?)";
            try (PreparedStatement reserveStmt = conn.prepareStatement(reserveSql)) {
                reserveStmt.setInt(1, bookId);
                reserveStmt.setInt(2, userId);
                
                if (reserveStmt.executeUpdate() == 0) {
                    conn.rollback();
                    return false;
                }
            }
            
            // Update book status
            String updateSql = "UPDATE books SET status = 'Reserved' WHERE id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setInt(1, bookId);
                
                if (updateStmt.executeUpdate() == 0) {
                    conn.rollback();
                    return false;
                }
            }
            
            conn.commit();
            return true;
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) conn.setAutoCommit(true);
        }
    }
    
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.*, u.username as student_name, b.title as book_title " +
                     "FROM reservations r " +
                     "JOIN users u ON r.user_id = u.id " +
                     "JOIN books b ON r.book_id = b.id";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt("id"));
                reservation.setBookId(rs.getInt("book_id"));
                reservation.setUserId(rs.getInt("user_id"));
                reservation.setReservationDate(rs.getTimestamp("reservation_date"));
                reservation.setStudentName(rs.getString("student_name"));
                reservation.setBookTitle(rs.getString("book_title"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }
}