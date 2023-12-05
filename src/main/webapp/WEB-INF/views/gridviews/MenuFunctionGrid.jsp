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
					<li class="breadcrumb-item"><a href="menugroupgrid">
							</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<section role="main" class="content-body">
	
	<!-- <div class="row">
		<div class="col-md-12">
			<div class="col-md-5"></div>
			<div class="col-md-5"></div>

			<div class="col-md-2">

				<button class="btn btn-primary mb-md" name="gen_report"
					id="gen_report" value="Add New Menu"
					onclick="location.href='newmenufunction'">Add New Menu</button>
			</div>
		</div>
	</div> -->

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<!-- <a href="#" class="fa fa-caret-down"></a> <a href="#"
					class="fa fa-times"></a> -->
			</div>
			<h6 class="panel-title">
				Menu Function Register
				<div style="float: right; padding-right: 6%;">
					<a href="newmenufunction"><i class="fa fa-plus fa-1g"
						aria-hidden="true" title="Add New Menu"></i></a>
				</div>
			</h6>
		</header>
		<div class="panel-body">
			<div class="table-responsive">
				<table
					class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column"
					id="table1" data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th class="text center">Sr No</th>
							<th class="text center">Function Name</th>
							<th class="text center">Action Name</th>
							<th class="text center">Active</th>


						</tr>
					</thead>
					<tbody>

						<%
						int j = 1;
						%>
						<c:forEach var="menu_func" items="${menu_func_list}"
							varStatus="status">
							<tr>
								<td class="text center"><a
									href="updatemenufunction?menu_function_id=${menu_func.menu_function_id}">${menu_func.menu_function_id}</a></td>
								<td class="text center">${menu_func.function_name}</td>
								<td class="text center">${menu_func.function_action_name}</td>
								<td class="text center">${menu_func.active}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</section>
	<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	$(document).ready(function() {

		/*
		$('#datatable-editable').DataTable().destroy();
		 */

		$('#table1').DataTable().draw();

	});
</script>

<script>
	$(document).ready(function() {

		//	$.getJSON('${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval', // ${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval
		//	function(json) {

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
		 

		$('#table1').DataTable().draw();

		});  */

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
