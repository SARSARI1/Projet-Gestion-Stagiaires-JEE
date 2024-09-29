package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.IEncadrantLocal;

/**
 * Servlet implementation class AddDELETEncadrant
 */
@WebServlet("/AddDELETEncadrant")
public class AddDELETEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
    IEncadrantLocal iencadrant;
    public AddDELETEncadrant() {
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
		String idEncadrant=request.getParameter("encadrantId");
		int idstagiareInt=Integer.parseInt(idEncadrant);
		iencadrant.DeleteEncadrant(idstagiareInt);
		this.getServletContext().getRequestDispatcher("/gestionEncadrantsChef.jsp").forward(request, response);	
		doGet(request, response);
	}

}
