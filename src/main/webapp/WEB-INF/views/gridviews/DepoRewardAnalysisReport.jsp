
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<form action="updateoutput" ModelAttribute="Bpil_Opa_Rw_Analysis_Rw"
	method="post" id="Saveform" enctype="multipart/form-data">
	
							<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Reward Analysis Report</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href=""> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="BudgetVsActualReport">RW Analysis</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              <!-- Page-header end -->
	
	<div class="card">
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Scheme Name<span class="required">*</span></label>
					<select class="form-control form-control-sm "
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Distributors<span class="required">*</span></label>
					<select class="form-control form-control-sm "
						data-plugin-selectTwo name="appl_depot_code" id="appl_depot_code"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Dealer Name<span class="required">*</span></label>
					<select class="form-control form-control-sm "
						data-plugin-selectTwo name="dlr_ac_name" id="dlr_ac_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div style="display: none;">
					<label class="control-label" for="inputSuccess">Bill To Id</label>
					<select class="form-control form-control-sm "
						data-plugin-selectTwo name="bill_to_id" id="bill_to_id"
						required="required">
					</select>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-md-12" style="text-align: center;">
					<input type="button" class="btn btn-primary btn-sm" id="action4"
						value="Show Report" onclick="searchinfo()"></input>
					<input type="button" class="btn btn-primary btn-sm" id="action_download"
						value="Download Report" onclick="downloadreport()"></input>
				</div>
			</div>
		</div>
	</div>

	<!-- 		<hr> -->
	<label style="font-weight: bold !important">Redeemed On :
		${LastRefresh}</label>
	<!-- start: page -->
	<div class="card">
		<div class="card-header">
			<h5>Dealer Details</h5>


		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="simpletable"
					class="table table-bordered nowrap table-hover" style="overflow-x: auto;">
					<thead>
						<tr>
							<th class="text-center" style="min-width: 30px !important; width: 60px !important">Region</th>
							<th class="text-center" style="min-width: 50px !important; width: 70px !important">State</th>
							<th class="text-center" style="min-width: 100px;">Distributors</th>
							<th class="text-center" style="min-width: 30px !important;">Terr</th>
							<th class="text-center" style="min-width: 120px; width: 118px">Terr Name</th>
							<th class="text-center" style="min-width: 70px;">A/C No.</th>
							<th class="text-center" style="min-width: 60px;">Bill To</th>
							<th class="text-center" style="min-width: 60px;">Dlr Cat</th>
							<th class="text-center" style="min-width: 80px;">Cust Type</th>
							<th class="text-center" style="min-width: 250px;">A/C Name</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center" >${info0.regn}</td>
							<td class="text-center" >${info0.state}</td>
							<td class="text-center" >${info0.depot}</td>
							<td class="text-center" >${info0.terr_code}</td>
							<td class="text-center" >${info0.terr_name}</td>
							<td class="text-center" >${info0.dlr_ac_no}</td>
							<td class="text-center" >${info0.dlr_bill_to}</td>
							<td class="text-center" >${info0.dlr_cat}</td>
							<td class="text-center" >${info0.dlr_type}</td>
							<td class="text-center" >${info0.dlr_name}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header">
			<h5>Reward Details</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="order-table"
					class="table table-striped table-bordered nowrap" data-url="" style="overflow-x: auto;
    display: block;">
					
					<thead>
						<tr>
							<th style="min-width: 150px;">Reward Section</th>
							<th style="min-width: 140px;">Reward Type</th>
							<th style="min-width: 80px;">Product</th>
							<th style="min-width: 80px;">Unit</th>
							<th style="min-width: 120px;">Reward Date</th>
							<th style="min-width: 80px;">LY</th>
							<th style="min-width: 80px;">Target</th>
							<th style="min-width: 80px;">TY</th>
							<th style="min-width: 120px;">TGT Pending</th>
							<th style="min-width: 80px;">Status</th>
							<th style="min-width: 90px;">Add PTS</th>
							<th style="min-width: 150px;">Reward Desc</th>
							<th style="min-width: 80px;">Reward</th>
							<th style="min-width: 80px;">Adjustments</th>
							<th style="min-width: 160px;">Adjustment Reason</th>
							<th style="min-width: 100px;">Gift TO CN</th>
							<th style="min-width: 160px;">Converted CN Value</th>
							<th style="min-width: 150px;">Adjustment Flag</th>
							<th style="min-width: 100px;">Adjustment Doc</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 0;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<c:set var="interface_status">${info.interface_status}</c:set>
							<c:set var="reward_section_total">${info.reward_section}</c:set>
							<c:set var="reward_gift_id">${info.reward_gift_id}</c:set>
							<c:set var="reward_color">${info.reward_color}</c:set>
							<%
								String interface_status = (String) pageContext.getAttribute("interface_status");
							%>
							<%
								String reward_section_total = (String) pageContext.getAttribute("reward_section_total");
									String reward_gift_id = (String) pageContext.getAttribute("reward_gift_id");
							%>
							<%
								if (interface_status.equals("P")) {
							%>
							<tr style="background-color: #c5d0dc;">
								<%
									} else {
								%>
							
							<tr>
								<%
									}
								%>

								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="hidden" id="opa_analysis_id<%=j%>"
									name="info[<%=j%>].opa_analysis_id" style="width: 100%"
									value="${info.opa_analysis_id}" /> <input type="hidden"
									id="scheme_id<%=j%>" name="info[<%=j%>].scheme_id"
									value="${info.scheme_id}" /> ${info.reward_section}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_type}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.product}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.unit}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_date1}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ly}</td>

								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_target}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ty}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.next_tgt_pending}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_status}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.additional}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_description}<input
									type="hidden" id="reward_description<%=j%>"
									name="info[<%=j%>].reward_description" style="min-width: 100%"
									value="${info.reward_description}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_total}<input
									type="hidden" id="reward_total<%=j%>"
									name="info[<%=j%>].reward_total" style="min-width: 100%"
									value="${info.reward_total}" /><input
									type="hidden" id="dlr_bill_to<%=j%>"
									name="info[<%=j%>].dlr_bill_to" style="min-width: 100%"
									value="${info.dlr_bill_to}" /></td>
								<%
									if (interface_status.equals("P")) {
								%>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="adjustments<%=j%>"
									name="info[<%=j%>].adjustments" style="width: 100%"
									value="${info.adjustments}" class="adjustpoints form-control"
									onblur="blur_fn(<%=j%>)"   pattern="[0-9]{1,15}" readonly/></td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="adjustment_reason<%=j%>"
									name="info[<%=j%>].adjustment_reason" style="width: 100%"
									value="${info.adjustment_reason}"
									class="adjustreason form-control" readonly/></td>

								<td bgcolor="<c:out value='${reward_color}'/>">
									<%
										if (reward_gift_id.equals("")) {
									%> <input type="hidden" id="reward_gift_id<%=j%>"
									name="info[<%=j%>].reward_gift_id" style="width: 100%"
									value="${info.reward_gift_id}" /> <input type="text"
									id="gift_to_cn_flag<%=j%>" name="info[<%=j%>].gift_to_cn_flag"
									style="width: 100%" class="form-control"
									value="${info.gift_to_cn_flag}" readonly /> <%
										} else {
									%> <input type="hidden" id="reward_gift_id<%=j%>"
									name="info[<%=j%>].reward_gift_id" style="width: 100%"
									value="${info.reward_gift_id}" /> <input type="text"
									id="gift_to_cn_flag<%=j%>" class="form-control"
									name="info[<%=j%>].gift_to_cn_flag" style="width: 100%"
									value="${info.gift_to_cn_flag}" onblur="gifttocn(<%=j%>)" /> <%
 	}
 %>
								</td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="converted_cn_value<%=j%>"
									name="info[<%=j%>].converted_cn_value" style="width: 100%"
									value="${info.converted_cn_value}"
									class="adjustcn form-control"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}"
									readonly="readonly" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="attribute1<%=j%>" class="form-control"
									name="info[<%=j%>].attribute1" style="width: 100%"
									value="${info.attribute1}" readonly /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">
									<div class="col-xs-12">
										<input type="file" name="info[<%=j%>].doc_file2"
											id="doc_file<%=j%>" />
									</div>
								</td>
								<%
									} else {
								%>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.adjustments}<input
									type="hidden" id="adjustments<%=j%>"
									name="info[<%=j%>].adjustments" style="width: 100%"
									value="${info.adjustments}" onblur="blur_fn(<%=j%>)" class="adjustpoints form-control"
								  pattern="[0-9]{1,15}" readonly/></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.adjustment_reason}<input
									type="hidden" id="adjustment_reason<%=j%>"
									name="info[<%=j%>].adjustment_reason" style="width: 100%"
									value="${info.adjustment_reason}"
									class="adjustreason form-control" readonly/></td>

								<td bgcolor="<c:out value='${reward_color}'/>">${info.gift_to_cn_flag}<input
									type="hidden" id="gift_to_cn_flag<%=j%>"
									name="info[<%=j%>].gift_to_cn_flag" style="width: 100%"
									value="${info.gift_to_cn_flag}" class="adjustgift form-control" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.converted_cn_value}<input
									type="hidden" id="converted_cn_value<%=j%>"
									name="info[<%=j%>].converted_cn_value" style="width: 100%"
									value="${info.converted_cn_value}"
									class="adjustcn form-control"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.attribute1}<input
									type="hidden" id="attribute1<%=j%>" class="form-control"
									name="info[<%=j%>].attribute1" style="width: 100%"
									value="${info.attribute1}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="hidden" name="info[<%=j%>].doc_file2" id="doc_file<%=j%>"
									class="col-xs-12 col-sm-4" /></td>
								<%
									}
								%>
							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- 	<hr> -->
	<div class="form-group">
		<div class="col-md-12" style="text-align: center;">
			<input type="hidden" name="action" id="action" value="" /> <input
				type="hidden" class="btn btn-primary btn-sm" id="action1"
				name="gen_report" value="Save" onclick="submitform()"></input>  <input
				type="hidden" class="btn btn-primary btn-sm" id="action2"
				value="Freeze Scheme" onclick="submitform1()"></input> 

		</div>
	</div>

</form>

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
									url : '${pageContext.request.contextPath}/getrewardanalysisschemedepo',
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

						var schemeid = "${scheme_id}";
						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschemedepotanalysis',
									// 						   data: ({schemeid :schemeid}),
									success : function(data) {

										var select = $('#appl_depot_code');
										select.find('option').remove();
										// 								$('<option>').val("").text("--Select--").appendTo(select);
										$
												.each(
														data,
														function(index, value) {

															if (value.depot_code == "${depo_code}") {

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

						var depo = "${depo_code}";

						$
								.ajax({
									url : '${pageContext.request.contextPath}/getdealer_name',
									data : ({
										depot : depo,
										schemeid : schemeid
									}),

									success : function(data) {

										var select = $('#dlr_ac_name');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$
												.each(
														data,
														function(index, value) {
															// 	 					           		if(value.dlr_ac_no == "${dealer_code}"){

															// 	 					           			$('<option selected>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
															// 	 					           		}
															// 	 					           		else {
															// 	 					           		$('<option>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
															// 	 					           		}

															if (value.dlr_bill_to == "${dealer_code}") {

																$(
																		'<option selected>')
																		.val(
																				value.dlr_bill_to)
																		.text(
																				value.dlr_ac_no
																						+ " - "
																						+ value.dlr_name)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.dlr_bill_to)
																		.text(
																				value.dlr_ac_no
																						+ " - "
																						+ value.dlr_name)
																		.appendTo(
																				select);
															}

														});

									}
								});

						var dealer = "${dealer_code}";
						$
								.ajax({
									url : '${pageContext.request.contextPath}/getbilltoid',
									data : ({
										dealer : dealer,
										depot : depo,
										schemeid : schemeid
									}),
									success : function(data) {

										var select = $('#bill_to_id');
										select.find('option').remove();
										// 	 					    	$('<option>').val("").text("--Select--").appendTo(select);
										$
												.each(
														data,
														function(index, value) {

															if (value.opa_rw_an_dealer_id == "${dealer_billto}") {

																$(
																		'<option selected>')
																		.val(
																				value.opa_rw_an_dealer_id)
																		.text(
																				value.opa_rw_an_dealer_id)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.opa_rw_an_dealer_id)
																		.text(
																				value.opa_rw_an_dealer_id)
																		.appendTo(
																				select);
															}
														});

									}
								});

						$('#scheme_name')
								.change(
										function(event) {
											var schemeid = $(
													"select#scheme_name").val();

											$
													.ajax({
														url : '${pageContext.request.contextPath}/getschemedepotanalysis',
														// 	                        data: ({schemeid :schemeid}),
														success : function(data) {

															var select = $('#appl_depot_code');
															select.find(
																	'option')
																	.remove();
															// 	 					    	$('<option>').val("").text("--Select--").appendTo(select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {

																				$(
																						'<option>')
																						.val(
																								value.depot_code)
																						.text(
																								value.depot_name)
																						.appendTo(
																								select);

																			});
															// 	 					           	var select1 = $('#dlr_ac_name');
															// 		 					    	select1.find('option').remove();
															// 		 					    	$('<option>').val("").text("--Select--").appendTo(select1);

															// 		 					    	var select2 = $('#bill_to_id');
															// 		 					    	select2.find('option').remove();
															// 		 					    	$('<option>').val("").text("--Select--").appendTo(select2);

															var schemeid = $(
																	"select#scheme_name")
																	.val();
															var depot = $(
																	"select#appl_depot_code")
																	.val();

															$
																	.ajax({
																		url : '${pageContext.request.contextPath}/getdealer_name',
																		data : ({
																			depot : depot,
																			schemeid : schemeid
																		}),

																		success : function(
																				data) {

																			var select = $('#dlr_ac_name');
																			select
																					.find(
																							'option')
																					.remove();
																			$(
																					'<option>')
																					.val(
																							"")
																					.text(
																							"--Select--")
																					.appendTo(
																							select);
																			$
																					.each(
																							data,
																							function(
																									index,
																									value) {

																								// 					 								$('<option>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);

																								$(
																										'<option>')
																										.val(
																												value.dlr_bill_to)
																										.text(
																												value.dlr_ac_no
																														+ " - "
																														+ value.dlr_name)
																										.appendTo(
																												select);

																							});

																			var select2 = $('#bill_to_id');
																			select2
																					.find(
																							'option')
																					.remove();
																			$(
																					'<option>')
																					.val(
																							"")
																					.text(
																							"--Select--")
																					.appendTo(
																							select2);

																		}
																	});

														}
													});

										});

						$('#appl_depot_code')
								.change(
										function(event) {

											var schemeid = $(
													"select#scheme_name").val();
											var depot = $(
													"select#appl_depot_code")
													.val();

											$
													.ajax({
														url : '${pageContext.request.contextPath}/getdealer_name',
														data : ({
															depot : depot,
															schemeid : schemeid
														}),

														success : function(data) {

															var select = $('#dlr_ac_name');
															select.find(
																	'option')
																	.remove();
															$('<option>')
																	.val("")
																	.text(
																			"--Select--")
																	.appendTo(
																			select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {

																				$(
																						'<option>')
																						.val(
																								value.dlr_ac_no)
																						.text(
																								value.dlr_name)
																						.appendTo(
																								select);

																			});

															var select2 = $('#bill_to_id');
															select2.find(
																	'option')
																	.remove();
															$('<option>')
																	.val("")
																	.text(
																			"--Select--")
																	.appendTo(
																			select2);

														}
													});

										});

						$('#dlr_ac_name')
								.change(
										function(event) {
											var dealer = $("select#dlr_ac_name")
													.val();
											var schemeid = $(
													"select#scheme_name").val();
											var depot = $(
													"select#appl_depot_code")
													.val();

											$
													.ajax({
														url : '${pageContext.request.contextPath}/getbilltoid',
														data : ({
															dealer : dealer,
															depot : depot,
															schemeid : schemeid
														}),
														success : function(data) {

															var select = $('#bill_to_id');
															select.find(
																	'option')
																	.remove();
															// 	 					    	$('<option>').val("").text("--Select--").appendTo(select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {

																				$(
																						'<option>')
																						.val(
																								value.opa_rw_an_dealer_id)
																						.text(
																								value.opa_rw_an_dealer_id)
																						.appendTo(
																								select);

																			});

														}
													});

										});

						var region_type = "REGION_TYPE";

						$
								.ajax({
									url : '${pageContext.request.contextPath}/loadregion',
									data : ({
										region : region_type
									}),
									success : function(data) {
										var select = $('#appl_regn_code');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$
												.each(
														data,
														function(index, value) {
															if (value == "${JSON.appl_regn_code}") {
																$(
																		'<option selected>')
																		.val(
																				value)
																		.text(
																				value)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value)
																		.text(
																				value)
																		.appendTo(
																				select);
															}
														});

									}
								});

						$('#depot_name')
								.change(
										function(event) {

											var region = $("select#depot_name")
													.val();

											$
													.ajax({
														url : '${pageContext.request.contextPath}/getdealer_name',
														data : ({
															depot : region
														}),
														success : function(data) {

															var select = $('#dealer_name');
															select.find(
																	'option')
																	.remove();
															$('<option>')
																	.val("")
																	.text(
																			"--Select--")
																	.appendTo(
																			select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {
																				if (value.depot_name == "${deptnm}") {
																					$(
																							'<option selected>')
																							.val(
																									value.dealer_name)
																							.text(
																									value.dealer_name)
																							.appendTo(
																									select);
																				} else {
																					$(
																							'<option>')
																							.val(
																									value.dealer_name)
																							.text(
																									value.dealer_name)
																							.appendTo(
																									select);
																				}
																			});

														}
													});

										});

						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschemeterr',
									success : function(data) {
										var select = $('#terr_name');
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

<script type="text/javascript">
	function downloadreport() {
		var scheme_name=document.getElementById("scheme_name").value;	
		var depot_code=document.getElementById("appl_depot_code").value;
		var dealer_name=document.getElementById("dlr_ac_name").value;
	

		window.location.href="downloadloadoutputdata_depo?schnm="+scheme_name+"&deptnm="+depot_code+"&dealer="+dealer_name;

	}

	function searchinfo() {
		if (document.getElementById("scheme_name").value == "") {
			alert("Please select scheme name");
		} else {
			
				var scheme_name=document.getElementById("scheme_name").value;	
				var depot_code=document.getElementById("appl_depot_code").value;
				var dealer_name=document.getElementById("dlr_ac_name").value;
				var bill_to_id=document.getElementById("bill_to_id").value;

				window.location.href="depo_show_report?scheme_name="+scheme_name+"&depot_code="+depot_code+"&dealer_name="+dealer_name+"&bill_to_id="+bill_to_id;

			
		}
	}
</script>
