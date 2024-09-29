package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.CompteDao;
import com.session.ICompteLocal;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   ICompteLocal compte;
   
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login =request.getParameter("login");
		String passwd =request.getParameter("passwd");
		
		String message="";
	
		
		if(!(compte.Connection(login, passwd))) {
			message="login ou mot de passe incorrect";
			request.setAttribute("message",message);
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		else
		{
			String typeCompte = (compte.getCompte(login, passwd)).getType();
			if("AdminRH".equals(typeCompte)){
				this.getServletContext().getRequestDispatcher("/DashboardAdmin.jsp").forward(request, response);
			}
			else if("ChefRH".equals(typeCompte)){
				this.getServletContext().getRequestDispatcher("/dashboardChef.jsp").forward(request, response);
			}
			else if("super".equals(typeCompte)){
				this.getServletContext().getRequestDispatcher("/superUserDashbord.jsp").forward(request, response);
			}
			
			else
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
			
		}
		
	}


