

        <html lang="en">
        
        <head>
            <meta charset="utf-8">
            <title>about</title>
            <meta content="width=device-width, initial-scale=1.0" name="viewport">
            <meta content="" name="keywords">
            <meta content="" name="description">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        
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
   <%@ include file="menu.jsp" %>
<!-- Navbar End -->

<!-- Modal Rejoignez-nous optionnel -->

            <div class="container-xxl position-relative bg-white d-flex p-0">
                <!-- Spinner Start -->
                <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <!-- Spinner End -->
        
        
                <!-- Sidebar Start -->
                  <%@ include file="sideBarAdmin.jsp" %>
                <!-- Sidebar End -->
        
        
                <!-- Content Start -->
                <div class="content">
<!-- Statistiques D�but -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title bg-white text-center text-primary px-3">Statistiques</h6>
            <h1 class="mb-5"><i class="fa fa-graduation-cap me-3 text-primary"></i>Aper�u du Programme de Stages</h1>
        </div>

        <!-- Ajouter un formulaire pour s�lectionner un d�partement -->
        <div class="row">
      
            
                <div class="col-md-6">
                  <form id="departmentForm" class="form-group" method='post' action='DashboardAdmin'>
                    <label for="department" class="form-label">S�lectionnez le D�partement: ${dep}</label>
                    <select id="department" name="deprtid" class="form-select" onchange="this.form.submit()">
                        <!-- Ajouter des options dynamiquement en fonction de vos d�partements -->
                        <option value="a">Tous les D�partements</option>
                        <c:forEach items="${liste}" var="liste">
                       
                        
                       
                        <option value="${liste.nom}">${liste.nom}</option>
                    
                        
   
                         </c:forEach>
                        
                    </select>
                    </form>
                </div>
                 
                
               
                
            </div>
       

        
    </div>
</div>
<!-- Statistiques Fin -->

<form method='post' action='DashboardAdmin'>
<button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-6 col-xl-3 col-sm-6" type="submit">Afficher les Statistiques</button>
<div class="container-fluid pt-4 px-4">
    <div class="row">
        <div class="col-md-4">
            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                <i class="fas fa-users fa-3x text-primary"></i>
                <div class="ms-3">
                    <p class="mb-2">Stagiaires</p>
                    <h6 class="mb-0">${nbrStagiaires}</h6>
                   <h6 class="mb-0"> ${nouveau} ${stagiaresNouveau}</h6>
                    <h6 class="mb-0">${encours} ${stagiaresEncourt}</h6>
                    <h6 class="mb-0">${archive} ${stagiaresArchive}</h6>
                    
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                <i class="fas fa-briefcase fa-3x text-primary"></i>
                <div class="ms-3">
                    <p class="mb-2">Stages</p>
                    <h6 class="mb-0">${nbrStages}</h6>
                    <div class="ms-3">
                   <h6 class="mb-0"> ${affecte} ${stagesAffectes}	</h6>
				    <h6 class="mb-0">${nonaffecte} ${stagesNonAffectes}</h6>
				   </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                <i class="fas fa-chalkboard-teacher fa-3x text-primary"></i>
                <div class="ms-3">
                    <p class="mb-2">Encadrants</p>
                    
                    <h6 class="mb-0">${nbrEncadrants}</h6>
                     <h6 class="mb-0">${Eaffecte} ${encadrantAffectes}	</h6>
				     <h6 >${Enonaffecte} ${encadrantNonAffectes}</h6>
                    
                   
                </div>
                
            </div>
        </div>
    </div>
    
</div>
</form>
</div>
</div>
<!--stistiques Fin -->



        
                    
        
        
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