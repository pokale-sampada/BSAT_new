

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="card"> 
<div class="card-header">
<h5>Pending Scheme for Approval</h5>
<div class="card-header-right">
<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
</div>
</div>
<div class="card-block">
<div class="form-group row"></div>
<div class="form-group row">
<div class="dt-responsive table-responsive">
<table class="table table-striped table-bordered nowrap"
				id="datatable-editable"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="10%">Sr.No.</th>
						<th class="center" width="26%">Scheme Name</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="10%">Effective From</th>
						<th class="center" width="10%">Effective To</th>
						<th class="center" width="13%">Submission Date</th>

						<th class="center" width="16%">Status</th>

					</tr>
				</thead>
				<tbody>
					<% int j=1; %>
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

							<%-- 													<td>${viewprfinfo.description}</td> --%>

							<%-- 													<td>${viewprfinfo.category}</td> --%>
							<%-- 													<td>${viewprfinfo.reward_type}</td> --%>

						</tr>
						<% j=j+1; %>
					</c:forEach>

				</tbody>
			</table>
</div>
</div>
</div>

		<%-- <header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a>
			</div>

			<h2 class="panel-title">Pending Scheme for Approval</h2>
		</header>
		<div class="panel-body">
			<table class="table table-bordered table-striped"
				id="datatable-editable"
				data-url="assets/ajax/ajax-datatables-sample.json">
				<thead>
					<tr>
						<th class="center" width="10%">Sr.No.</th>
						<th class="center" width="26%">Scheme Name</th>
						<th class="center" width="15%">Scheme Code</th>
						<th class="center" width="10%">Effective From</th>
						<th class="center" width="10%">Effective To</th>
						<th class="center" width="13%">Submission Date</th>

						<th class="center" width="16%">Status</th>

					</tr>
				</thead>
				<tbody>
					<% int j=1; %>
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

																				<td>${viewprfinfo.description}</td>

																				<td>${viewprfinfo.category}</td>
																				<td>${viewprfinfo.reward_type}</td>

						</tr>
						<% j=j+1; %>
					</c:forEach>

				</tbody>
			</table>
		</div> --%>
	

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	$(document).ready(function() {
		$('#datatable-editable').DataTable().draw();
	});
</script>



<script>
	$('#scheme_name').change(function(event) {
		var scheme_id = $("select#scheme_name").val();

		$.ajax({
			url : '${pageContext.request.contextPath}/getstatus',
			data : ({
				scheme_id : scheme_id
			}),
			success : function(data) {

				$.each(data, function(index, value) {

					if (value.active_flag == "Active") {

						$("#gen_report").show();

					} else {
						$("#gen_report").hide();
					}

				});

			}
		});

	});
	//        $(document).ready(function()
	//         {
	//     	   var depot_name = $('#depot_name').val();
	//            var scheme_name = $('#scheme_name').val();
	//     	   if(depot_name =="" && scheme_name=="")
	//     		   {
	// 			        $("#show_report").hide();
	// 			        $("#show_details").hide();

	// 			        var select = $('#scheme_name');
	// 			    	select.find('option').remove();
	// 				    $('<option>').val("").text("--select--").appendTo(select);

	// 				    var select1 = $('#depot_name');
	// 			    	select1.find('option').remove();
	// 				    $('<option>').val("").text("--select--").appendTo(select1);
	//     		   }
	//     	   else{
	// 	    		   $("#gen_report").hide();
	// 	    		   $("#show_report").show();  
	// 	          	  $("#show_details").show();
	//     	  	 }
	//         });
</script>
<script>
	function myFunction1() {
		//         	setTimeout(myFunction3, 1000);
		//         	  var depot_name = $('#depot_name').val();
		var depot_name = "";
		var scheme_id = $('#scheme_name').val();
		var finanalysis = "0";
		var a = confirm("Do you want to proceed for Reward Processing?");
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

			window.location.href = "startrewardprocess?scheme_id=" + scheme_id
					+ "&process_flag=R";

		} else {

		}

	}

	function myFunction3() {
		$("#loading").show();
	}

	function myFunction2() {
		//         	 $("#gen_report").hide(); 
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();

		window.location.href = "loadrewarddata?schnm=" + scheme_name + "";
		//$("#show_details").show();
	}
</script>


<script>
	function submitform() {
		$('#action').val("Update");
		var aa = confirm('Do you want to update this scheme?')
		if (aa == true) {
			$('#Saveform').submit();
		} else {
			return false;
		}
	}

	function submitform1() {
		$('#action').val("Freeze");
		var aa = confirm('Are you sure to freeze this scheme?')
		if (aa == true) {
			$('#Saveform').submit();
		} else {
			return false;
		}
	}
</script>

<script>
	$('.adjustpoints').keyup(
			function() {

				var sum = 0;
				var count = $('.adjustpoints').index(this) + 1;

				$('#sch_tot_cn_pts' + count).val("0");

				var part1_value = $('#part1_value' + count).val();
				var part2_value = $('#part2_value' + count).val();
				var sch_adj_pts = $('#sch_adj_pts' + count).val();

				var sum = parseInt(part1_value) + parseInt(part2_value)
						+ parseInt(sch_adj_pts);

				$('#sch_tot_cn_pts' + count).val(sum);
				$('#attribute1' + count).val("Y");

			});
</script>

<script>
	$(window)
			.load(
					function() {

						$
								.ajax({
									// 					    url: '${pageContext.request.contextPath}/getrwpschemename1',
									url : '${pageContext.request.contextPath}/getrwpschemename',
									success : function(data) {
										var select = $('#scheme_name');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$
												.each(
														data,
														function(index, value) {
															var scheme_nm_code = value.scheme_name
																	+ '('
																	+ value.scheme_code
																	+ ')';
															if (value.scheme_id == "${scheme_id}") {
																$(
																		'<option selected>')
																		.val(
																				value.scheme_id)
																		.text(
																				scheme_nm_code)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.scheme_id)
																		.text(
																				scheme_nm_code)
																		.appendTo(
																				select);
															}
														});

									}
								});

						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschemedepot',
									success : function(data) {
										var select = $('#depot_name');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$
												.each(
														data,
														function(index, value) {
															if (value.depot_name == "${deptnm}") {
																$(
																		'<option selected>')
																		.val(
																				value.depot_name)
																		.text(
																				value.depot_name)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.depot_name)
																		.text(
																				value.depot_name)
																		.appendTo(
																				select);
															}
														});

									}
								});

					});
</script>

<script>
	$(document).ready(function() {

		$("#loading").hide();

	})
</script>
