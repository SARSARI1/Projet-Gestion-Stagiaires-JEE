package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Absence;
import com.session.IAbsenceLocal;

/**
 * Servlet implementation class deleteAbs
 */
@WebServlet("/deleteAbs")
public class deleteAbs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @EJB
     IAbsenceLocal Iabsence; 
    public deleteAbs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		int codei=Integer.parseInt(code);
	
		Iabsence.DeleteAbsence(codei);
		
		String message ="Absence bien supprimé";
		request.setAttribute( "message",message);

		this.getServletContext().getRequestDispatcher("/affichagesAbsences.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
