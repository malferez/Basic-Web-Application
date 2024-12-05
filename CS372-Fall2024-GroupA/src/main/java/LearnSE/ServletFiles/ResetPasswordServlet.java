package LearnSE.ServletFiles;

import java.io.IOException;

import LearnSE.Dao.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetPasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("email", email);
        	response.sendRedirect("/CS372-Fall2024-GroupA/Login/resetpassword.jsp?error=passwords_do_not_match");

            return;
        }

        try {
            // Update the password in the database
            userDao userDao = new userDao();
            boolean isUpdated = userDao.resetPassword(email, password);

            if (isUpdated) {
                response.sendRedirect("/CS372-Fall2024-GroupA/Login/login.jsp?message=Password reset successfully!");
            } else {
            	response.sendRedirect("/CS372-Fall2024-GroupA/Login/resetpassword.jsp?error=failed_try_again");

            }
        } catch (Exception e) {
            throw new ServletException("Error during password reset", e);
        }
    }

}
