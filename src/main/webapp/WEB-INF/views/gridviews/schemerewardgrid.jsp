<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/themify-icons.css">

<link rel="stylesheet" type="text/css" href="css/icofont.css">

<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/feather.css">

<link rel="stylesheet" type="text/css" href="css/themify-icons.css">
<link rel="stylesheet" type="text/css"
	href="css/datatables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="css/buttons.datatables.min.css">

<link rel="stylesheet" type="text/css" href="css/pages.css">
</head>
<body>

	<div class="card">
		<div class="card-header">
			<h5>Gift Master</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="header-footer-fix"
					class="table table-hover table-bordered nowrap">
					<thead>
						<tr>
							<th>Sr.No.</th>
							<th >GIFT NAME</th>
							<th >GIFT GROUP</th>
							<th >GIFT CODE</th>
							<th style="display: none;">GIFT BRAND NAME</th>
							<th >EFFECTIVE PRICE</th>
						</tr>
					</thead>
					<tbody>
						<%
						int j = 1;
					%>
						<c:forEach var="viewprfinfo" items="${giftmasterlist}"
							varStatus="status">
							<tr>
								<td class="text-center"><%=j%></td>
								<td><a href="giftdetails?gift_id=${viewprfinfo.gift_id}">${viewprfinfo.gift_name}</a></td>
								<td>${viewprfinfo.gift_group}</td>
								<td>${viewprfinfo.gift_code}</td>
								<td style="display: none;">${viewprfinfo.gift_brand_name}</td>
								<td>${viewprfinfo.effective_price}</td>

							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
					 <tfoot>
						<tr>
							<th >Sr.No.</th>
							<th >GIFT NAME</th>
							<th >GIFT GROUP</th>
							<th >GIFT CODE</th>
							<th style="display: none;">GIFT BRAND NAME</th>
							<th >EFFECTIVE PRICE</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<script>
				$(window).load(function(){
					$('.col-xs-12.col-sm-12').css({'overflow-x':'auto'});
				}
				);
</script>
</body>
</html>
