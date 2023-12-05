	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label for="cars">Choose Your USER_ID:</label>

	<select name="projectList" id="discount" onchange="fun()">
		<c:forEach var="namee" items="${data}">
			<option value="${namee.id}">${namee.id}</option>
		</c:forEach>
	</select>
	<label for="fname">NAME:</label>
	<input type="text" id="name" name="fname">
	<br>
	<br>

	<h1>Welcome To updatestudnt.jsp page shilpi</h1>
	<div class="card-block">
		<div class="dt-responsive table-responsive">
			<table id="header-footer-fix"
				class="table table-bordered nowrap table-hover">
				<thead>
					<tr>
						<th class="text-center">ID</th>
						<th class="text-center">NAME</th>
						<th class="text-center">CITY</th>

					</tr>
				</thead>
				<tbody>
					<%
					int j = 1;
					%>
					<c:forEach var="viewprfinfo" items="${data}" varStatus="status">
						<tr>

							<td><a href="fetchstudent ?id=${viewprfinfo.id}">${viewprfinfo.id}</a></td>
							<td>${viewprfinfo.name}</td>
							<td>${viewprfinfo.city}</td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th class="text-center">ID</th>
						<th class="text-center">NAME</th>
						<th class="text-center">CITY</th>

					</tr>
				</tfoot>
			</table>
		</div>
	</div>



</body>
</html>