package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class AfficherStagiaires
 */
@WebServlet("/AfficherStagiaires")
public class AfficherStagiaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @EJB
     IStagiaireLocal istagiaire;
    public AfficherStagiaires() {
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
		
		if (request.getParameter("admin") == null) {
			this.getServletContext().getRequestDispatcher("/gestionStagiaireChef.jsp").forward(request, response);	
			}
			else
			{
				this.getServletContext().getRequestDispatcher("/managStagiareAdmin.jsp").forward(request, response);	
			}
		
		
		
		if(request.getParameter("modifier")!=null) {
			
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String cin = request.getParameter("cin");
            String etablissement = request.getParameter("etablissement");
            String filiere = request.getParameter("filiere");
            String adresse = request.getParameter("adresse");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String date_naissance = request.getParameter("date_naissance");
           

            Stagiaire stagiaire = istagiaire.getStagiaire(id);

          
            if (nom != null && !nom.isEmpty()) {
                stagiaire.setNom(nom);
            }

            if (prenom != null && !prenom.isEmpty()) {
                stagiaire.setPrenom(prenom);
            }

            if (cin != null && !cin.isEmpty()) {
                stagiaire.setCin(cin);
            }

            if (etablissement != null && !etablissement.isEmpty()) {
                stagiaire.setEtablissment(etablissement);
            }

            if (filiere != null && !filiere.isEmpty()) {
                stagiaire.setFiliere(filiere);
            }

            if (adresse != null && !adresse.isEmpty()) {
                stagiaire.setAdresse(adresse);
            }

            if (email != null && !email.isEmpty()) {
                stagiaire.setEmail(email);
            }

            if (telephone != null && !telephone.isEmpty()) {
                stagiaire.setTelephone(telephone);
            }

            if (date_naissance != null && !date_naissance.isEmpty()) {
            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            	Date parsedDate;
				try {
					parsedDate = dateFormat.parse(date_naissance);
					stagiaire.setDateN(new java.sql.Date(parsedDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 
            	
            }
          
            
            // Assuming that dateN is the attribute in Stagiaire to store the Date object
           
          
           
            istagiaire.UpdateStagiaire(stagiaire);
            response.sendRedirect(request.getContextPath() + "/gestionStagiaireChef.jsp");
            
	}

            // Redirect back to the page (you can change the URL)
           
	}

}
