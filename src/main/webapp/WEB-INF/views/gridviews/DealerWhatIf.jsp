

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	
							<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Dealer What If</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href=""> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="BudgetVsActualReport">Dealer What If</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              <!-- Page-header end -->

	<form class="form-horizontal form-bordered"
		action="" method="post" id="Saveform">
		<div class="form-group row">
		<div class="col-md-4">
			<label class="control-label">Scheme Name<font>*</font></label> <select
				class="form-control form-control-sm "
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
				required>
				<option>--Select--</option>
			</select>
		</div>


		<div style="display: none;">
			<div style="display: none">
				<label>Region <i class="menu-icon fa red"> *</i>
				</label> <select name="appl_regn_code" id="appl_regn_code" required>
				</select>
			</div>
		</div>


		<div class="col-md-4">
			<label class="control-label">Distributors<font>*</font></label> <select
				class="form-control form-control-sm "
						data-plugin-selectTwo name="appl_depot_code"
				id="appl_depot_code" required>
				<option>--Select--</option>
			</select>
		</div>


		<div class="col-md-4">
			<label class="control-label">Dealer Name<font>*</font></label> <select
				class="form-control form-control-sm "
						data-plugin-selectTwo name="dlr_ac_name" id="dlr_ac_name"
				required>
				<option>--Select--</option>
			</select>
		</div>

		<div style="display: none;">
			<input type="hidden" name="whatifInt" id="whatifInt" value="">
			<input type="hidden" name="schopawebservice" id="schopawebservice"
				value="">
		</div>

		<div style="display: none;">
			<div>
				<label>Bill To Id <i class="menu-icon fa red"> *</i>
				</label>

				<div>
					<div>
						<select name="bill_to_id" id="bill_to_id" required>
						</select>

					</div>
				</div>
			</div>
		</div>
		</div>
<!-- <hr> -->
		<div class="form-group row">
		<div class="col-md-3"></div>
			<div class="col-md-6 text-center col-sm-6 col-sm-offset-3">
				<input type="button" class="btn btn-primary btn-sm" name="gen_report"
					id="gen_report" value="Run What IF Analysis"
					onclick="whatifInterview()"></input>
			</div>
		</div>

	</form>	
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
			
					
					
					$.ajax({
					    url: '${pageContext.request.contextPath}/getschemenamewhatif',	
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
					//	    url: '${pageContext.request.contextPath}/getschemedepot',
						url: '${pageContext.request.contextPath}/getschemedepotdetails',
					   	data: ({schemeid :schemeid}),
					    success: function(data) {
					
					    	var select = $('#appl_depot_code');
					        select.find('option').remove();
							$('<option>').val("").text("--Select--").appendTo(select);
					        $.each(data, function(index, value) {
					            	
					//	            	 if(value.depot_code == "${depo_code}"){
					
					//						$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
					//	            	 } else {
					//	            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
					//	            	 }
					
					        	if(value.sch_depot_code == "${depo_code}"){
					
					 				$('<option selected>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
					            } else {
					            	$('<option>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
					            }
					
					        });
					
					    }
					});
					
					$.ajax({
				    	url: '${pageContext.request.contextPath}/getopawhatifInterview',
				   		data: ({scheme_id :schemeid}),
				    	success: function(data) {
				    	
				    		$('#whatifInt').val(data);


				    	}
				 	});
					
					$.ajax({
				    	url: '${pageContext.request.contextPath}/getschopawebserviceUrl',
				   		data: ({scheme_id :schemeid}),
				    	success: function(data) {
				    	
				    		$('#schopawebservice').val(data);


				    	}
				 	});
					
					var depo = "${depo_code}";
					$.ajax({
				    	url: '${pageContext.request.contextPath}/getWhatIfdealer_name',
				    	data: ({depot :depo,
				        		schemeid : schemeid}),
				        
				        success: function(data) {

				       		var select = $('#dlr_ac_name');
						    select.find('option').remove();
						    $('<option>').val("").text("--Select--").appendTo(select);
						    $.each(data, function(index, value) {		        	
//						           		if(value.dlr_ac_no == "${dealer_code}"){

//						           			$('<option selected>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
//						           		}
//						           		else {
//						           		$('<option>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
//						           		}

						    	if(value.dlr_bill_to == "${dealer_code}"){

					           		$('<option selected>').val(value.dlr_bill_to).text(value.dlr_ac_no + " - " + value.dlr_name).appendTo(select);
					           	}
					           	else {
					           		$('<option>').val(value.dlr_bill_to).text(value.dlr_ac_no + " - " + value.dlr_name).appendTo(select);
					           	}

						           		
						    });

				        }
				    });
				  
					$('#scheme_name').change(function(event) {
				    	var scheme_id = $("select#scheme_name").val();
				    
				    	$.ajax({
//				         url: '${pageContext.request.contextPath}/getschemedepot',
					    	url: '${pageContext.request.contextPath}/getschemedepotdetails',
					       	data: ({schemeid :scheme_id}),
					        success: function(data) {

					       	 	var select = $('#appl_depot_code');
						    	select.find('option').remove();
						    	$('<option>').val("").text("--Select--").appendTo(select);
						        $.each(data, function(index, value) {		        	
					           		
					        
//							        		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
						 			$('<option>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
						    
					           		
					    		});
					        
						        var select1 = $('#dlr_ac_name');
							    select1.find('option').remove();
							    $('<option>').val("").text("--Select--").appendTo(select1);
						    	
					           	
						   

				        	}
				    	});
				    
				    	$.ajax({
				        	url: '${pageContext.request.contextPath}/getopawhatifInterview',
				       		data: ({scheme_id :scheme_id}),
				        	success: function(data) {
				        	
				        		$('#whatifInt').val(data);


				        	}
				     	});
				    	
				    	$.ajax({
				        	url: '${pageContext.request.contextPath}/getschopawebserviceUrl',
				       		data: ({scheme_id :scheme_id}),
				        	success: function(data) {
				        	
				        		$('#schopawebservice').val(data);


				        	}
				     	});

					});
				});

					$('#appl_depot_code').change(function(event) {
					  
						var schemeid = $("select#scheme_name").val();
				       	var depot = $("select#appl_depot_code").val();
				       

				      	$.ajax({
				        	url: '${pageContext.request.contextPath}/getWhatIfdealer_name',
				          	data: ({depot :depot,
				          			schemeid : schemeid}),
				          
				           	success: function(data) {

				          		var select = $('#dlr_ac_name');
						    	select.find('option').remove();
						    	$('<option>').val("").text("--Select--").appendTo(select);
						        $.each(data, function(index, value) {		        	
						           		
//										$('<option>').val(value.dlr_ac_no).text(value.dlr_name).appendTo(select);
											
									$('<option>').val(value.dlr_bill_to).text(value.dlr_ac_no + " - " + value.dlr_name).appendTo(select);
							       		
						    	});
						           	  
						           	  
							    	
							    	
							}
				        });
				    });
				
				</script>

<script type="text/javascript">
function whatifInterview() {
	
	var whatifInt = $('#whatifInt').val();
    var scheme_id = $('#scheme_name').val();
    var depot_code = $('#appl_depot_code').val();
    var dlr_ac_name = $('#dlr_ac_name').val();
    
    if(scheme_id != ""){
    	if(depot_code != ""){
    		if(dlr_ac_name != ""){
    			if(whatifInt != null && whatifInt != "") {
            		window.open(whatifInt+"?scheme_id="+scheme_id+"&depot="+depot_code+"&bill_to_id="+dlr_ac_name);
            	}
            	else{
            	 	alert("No what if url for this scheme");
            	}
    		} else{
            	alert("Please select dealer name.");
            }
    		
    	} else{
        	alert("Please select depot name.");
        }
    	
    	
    } else{
    	alert("Please select scheme name.");
    }
}
</script>


<script>
		function showgrid(){
			$('#grid1').show();
		}
		</script>

