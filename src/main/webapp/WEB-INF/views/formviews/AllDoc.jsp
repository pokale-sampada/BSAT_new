<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<!-- <li><span>Scheme Approval</span></li>
				<li><span>List Of Schemes</span></li> -->
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
			<h2 class="panel-title">All Document Details</h2>

		</header>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover" id=""
				cellspacing="0" width="100%">

				<thead>
					<tr>
						<th class="center" style="width: 5%">SR No</th>
						<th class="center" style="width: 15%">DocumentType</th>
						<th class="center" style="width: 35%">Document Title</th>
						<th class="center" style="width: 7%">Revision</th>
						<th class="center" style="width: 13%">Upload Date</th>
						<th class="center" style="width: 15%">Comment</th>
						<th class="center" style="width: 10%">Download File</th>
						<!--  <th class="center">Delete File</th> -->
					<tr>
				</thead>


				<tbody>

					<%int i=1; %>
					<c:forEach var="grp_reg" items="${sss}" varStatus="status">

						<tr>
							<td><%=i%></td>

							<td>${grp_reg.doc_type}</td>
							<td>${grp_reg.doc_title}</td>
							<td>${grp_reg.revision}</td>
							<td>${grp_reg.doc_upload_date1}</td>
							<td>${grp_reg.comments}</td>
							<td><center>
									<a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
										class="fa fa-download bigger-160" aria-hidden="true"></i></a>
								</center></td>

						</tr>
						<% i=i+1; %>
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

		$('#').DataTable().draw();

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
