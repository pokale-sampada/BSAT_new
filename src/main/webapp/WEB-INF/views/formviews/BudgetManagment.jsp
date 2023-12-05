<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- start: page -->
	<div class="card">
					<div class="card-header">
						<h5>Budget Management</h5>
						<div class="card-header-right">
							<ul class="list-unstyled card-option">
								<li><i class="feather icon-maximize full-card"></i></li>
								<li><i class="feather icon-minus minimize-card"></i></li>
								<li><i class="feather icon-trash-2 close-card"></i></li>
							</ul>
						</div>
					</div>
					<div class="card-block">
						<form action="it">
							<div class="row" id="totalBudget" style="margin-top: 20px;">

					<div class="col-md-3">
						<label class="control-label" for="inputSuccess">Total
							Budget : </label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control form-control-sm form-control-primary" id="total_budget"
							name="total_budget" value="7000000000" readonly>
					</div>
				</div>
				<div class="row" id="hqBudget" style="margin-top: 20px;">

					<div class="col-md-3">
						<label class="control-label" for="inputSuccess">Head
							Quater Level Budget : </label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control form-control-sm form-control-primary" id="hq_budget_per"
							name="hq_budget_per" readonly placeholder="Enter Percentage">
					</div>
					<div class="col-md-3">

						<input type="text" class="form-control form-control-sm form-control-primary" id="hq_budget"
							name="hq_budget" readonly>
					</div>
				</div>
				<div class="row" id="regionBudget" style="margin-top: 20px;">
					<div class="col-md-3">
						<label class="control-label" for="inputSuccess">Region
							Level Budget : </label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control form-control-sm form-control-primary" id="region_budget_per"
							name="region_budget_per" placeholder="Enter Percentage" readonly>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control form-control-sm form-control-primary" id="region_budget"
							name="region_budget" readonly>
					</div>
				</div>
				<div class="row" id="branchBudget" style="margin-top: 20px;">
					<div class="col-md-3">
						<label class="control-label" for="inputSuccess">Branch
							Level Budget : </label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control form-control-sm form-control-primary" id="branch_budget_per"
							name="total_budget_per" placeholder="Enter Percentage" readonly>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control form-control-sm form-control-primary" id="branch_budget"
							name="total_budge" readonly>
					</div>
				</div>
				<div class="row">
					<div id="submitbutton" class="col-md-3">
						<input type="button" class="btn btn-primary center btn-sm" id="Save"
							value="Save" onclick="redirectTo()">
					</div>
					<div id="editbutton" class="col-md-3">
						<input type="button" class="btn btn-primary center btn-sm" id="Save"
							value="Edit" onclick="editForm()">
					</div>
				</div>
						</form>
					</div>
				</div>
<script>
	$(document).ready(function() {

		$("#submitbutton").hide();

	});
	$(window)
			.load(

					function() {
						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschschemename',
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

					});
</script>



<script>
	//function chk(){
	function redirectTo() {
		var hq_per = $("input#hq_budget_per").val();
		var region_budget_per = $("input#region_budget_per").val();
		var branch_budget_per = $("input#branch_budget_per").val();
		var total_per = +hq_per + +region_budget_per + +branch_budget_per;

		if (total_per < 100) {
			window.location.href = "it";

		} else {

			alert("Total Percentage should not be greate than 100");
		}

	}
	function editForm() {
		
		document.getElementById("hq_budget_per").removeAttribute("readonly");
		document.getElementById("branch_budget_per").removeAttribute("readonly");
		document.getElementById("region_budget_per").removeAttribute("readonly");
		$("#editbutton").hide();
		$("#submitbutton").show();

	}
	$('#scheme_name').change(function() {
		var schemename = $("select#scheme_name").val();
		$('#total_budget').val(0);
		$('#region_budget').val(0);
		$('#hq_budget').val(0);
		$('#branch_budget').val(0);
		if (schemename === '') {
			$("#totalBudget").hide();
			$("#hqBudget").hide();
			$("#regionBudget").hide();
			$("#branchBudget").hide();
		} else {
			$("#totalBudget").show();
			$("#hqBudget").show();
			$("#regionBudget").show();
			$("#branchBudget").show();

		}
	});
	/* $('#total_budget').change(function() {
		var total_budget = $("input#total_budget").val();
		var regional_budget = total_budget * 30 / 100;
		var hq_budget = total_budget * 40 / 100;
		var branch_budget = total_budget * 20 / 100;
		$('#region_budget').val(regional_budget);
		$('#hq_budget').val(hq_budget);
		$('#branch_budget').val(hq_budget);

	}); */
	$('#hq_budget_per').change(function() {
		var total_budget = $("input#total_budget").val();

		var hq_per = $("input#hq_budget_per").val();

		var hq_budget = total_budget * hq_per / 100;
		if (hq_per < 100) {
			$('#hq_budget').val(hq_budget);

		} else {
			alert("Please enter percentage between 0 to 100");
			$('#hq_budget').val(0);
		}

	});
	$('#region_budget_per').change(function() {
		var total_budget = $("input#total_budget").val();

		var region_budget_per = $("input#region_budget_per").val();

		var reg_budget = total_budget * region_budget_per / 100;
		if (region_budget_per < 100) {
			$('#region_budget').val(reg_budget);
		} else {
			alert("Please enter percentage between 0 to 100");
			$('#region_budget').val(0);
		}

	});
	$('#branch_budget_per').change(function() {
		var total_budget = $("input#total_budget").val();

		var branch_budget_per = $("input#branch_budget_per").val();

		var branch_budget = total_budget * branch_budget_per / 100;

		if (branch_budget_per < 100) {
			$('#branch_budget').val(branch_budget);
		} else {
			alert("Please enter percentage between 0 to 100");
			$('#branch_budget').val(0);
		}

	});

	//}
</script>