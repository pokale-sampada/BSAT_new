<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>
				<li><span><span><a href="Branch_List">System Setups</a></span></span></li>
				<li><span><span> <a href="Branch_List">Branch List</a></span></span></li>
				<li><span>New Branch Master</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>
	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<!-- <a href="#" class="fa fa-caret-down"></a> --><!--  <a href="#"
					class="fa fa-times"></a> -->
			</div>
			<h6 class="panel-title">Branch Master</h6>
			<div></div>
		</header>
		<div class="panel-body">

			<form class="form-horizontal form-field" role="form" id="newbranch"
				action="save_new_Branch" @ModelAttribute="Bpil_Branch_Master">
				<input type="hidden" id="branch_id" name="branch_id" />
			   <div class="row">
				<div class="col-md-3">
					<label class="control-label formmodifiedLable" for="inputDefault">Region</label>
					<!-- <select name="region_id" id="region_id" class="form-control mb-md">

					</select> -->
					<select data-plugin-selectTwo
									class="form-control populate placeholder" name="region_id"
									id="region_id"
									data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
									required>
									<option selected="selected" ></option>
								</select>
				</div>
				<div class="col-md-3">
					<label class="control-label formmodifiedLable" for="inputDefault">Branch
						Code<span class="required">*</span></label> <input type="text" class="form-control" id="branch_code" name="branch_code" required>
				</div>
				<div class="col-md-3">
					<label class="control-label formmodifiedLable" for="inputDefault">Branch
						Name<span class="required">*</span></label> <input type="text" class="form-control" id="branch_desc" name="branch_desc" required>
				</div>
				<div class="col-md-3">
					<label class="control-label formmodifiedLable" for="inputDefault">Is
						Active</label>
						<div class="switch switch-primary"><input type="checkbox"  name="switch" data-plugin-ios-switch checked="checked" id="active" name="switch"
						onclick="CheckUserStatusHeader()"/></div>
						
						</div>
						</div>
						<div class="row">
		<div class="col-md-12">
			<div class="col-md-5"></div>
			<div class="col-md-5">
			<button class="btn btn-primary mb-md" name="submitbranch"
						id="submitbranch">submit</button>
			</div>
			
			</div>
		</div>
		</form>
		</div>
	</section>
</section>
<script>
	$(document).ready(function() {
		//Load all elements
	});
	$("#submitbranch").click(function(e) {
		$("#newbranch").submit();
	});

	<script>
	function CheckUserStatusHeader() {
		console.log("In CheckUserStatusHeader ")
		if (document.getElementById("active").checked == true) {
			document.getElementById("active").value = 'Y'
		} else if (document.getElementById("active").checked == false) {
			document.getElementById("active").value = 'N';
		}
	}
</script>
<script>
	$(document).ready(function() {

		var len = document.getElementById("active").value;
		if (len == 'Y') {
			$("#active").prop("checked", true);
		} else {
			$("#active").prop("checked", false);
		}
	});
</script>


<script>
	$.ajax({
		url : '${pageContext.request.contextPath}/getRegion',
		success : function(data) {

			var select = $('#region_id');
			/*   select.find('option').remove(); */
			$('<option>').val("").text("--Select--").appendTo(select);
			$.each(data, function(index, value) {

				$('<option>').val(value.region_id).text(value.region_name)
						.appendTo(select);

			});

		}
	});
</script>