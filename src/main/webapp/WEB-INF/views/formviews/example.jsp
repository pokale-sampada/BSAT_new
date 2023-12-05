<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  
  
  <label for="cars">Choose a scheme code:</label>

<select id="discount" name="cars" onchange="fun()">
 <% int k=1; %>
         <c:forEach var="list" items="${data}">
  <option value="${list.scheme_id}">${list.scheme_code}</option>
   <% k=k+1; %>
                                                 </c:forEach>
  
</select>


  <label for="fname">Scheme name:</label>
  <input type="text" id="fname" name="fname"><br><br>

<br>

<br>

  
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Scheme_code</th>
      <th scope="col">Scheme_Name</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
  
   <% int j=1; %>
         <c:forEach var="list" items="${data}">
    <tr>

      
      <td>${list.scheme_code}</td>
      <td>${list.scheme_name}</td>
      
    </tr>
    
     <% j=j+1; %>
                                                 </c:forEach>
  
  </tbody>
</table>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>    
  <script>
  
  function fun(){
  
  
  var discount =document.getElementById("discount").value
			console.log(discount);
			 $.ajax({
            	url: "${pageContext.request.contextPath}/example2",
                data:  ({discount :discount}),
                success: function(data) {
                	
                	
										
										var select=$("fname");
										console.log('discount'+data);
										document.getElementById("fname").value=data;
                	}
                	});
			
  
  }
  
  
  
  </script>
    
     


  </body>
</html>
