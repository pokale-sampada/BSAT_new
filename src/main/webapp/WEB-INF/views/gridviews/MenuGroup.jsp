
<%@ page import="java.util.Date"%>

<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Menu Group</h4>

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
					<li class="breadcrumb-item"><a href="#!">Menu Groups</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<form class="form-horizontal form-field" role="form"
	action="save_menugroup" ModelAttribute="Bpil_MenuGroup" method="post">
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
		<div class="card-block">
			<div class="form-group row">
				<input type="hidden" id="menu_group_id" name="menu_group_id"
					value="${JSON.menu_group_id}" />
				<div class="col-md-4">

					<label class="block"> Menu Group Name <span
						class="required">*</span></label> <input class="form-control form-control-sm form-control-primary"
						id="group_name" type="text" name="group_name"
						value="${JSON.group_name}" required />

				</div>
				<div class="col-md-4">

					<label class="block"> Menu Group Description<span
						class="required">*</span></label> <input class="form-control form-control-sm form-control-primary"
						id="group_description" type="text" name="group_description"
						value="${JSON.group_description}" required />
				</div>
				<div class="col-md-4">

					<label class="block"> Start Date</label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary" data-plugin-datepicker
							id="group_start_date" 
							value="${JSON.group_start_date1}" name="group_start_date"
							type="date" /> <span class="input-group-addon">
							<i class="fa fa-calendar bigger-110"></i>
						</span>
					</div>

				</div>
			</div>
			<div class="form-group row">
			<div class="col-md-4">
								<label class="block"> End Date</label>
								<div class="input-group input-append date" id="datePicker2">
									<input class="form-control form-control-sm form-control-primary" data-plugin-datepicker
										data-date-format="dd-mm-yyyy" id="group_end_date"
										value="${JSON.group_end_date1}" name="group_end_date"
										type="date" /> <span class="input-group-addon">
										<i class="fa fa-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							
							<div class="col-md-4">
								 <input class="form-control form-control-sm form-control-primary"
									id="active" type="hidden" name="active" value="${JSON.active}" />
									<label class="block">Active</label>
								<div class="switch switch-primary">
									<input name="activecheck" id="activecheck"
										data-plugin-ios-switch type="checkbox" 
										onchange="CheckMenuGroupStatus()"/>
								</div>
								<span class="lbl"></span>
							</div>
							<div class="col-md-4"></div>
			</div>
		</div>
		</div>
		<footer class="panel-footer">
					<div class="row" style="text-align: center">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-primary btn-sm">Save</button>
							<button type="button" class="btn btn-primary btn-sm" onclick="Previouspage()">Back</button>
						</div>
					</div>
				</footer>
</form>
<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<script>
	function CheckMenuGroupStatus() {
		if (document.getElementById("activecheck").checked == true) {
			document.getElementById("active").value = 'Y';
		} else {
			document.getElementById("active").value = 'N';
		}
	}
</script>
<script>
	function Previouspage() {
		window.location.href = "menugroupgrid";
	}
</script>
<!-- <script>	  
				
				    var a=new Date().getDate();
				    var a1=a.toString();
				    var b=new Date().getMonth()+1;
				    var b1=b.toString();
				    var c=new Date().getFullYear();
				    var c1=c.toString();
				
				    var q="-";
				    var d=a1.concat(q);
				    var d1=d.concat(b1);
				    var d2=d1.concat(q);
				    var sysdate=d2.concat(c1);
				
				$('#datePicker1')
				    .datepicker({
				        format: 'dd-mm-yyyy',
				         startDate: sysdate
				         
				    })
				     .on('changeDate', function(e) {
				         // Revalidate the date field
				         $('#eventForm').formValidation('revalidateField', 'date');
				    });
				
				$('#datePicker2')
                .datepicker({


                    format: 'dd-mm-yyyy',
                     startDate: sysdate
                     
                })
                 .on('changeDate', function(e) {
                     // Revalidate the date field
						$('#eventForm').formValidation('revalidateField', 'date');
                });
				
		</script>
 -->
<script>
	$(document).ready(function() {

		var active = document.getElementById("active").value;
		if (active == 'Y') {
			$("#activecheck").prop("checked", true);
		} else {
			$("#activecheck").prop("checked", false);
			document.getElementById("active").value = 'N';
		}
	});
</script>