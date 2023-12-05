<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
		<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Menu Header Grid</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="">System Setups</a></li>
					<li class="breadcrumb-item"><a href="menugroupgrid">Look Up Grid</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" ></a>
			</div>
			<h4 class="panel-title">
				LookUp Details
				<div style="float: right; padding-right: 0.5%;">
					<a href="Lookup"><i class="fa fa-plus fa-1g"
						aria-hidden="true" title="Add New lookup "></i></a>
				</div>
			</h4>


		</header>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover"
				id="table1" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Sr No</th>
						<th>LookUp Type</th>
						<th>Active Start Date</th>
						<th>Active End Date</th>

					</tr>
				</thead>

				<tbody>
				<%
						int j = 1;
					%>

					<c:forEach var="lookupinfo" items="${alllookuplist}"
						varStatus="status">
						<tr>
						<td><%=j%></td>
							<%-- 					<td><a href="h5?lookup_type=${lookupinfo.lookup_type}">${lookupinfo.lookup_type}</a></td> --%>
							<td style="padding-left: 1%"><a
								href="loadlookupdata?lookup_type=${lookupinfo.lookup_type}">${lookupinfo.lookup_type}</a></td>
							<td>${lookupinfo.active_start_date}</td>
							<td>${lookupinfo.active_end_date}</td>


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
