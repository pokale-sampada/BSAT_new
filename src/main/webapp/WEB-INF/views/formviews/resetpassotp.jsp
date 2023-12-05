<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- <style type="text/css">
#login{
margin-top:120px;
max-width:900px;
height:420px;
border:1px solid #9c9c9c;
background-color:white;
}

</style> -->
</head>
<body>
	<section>
		<div id="login">
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="login-column" class="col-md-6">
						<div class="alert alert-danger" id="fail-alert" style="display: none;">
							<strong>Failed! </strong> Email does not exist.
						</div>

						<form action="sendotp">
							<div class="form-group">
							    <h5 class="" style="color:red"></h3>
							    <h5 class="" style="color:green"></h3>
								<h2 class="text-center m-3">Enter Your Registered Email</h2>
								<input name="email" type="email" id="email" class="form-control"
									placeholder="Enter email here" required />
							</div>
							<br>
							<br>
							<div class="container text-center">
								<button class="btn btn-primary" id="clickme" onclick="return confirmValidate()">Send OTP</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
  


  
  
  <script type="text/javascript">
   
  </script>
  
  <script>
	$(document).ready(function(event) {
	
	/* 	var v = "${success}";
		if (v == "success") {

			swal({
				title : "Done",
				text : "New User has been created Successfully!",
				icon : "success"
			}).then(function() {

			});
		} */
		
		
		function confirmValidate() {
			alert('jii');
			var sel_menu = ${"otpsent"};
			alert(sel_menu);
			

			if (document.getElementById("email").value == "") {
				alert("Please enter your email");
				return false;
			} 
			else {
				return true;
			}
		}
	

	});
	
</script>

</body>
</html>