package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Absence;
import com.entities.Departement;
import com.entities.Stagiaire;
import com.session.IAbsenceLocal;
import com.session.IStagiaireLocal;


/**
 * Servlet implementation class absence
 */
@WebServlet("/absence")
public class absence extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @EJB
     IAbsenceLocal Iabsence; 
     
     @EJB
     IStagiaireLocal Istagiaire; 
    public absence() {
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
		// TODO Auto-generated method stub
		 if (request.getParameter("afficher") == null) {
			String message="absence bien enregistré";
				request.setAttribute("message",message);
			 Date currentDate=new Date();
			SimpleDateFormat f=new SimpleDateFormat ("dd/MM/YYYY");
			 
				Stagiaire stagiaire=new Stagiaire();
				String[] idsStagiaires = request.getParameterValues("id");
				if (idsStagiaires != null) {
					
					
				    for (String idStagiaire : idsStagiaires) {
					int code =Integer.parseInt(idStagiaire);
					Absence abs=Iabsence.getAbsenceByStagiaireId(code);
					if(abs==null || (abs!=null && !(f.format(abs.getDate_abs()).equals(f.format(currentDate))))) {
						
						stagiaire=Istagiaire.getStagiaire(code);
						Iabsence.marquerAbsence(stagiaire);
					
					}
				}
					
					
				}
				this.getServletContext().getRequestDispatcher("/absence.jsp").forward(request, response);
		
		 }
			else {
				
				
				    Map<Date, List<Absence>> groupedAbsences = new LinkedHashMap<>();
				    List<Absence> absences=Iabsence.getAllAbsencets();

				    for (Absence absence : absences) {
				        Date dateAbs = absence.getDate_abs();

				        // Si la date est déjà dans la map, ajoutez l'absence à la liste existante
				        if (groupedAbsences.containsKey(dateAbs)) {
				            groupedAbsences.get(dateAbs).add(absence);
				        } else {
				            // Sinon, créez une nouvelle liste pour cette date
				            List<Absence> newList = new ArrayList<>();
				            newList.add(absence);
				            groupedAbsences.put(dateAbs, newList);
				        }
				    }
				    request.setAttribute("groupedAbsences", groupedAbsences);
				    this.getServletContext().getRequestDispatcher("/affichagesAbsences.jsp").forward(request, response);
				 

				/*List<Absence> listeAbs=Iabsence.getAllAbsencets();
				//List<Absence> listeStag=Iabsence.getAllAbsencets();
				request.setAttribute("liste",listeAbs);
				this.getServletContext().getRequestDispatcher("/affichagesAbsences.jsp").forward(request, response);
		*/
			}
			
		
		
		
		doGet(request, response);
	}

}
