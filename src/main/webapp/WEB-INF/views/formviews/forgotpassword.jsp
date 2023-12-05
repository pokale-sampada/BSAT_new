<!doctype html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html class="fixed">
	<head>

		<!-- Basic -->
		<!-- <meta charset="UTF-8">

		<meta name="keywords" content="HTML5 Admin Template" />
		<meta name="description" content="Porto Admin - Responsive HTML5 Template">
		<meta name="author" content="okler.net">

		Mobile Metas
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

		Web Fonts 
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css">

		Vendor CSS
		<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="assets/vendor/magnific-popup/magnific-popup.css" />
		<link rel="stylesheet" href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />

		Theme CSS
		<link rel="stylesheet" href="assets/stylesheets/theme.css" />

		Skin CSS
		<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

		Theme Custom CSS
		<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

		Head Libs
		<script src="assets/vendor/modernizr/modernizr.js"></script> -->
		<meta name="keywords" content="HTML5 Admin Template" />
<meta name="description"
	content="Porto Admin - Responsive HTML5 Template">
<meta name="author" content="okler.net">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Web Fonts  -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light"
	rel="stylesheet" type="text/css">

<!-- Specific Page Vendor CSS -->
<link rel="stylesheet" href="resources/newportal/vendor/morris/morris.css" />

<!-- Vendor CSS -->
<link rel="stylesheet"
	href="resources/newportal/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/bootstrap-multiselect/bootstrap-multiselect.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/select2/select2.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/font-awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/dropzone/css/basic.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/dropzone/css/dropzone.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/magnific-popup/magnific-popup.css" />

<link rel="stylesheet"
	href="resources/newportal/vendor/bootstrap-datepicker/css/datepicker3.css" />
<link rel="stylesheet"
	href="resources/newportal/vendor/jquery-datatables-bs3/assets/css/datatables.css" />

<!-- Specific Page Vendor CSS -->
<link rel="stylesheet"
	href="resources/newportal/vendor/pnotify/pnotify.custom.css" />

<!-- Theme CSS -->
<link rel="stylesheet" href="resources/newportal/stylesheets/theme.css" />

<!-- Skin CSS -->
<link rel="stylesheet"
	href="resources/newportal/stylesheets/skins/default.css" />

<!-- Theme Custom CSS -->
<link rel="stylesheet"
	href="resources/newportal/stylesheets/theme-custom.css">

<!-- Head Libs -->
<script src="resources/newportal/vendor/modernizr/modernizr.js"></script>


<!-- internal CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/newportal/internalCSS/formtextlabel.css"></link>
<link rel="stylesheet" type="text/css"
	href="resources/newportal/internalCSS/dashboard.css"></link>

<!-- <script>
			alert("====");
var ab=${ab};
if (ab==5){
alert("Password reset successfully please check your mail...");

}</script> -->
		

	</head>
	<body>
	
	
		<!-- start: page -->
		<section class="body-sign">
			<div class="center-sign">
				<div class="panel panel-sign">
					<div class="panel-title-sign mt-xl text-left">
						 <h2 class="title text-uppercase text-bold m-none"><i class="fa fa-user mr-xs"></i> Recover Password</h2>
					</div>
					<div class="panel-body">
						<!-- <div class="alert alert-info">
							<p class="m-none text-semibold h6"> Enter Your User Name</p>
						</div> -->

						<form id="forgot_password" name="forgot_password" class="login-form" action="forgot_password" ModelAttribute="Bpil_Users" method="post">
							<div class="form-group mb-none">
								<div class="input-group">
								<div class="col-sm-10">
									<input name="user_name" id="user_name" type="text" class="form-control" placeholder="Username" required onfocus="this.value=''" pattern="[a-z,A-Z,0-9]{1,15}"/>
									</div>
									<div class="col-sm-2">
									<span class="input-group-btn">
										<input class="btn btn-primary" type="submit" value="Submit" onKeyPress="submitOnEnter(this, event)" />
									</span>
									</div>
									<div style="color: red;">${message}</div>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</section>
		
		<!-- end: page -->
		<script src="assets/vendor/jquery/jquery.js"></script>
		<script src="assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
		<script src="assets/vendor/nanoscroller/nanoscroller.js"></script>
		<script src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
		<script src="assets/vendor/magnific-popup/magnific-popup.js"></script>
		<script src="assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>
		
		<!-- Theme Base, Components and Settings -->
		<script src="assets/javascripts/theme.js"></script>
		
		<!-- Theme Custom -->
		<script src="assets/javascripts/theme.custom.js"></script>
		
		<!-- Theme Initialization Files -->
		<script src="assets/javascripts/theme.init.js"></script>
		
	</body>
	
	
	<script>
	
	$(document).ready(function(){
	
		alert("****");
		
		var ab=${ab};
		if (ab==5){
		alert("Password reset successfully please check your mail... ****");
		}
	});
	
</script>
	
</html>