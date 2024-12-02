package LearnSE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LearnSE.dbConnection;

public class userDao {
    private dbConnection dbConn;

    public userDao() {
        // Initialize the dbConnection object with your database details
        dbConn = new dbConnection("cs372_2024db", "root", "Passw0rd");
    }

    // Method to check if the password matches
    public boolean checkPassword(String userId, String currentPassword) {
        boolean isValid = false;
        String query = "SELECT password FROM users WHERE userid = ?";

        try (Connection conn = dbConn.create_connection_string(); // Use dbConnection to get DB connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (dbConn.verifyPassword(currentPassword, storedPassword)) {
                    isValid = true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // Method to update the password in the database
    public boolean updatePassword(String userId, String newPassword) {
        boolean isUpdated = false;
        String hashedPassword = dbConn.hashpwd(newPassword); // Hash the new password

        String query = "UPDATE users SET password = ? WHERE userid = ?";

        try (Connection conn = dbConn.create_connection_string(); // Use dbConnection to get DB connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hashedPassword);
            stmt.setString(2, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    // Method to check if the email is already taken
    public boolean isEmailTaken(String email) {
        boolean taken = false;
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection conn = dbConn.create_connection_string(); // Use dbConnection to get DB connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                taken = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taken;
    }

    // Method to update the email in the database
    public boolean updateEmail(String userId, String newEmail) {
        boolean isUpdated = false;
        String query = "UPDATE users SET email = ? WHERE userid = ?";

        try (Connection conn = dbConn.create_connection_string(); // Use dbConnection to get DB connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newEmail);
            stmt.setString(2, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    // Method to delete a user account from the database
    public boolean deleteAccount(String userId) {
        boolean isDeleted = false;
        String query = "DELETE FROM users WHERE userid = ?";

        try (Connection conn = dbConn.create_connection_string(); // Use dbConnection to get DB connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}