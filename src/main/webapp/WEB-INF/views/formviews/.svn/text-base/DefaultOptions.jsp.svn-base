
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<section role="main" class="content-body">
	<header class="page-header">
		<!-- <h2>Create Scheme</h2> -->
		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>

				<li><span>System Setups</span></li>
				<li><span>Automation Dates</span></li>
			</ol>

			 <a class="sidebar-right-toggle" data-open="sidebar-right"></a><!-- <i
				class="fa fa-chevron-left"></i></a> -->
		</div>
	</header>

	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal form-field" role="form" id="Regi"
				action="setDefaultOptions" method="post">
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<!-- <a href="#" class="fa fa-caret-down"></a> -->
							<!--  <a href="#"
								class="fa fa-times"></a> -->
						</div>

						<h2 class="panel-title">Default Option</h2>

					</header>
					<div class="panel-body">
						<div class="form-group">

							<input type="hidden" name="test" id="test" value="" />

							<div class="col-md-4">

								<label class="control-label"> Redemption Date : 
									</label>
								<div class="input-group input-append date" id="datePicker">
									<input class="form-control " id="redemption_date"
										name="redemption_date" placeholder="Redemption Date"
										value="${redemption_date}" type="text" />
									<span class="input-group-addon"> <i
										class="fa fa-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-md-4">

								<label class="control-label">Freeze Date : 
									</label>
								

									<div class="input-group input-append date" id="datePicker1">
										<input class="form-control " id="freeze_date"
											name="freeze_date" placeholder="Freeze Date"
											value="${freeze_date}" type="text" /> <span
											class="input-group-addon"> <i
											class="fa fa-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-md-4">

									<label class="control-label"> Interface Date : 
										</label>
									<div class="input-group input-append date" id="datePicker2">
										<input class="form-control " id="interface_date"
											name="interface_date" placeholder="Interface Date"
											value="${interface_date}" type="text" />
										<span class="input-group-addon"> <i
											class="fa fa-calendar bigger-110"></i>
										</span>
									</div>

								</div>
								<!-- <div class="col-sm-6">
								<label class="control-label">Menu Group Name <span
									class="required">*</span></label>
								<div class="switch switch-primary">
									<input type="checkbox" name="switch" data-plugin-ios-switch
										checked="checked" />
								</div>
							</div> -->
							
						</div>
						</div>
				</section>

				<footer class="panel-footer">
					<div class="row" style="text-align: center">
						<div class="col-sm-12">

							<button type="submit" class="btn btn-primary mb-md"
								onclick="return confirmValidate()">Save</button>
						</div>
					</div>
				</footer>
			</form>
		</div>
		<!-- col-md-6 -->
	</div>

</section>



<script>
	function confirmValidate() {
		if (document.getElementById("redemption_date").value == "") {
			alert("Please select Redemption Date");
			return false;
		}
		if (document.getElementById("freeze_date").value == "") {
			alert("Please select Freeze Date");
			return false;
		}
		if (document.getElementById("interface_date").value == "") {
			alert("Please select Interface Date");
			return false;
		} else {
			return true;
		}
	}
</script>




