<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Movie Cruiser Login Page</title>
        <link rel="stylesheet" href="/portal/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Oswald:400" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<style>
.gradient-custom-2 {
  background: #C3B1E1;

  background: -webkit-linear-gradient(to right, #552586, #6A359C, #804FB3, #9969C7);

  background: linear-gradient(to right, #552586, #6A359C, #804FB3, #9969C7);
}

@media (min-width: 768px) {
  .gradient-form {
    height: 100vh !important;
  }
}
@media (min-width: 769px) {
  .gradient-custom-2 {
    border-top-right-radius: .3rem;
    border-bottom-right-radius: .3rem;
  }
}

</style>
</head>

<body>

<section class="h-100 gradient-form" style="background-color: #eee;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-xl-10">
        <div class="card rounded-3 text-black">
          <div class="row g-0">
            <div class="col-lg-6">
              <div class="card-body p-md-5 mx-md-4">
              
            <!-- <h1 class="text-danger">${sessionScope.error}</h1> -->
            <div class="row">
                <spring:url value="/home" var="homePageLink"></spring:url>
              <img src="https://png.pngtree.com/png-clipart/20190920/original/pngtree-film-film-decoration-illustration-png-image_4674079.jpg" style="width: 185px; border-radius: 50%;"  alt="moviecruiser">
                  <h4 class="mt-1 mb-5 pb-1">Movie Cruiser Login Portal</h4>
                </div>
                
                <p>Please login to your account</p>
                  
                    <spring:url value="/login" var="loginUrl"></spring:url>
                    <form:form method="post" modelAttribute="model" action="${loginUrl}" >
                    
                    <spring:bind path="userName">
                        <div class="form-outline mb-4">
                            <label for="userName" >Username</label>
                            <form:input path="userName" type="text" 
                                class="form-control ${status.error ? 'is-invalid' : ''}" id="userName" placeholder="Username" />
                            <form:errors path="userName" class="invalid-feedback" />
                        </div>
                    </spring:bind>
                    
                    <spring:bind path="password">
                        <div class="form-outline mb-4">
                            <label for="password">Password</label>
                            <form:input path="password" type="password" 
                                class="form-control ${status.error ? 'is-invalid' : ''}" id="password" placeholder="Password" />
                            <form:errors path="password" class="invalid-feedback" />
                        </div>
                    </spring:bind>
                    
                        <button type="submit" class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3">Login</button>
                    </form:form>
                    
                    <span style="color:red;font-weight:bold">${error }</span>
                 
                  </div>
                </div>
              </div>
             </div>
            </div>
           </div>
          </div>
</section>
</body>
 </html>