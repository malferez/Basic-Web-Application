package LearnSE.ServletFiles;

import java.io.IOException;

import LearnSE.Dao.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifySecurityQuestionsServlet
 */
public class VerifySecurityQuestionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public VerifySecurityQuestionsServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");

        if (email == null || answer1 == null || answer2 == null) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/Login/securityquestions.jsp").forward(request, response);
            return;
        }

        userDao userDao = new userDao();
        boolean verified = userDao.verifySecurityAnswers(email, answer1, answer2);

        if (verified) {
            // Redirect to reset password page
            request.setAttribute("email", email);
            request.getRequestDispatcher("/Login/resetpassword.jsp").forward(request, response);
        } else {
            // Pass security questions back to the page along with an error message
            String[] securityQuestions = userDao.getSecurityQuestionsByEmail(email);
            request.setAttribute("email", email);
            request.setAttribute("question1", securityQuestions[0]);
            request.setAttribute("question2", securityQuestions[1]);
            request.setAttribute("error", "Verification failed. Please try again.");
            request.getRequestDispatcher("/Login/securityquestions.jsp").forward(request, response);
        }
    }
}