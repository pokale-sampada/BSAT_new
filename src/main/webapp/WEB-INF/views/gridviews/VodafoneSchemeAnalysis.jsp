
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<form action="updateoutput" method="post" id="Saveform">
	<div class="card">
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-2">
					<label class="control-label" for="inputSuccess">Scheme Name
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control form-control-sm form-control-primary"
						data-plugin-selectTwo name="maxlife_scheme_name"
						id="maxlife_scheme_name" required="required">
						<option>--Select--</option>
						<option value="vodafone">Telecom Scheme</option>
					</select>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<label class="control-label" for="inputSuccess">Month : </label>
				</div>
				<div class="col-md-3">
					<select class="form-control form-control-sm form-control-primary" name="month" id="month"
						required="required">
						<option>--Select--</option>
						<option value="APR19">April</option>
						<option value="MAY19">May</option>
						<option value="JUN19">June</option>
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
				</div>
			</div>
		</div>
	</div>
		<label>Last Refreshed : ${LastRefresh}</label>
		<!-- start: page -->
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
					<div class="card-block">
						<div class="dt-responsive table-responsive">
					<table class="table table-bordered table-striped nowrap"
						id="header-footer-fix" data-url="">
					<thead>
						<tr>
							<th class="center" style="min-width:70px;">RW ID</th>
							<th class="center" style="min-width:70px;">RANGE</th>
							<th class="center" style="min-width:70px;">CIRCLE</th>
							<th class="center" style="min-width:150px;">EMP NAME</th>
							<th class="center" style="min-width:70px;">EMP CODE</th>
							<th class="center" style="min-width:150px;">ROLE</th>
							<th class="center" style="min-width:70px;">EMP STATUS</th>
							<th class="center" style="min-width:100px;">MONTH</th>
							<th class="center" style="min-width:100px;">TARGET PAYOUT</th>
							<th class="center" style="min-width:70px;">P1 MONTHLY TGT</th>
							<th class="center" style="min-width:70px;">P1 MONTHLY ACH</th>
							<th class="center" style="min-width:70px;">P1 CUM TGT</th>
							<th class="center" style="min-width:80px;">P1 CUM ACH</th>
							<th class="center" style="min-width:100px;">P1 PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P1 PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P1 PAYOUT MTD</th>
							<th class="center" style="min-width:100px;">P1 PAYOUT YTD</th>
							<th class="center" style="min-width:70px;">P1 WEIGHTAGE</th>
							<th class="center" style="min-width:80px;">P2 MOB MONTHLY TGT</th>
							<th class="center" style="min-width:80px;">P2 MOB MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 MOB CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 MOB CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 PER MOB MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 MOB PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 FLD MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 FLD CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 FLV MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 FLV CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 IOT MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 IOT CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 CLD MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 CLD CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 TOT PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 TOT PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 TOT PAYOUT MTD</th>
							<th class="center" style="min-width:100px;">P2 TOT PAYOUT YTD</th>
							<th class="center" style="min-width:100px;">P2 TOT WEIGHTAGE</th>
							<th class="center" style="min-width:100px;">P3 SEG1 MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG1 MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG1 CUM TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG1 CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG1 PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG1 PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG2 MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 CUM TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG2 CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 TOT PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P3 TOT PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 TOT PAYOUT MTD</th>
							<th class="center" style="min-width:100px;">P3 TOT PAYOUT YTD</th>
							<th class="center" style="min-width:100px;">P3 TOT WEIGHTAGE</th>
							<th class="center" style="min-width:100px;">P1 QTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P1 YTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P2 QTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P2 YTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P3 QTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P3 YTD PAYOUT</th>
							<th class="center" style="min-width:100px;">overall ach</th>
							<th class="center" style="min-width:100px;">TOT PAYOUT SIP</th>
							<th class="center" style="min-width:100px;">FINAL PAYOUT AMT</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 1;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<tr>
								<td><%=j%></td>
								<td>${info.range}</td>
								<td>${info.circle}</td>
								<td>${info.emp_name}</td>
								<td>${info.emp_code}</td>
								<td>${info.role}</td>
								<td>${info.emp_status}</td>
								<td>${info.month}</td>
								<td>${info.target_payout}</td>
								<td>${info.p1_monthly_tgt}</td>
								<td>${info.p1_monthly_ach}</td>
								<td>${info.p1_cum_tgt}</td>
								<td>${info.p1_cum_ach}</td>
								<td>${info.p1_monthly_ach_per}</td>
								<td>${info.p1_cum_ach_per}</td>
								<td>${info.p1_mtd}</td>
								<td>${info.p1_ytd}</td>
								<td>${info.p1_weightage}</td>
								<td>${info.p2_mb_monthly_tgt}</td>
								<td>${info.p2_mb_monthly_ach}</td>
								<td>${info.p2_mb_cum_tgt}</td>
								<td>${info.p2_mb_cum_ach}</td>
								<td>${info.p2_mb_monthly_ach_per}</td>
								<td>${info.p2_mb_cum_ach_per}</td>
								<td>${info.p2_fld_monthly_tgt}</td>
								<td>${info.p2_fld_monthly_ach}</td>
								<td>${info.p2_fld_cum_tgt}</td>
								<td>${info.p2_fld_cum_ach}</td>
								<td>${info.p2_fld_monthly_ach_per}</td>
								<td>${info.p2_fld_cum_ach_per}</td>
								<td>${info.p2_flv_monthly_tgt}</td>
								<td>${info.p2_flv_monthly_ach}</td>
								<td>${info.p2_flv_cum_tgt}</td>
								<td>${info.p2_flv_cum_ach}</td>
								<td>${info.p2_flv_monthly_ach_per}</td>
								<td>${info.p2_flv_cum_ach_per}</td>
								<td>${info.p2_iot_monthly_tgt}</td>
								<td>${info.p2_iot_monthly_ach}</td>
								<td>${info.p2_iot_cum_tgt}</td>
								<td>${info.p2_iot_cum_ach}</td>
								<td>${info.p2_iot_monthly_ach_per}</td>
								<td>${info.p2_iot_cum_ach_per}</td>
								<td>${info.p2_cloud_monthly_tgt}</td>
								<td>${info.p2_cloud_monthly_ach}</td>
								<td>${info.p2_cloud_cum_tgt}</td>
								<td>${info.p2_cloud_cum_ach}</td>
								<td>${info.p2_cloud_monthly_ach_per}</td>
								<td>${info.p2_cloud_cum_ach_per}</td>
								<td>${info.p2_monthly_ach}</td>
								<td>${info.p2_cum_ach}</td>
								<td>${info.p2_mtd}</td>
								<td>${info.p2_ytd}</td>
								<td>${info.p2_weightage}</td>
								<td>${info.p3_seg1_monthly_tgt}</td>
								<td>${info.p3_seg1_monthly_ach}</td>
								<td>${info.p3_seg1_cum_tgt}</td>
								<td>${info.p3_seg1_cum_ach}</td>
								<td>${info.p3_seg1_monthly_ach_per}</td>
								<td>${info.p3_seg1_cum_ach_per}</td>
								<td>${info.p3_seg2_monthly_tgt}</td>
								<td>${info.p3_seg2_monthly_ach}</td>
								<td>${info.p3_seg2_cum_tgt}</td>
								<td>${info.p3_seg2_cum_ach}</td>
								<td>${info.p3_seg2_monthly_ach_per}</td>
								<td>${info.p3_seg2_cum_ach_per}</td>
								<td>${info.p3_monthly_ach}</td>
								<td>${info.p3_cum_ach}</td>
								<td>${info.p3_mtd}</td>
								<td>${info.p3_ytd}</td>
								<td>${info.p3_weightage}</td>
								<td>${info.p1_qtd_payout}</td>
								<td>${info.p1_ytd_payout}</td>
								<td>${info.p2_qtd_payout}</td>
								<td>${info.p2_ytd_payout}</td>
								<td>${info.p3_qtd_payout}</td>
								<td>${info.p3_ytd_payout}</td>
								<td>${info.overall_ach}</td>
								<td>${info.total_payout_sip}</td>
								<td>${info.final_payout_amt}</td>
							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
						<tfoot>
							<tr>
							<th class="center" style="min-width:70px;">RW ID</th>
							<th class="center" style="min-width:70px;">RANGE</th>
							<th class="center" style="min-width:70px;">CIRCLE</th>
							<th class="center" style="min-width:150px;">EMP NAME</th>
							<th class="center" style="min-width:70px;">EMP CODE</th>
							<th class="center" style="min-width:150px;">ROLE</th>
							<th class="center" style="min-width:70px;">EMP STATUS</th>
							<th class="center" style="min-width:100px;">MONTH</th>
							<th class="center" style="min-width:100px;">TARGET PAYOUT</th>
							<th class="center" style="min-width:70px;">P1 MONTHLY TGT</th>
							<th class="center" style="min-width:70px;">P1 MONTHLY ACH</th>
							<th class="center" style="min-width:70px;">P1 CUM TGT</th>
							<th class="center" style="min-width:80px;">P1 CUM ACH</th>
							<th class="center" style="min-width:100px;">P1 PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P1 PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P1 PAYOUT MTD</th>
							<th class="center" style="min-width:100px;">P1 PAYOUT YTD</th>
							<th class="center" style="min-width:70px;">P1 WEIGHTAGE</th>
							<th class="center" style="min-width:80px;">P2 MOB MONTHLY TGT</th>
							<th class="center" style="min-width:80px;">P2 MOB MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 MOB CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 MOB CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 PER MOB MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 MOB PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 FLD MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 FLD CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 FLD PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 FLV MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 FLV CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 FLV PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 IOT MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 IOT CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 IOT PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P2 CLD MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD CUM TGT</th>
							<th class="center" style="min-width:100px;">P2 CLD CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 CLD PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 TOT PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P2 TOT PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P2 TOT PAYOUT MTD</th>
							<th class="center" style="min-width:100px;">P2 TOT PAYOUT YTD</th>
							<th class="center" style="min-width:100px;">P2 TOT WEIGHTAGE</th>
							<th class="center" style="min-width:100px;">P3 SEG1 MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG1 MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG1 CUM TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG1 CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG1 PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG1 PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 MONTHLY TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG2 MONTHLY ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 CUM TGT</th>
							<th class="center" style="min-width:100px;">P3 SEG2 CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P3 SEG2 PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 TOT PER MONTH ACH</th>
							<th class="center" style="min-width:100px;">P3 TOT PER CUM ACH</th>
							<th class="center" style="min-width:100px;">P3 TOT PAYOUT MTD</th>
							<th class="center" style="min-width:100px;">P3 TOT PAYOUT YTD</th>
							<th class="center" style="min-width:100px;">P3 TOT WEIGHTAGE</th>
							<th class="center" style="min-width:100px;">P1 QTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P1 YTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P2 QTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P2 YTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P3 QTD PAYOUT</th>
							<th class="center" style="min-width:100px;">P3 YTD PAYOUT</th>
							<th class="center" style="min-width:100px;">overall ach</th>
							<th class="center" style="min-width:100px;">TOT PAYOUT SIP</th>
							<th class="center" style="min-width:100px;">FINAL PAYOUT AMT</th>
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
						<table class="table table-bordered table-striped"
					id="fix-header"
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

								<td><div class="col-sm-12 col-md-6 col-lg-4 outer-ellipsis"><a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
										class="typcn typcn-download" ></i></a></div></td>
										
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
	<!-- end: page -->
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
			
			$('.col-xs-12.col-sm-12').css({
				'overflow-x' : 'auto'
			});
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
// 		var depot_name = $('#depot_name').val();
// 		var scheme_name = $('#scheme_name').val();

			window.location.href = "downloadVodafoneSchAnReportSoap";
		
		//$("#show_details").show();
	}
</script>

<script>
	function myFunction2() {
		//         	 $("#gen_report").hide(); 
// 		var depot_name = $('#depot_name').val();
// 		var scheme_name = $('#scheme_name').val();

			var month = document.getElementById("month").value;
			window.location.href = "showVodafoneSchAnReportSoap?month="+month;
		
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