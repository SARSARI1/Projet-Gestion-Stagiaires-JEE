package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Stage;
import com.entities.Stagiaire;
import com.session.IStageLocal;
import com.session.IStagiaireLocal;

/**
 * Servlet implementation class AfficherStages
 */
@WebServlet("/AfficherStages")
public class AfficherStages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    IStageLocal istage;
    public AfficherStages() {
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
		List<Stage> stages = new ArrayList<>();
		stages=istage.getAllStages();
		request.setAttribute("stages",stages);
		if (request.getParameter("admin") == null) {
		this.getServletContext().getRequestDispatcher("/gestionStagesChef.jsp").forward(request, response);	
		}
		else
		{
			this.getServletContext().getRequestDispatcher("/managStagesAdmin.jsp").forward(request, response);	
		}
	
		
		if(request.getParameter("modifier")!=null) {
			
			
			 try {
		            int stageId = Integer.parseInt(request.getParameter("stageid"));
		            Stage stage = istage.getStage(stageId);

		            // Check if  stage  exists
		            if (stage != null) {
		              
		                String sujet = request.getParameter("sujet");
		                if (sujet != null && !sujet.isEmpty()) {
		                    stage.setSujet(sujet);
		                }

		                String dateDebutStr = request.getParameter("dateDebut");
		                if (dateDebutStr != null && !dateDebutStr.isEmpty()) {
		                    stage.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutStr));
		                }

		                String dateFinStr = request.getParameter("dateFin");
		                if (dateFinStr != null && !dateFinStr.isEmpty()) {
		                    stage.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(dateFinStr));
		                }

		                String division = request.getParameter("division");
		                if (division != null && !division.isEmpty()) {
		                    stage.setDivision(division);
		                }

		                String type = request.getParameter("type");
		                if (type != null && !type.isEmpty()) {
		                    stage.setType(type);
		                }

		               
		                istage.UpdateStage(stage);
		                response.sendRedirect(request.getContextPath() + "/gestionStagesChef.jsp");
		            } else {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Stage not found with ID: " + stageId);
		            }
		        } catch (NumberFormatException | ParseException e) {
		            e.printStackTrace();
		            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
		        } catch (Exception e) {
		            e.printStackTrace();
		            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating Stage in the database.");
		        }
		    }
		}
	}


