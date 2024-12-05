package LearnSE.ServletFiles;

import java.io.IOException;
import java.util.ArrayList;

import LearnSE.Dao.cyberattackDao;
import LearnSE.Model.CyberModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CyberAttackServlet
 */
public class CyberAttackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberAttackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cyberattackDao dao = new cyberattackDao();
        ArrayList<CyberModel> cyberData = dao.getCyberData();

        // Debug: Print the size of the data retrieved
        //System.out.println("cyberData size in servlet: " + (cyberData != null ? cyberData.size() : "null"));

        // Set the data in the request scope
        request.setAttribute("cyberData", cyberData);

        // Forward to the JSP
        request.getRequestDispatcher("CyberAttacks/TopCountriesAttacks.jsp").forward(request, response);
        //System.out.println("Forwarding to JSP with cyberData: " + cyberData.size());

    }
}
