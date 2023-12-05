

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Reward Approval</span></li>
				<li><span>Adjust Reward Details</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<form action="updateoutput" ModelAttribute="Bpil_Opa_Rw_Analysis_Rw"
		method="post" id="Saveform" enctype="multipart/form-data">
		<div class="form-group">
			<div class="col-md-12">
				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Scheme Name</label>
					<input class="form-control" type="text" name="scheme_name"
						id="scheme_name" value="${scheme_name} (${scheme_code})" readonly></input>
				</div>
				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Distributors</label> <input
						class="form-control" type="text" name="depot" id="depot"
						value="${depot}" readonly></input>
				</div>
				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Dealer Name</label>
					<input class="form-control" type="text" name="dlr_name"
						id="dlr_name" value="${dlr_ac_no} - ${dlr_name}" readonly></input>
				</div>
				<div style="display: none;">
					<label class="control-label" for="inputSuccess">Bill To Id</label>
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="bill_to_id" id="bill_to_id"
						required="required">
					</select>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12" style="text-align: center;">
				<input type="button" class="btn btn-primary" id="action4"
					value="Search" onclick="searchinfo()"></input>
			</div>
		</div>

		<hr>
		<label>Redeemed On : ${LastRefresh}</label>
		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a> <a href="#"
						class="fa fa-times"></a>
				</div>
				<h2 class="panel-title">Dealer Details</h2>

			</header>
			<div class="panel-body"
				style="display: inline-block; overflow: scroll; width: 100%; height: 500px">
				<table class="table table-bordered table-striped"
					id="datatable-editable2"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th style="min-width: 100px;">Distributors</th>
							<th style="min-width: 150px;">A/C No.</th>
							<th style="min-width: 250px;">A/C Name</th>
							<th style="min-width: 250px;">Reward Section</th>
							<th style="min-width: 100px;">Reward Type</th>
							<th style="min-width: 100px;">Product</th>
							<th style="min-width: 100px;">Unit</th>
							<th style="min-width: 120px;">Reward Date</th>
							<th style="min-width: 100px;">LY</th>
							<th style="min-width: 100px;">Target</th>
							<th style="min-width: 100px;">TY</th>
							<th style="min-width: 100px;">TGT Pending</th>
							<th style="min-width: 100px;">Status</th>
							<th style="min-width: 250px;">Reward Desc</th>
							<th style="min-width: 150px;">Actual</th>
							<th style="min-width: 150px;">Requested</th>
							<th style="min-width: 250px;">Adjustment Reason</th>
							<th style="min-width: 150px;">Gift TO CN</th>
							<th style="min-width: 100px;">Converted CN Value</th>
							<th style="min-width: 100px;">Adjustment Flag</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 0;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<c:set var="interface_status">${info.interface_status}</c:set>
							<c:set var="reward_section_total">${info.reward_section}</c:set>
							<c:set var="reward_gift_id">${info.reward_gift_id}</c:set>
							<c:set var="reward_color">${info.reward_color}</c:set>
							<%
								String interface_status = (String) pageContext.getAttribute("interface_status");
							%>
							<%
								String reward_section_total = (String) pageContext.getAttribute("reward_section_total");
									String reward_gift_id = (String) pageContext.getAttribute("reward_gift_id");
							%>
							<%
								if (interface_status.equals("P")) {
							%>
							<tr style="background-color: #c5d0dc;">
								<%
									} else {
								%>
							
							<tr>
								<%
									}
								%>
								<%
									if (reward_section_total.equalsIgnoreCase("TOTAL")) {
								%>



								<input type="hidden" id="opa_analysis_id<%=j%>"
									name="info[<%=j%>].opa_analysis_id" style="width: 100%"
									value="${info.opa_analysis_id}" />
								<input type="hidden" id="scheme_id<%=j%>" name="info[<%=j%>].scheme_id"
									value="${info.scheme_id}" />
								<td>${info.depot}</td>
								<td>${info.dlr_ac_no}</td>
								<td>${info.dlr_name}</td>

								<%
									} else {
								%>



								<input type="hidden" id="opa_analysis_id<%=j%>"
									name="info[<%=j%>].opa_analysis_id" style="width: 100%"
									value="${info.opa_analysis_id}" />
								<input type="hidden" id="scheme_id<%=j%>" name="info[<%=j%>].scheme_id"
									value="${info.scheme_id}" />
								<td><input type="hidden" id="depot<%=j%>" name="info[<%=j%>].depot"
									style="width: 100%" value="${info.depot}" /></td>
								<td><input type="hidden" id="dlr_ac_no<%=j%>"
									name="info[<%=j%>].dlr_ac_no" style="width: 100%" value="${info.dlr_ac_no}" /></td>
								<td><input type="hidden" id="dlr_name<%=j%>"
									name="info[<%=j%>].dlr_name" style="width: 100%" value="${info.dlr_name}" /></td>

								<%
									}
								%>

								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_section}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_type}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.product}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.unit}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_date1}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ly}</td>

								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_target}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ty}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.next_tgt_pending}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_status}</td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_description}<input
									type="hidden" id="reward_description<%=j%>"
									name="info[<%=j%>].reward_description" style="min-width: 100%"
									value="${info.reward_description}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_total}<input
									type="hidden" id="reward_total<%=j%>" name="info[<%=j%>].reward_total"
									style="min-width: 100%" value="${info.reward_total}" /></td>
								<%
									if (interface_status.equals("P")) {
								%>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="adjustments<%=j%>" name="info[<%=j%>].adjustments"
									style="width: 100%" value="${info.adjustments}"
									class="adjustpoints" onkeypress="return isNumber(event);"
									pattern="[0-9]{1,15}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="adjustment_reason<%=j%>"
									name="info[<%=j%>].adjustment_reason" style="width: 100%"
									value="${info.adjustment_reason}" class="adjustreason" /></td>

								<td bgcolor="<c:out value='${reward_color}'/>">
									<%
										if (reward_gift_id.equals("")) {
									%> <input type="hidden" id="reward_gift_id<%=j%>"
									name="info[<%=j%>].reward_gift_id" style="width: 100%"
									value="${info.reward_gift_id}" /> <input type="text"
									id="gift_to_cn_flag<%=j%>" name="info[<%=j%>].gift_to_cn_flag"
									style="width: 100%" value="${info.gift_to_cn_flag}" readonly />
									<%
										} else {
									%> <input type="hidden" id="reward_gift_id<%=j%>"
									name="info[<%=j%>].reward_gift_id" style="width: 100%"
									value="${info.reward_gift_id}" /> <input type="text"
									id="gift_to_cn_flag<%=j%>" name="info[<%=j%>].gift_to_cn_flag"
									style="width: 100%" value="${info.gift_to_cn_flag}"
									onblur="gifttocn(<%=j%>)" /> <%
 	}
 %>
								</td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="converted_cn_value<%=j%>"
									name="info[<%=j%>].converted_cn_value" style="width: 100%"
									value="${info.converted_cn_value}" class="adjustcn"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}"
									readonly="readonly" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="text" id="attribute1<%=j%>" name="info[<%=j%>].attribute1"
									style="width: 100%" value="${info.attribute1}" readonly /></td>
								<%
									} else {
								%>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.adjustments}<input
									type="hidden" id="adjustments<%=j%>" name="info[<%=j%>].adjustments"
									style="width: 100%" value="${info.adjustments}"
									class="adjustpoints" onkeypress="return isNumber(event);"
									pattern="[0-9]{1,15}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.adjustment_reason}<input
									type="hidden" id="adjustment_reason<%=j%>"
									name="info[<%=j%>].adjustment_reason" style="width: 100%"
									value="${info.adjustment_reason}" class="adjustreason" /></td>

								<td bgcolor="<c:out value='${reward_color}'/>">${info.gift_to_cn_flag}<input
									type="hidden" id="gift_to_cn_flag<%=j%>" name="info[<%=j%>].gift_to_cn_flag"
									style="width: 100%" value="${info.gift_to_cn_flag}"
									class="adjustgift" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.converted_cn_value}<input
									type="hidden" id="converted_cn_value<%=j%>"
									name="info[<%=j%>].converted_cn_value" style="width: 100%"
									value="${info.converted_cn_value}" class="adjustcn"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.attribute1}<input
									type="hidden" id="attribute1<%=j%>" name="info[<%=j%>].attribute1"
									style="width: 100%" value="${info.attribute1}" /></td>
								<%
									}
								%>

							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>

		<hr>
		<div class="form-group">
			<div class="col-md-12" style="text-align: center;">
				<input type="hidden" name="action" id="action" value="" /> <input
					type="button" class="btn btn-primary"
					name="gen_report" value="Close Window" onclick="closeform()"></input> <input
					type="button" class="btn btn-primary" id="action1"
					value="Save" onclick="submitform()"></input>

			</div>
		</div>

	</form>
	<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	$(document).ready(function() {
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
		$('#datatable-editable1').DataTable().draw();

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
						    url: '${pageContext.request.contextPath}/getadjustschemerw',
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

<script type="text/javascript">

	function searchinfo() {
		var scheme_name=document.getElementById("scheme_name").value;	
		var depot_code=document.getElementById("appl_depot_code").value;
		var dealer_name=document.getElementById("dlr_ac_name").value;
		var bill_to_id=document.getElementById("bill_to_id").value;


		window.location.href="adjust_reward?scheme_name="+scheme_name+"&depot_code="+depot_code+"&dealer_name="+dealer_name+"&bill_to_id="+bill_to_id;

	}
	
	function isNumber(evt) {
		var iKeyCode = (evt.which) ? evt.which : evt.keyCode;

		if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
	    
		return false;

		
	return true;
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
function submitform()
{
	$('#action').val("RwUpdate");
	
	var totalrowcount = $('#table1 tr').length-1;
	var adjustamt = true;
	var adjustres = true;
	for(i=1; i<=totalrowcount; i++){
	
			var adjustflag = $('#attribute1'+i).val();
    	 

		if(adjustflag == "Y")
         {
    	
			var adjustments = $('#adjustments'+i).val();
			var adjustment_reason = $('#adjustment_reason'+i).val();
			
			
			if(adjustments == "") {
				adjustamt = false;
				
				
			}
			if(adjustment_reason == "") {
				adjustres = false;
				
				
			}
				
		}
	}
	if (adjustamt == false) {
		alert("Please provide adjustment amount.");
	        return false;
	    
	    } else 
		
		if (adjustres == false) {
			alert("Please provide adjustment reason.");
	        return false;
	    
	    } else {
	         var aa = confirm('Do you want to update this scheme?')
	         if(aa == true)
	         {
	        	 var table = $('#datatable-editable2').DataTable();
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
	    
	    function submitform1()
	    {
	    	$('#action').val("Freeze");
	    	
	    	var totalrowcount = $('#table1 tr').length-1;
	    	var adjustamt = true;
	    	var adjustres = true;
	    	var adjustdoc = true;
	    	for(i=1; i<=totalrowcount; i++){
	    	
 				var adjustflag = $('#attribute1'+i).val();
		    	 

				if(adjustflag == "Y")
		         {
		    	
					var adjustments = $('#adjustments'+i).val();
					var adjustment_reason = $('#adjustment_reason'+i).val();
					 var adjust_doc = document.getElementById("doc_file"+i);
					
					if(adjustments == "") {
						adjustamt = false;
						
						
					}
					if(adjustment_reason == "") {
						adjustres = false;
						
						
					}
					if ('files' in adjust_doc) {
				        if (adjust_doc.files.length == 0) {
				        	adjustdoc = false;
				        }
					} 
				    else {
				        if (adjust_doc.value == "") {
				        	adjustdoc = false;
				        }
				    }
						
				}
	    	}
	    	if (adjustamt == false) {
	    		alert("Please provide adjustment amount.");
	 	 	        return false;
	 		    
	 	 	    } else 
	 			
	 	 		if (adjustres == false) {
	 	 			alert("Please provide adjustment reason.");
	 	 	        return false;
	 		    
	 	 	    }  else 
	 	 			
	 	 	 		if (adjustdoc == false) {
	 	 	 			alert("Please upload Approval document for this adjustment.");
	 	 	 	        return false;
	 	 		    
	 	 	 	    }
	 	 	 		else {
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
			var count = $('.adjustpoints').index(this);
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
				var count = $('.adjustreason').index(this);
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
				var count = $('.adjustgift').index(this);
				
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
				var count = $('.adjustcn').index(this);
				
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
		 $('.adjustpoints').keyup(function(){	
			 
		 	var sum = 0;			 
			var count = $('.adjustpoints').index(this);
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
				var count = $('.adjustreason').index(this);
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
				var count = $('.adjustgift').index(this);
				
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
				var count = $('.adjustcn').index(this);
				
//	 			 $('#sch_tot_cn_pts'+count).val("0"); 
				
//	 			 var part1_value = $('#part1_value'+count).val();  
//	 			 var part2_value = $('#part2_value'+count).val();  
//	 			 var sch_adj_pts = $('#sch_adj_pts'+count).val();  
				 
//	 			 var sum = parseInt(part1_value) + parseInt(part2_value) + parseInt(sch_adj_pts);
				 
//	 			 $('#sch_tot_cn_pts'+count).val(sum);
				 $('#attribute1'+count).val("Y");
				 
			 });
		 
		 function closeform()
		 {
//		  	window.close();
		 	window.location.href="reloadRwApr";
		 }
		 </script>
