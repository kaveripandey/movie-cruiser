<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Edit Movie Cruiser</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
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

.myfooter {
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	padding-left: 20px;
	text-align: center;
}

.footer-copyright {
	color: white;
}

.container {
	margin-top: 30px;
	background-color: #d6d6f5; 

}

img {
	height: 48px;
	width: 50px;
	margin-top: 7px;
}
</style>
</head>

<body>
	<div class="border" style="margin: auto;">
		<nav class="navbar navbar-expand-sm navbar-dark"
			style="background-color: #0f0f3d;">
			<a class="navbar-brand" href="#">Movie Cruiser</a> <img
				src="https://png.pngtree.com/png-clipart/20190920/original/pngtree-film-film-decoration-illustration-png-image_4674079.jpg"
				alt="MovieCruiser">
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto" style="font-size: 20px;">
					<li class="nav-item"><a class="nav-link" href="/movie-list"><i
							class="fa fa-home">&nbsp;</i>Movie List</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>

				</ul>
			</div>
		</nav>

		<div class="container-fluid">
			<div
				style="font-weight: bold; font-size: 20px; margin-bottom: 20px; margin-left: 60px; margin-top: 20px;">Favorites</div>
			<div class="container">
				<div class="row" style="font-weight: bold;">
					<div class="col-sm">
						<span>Movie Name</span>
					</div>

					<div class="col-sm">
						<span>Box Office</span>
					</div>

					<div class="col-sm">
						<span>Date of Launch</span>
					</div>

					<div class="col-sm">
						<span>Genre</span>
					</div>

					<div class="col-sm">
						<span>Action</span>
					</div>

				</div>

				<hr>

				<c:forEach items="${inf}" var="temp">
					<div class="row colored-cell">
						<div class="col-sm">
							<span>${temp.title}</span>
						</div>

						<div class="col-sm">
							<span>${temp.boxOffice}</span>
						</div>

						<div class="col-sm">
							<span><fmt:formatDate value="${temp.dateOfLaunch}"
									type="date" pattern="dd-MMM-yyyy" /></span>
						</div>

						<div class="col-sm">
							<span>${fn:toUpperCase(temp.genre)}</span>
						</div>

						<div class="col-sm">
							<a href="deleteItem?id=${temp.id}">Delete</a>
						</div>

					</div>

				</c:forEach>
				
				<br>

				<c:set var="active" value="${inf.size()}" />
				<c:choose>
					<c:when test="${active>0}">

						<div class="row">

							<div class="col-lg-6">
								<h5>Total Favorite Movies : ${inf.size()}</h5>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<style>
                   #main {
	                 display: none;
                         }
                       </style>
						<div class="row"></div>
						<div class="col-lg-12 alert alert-danger">No Favorites Movie</div>

					</c:otherwise>
				</c:choose>

			</div>

		</div>


		<footer class="page-footer myfooter"
			style="background-color: #0f0f3d; width: 100%;">
			<div class="footer-copyright text-left py-3">Copyright © 2021</div>
		</footer>
		<!-- Footer -->

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>

</html>

<!-- End -->
