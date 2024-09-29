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
import com.session.IStageLocal;

/**
 * Servlet implementation class AfficherEncadrants
 */
@WebServlet("/AfficherEncadrants")
public class AfficherEncadrants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    IEncadrantLocal iencadrant;
    public AfficherEncadrants() {
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
		List<Encadrant> encadrants = new ArrayList<>();
		encadrants=iencadrant.getAllEncadrants();
		request.setAttribute("encadrants",encadrants);
		
		if(request.getParameter("modifier")!=null) {
		
		   try {
	            int encadrantId = Integer.parseInt(request.getParameter("id"));
	            String nomModifier = request.getParameter("nom");
	            String prenomModifier = request.getParameter("prenom");

	            Encadrant encadrant = iencadrant.getEncadrant(encadrantId);

	          
	            if (nomModifier != null && !nomModifier.isEmpty()) {
	                encadrant.setNom(nomModifier);
	            }

	            if (prenomModifier != null && !prenomModifier.isEmpty()) {
	                encadrant.setPrenom(prenomModifier);
	            }

	        
	            iencadrant.UpdateEncadrant(encadrant);

	         
	            response.sendRedirect(request.getContextPath() + "/gestionEncadrantsChef.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating Encadrant in the database.");
	        }
	    }
	
		
				this.getServletContext().getRequestDispatcher("/gestionEncadrantsChef.jsp").forward(request, response);	
			
		
		doGet(request, response);
	}

}
