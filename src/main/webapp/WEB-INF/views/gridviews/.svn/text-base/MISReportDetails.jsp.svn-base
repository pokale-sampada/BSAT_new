<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section role="main" class="content-body">
	<header class="page-header">
		<!-- <h2>Reward Processing</h2> -->

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Report</span></li>
				<li><span>MIS Report Details</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"><i
				class="fa fa-chevron-left"></i></a>
		</div>
	</header>




	<form action="updateoutput" method="post" id="Saveform">

		<div class="col-md-4">
			<label class="control-label">ML Group</label> <input type="text"
				name="ML_Group" id="ML_Group" class="form-controlW"
				value="${ML_Group}" readonly />
		</div>

		<div class="col-md-4">
			<label class="control-label">From Date</label> <input type="text"
				name="From_Date" id="From_Date" class="form-control"
				value="${From_Date}" readonly />
		</div>

		<div class="col-md-4">
			<label class="control-label">To Date</label> <input type="text"
				name="To_Date" id="To_Date" class="form-control" value="${To_Date}"
				readonly />
		</div>


		<div class="row">
		<hr>
			<div class="col-md-6 text-center col-sm-6 col-sm-offset-3">
				<button class="btn btn-primary" id="action4" value="Show Report"
					onclick="searchinfo()">Show Report</button>
				<button class="btn btn-primary" id="action5" value="Download Report"
					onclick="downloadreport()">Download Report</button>
			</div>
		</div>


		<hr>

		<div id="loading" style="width: 200%; height: 230%; margin-left: 2%;">

			<img src="resources/login_assets/Loading1.gif" alt="BASS"
				style="width: 15%; height: 15%; margin-left: 16%; margin-top: 0%;"
				class="" />

			<h6 style="margin-left: 20%;">Loading, Please Wait.....</h6>
		</div>



		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a> <a href="#"
						class="fa fa-times"></a>
				</div>

				<h2 class="panel-title">MIS Report Details</h2>
			</header>


	<div class="panel-body">
		<table class="table table-bordered table-striped"
			id="datatable-editable"
			data-url="assets/ajax/ajax-datatables-sample.json">
			<thead>
				<tr>
					<th style="min-width: 100px;">Scheme Code</th>
					<th style="min-width: 150px;">Scheme Name</th>
					<th style="min-width: 250px;">Scheme Outflow</th>
				</tr>
			</thead>
			<tbody>
				<%
					int j = 1;
				%>
				<c:forEach var="info" items="${Info_grid}" varStatus="status">
					<tr>
						<td>${info.scheme_code}</td>
						<td>${info.scheme_name}</td>
						<td><fmt:formatNumber value="${info.scheme_outflow}"
								pattern="###0.00" /></td>
					</tr>
					<%
						j = j + 1;
					%>
				</c:forEach>

			</tbody>
		</table>

		<div class="wizard-actions">
			<input type="hidden" name="action" id="action" value="">
		</div>

	</div>
</section>
</form>
<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
		$(document).ready(function() {
			$('#datatable-editable').DataTable().draw();
		});
	</script>



<script>

function downloadreport()
{
	if(document.getElementById("scheme_name").value == ""){
		alert("Please select scheme name");
	}else{
		var scheme_name=document.getElementById("scheme_name").value;	
		var depot_code=document.getElementById("appl_depot_code").value;
		var dealer_name=document.getElementById("dlr_ac_name").value;
		var bill_to_id=document.getElementById("bill_to_id").value;


		window.location.href="downloadRewardAnalysisReport?scheme_name="+scheme_name+"&depot_code="+depot_code+"&dealer_name="+dealer_name+"&bill_to_id="+bill_to_id;
	}	
}

function searchinfo()
{
	if(document.getElementById("scheme_name").value == ""){
		alert("Please select scheme name");
	}else{
		var scheme_name=document.getElementById("scheme_name").value;	
		var depot_code=document.getElementById("appl_depot_code").value;
		var dealer_name=document.getElementById("dlr_ac_name").value;
		var bill_to_id=document.getElementById("bill_to_id").value;


		window.location.href="generateRewardAnalysisReport?scheme_name="+scheme_name+"&depot_code="+depot_code+"&dealer_name="+dealer_name+"&bill_to_id="+bill_to_id;
	}	
}

function closeform()
{
	window.close();
}

function isNumber(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode;

	if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
    
	return false;

	
return true;
} 
</script>
<script>
				$(window).load(function(){
			
					
					
					/* alert("hhh1");
					var id1=document.getElementById("scheme_name").value;
					$.ajax({
					    url: '${pageContext.request.contextPath}/getschemedepot',	
					    data: ({depot : id1}),
					    success: function(data) {	
					    	alert("hhh2");
					    	var select = $('#appl_depot_code');
					    	select.find('option').remove();
					    	$('<option>').val("").text("--select--").appendTo(select);
					           	  $.each(data, function(index, value) {		        	
					           		if(value.depot_name == "${deptnm}"){
					    	  $('<option selected>').val(value.depot_name).text(value.depot_name).appendTo(select);
					           		}else{
					           			$('<option>').val(value.depot_name).text(value.depot_name).appendTo(select); 			
					           		}
					    	});
					
					    }
					  });
					 */
					 
						$.ajax({
// 						    url: '${pageContext.request.contextPath}/getschemename4',
						    url: '${pageContext.request.contextPath}/gethistrwschemename',
						    success: function(data) {				        	
						    	var select = $('#scheme_name');
						    	select.find('option').remove();
						    	$('<option>').val("").text("--Select--").appendTo(select);
						           	  $.each(data, function(index, value) {	
						           		var scheme_nm_code = value.scheme_name + '(' + value.scheme_code + ')';
						           		  if(value.scheme_id == "${scheme_id}"){
						    	  $('<option selected>').val(value.scheme_id).text(scheme_nm_code).appendTo(select);
						           		  }else{
						           			$('<option>').val(value.scheme_id).text(scheme_nm_code).appendTo(select);
						           		  }
						    	});
						
						    }
						  });
					 
					 var schemeid = "${scheme_id}";
						$.ajax({
// 						    url: '${pageContext.request.contextPath}/getschemedepot',
						    url: '${pageContext.request.contextPath}/getschemedepotdetails',
						   data: ({schemeid :schemeid}),
						    success: function(data) {

						        var select = $('#appl_depot_code');
						        select.find('option').remove();
								$('<option>').val("").text("--Select--").appendTo(select);
						            $.each(data, function(index, value) {
						            	
// 						            	 if(value.depot_code == "${depo_code}"){

// 											$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
// 						            	 } else {
// 						            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
// 						            	 }

						            	if(value.sch_depot_code == "${depo_code}"){

						 					$('<option selected>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
						             	 } else {
						             		 $('<option>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
						             	 }

						        });

						    }
						 });
						
						 var depo = "${depo_code}";
	
						
						$.ajax({

							
							url: '${pageContext.request.contextPath}/getdealer_name',
	                        data: ({depot :depo,
	                        	schemeid : schemeid}),
	                        
	                         success: function(data) {

	                        	 var select = $('#dlr_ac_name');
	 					    	select.find('option').remove();
	 					    	$('<option>').val("").text("--Select--").appendTo(select);
	 					           	  $.each(data, function(index, value) {		        	
// 	 					           		if(value.dlr_ac_no == "${dealer_code}"){

// 	 					           			$('<option selected>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
// 	 					           		}
// 	 					           		else {
// 	 					           		$('<option>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
// 	 					           		}

	 					           	if(value.dlr_bill_to == "${dealer_code}"){

 					           			$('<option selected>').val(value.dlr_bill_to).text(value.dlr_ac_no + " - " + value.dlr_name).appendTo(select);
 					           		}
 					           		else {
 					           		$('<option>').val(value.dlr_bill_to).text(value.dlr_ac_no + " - " + value.dlr_name).appendTo(select);
 					           		}

	 					           		
	 					    	});

	                         }
	                      });
						
						var dealer = "${dealer_code}";
						$.ajax({
	                         url: '${pageContext.request.contextPath}/getbilltoid',
	                        data: ({dealer :dealer,
	                        	depot :depo,
	                        	schemeid : schemeid}),
	                         success: function(data) {

	                        	 var select = $('#bill_to_id');
	 					    	select.find('option').remove();
// 	 					    	$('<option>').val("").text("--Select--").appendTo(select);
	 					           	  $.each(data, function(index, value) {		        	

		 					           		if(value.opa_rw_an_dealer_id == "${dealer_billto}"){

	 					           			$('<option selected>').val(value.opa_rw_an_dealer_id).text(value.opa_rw_an_dealer_id).appendTo(select); 			
		 					           		}
		 					           		else {
		 					           		$('<option>').val(value.opa_rw_an_dealer_id).text(value.opa_rw_an_dealer_id).appendTo(select);
		 					           		}
	 					    	});

	                         }
	                      });



			
					 
					 $('#scheme_name').change(function(event) {
	                     var schemeid = $("select#scheme_name").val();

	                    $.ajax({
// 	                         url: '${pageContext.request.contextPath}/getschemedepot',
	                         url: '${pageContext.request.contextPath}/getschemedepotdetails',
	                        data: ({schemeid :schemeid}),
	                         success: function(data) {

	                        	 var select = $('#appl_depot_code');
	 					    	select.find('option').remove();
	 					    	$('<option>').val("").text("--Select--").appendTo(select);
	 					           	  $.each(data, function(index, value) {		        	
	 					           		
	 					        
// 								        		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
		            		 			$('<option>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
							    
	 					           		
	 					    	});
	 					           	var select1 = $('#dlr_ac_name');
		 					    	select1.find('option').remove();
		 					    	$('<option>').val("").text("--Select--").appendTo(select1);
		 					    	
		 					    	
		 					    	var select2 = $('#bill_to_id');
		 					    	select2.find('option').remove();
		 					    	$('<option>').val("").text("--Select--").appendTo(select2);

	                         }
	                      });


	        });
					 
					 
					 
					  $('#appl_depot_code').change(function(event) {
						  
						  var schemeid = $("select#scheme_name").val();
		                     var depot = $("select#appl_depot_code").val();

		                    $.ajax({
		                         url: '${pageContext.request.contextPath}/getdealer_name',
		                        data: ({depot :depot,
		                        	schemeid : schemeid}),
		                        
		                         success: function(data) {

		                        	 var select = $('#dlr_ac_name');
		 					    	select.find('option').remove();
		 					    	$('<option>').val("").text("--Select--").appendTo(select);
		 					           	  $.each(data, function(index, value) {		        	
		 					           		
// 			 								$('<option>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
			 								
			 								$('<option>').val(value.dlr_bill_to).text(value.dlr_ac_no + " - " + value.dlr_name).appendTo(select);
			 					       		
		 					    	});
		 					           	  
		 					           	  
		 						    	
			 					    	
			 					    	var select2 = $('#bill_to_id');
			 					    	select2.find('option').remove();
			 					    	$('<option>').val("").text("--Select--").appendTo(select2);


		                         }
		                      });


		        });
					
					 $('#dlr_ac_name').change(function(event) {
	                     var dealer = $("select#dlr_ac_name").val();
	                     var schemeid = $("select#scheme_name").val();
	                     var depot = $("select#appl_depot_code").val();

	                    $.ajax({
	                         url: '${pageContext.request.contextPath}/getbilltoid',
	                        data: ({dealer :dealer,
	                        	depot :depot,
	                        	schemeid : schemeid}),
	                         success: function(data) {

	                        	 var select = $('#bill_to_id');
	 					    	select.find('option').remove();
// 	 					    	$('<option>').val("").text("--Select--").appendTo(select);
	 					           	  $.each(data, function(index, value) {		        	
	 					           		
		 					           		$('<option>').val(value.opa_rw_an_dealer_id).text(value.opa_rw_an_dealer_id).appendTo(select);
			 					           	
	 					    	});

	                         }
	                      });


	        });
					 
					 
					
					/*  $('#appl_regn_code').change(function(event) {
	                     var region = $("select#appl_regn_code").val();

	                    $.ajax({
	                         url: '${pageContext.request.contextPath}/loaddependentregion1',
		                        data: ({ava_region :region}),
	                         success: function(data) {

	                        	 var select = $('#depot_name');
	 					    	select.find('option').remove();
	 					    	$('<option>').val("").text("--select--").appendTo(select);
	 					           	  $.each(data, function(index, value) {		        	
	 					           		alert(value.depot_code);
	 					           			$('<option>').val(value.depot_code).text(value.depot_name).appendTo(select); 			
	 					           		
	 					    	});

	                         }
	                      });


	        }); */
					  
					  
					 var region_type = "REGION_TYPE";


		             $.ajax({
		                    url: '${pageContext.request.contextPath}/loadregion',
		                    data: ({region : region_type}),
		                    success: function(data) {
		                        var select = $('#appl_regn_code');
		                             select.find('option').remove();
						$('<option>').val("").text("--Select--").appendTo(select);
		                          $.each(data, function(index, value) {
		                              if(value == "${JSON.appl_regn_code}") {
		                          $('<option selected>').val(value).text(value).appendTo(select);
		                              }else{
						$('<option>').val(value).text(value).appendTo(select);
		                              }
		                        });

		                    }
		                   });
		             
		             
		            
		             
		             $('#depot_name').change(function(event) {
		            	
	                     var region = $("select#depot_name").val();

	                    $.ajax({
	                         url: '${pageContext.request.contextPath}/getdealer_name',
	                        data: ({depot :region}),
	                         success: function(data) {

	                        	 var select = $('#dealer_name');
							    	select.find('option').remove();
							    	$('<option>').val("").text("--Select--").appendTo(select);
							           	  $.each(data, function(index, value) {		        	
							           		if(value.depot_name == "${deptnm}"){
							    	  $('<option selected>').val(value.dealer_name).text(value.dealer_name).appendTo(select);
							           		}else{
							           			$('<option>').val(value.dealer_name).text(value.dealer_name).appendTo(select); 			
							           		}
							    	});

	                         }
	                      });


	        });
		             		             
					$.ajax({
					    url: '${pageContext.request.contextPath}/getschemeterr',	
					    success: function(data) {				        	
					    	var select = $('#terr_name');
					    	select.find('option').remove();
					    	$('<option>').val("").text("--Select--").appendTo(select);
					           	  $.each(data, function(index, value) {		        	
					           		if(value.depot_name == "${deptnm}"){
					    	  $('<option selected>').val(value.depot_name).text(value.depot_name).appendTo(select);
					           		}else{
					           			$('<option>').val(value.depot_name).text(value.depot_name).appendTo(select); 			
					           		}
					    	});
					
					    }
					  });

		});
				</script>
<script>
        function myFunction1()
        {
        	setTimeout(myFunction3, 1000);
//         	  var depot_name = $('#depot_name').val();
				var depot_name = "011:Vadodara-2";
              var scheme_id = $('#scheme_name').val();
              
        	$.ajax({
			    url: '${pageContext.request.contextPath}/callopa',
			    data:({depot_name : depot_name ,scheme_id : scheme_id}),
			    success: function(data) {				        	
			    	
// 			    		 $("#show_report").show();  
// 			       		$("#show_details").show();
// 			       		$("#gen_report").hide();
			       		$("#loading").hide();
			       		myFunction2();
			    }
			  });
             		
       		
        	
        	
        		
        	
       //	 window.location.href = "callopa?deptnm="+depot_name+"&&schnm="+scheme_name+"";
        }
        
        function myFunction3()
        {
        	$("#loading").show();	
        }

        function myFunction2()
        {
//         	 $("#gen_report").hide(); 
            var depot_name = $('#depot_name').val();
            var scheme_name = $('#scheme_name').val();

        window.location.href = "loadrewarddata?schnm="+scheme_name+"";
        //$("#show_details").show();
        }
        
        function gifttocn(j)
        {
        	var gift_to_cn_flag = $('#gift_to_cn_flag'+j).val();
        	var n = gift_to_cn_flag.charCodeAt(0);
        	if(gift_to_cn_flag.length == 1 ){
        		if(n == 89 || n == 78 ) {
                	var reward_gift_id = $('#reward_gift_id'+j).val();
                	var reward_total = $('#reward_total'+j).val();
                	var adjustments = $('#adjustments'+j).val();
                	var adjustment_reason = $('#adjustment_reason'+j).val();
                	var converted_cn_value = '0';
                	if(gift_to_cn_flag == 'Y') 
                	{
                		$('#attribute1'+j).val("Y");
                		$.ajax({
                		    url: '${pageContext.request.contextPath}/getgifttocn',
                		    data: ({reward_gift_id :reward_gift_id}),
                		    success: function(data) {	
                		    	var gift_to_cn = data;
                		    	
                		    	if(gift_to_cn == 0) {
                		    		if(adjustments == 0 && adjustment_reason == '') {
                		        		$('#attribute1'+j).val("");
                		        	}
                		    		$('#gift_to_cn_flag'+j).val("N");
                		    		alert("Gift to CN not allowed for this Gift as Gift to CN value for this gift is 0. ");
                		    	}
                		    	
                		    	converted_cn_value = gift_to_cn *  reward_total;
                		    	$('#converted_cn_value'+j).val(converted_cn_value);  
                		    	
                		    	   	  

                		    }
                		});
                	}
                	else {
                		$('#converted_cn_value'+j).val(converted_cn_value);
                		if(adjustments == 0 && adjustment_reason == '') {
                			$('#attribute1'+j).val("");
                		}
                	}

        		} else {
       			 alert("Only 'Y' or 'N' is allowed for Gift to CN flag");
    			 $('#gift_to_cn_flag'+j).val("N");
    			}
        	} else {
        		alert("Only 'Y' or 'N' is allowed for Gift to CN flag");
        		$('#gift_to_cn_flag'+j).val("N");
        	}
        }
        </script>


<script>
		    function submitform(j)
		    {
		    	$('#action').val("Update");
		    	
		    	 var adjustflag = $('#attribute1'+j).val();
		    	 
				if(adjustflag == "Y")
		         {
					
					var adjustments = $('#adjustments'+j).val();
					var adjustment_reason = $('#adjustment_reason'+j).val();
					
					if(adjustments == "" || adjustment_reason == "") {
						alert("Please provide adjustment amount and reason.");
						
					} else {
				         var aa = confirm('Do you want to update this scheme?')
				         if(aa == true)
				         {
				        	 var table = $('#table1').DataTable();
				        	 var data = table.$('input, select').serialize();
				        	 var formdata = $('#Saveform').serialize();
				             $('#Saveform').submit();
				             
		// 		             $.ajax({
		// 		 			    url: '${pageContext.request.contextPath}/updateoutput',
		// 		 			   type: 'post',
		// 		 			    data: data,
		// 		 			    success: function(data) {				        	
				 			    	
		// 		 			    }
		// 		 			  });
				             
				             }
				         else {
				                 return false;
				             }
					}
		         } else {
		        	 var aa = confirm('Do you want to update this scheme?')
			         if(aa == true)
			         {
			        	 var table = $('#table1').DataTable();
			        	 var data = table.$('input, select').serialize();
			        	 var formdata = $('#Saveform').serialize();
			             $('#Saveform').submit();
			             
	// 		             $.ajax({
	// 		 			    url: '${pageContext.request.contextPath}/updateoutput',
	// 		 			   type: 'post',
	// 		 			    data: data,
	// 		 			    success: function(data) {				        	
			 			    	
	// 		 			    }
	// 		 			  });
			             
			             }
			         else {
			                 return false;
			             }
		         }
		    }
		    
		    function submitform1(j)
		    {
		    	$('#action').val("Freeze");
		    	
		    	var adjustflag = $('#attribute1'+j).val();
		    	 
		    	
		    	if(adjustflag == "Y")
		         {
		    	
					var adjustments = $('#adjustments'+j).val();
					var adjustment_reason = $('#adjustment_reason'+j).val();
					
					
					if(adjustments == "" || adjustment_reason == "") {
						alert("Please provide adjustment amount and reason.");
						
					} else {
				         var aa = confirm('Are you sure to freeze this scheme?')
				         if(aa == true)
				         {
				             $('#Saveform').submit();
				             }
				         else {
				                 return false;
				             }
					}
		         } else {
		        	 var aa = confirm('Are you sure to freeze this scheme?')
			         if(aa == true)
			         {
			             $('#Saveform').submit();
			             }
			         else {
			                 return false;
			             }
		         }
		    }
		    </script>

<script>
		 $('.adjustpoints').keyup(function(){	
			 
		 	var sum = 0;			 
			var count = $('.adjustpoints').index(this)+1;
			var adjustments = $('#adjustments'+count).val();
        	var adjustment_reason = $('#adjustment_reason'+count).val();
			
// 			 $('#sch_tot_cn_pts'+count).val("0"); 
			
// 			 var part1_value = $('#part1_value'+count).val();  
// 			 var part2_value = $('#part2_value'+count).val();  
// 			 var sch_adj_pts = $('#sch_adj_pts'+count).val();  
			 
// 			 var sum = parseInt(part1_value) + parseInt(part2_value) + parseInt(sch_adj_pts);
			 
// 			 $('#sch_tot_cn_pts'+count).val(sum);
			 if(adjustments == 0 && adjustment_reason == '') {
             	$('#attribute1'+count).val("");
             } else {
            	 $('#attribute1'+count).val("Y");
             }
			 
		 });
		 
		 $('.adjustreason').keyup(function(){	
			 
			 	var sum = 0;			 
				var count = $('.adjustreason').index(this)+1;
				var adjustments = $('#adjustments'+count).val();
	        	var adjustment_reason = $('#adjustment_reason'+count).val();
				
//	 			 $('#sch_tot_cn_pts'+count).val("0"); 
				
//	 			 var part1_value = $('#part1_value'+count).val();  
//	 			 var part2_value = $('#part2_value'+count).val();  
//	 			 var sch_adj_pts = $('#sch_adj_pts'+count).val();  
				 
//	 			 var sum = parseInt(part1_value) + parseInt(part2_value) + parseInt(sch_adj_pts);
				 
//	 			 $('#sch_tot_cn_pts'+count).val(sum);
				 if(adjustments == 0 && adjustment_reason == '') {
	             	$('#attribute1'+count).val("");
	             } else {
	            	 $('#attribute1'+count).val("Y");
	             }
				 
			 });
		 
		 $('.adjustgift').keyup(function(){	
			 
			 	var sum = 0;			 
				var count = $('.adjustgift').index(this)+1;
				
//	 			 $('#sch_tot_cn_pts'+count).val("0"); 
				
//	 			 var part1_value = $('#part1_value'+count).val();  
//	 			 var part2_value = $('#part2_value'+count).val();  
//	 			 var sch_adj_pts = $('#sch_adj_pts'+count).val();  
				 
//	 			 var sum = parseInt(part1_value) + parseInt(part2_value) + parseInt(sch_adj_pts);
				 
//	 			 $('#sch_tot_cn_pts'+count).val(sum);
				 $('#attribute1'+count).val("Y");
				 
			 });
		 
		 $('.adjustcn').keyup(function(){	
			 
			 	var sum = 0;			 
				var count = $('.adjustcn').index(this)+1;
				
//	 			 $('#sch_tot_cn_pts'+count).val("0"); 
				
//	 			 var part1_value = $('#part1_value'+count).val();  
//	 			 var part2_value = $('#part2_value'+count).val();  
//	 			 var sch_adj_pts = $('#sch_adj_pts'+count).val();  
				 
//	 			 var sum = parseInt(part1_value) + parseInt(part2_value) + parseInt(sch_adj_pts);
				 
//	 			 $('#sch_tot_cn_pts'+count).val(sum);
				 $('#attribute1'+count).val("Y");
				 
			 });
		 </script>


<script>
		function showgrid(){
			$('#grid1').show();
		}
		</script>
<script>
	$(document).ready(function(){
		
		$("#loading").hide();
		
	})
	</script>

