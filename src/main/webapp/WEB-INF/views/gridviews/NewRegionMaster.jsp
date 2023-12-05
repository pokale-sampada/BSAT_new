<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Region Details</h4>

				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Masters</a></li>
					<li class="breadcrumb-item"><a href="getregionslist">Regions</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<div class="card">
		<div class="card-header">
			<h5>Menu Groups</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<form class="form-horizontal form-field" role="form"
		action="saveregion" method="post">
		<div class="card-block">
			<div class="form-group row">
			<input type="hidden" id="region_id" name="menu_group_id"
							value="${JSON.region_id}" />


						<div class="col-md-4">
							<label class="control-label">Region Code<span
								class="required">*</span></label> <input id="group_code" type="text"
								name="group_code" value="${JSON.region_code}"
								class="form-control form-control-sm form-control-primary" required />

						</div>

						<div class="col-md-4">
							<label class="control-label">Region Name<span
								class="required">*</span></label> <input id="group_name" type="text"
								name="group_name" value="${JSON.region_name}"
								class="form-control form-control-sm form-control-primary" required />

						</div>
						<div class="col-md-4">
							<label class="control-label" for="url">User Status</label>
							<div class="switch switch-primary">
								<%-- <input class="form-control form-control-sm form-control-primary" id="userstatus" type="hidden"
									name="userstatus"  value="${JSON.is_active}" /> --%> <input type="checkbox" name="active"
									id="active" value="${JSON.is_active}" onchange="CheckUserStatusHeader()"
									data-plugin-ios-switch /> <span class="lbl"></span>
							</div>
						</div>
			</div>
		</div>
			<footer class="panel-footer">
				<div class="row" style="text-align: center">
					<div class="col-sm-12">
						<button type="submit" value="Save" class="btn btn-sm btn-primary">Save</button>

					</div>
				</div>
			</footer>
		</form>
	</div>



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
				tr.append("<td>" +  json[i].scheme_code + "</td>");
				tr.append("<td>" + json[i].start_date1 + "</td>");
				tr.append("<td>" + json[i].end_date1 + "</td>");
				tr.append("<td>" + json[i].submission_date1 + "</td>");
				tr.append("<td>" + json[i].active_flag + "</td>");
		
				$('#datatable-editable').find('tbody').append(tr);
				//$('#datatable-editable').append(tr);
			}
		 */

		$('#').DataTable().draw();

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
		var a = new Date().getDate();
		var a1 = a.toString();
		var b = new Date().getMonth() + 1;
		var b1 = b.toString();
		var c = new Date().getFullYear();
		var c1 = c.toString();

		var q = "-";
		var d = a1.concat(q);
		var d1 = d.concat(b1);
		var d2 = d1.concat(q);
		var sysdate = d2.concat(c1);

		$('#datePicker1').datepicker({
			format : 'dd-mm-yyyy',
			startDate : sysdate

		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});

		$('#datePicker2').datepicker({

			format : 'dd-mm-yyyy',
			startDate : sysdate

		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});
	</script>


