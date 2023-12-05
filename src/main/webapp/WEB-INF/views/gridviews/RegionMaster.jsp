<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Region Master</h4>

				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href=""> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Setups</a></li>
					<li class="breadcrumb-item"><a href="getregionslist">Region Master</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->

<div class="card">
	<div class="card-header">
		<h5>Region Master</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><a href="saveregion"><i class="feather icon-plus" style="color: blue; font-size: 20px; font-weight: bold;"
					title="Add New Region "></i></a></li>
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<div class="dt-responsive table-responsive">
			<table id="header-footer-fix"
				class="table table-bordered nowrap table-hover">
				<thead>
					<tr>
						<!-- <th class="text-center" width="10%">Sr.No.</th>
							<th class="text-center" width="26%">Scheme Name</th>
							<th class="text-center" width="15%">Scheme Code</th>
							<th class="text-center" width="10%">Effective From</th>
							<th class="text-center" width="10%">Effective To</th>
							<th class="text-center" width="13%">Submission Date</th>
							<th class="text-center" width="16%">Status</th> -->
							<th class="text-center" width="10%">Sr.No.</th>
						<th class="text-center">Region ID</th>
						<th class="text-center">Region Name</th>
						<th class="text-center">Region Code</th>
						<th class="text-center">Is Active</th>
					</tr>
				</thead>
				<tbody>
					<%
							int j = 1;
						%>
					<c:forEach var="viewprfinfo" items="${regionmaster}"
						varStatus="status">
						<tr>
						<td class="text-center"><%=j%></td>
							<td><a href="updateregion?regionid=${viewprfinfo.region_id}">${viewprfinfo.region_id}</a>
							</td>
							<td>${viewprfinfo.region_code}</td>
							<td>${viewprfinfo.region_name}</td>
							<td>${viewprfinfo.is_active}</td>
						</tr>
						<%
								j = j + 1;
							%>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
					<th class="text-center" width="10%">Sr.No.</th>
						<th class="text-center">Region ID</th>
						<th class="text-center">Region Name</th>
						<th class="text-center">Region Code</th>
						<th class="text-center">Is Active</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>








































<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>System Setups</span></li>
				<li><span>Geographical</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#"></a>
			</div>

			<h2 class="panel-title">
				Region Master
				<div style="float: right; padding-right: 0.5%;">
					<a href="saveregion"><i class="fa fa-plus fa-1g"
						aria-hidden="true" title="Add New Region "></i></a>
				</div>
			</h2>
		</header>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover"
				id="table1" cellspacing="0" style="max-width: 100%; margin: 0 auto;">
				<thead>
					<tr>
						<th class="center" width="10%">Region ID</th>
						<th class="center" width="26%">Region Name</th>
						<th class="center" width="15%">Region Code</th>
						<th class="center" width="10%">Is Active</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="viewprfinfo" items="${regionmaster}"
						varStatus="status">
						<tr>
							<td><a href="updateregion?regionid=${viewprfinfo.region_id}">${viewprfinfo.region_id}</a>
							</td>
							<td>${viewprfinfo.region_code}</td>
							<td>${viewprfinfo.region_name}</td>
							<td>${viewprfinfo.is_active}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	$(document).ready(function() {
		//alert("***");

		//	$.getJSON('${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval', // ${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval
		//	function(json) {
		/*
		$('#datatable-editable').dataTable( {
		    "aaData": json,
		    "columns": [
		        { "data": "scheme_id" } ,
		        { "data": "scheme_name" },
		        { "data": "scheme_code" },
		        { "data": "start_date1" }, 
		        { "data": "end_date1" },
		        { "data": "submission_date1" },
		        { "data": "active_flag" }
		    ]
		})
		 */

		//	var tr;
		/*
		$('#datatable-editable').DataTable().destroy();
		 */

		/* 	for (var i = 0; i < json.length; i++) {

				tr = $('<tr/>');
				tr.append("<td>" +i+"</td>");
				tr.append("<td>" + json[i].scheme_name + "</td>");
				tr.append("<td>" +  json[i].scheme_code + "</td>");
				tr.append("<td>" + json[i].start_date1 + "</td>");
				tr.append("<td>" + json[i].end_date1 + "</td>");
				tr.append("<td>" + json[i].submission_date1 + "</td>");
				tr.append("<td>" + json[i].active_flag + "</td>");
		
				$('#datatable-editable').find('tbody').append(tr);
				//$('#datatable-editable').append(tr);
			}
		 */

		$('#table1').DataTable().draw();

		/* 	});  */

		//var oTable = $('#datatable-editable').DataTable( );
		// to reload
		//oTable.ajax.reload();
		/*
		var table = $('#datatable-editable').DataTable();
		table.draw();
		 */

		/*
		$.ajax({
		'url': "${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval",
		'method': "GET",
		'contentType': 'application/json'
		}).done( function(data) {
		$('#datatable-editable').dataTable( {
		    "aaData": data,
		    "columns": [
		        { "data": "scheme_id" } ,
		        { "data": "scheme_name" },
		        { "data": "scheme_code" },
		        { "data": "start_date1" }, 
		        { "data": "end_date1" },
		        { "data": "submission_date1" },
		        { "data": "active_flag" }
		    ]
		})
		}); */

	});
</script>
 --%>