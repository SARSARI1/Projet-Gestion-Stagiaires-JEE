package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Compte;
import com.session.ICompteLocal;

/**
 * Servlet implementation class DeleteCompteServlet
 */
@WebServlet("/DeleteCompteServlet")
public class DeleteCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @EJB 
	  ICompteLocal compteDao;
    public DeleteCompteServlet() {
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
		 int compteId = Integer.parseInt(request.getParameter("compteId"));

	        // Retrieve the compte by its ID
	        Compte compte = compteDao.getCompte(compteId);

	        // Delete the compte from the database
	        compteDao.DeleteCompte(compte.getId_compte());

	        // Redirect to the listComptes.jsp page
	        request.getRequestDispatcher("superUserCompte.jsp").forward(request, response);
		doGet(request, response);
	}

}
