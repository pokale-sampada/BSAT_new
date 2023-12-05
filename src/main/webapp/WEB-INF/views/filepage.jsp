%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
  
  
<form action="fileupload" class="form-horizontal"
	id="Saveform" method="Post"
	enctype="multipart/form-data">
  <div class="row">
  
    <div class="col">
      <input type="text" name="NAME" class="form-control" placeholder="Name">
    </div>
       <div class="col">
      <input type="text" name="ADDRESS" class="form-control" placeholder="Address">
    </div>
    >
       <div class="col">
      <input type="text" name = "CITY" class="form-control" placeholder="city">
    </div>
    <div>
    <label for="myfile">Select a file:</label>
	<input type="file" id="myfile" name="emp_attachment">
	</div>
  </div>
  <br>
  
  <div>
 <button type="submit" class="btn btn-primary">Submit</button>
 </div>
</form>
</body>
</html>



