package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Compte;
import com.session.ICompteLocal;

/**
 * Servlet implementation class ListComptesServlet
 */
@WebServlet("/ListComptesServlet")
public class ListComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB 
    ICompteLocal compteDao;
    public ListComptesServlet() {
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
		 List<Compte> comptes = compteDao.getAllComptes();

	        // Set the list of Comptes as an attribute in the request
	        request.setAttribute("comptes", comptes);

	        // Forward the request to the listComptes.jsp page
	        request.getRequestDispatcher("superUserCompte.jsp").forward(request, response);
		doGet(request, response);
	}

}
