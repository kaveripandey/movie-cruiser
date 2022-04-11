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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>
<style>
body {
	font-family: 'raleway', serif;
}
.myfooter{
position:absolute;
left:0;
bottom:0;
width:100%;
padding-left:20px;
text-align:center;
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
					<li class="nav-item"><a class="nav-link" href="/admin">
							<i class="fa fa-home">&nbsp;</i>Movie List</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>

			    </ul>
			</div>
		</nav>
 <form:form action="edit-menu-item-success" method="post" modelAttribute="editMovie">
    <div class="container-fluid">
    <div style="font-weight: bold;font-size:20px;margin-bottom:20px;margin-left:60px;margin-top:20px;">Edit Movie Details</div>
      <div class="form-row" style="font-weight: bold;">
        <div class="col-sm-3">
          <form:label path="id" for="id">ID</form:label>
          <form:input path="id" class="form-control" id="id"
            value="${Movieid} " />
        </div>
        <div class="col-sm-9">

          <form:label path="title" for="title">Title</form:label>
          <form:input path="title" type="text" class="form-control"
            id="title" value="${title}" required="required" />
        </div>
      </div>

      <div class="form-row" style="font-weight: bold;">
        <div class="col-sm-4">
          <form:label path="boxOffice" for="price">Box-Office</form:label>
          <form:input path="boxOffice" type="text" class="form-control"
            id="price" value="${boxOffice}" required="required" />
        </div>
        <div class="col-sm-4">
          <form:label path="dateOfLaunch" for="dateOfLaunch">Date of Launch</form:label>
          <form:input path="dateOfLaunch" type="text" class="form-control"
            id="dateOfLaunch" value="${dol}" required="required" />
        </div>
        <div class="col-sm-4">
          <form:label path="genre" for="genre">Genre</form:label>
          <form:select path="genre" id="genre" class="form-control">
          <form:option value="${genre}"></form:option>
            <c:forEach items="${genreList}" var="gen"
              varStatus="loop">
              <option value="${gen}">${gen}</option>
            </c:forEach>

          </form:select>
        </div>
        </div>
        
        <div class="form-row" style="font-weight: bold;">
        <div class="col-sm-4">
          <form:label path="active" for="active">Active</form:label>
          <br>
          <div class="form-check-inline">
            <form:label path="active" class="form-check-label">
              <form:radiobutton path="active" class="form-check-input"
                id="active" name="active" value="yes" />Yes
            </form:label>
          </div>
          <div class="form-check-inline">
            <form:label path="active" class="form-check-label">
              <form:radiobutton path="active" class="form-check-input"
                id="active" name="active" value="no" />No
            </form:label>
          </div>

        </div>
    
      
        <div class="col-sm-4">
          <form:label path="hasTeaser" for="active">Has Teaser</form:label>
          <br>
          <div class="form-check-inline">
            <form:label path="hasTeaser" class="form-check-label">
              <form:radiobutton path="hasTeaser" class="form-check-input"
                id="active" name="active" value="yes" />Yes
            </form:label>
          </div>
          <div class="form-check-inline">
            <form:label path="hasTeaser" class="form-check-label">
              <form:radiobutton path="hasTeaser" class="form-check-input"
                id="active" name="active" value="no" />No
            </form:label>
          </div>

        </div>
      </div>
     <br>
      <div class="row">
        <div class="col-sm-3">
          <input name="submit" class="btn btn-success" value="Save" type="submit" />
        </div>
      </div>
    </div>

  </form:form>
  <footer class="page-footer myfooter"
			style="background-color: #0f0f3d; width: 100%;">
			<div class="footer-copyright text-left py-3">Copyright © 2021</div>
		</footer>
	</div>
	<script type="text/javascript">
    $('#dateOfLaunch').datepicker({
        uiLibrary : 'bootstrap4',
        format : 'yyyy/mm/dd'
    });
    </script>
</body>
</html>