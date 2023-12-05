

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="it"> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Scheme Analysis Exception Report</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions"></div>
			<h2 class="panel-title">Scheme Analysis Exception Report</h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th width="10%">Sr. No.</th>
						<th width="12%">Scheme ID</th>
						<th width="14%">Scheme Code</th>
						<th width="18%">Creation Date</th>
						<th width="50%">Exception</th>

					</tr>
				</thead>
				<tbody>
					<%
						int j = 1;
					%>
					<c:forEach var="viewprfinfo" items="${schememaster}"
						varStatus="status">
						<tr>
							<td><input type="hidden" value="${viewprfinfo.excp_id}"></input>
								<%=j%></td>
							<td>${viewprfinfo.scheme_id}</td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.creation_date}</td>
							<td>${viewprfinfo.exception}</td>

						</tr>
						<%
							j = j + 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>

	<center>
	<input type="button" class="btn btn-primary" id="action1"
		style="margin-top: 3%;" value="Clear Exceptions"
		onclick="submitform()"></input></center>
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

<script type="text/javascript">
	function submitform() {
		if (confirm('Are you sure you want to clear exceptions?')) {
			window.location.href = "clearSchemeExceptions";
		} else {
			// Do nothing!
		}
	}
</script>
