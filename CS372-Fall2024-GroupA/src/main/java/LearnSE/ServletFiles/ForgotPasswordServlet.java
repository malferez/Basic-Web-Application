package LearnSE.ServletFiles;

import java.io.IOException;

import LearnSE.Dao.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        userDao userDao = new userDao();
        String[] securityQuestions = userDao.getSecurityQuestionsByEmail(email);

        if (securityQuestions != null) {
            // Pass security questions and email to the next page
            request.setAttribute("email", email);
            request.setAttribute("question1", securityQuestions[0]);
            request.setAttribute("question2", securityQuestions[1]);
            request.getRequestDispatcher("/Login/securityquestions.jsp").forward(request, response);
        } else {
            // Email not found, return to the forgot password page with error
        	response.sendRedirect("/CS372-Fall2024-GroupA/Login/forgotpassword.jsp?error=email_not_found");
        }
    }
}
