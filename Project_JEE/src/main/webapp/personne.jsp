<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link href="css/index-styles.css" rel="stylesheet" />
<br>
<br>
<br>
<br>
</head>
<body>
<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.do">HOME </a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="classe.do">Classe</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="matiere.do">Matiere</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="personne.do">Utilisateurs</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="tirage.do">Tirage</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
							
					
				</ul>
			</div>
		</div>
	</nav>
<p></p>
<br>
<br>


<div class="container">
<div class="card">
  <div class="card-header">
  GESTION DES CLASSES	
  </div>
  <div class="card-body">
      <form action="chercherpersonne.do" method="get">
        <label>Mot Clé</label>
        <input type="text" name="motCle" value="${model.motCle}"/>
        <button type="submit" class="btn btn-primary">Chercher</button>
         <a  href="saisiepersonne.do" class="btn btn-primary">Ajouter Personne</a>
      </form>     
      <table class="table table-striped">
        <tr>
          <th>ID</th><th>Nom Personne</th><th>Prenom Personne</th><th>Login Personne</th> <th>Mot de passe Personne</th> <th>Type Personne</th><th>Suppression<th>Edition</th> 
         </tr>
        <c:forEach items="${model.personne}" var="c">  
           <tr>
              <td>${c.id }</td>
              <td>${c.nom }</td>
              <td>${c.prenom }</td>
              <td>${c.login }</td>
              <td>${c.mdp }</td>
              <td>${c.type }</td>
              
            

              <td><a onclick="return confirm('Etes-vous sur ?')" href="supprimerpersonne.do?id=${c.id}">Supprimer</a></td>
               <td><a href="editerpersonne.do?id=${c.id }">Edit</a></td>
           </tr>
         </c:forEach>       
      </table>
  </div>
</div>
</div>
</body>
</html>