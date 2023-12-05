
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.required{
color:red;
}

</style>
<title>Page Title</title>
</head>
<body>


<section role="main" class="content-body">
	

	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
			<form id="Regi" action="resetsubmit" autocomplete="off"
				class="form-horizontal" method="Post"
				onsubmit="return confirmValidate();">
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#"></a>
						</div>

						<h2 class="panel-title">Reset Password</h2>

					</header>
					<div class="panel-body">
						<div class="form-group">
	
								
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<label class="control-label"> User Name<span
									class="required">*</span></label> <input type="text"
									name="username" id="username" class="form-control"
									placeholder="eg.: John Doe" required />
							</div>
							<br> <br> <br>
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<label class="control-label"> New Password<span
									class="required">*</span></label> <input type="password" name="newpassword"
									id="newpassword" class="form-control" placeholder="eg.: John Doe"
									required />
							</div>
							<br> <br> <br>
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<label class="control-label"> Confirm Password<span
									class="required">*</span></label> <input type="password" name="conpassword"
									id="conpassword" class="form-control" placeholder="eg.: John Doe"
									required />
							</div>
							<input type="hidden" id="success" value="test">

						</div>
					</div>
					<input name="checkpass" id="checkpass" value="" type="hidden" />
					<footer class="panel-footer">
						<div class="row" style="text-align: center">
							<div class="col-sm-12">
								<button id="sub" class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</footer>

				</section>

			</form>






		</div>

	</div>
</section>

</body>
</html>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script type="text/javascript">
		$('#conpassword').blur(function()	
				{
					
					var pass1=$('#newpassword').val();
					var pass2=$('#conpassword').val();
					
					//alert(pass1);	
					//alert(pass2);
					
					if(pass1 == pass2)
						{
						   document.getElementById("conpassword").style.borderColor="#C0C0C0";
						  



						}
					else
						{
							alert("Password doesn't Not Match ");
							document.getElementById("conpassword").style.borderColor="#FF0000";
							document.getElementById("conpassword").style.borderColor="#FF0000";
							 document.getElementById("conpassword").value="";

						}
				});
	
					
			</script>

