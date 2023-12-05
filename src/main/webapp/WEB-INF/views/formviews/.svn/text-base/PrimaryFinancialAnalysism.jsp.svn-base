<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="..\files\assets\scss\partials\menu\_pcmenu.htm">
<title>BSAT-R3</title>
</head>
<body>

	<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Primary Fin Analysis</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href="marketing"> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="#!">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="primaryfinancialanalysism">Primary Fin Analysis</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                             <!-- Page-header end -->

	<div class="card">
		<div class="card-header">
			<h5>Primary Financial Analysis</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<form action="financialanalysis" class="form-horizontal"
		ModelAttribute="New_Scheme_mstr" id="Saveform" method="Post"
		enctype="multipart/form-data">
				<div class="form-group row">
					<div class="col-sm-3">
						<label class="col-form-label" for="inputSuccess">Reference
							Scheme</label> <select class="form-control form-control-sm"
							name="reference_sch_id" id="reference_sch_id" required="required"
							onChange="fetchdata()">
							<option>--Select--</option>
							
						</select>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label" for="inputSuccess">Total
							Volume for the Scheme</label> <input type="text"
							class="form-control form-control-sm" name="total_sch_vol"
							id="total_sch_vol" readonly="readonly"></input>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label" for="inputSuccess">Total
							Value for the Scheme</label> <input type="text"
							class="form-control form-control-sm" id="total_sch_val"
							name="total_sch_val" readonly="readonly"></input>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label" for="inputSuccess">Rs / Lt</label> <input
							type="text" class="form-control form-control"
							name="sch_reward_eff_price" id="sch_reward_eff_price"
							readonly="readonly"></input>
					</div>
				</div>

				<div class="form-group row">


					<div class="col-sm-3">
						<label class="col-form-label">Total No. of dealer
							Qualified</label> <input type="text" class="form-control form-control-sm"
							name="total_sch_qlfd_dlrs" id="total_sch_qlfd_dlrs"
							readonly="readonly"></input>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label">Scheme Actual Spending</label> <input
							class="form-control-sm form-control" type="text"
							name="sch_actual_budget" id="sch_actual_budget"
							readonly="readonly"></input>
					</div>
					<div class="col-sm-3">
						<label class="col-form-label">Confidence %</label> <input
							type="text" class="form-control form-control-sm"
							name="confidence_pct" onblur="mult()" id="confidence_pct"
							value="100" onkeypress="return isNumber(event);"
							pattern="[0-9]+([\.,][0-9]+)?" step="0.01"></input>
					</div>
					<div class="col-md-3">
						<label class="col-form-label">Predicted Outflow</label> <input
							type="text" class="form-control-sm form-control" name="outflow"
							id="outflow" readonly="readonly"></input>
					</div>
				</div>
			</form>
		</div>
	</div>
<script>
function fetchdata()
{
	 var refsch = document.getElementById("reference_sch_id").value;
	 
//	 var lovtype = a; 
	 $.ajax({ 
		        url: '${pageContext.request.contextPath}/loadschemedata', 
		        data: ({scheme : refsch}), 
	        	success: function(data) {
		              $.each(data, function(index, value) {
		            	  document.getElementById("total_sch_vol").value=value.total_sch_vol;
		            	  document.getElementById("total_sch_val").value=value.total_sch_val;
		            	  document.getElementById("total_sch_qlfd_dlrs").value=value.total_sch_qlfd_dlrs;
		            	  
		            	  document.getElementById("sch_actual_budget").value=value.sch_actual_budget;
		            	  
		            	  if(value.total_sch_vol == 0) {
		            		  document.getElementById("sch_reward_eff_price").value="0" ;
		            	  } else {
		            	  
		            	  document.getElementById("sch_reward_eff_price").value=(value.total_sch_val / value.total_sch_vol).toFixed(2) ;
		            	  }
		            	  document.getElementById("confidence_pct").value=100;
		            	  
		            	  var c=document.getElementById("sch_actual_budget").value;
		          		var d=document.getElementById("confidence_pct").value;
		          		var r=1;
		          		
		          		var outflow=(c*d*r)/100;
		          		document.getElementById("outflow").value=outflow;
	            }); 

		        } 
		      }); 
}

function mult()
{
	var c=document.getElementById("sch_actual_budget").value;
	var d=document.getElementById("confidence_pct").value;
	var r=1;
	
	
	var outflow = (c*d*r)/100;
	document.getElementById("outflow").value = outflow;
	
	
}

function isNumber(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode;

	if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
    
	return false;

	
return true;
}
</script>

<script>
		    window.onload = function () {
		       //alert("hello");
		       
		       $.ajax({
			        url: '${pageContext.request.contextPath}/loadscheme',
			        
			        success: function(data) {
			            var select = $('#reference_sch_id');
			            select.find('option').remove();
			            $('<option>').val("").text("--Select--").appendTo(select);
			              $.each(data, function(index, value) {
			            	  
						  $('<option>').val(value.scheme_id).text(value.scheme_name).appendTo(select);
			            });
		
			        }
			      }); 
		}
		</script>

</body>
</html>