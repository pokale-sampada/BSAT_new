<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span></span></li>
				<li><span></span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" ></a>
			</div>
			<h2 class="panel-title">
				Menu Group Details
				<div style="float: right; padding-right: 6%;">
					<a href="menugroup"><i class="fa fa-plus fa-1g"
						aria-hidden="true" title="Add New Menu Group "></i></a>
				</div>
			</h2>

		</header>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover"
				id="table1" cellspacing="0" style="width: 100%; margin: 0 auto;">
				<thead>
					<tr>
						<th class="center">Sr.No.</th>
						<th class="center">Menu Group Name</th>
						<th class="center">Menu Group Description</th>
						<th class="center">Start Date</th>
						<th class="center">End Date</th>

						<th class="center">Active</th>

						<!-- 														<th class="center" >Description</th> -->
						<!-- 														<th class="center" >Category</th> -->
						<!-- 														<th class="center" >Reward Type</th> -->

					</tr>
				</thead>
				<tbody>
					<%
						int j = 1;
					%>
					<c:forEach var="viewprfinfo" items="${groupdetails}"
						varStatus="status">
						<tr>
							<td><center>
									<%=j%>
								</center></td>
							<td style="padding-left: 4%"><a
								href="menugroup1?menu_group_id=${viewprfinfo.menu_group_id}">${viewprfinfo.group_name}</a></td>
							<td><center>${viewprfinfo.group_description}</center></td>
							<td><center>${viewprfinfo.group_start_date1}</center></td>
							<td><center>${viewprfinfo.group_end_date1}</center></td>
							<td><center>${viewprfinfo.active}</center></td>

							<%-- 													<td>${viewprfinfo.description}</td> --%>

							<%-- 													<td>${viewprfinfo.category}</td> --%>
							<%-- 													<td>${viewprfinfo.reward_type}</td> --%>

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
