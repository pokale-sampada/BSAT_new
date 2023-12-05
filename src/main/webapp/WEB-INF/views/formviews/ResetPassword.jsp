

<section role="main" class="content-body">
	<header class="page-header">
		<!-- <h2>Create Scheme</h2> -->
		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>

				<li><span>Settings</span></li>
				<li><span>Reset Password</span></li>
				
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
			<form id="Regi" action="updatepassword" autocomplete="off"
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
						
						
							<input name="user_name" id="user_name" type="hidden"
								value="${username1}" class="col-xs-12 col-sm-4" required /> <input
								name="user_id" id="user_id" value="${user_id}" type="hidden" />
								
								
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<label class="control-label"> Old Password<span
									class="required">*</span></label> <input type="password"
									name="oldpassword" id="oldpassword" class="form-control"
									placeholder="eg.: John Doe" required />
							</div>
							<br> <br> <br>
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<label class="control-label"> Password<span
									class="required">*</span></label> <input type="password" name="password"
									id="password1" class="form-control" placeholder="eg.: John Doe"
									required />
							</div>
							<br> <br> <br>
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<label class="control-label"> Confirm Password<span
									class="required">*</span></label> <input type="password" name="password1"
									id="password2" class="form-control" placeholder="eg.: John Doe"
									required />
							</div>

						</div>
					</div>
					<input name="checkpass" id="checkpass" value="" type="hidden" />
					<footer class="panel-footer">
						<div class="row" style="text-align: center">
							<div class="col-sm-12">
								<button class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</footer>

				</section>

			</form>






		</div>

	</div>
</section>


<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<script type="text/javascript">
		$('#password2').blur(function()	
				{
					//alert("hello");
					var pass1=$('#password1').val();
					var pass2=$('#password2').val();
					
					//alert(pass1);	
					//alert(pass2);
					
					if(pass1 == pass2)
						{
						   document.getElementById("password2").style.borderColor="#C0C0C0";
						  



						}
					else
						{
							alert("Password doesn't Not Match ");
							document.getElementById("password2").style.borderColor="#FF0000";
							document.getElementById("password2").style.borderColor="#FF0000";
							 document.getElementById("password2").value="";

						}
				});
    	function confirmValidate()
    	{
    		var v1=document.getElementById("oldpassword").value;
    		var v2=document.getElementById("checkpass").value;
    		
    		if(v1!=v2)
    			{
    				alert ("Old Password Does not match.");
    				return false;
    			}
    

    	}
    	
		var UserName = $('#user_name').val();
					var UserName = $('#user_name').val();
					$.ajax({
				        url: '${pageContext.request.contextPath}/FindPasswordPresence',
				        data: ({UserName : UserName}),
				        success: function(data) {		        	
				        	
				        	 var r;
				        	if(data!=null)
				        	{				

// 				        		if(data.first_name!=null)
// 			        			{
// 						             r = confirm("This UserName is already present, Do you Want to Update");
// 			        			}
					        
// 					            if (r == true) {
					            	
					            	
					            	document.getElementById("user_name").value=UserName;
						        	document.getElementById("user_id").value=data.user_id;
						        	document.getElementById("checkpass").value=data.password;	
						        	
						        	
// 					            } else {
					            	
					            	
					        
// 						        	alert("User is not Available Please Create new user");
// 					            }
					        	
					        	
			        			}  
				
				        }
				    
				});
					
					$('#oldpassword').blur(function()							
					{
						var old = $('#oldpassword').val();
						var DBpass = $('#checkpass').val();
						alert(DBpass);
						
						if(DBpass == old)
						{
							   document.getElementById("oldpassword").style.borderColor="#C0C0C0"
							}
						else
							{
								alert(" Old Password doesn't Not Match ");
								document.getElementById("oldpassword").value="";
								document.getElementById("oldpassword").style.borderColor="#FF0000"
							}
						
					});
			</script>

