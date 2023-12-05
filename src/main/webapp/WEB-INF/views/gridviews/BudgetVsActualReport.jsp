<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form method="post" id="Saveform">
	
	<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Budget Vs Actual</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href=""> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                    <li class="breadcrumb-item"><a href="">Report</a>
                                                    </li>
                                                    <li class="breadcrumb-item"><a href="BudgetVsActualReport">Budget Vs Actual</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              <!-- Page-header end -->
		<div class="card">
					<div class="card-block">
						<div class="form-group row">
<!-- 						<div class="col-md-3"></div> -->
						
							<div class="col-md-4">
							<label class="control-label" for="inputSuccess">Scheme Name<span class="required">*</span></label>
					  <select class="js-example-basic form-control" name="scheme_name" id="scheme_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
						</div>
					</div>
				</div>

		<div class="form-group row">
			<div class="col-md-12" style="text-align: center;">
				<input type="button" class="btn btn-primary" id="action4"
					value="Show Report" onclick="searchinfo()"></input> <input
					type="button" class="btn btn-primary" id="action5"
					value="Download Report" onclick="downloadreport()"></input>
			</div>
		</div>

		<!-- start: page -->
		<div class="card">
					<div class="card-header">
						<h5>Budget Vs Actual Report</h5>
						<div class="card-header-right">
							<ul class="list-unstyled card-option">
								<li><i class="feather icon-maximize full-card"></i></li>
								<li><i class="feather icon-minus minimize-card"></i></li>
								<li><i class="feather icon-trash-2 close-card"></i></li>
							</ul>
						</div>
					</div>
					<div class="card-block">
						<table class="table table-bordered table-striped"
					id="datatable-editable"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th style="min-width: 150px;">Report Month</th>
							<th style="min-width: 150px;">ML Business Line</th>
							<th style="min-width: 150px;">Scheme Code</th>
							<th style="min-width: 250px;">Scheme Name</th>
							<th style="min-width: 100px;">Budget</th>
							<th style="min-width: 200px;">Expense Before Exception</th>
							<th style="min-width: 180px;">Expense After Exception</th>
							<th style="min-width: 210px;">Variance from budget(Before
								Exception)</th>
							<th style="min-width: 200px;">Variance from budget(After
								Exception)</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 1;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<tr>
								<td>${info.report_month}</td>
								<td>${info.ml_business_line}</td>
								<td>${info.scheme_code}</td>
								<td>${info.scheme_name}</td>
								<td>${info.budget}</td>
								<td>${info.expense_before_exception}</td>
								<td>${info.expense_after_exception}</td>
								<td>${info.variance_from_budget_before_exception}</td>
								<td>${info.variance_from_budget_after_exception}</td>

							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
				</table>
					</div>
				</div>
	</form>
	<!-- end: page -->

<script>
$(window).load(function() {

	$('.required').css({
	'color' : 'red'
	});
	

	});
	

	$(document).ready(function() {
		
		$('#scheme_name').css({
			'background-color' : 'white'
			});
		//alert("***");

		//	$.getJSON('${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval', // ${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval
		//	function(json) {
		/*
		$('#datatable-editable').dataTable( {
		    "aaData": json,
		    "columns": [
		        { "data": "scheme_id" } ,
		        { "data": "scheme_name" },
		        { "data": "scheme_code" },
		        { "data": "start_date1" }, 
		        { "data": "end_date1" },
		        { "data": "submission_date1" },
		        { "data": "active_flag" }
		    ]
		})
		 */

		//	var tr;
		/*
		$('#datatable-editable').DataTable().destroy();
		 */

		/* 	for (var i = 0; i < json.length; i++) {

				tr = $('<tr/>');
				tr.append("<td>" +i+"</td>");
				tr.append("<td>" + json[i].scheme_name + "</td>");
				tr.append("_$ta" +  json[i].scheme_code + "_$tag");
				tr.append("_$ta" + json[i].start_date1 + "_$tag");
				tr.append("_$ta" + json[i].end_date1 + "_$tag");
				tr.append("_$ta" + json[i].submission_date1 + "_$tag");
				tr.append("_$ta" + json[i].active_flag + "_$tag");
		
				$('#datatable-editable').find('tbody').append(tr);
				//$('#datatable-editable').append(tr);
			}
		 */

		$('#datatable-editable').DataTable().draw();

		/* 	});  */

		//var oTable = $('#datatable-editable').DataTable( );
		// to reload
		//oTable.ajax.reload();
		/*
		var table = $('#datatable-editable').DataTable();
		table.draw();
		 */

		/*
		$.ajax({
		'url': "${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval",
		'method': "GET",
		'contentType': 'application/json'
		}).done( function(data) {
		$('#datatable-editable').dataTable( {
		    "aaData": data,
		    "columns": [
		        { "data": "scheme_id" } ,
		        { "data": "scheme_name" },
		        { "data": "scheme_code" },
		        { "data": "start_date1" }, 
		        { "data": "end_date1" },
		        { "data": "submission_date1" },
		        { "data": "active_flag" }
		    ]
		})
		}); */

	});
</script>

<script>
				$(window).load(function(){

					$('.col-xs-12.col-sm-12').css({
						'overflow-x' : 'auto'
					}); 
					
						$.ajax({
						    url: '${pageContext.request.contextPath}/getBudgetVsActualschemename',
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


		});
				</script>

<script type="text/javascript">
	function downloadreport() {
		if(document.getElementById("scheme_name").value == ""){
			alert("Please select scheme name");
		}else{
			var scheme_name=document.getElementById("scheme_name").value;	

			window.location.href="downloadBudgetVsActualReport?scheme_name="+scheme_name;
		}	
	}

	function searchinfo() {
		if(document.getElementById("scheme_name").value == ""){
			alert("Please select scheme name");
		}else{
			var scheme_name=document.getElementById("scheme_name").value;	
			
			window.location.href="generateBudgetVsActualReport?scheme_name="+scheme_name;
		}
	}
</script>
