<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="form-group row">
			<div class="col-md-2">
				<label class="block">Scheme Name:<span class="required">*</span></label>
			</div>
			<div class="col-md-4">
					<select class="form-control form-control-sm form-control-primary"
						data-plugin-selectTwo name="scheme_name"
						id="scheme_name" required>
						<option>--Select--</option>
					</select>
			</div>
			<div class="col-md-4">
				<button class="btn btn-primary btn-sm" name="gen_report"
					id="gen_report" value="Submit for Reward Processing"
					onclick="myFunction1()">Submit for Reward Processing</button>
			</div>

	</div>
	<!-- start: page -->
	<div class="card">
		<div class="card-header">
			<h5>Reward Approval</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="simpletable"
					class="table table-striped table-bordered nowrap">
					<thead>
					<tr>
						<th style="width: 5%">Sr.No.</th>
						<th style="width: 30%">Scheme Name</th>
						<th style="width: 20%">Scheme Code</th>
						<th style="width: 13%">Effective From</th>
						<th style="width: 13%">Effective To</th>
						<th style="width: 19%">Status</th>

					</tr>
				</thead>
				<tbody>
					<%
						int k = 1;
					%>
					<c:forEach var="viewprfinfo" items="${Rewpro_Pending_list}"
						varStatus="status">
						<tr>
							<td><%=k%></td>
							<td>
								<%--    <a href="reviewschemedetails?scheme_id=${viewprfinfo.scheme_id}"> --%>
								${viewprfinfo.scheme_name}</a>
							</td>
							<td>${viewprfinfo.scheme_code}</td>
							<td>${viewprfinfo.start_date1}</td>
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
		</div>
	</div>
	<!-- end: page -->
<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>

$(window).load(function() {

$('.required').css({
'color' : 'red'
});

});
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


			window.location.href = "startrewardprocess?scheme_id=" + scheme_id
					+ "&process_flag=R";

		} else {

		}

	}

	function myFunction3() {
		$("#loading").show();
	}

	function myFunction2() {
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();
		window.location.href = "loadrewarddata?schnm=" + scheme_name + "";
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