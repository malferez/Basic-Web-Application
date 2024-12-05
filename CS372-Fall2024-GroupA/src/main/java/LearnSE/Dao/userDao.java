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

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                isValid = dbConn.verifyPassword(currentPassword, storedPassword);
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

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hashedPassword);
            stmt.setString(2, userId);

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

 // Method to check if the email is already registered/taken
    public boolean isEmailTaken(String email) {
        boolean taken = false;
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection conn = dbConn.create_connection_string();
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

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newEmail);
            stmt.setString(2, userId);

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    // Method to delete a user account from the database
    public boolean deleteAccount(String userId) {
        boolean isDeleted = false;
        String query = "DELETE FROM users WHERE userid = ?";

        try (Connection conn = dbConn.create_connection_string();
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

    // Forgot Password: Retrieve security questions by email
    public String[] getSecurityQuestionsByEmail(String email) {
        try (Connection conn = dbConn.create_connection_string()) {
            String query = "SELECT securityquestion1, securityquestion2 FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new String[] { rs.getString("securityquestion1"), rs.getString("securityquestion2") };
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Forgot Password: Verify the security answers
    public boolean verifySecurityAnswers(String email, String answer1, String answer2) {
        boolean isVerified = false;
        String query = "SELECT securityanswer1, securityanswer2 FROM users WHERE email = ?";

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedAnswer1 = rs.getString("securityanswer1");
                String storedAnswer2 = rs.getString("securityanswer2");

                // Compare plain text answers directly
                isVerified = answer1.equalsIgnoreCase(storedAnswer1) && answer2.equalsIgnoreCase(storedAnswer2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isVerified;
    }

    // Forgot Password: Update password
    public boolean resetPassword(String email, String newPassword) {
        boolean isUpdated = false;
        String hashedPassword = dbConn.hashpwd(newPassword);

        String query = "UPDATE users SET password = ? WHERE email = ?";

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hashedPassword);
            stmt.setString(2, email);

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}