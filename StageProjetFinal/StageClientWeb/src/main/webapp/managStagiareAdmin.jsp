<!DOCTYPE html>
<html lang="en">

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
 <%@ include file="menu.jsp" %>
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
              <span class="fs-4">AminDRH</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
              <li class="nav-item">
                <a href="DashboardAdmin.jsp" class="nav-link text-white" aria-current="page">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="dashbordAdmin.html"/></svg>
                  Dashboard
                </a>
              </li>
              <li>
                <a href="managStagiareAdmin.jsp" class="nav-link active">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="gestionStagairesAdmin"/></svg>
                  Gestion stagaires
                </a>
              </li>
              <li>
                <a href="managStagesAdmin.jsp" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                  gestion des Stages
                </a>
              </li>
              <li>
                <a href="attestation.jsp" class="nav-link text-white">
                  <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
                  Attestation
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
        <h2>Liste des Stagiaires</h2>
      </div>
                      <!-- Bouton de recherche -->
                       <div class="form-group">
                         <form action="SearchStagiaire" method="POST">
                          <br><br>
                        
                          <input type="text" class="form-control" name="searchInput" placeholder="Entrez le nom ou CIN">
                          <input type="hidden" name="admin" value="true">
                          <button type="submit" class="btn btn-primary mb-3">Rechercher</button>
                         </form>
                      </div>
                      
                       <br> <br>
                      <form action="AfficherStagiaires" method="POST">
		
							<div class="col-lg-5">
											  <button type="submit" class="btn btn-primary">
											    <i class="bi bi-arrow-clockwise"></i> Refresh List Stagaires
											  </button>
											  <input type="hidden" name="admin" value="true"/>
											</div>

													</form>
                      <!-- Tableau des stagiaires -->
                         <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>CIN</th>
                    <th>Établissement</th>
                    <th>Filière</th>
                    <th>Adresse</th>
                    <th>Email</th>
                    <th>Téléphone</th>
                    <th>Date de Naissance</th>
                    
                </tr>
            </thead>
            <tbody>
                <!-- Exemples de données de stagiaires -->
                <c:forEach var="stagiaire" items="${stagiaires}">
                    <tr>
                        <td><c:out value="${stagiaire.id_stagiaire}" /></td>
                        <td><c:out value="${stagiaire.prenom}" /></td>
                        <td><c:out value="${stagiaire.nom}" /></td>
                        <td><c:out value="${stagiaire.cin}" /></td>
                        <td><c:out value="${stagiaire.etablissment}" /></td>
                        <td><c:out value="${stagiaire.filiere}" /></td>
                        <td><c:out value="${stagiaire.adresse}" /></td>
                        <td><c:out value="${stagiaire.email}" /></td>
                        <td><c:out value="${stagiaire.telephone}" /></td>
                        <td><fmt:formatDate value="${stagiaire.dateN}" pattern="dd/MM/yyyy" /></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
   
  

      

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
