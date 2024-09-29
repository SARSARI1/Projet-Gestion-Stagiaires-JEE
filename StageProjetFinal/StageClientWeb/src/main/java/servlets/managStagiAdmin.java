package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Departement;
import com.entities.Stagiaire;
import com.session.IAbsenceLocal;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class managStagiAdmin
 */
@WebServlet("/managStagiAdmin")
public class managStagiAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @EJB
    IAbsenceLocal absence;
	 @EJB
	 IStagiaireLocal stagiare;
    
    public managStagiAdmin() {
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
		 Date currentDate=new Date();
		 SimpleDateFormat f=new SimpleDateFormat ("dd//MM//YYYY");
		 request.setAttribute("currentDate",f.format(currentDate));
		List<Stagiaire> listeStagiaires=stagiare.getAllStagiaires();
		request.setAttribute("liste",listeStagiaires);
		this.getServletContext().getRequestDispatcher("/absence.jsp").forward(request, response);
		doGet(request, response);
	}

}
