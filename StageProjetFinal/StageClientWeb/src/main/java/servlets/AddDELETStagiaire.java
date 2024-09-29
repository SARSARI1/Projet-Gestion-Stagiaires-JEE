package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.IStagiaireLocal;

/**
 * Servlet implementation class AddDELETStagiaire
 */
@WebServlet("/AddDELETStagiaire")
public class AddDELETStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    IStagiaireLocal istagiaire;
    public AddDELETStagiaire() {
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
		String idStagiare=request.getParameter("stagiaireId");
		int idstagiareInt=Integer.parseInt(idStagiare);
		request.setAttribute("idS",idstagiareInt);
		istagiaire.DeleteStagiaire(idstagiareInt);
		this.getServletContext().getRequestDispatcher("/gestionStagiaireChef.jsp").forward(request, response);	
		doGet(request, response);
	}

}
