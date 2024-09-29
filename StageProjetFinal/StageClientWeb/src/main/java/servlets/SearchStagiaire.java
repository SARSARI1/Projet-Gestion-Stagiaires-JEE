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

import com.entities.Stagiaire;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class SearchStagiaire
 */
@WebServlet("/SearchStagiaire")
public class SearchStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    IStagiaireLocal istagiaire;
    public SearchStagiaire() {
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
			
			List<Stagiaire> stagiaires = new ArrayList<>();
			stagiaires=istagiaire.getStagiaireByNomCIN(searchInput);
			request.setAttribute("stagiaires",stagiaires);
			if (request.getParameter("admin") == null) {
				this.getServletContext().getRequestDispatcher("/gestionStagiaireChef.jsp").forward(request, response);	
				}
				else
				{
					this.getServletContext().getRequestDispatcher("/managStagiareAdmin.jsp").forward(request, response);	
				}
			
		} else {
			if (request.getParameter("admin") == null) {
				response.sendRedirect(request.getContextPath() + "/gestionStagiaireChef.jsp");
				}
				else
				{
					response.sendRedirect(request.getContextPath() + "/managStagiareAdmin.jsp");
					
				}
			
		
		}
		
	}

}
