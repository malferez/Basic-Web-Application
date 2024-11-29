package LearnSE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import LearnSE.dbConnection;
import LearnSE.Model.UserRegistrationModel;

public class authentication {

    public boolean memberRegistration(UserRegistrationModel regModel) {
        dbConnection dbConn = new dbConnection("cs372_2024db", "root", "Passw0rd");

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement checkUserStmt = conn.prepareStatement(
                     "SELECT username, email FROM users WHERE username = ? OR email = ?");
             PreparedStatement insertUserStmt = conn.prepareStatement(
                     "INSERT INTO users (email, firstname, middlename, lastname, username, userid, password, " +
                             "securityquestion1, securityanswer1, securityquestion2, securityanswer2, " +
                             "securityaccesslevel, createdon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE())")) {

            // Check if the user already exists
            checkUserStmt.setString(1, regModel.getUserName());
            checkUserStmt.setString(2, regModel.getEmail());
            ResultSet rs = checkUserStmt.executeQuery();

            if (rs.next()) {
                // User already exists
                System.out.println("User already exists with username: " + regModel.getUserName() +
                                   " or email: " + regModel.getEmail());
                return false; // User already exists
            }

            // Generate a valid and unique UserID
            int userId = generateStandardUserId(conn);

            // Insert the new user into the database
            insertUserStmt.setString(1, regModel.getEmail());
            insertUserStmt.setString(2, regModel.getFirstName());
            insertUserStmt.setString(3, regModel.getMiddleName());
            insertUserStmt.setString(4, regModel.getLastName());
            insertUserStmt.setString(5, regModel.getUserName());
            insertUserStmt.setInt(6, userId);
            insertUserStmt.setString(7, hashPassword(regModel.getUserPwd())); // Store hashed password
            insertUserStmt.setString(8, regModel.getSecQuestion1());
            insertUserStmt.setString(9, regModel.getSecAnswer1());
            insertUserStmt.setString(10, regModel.getSecQuestion2());
            insertUserStmt.setString(11, regModel.getSecAnswer2());
            insertUserStmt.setString(12, "standard"); // Default access level

            int rowsAffected = insertUserStmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User successfully inserted.");
                return true; // Successful registration
            } else {
                System.out.println("No rows were inserted.");
                return false; // Registration failed
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Handle database exceptions
        }
    }

    // Generate a unique UserID
    private int generateStandardUserId(Connection conn) throws SQLException {
        int userId;
        boolean isUnique;
        do {
            userId = 1000 + (int) (Math.random() * 5001); // Generate ID between 1000 and 6000
            PreparedStatement checkIdStmt = conn.prepareStatement("SELECT userid FROM users WHERE userid = ?");
            checkIdStmt.setInt(1, userId);
            ResultSet rs = checkIdStmt.executeQuery();
            isUnique = !rs.next(); // If no results, the ID is unique
        } while (!isUnique);
        return userId;
    }

    // Hash the password using SHA-256
    private String hashPassword(String password) {
        dbConnection dbConn = new dbConnection("cs372_2024db", "root", "Passw0rd");
        return dbConn.hashpwd(password); // Assumes the dbConnection class has a working hashpwd method
    }
}
