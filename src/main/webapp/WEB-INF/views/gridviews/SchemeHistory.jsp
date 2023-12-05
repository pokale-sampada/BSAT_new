<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span><span>Scheme History</span></span></li>
				<li><span>Menu Function<span></span></span></li>
				<li><span>Menu Function Register</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>
	<div class="row">
		<div class="col-md-12">
			<div class="col-md-5"></div>
			<div class="col-md-5"></div>

			<div class="col-md-2">

				<button class="btn btn-primary mb-md" name="gen_report"
					id="gen_report" value="Add New Menu"
					onclick="location.href='newmenufunction'">Add New Menu</button>
			</div>

		</div>
	</div>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a> <a href="#"
					class="fa fa-times"></a>
			</div>
			<h6 class="panel-title">Scheme History</h6>
			
		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped" id="table1"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="text center" >Sr.No.</th>
														<th class="text center" >Scheme Name</th>
														<th class="text center" >Description</th>
														<th class="text center" >Status </th>
														<th class="text center" >Published Date</th>														
														<th class="text center" >Category</th>
														<th class="text center" >Reward Type</th>
														<th class="text center" >Qualified for reward</th>
														<th class="text center" >Total CN PTS</th>
														<th class="text center" >Next Milestone</th>
														<th class="text center" >Target</th>
						

					</tr>
				</thead>
				<tbody>

						<% int j=1; %>
											<c:forEach var="viewprfinfo" items="${history}" varStatus="status">
												<tr>
												<td clss="text center">
											    	<%=j%>
													</td>
													<td><a href="historydetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
													<td class="text center">${viewprfinfo.scheme_code}</td>
													<td class="text center">${viewprfinfo.active_flag}</td>
													<td class="text center">${viewprfinfo.creation_date}</td>
													<td class="text center">${viewprfinfo.scheme_type}</td>
													<td class="text center">${viewprfinfo.attribute1}</td>
													<td class="text center">${viewprfinfo.attribute2}</td>
													<td class="text center">${viewprfinfo.attribute3}</td>
													<td class="text center">${viewprfinfo.attribute4}</td>
													<tdclass="text center">${viewprfinfo.attribute5}</td>
													
<%-- 													<td>${viewprfinfo.description}</td> --%>
													
<%-- 													<td>${viewprfinfo.category}</td> --%>
<%-- 													<td>${viewprfinfo.reward_type}</td> --%>
													
													</tr>
													<% j=j+1; %>
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
