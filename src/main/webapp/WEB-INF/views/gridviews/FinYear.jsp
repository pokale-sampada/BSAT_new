

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Financial Year Grid</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="">Masters</a></li>
					<li class="breadcrumb-item"><a href="menugroupgrid">Financial Year</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<div class="card">
	<div class="card-header">
		<h5>Financial Year Grid</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<!-- <li><a href="saveregion"><i class="feather icon-plus" style="color: blue; font-size: 20px; font-weight: bold;"
					title="Add New Region "></i></a></li> -->
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
						<th>Sr No</th>
						<th>Fin_Year</th>
						<th>No Of Weeks</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Current Year</th>
						<th>Active</th>
					</tr>
				</thead>
				<tbody>
					<%
						int j = 1;
					%>
					<c:forEach var="grp_reg" items="${dml}" varStatus="status">

						<tr>
							<td class="center"><%=j%></td>
							<td class="center"><a
								href="read_only?fin_year=${grp_reg.fin_year}">${grp_reg.fin_year}</a></td>
							<td class="center">${grp_reg.no_of_weeks}</td>
							<td class="center">${grp_reg.start_date1}</td>
							<td class="center">${grp_reg.end_date1}</td>
							<td class="center">${grp_reg.current_yr_flag}</td>
							<td class="center">${grp_reg.active_flag}</td>
						</tr>
						<%
							j = j + 1;
						%>
					</c:forEach>
				</tbody>
				<tfoot>
					<th>Sr No</th>
						<th>Fin_Year</th>
						<th>No Of Weeks</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Current Year</th>
						<th>Active</th>
				</tfoot>
			</table>
		</div>
	</div>
</div>
<%-- <section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>
			<li><span>System Setups</span></li>
			<li><span>Fin Year</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				
			</div>
			<h2 class="panel-title">Financial Year Details <div style="float: right; padding-right: 1%;">
					<a href="new_fin"><i class="fa fa-plus fa-1g"
						aria-hidden="true" title="Add New Menu"></i></a>
				</div></h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th>Sr No</th>
						<th>Fin_Year</th>
						<th>No Of Weeks</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Current Year</th>
						<th>Active</th>
					</tr>
				</thead>
				<tbody>
					<%
						int j = 1;
					%>
					<c:forEach var="grp_reg" items="${dml}" varStatus="status">

						<tr>
							<td class="center"><%=j%></td>
							<td class="center"><a
								href="read_only?fin_year=${grp_reg.fin_year}">${grp_reg.fin_year}</a></td>
							<td class="center">${grp_reg.no_of_weeks}</td>
							<td class="center">${grp_reg.start_date1}</td>
							<td class="center">${grp_reg.end_date1}</td>
							<td class="center">${grp_reg.current_yr_flag}</td>
							<td class="center">${grp_reg.active_flag}</td>
						</tr>
						<%
							j = j + 1;
						%>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<!-- end: page -->
</section> --%>

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

		$('#datatable-editable').DataTable().draw();

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
