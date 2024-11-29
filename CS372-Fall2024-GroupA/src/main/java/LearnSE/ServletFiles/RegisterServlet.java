package LearnSE.ServletFiles;

import LearnSE.Model.UserRegistrationModel;
import LearnSE.Dao.authentication;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet") // Maps servlet to "/RegisterServlet"
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    /**
     * Handles POST requests for user registration
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract user information from the request
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String secQuestion1 = request.getParameter("secQuestion1");
        String secAnswer1 = request.getParameter("secAnswer1");
        String secQuestion2 = request.getParameter("secQuestion2");
        String secAnswer2 = request.getParameter("secAnswer2");

        // Create a UserRegistrationModel object to store the extracted data
        UserRegistrationModel regModel = new UserRegistrationModel();
        regModel.setEmail(email);
        regModel.setFirstName(firstName);
        regModel.setMiddleName(middleName);
        regModel.setLastName(lastName);
        regModel.setUserName(username);
        regModel.setUserPwd(password);
        regModel.setSecQuestion1(secQuestion1);
        regModel.setSecAnswer1(secAnswer1);
        regModel.setSecQuestion2(secQuestion2);
        regModel.setSecAnswer2(secAnswer2);
        
        System.out.println(username);

        // Register user using the authentication class
        authentication authService = new authentication();
        try {
            boolean isRegistered = authService.memberRegistration(regModel);

            if (isRegistered) {
                // Redirect to a success page or login page
                response.sendRedirect(request.getContextPath() + "/Login/login.jsp");
            } else {
                // Show error message on the registration page if user already exists
                request.setAttribute("errorMessage", "User already exists. Please try a different username or email.");
                request.getRequestDispatcher("/Register/register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other errors by displaying a general error message on the registration page
            request.setAttribute("errorMessage", "An error occurred. Please try again.");
            request.getRequestDispatcher("/Login/login.jsp").forward(request, response);
        }
    }

    /**
     * Handles GET requests to show the registration form
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to registration form
        request.getRequestDispatcher("/Login/register.jsp").forward(request, response);
    }
}
