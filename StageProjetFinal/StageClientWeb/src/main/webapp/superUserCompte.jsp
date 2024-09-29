<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tailwind Admin Starter Template : Tailwind Toolbox</title>
    <meta name="description" content="Tailwind CSS Starter template - Admin theme, dashboard, or web application UI!">
    <meta name="keywords" content="tailwind,tailwindcss,tailwind css,css,starter template,free template,fixed header, admin starter template, admin template, admin console, example">
    
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,700,800" rel="stylesheet">
	<link rel="apple-touch-icon" sizes="180x180" href="../apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="../favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="../favicon-16x16.png">
	<link rel="manifest" href="../site.webmanifest">
	<link rel="mask-icon" href="../safari-pinned-tab.svg" color="#5bbad5">
	<meta name="msapplication-TileColor" content="#00aba9">
	<meta name="theme-color" content="#3b7977">

	<!-- Primary Meta Tags -->
	<title>comptes</title>
	<meta name="title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
	<meta name="description" content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">

	<!-- Open Graph / Facebook -->
	<meta property="og:type" content="website">
	<meta property="og:url" content="https://www.tailwindtoolbox.com/">
	<meta property="og:title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
	<meta property="og:description" content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">
	<meta property="og:image" content="https://www.tailwindtoolbox.com/social.png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/css/bootstrap.min.css"
    integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyYq9vIQI2ucSn6a03SksMEq5CEbYlOoSd"
    crossorigin="anonymous">
	<!-- Twitter -->
	<meta property="twitter:card" content="summary_large_image">
	<meta property="twitter:url" content="https://www.tailwindtoolbox.com/">
	<meta property="twitter:title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
	<meta property="twitter:description" content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">
	<meta property="twitter:image" content="https://www.tailwindtoolbox.com/social.png">

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Include Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css" rel=" stylesheet">
    <!--Replace with your tailwind.css once created-->
    <link href="https://afeld.github.io/emoji-css/emoji.css" rel="stylesheet">
    <!--Totally optional :) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js" integrity="sha256-XF29CBwU1MWLaGEnsELogU6Y6rcc5nCkhhx89nFMIDQ=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js" integrity="sha256-XF29CBwU1MWLaGEnsELogU6Y6rcc5nCkhhx89nFMIDQ=" crossorigin="anonymous"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>


<body class="bg-gray-800 font-sans leading-normal tracking-normal mt-12">

     <!--Nav-->
     <nav class="bg-gray-800 pt-2 md:pt-1 pb-1 px-1 mt-0 h-auto fixed w-full z-20 top-0">

        <div class="flex w-full pt-2">
            <div class="md:w-1/3 md:mr-3">
                <div class="flex items-center">
                    <a href="superUserDashbord.jsp" class="pr-2 text-white">
                        <i class="fas fa-user"></i>
                    </a>
                    <span class="text-white">Super User</span>
                </div>
            </div>
            
           
        </div>

    </nav>

    <div class="flex flex-col md:flex-row">

        <div class="bg-gray-800 shadow-xl h-auto mt-20 fixed bottom-0 md:relative md:h-screen z-10 w-full md:w-48 mr-4">
            <div class="md:mt-12 md:w-48 md:fixed md:left-0 md:top-0 content-center md:content-start text-left justify-between">
                <ul class="list-reset py-0 md:py-3 px-1 md:px-2 text-center md:text-left">
                    <li class="flex-1">
                        <a href="superUserArchive.jsp" class="block py-1 md:py-3 pl-1 align-middle text-white no-underline hover:text-white border-b-2 border-gray-800 hover:border-pink-500">
                            <i class="fas fa-folder-open pr-0 md:pr-3"></i>
                            <span class="pb-1 md:pb-0 text-xs md:text-base text-gray-600 md:text-gray-400 block md:inline-block">Archive des Stagiaires</span>
                        </a>
                    </li>
                </ul>
                
                <ul class="list-reset py-0 md:py-3 px-1 md:px-2 text-center md:text-left">
                    <li class="flex-1">
                        <a href="superUserCompte.jsp" class="block py-1 md:py-3 pl-1 align-middle text-white no-underline hover:text-white border-b-2 border-gray-800 hover:border-purple-500">
                            <i class="fa fa-user-cog pr-0 md:pr-3"></i>
                            <span class="pb-1 md:pb-0 text-xs md:text-base text-gray-600 md:text-gray-400 block md:inline-block">Gestion des Comptes</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        
        

        <div class="main-content flex-1 bg-gray-100 mt-12 md:mt-2 pb-24 md:pb-5">

          

            <div class="bg-gray-800 pt-3">
               
                <div class="rounded-tl-3xl bg-gradient-to-r from-blue-900 to-gray-800 p-4 shadow text-2xl text-white">
                    <h3 class="font-bold pl-2">Cree compte</h3>
                    <form action="CreateCompteServlet" method="post">
                        <div class="form-group">
                            <label for="login">Login:</label>
                            <input type="text" class="form-control" id="login" name="login" required>
                        </div>
            
                        <div class="form-group">
                            <label for="passwd">Password:</label>
                            <input type="password" class="form-control" id="passwd" name="passwd" required>
                        </div>
            
                        <div class="form-group">
                            <label for="type">Type:</label>
                            <select class="form-control" id="type" name="type" required>
                                <option value="AdminRH">Admin DRH</option>
                                <option value="ChefRH">Chef DRH</option>
                               
                            </select>
                        </div>
            
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form>
                </div>
                
                
                <form action="ListComptesServlet" method="post">
                    <button type="submit" class="btn btn-primary mb-3">
                        <i class="fas fa-sync-alt"></i> Refresh
                    </button>
                </form>

            </div>
            
            
            
            <div class="flex flex-wrap">
                
                
                <table class="table table-bordered mt-3">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Login</th>
                            <th>Password</th>
                            <th>Type</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="compte" items="${comptes}">
                            <tr>
                                <td>${compte.id_compte}</td>
                                <td>${compte.login}</td>
                                <td>${compte.passwd}</td>
                                <td>${compte.type}</td>
                                <td>
                                    <form action="DeleteCompteServlet" method="post">
                                        <input type="hidden" name="compteId" value="${compte.id_compte}">
                                        <button type="submit" class="btn btn-danger btn-sm"
                                                onclick="return confirm('Are you sure you want to delete this compte?')">
                                            Delete
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                

            </div>
           
               

               

            </div>
        </div>
    

   





    <script>
        /*Toggle dropdown list*/
        function toggleDD(myDropMenu) {
            document.getElementById(myDropMenu).classList.toggle("invisible");
        }
        /*Filter dropdown options*/
        function filterDD(myDropMenu, myDropMenuSearch) {
            var input, filter, ul, li, a, i;
            input = document.getElementById(myDropMenuSearch);
            filter = input.value.toUpperCase();
            div = document.getElementById(myDropMenu);
            a = div.getElementsByTagName("a");
            for (i = 0; i < a.length; i++) {
                if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
                    a[i].style.display = "";
                } else {
                    a[i].style.display = "none";
                }
            }
        }
        // Close the dropdown menu if the user clicks outside of it
        window.onclick = function(event) {
            if (!event.target.matches('.drop-button') && !event.target.matches('.drop-search')) {
                var dropdowns = document.getElementsByClassName("dropdownlist");
                for (var i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (!openDropdown.classList.contains('invisible')) {
                        openDropdown.classList.add('invisible');
                    }
                }
            }
        }
    </script>
<!-- Add your Bootstrap and Popper.js scripts here -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"
integrity="sha384-L8bpoPQnRE8BqjsOQpdKjc2eFbMKOpE1nw4JxMl58R79UXXyPm0frl5yI8iBaccS"
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"
integrity="sha384-Rr7MlUzBqBsXFA2gzgx2OOisk4QPe+SGkt5fQ35AWB8jq8qxCz1PbGoLZVtA"
crossorigin="anonymous"></script>

</body>

</html>