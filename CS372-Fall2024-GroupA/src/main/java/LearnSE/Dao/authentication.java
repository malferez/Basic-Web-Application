package LearnSE.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import LearnSE.dbConnection;
import LearnSE.Model.UserRegistrationModel;

public class authentication {

    public boolean studentLogin(UserRegistrationModel loginModel) {
        // Logic to verify student login using loginModel (username and password)
        return true; // Temporary return
    }

    public boolean memberRegistration(UserRegistrationModel regModel) {
        dbConnection dbConn = new dbConnection("cs372_2024db", "root", "Passw0rd");
        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement checkUserStmt = conn.prepareStatement("SELECT username, email FROM users WHERE username = ? OR email = ?");
             PreparedStatement insertUserStmt = conn.prepareStatement("INSERT INTO users (email, firstname, middlename, lastname, username, userid, password, securityquestion1, securityanswer1, securityquestion2, securityanswer2, securityaccesslevel, createdon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE())")) {
            
            // Check if the user already exists
            checkUserStmt.setString(1, regModel.getUserName());
            checkUserStmt.setString(2, regModel.getEmail());
            ResultSet rs = checkUserStmt.executeQuery();
            if (rs.next()) {
                return false; // User already exists
            }

            // Insert new user
            insertUserStmt.setString(1, regModel.getEmail());
            insertUserStmt.setString(2, regModel.getFirstName());
            insertUserStmt.setString(3, regModel.getMiddleName());
            insertUserStmt.setString(4, regModel.getLastName());
            insertUserStmt.setString(5, regModel.getUserName());
            insertUserStmt.setInt(6, generateUserId());
            insertUserStmt.setString(7, hashPassword(regModel.getUserPwd()));
            insertUserStmt.setString(8, regModel.getSecQuestion1());
            insertUserStmt.setString(9, regModel.getSecAnswer1());
            insertUserStmt.setString(10, regModel.getSecQuestion2());
            insertUserStmt.setString(11, regModel.getSecAnswer2());
            insertUserStmt.setString(12, regModel.getAccessLevel());

            return insertUserStmt.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private int generateUserId() {
        // Generate unique user ID, replace with a more robust approach as needed
        return (int) (Math.random() * 100000); 
    }

    private String hashPassword(String password) {
        dbConnection dbConn = new dbConnection("cs372_2024db", "root", "Passw0rd");
        return dbConn.hashpwd(password); // Uses hash function from dbConnection
    }
}
