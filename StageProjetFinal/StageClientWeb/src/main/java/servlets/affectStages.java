package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Encadrant;
import com.entities.Stage;
import com.entities.Stagiaire;
import com.session.IEncadrantLocal;
import com.session.IStageLocal;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class affectStages
 */
@WebServlet("/affectStages")
public class affectStages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	IStageLocal iStage;
	
	@EJB
	IStagiaireLocal istagiaire;
	
	@EJB
	IEncadrantLocal iencadrant;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public affectStages() {
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
		List<Stage>stages=iStage.getAllStages();
		request.setAttribute("liste",stages);
		
		List<Encadrant>encadrants=iencadrant.getAllEncadrants();
		request.setAttribute("listeE",encadrants);
		
		
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires=istagiaire.getStagiaireNouveau();
		request.setAttribute("stagiaires",stagiaires);
		
		
		
		if(request.getParameter("affecter")!= null) {
		
		String st=request.getParameter("stageid");
		int ist=Integer.parseInt(st);
		
		String end =request.getParameter("encadrantid");
		int iend=Integer.parseInt(end);
		
		String sta=request.getParameter("stagiaireid");
		int ista=Integer.parseInt(sta);
		
		
		
		
		Stage stage=iStage.getStage(ist);
		Encadrant encadrant=iencadrant.getEncadrant(iend);
		
		Stagiaire stagiaire=istagiaire.getStagiaire(ista);
		
		stagiaire.setEncadrant(encadrant);
		stagiaire.setStage(stage);
		
		istagiaire.UpdateStagiaire(stagiaire);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/affStages.jsp");
		dispatcher.forward(request, response);
	}
	
}
