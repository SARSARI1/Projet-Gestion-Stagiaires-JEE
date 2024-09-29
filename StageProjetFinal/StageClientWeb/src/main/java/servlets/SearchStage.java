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

import com.entities.Stage;
import com.entities.Stagiaire;
import com.session.IStageLocal;

/**
 * Servlet implementation class SearchStage
 */
@WebServlet("/SearchStage")
public class SearchStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    IStageLocal istage;
    public SearchStage() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchInput = request.getParameter("searchInput");
		
		if (searchInput != null && !searchInput.isEmpty()) {
		 
		  List<Stage> stages=istage.getStageBySujet(searchInput);
			//stagiaires=istagiaire.getStagiaireByNomCIN(searchInput);
			request.setAttribute("stages",stages);
			if (request.getParameter("admin") == null) {
				this.getServletContext().getRequestDispatcher("/gestionStagesChef.jsp").forward(request, response);	
				}
				else
				{
					this.getServletContext().getRequestDispatcher("/managStagesAdmin.jsp").forward(request, response);	
				}
			
		} else {
			if (request.getParameter("admin") == null) {
				response.sendRedirect(request.getContextPath() + "/gestionStagesChef.jsp");
				}
				else
				{
					response.sendRedirect(request.getContextPath() + "/managStagesAdmin.jsp");
					
				}
			
			return;
		}
		doGet(request, response);
	}

}
