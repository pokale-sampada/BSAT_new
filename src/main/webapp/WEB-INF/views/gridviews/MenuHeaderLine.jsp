<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>


<section role="main" class="content-body">
	<header class="page-header">
		<!-- <h2>Create Scheme</h2> -->
		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>

				<li><span><a href="menuheadergrid">System Setups</a></span></li>
				<li><span><a href="menuheadergrid">Menu Header</a></span></li>
				<li><span> New Menu Header</span></li>
			</ol>

		 <a class="sidebar-right-toggle" data-open="sidebar-right"></a><!-- <i
				class="fa fa-chevron-left"></i></a> -->
		</div>
	</header>

	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal form-field" role="form"
				action="save_menuHeaderLine" ModelAttribute="Bpil_Menu_Header"
				method="post">
				<div class="form-group">

					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
								<!-- <a href="#" class="fa fa-caret-down"></a> -->
								<!--  <a href="#"
								class="fa fa-times"></a> -->
							</div>

							<h2 class="panel-title">Menu Header</h2>

						</header>
						<div class="panel-body">
							<div class="col-md-4">
								<%-- <div style="display: none;">
									<input type="text" id="menu_header_id" name="menu_header_id"
										value="${JSON.menu_header_id}" />
								</div> --%>
								<!-- <div> -->
								<label class="control-label">Menu Group Name <span
									class="required">*</span></label>
								    <%-- <select class="form-control" name="menu_group_id" id="menu_group_id" required >
									<option selected="selected" value="${JSON.menu_group_id}"></option>
									</select> --%>
									 <select data-plugin-selectTwo
									class="form-control populate placeholder" name="menu_group_id"
									id="menu_group_id"
									data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
									required>
									<option selected="selected" value="${JSON.menu_group_id}"></option>
								</select>
									<!-- </div> -->
							</div>
							<div class="col-md-4">
								<label class="control-label">Header Menu Name <span
									class="required">*</span></label> <input type="text"
									class="form-control" name="header_name" id="header_name"
									value="${JSON.header_name}" required />

							</div>
							<div class="col-md-4">
								<label class="control-label">Header Menu Action <span
									class="required">*</span></label> <input type="text"
									class="form-control" name="action_name" id="action_name"
									value="${JSON.action_name}" required />

							</div>
							<div class="col-md-4">
								<label class="control-label"> Start Date</label>
								<div class="input-group input-append date" id="datePicker1">
									<input class="form-control " id="header_start_date" data-plugin-datepicker
										data-date-format="dd-mm-yyyy" name="header_start_date" value="${JSON.header_start_date1}"
										type="text" onchange="checkattend()" readonly /> <span
										class="input-group-addon"> <i
										class="fa fa-calendar bigger-110"></i>
									</span>
								</div>
							</div>

							<div class="col-md-4">
								<label class="control-label"> End Date </label>
								<div class="input-group input-append date" id="datePicker1">
									<input class="form-control " id="header_end_date" data-date-format="dd-mm-yyyy"
										data-plugin-datepicker name="header_end_date" value="${JSON.header_end_date1}"
										type="text" readonly /> <span class="input-group-addon">
										<i class="fa fa-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-md-4">
								<input class="form-control" id="header_active" type="hidden"
									name="header_active" value="${JSON.header_active}" /> <label
									class="control-label">Active</label>
								<div class="switch switch-primary">
									<input type="checkbox" name="header_activecheck" 
										id="header_activecheck" data-plugin-ios-switch value=""
										onchange="CheckMenuHeaderStatus()" />
								</div>
							</div>

						</div>

					</section>
					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
							 <a href="#" class="fa fa-caret-down"></a>
								<!-- <a href="#"
					class="fa fa-times"></a> -->
							</div>
							<h2 class="panel-title">Menu Lines</h2>

						</header>
						<div class="panel-body">
							<div class="table-responsive">
								<%
									int n1 = 0;
								%>

								<input type="hidden" id="rowcount1" name="rowcount1">
								<table
									class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column"
									id="dynamic-table1">
									<thead>
										<tr>
											<th class="text center">Sr No</th>
											<th class="text center">SubMenu Name</th>
											<th class="text center">SubMenu Action</th>
											<th class="center">Active</th>
										</tr>
									</thead>
									<tbody>
										<%
											int j = 1;
										%>
										<c:forEach var="menuline" items="${menulines}"
											varStatus="status">

											<tr>

												<td class="text center"><%=j%> <input type="hidden"
													value="${menuline.menu_line_id}" id="menu_line_id<%=j%>"
													name="menu_line_id" /></td>
												
												<td class="text center"><input type="text" class="form-control" id="line_name<%=j%>"
													name="line_name" value="${menuline.line_name}" required />
												</td>
												
												<td class="text center">
												<input type="text" class="form-control" id="line_action_name<%=j%>"
													name="line_action_name" value="${menuline.action_name}" required />
												</td>
												
												<td class="text center">
															<input class="form-control" id="active<%=j%>"
																type="hidden" name="active" value="${menuline.active}" />
																
											<div class="switch switch-primary"><input type="checkbox"  name="activecheck"  
											 data-plugin-ios-switch checked="checked" id="activecheck<%=j%>" name="switch"
						                     onchange="CheckMenuLineStatusGrid(<%=j%>)" />
						                     </div>
											
													</td>
											</tr>
											<%j = j + 1;%>
										</c:forEach>
									</tbody>
								</table>
								<footer class="panel-footer">
						<div class="row" style="text-align: center">
							<div class="col-md-4"></div>
							<div class="col-md-4">
							
							<input type="button" class="btn btn-primary mb-md" value="Add Row" onclick="AddRow()" >
													
						    <input type="button" class="btn btn-primary mb-md" value="DeleteRow" onclick="delRow(<%=j%>)" />	
			
							<input type="submit" value="Submit"  class="btn btn-primary mb-md" />
							</div>
                                <div class="col-md-4">
                                
							</div>
						</div>
					</footer>

							</div>
						</div>
					</section>
					
				</div>
			</form>
		</div>
		<!-- col-md-6 -->
	</div>

</section>


<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->


	<script>
		
		function CheckMenuHeaderStatus()
		{
			
			if(document.getElementById("header_activecheck").checked == true){
				document.getElementById("header_active").value ='Y';
				//alert(document.getElementById("header_active").value );
			}else if(document.getElementById("header_activecheck").checked == false){
				document.getElementById("header_active").value ='N';
				//alert(document.getElementById("header_active").value );
			}
		}
		
		function CheckMenuLineStatusGrid(id)
		{
			var active = "activecheck"+id;
// 			alert(active);
			
// 			var result= id.replace(/[A-Za-z$-]/g, "");
			
// 			alert(document.getElementById(active).checked);
			if(document.getElementById(active).checked == true){
				$("#active"+id).val('Y');
// 				alert("#active"+id);
		
			}else if(document.getElementById(active).checked == false){
				$("#active"+id).val('Y');
// 				alert("#active"+id);
			
			}
		}
		</script>
	<script>
        function AddRow()       												
    	{ 	
    		 $('#dynamic-table1 tr').last().after('<tr>'
    				 +'<td class="text center">'+($('#dynamic-table1 tr').length)+'<input type="hidden" value="" id="menu_line_id'+$('#dynamic-table1 tr').length+'" name="menu_line_id" /></td>'
//     				 +'<td><center><input type="checkbox" class="Deleterow" id="chk'+$('#dynamic-table1 tr').length+'" name="chk" style="text-align:center;"/></center></td>'
    				 +'<td class="text center"><input type="text" class="form-control" id="line_name'+$('#dynamic-table1 tr').length+'" required/></td>'
    				 +'<td class="text center"><input type="text" class="form-control" id="line_action_name'+$('#dynamic-table1 tr').length+'" name="line_action_name" value="" required/></td>'
    				 +'<td class="text center"><input class="form-control" id="active'+$('#dynamic-table1 tr').length+'" type="hidden" name="active" value="" /> <div class="switch switch-primary"> <input name="activecheck" id="activecheck'+$('#dynamic-table1 tr').length+'" type="checkbox" data-plugin-ios-switch value="" onchange="CheckMenuLineStatusGrid('+$('#dynamic-table1 tr').length+')"/></div></td>'
    				 +'</tr>');
    		 
    		 
				
			
		
		
		
    		 $('#rowcount1').val($('#dynamic-table1 tr').length-1);	
    		 var count = $('#rowcount1').val();

//     		 $.ajax({
// 			        url: '${pageContext.request.contextPath}/loadMenugroupname',
			        
// 			        success: function(data) {
// 			            var select = $('#menu_id'+count);
// 			           // alert(select);
// 			            select.find('option').remove();
// 			              $.each(data, function(index, value) {
// 						  $('<option>').val(value.main_menu_id).text(value.main_menu_name).appendTo(select);
// 			            });
		
// 			        }
// 			      });
    			
    	
	    		 
    			//delete table row	

// 			$('.Deleterow').click(function() { 	
// 					var index = $('.Deleterow').index(this)+1;
			
                //if(document.getElementById('chk'+index).checked) 							  	
				 //	{						
// 					$('#delrow1').val(index);
                //}
// 			});		
    	 }
		</script>
		
	 	<script>		
		function delRow(cnt){
			
			$('#rowcount1').val($('#dynamic-table1 tr').length - 1);
			var count = $('#rowcount1').val();
			

			if(count >= cnt)
				{ 		
					 document.getElementById("dynamic-table1").deleteRow(count);
			 			
					
				}
							
// 				var index=$('#delrow1').val();
			//alert("delete btn" +index)
// 			if(index!= "")
// 	 	 		{ 		
					//if(document.getElementById('chk'+index).checked) 
					//{	
// 		 	 		 document.getElementById("dynamic-table1").deleteRow(index);
// 		 	 			$('#delrow1').val("");	
					//}
		 	 		 
// 				}	
	 	 		
	 	 	}	
		</script>
		<script>
		function checkattend()
         {
			// alert("hello");
             var complain_date = $('#header_start_date').val();
             
		//	alert(complain_date);
			
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
			
			$('#datePicker2')
			    .datepicker({
						
			        format: 'dd-mm-yyyy',
			         startDate: complain_date,
			      //   endDate: sysdate
			    })
			     .on('changeDate', function(e) {
			         // Revalidate the date field
			         $('#eventForm').formValidation('revalidateField', 'date');
			    });
			

         }

		</script>
		<script>	
	$(document).ready(function(){
		
		var header_active = document.getElementById("header_active").value;
			if(header_active == 'Y')	
				{			
					$("#header_activecheck").prop( "checked", true );
				}
			else{
				$("#header_activecheck").prop( "checked", false );
				document.getElementById("header_active").value ='N';
			}
			
			 var len1 = document.getElementsByName('active').length; 
			for(var i=1;i<=len1;i++)
				{			
				
				if(document.getElementById("active"+i).value == 'Y')
						{		
							//alert("y");
							$("#activecheck"+i).prop( "checked", true );
						}
					else{
						//alert("n");
							$("#activecheck"+i).prop( "checked", false );
							document.getElementById("active"+i).value ='N';
							
							
						}
				}
		
	});
	
	</script> 
	
	
	
	
	<script>
// 		$(window).load(function(){
	
			$('.fetchgrpid').mousedown(function()
					{
			 $.ajax({
			        url: '${pageContext.request.contextPath}/loadmenugroup',
			        
			        success: function(data) {
			            var select = $('#menu_group_id');
			           // alert(select);
			            select.find('option').remove();
			            $('<option>').val("").text("--Select--").appendTo(select);
			              $.each(data, function(index, value) {
									
			            	  	alert("value.menu_group_id--->>"+value.menu_group_id);
							
			            	  $('<option>').val(value.menu_group_id).text(value.group_name).appendTo(select);
			            });
		
			        }
			      });
		});
		</script>
		<script>
	
		$(window).load(function(){
						 $.ajax({
			        url: '${pageContext.request.contextPath}/loadmenugroup',
			        
			        success: function(data) {
			            var select = $('#menu_group_id');
			           // alert(select);
			            select.find('option').remove();
			            $('<option>').val("").text("--Select--").appendTo(select);
			            $.each(data, function(index, value) {
			            	if(value.menu_group_id == "${JSON.menu_group_id}"){
						  		$('<option selected>').val(value.menu_group_id).text(value.group_name).appendTo(select);
			            	}
			            	else {
			            		$('<option>').val(value.menu_group_id).text(value.group_name).appendTo(select);
			            	}
			            });
		
			        }
			      });
			
			 }); 
			
	</script>
	
