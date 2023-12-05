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


						<form action="verify_otp">
							<div class="form-group">
								<h2 class="text-center m-3">Please Enter OTP Sent to Your Registered Email </h2>
								<input name="otp" type="text" class="form-control" placeholder="Enter otp here" required/>
							</div>
							<br><br>
							<div class="container text-center">
							<button class="btn btn-warning">Verify OTP</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
