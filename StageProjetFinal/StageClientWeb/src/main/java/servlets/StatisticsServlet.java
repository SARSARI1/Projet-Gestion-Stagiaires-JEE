package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.IEncadrantLocal;
import com.session.IStageLocal;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class StatisticsServlet
 */
@WebServlet("/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    IStagiaireLocal stagiaireDao;
    
    @EJB
    IStageLocal stageDao;
    
    @EJB
    IEncadrantLocal encadrantDao;
    public StatisticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
	           
	        	
	            int totalStagiaires = stagiaireDao.getAllStagiaires().size();
	            int totalEncadrants = encadrantDao.getAllEncadrants().size();
	            int totalStages = stageDao.getAllStages().size();
	          

	           
	            req.setAttribute("totalStagiaires", totalStagiaires);
	            req.setAttribute("totalEncadrants", totalEncadrants);
	            req.setAttribute("totalStages", totalStages);
	           

	            req.getRequestDispatcher("superUserDashbord.jsp").forward(req, resp);

	        } catch (Exception e) {
	            e.printStackTrace();
	            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching data from the database.");
	        }
	   
		doGet(req, resp);
}

}
