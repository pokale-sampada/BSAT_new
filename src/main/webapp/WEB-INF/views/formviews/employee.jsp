<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="fetchemployee" method="post" enctype="multipart/form-data">  
     Enter your name :  <input type="text" name="name"> <br><br>
     Enter your City :  <input type="text" name="city"><br><br>
     Choose a File :    <input type="file" multiple id="fileToUpload" name="fileToUpload"><br><br>
     <input type="submit" value="Submit">
  </form> 
</body>
</html>