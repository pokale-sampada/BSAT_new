<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Scheme Approval</span></li>
				<li><span>List Of Schemes</span></li>
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
			<h2 class="panel-title">Scheme Analysis Request Report Queue 1</h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable1"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="5%">Sr. No.</th>
						<th class="center" width="10%">Scheme ID</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="15%">SCH Start Time</th>
						<th class="center" width="15%">SP Start Time</th>
						<th class="center" width="15%">SP End Time</th>
						<th class="center" width="15%">SCH End Time</th>
						<th class="center" width="15%">Status</th>
					</tr>
				</thead>
				<tbody>

					<%
						int j = 1;
					%>
					<c:forEach var="viewprfinfo" items="${schememaster}"
						varStatus="status">
						<tr>
							<td><%=j%></td>
							<td><a
								href="pendingschemeaprdetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.start_date1}</td>
							<td>${viewprfinfo.end_date1}</td>
							<td>${viewprfinfo.submission_date1}</td>
							<td>${viewprfinfo.active_flag}</td>


						</tr>
						<%
							j = j + 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" ></a> 
			</div>
			<h2 class="panel-title">Scheme Analysis Request Report Queue 2</h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable2"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="5%">Sr. No.</th>
						<th class="center" width="10%">Scheme ID</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="15%">SCH Start Time</th>
						<th class="center" width="15%">SP Start Time</th>
						<th class="center" width="15%">SP End Time</th>
						<th class="center" width="15%">SCH End Time</th>
						<th class="center" width="15%">Status</th>
					</tr>
				</thead>
				<tbody>

					<%
						int p = 1;
					%>
					<c:forEach var="viewprfinfo" items="${schememaster}"
						varStatus="status">
						<tr>
							<td><%=p%></td>
							<td><a
								href="pendingschemeaprdetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.start_date1}</td>
							<td>${viewprfinfo.end_date1}</td>
							<td>${viewprfinfo.submission_date1}</td>
							<td>${viewprfinfo.active_flag}</td>


						</tr>
						<%
							p = p + 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" ></a>
			</div>
			<h2 class="panel-title">Scheme Analysis Request Report Queue 3</h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable3"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="5%">Sr. No.</th>
						<th class="center" width="10%">Scheme ID</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="15%">SCH Start Time</th>
						<th class="center" width="15%">SP Start Time</th>
						<th class="center" width="15%">SP End Time</th>
						<th class="center" width="15%">SCH End Time</th>
						<th class="center" width="15%">Status</th>
					</tr>
				</thead>
				<tbody>

					<%
						int q = 1;
					%>
					<c:forEach var="viewprfinfo" items="${schememaster}"
						varStatus="status">
						<tr>
							<td><%=q%></td>
							<td><a
								href="pendingschemeaprdetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.start_date1}</td>
							<td>${viewprfinfo.end_date1}</td>
							<td>${viewprfinfo.submission_date1}</td>
							<td>${viewprfinfo.active_flag}</td>


						</tr>
						<%
							q = q + 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" ></a>
			</div>
			<h2 class="panel-title">Scheme Analysis Request Report Queue 4</h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable4"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="5%">Sr. No.</th>
						<th class="center" width="10%">Scheme ID</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="15%">SCH Start Time</th>
						<th class="center" width="15%">SP Start Time</th>
						<th class="center" width="15%">SP End Time</th>
						<th class="center" width="15%">SCH End Time</th>
						<th class="center" width="15%">Status</th>
					</tr>
				</thead>
				<tbody>

					<%
						int r = 1;
					%>
					<c:forEach var="viewprfinfo" items="${schememaster}"
						varStatus="status">
						<tr>
							<td><%=r%></td>
							<td><a
								href="pendingschemeaprdetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.start_date1}</td>
							<td>${viewprfinfo.end_date1}</td>
							<td>${viewprfinfo.submission_date1}</td>
							<td>${viewprfinfo.active_flag}</td>


						</tr>
						<%
							r = r + 1;
						%>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" ></a>
			</div>
			<h2 class="panel-title">Scheme Analysis Request Report Queue 5</h2>

		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable5"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="5%">Sr. No.</th>
						<th class="center" width="10%">Scheme ID</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="15%">SCH Start Time</th>
						<th class="center" width="15%">SP Start Time</th>
						<th class="center" width="15%">SP End Time</th>
						<th class="center" width="15%">SCH End Time</th>
						<th class="center" width="15%">Status</th>
					</tr>
				</thead>
				<tbody>

					<%
						int s = 1;
					%>
					<c:forEach var="viewprfinfo" items="${schememaster}"
						varStatus="status">
						<tr>
							<td><%=s%></td>
							<td><a
								href="pendingschemeaprdetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.start_date1}</td>
							<td>${viewprfinfo.end_date1}</td>
							<td>${viewprfinfo.submission_date1}</td>
							<td>${viewprfinfo.active_flag}</td>


						</tr>
						<%
							s = s + 1;
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

		 $('#datatable-editable1').DataTable().draw();
		 $('#datatable-editable2').DataTable().draw();
		 $('#datatable-editable3').DataTable().draw();
		 $('#datatable-editable4').DataTable().draw();
		 $('#datatable-editable5').DataTable().draw();
				 

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
