
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Reward Analysis</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<form action="updateoutput" method="post" id="Saveform">
		<div class="form-group">
			<div class="col-md-12">
				<div class="col-md-2">
					<label class="control-label" for="inputSuccess">Scheme Name
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<label class="control-label" for="inputSuccess">Depot Name
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control input-sm mb-md" name="depot_name"
						id="depot_name" required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12" style="text-align: center;">
				<input type="button" class="btn btn-primary" id="action4"
					name="gen_report" value="Show Report" onclick="myFunction2()"></input>
				<input type="button" class="btn btn-primary" id="action5"
					name="show_report" value="Download Report" onclick="myFunction4()"></input>
			</div>
		</div>

		<hr>
		<label>Last Refreshed : ${LastRefresh}</label>
		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a> <a href="#"
						class="fa fa-times"></a>
				</div>
				<h2 class="panel-title">Reward Details</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th class="center">SR. No</th>
							<th class="center">ADM</th>
							<th class="center">ADM ID</th>
							<th class="center">Joining Date</th>
							<th class="center">ADM Name</th>
							<th class="center">Promotion Date</th>
							<th class="center">Role</th>
							<th class="center">Terminated Count</th>
							<th class="center">Actual MTD Active MM</th>
							<th class="center">Actual NOP</th>
							<th class="center">Actual QP</th>
							<th class="center">Actual WFYP</th>
							<th class="center">Expected MTD Active MM</th>
							<th class="center">Expected NOP</th>
							<th class="center">Expected QP</th>
							<th class="center">Expected WFYP</th>
							<th class="center">MTD Active MM GPA Score</th>
							<th class="center">MTD Active MM Percentage</th>
							<th class="center">NOP GPA Score</th>
							<th class="center">NOP Percentage</th>
							<th class="center">QP GPA Score</th>
							<th class="center">QP Percentage</th>
							<th class="center">Vintage Period</th>
							<th class="center">Weighted Percentage</th>
							<th class="center">Weighted value for MTD Active MM</th>
							<th class="center">Weighted value for NOP</th>
							<th class="center">Weighted value for QP</th>
							<th class="center">Weighted value for WFYP</th>
							<th class="center">WFYP GPA Score</th>
							<th class="center">WFYP GPA Percentage</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 1;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<tr>

								<td><%=j%></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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
					<a href="#" class="fa fa-caret-down"></a> <a href="#"
						class="fa fa-times"></a>
				</div>
				<h2 class="panel-title">Document Details</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable1"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<!-- <th class="center" width="10%">Region</th>
							<th class="center" width="20%">State</th>
							<th class="center" width="10%">Depo</th> -->


							<th class="center">Sr. No.</th>
							<th class="center">Document Type</th>
							<th class="center">Document Title</th>
							<th class="center">Reference Number</th>
							<th class="center">Upload Date</th>
							<th class="center">Download File</th>
						</tr>
					</thead>
					<tbody>

						<%
							int i = 1;
						%>
						<c:forEach var="grp_reg" items="${doc_list}" varStatus="status">

							<tr>
								<td><%=i%> <input type="hidden"
									value="${grp_reg.scheme_doc_id}" id="scheme_doc_id<%=i%>"
									name="scheme_doc_id" /></td>

								<td><input type="text" class="lovdata" id="doc_type<%=i%>"
									name="doc_type" value="${grp_reg.doc_type}"
									style="width: 100%;" readonly /></td>

								<td><input type="text" id="doc_title<%=i%>"
									name="doc_title" value="${grp_reg.doc_title}"
									style="width: 100%;" readonly /></td>

								<td><input type="text" id="doc_srl_no<%=i%>"
									name="doc_srl_no" value="${JSON.scheme_srl_no}"
									style="width: 100%;" readonly /></td>
								<td><input type="text" id="doc_upload_date<%=i%>"
									name="doc_upload_date" value="${grp_reg.doc_upload_date1}"
									style="width: 100%;" readonly /></td>

								<td><a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
										class="fa fa-download bigger-160" aria-hidden="true"></i></a></td>
							</tr>
							<%
								i = i + 1;
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
	$(document).ready(function() {
		$('#datatable-editable').DataTable().draw();
		$('#datatable-editable1').DataTable().draw();
	});
</script>




<script>
$(window)
.load(
		function() {
$.ajax({
			//     url: '${pageContext.request.contextPath}/getschemename1',
			url : '${pageContext.request.contextPath}/getschschemename',
			success : function(data) {

				var select = $('#scheme_name');
				select.find('option').remove();
				$('<option>').val("").text("--Select--").appendTo(select);
				$.each(data, function(index, value) {
					var scheme_nm_code = value.scheme_name + '('
							+ value.scheme_code + ')';
					if (value.scheme_id == "${scheme_id}") {
						$('<option selected>').val(value.scheme_id).text(
								scheme_nm_code).appendTo(select);
					} else {
						$('<option>').val(value.scheme_id).text(scheme_nm_code)
								.appendTo(select);
					}
				});

			}
		});

		var schemeid = "${scheme_id}";
$.ajax({
			//     url: '${pageContext.request.contextPath}/getschemedepot',
			url : '${pageContext.request.contextPath}/getschemedepotdetails',
			data : ({
				schemeid : schemeid
			}),
			success : function(data) {

				var select = $('#depot_name');
				select.find('option').remove();
				$('<option>').val("").text("--Select--").appendTo(select);
				$.each(data, function(index, value) {

					//             	 if(value.depot_code == "${deptnm}"){

					// 					$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
					//             	 } else {
					//             		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
					//             	 }

					if (value.sch_depot_code == "${deptnm}") {

						$('<option selected>').val(value.sch_depot_code).text(
								value.sch_depot_name).appendTo(select);
					} else {
						$('<option>').val(value.sch_depot_code).text(
								value.sch_depot_name).appendTo(select);
					}

				});

			}
		});

		$.ajax({
			url : '${pageContext.request.contextPath}/getschopawebserviceUrl',
			data : ({
				scheme_id : schemeid
			}),
			success : function(data) {

				$('#schopawebservice').val(data);

			}
		});

		$('#scheme_name')
				.change(
						function(event) {
							var schemeid = $("select#scheme_name").val();
    $.ajax({
										//         url: '${pageContext.request.contextPath}/getschemedepot',
										url : '${pageContext.request.contextPath}/getschemedepotdetails',
										data : ({
											schemeid : schemeid
										}),
										success : function(data) {

											var select = $('#depot_name');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
											$
													.each(
															data,
															function(index,
																	value) {

																// 	            	 if(value.depot_code == "${deptnm}"){

																// 						$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
																// 	            	 } else {
																// 	            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
																// 	            	 }

																//	 	            	 if(value.sch_depot_code == "${deptnm}"){

																//	 						$('<option selected>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
																//	 	            	 } else {
																$('<option>')
																		.val(
																				value.sch_depot_code)
																		.text(
																				value.sch_depot_name)
																		.appendTo(
																				select);
																//	 	            	 }

															});

										}
									});

							$
									.ajax({
										url : '${pageContext.request.contextPath}/getschopawebserviceUrl',
										data : ({
											scheme_id : schemeid
										}),
										success : function(data) {

											$('#schopawebservice').val(data);

										}
									});

						});

	});
</script>
<script>
	function myFunction1() {

		//         	setTimeout(myFunction3, 1000);
		//         	  var depot_name = $('#depot_name').val();
		//               var scheme_id = $('#scheme_name').val();
		//               var finanalysis = "0";

		//         	$.ajax({
		// 			    url: '${pageContext.request.contextPath}/callopa',
		// 			    data:({depot_name : depot_name ,scheme_id : scheme_id, finanalysis : finanalysis}),
		// 			    success: function(data) {				        	

		// 			       		$("#loading").hide();
		// 			       		myFunction2();
		// 			    }
		// 			  });

		var schopawebservice = $('#schopawebservice').val();
		var scheme_id = $('#scheme_name').val();
		var depot_code = $('#depot_name').val();
		//             var dlr_ac_name = "";

		if (scheme_id != "") {
			if (depot_code != "") {
				//             		if(dlr_ac_name != ""){
				if (schopawebservice != null && schopawebservice != "") {
					window.location.href = "callSchOpaWebservloadoutputdata?scheme_id="
							+ scheme_id + "&depot=" + depot_code;

				} else {
					alert("No OPA Webservice url for this scheme");
				}
				//             		} else{
				//                     	alert("Please select dealer name.");
				//                     }

			} else {
				alert("Please select depot name.");
			}

		} else {
			alert("Please select scheme name.");
		}

		//	 window.location.href = "loadoutputdata?deptnm="+depot_name+"&&schnm="+scheme_name+"";
	}

	function myFunction3() {
		$("#loading").show();
	}

	function myFunction4() {
		//         	 $("#gen_report").hide(); 
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();

		window.location.href = "downloadloadoutputdata?deptnm=" + depot_name
				+ "&schnm=" + scheme_name + "";
		//$("#show_details").show();
	}
</script>

<script>
	function myFunction2() {
		//         	 $("#gen_report").hide(); 
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();

		window.location.href = "loadoutputdata?deptnm=" + depot_name
				+ "&schnm=" + scheme_name + "";
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
	$('.docalculation').keyup(function() {

		$('#sch_total' + count).val("0");

		var count = $('.docalculation').index(this) + 1;
		var sch_ty_tot_vol = $('#sch_ty_tot_vol' + count).val();
		var sch_adjusted = $('#sch_adjusted' + count).val();

		var sum = parseInt(sch_ty_tot_vol) + parseInt(sch_adjusted);

		$('#sch_total' + count).val(sum);
		$('#change_flag' + count).val("Y");
	});
</script>



<script>
	$(document).ready(function() {

		$("#loading").hide();

	});
</script>