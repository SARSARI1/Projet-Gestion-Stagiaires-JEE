<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Absences</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-8 offset-md-2">
<hr/>           
<h2 class="text-center">Liste des Absences </h2>
<br/><br/>
             <h5><font color="red"> <c:out value ="${message}" default=""/></font></h5>
            <table class="table">
                <thead>
                    <tr>
                        <th>identifiant</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>CIN</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                <tbody>
                
                    <c:forEach items="${groupedAbsences}" var="entry">
          <tr>
        <td><strong>${entry.key}</strong></td>
        </tr>
        <tr>
             <c:forEach items="${entry.value}" var="absence">
            <td>${absence.id_abs}</td>
            <td>${absence.stagiaire.nom}</td>
            <td>${absence.stagiaire.prenom}</td>
             <td>${absence.stagiaire.cin}</td>
             <td>
                   <c:url value="/deleteAbs"  var="delete">
   <c:param name="code" value="${absence.id_abs}"/>
   </c:url>
   <a href="${delete}" >
   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
  <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
</svg></a>
                            </td>
                           
                        </tr>
                           
                    </c:forEach>
      </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>