<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Movie Cruiser</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
body {
	font-family: 'raleway', serif;
}
.colored-cell{
    background-color: #adadeb;
    backdrop-filter: blur(10px);
    border-radius: 5px;
    margin-bottom:3px;
}
.myfooter{
position:absolute;
left:0;
bottom:0;
width:100%;
text-align:center;
padding-left:20px;
}
.footer-copyright{
color:white;
}
.container{
     background-color: #d6d6f5; 
}
img{
    height: 48px;
    width: 50px;
    margin-top: 7px;
}

</style>
</head>
<body>
<jsp:useBean id="date" class="java.util.Date"/>
	<div class="border" style="margin: auto;">
		<nav class="navbar navbar-expand-sm navbar-dark"
			style="background-color: #0f0f3d;">
			<a class="navbar-brand" href="#">Movie Cruiser</a>
			<img src="https://png.pngtree.com/png-clipart/20190920/original/pngtree-film-film-decoration-illustration-png-image_4674079.jpg" alt="MovieCruiser">
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto" style="font-size: 20px;">
					<li class="nav-item"><a class="nav-link" href="/admin"><i
							class="fa fa-home">&nbsp;</i>Movie List</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout"><em
							class="fa fa-sign-out">&nbsp;</em>Logout</a></li>

			    </ul>
			</div>
		</nav>
		
		<div style="height:fit-content;" class="container-fluid">
			<div style="font-weight: bold;font-size:20px;margin-bottom:20px;margin-left:60px;margin-top:20px;">Movies List</div>
			<div class="container">
				<div class="row" style="font-weight: bold;">
					<div class="col-lg-2 col-md-4 col-sm-6">
						<span>Movie Name</span>
					</div>

					<div class="col-lg-2 col-md-4 col-sm-6">
						<span>Box Office</span>
					</div>

					<div class="col-lg-2 col-md-4 col-sm-6">
						<span>Active</span>
					</div>

					<div class="col-lg-2 col-md-4 col-sm-6">
						<span>Date of Launch</span>
					</div>

					<div class="col-lg-2 col-md-4 col-sm-6">
						<span>Genre</span>
					</div>

					<div class="col-lg-2 col-md-4 col-sm-6">
						<span>Action</span>
					</div>

				</div>
				
				<hr>
				
				<c:forEach items="${inf}" var="temp">
					<div class="row colored-cell">
						<div class="col-lg-2 col-md-4 col-sm-6">
							<span>${temp.title}</span>
						</div>

						<div class="col-lg-2 col-md-4 col-sm-6">
							<span>${temp.boxOffice}</span>
						</div>

						<div class="col-lg-2 col-md-4 col-sm-6">
                            <c:set var="active" value="${temp.active}" />
                            <c:choose>
                                <c:when test="${active}">
                                    <c:out value="Yes" />
                                </c:when>
                                <c:otherwise>
                                    <c:out value="No" />
                                </c:otherwise>
                            </c:choose>
                        </div>

						<div class="col-lg-2 col-md-4 col-sm-6">
							<span><fmt:formatDate value="${temp.dateOfLaunch}" type="date" pattern="dd-MMM-yyyy"/></span>
						</div>

						<div class="col-lg-2 col-md-4 col-sm-6">
							<span>${fn:toUpperCase(temp.genre)}</span>
						</div>

						<div class="col-lg-2 col-md-4 col-sm-6">
							<a href="edit?id=${temp.id}&title=${temp.title}&box=${temp.boxOffice}&dol=${temp.dateOfLaunch}&genre=${temp.genre}">Edit</a>
						</div>
						
					</div>
					
				</c:forEach>
				
			</div>
			
		</div>
		
		<footer class="page-footer myfooter"
			style="background-color: #0f0f3d; width: 100%;">
			<div class="footer-copyright text-left py-3">Copyright © 2021</div>
		</footer>
	</div>
	
</body>

</html>