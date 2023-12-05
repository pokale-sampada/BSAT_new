

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="it"> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Financial Analysis</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a>
			</div>
			<h2 class="panel-title">Review Scheme</h2>
			
		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped" id="datatable-editable"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
                                                         <tr>
                                                         <th class="center" width="10%">Sr.No.</th>
                                                         <th class="center" width="25%">Scheme Name</th>
                                                         <th class="center" width="17%">Scheme Code</th>
                                                         <th class="center" width="12%">Effective From</th>
                                                         <th class="center" width="12%">Effective To</th>

                                                         <th class="center" width="10%">Status</th>
                                                          <th class="center" width="14%">Financial Analysis</th>

<!-- <th class="center" >Description</th> -->
<!-- <th class="center" >Category</th> -->
<!-- <th class="center" >Reward Type</th> -->

</tr>
  </thead>
                                             <tbody>
                                                 <% int j=1; %>
         <c:forEach var="viewprfinfo" items="${list}" varStatus="status">
                                                 <tr>
<td>
<%=j%>
</td>
   <td><a href="reviewschemedetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>

     
     <td>${viewprfinfo.scheme_code} </td>
     <td> ${viewprfinfo.start_date1} </td>
     <td>${viewprfinfo.end_date1} </td>
     <td>${viewprfinfo.active_flag} </td>
     <c:set var="schstatus" value="${viewprfinfo.active_flag}"></c:set>
      <c:set var="schtype" value="${viewprfinfo.scheme_type}"></c:set>
  					<% String schstatus = (String)pageContext.getAttribute("schstatus");
  					String schtype = (String)pageContext.getAttribute("schtype");
  					if(schstatus.equals("Provisioned")){
  						if(schtype.equals("TSI")) {
  					%>
  					 <td><a href="tsifinancialanalysis?scheme_id=${viewprfinfo.scheme_id}">View Report</a> </td>
  					
  						<%} else { %>
  					<td><a href="financialanalysis?scheme_id=${viewprfinfo.scheme_id}">View Report</a> </td>
  					<%}
  					} else { %>
                    
                    <td> </td>   
                        <%} %>




                                                     </tr>
                                                     <% j=j+1; %>
                                                 </c:forEach>

                                                     </tbody>
			</table>
		</div>
	</section>
	<!-- end: page -->
	
	
	
	
	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a> 
			</div>
			<h2 class="panel-title"> Financial Analysis Pending</h2>
			
		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped" id="datatable-editable1"
				data-url="assets/ajax/ajax-datatables-sample.json">
				  <thead>
                                                         <tr>
                                                         <th class="center" width="10%">Sr.No.</th>
                                                         <th class="center" width="30%">Scheme Name</th>
                                                         <th class="center" width="19%">Scheme Code</th>
                                                         <th class="center" width="13%">Effective From</th>
                                                         <th class="center" width="13%">Effective To</th>

                                                         <th class="center" width="15%">Status</th>

<!-- <th class="center" >Description</th> -->
<!-- <th class="center" >Category</th> -->
<!-- <th class="center" >Reward Type</th> -->

</tr>
  </thead>
                                             <tbody>
                                                 <% int k=1; %>
         <c:forEach var="viewprfinfo" items="${Fin_Pending_list}" varStatus="status">
                                                 <tr>
<td>
<%=k%>
</td>
   <td>
<%--    <a href="reviewschemedetails?scheme_id=${viewprfinfo.scheme_id}"> --%>
   ${viewprfinfo.scheme_name}</a></td>

     
     <td>${viewprfinfo.scheme_code} </td>
     <td> ${viewprfinfo.start_date1} </td>
     <td>${viewprfinfo.end_date1} </td>
     <td>${viewprfinfo.active_flag} </td>



                                                     </tr>
                                                     <% k=k+1; %>
                                                 </c:forEach>

                                                     </tbody>
			</table>
		</div>
	</section>
	
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

 <script>
	$(document).ready(function() 
			{
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
			$('#datatable-editable1').DataTable().draw();
			
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
