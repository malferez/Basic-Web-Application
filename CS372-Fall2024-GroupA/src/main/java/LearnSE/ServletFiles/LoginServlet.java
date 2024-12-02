package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LearnSE.dbConnection;
import LearnSE.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameOrEmail = request.getParameter("usernameOrEmail");
        String password = request.getParameter("password");

        // Validate credentials and get the user details
        User user = validateCredentials(usernameOrEmail, password);

        if (user != null) {
            // Store user details in the session
            request.getSession().setAttribute("userId", user.getUserId());
            request.getSession().setAttribute("firstName", user.getFirstName());
            request.getSession().setAttribute("username", user.getUsername());
            request.getSession().setAttribute("userRole", user.getAccessLevel());

            // Redirect to the main page after successful login
            response.sendRedirect("/CS372-Fall2024-GroupA/");
        } else {
            // Redirect back to login with an error message if login fails
            response.sendRedirect("/CS372-Fall2024-GroupA/Login/login.jsp?error=invalid_credentials");
        }
    }

    private User validateCredentials(String usernameOrEmail, String password) {
        dbConnection dbConn = new dbConnection("cs372_2024db", "root", "Passw0rd");
        User user = null;

        String query = "SELECT userid, firstname, username, password, securityaccesslevel FROM users WHERE username = ? OR email = ?";

        try (Connection conn = dbConn.create_connection_string();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usernameOrEmail);
            stmt.setString(2, usernameOrEmail);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                String hashedPassword = dbConn.hashpwd(password);

                if (storedPassword.equals(hashedPassword)) {
                    // Create user object with the retrieved details
                    user = new User(
                    		rs.getString("userid"),
                    		rs.getString("firstname"),
                    		rs.getString("username"),
                    		rs.getString("securityaccesslevel"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}