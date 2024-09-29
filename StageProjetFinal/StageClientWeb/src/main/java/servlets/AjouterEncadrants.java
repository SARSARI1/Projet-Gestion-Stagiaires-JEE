package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Encadrant;
import com.session.IEncadrantLocal;

/**
 * Servlet implementation class AjouterEncadrants
 */
@WebServlet("/AjouterEncadrants")
public class AjouterEncadrants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    IEncadrantLocal iencadrant;
    public AjouterEncadrants() {
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
		 try {
	            // Retrieve data from the form
	            String nom = request.getParameter("nom");
	            String prenom = request.getParameter("prenom");

	            // Create Encadrant object
	            Encadrant encadrant = new Encadrant();
	            encadrant.setNom(nom);
	            encadrant.setPrenom(prenom);
	         // Set initial state to non_affecte
	            

	            // Add Encadrant to the database
	            iencadrant.AddEncadrant(encadrant);

	            // Redirect back to the page (you can change the URL)
	            response.sendRedirect(request.getContextPath() + "/gestionEncadrantsChef.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding Encadrant to the database.");
	        }
	   
		doGet(request, response);
	}

}
