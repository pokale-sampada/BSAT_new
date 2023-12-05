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
		<c:forEach var="name" items="${data}">
			<option value="${name.profile_id}">${name.user_id}</option>
		</c:forEach>
	</select>
	<label for="fname">Profile_Id:</label>
	<input type="text" id="profile_id" name="fname">
	<br>
	<br>

	<h1>Welcome To hello.jsp page shilpi</h1>
	<div class="card-block">
		<div class="dt-responsive table-responsive">
			<table id="header-footer-fix"
				class="table table-bordered nowrap table-hover">
				<thead>
					<tr>
						<th class="text-center">USER_ID</th>
						<th class="text-center">PROFILE_ID</th>
						<th class="text-center">SUPERVISOR_ID</th>

					</tr>
				</thead>
				<tbody>
					<%
					int j = 1;
					%>
					<c:forEach var="viewprfinfo" items="${data}" varStatus="status">
						<tr>

							<td>${viewprfinfo.user_id}</td>
							<td>${viewprfinfo.profile_id}</td>
							<td>${viewprfinfo.supervisor_id}</td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th class="text-center">User ID</th>
						<th class="text-center">PROFILE_ID</th>
						<th class="text-center">SUPERVISOR_ID</th>

					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<script>
	

	function fun(){


	var discount =document.getElementById("discount").value
	console.log(discount);
	$.ajax({
	url: "${pageContext.request.contextPath}/helloo",
	data: ({discount :discount}),
	success: function(data) {
	var select = $('#profile_id');
	console.log('discount'+data);
	document.getElementById("profile_id").value = data;

	}
	});


	}

</script>
</body>
</html>