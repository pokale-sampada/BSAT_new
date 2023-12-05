<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



</head>
<body>
	<section>
		<div id="login">
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="login-column" class="col-md-6">

						<div class="alert alert-success" id="success-alert">
							<strong>Success!</strong> OTP Sent Successfully.
						</div>
						<div class="alert alert-success" id="otp-expired">
							<strong>Failed!</strong> OTP Expired.
						</div>
						<div class="alert alert-success" id="In-ValidOTP">
							<strong>Failed!</strong> OTP Expired.
						</div>
						<form action="verify_otp">
							<div class="form-group">
								<h2 class="text-center m-3">Please Enter OTP</h2>
								<input name="otp" type="text" class="form-control"
									placeholder="Enter otp here" required />
							</div>
							<br> <br>
							<div class="container text-center">
								<button class="btn btn-primary"  id="clickme" >Verify OTP</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

   <script type="text/javascript">
      $(document).ready(function () {
    	  
            $('#success-alert').hide();
            $('#otp-expired').hide();
            $('#In-ValidOTP').hide();
  		
        
      });
  </script>
  <script>

$("#clickme").click(function(){
	var m=${otpbsent};
	var n={OtpFail};
	
	if(m==true)
	{
		//$("#success-alert").show();
		$("#success-alert").show();  
	}
	if(n==false)
		{
		$("#otp-expired").show(); 
		}
	  
	});
</script>
</body>

</html>
