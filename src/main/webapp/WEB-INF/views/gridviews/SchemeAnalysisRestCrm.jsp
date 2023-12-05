<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="updateoutput" method="post" id="Saveform">

<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 3em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Scheme Analysis</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href="marketing"> <i class="feather icon-home"></i> </a>
                                                    </li>                                                  
                                                    <li class="breadcrumb-item"><a href="schemeanalysis">Scheme Analysis</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Page-header end -->
	<div class="form-group">
				<div class="col-md-12" style="text-align: center;">
					<input type="button" class="btn btn-primary btn-sm" id="action4"
						name="gen_report" value="Show Report" onclick="myFunction2()"></input>
		
				</div>
			</div>

			
			<div class="card">
			<div class="card-header">
				<h5>Reward Details</h5>
				<div class="card-header-right">
					<ul class="list-unstyled card-option">
						<li><i class="feather icon-maximize full-card"></i></li>
						<li><i class="feather icon-minus minimize-card"></i></li>
						<li><i class="feather icon-trash-2 close-card"></i></li>
					</ul>
				</div>
			</div>
			<!-- <header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>
				<h2 class="panel-title">Reward Details</h2>

			</header> -->
			<!--  -->
			<div class="card-block">
				<div class="dt-responsive table-responsive">
<!-- 					<div id="source" style="overflow-x : auto;"> -->
					<table class="table table-bordered table-striped nowrap"
						id="rewardDetails" data-url="" style="overflow-x: auto;
    display: block;">
						<thead>
							<tr>
							    <th class="center" width="10%">Sr. No</th>
								<th class="center" width="10%">CUSTOMER_ID</th>
								<th class="center" width="10%">SALES_ORDER_ID</th>	
								<th class="center" width="10%">CREATION DATE</th>
								<th class="center" width="20%">CUSTOMER_COMPANY</th>														
								<th class="center" width="10%">STATUS</th>								
								<th class="center" width="20%">TOTAL_SELLS</th>
								<th class="center" width="10%">TARGET</th>
								<th class="center" width="10%">PENDING</th>
								<th class="center" width="20%">STATUS</th>
								<th class="center" width="20%">ADJUST REWARD</th>
								
							</tr>
						</thead>
						<tbody style="">
								<%
				int j = 0;
				%>
				<%
				                     int i = 0;
				                    %>
			
				<c:forEach var="viewprfinfo" items="${iftest}">
					
					<tr>
									
						<td><%=j%></td>
						<td>${viewprfinfo.CUSTOMER_ID}</td>
						<td>${viewprfinfo.SALES_ORDER_ID}</td>
						<td>${viewprfinfo.DATE}</td>
						<td>${viewprfinfo.CUSTOMER_COMPANY}</td>
						<td>${viewprfinfo.RES_LINE_STATUS}</td>
						
						<td>${viewprfinfo.SO_LINE_TOTAL}</td>
					    <td>${ifl2}</td>
					    <c:set var="bonus_pending" value="${viewprfinfo.SO_LINE_TOTAL-ifl2}"></c:set>
					    <%
					    Long bonus_pending_pro = (Long) pageContext.getAttribute("bonus_pending");
					

					%>

					<%
					if (bonus_pending_pro>=0)
					{
					%>
						<td>0</td>
					<%
					}
					
					%>
					
					<%
					if (bonus_pending_pro<0)
					{
					%>
						<td>${viewprfinfo.SO_LINE_TOTAL-ifl2}</td>
					<%
					}
					
					%>
					    
					    <td>${viewprfinfo.STATUS}</td>
					    
					
					<c:set var="bonus_name_pro" value="${viewprfinfo.STATUS}"></c:set>
					<%
					String bonus_name2_pro = (String) pageContext.getAttribute("bonus_name_pro");
					System.out.println(bonus_name2_pro);

					%>

					<%
					if (bonus_name2_pro.equals("Qualified"))
					{
					%>
						<td><input type="text" class="form-control" id="adjust" style="width: 55px;" value="N/A" readonly="readonly"/></td>
					<%
					}
					
					%>
					
					<%
					if (!bonus_name2_pro.equals("Qualified"))
					{
						%>
						<td><input type="text" class="form-control" id="adjust" style="width: 55px;" /></td>
					<%
					}
					
					%>
					  
					    
					    <%
				                      i = i+1;
				         %>
					</tr>
					<%
					j = j + 1;
					%>
				</c:forEach>
				
						</tbody>
						<tfoot>
						<tr>
				                <th class="center" width="10%">Sr. No</th>
								<th class="center" width="10%">CUSTOMER_ID</th>
								<th class="center" width="10%">SALES_ORDER_ID</th>	
								<th class="center" width="10%">CREATION DATE</th>
								<th class="center" width="20%">CUSTOMER_COMPANY</th>														
								<th class="center" width="10%">STATUS</th>								
								<th class="center" width="20%">TOTAL_SELLS</th>
								<th class="center" width="10%">TARGET</th>
								<th class="center" width="10%">PENDING</th>
								<th class="center" width="20%">STATUS</th>
								<th class="center" width="20%">ADJUST REWARD</th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>
			</div>

			
</form>
<script>

$( window ).scroll(function() {$(".table.table-bordered.table-striped.nowrap.dataTable.fixedHeader-floating").css({
	'overflow-x' : '' , 'display' : ''
});});
$(window)
.load(
		function() {
			$('.col-xs-12.col-sm-12').css({
				'overflow-x' : 'auto'
			});
		
		
$.ajax({
			//     url: '${pageContext.request.contextPath}/getschemename1',
			url : '${pageContext.request.contextPath}/getschschemename',
			success : function(data) {

				var select = $('#scheme_name');
				select.find('option').remove();
				$('<option>').val("").text("--Select--").appendTo(select);
				$.each(data, function(index, value) {
					var scheme_nm_code = value.scheme_name + '('
							+ value.scheme_code + ')';
					if (value.scheme_id == "${scheme_id}") {
						$('<option selected>').val(value.scheme_id).text(
								scheme_nm_code).appendTo(select);
					} else {
						$('<option>').val(value.scheme_id).text(scheme_nm_code)
								.appendTo(select);
					}
				});

			}
		});

		var schemeid = "${scheme_id}";
$.ajax({
			//     url: '${pageContext.request.contextPath}/getschemedepot',
			url : '${pageContext.request.contextPath}/getschemedepotdetails',
			data : ({
				schemeid : schemeid
			}),
			success : function(data) {

				var select = $('#depot_name');
				select.find('option').remove();
				$('<option>').val("").text("--Select--").appendTo(select);
				$.each(data, function(index, value) {

					//             	 if(value.depot_code == "${deptnm}"){

					// 					$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
					//             	 } else {
					//             		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
					//             	 }

					if (value.sch_depot_code == "${deptnm}") {

						$('<option selected>').val(value.sch_depot_code).text(
								value.sch_depot_name).appendTo(select);
					} else {
						$('<option>').val(value.sch_depot_code).text(
								value.sch_depot_name).appendTo(select);
					}

				});

			}
		});

		$.ajax({
			url : '${pageContext.request.contextPath}/getschopawebserviceUrl',
			data : ({
				scheme_id : schemeid
			}),
			success : function(data) {

				$('#schopawebservice').val(data);

			}
		});

		$('#scheme_name')
				.change(
						function(event) {
							var schemeid = $("select#scheme_name").val();
    $.ajax({
										//         url: '${pageContext.request.contextPath}/getschemedepot',
										url : '${pageContext.request.contextPath}/getschemedepotdetails',
										data : ({
											schemeid : schemeid
										}),
										success : function(data) {

											var select = $('#depot_name');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
											$
													.each(
															data,
															function(index,
																	value) {

																// 	            	 if(value.depot_code == "${deptnm}"){

																// 						$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
																// 	            	 } else {
																// 	            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
																// 	            	 }

																//	 	            	 if(value.sch_depot_code == "${deptnm}"){

																//	 						$('<option selected>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
																//	 	            	 } else {
																$('<option>')
																		.val(
																				value.sch_depot_code)
																		.text(
																				value.sch_depot_name)
																		.appendTo(
																				select);
																//	 	            	 }

															});

										}
									});

							$
									.ajax({
										url : '${pageContext.request.contextPath}/getschopawebserviceUrl',
										data : ({
											scheme_id : schemeid
										}),
										success : function(data) {

											$('#schopawebservice').val(data);

										}
									});

						});

	});
</script>
<script>
	function myFunction1() {

		//         	setTimeout(myFunction3, 1000);
		//         	  var depot_name = $('#depot_name').val();
		//               var scheme_id = $('#scheme_name').val();
		//               var finanalysis = "0";

		//         	$.ajax({
		// 			    url: '${pageContext.request.contextPath}/callopa',
		// 			    data:({depot_name : depot_name ,scheme_id : scheme_id, finanalysis : finanalysis}),
		// 			    success: function(data) {				        	

		// 			       		$("#loading").hide();
		// 			       		myFunction2();
		// 			    }
		// 			  });

		var schopawebservice = $('#schopawebservice').val();
		var scheme_id = $('#scheme_name').val();
		var depot_code = $('#depot_name').val();
		//             var dlr_ac_name = "";

		if (scheme_id != "") {
			if (depot_code != "") {
				//             		if(dlr_ac_name != ""){
				if (schopawebservice != null && schopawebservice != "") {
					window.location.href = "callSchOpaWebservloadoutputdata?scheme_id="
							+ scheme_id + "&depot=" + depot_code;

				} else {
					alert("No OPA Webservice url for this scheme");
				}
				//             		} else{
				//                     	alert("Please select dealer name.");
				//                     }

			} else {
				alert("Please select depot name.");
			}

		} else {
			alert("Please select scheme name.");
		}

		//	 window.location.href = "loadoutputdata?deptnm="+depot_name+"&&schnm="+scheme_name+"";
	}

	function myFunction3() {
		$("#loading").show();
	}

	function myFunction4() {
		//         	 $("#gen_report").hide(); 
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();

		window.location.href = "downloadloadoutputdata?deptnm=" + depot_name
				+ "&schnm=" + scheme_name + "";
		//$("#show_details").show();
	}
</script>

<script>
	function myFunction2() {
		//         	 $("#gen_report").hide(); 
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();

		window.location.href = "callschoparest_webservicecrm?depot=" + depot_name
				+ "&scheme_id=" + scheme_name + "&bill_to_id=";
		//$("#show_details").show();
		
		
	}
</script>


<script>
	function submitform() {
		$('#action').val("Update");
		var aa = confirm('Do you want to update this scheme?')
		if (aa == true) {
			$('#Saveform').submit();
		} else {
			return false;
		}
	}

	function submitform1() {
		$('#action').val("Freeze");
		var aa = confirm('Are you sure to freeze this scheme?')
		if (aa == true) {
			$('#Saveform').submit();
		} else {
			return false;
		}
	}
</script>

<script>
	$('.docalculation').keyup(function() {

		$('#sch_total' + count).val("0");

		var count = $('.docalculation').index(this) + 1;
		var sch_ty_tot_vol = $('#sch_ty_tot_vol' + count).val();
		var sch_adjusted = $('#sch_adjusted' + count).val();

		var sum = parseInt(sch_ty_tot_vol) + parseInt(sch_adjusted);

		$('#sch_total' + count).val(sum);
		$('#change_flag' + count).val("Y");
	});
</script>



<script>
	$(document).ready(function() {

// 		$("#loading").hide();

	});
</script>