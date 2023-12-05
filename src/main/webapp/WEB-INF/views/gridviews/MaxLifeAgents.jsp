
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="it"> <i class="fa fa-home"></i>
				</a></li>
				<li><span>MaxLife Agents</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<form action="updateoutput" method="post" id="Saveform">
		<div class="form-group">
			<div class="col-md-12">
				<div class="col-md-2">
					<label class="control-label" for="inputSuccess">City
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="city" id="city"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<label class="control-label" for="inputSuccess">ADM
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control input-sm mb-md" name="scheme_name"
						id="scheme_name" required="required">
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
			</div>
		</div>

		<hr>
		<label>Last Refreshed : ${LastRefresh}</label>
		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>
				<h2 class="panel-title">Reward Details</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th class="center" width="10%">ADM ID</th>
							<th class="center" width="20%">Agent ID</th>
							<th class="center" width="10%">Agent DOJ</th>
							<th class="center" width="10%">Agent Status</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="info" items="${Info_Grid}" varStatus="status">
							
							<tr>

								<td>${info.ADM_ID}</td>
								<td><a
								href="agentdetails?AGENTID=${info.AGENT_ID}">${info.AGENT_ID}</a></td>
								<td>${info.AGENT_DOJ}</td>
								<td>${info.AGENT_STATUS}</td>
								
							</tr>
							
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
			url : '${pageContext.request.contextPath}/getCity',
			success : function(data) {

				var select = $('#city');
				select.find('option').remove();
				$('<option>').val("").text("--Select--").appendTo(select);
				$.each(data, function(index, value) {
					if (value.location == "${scheme_id}") {
						$('<option selected>').val(value.location).text(
								value.location).appendTo(select);
					} else {
						$('<option>').val(value.location).text(value.location)
								.appendTo(select);
					}
				});

			}
		});

		var schemeid = document.getElementById("city").value;
$.ajax({
			//     url: '${pageContext.request.contextPath}/getschemedepot',
			url : '${pageContext.request.contextPath}/getADMID',
			data : ({
				schemeid : schemeid
			}),
			success : function(data) {

				var select = $('#scheme_name');
				select.find('option').remove();
				$('<option>').val("").text("--Select--").appendTo(select);
				$.each(data, function(index, value) {

					if (value.ADM_ID == "${deptnm}") {

						$('<option selected>').val(value.sch_depot_code).text(
								value.sch_depot_name).appendTo(select);
					} else {
						$('<option>').val(value.ADM_ID).text(
								value.ADM_ID).appendTo(select);
					}

				});

			}
		});


		$('#city')
				.change(
						function(event) {
							var schemeid = $("select#city").val();
    $.ajax({
										//         url: '${pageContext.request.contextPath}/getschemedepot',
										url : '${pageContext.request.contextPath}/getADMID',
										data : ({
											schemeid : schemeid
										}),
										success : function(data) {

											var select = $('#scheme_name');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
											$
													.each(
															data,
															function(index,
																	value) {

																$('<option>')
																		.val(
																				value.ADM_ID)
																		.text(
																				value.ADM_ID)
																		.appendTo(
																				select);

															});

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
		var scheme_name = $('#scheme_name').val();

		window.location.href = "getAgents?ADMID=" + scheme_name + "";
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