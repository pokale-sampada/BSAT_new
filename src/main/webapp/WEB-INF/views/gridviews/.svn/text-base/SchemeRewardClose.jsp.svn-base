<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Interface Schemes </span></li>
			</ol>
			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>
	<h2 style="text-align: center">Interface Schemes</h2>
	<hr>
	<div class="row" style="text-align: center">
		<div class="col-sm-12">
		<div class="col-sm-6">Interface Schemes</div>
		<div class="col-sm-6">
			<button class="btn btn-primary">Interface Schemes</button>
	</div>
		</div>
	</div>

	<hr>
	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions"></div>
			<h2 class="panel-title">Closed Schemes with current month
				Redemption Date</h2>

		</header>
		<div class="panel-body">
			<table class="table table-striped 
table-bordered table-hover"
				id="table1" cellspacing="0" style="width: 100%; margin: 0 auto;">
				<thead>
					<tr>
						<th class="center" style="width: 5%">Sr.No.</th>
						<th class="center" style="width: 30%">Scheme Name</th>
						<th class="center" style="width: 20%">Scheme Code</th>
						<th class="center" style="width: 13%">Effective From</th>
						<th class="center" style="width: 13%">Effective To</th>

						<th class="center" style="width: 19%">Status</th>

						<!-- <th class="center" >Description</th> -->
						<!-- <th class="center" >Category</th> -->
						<!-- <th class="center" >Reward Type</th> -->

					</tr>
				</thead>
				<tbody>
					<% int k=1; %>
					<c:forEach var="viewprfinfo" items="${Rew_Sch_Close_list}"
						varStatus="status">
						<tr>
							<td><center>
									<%=k%>
								</center></td>
							<td><center>
									<%--    <a href="reviewschemedetails?scheme_id=${viewprfinfo.scheme_id}"> --%>
									${viewprfinfo.scheme_name}</a>
								</center></td>


							<td><center>${viewprfinfo.scheme_code}</center></td>
							<td>
								<center>${viewprfinfo.start_date1}</center>
							</td>
							<td><center>${viewprfinfo.end_date1}</center></td>
							<td><center>${viewprfinfo.active_flag}</center></td>



						</tr>
						<% k=k+1; %>
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
