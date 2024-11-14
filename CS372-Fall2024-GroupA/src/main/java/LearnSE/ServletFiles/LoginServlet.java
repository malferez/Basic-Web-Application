package LearnSE.ServletFiles;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	/**
	 * Handles the POST request for login submission.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameOrEmail = request.getParameter("usernameOrEmail");
        String password = request.getParameter("password");

        // Placeholder login validation (replace with real validation logic)
        boolean loginSuccessful = validateCredentials(usernameOrEmail, password);

        if (loginSuccessful) {
            // Redirect to the user dashboard upon successful login
            response.sendRedirect("userDashboard.jsp"); // Adjust to actual dashboard page
        } else {
            // Redirect back to login with an error message if login fails
            response.sendRedirect("/Login/login.jsp?error=invalid_credentials");  // Adjusted path to /Login/login.jsp
        }
	}

	/**
	 * Mock validation method to check credentials (replace with actual database check).
	 */
	private boolean validateCredentials(String usernameOrEmail, String password) {
        // Placeholder logic; replace with real database query
        return "user".equals(usernameOrEmail) && "password".equals(password); // for testing
    }
}
