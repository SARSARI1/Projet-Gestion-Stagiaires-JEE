package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Stage;
import com.session.IStageLocal;


@WebServlet("/AjouterStages")
public class AjouterStages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	IStageLocal stageDao;
    public AjouterStages() {
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
		 try {
	            String sujet = request.getParameter("sujet");
	            
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            
	            Date dateDebut =  dateFormat.parse(request.getParameter("dateDebut"));
	            Date dateFin =  dateFormat.parse(request.getParameter("dateFin"));
	            String division = request.getParameter("division");
	            String type = request.getParameter("type");

	            Stage stage = new Stage();
	            stage.setSujet(sujet);
	            stage.setDateDebut(dateDebut);
	            stage.setDateFin(dateFin);
	            stage.setDivision(division);
	            stage.setType(type);
	            // Set initial state to non_affecte
	           

	            // Add Stage to the database
	            stageDao.AddStage(stage);

	            // Redirect back to the page (you can change the URL)
	            response.sendRedirect(request.getContextPath() + "/gestionStagesChef.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding Stage to the database.");
	        }
	    }
		
	}


