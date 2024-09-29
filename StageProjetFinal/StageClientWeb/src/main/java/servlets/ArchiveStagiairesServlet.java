package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Stagiaire;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class ArchiveStagiairesServlet
 */
@WebServlet("/ArchiveStagiairesServlet")
public class ArchiveStagiairesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    IStagiaireLocal stagiaireDao;
    public ArchiveStagiairesServlet() {
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
		

        // Get all stagiaires
		List<Stagiaire> allStagiaires = stagiaireDao.countNbStagiairesArchives();

		

        
		req.setAttribute("stagiaires", allStagiaires);
		req.getRequestDispatcher("superUserArchive.jsp").forward(req, resp);
    

   
		doGet(req, resp);
	}

}
