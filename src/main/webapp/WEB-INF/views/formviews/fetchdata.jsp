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
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Mobile No</th>
      <th scope="col">City/th>
    </tr>
  </thead>
  <tbody>
  
   <% int j=1; %>
         <c:forEach var="list" items="${data}">
    <tr>

      
      <td>${list.ID}</td>
      <td>${list.NAME}</td>
      <td>${list.ADDRESS}</td>
      <td>${list.MOBILE}</td>
      <td>${list.CITY}</td>
      
    </tr>
    
     <% j=j+1; %>
                                                 </c:forEach>
  
  </tbody>
</table>
</body>
</html>

 