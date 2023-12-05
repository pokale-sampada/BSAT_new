<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li class="breadcrumb-item"><a href="menugroupgrid">Branch List
							</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<section role="main" class="content-body">
	

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#"></a>

			</div>
			<h2 class="panel-title">
				Branch Master
				<div style="float: right; padding-right: 0.5%;">
					<a href="create_branch"><i class="fa fa-plus fa-1g"
						aria-hidden="true" title="Add New Menu Group "></i></a>
				</div>
			</h2>
		</header>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover"
				id="table1" cellspacing="0" style="max-width: 100%; margin: 0 auto;">
				<thead>
					<tr>
						<th width="10%">Branch ID</th>
						<th width="26%">Branch Name</th>
						<th width="15%">Branch Description</th>
						<!-- 	<th class="center" width="10%">Is Active</th> -->

					</tr>
				</thead>
				<tbody>
					<c:forEach var="viewprfinfo" items="${dml}" varStatus="status">
						<tr>
							<td><a
								href="update_branch?branch_id=${viewprfinfo.branch_id}">${viewprfinfo.branch_id}</a>
							</td>
							<td>${viewprfinfo.branch_code}</td>
							<td>${viewprfinfo.branch_desc}</td>
							<%-- 	<td><center>${viewprfinfo.is_active}</center></td> --%>
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
