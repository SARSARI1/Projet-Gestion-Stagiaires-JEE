package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Stagiaire;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class AjouterStagiaires
 */
@WebServlet("/AjouterStagiaires")
public class AjouterStagiaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    IStagiaireLocal stagiaireDao;
    public AjouterStagiaires() {
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
		
            // Retrieve form parameters
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String cin = request.getParameter("cin");
            String etablissement = request.getParameter("etablissement");
            String filiere = request.getParameter("filiere");
            String adresse = request.getParameter("adresse");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String dateNaissanceStr = request.getParameter("date_naissance");

            // Convert date string to Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateNaissance = null;

                try {
					dateNaissance = dateFormat.parse(dateNaissanceStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          
           
            Stagiaire stagiaire = new Stagiaire();
            stagiaire.setNom(nom);
            stagiaire.setPrenom(prenom);
            stagiaire.setCin(cin);
            stagiaire.setEtablissment(etablissement);
            stagiaire.setFiliere(filiere);
            stagiaire.setAdresse(adresse);
            stagiaire.setEmail(email);
            stagiaire.setTelephone(telephone);
            stagiaire.setDateN(dateNaissance);

            
            stagiaireDao.AddStagiaire(stagiaire);

            // Redirect back to the page (you can change the URL)
            response.sendRedirect(request.getContextPath() + "/gestionStagiaireChef.jsp");
        
    
		doGet(request, response);
	
	}
	}
