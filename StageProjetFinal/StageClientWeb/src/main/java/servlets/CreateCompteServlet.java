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
 * Servlet implementation class CreateCompteServlet
 */
@WebServlet("/CreateCompteServlet")
public class CreateCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @EJB 
    ICompteLocal compteDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        String passwd = request.getParameter("passwd");
        String type = request.getParameter("type");

        // Create a new Compte
        Compte compte = new Compte();
        compte.setLogin(login);
        compte.setPasswd(passwd);
        compte.setType(type);

        // Add the Compte to the database
        compteDao.AddCompte(compte);

        // Redirect to the createCompte.jsp page
        request.getRequestDispatcher("superUserCompte.jsp").forward(request, response);
   
		doGet(request, response);
	}

}
