

<section role="main" class="content-body">
	<header class="page-header">
		<!-- <h2>Create Scheme</h2> -->
		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>

				<li><span>MaxLife</span></li>
				<li><span>Agent Details</span></li>
				
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
			<form id="Regi" action="updateAgent" autocomplete="off"
				class="form-horizontal" method="Post">
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#"></a>
						</div>

						<h2 class="panel-title">Agent Details</h2>

					</header>
					<div class="panel-body">
						<div class="form-group">
						
						
							<input name="user_name" id="user_name" type="hidden"
								value="${username1}" class="col-xs-12 col-sm-4" required /> <input
								name="user_id" id="user_id" value="${user_id}" type="hidden" />
								
							<div class="col-md-2"></div>
							<div class="col-sm-4">
								<label class="control-label"> ADM ID<span
									class="required">*</span></label> <input type="text"
									name="ADM_ID" id="ADM_ID" class="form-control"
									placeholder="ADM ID" value="${Info_Grid.ADM_ID}" required />
							</div>
							
							<div class="col-sm-4">
								<label class="control-label"> AGENT ID<span
									class="required">*</span></label> <input type="text" name="AGENT_ID"
									id="AGENT_ID" value="${Info_Grid.AGENT_ID}" class="form-control" placeholder="AGENT ID"
									required />
							</div>
							<div class="col-md-2"></div>
							<br> <br> <br>
							<div class="col-md-2"></div>
							<div class="col-sm-4">
								<label class="control-label"> AGENT DOJ<span
									class="required">*</span></label> <input type="text" name="AGENT_DOJ"
									id="AGENT_DOJ" value="${Info_Grid.AGENT_DOJ}" class="form-control" placeholder="AGENT DOJ"
									required />
							</div>
							
							<div class="col-sm-4">
								<label class="control-label"> AGENT STATUS<span
									class="required">*</span></label> <input type="text" name="AGENT_STATUS"
									id="AGENT_STATUS" value="${Info_Grid.AGENT_STATUS}" class="form-control" placeholder="AGENT STATUS"
									required />
							</div>
							<div class="col-md-2"></div>

						</div>
					</div>
					<input name="checkpass" id="checkpass" value="" type="hidden" />
					<footer class="panel-footer">
						<div class="row" style="text-align: center">
							<div class="col-sm-12">
								<input type="submit" class="btn btn-primary" value="Save"></input>
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

