package LearnSE.ServletFiles;

import java.io.IOException;

import LearnSE.Dao.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAccount
 */
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
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

        // Create a userDao instance
        userDao dao = new userDao();

        // Check if the password is correct
        boolean isPasswordCorrect = dao.checkPassword(userId, password);

        if (isPasswordCorrect) {
            // If password is correct, delete the account
            boolean isDeleted = dao.deleteAccount(userId);

            if (isDeleted) {
                // Account successfully deleted, log the user out and redirect to a success page or login page
                request.getSession().invalidate(); // Invalidate session to log the user out
                response.sendRedirect("AccountSettings/accountdeleted.jsp"); // Redirect to account deleted confirmation page
            } else {
                // If deletion fails, show error message
            	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/deleteaccount.jsp?error=try_again");
            }
        } else {
            // If password is incorrect, show error message
        	response.sendRedirect("/CS372-Fall2024-GroupA/AccountSettings/deleteaccount.jsp?error=incorrect_password");
        }
    }
}
