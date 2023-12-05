
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="updateoutput" method="post" id="Saveform">

<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Depo Scheme Analysis</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href="marketing"> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="#!">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="schemeanalysis">Depo Scheme Analysis</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Page-header end -->

	<div class="card">
		<div class="card-header">
			<h5>Depo Scheme Analysis</h5>
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
				<div class="col-sm-2">
					<label class="block" for="inputSuccess">Scheme Name : </label>
				</div>
				<div class="col-sm-3">
					<select class="form-control form-control-sm " name="scheme_name"
						id="scheme_name" required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-sm-1"></div>
				<div class="col-md-2">
					<label class="block" for="inputSuccess">Distributors Name :
					</label>
				</div>
				<div class="col-md-3">
					<select class="form-control form-control-sm " name="depot_name"
						id="depot_name" required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-1"></div>
			</div>

			<div class="form-group">
				<div class="col-md-12" style="text-align: center;">
					<input type="button" class="btn btn-primary btn-sm" id="action4"
						name="gen_report" value="Show Report" onclick="myFunction2()"></input>
					<input type="button" class="btn btn-primary btn-sm" id="action5"
						name="show_report" value="Download Report" onclick="myFunction4()"></input>
						<input type="button" class="btn btn-primary btn-sm" id="action6"
						name="dashboard_report" value="Dashboard Report" onclick="myFunction5()"></input>
				</div>
			</div>
</div></div>
			<!-- <hr> -->
				<label>Last Refreshed : ${LastRefresh}</label>
			<div class="card">
			<div class="card-header">
				<h5>Reward Details</h5>
				<div class="card-header-right">
					<ul class="list-unstyled card-option">
						<li><i class="feather icon-maximize full-card"></i></li>
						<li><i class="feather icon-minus minimize-card"></i></li>
						<li><i class="feather icon-trash-2 close-card"></i></li>
					</ul>
				</div>
			</div>
			<!-- <header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>
				<h2 class="panel-title">Reward Details</h2>

			</header> -->
			<!--  -->
			<div class="card-block">
				<div class="dt-responsive table-responsive">
<!-- 					<div id="source" style="overflow-x : auto;"> -->
					<table class="table table-bordered table-striped nowrap"
						id="rewardDetails" data-url="" style="overflow-x: auto;
    display: block;">
						<thead>
							<tr>
								<th class="center" width="10%">Region</th>
								<th class="center" width="20%">State</th>
								<th class="center" width="10%">Distributors</th>
								<th class="center" width="10%">Sup Code</th>
								<th class="center" width="20%">Sup Name</th>
								<th class="center" width="5%">Terr</th>
								<th class="center" width="40%">Terr Name</th>
								<th class="center" width="10%">A/C No.</th>
								<th class="center" width="10%">Bill To</th>
								<th class="center" width="15%">Dlr Cat</th>
								<th class="center" width="15%">Cust Type</th>
								<th class="center" width="40%">A/C Name</th>
								<th class="center" width="20%">Reward Section</th>
								<th class="center" width="15%">Reward Type</th>
								<th class="center" width="15%">Product</th>
								<th class="center" width="15%">Unit</th>
								<th class="center" width="20%">Reward Date</th>
								<th class="center">LY</th>
								<th class="center" width="15%">Target</th>
								<th class="center" width="15%">TY</th>
								<th class="center" width="15%">TGT Pending</th>
								<th class="center" width="15%">Status</th>
								<th class="center" width="15%">Add PTS</th>
								<th class="center" width="20%">Reward Desc</th>
								<th class="center" width="15%">Reward</th>
							</tr>
						</thead>
						<tbody style="">
							<%
								int j = 1;
							%>
							<c:forEach var="info" items="${Info_grid}" varStatus="status">
								<c:set var="reward_section_total">${info.reward_section}</c:set>
								<c:set var="reward_color">${info.reward_color}</c:set>
								<%
									String reward_section_total = (String) pageContext.getAttribute("reward_section_total");
								%>
								<tr>

									<td bgcolor="<c:out value='${reward_color}'/>"><input
										type="hidden" id="opa_analysis_id<%=j%>"
										name="opa_analysis_id" style="width: 100%"
										value="${info.opa_analysis_id}" /> <input type="hidden"
										id="scheme_id<%=j%>" name="scheme_id"
										value="${info.scheme_id}" /> ${info.regn}<input type="hidden"
										id="regn<%=j%>" name="regn" style="width: 100%"
										value="${info.regn}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.state}<input
										type="hidden" id="state<%=j%>" name="state"
										style="width: 100%" value="${info.state}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.depot}<input
										type="hidden" id="depot<%=j%>" name="depot"
										style="width: 100%" value="${info.depot}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.sup_code}<input
										type="hidden" id="sup_code<%=j%>" name="sup_code"
										style="width: 100%" value="${info.sup_code}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.sup_name}<input
										type="hidden" id="sup_name<%=j%>" name="sup_name"
										style="width: 100%" value="${info.sup_name}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.terr_code}<input
										type="hidden" id="terr_code<%=j%>" name="terr_code"
										style="width: 100%" value="${info.terr_code}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.terr_name}<input
										type="hidden" id="terr_name<%=j%>" name="terr_name"
										style="width: 100%" value="${info.terr_name}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_ac_no}<input
										type="hidden" id="dlr_ac_no<%=j%>" name="dlr_ac_no"
										style="width: 100%" value="${info.dlr_ac_no}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_bill_to}<input
										type="hidden" id="dlr_bill_to<%=j%>" name="dlr_bill_to"
										style="width: 100%" value="${info.dlr_bill_to}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_cat}<input
										type="hidden" id="dlr_cat<%=j%>" name="dlr_cat"
										style="width: 100%" value="${info.dlr_cat}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_type}<input
										type="hidden" id="dlr_type<%=j%>" name="dlr_type"
										style="width: 100%" value="${info.dlr_type}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_name}<input
										type="hidden" id="dlr_name<%=j%>" name="dlr_name"
										style="width: 100%" value="${info.dlr_name}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_section}<input
										type="hidden" id="reward_section<%=j%>" name="reward_section"
										style="width: 100%" value="${info.reward_section}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_type}<input
										type="hidden" id="reward_type<%=j%>" name="reward_type"
										style="width: 100%" value="${info.reward_type}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.product}<input
										type="hidden" id="product<%=j%>" name="product"
										style="width: 100%" value="${info.product}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.unit}<input
										type="hidden" id="unit<%=j%>" name="unit" style="width: 100%"
										value="${info.unit}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_date1}<input
										type="hidden" id="reward_date<%=j%>" name="reward_date"
										style="width: 100%" value="${info.reward_date1}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ly}<input
										type="hidden" id="reward_ly<%=j%>" name="reward_ly"
										style="width: 100%" value="${info.reward_ly}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_target}<input
										type="hidden" id="reward_target<%=j%>" name="reward_target"
										style="width: 100%" value="${info.reward_target}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ty}<input
										type="hidden" id="reward_ty<%=j%>" name="reward_ty"
										style="width: 100%" value="${info.reward_ty}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.next_tgt_pending}<input
										type="hidden" id="next_tgt_pending<%=j%>"
										name="next_tgt_pending" style="width: 100%"
										value="${info.next_tgt_pending}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_status}<input
										type="hidden" id="reward_status<%=j%>" name="reward_status"
										style="width: 100%" value="${info.reward_status}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.additional}<input
										type="hidden" id="additional<%=j%>" name="additional"
										style="width: 100%" value="${info.additional}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_description}<input
										type="hidden" id="reward_description<%=j%>"
										name="reward_description" style="width: 100%"
										value="${info.reward_description}" /></td>
									<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_total}<input
										type="hidden" id="reward_total<%=j%>" name="reward_total"
										style="width: 100%" value="${info.reward_total}" /></td>
								</tr>
								<%
									j = j + 1;
								%>
							</c:forEach>
						</tbody>
						<tfoot>
						<tr>
								<th class="center" width="10%">Region</th>
								<th class="center" width="20%">State</th>
								<th class="center" width="10%">Distributors</th>
								<th class="center" width="10%">Sup Code</th>
								<th class="center" width="20%">Sup Name</th>
								<th class="center" width="5%">Terr</th>
								<th class="center" width="40%">Terr Name</th>
								<th class="center" width="10%">A/C No.</th>
								<th class="center" width="10%">Bill To</th>
								<th class="center" width="15%">Dlr Cat</th>
								<th class="center" width="15%">Cust Type</th>
								<th class="center" width="40%">A/C Name</th>
								<th class="center" width="20%">Reward Section</th>
								<th class="center" width="15%">Reward Type</th>
								<th class="center" width="15%">Product</th>
								<th class="center" width="15%">Unit</th>
								<th class="center" width="20%">Reward Date</th>
								<th class="center">LY</th>
								<th class="center" width="15%">Target</th>
								<th class="center" width="15%">TY</th>
								<th class="center" width="15%">TGT Pending</th>
								<th class="center" width="15%">Status</th>
								<th class="center" width="15%">Add PTS</th>
								<th class="center" width="20%">Reward Desc</th>
								<th class="center" width="15%">Reward</th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>
			</div>

			<div class="card">
			<div class="card-header">
				<h5>Document Details</h5>
				<div class="card-header-right">
					<ul class="list-unstyled card-option">
						<li><i class="feather icon-maximize full-card"></i></li>
						<li><i class="feather icon-minus minimize-card"></i></li>
						<li><i class="feather icon-trash-2 close-card"></i></li>
					</ul>
				</div>
			</div>

				<div class="card-block">
					<div class="dt-responsive table-responsive">
						<table class="table table-bordered table-hover nowrap"
							id="fix-header">
						<thead>
							<tr>
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

									<td><input type="text" class="form-control form-control-sm " id="doc_type<%=i%>"
										name="doc_type" value="${grp_reg.doc_type}" readonly
										/></td>

									<td><input type="text" class="form-control form-control-sm " id="doc_title<%=i%>"
										name="doc_title" value="${grp_reg.doc_title}"
										 readonly /></td>

									<td><input type="text" class="form-control form-control-sm " id="doc_srl_no<%=i%>"
										name="doc_srl_no" value="${JSON.scheme_srl_no}"
										 readonly /></td>
									<td><input type="text" class="form-control form-control-sm " id="doc_upload_date<%=i%>"
										name="doc_upload_date" value="${grp_reg.doc_upload_date1}"
										 readonly /></td>

									<td><a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
											class="typcn typcn-download" style="font-size: 30px"></i></a></td>
								</tr>
								<%
									i = i + 1;
								%>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>			
</form>


<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>

$( window ).scroll(function() {$(".table.table-bordered.table-striped.nowrap.dataTable.fixedHeader-floating").css({
	'overflow-x' : '' , 'display' : ''
});});
$(window)
.load(
		function() {
			$('.col-xs-12.col-sm-12').css({
				'overflow-x' : 'auto'
			});

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
				tr.append("_$ta" +  json[i].scheme_code + "_$tag");
				tr.append("_$ta" + json[i].start_date1 + "_$tag");
				tr.append("_$ta" + json[i].end_date1 + "_$tag");
				tr.append("_$ta" + json[i].submission_date1 + "_$tag");
				tr.append("_$ta" + json[i].active_flag + "_$tag");
		
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

<script>
	$(window)
			.load(
					function() {
						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschemenamedepo',
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

						var region = "${scheme_id}";
						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschemedepotanalysis',
									//    data: ({depot :region}),
									success : function(data) {

										var select = $('#depot_name');
										select.find('option').remove();
										// 		$('<option>').val("").text("--Select--").appendTo(select);
										$
												.each(
														data,
														function(index, value) {

															if (value.depot_code == "${deptnm}") {

																$(
																		'<option selected>')
																		.val(
																				value.depot_code)
																		.text(
																				value.depot_name)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.depot_code)
																		.text(
																				value.depot_name)
																		.appendTo(
																				select);
															}

														});

									}
								});

						$('#scheme_name')
								.change(
										function(event) {
											var region = $("select#scheme_name")
													.val();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/getschemedepotanalysis',
														//        data: ({depot :region}),
														success : function(data) {

															var select = $('#depot_name');
															select.find(
																	'option')
																	.remove();
															// 			$('<option>').val("").text("--Select--").appendTo(select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {

																				// 	            	 if(value.depot_code == "${deptnm}"){

																				// 						$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
																				// 	            	 } else {
																				$(
																						'<option>')
																						.val(
																								value.depot_code)
																						.text(
																								value.depot_name)
																						.appendTo(
																								select);
																				// 	            	 }

																			});

														}
													});

										});

					});
</script>
<script type="text/javascript">
	function myFunction3() {
		$("#loading").show();
	}

	function myFunction2() {
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();
	/* 	window.location.href = "loaddepooutputdata?deptnm=" + depot_name
				+ "&&schnm=" + scheme_name + ""; */
		
		window.location.href = "callschoparest_webservice1_new_depo?depot=" + depot_name
		+ "&scheme_id=" + scheme_name + "&bill_to_id=";

	}

	function myFunction4() {
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();

		window.location.href = "downloadloadoutputdata?deptnm=" + depot_name
				+ "&schnm=" + scheme_name + "";
		//$("#show_details").show();
		
	}
	
function myFunction5(){
		
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();
		
		window.location.href = "dashboard_report?deptnm=" + depot_name
		+ "&schnm=" + scheme_name + "";
	}
</script>
<style>
table {
    display: block;
    overflow-x: auto;
    white-space: nowrap;
}

</style>
