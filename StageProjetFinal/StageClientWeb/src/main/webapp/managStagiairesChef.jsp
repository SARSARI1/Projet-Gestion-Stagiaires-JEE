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
        <a href="gestionStagairesChef.html" class="nav-link active">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="gestionStagairesAdmin"/></svg>
          Gestion stagaires
        </a>
      </li>
      <li>
        <a href="gestionEncadrantsChef.html" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#"/></svg>
          Gestion des encadrants
        </a>
      </li>
      <li>
        <a href="gestionStagesChef.html" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
          gestion des Stages
        </a>
      </li>
      
      <li>
        <a href="prametresChef.html" class="nav-link text-white">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
          Parametres
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
                            <label for="searchInput">Rechercher par Nom ou Prénom :</label>
                            <input type="text" class="form-control" id="searchInput" placeholder="Entrez le nom ou prénom">
                        </div>
                        <button type="button" class="btn btn-primary mb-3">Rechercher</button>
                        
                        <!-- Boutons Ajouter -->
                        <div class="btn-group">
                            <button type="button" class="btn btn-success mb-3" data-bs-toggle="modal" data-bs-target="#addStagiaireModal">Ajouter</button>
                        </div>
                        <!-- controle d absence -->
                        <form method='post' action='managStagiAdmin'>
                        <button type="submit" class="btn btn-info btn-sm">Contrôler Absence</button>
                        </form>
                        <!-- Tableau des stagiaires -->
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nom</th>
                                    <th>Prénom</th>
                                    <th>CIN</th>
                                    <th>Établissement</th>
                                    <th>Filière</th>
                                    <th>Adresse</th>
                                    <th>Email</th>
                                    <th>Téléphone</th>
                                    <th>Date de Naissance</th>
                                    <th>État</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Sample Stagiaire data -->
                                <tr>
                                    <td>1</td>
                                    <td>John</td>
                                    <td>Doe</td>
                                    <td>123456789</td>
                                    <td>Université XYZ</td>
                                    <td>Informatique</td>
                                    <td>123 Rue ABC</td>
                                    <td>john.doe@example.com</td>
                                    <td>1234567890</td>
                                    <td>1990-01-01</td>
                                    <td>Actif</td>
                                    <td>
                                        <button class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#modifyStagiaireModal">Modifier</button>
                                    </td>
                                    <td>
                                        <button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteStagiaireModal">Supprimer</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jane</td>
                                    <td>Smith</td>
                                    <td>987654321</td>
                                    <td>École ABC</td>
                                    <td>Ingénierie</td>
                                    <td>456 Rue XYZ</td>
                                    <td>jane.smith@example.com</td>
                                    <td>9876543210</td>
                                    <td>1995-05-05</td>
                                    <td>Inactif</td>
                                    <td>
                                        <button class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#modifyStagiaireModal">Modifier</button>
                                    </td>
                                    <td>
                                        <button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteStagiaireModal">Supprimer</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Michael</td>
                                    <td>Jackson</td>
                                    <td>555555555</td>
                                    <td>College XYZ</td>
                                    <td>Music</td>
                                    <td>789 Broadway</td>
                                    <td>michael.jackson@example.com</td>
                                    <td>5555555555</td>
                                    <td>1958-08-29</td>
                                    <td>Actif</td>
                                    <td>
                                        <button class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#modifyStagiaireModal">Modifier</button>
                                    </td>
                                    <td>
                                        <button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteStagiaireModal">Supprimer</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    

                        <!-- Formulaires de modification de stagiaire -->
                        <div class="modal fade" id="modifyStagiaireModal" tabindex="-1" role="dialog" aria-labelledby="modifyStagiaireModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="modifyStagiaireModalLabel">Modifier Stagiaire</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fermer"></button>
                                    </div>
                                    <div class="modal-body">
                                        <!-- Add your Stagiaire modification form content here -->
                                        <form>
                                            <!-- Your form fields for modifying a Stagiaire -->
                                            <div class="form-group">
                                                <label for="nomModifier">Nom à modifier :</label>
                                                <input type="text" class="form-control" id="nomModifier" placeholder="Entrez le nouveau nom">
                                            </div>
                                            <div class="form-group">
                                                <label for="prenomModifier">Prénom à modifier :</label>
                                                <input type="text" class="form-control" id="prenomModifier" placeholder="Entrez le nouveau prénom">
                                            </div>
                                            <!-- Add more fields as needed -->

                                            <button type="submit" class="btn btn-primary">Enregistrer les modifications</button>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                                    </div>
                                </div>
                            </div>
                        </div>





                            <!-- Modal ajouter stagiaire -->
                            <div class="modal fade" id="addStagiaireModal" tabindex="-1" role="dialog" aria-labelledby="addStagiaireModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="addStagiaireModalLabel">Ajouter Stagiaire</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fermer"></button>
                                        </div>
                            <div class="modal-body">
                                <!-- Add your Stagiaire addition form content here -->
                                <form>
                                
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="id">ID</label>
                                                    <input type="text" class="form-control" id="id" placeholder="Entrez l'ID">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="nom">Nom</label>
                                                    <input type="text" class="form-control" id="nom" placeholder="Entrez le nom">
                                                </div>
                                            </div>
                                        </div>
                                
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="prenom">Prénom</label>
                                                    <input type="text" class="form-control" id="prenom" placeholder="Entrez le prénom">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="cin">CIN</label>
                                                    <input type="text" class="form-control" id="cin" placeholder="Entrez le CIN">
                                                </div>
                                            </div>
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="etablissement">Établissement</label>
                                            <input type="text" class="form-control" id="etablissement" placeholder="Entrez l'établissement">
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="filiere">Filière</label>
                                            <input type="text" class="form-control" id="filiere" placeholder="Entrez la filière">
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="adresse">Adresse</label>
                                            <input type="text" class="form-control" id="adresse" placeholder="Entrez l'adresse">
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="email" class="form-control" id="email" placeholder="Entrez l'email">
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="telephone">Téléphone</label>
                                            <input type="tel" class="form-control" id="telephone" placeholder="Entrez le téléphone">
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="date_naissance">Date de Naissance</label>
                                            <input type="date" class="form-control" id="date_naissance">
                                        </div>
                                
                                        <div class="form-group">
                                            <label for="etat">État</label>
                                            <input type="text" class="form-control" id="etat" placeholder="Entrez l'état">
                                        </div>

                                    <button type="submit" class="btn btn-primary">Ajouter</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                            </div>
                        </div>
                    </div>
                </div>

                        <!-- Formulaires de suppression de stagiaire -->
                        <div class="modal fade" id="deleteStagiaireModal" tabindex="-1" role="dialog" aria-labelledby="deleteStagiaireModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteStagiaireModalLabel">Supprimer Stagiaire</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fermer"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Êtes-vous sûr de vouloir supprimer ce stagiaire ?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                                        <form>
                                            <button type="button" class="btn btn-danger">Supprimer</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                            
  
  
                          

                        

                    </div>
                </div>
                        




            


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