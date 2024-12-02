package LearnSE.ServletFiles;

import java.io.IOException;

import LearnSE.Dao.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeEmailServlet
 */
public class ChangeEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId"); // Assuming userId is stored in session
        String password = request.getParameter("password");
        String newEmail = request.getParameter("newEmail");

        // Create a userDao instance
        userDao dao = new userDao();

        // Check if the password is correct
        boolean isPasswordCorrect = dao.checkPassword(userId, password);

        if (isPasswordCorrect) {
            // If password is correct, update the email
            boolean isEmailUpdated = dao.updateEmail(userId, newEmail);

            if (isEmailUpdated) {
                // Email successfully updated, redirect to email changed page
                response.sendRedirect("AccountSettings/emailchanged.jsp");
            } else {
                // If email update fails, show error message
            	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/changeemail.jsp?error=failed_try_again");
            }
        } else {
            // If password is incorrect, show error message
        	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/changeemail.jsp?error=incorrect_password");
        }
    }
}
