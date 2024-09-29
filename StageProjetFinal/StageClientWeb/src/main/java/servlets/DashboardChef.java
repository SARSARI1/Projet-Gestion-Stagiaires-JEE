package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Departement;
import com.session.IDepartementLocal;
import com.session.IEncadrantLocal;
import com.session.IStageLocal;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class DashboardChef
 */
@WebServlet("/DashboardChef")
public class DashboardChef extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	   IStageLocal stagedao;
	@EJB
	IStagiaireLocal stagiaire;
	@EJB
	IEncadrantLocal encadrant;
	@EJB
	IDepartementLocal departement;
    public DashboardChef() {
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

		String nouveau="";
		String encours="";
		String archive="";
		
		String affecte="";
		
		String nonaffecte="";
		
        String Eaffecte="";
		String Enonaffecte="";
		
		List<Departement> listeDepart=departement.getAllDepartements();
		request.setAttribute("liste",listeDepart);
		
		String dep =request.getParameter("deprtid");
		
		if(dep==null) {
			Long nbrStages=stagedao.countNbStages();
			
			request.setAttribute("nbrStages",nbrStages);
			
			
	      Long nbrStagiaires=stagiaire.countNbStagiaire();
			
			request.setAttribute("nbrStagiaires",nbrStagiaires);
			
			
			Long nbrEncadrants=encadrant.countNbEncadrants();
			request.setAttribute("nbrEncadrants",nbrEncadrants);
			}
			
			else {
				
				 nouveau="nouveaux:";
				 encours="en cours:";
				 archive="archive:";
				 
			     affecte="Affectés:";
				 nonaffecte="Non affectes:";
				 
				 
				 Eaffecte="Affectés:";
				 Enonaffecte="Non affectes:";
				 
				 request.setAttribute("nouveau",nouveau);
				 request.setAttribute("encours",encours);
				 request.setAttribute("archive",archive);
				 
				 request.setAttribute("affecte",affecte);
				 request.setAttribute("nonaffecte",nonaffecte);
				 
				 request.setAttribute("Eaffecte",Eaffecte);
				 request.setAttribute("Enonaffecte",Enonaffecte);
				 
				//int id_dp=Integer.parseInt(dep);
				Long nbrStages=stagedao.countNbStagesByDepartement(dep);
				
				request.setAttribute("nbrStages",nbrStages);
				
				
		      Long nbrStagiaires=stagiaire.countNbStagiaireByDepartement(dep);
				
				request.setAttribute("nbrStagiaires",nbrStagiaires);
				
				
				Long nbrEncadrants=encadrant.countNbStagesByEncadrant(dep);
				request.setAttribute("nbrEncadrants",nbrEncadrants);
				
				
				Long stagiaresEncourt=stagiaire.countNbStagiaireCourt(dep);
				request.setAttribute("stagiaresEncourt",stagiaresEncourt);
				
				Long stagiaresArchive=stagiaire.countNbStagiaireArchive(dep);
				request.setAttribute("stagiaresArchive",stagiaresArchive);
				
				Long stagiaresNouveau=stagiaire.countNbStagiaireNouveau(dep);
				request.setAttribute("stagiaresNouveau",stagiaresNouveau);
				
				Long stagesAffectes=stagedao.countNbStagesAffectes(dep);
				request.setAttribute("stagesAffectes",stagesAffectes);
				
				Long stagesNonAffectes=stagedao.countNbStagesNonAffectes(dep);
				request.setAttribute("stagesNonAffectes",stagesNonAffectes);
				
				
				Long encadrantAffectes=encadrant.countNbEncadrantsAffectes(dep);
				request.setAttribute("encadrantAffectes",encadrantAffectes);
				

				Long encadrantNonAffectes=encadrant.countNbEncadrantsNonAffectes(dep);
				request.setAttribute("encadrantNonAffectes",encadrantNonAffectes);
				
				
				
				
				
			}
		
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboardChef.jsp");
        dispatcher.forward(request, response);
		
		doGet(request, response);
	}

}
