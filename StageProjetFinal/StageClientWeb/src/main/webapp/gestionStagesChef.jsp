
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>about</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>

<body>
     <!-- Navbar Start -->
<nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
<a href="index.html" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
<h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>Pro-Intern</h2>
</a>
<button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
<span class="navbar-toggler-icon"></span>
</button>
<div class="collapse navbar-collapse" id="navbarCollapse">
<div class="navbar-nav ms-auto p-4 p-lg-0">
    <a href="dashbordAdmin.html" class="nav-item nav-link active">Accueil</a>
    <a href="about.html" class="nav-item nav-link">À propos</a>
    <a href="stages.html" class="nav-item nav-link">Stages</a>
    <div class="nav-item dropdown">
        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
        <div class="dropdown-menu fade-down m-0">
            <a href="team.html" class="dropdown-item">Notre Équipe</a>
            <a href="testimonial.html" class="dropdown-item">Témoignages</a>
            <a href="404.html" class="dropdown-item">Page 404</a>
        </div>
    </div>
    <a href="contact.html" class="nav-item nav-link">Contact</a>
</div>
<!-- Bouton "Rejoignez-nous" mis à jour avec un déclencheur de modal -->
<button type="button" class="btn btn-primary py-2 px-4 d-none d-lg-block" data-bs-toggle="modal" data-bs-target="#joinNowModal">Rejoignez-nous <i class="fa fa-arrow-right ms-3"></i></button>
</div>
</nav>
<!-- Navbar End -->



    <div class="container-xxl position-relative bg-white d-flex p-0">
       <!-- Spinner Start -->
                <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <!-- Spinner End -->
                
        <!-- Sidebar Start -->
        <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
              <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
              <span class="fs-4">ChefDRH</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
              <li class="nav-item">
                <a href="dashboardChef.jsp" class="nav-link text-white" aria-current="page">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="dashbordAdmin.html"/></svg>
                  Dashboard
                </a>
              </li>
              <li>
                <a href="gestionStagiaireChef.jsp" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="gestionStagairesAdmin"/></svg>
                  Gestion stagaires
                </a>
              </li>
              <li>
                <a href="gestionEncadrantsChef.jsp" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="#"/></svg>
                  Gestion des encadrants
                </a>
              </li>
              <li>
                <a href="gestionStagesChef.jsp" class="nav-link active">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                  gestion des Stages
                </a>
              </li>
             
              <li>
                <a href="login.jsp" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                  se deconnecter
                </a>
              </li>
            </ul>
            <hr>
            
          </div>
        <!-- Sidebar End -->

 <!-- Content Start -->
        
 <div class="container-xxl py-5">
  <div class="container">
      <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
        <h2>Liste des Stages</h2>
      </div>
                      <!-- Bouton de recherche -->
                      <div class="form-group">
                         <form action="SearchStage" method="POST">
                          <br><br>
                        
                          <input type="text" class="form-control" name="searchInput" placeholder="Entrez le sujet">
                          <button type="submit" class="btn btn-primary mb-3">Rechercher</button>
                          
                         </form>
                      </div>
                      
                      
                        <div class="btn-group">
                            <button type="button" class="btn btn-success mb-3" data-bs-toggle="modal" data-bs-target="#ajouterModal">Ajouter</button>
                        </div>
                        <button class="btn btn-warning mb-3" data-bs-toggle="modal" data-bs-target="#modifyStageeModal">Modifier</button>
                        <!-- controle d absence -->
                        <form  method='post' action='affectStages'>
                                    <button type="submit" class="btn btn-primary">Affecter</button>
						 </form>			     
											  
                            
                    
                                        
                               
                       <br> <br>
                      <form action="AfficherStages" method="POST">
		
							<div class="col-lg-5">
											  <button type="submit" class="btn btn-primary">
											    <i class="bi bi-arrow-clockwise"></i> Refresh List Stages
											  </button>
											
											</div>

													</form>
    
          <form action="AddDELETStage" method="POST">
        <table class="table">
            <thead>
                <tr>
                    <th>ID ${idS}</th>
                    <th>Sujet</th>
                    <th>Date de Début</th>
                    <th>Date de Fin</th>
                    <th>Division</th>
                    <th>Type</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Exemples de données de stagiaires -->
               <c:forEach var="stage" items="${stages}">
                    <tr>
                        <td>${stage.id_stage}</td>
                        <td>${stage.sujet}</td>
                        <td>${stage.dateDebut}</td>
                        <td>${stage.dateFin}</td>
                        <td>${stage.division}</td>
                        <td>${stage.type}</td>
                            <td>
                        <button type="submit" class="btn btn-danger btn-sm" name="stageId" value="${stage.id_stage}" onclick="return confirm('Are you sure you want to delete this Stage?')">Supprimer</button>
                                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
   
		 </form>
		 
		   <form action="AjouterStages" method="POST">
                          <!-- Ajouter Modal -->
<div class="modal fade" id="ajouterModal" tabindex="-1" role="dialog" aria-labelledby="ajouterModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ajouterModalLabel">Ajouter Stage</h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Fermer">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Form for adding a new stage -->
                
                    <div class="form-group">
                        <label for="sujet">Sujet</label>
                        <input type="text" class="form-control" name="sujet" placeholder="Entrer  sujet">
                    </div>
                    <div class="form-group">
                        <label for="dateDebut">Date Début</label>
                        <input type="date" class="form-control" name="dateDebut" placeholder="Entrer date de début">
                    </div>
                    <div class="form-group">
                        <label for="dateFin">Date Fin</label>
                        <input type="date" class="form-control" name="dateFin" placeholder="Entrer date de fin">
                    </div>
                    <div class="form-group">
                        <label for="division">Division</label>
                        <input type="text" class="form-control" name="division" placeholder="Entrer  division">
                    </div>
                    <div class="form-group">
                        <label for="type">Type</label>
                        <input type="text" class="form-control" name="type" placeholder="Entrer type">
                    </div>
                   
                    <div class="modal-footer">
                                 
                       <button type="submit" class="btn btn-primary">Ajouter</button>
                       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                            
                    </div>
                    
                
            </div>
        </div>
    </div>
</div>

</form>
        <!-- Modifier Modal -->
        
        
         <form action="AfficherStages" method="POST">
           <div class="modal fade" id="modifyStageeModal" tabindex="-1" role="dialog" aria-labelledby="#modifyStageeModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ajouterModalLabel">Modifier Stage</h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Fermer">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Form for adding a new stage -->
                
                    <div class="form-group">
                        <label for="department" class="form-label">Sélectionnez Stage :</label>
                                        <select id="stage" name="stageid" class="form-select">
                                 <c:forEach items="${stages}" var="stage">
                       
                                        <option value="${stage.id_stage}">${stage.sujet}</option>
                                  </c:forEach>
                        
                               </select>
                    </div>
                    <div class="form-group">
                        <label for="dateDebut">Sujet</label>
                        <input type="text" class="form-control" name="sujet" placeholder="Entrer le sujet">
                    </div>
                    <div class="form-group">
                        <label for="dateDebut">Date Début</label>
                        <input type="date" class="form-control" name="dateDebut" placeholder="Entrer date de début">
                    </div>
                    
                    <div class="form-group">
                        <label for="dateFin">Date Fin</label>
                        <input type="date" class="form-control" name="dateFin" placeholder="Entrer date de fin">
                    </div>
                    <div class="form-group">
                        <label for="division">Division</label>
                        <input type="text" class="form-control" name="division" placeholder="Entrer  division">
                    </div>
                    <div class="form-group">
                        <label for="type">Type</label>
                        <input type="text" class="form-control" name="type" placeholder="Entrer type">
                    </div>
                    
                    <div class="form-group">
                        <label for="periode">Période</label>
                        <input type="text" class="form-control" name="periode" placeholder="Entrer  période">
                    </div>

                    <div class="modal-footer">
                     <input type="hidden" name="modifier" value="true"/>
                      <button type="submit" class="btn btn-primary">Modifier</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                            
                        </div>
                
            </div>
        </div>
    </div>
</div>
 </form>
    
        <!-- Supprimer Modal -->
        <div class="modal fade" id="supprimerModal" tabindex="-1" role="dialog" aria-labelledby="supprimerModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="supprimerModalLabel">Confirmer la Suppression</h5>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Fermer">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Êtes-vous sûr de vouloir supprimer ce stage ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                        <button type="button" class="btn btn-danger">Supprimer</button>
                    </div>
                </div>
            </div>
        </div>
  

                            
  
  
                          

                        

                    </div>
                </div>
                        



       






            


   


<!-- Ajoutez le CDN de Bootstrap JS ici -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-e3ZlRnJ2lC3UqF5tGuTzodjx8XK+QuUJWA2zNb9N/6O5Jw8S3av57I5XkrBpYQo9" crossorigin="anonymous"></script>






        
      







    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>
    