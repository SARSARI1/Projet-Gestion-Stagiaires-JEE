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

import com.entities.Encadrant;
import com.entities.Stagiaire;
import com.session.IEncadrantLocal;

/**
 * Servlet implementation class SearchEncadrant
 */
@WebServlet("/SearchEncadrant")
public class SearchEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    IEncadrantLocal iencadrant;
    
    public SearchEncadrant() {
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
			
			List<Encadrant> encadrants = new ArrayList<>();
			encadrants=iencadrant.getEncadrantByNom(searchInput);
			request.setAttribute("encadrants",encadrants);
			
				this.getServletContext().getRequestDispatcher("/gestionEncadrantsChef.jsp").forward(request, response);	
				
			
		} else {
			
				response.sendRedirect(request.getContextPath() + "/gestionEncadrantsChef.jsp");
				
			
		doGet(request, response);
	}
	}
}


