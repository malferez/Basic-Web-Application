package LearnSE.ServletFiles;

import java.io.IOException;

import LearnSE.Dao.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the form data
        String userId = (String) request.getSession().getAttribute("userId"); // Assuming userId is stored in session
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate new passwords match
        if (!newPassword.equals(confirmPassword)) {
        	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/changepassword.jsp?error=passwords_do_not_match");
            return;
        }

        // Create a userDao instance
        userDao dao = new userDao();

        // Check if the current password is correct
        boolean isPasswordCorrect = dao.checkPassword(userId, currentPassword);
        if (isPasswordCorrect) {
            // If the password is correct, update the password
            boolean isUpdated = dao.updatePassword(userId, newPassword);
            if (isUpdated) {
                // If the update is successful, redirect to the success page
                response.sendRedirect("AccountSettings/passwordchanged.jsp");
            } else {
                // If update fails, show error message
            	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/changepassword.jsp?error=failed_try_again");
            }
        } else {
            // If the current password is incorrect
        	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/changepassword.jsp?error=incorrect_password");
        }
    }
}
