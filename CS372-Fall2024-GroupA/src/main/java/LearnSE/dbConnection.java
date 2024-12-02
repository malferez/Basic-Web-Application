package LearnSE;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    Connection conn = null;
    private static String strconnect = "jdbc:mysql://localhost:3306/";
    private static String usrname;
    private static String usrpwd;
    private static String usrdbname;

    // Constructor to initialize connection parameters
    public dbConnection(String usrdbname, String usrname, String usrpwd) {
        dbConnection.usrname = usrname;
        dbConnection.usrpwd = usrpwd;
        dbConnection.usrdbname = usrdbname;
    }

    // Create and return the database connection
    public Connection create_connection_string() throws SQLException {
        String connString = strconnect + usrdbname;
        try {
            // Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create the connection string
            conn = DriverManager.getConnection(connString, usrname, usrpwd);
            if (conn != null) {
                // Successful connection
            } else {
                System.out.println("Connection failed!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Hash the password using SHA-256
    public String hashpwd(String password) {
        String hash_algorithm = "SHA-256";
        StringBuilder byte_String = new StringBuilder();
        try {
            MessageDigest my_hash_pwd = MessageDigest.getInstance(hash_algorithm);
            my_hash_pwd.update(password.getBytes());
            byte[] pwd_digest = my_hash_pwd.digest();
            for (Byte byte_ch : pwd_digest) {
                byte_String.append(String.format("%02x", byte_ch));
            }
            return byte_String.toString();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    // Verify the password by comparing the stored hash with the hashed input password
    public boolean verifyPassword(String inputPassword, String storedHash) {
        // Hash the input password using the same hash method
        String inputHash = hashpwd(inputPassword);

        // Compare the hashed input password with the stored hash
        return inputHash != null && inputHash.equals(storedHash);
    }
}