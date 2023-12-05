
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Freeze Scheme</span></li>
				<li><span></span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<form action="updateoutput" method="post" id="Saveform">
		<div class="form-group">
			<div class="col-md-12">
				<div class="col-md-5">
					<h5>
						<label class="control-label" for="inputSuccess">Freeze
							Schemes for Adjustment Reward Approval : </label>
					</h5>
				</div>
				<div class="col-md-7">
					<input type="button" class="btn btn-primary" name="gen_report"
						id="gen_report" style="margin-left: 5%" value="Freeze Schemes"
						onclick="myFunction1()">
				</div>

			</div>
		</div>
		<hr>

		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a> <a href="#"
						class="fa fa-times"></a>
				</div>
				<h2 class="panel-title">Freeze Schemes</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th class="center" style="width: 5%">Sr.No.</th>
							<th class="center" style="width: 30%">Scheme Name</th>
							<th class="center" style="width: 20%">Scheme Code</th>
							<th class="center" style="width: 13%">Effective From</th>
							<th class="center" style="width: 13%">Effective To</th>

							<th class="center" style="width: 19%">Status</th>

						</tr>
					</thead>
					<tbody>

						<%
							int k = 1;
						%>
						<c:forEach var="viewprfinfo" items="${Rew_Sch_Freeze_list}"
							varStatus="status">
							<tr>
								<td><%=k%></td>
								<td>
									<%--    <a href="reviewschemedetails?scheme_id=${viewprfinfo.scheme_id}"> --%>
									${viewprfinfo.scheme_name}</a>
								</td>


								<td>${viewprfinfo.scheme_code}</td>
								<td>${viewprfinfo.start_date1}
								<td>${viewprfinfo.end_date1}</td>
								<td>${viewprfinfo.active_flag}</td>



							</tr>
							<%
								k = k + 1;
							%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</form>
	<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	function myFunction1() {
		//         	setTimeout(myFunction3, 1000);
		//         	  var depot_name = $('#depot_name').val();
		var depot_name = "";
		var scheme_id = $('#scheme_name').val();
		var finanalysis = "0";
		var a = confirm("This will Freeze all processed schemes pending for this month's Redemption. Do you want to proceed for Freeze Schemes?");
		if (a == true) {

			//         	$.ajax({
			// 			    url: '${pageContext.request.contextPath}/callopa',
			// 			    data:({depot_name : depot_name ,scheme_id : scheme_id, finanalysis : finanalysis}),
			// 			    success: function(data) {				        	

			// 			    		 $("#show_report").show();  
			// 			       		$("#show_details").show();
			// 			       		$("#gen_report").hide();
			// 			       		$("#loading").hide();
			// 			       		myFunction2();
			// 			    }
			// 			  });

			//	 window.location.href = "callopa?deptnm="+depot_name+"&&schnm="+scheme_name+"";

			window.location.href = "startschemerewardfreeze?process_flag=R";

		} else {

		}

	}
</script>
<script>
	$(document).ready(function() {
		

		$('#datatable-editable').DataTable().draw();

		

	});
</script>
