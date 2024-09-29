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
 * Servlet implementation class affStagiaire
 */
@WebServlet("/affStagiaire")
public class affStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    IStagiaireLocal istagiaire;
    public affStagiaire() {
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
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires=istagiaire.getAllStagiaires();
		request.setAttribute("stagiaires",stagiaires);
		this.getServletContext().getRequestDispatcher("/attestation.jsp").forward(request, response);
	}

}
