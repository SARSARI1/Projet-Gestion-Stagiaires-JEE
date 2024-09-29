package servlets;

import java.io.IOException;
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
 * Servlet implementation class modifyStagiaire
 */
@WebServlet("/modifyStagiaire")
public class modifyStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    IStagiaireLocal stagiaireDao;
    public modifyStagiaire() {
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
		stagiaires=stagiaireDao.getAllStagiaires();
		request.setAttribute("stagiaires",stagiaires);
		
		
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
	           // String date_naissance = request.getParameter("date_naissance");
	           

	            Stagiaire stagiaire = stagiaireDao.getStagiaire(id);

	            // Check each parameter individually and update only if provided
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
/*
	            if (date_naissance != null && !date_naissance.isEmpty()) {
	            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            	Date parsedDate = dateFormat.parse(date_naissance);
	            	 stagiaire.setDateN(new java.sql.Date(parsedDate.getTime()));
	            	
	            }
	            */
	            
	            // Assuming that dateN is the attribute in Stagiaire to store the Date object
	           
	          
	           
	            stagiaireDao.UpdateStagiaire(stagiaire);
	            
		}

	            // Redirect back to the page (you can change the URL)
	            response.sendRedirect(request.getContextPath() + "/gestionStagiaireChef.jsp");
	       
		doGet(request, response);
}
}



