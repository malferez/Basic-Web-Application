package LearnSE.ServletFiles;

import java.io.IOException;
import java.sql.SQLException;

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
		String entry_title= request.getParameter("text-title-content");
		String entry_details = request.getParameter("txt-content-detail");
		//set the model
		mainEntryModel entry = new mainEntryModel();
		entry.setContentTitle(entry_title);
		entry.setContentDetails(entry_details);
		//pass data top data access object
		daoService entrydao = new daoService();
		try {
			entrydao.addMainContent(entry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

