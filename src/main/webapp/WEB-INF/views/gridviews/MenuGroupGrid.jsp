<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Menu Group Grid</h4>
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
					<li class="breadcrumb-item"><a href="menugroupgrid">Menu Groups</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<div class="card">
	<div class="card-header">
		<h5>Menu Group Grid</h5>
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
						<th>Menu Group Name</th>
						<th>Menu Group Description</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Active</th>
					</tr>
				</thead>
				<tbody>
					<%
						int j = 1;
					%>
					<c:forEach var="menu_grp" items="${menu_grp_list}"
						varStatus="status">
						<tr>
							<td><%=j%></td>
							<td><a
								href="updatemenugroup?menu_group_id=${menu_grp.menu_group_id}">${menu_grp.group_name}</a></td>
							<td>${menu_grp.group_description}</td>
							<td>${menu_grp.group_start_date1}</td>
							<td>${menu_grp.group_end_date1}</td>
							<td>${menu_grp.active}</td>
						</tr>
						<%
							j = j + 1;
						%>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Sr No</th>
						<th>Menu Group Name</th>
						<th>Menu Group Description</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Active</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

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
