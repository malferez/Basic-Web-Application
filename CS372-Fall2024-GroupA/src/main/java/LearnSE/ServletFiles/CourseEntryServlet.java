package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.SQLException;

import LearnSE.Dao.cyberattackDao;
import LearnSE.Dao.daoService;
import LearnSE.Model.mainEntryModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseEntryServlet
 */
public class CourseEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 1: Call the scrapeData() method
        cyberattackDao dao = new cyberattackDao();
        try {
            dao.scrapeData(); // Trigger data scraping
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions during scraping
        }

        // Step 2: Handle the usual logic for processing user input (if needed)
        String entry_title = request.getParameter("text-title-content");
        String entry_details = request.getParameter("txt-content-detail");

        if (entry_title != null && entry_details != null) {
            // Set the model
            mainEntryModel entry = new mainEntryModel();
            entry.setContentTitle(entry_title);
            entry.setContentDetails(entry_details);

            // Pass data to the DAO
            daoService entrydao = new daoService();
            try {
                entrydao.addMainContent(entry);
            } catch (SQLException e) {
                e.printStackTrace(); // Handle exceptions during database operations
            }
        }
	}
}