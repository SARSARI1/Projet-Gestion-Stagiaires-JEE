<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
   <link href="css/style.css" rel="stylesheet">
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>
<body>

                <div class="container-xxl py-5">
                    <div class="container">
                        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                            <h2>Liste des absences</h2>
                        </div>
                        <form method='post' action='absence'> 
                        <font color="red">  <u> ${message}</u></font>
                        </form>
                        <hr/>
                         <form method='post' action='absence'> 
                         <input type="hidden" name="afficher" value="true">
                        <button type="submit" class="btn btn-info btn-sm">Afficher les absences</button>
                         </form> 
                        </div>
                        

<div  tabindex="-1" role="dialog" aria-hidden="true">
       <form method='post' action='absence'>      
            <div class="modal-body">
            
                <p><strong>Date du jour: ${currentDate}</strong></p>
                <!-- Table to display interns and confirm absence -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Confirmer Absence</th>
                            
                        </tr>
                    </thead>
                    
                    <tbody>
                    <c:forEach items="${liste}" var="liste">
                       
   
                        
                        <!-- Example intern row with checkbox -->
                        <tr>
                            <td>${liste.id_stagiaire}</td>
                            <td>${liste.nom}</td>
                            <td>${liste.prenom}</td>
                            <td>
                                <input type="checkbox" class="form-check-input"  name="id" value="${liste.id_stagiaire}">
                            </td>
                        </tr>
                        </c:forEach>
                        <!-- ... (other intern rows) ... -->
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
               
                        <button type="submit" class="btn btn-info btn-sm">Enregistrer les absences</button>
               
            </div>
            </form>
        </div>
        </div>
        </div>
</body>
</html>