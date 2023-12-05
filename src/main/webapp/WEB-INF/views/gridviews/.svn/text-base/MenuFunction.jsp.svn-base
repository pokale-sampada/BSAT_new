<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>
				<li><span><span><a href="menufunctiongrid">System Setups</a></span></span></li>   
				<li><span><span><a href="menufunctiongrid">Menu Function</a></span></span></li>
				<li><span>Menu Function Register</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>
	<!-- start: page -->	
		<div class="row">
		<div class="col-md-12">
			<form id="form" action="save_menufunction" role="form" method="post"
				class="form-horizontal">
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<!-- <a href="#" class="fa fa-caret-down"></a> --> <!-- <a href="#"
								class="fa fa-times"></a> -->
						</div>

						<h2 class="panel-title">Menu Function Register</h2>

					</header>
					<div class="panel-body">
				
						<div class="form-group">
                               <% int n=0; %> 
                    					<input type="hidden" id="rowcount1" name="rowcount1">
                    					<input type="hidden" id="delrow1" name="delrow1" value="">  
                    					<div class="table-responsive">
                                    	<table id="dynamic-table1" class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column" id="table1">
											<thead>
											<tr>
												<th>Sr. No.</th>
	                                            <th>Select</th>
                                                <th>SubMenu Name</th>
												 <th>Function Name</th>
												<th>Action Name</th>
												<th class="center">Active</th>
											</tr>
										</thead>   
										<tbody>

<%int j=1; %>
			<c:forEach var="menu_func" items="${menu_func_list}" varStatus="status">

    		 <tr>
    		 <td class="text center">
    		 <%=j %>
    		 </td>
    		 <td class="text center" style="display: none">
					<input type="hidden" value="${menu_func.menu_function_id}" id="menu_function_id<%=j%>" name="menu_function_id" />
					</td>
				<td class="text center">
				<input type="checkbox" class="Deleterow" id="chk<%=j%>" name="chk"/>
			</td>
			<td class="text center">
		<select  id="menu_line_id<%=j%>" name="menu_line_id" class="form-control" value="${menu_func.menu_line_id}"  required>
		<option value="${menu_func.menu_line_id}">${line_name}</option></select>
		</td>
		 <td class="text center">
			<input type="text" class="form-control" value="${menu_func.function_name}" id="function_name<%=j%>" name="function_name" required/>
		</td>
				
		 <td class="text center">
			<input type="text" class="form-control" value="${menu_func.function_action_name}" id="function_action_name<%=j%>" name="function_action_name" required/>
		</td>			
			
			<td class="text center">
			<div class="switch switch-primary">
					<input name="active" id="active<%=j%>" type="checkbox" value="${menu_func.active}" data-plugin-ios-switch onclick="CheckUserStatusHeader(<%=j%>)"/>
			</div>
			<input type="hidden" id="line_status<%=j%>" value="${menu_func.active}" name="line_status" readonly/>
			</td>
		</tr>
		<% j=j+1; %>
												</c:forEach> 	

                                        </tbody>
                                	</table>	
							</div>
							</div>
							</div>
					<footer class="panel-footer">
						<div class="row" style="text-align: center">
							<div class="col-sm-12">
								<input type="button" class="btn btn-primary mb-md" value="Add Row" onclick="AddRow()" >
								<input type="button" class="btn btn-primary mb-md" value="Delete Row" onclick="del()">
							<input type="submit" value="Submit" class="btn btn-primary mb-md" />
							
							</div>
						</div>
					</footer>
				</section>
			</form>
		</div>
		<!-- col-md-6 -->
	</div>
				
		
	
</section>
<script src="resources/newportal/vendor/jquery/jquery.js"></script>
 <script>
        function AddRow()       												
    	{ 	
    		 $('#dynamic-table1 tr').last().after(
    				 '<tr>'+
    				 	'<td> <center>'+($('#dynamic-table1 tr').length)+'</center><input type="hidden" value="" id="menu_function_id'+$('#dynamic-table1 tr').length+'" name="menu_function_id" required/></td>'+
    				 	'<td> <center><input type="checkbox" class="Deleterow" id="chk'+$('#dynamic-table1 tr').length+'" name="chk" onchange="myfunc('+$('#dynamic-table1 tr').length+')" style="text-align:center;"/></center></td>'+
    					'<td> <select  id="menu_line_id'+$('#dynamic-table1 tr').length+'" name="menu_line_id" class="ChangeDropdown" style="width:100%;" required><option selected  value="14">abc</option></select></td>'+
    				 	'<td> <input type="text" class="form-control" value="" style="width:100%;" id="function_name'+$('#dynamic-table1 tr').length+'" name="function_name" required/></td>'+
    				 	'<td> <input type="text" class="form-control" value="" style="width:100%;" id="function_action_name'+$('#dynamic-table1 tr').length+'" name="function_action_name" required/></td>'+
    				 	'<td> <div class="switch switch-primary"><div class="ios-switch off"  onclick="CheckUserStatusGrid(this, id)" name="active'+$('#dynamic-table1 tr').length+'" id="myid'+$('#dynamic-table1 tr').length+'"><div class="on-background background-fill"></div><div class="state-background background-fill"></div> <div class="handle"> </div></div><input name="active" id="active'+$('#dynamic-table1 tr').length+'" type="checkbox" data-plugin-ios-switch onclick="CheckUserStatusGrid(id)" style="display: none;"/></div> <input type="hidden" name="line_status" id="line_status'+$('#dynamic-table1 tr').length+'" value=""></td>'+
    				 '</tr>');
    		 
    		 var x = $('#dynamic-table1 tr').length-1;
    		 /* alert("========="+x); */
    		  $("#line_status"+x).val('N');
    		 
    		 $('#rowcount1').val($('#dynamic-table1 tr').length-1);	
    		 var count = $('#rowcount1').val();

    		 $.ajax({
			        url: '${pageContext.request.contextPath}/loadmenuline',			      
			        success: function(data) {
			            var select = $('#menu_line_id'+count);
			            select.find('option').remove();
			            $('<option>').val("").text("--select--").appendTo(select);
			              $.each(data, function(index, value) {
						  $('<option>').val(value.menu_line_id).text(value.line_name).appendTo(select);
			            });
			        }
			      });	
    	//}	
	    		 
    			//delete table row	

			$('.Deleterow').click(function() { 	
					var index = $('.Deleterow').index(this)+1;
			
                //if(document.getElementById('chk'+index).checked) 							  	
				 //	{						
					$('#delrow1').val(index);
                //}
			});		
    	 }
		</script>
		
		<script>
		
		function CheckUserStatusHeader(k)
		{
			
			if(document.getElementById("active"+k).checked == true){
				document.getElementById("active"+k).value = 'Y'
					alert(document.getElementById("active"+k).val);
				//alert(document.getElementById("header_active").value );
			}else if(document.getElementById("active"+k).checked == false){
				document.getElementById("active"+k).value ='N';
				//alert(document.getElementById("header_active").value );
				alert(document.getElementById("active"+k).val);
			}
			/* alert(document.getElementById("active").val); */
		}
		
		function CheckUserStatusGrid(item,id)
		{
			/* alert("hello==="); */

			/* alert("====="+item.className+"==========="+id); */
			if(item.className == "ios-switch on")
				{
				item.className="ios-switch off";
				
				}
			else{
				item.className="ios-switch on";
				
			   }
			  
		
			
			 var active = id;
			//alert(id);
			var result= id.replace(/[A-Za-z$-]/g, "");
		//	alert(result)

			if(item.className == "ios-switch on"){
				
				$("#line_status"+result).val('Y');
		
			}
			else /* if(document.getElementById(active).checked == false */
			{
				
				$("#line_status"+result).val('N');
			
			} 
		}
		</script>
		
		<script>
		 $(document).ready(function(){
			 
		 $('.ChangeDropdown').mousedown(function(){
			 var count = $('.ChangeDropdown').index(this)+1;
			    $.ajax({
			        url: '${pageContext.request.contextPath}/loadmenuline',			      
			        success: function(data) {
			            var select = $('#menu_line_id'+count);
			            select.find('option').remove();
			            $('<option>').val("").text("--select--").appendTo(select);
			              $.each(data, function(index, value) {
						  $('<option>').val(value.menu_line_id).text(value.line_name).appendTo(select);
			            });
			        }
			      });
		 });
		 });
		</script>
		
	 	<script>		
		function del(){
							
				var index=$('#delrow1').val();
			//alert("delete btn" +index)
			if(index!= "")
	 	 		{ 		
					//if(document.getElementById('chk'+index).checked) 
					//{	
		 	 		 document.getElementById("dynamic-table1").deleteRow(index);
		 	 			$('#delrow1').val("");	
					//}
		 	 		 
				}	
	 	 		
	 	 	}	
		</script> 
		
	   	
		<script>		  		
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
				
// 				$('#datePicker2')
//                 .datepicker({


//                     format: 'dd-mm-yyyy',
//                      startDate: sysdate
                     
//                 })
//                  .on('changeDate', function(e) {
//                      // Revalidate the date field
// 						$('#eventForm').formValidation('revalidateField', 'date');
//                 });
				
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
		