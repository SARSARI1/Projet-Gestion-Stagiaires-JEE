package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Stage;
import com.entities.Stagiaire;
import com.session.IStagiaireLocal;

import java.awt.Color;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * Servlet implementation class GeneratePDFServlet
 */
@WebServlet("/GeneratePDFServlet")
public class GeneratePDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    IStagiaireLocal istagiaire;
	
    public GeneratePDFServlet() {
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
		if(request.getParameter("ref")!=null){
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires=istagiaire.getAllStagiaires();
		request.setAttribute("stagiaires",stagiaires);
	
		
		}
		 
		else {
		 response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=certificate.pdf");

	        try (OutputStream outputStream = response.getOutputStream()) {
	            PDDocument document = new PDDocument();
	            PDPage page = new PDPage();
	            document.addPage(page);

	            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
	            	
	                 
	            	 String searchInput = request.getParameter("id");
	            	 int idInt=Integer.parseInt(searchInput);
	                 if (searchInput != null && !searchInput.isEmpty()) {

	                     Stagiaire stagiaire = istagiaire.getStagiaire(idInt);

	                   
	                        

	                         // Get information about the corresponding stage
	                         Stage stage = stagiaire.getStage();

	                         // Set the information in the Stagiaire object
	                         String stagiaireNom = stagiaire.getNom();
	                         String stagiairePrenom = stagiaire.getPrenom();
	                         String stageSujet = stage.getSujet();
	                         String departement = stage.getDivision();
	                         String typestage=stage.getType();
	                        Date dateDebut = stage.getDateDebut();
	                         Date dateFin = stage.getDateFin();
	                        
	                         //Instant instantF = dateFin.toInstant();
	                         //Instant instantD = dateDebut.toInstant();
	                         
	                         //LocalDate localDateFin = instantF.atZone(ZoneId.systemDefault()).toLocalDate();
	                         //LocalDate localDateDebut = instantD.atZone(ZoneId.systemDefault()).toLocalDate();
	                      
	                         //Period period = Period.between(localDateDebut, localDateFin);
	                         //String periode = period.toString();
	                      // Logo and App Information
	                         //String contextPath = getServletContext().getRealPath("/");
	                        // String imagePath = contextPath + "img/logo.png";
	                         //PDImageXObject logoImage = PDImageXObject.createFromFile(imagePath, document);
	                         //float imageWidth = logoImage.getWidth();
	                         //float imageHeight = logoImage.getHeight();
	                        // float desiredWidth = 300;
	                         //float desiredHeight = 230;
	                         //float centerX = (page.getMediaBox().getWidth() - desiredWidth) / 2;
	                         //float centerY = (page.getMediaBox().getHeight() - desiredHeight) / 2;
	                        // contentStream.drawImage(logoImage, centerX, centerY, desiredWidth, desiredHeight);

	                         // Date and Time
	                         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	                         String currentDate = dateFormat.format(new Date());
	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);
	                         contentStream.setNonStrokingColor(Color.decode("#000000")); // Set text color
	                         contentStream.beginText();
	                         contentStream.newLineAtOffset(400, 770);
	                         contentStream.showText("Généré le : " + currentDate); // French text
	                         contentStream.endText();

	                         // Certificate Content
	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 30);
	                         contentStream.beginText();
	                         contentStream.setNonStrokingColor(Color.decode("#FF890A")); // Set text color
	                         contentStream.newLineAtOffset(100, 700);
	                         contentStream.showText("CERTIFICAT DE RÉALISATION");
	                         contentStream.endText();

	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
	                         contentStream.beginText();
	                         contentStream.setNonStrokingColor(Color.decode("#38b6ff")); // Set text color
	                         contentStream.newLineAtOffset(100, 650);
	                         contentStream.showText(stagiaireNom + " " + stagiairePrenom);
	                         contentStream.endText();

	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);
	                         contentStream.beginText();
	                         contentStream.setNonStrokingColor(Color.decode("#000000")); // Set text color
	                         contentStream.newLineAtOffset(100, 630);
	                         contentStream.showText("a réussi avec succès un stage dans le département de " + departement + ",");
	                         contentStream.endText();

	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);
	                         contentStream.beginText();
	                         contentStream.setNonStrokingColor(Color.decode("#000000")); // Set text color
	                         contentStream.newLineAtOffset(100, 610);
	                         contentStream.showText("travaillant sur le projet intitulé :");
	                         contentStream.endText();

	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
	                         contentStream.beginText();
	                         contentStream.setNonStrokingColor(Color.decode("#38b6ff")); // Set text color
	                         contentStream.newLineAtOffset(100, 590);
	                         contentStream.showText(stageSujet);
	                         contentStream.endText();

	                         contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);
	                         contentStream.beginText();
	                         contentStream.setNonStrokingColor(Color.decode("#000000")); // Set text color
	                         contentStream.newLineAtOffset(100, 560);
	                         
	                         contentStream.showText("Un stage "+ typestage +" a été effectué du " + 
	                         formatDate(dateDebut) + " au " + formatDate(dateFin) + ".");
	                         contentStream.endText();
	                         contentStream.close();
	                         document.save(outputStream);
	                         document.close();
	                         
	                         
	                     }
	                 }

	                        
	                        
	                        
	                    
	              

	               
	        

	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
	        }
	   

		}
	
	this.getServletContext().getRequestDispatcher("/attestation.jsp").forward(request, response);

}
	
	private String formatDate(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    return dateFormat.format(date);
		
	}
}


