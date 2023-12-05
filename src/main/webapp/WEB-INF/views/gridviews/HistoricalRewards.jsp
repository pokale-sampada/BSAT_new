
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<form action="updateoutput" method="post" id="Saveform">
	
						 <!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Historical Rewards</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href=""> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="#!">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="historicalrewards">Historical Rewards</a>
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
				<div class="col-md-2">
					<label class="block" for="inputSuccess">Scheme Name
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control form-control-sm "
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-2">
					<label class="block" for="inputSuccess">Distributors Name
						: </label>
				</div>
				<div class="col-md-3">
					<select class="form-control form-control-sm " name="depot_name"
						id="depot_name" required="required">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-1"></div>
		</div>

		<div class="form-group row"></div>
		<div class="form-group row">
			<div class="col-md-12" style="text-align: center;">
				<input type="button" class="btn btn-primary btn-sm" id="action4"
					name="gen_report" value="Show Report" onclick="myFunction2()"></input>
				<!-- 				<input type="button" class="btn btn-primary" id="action5" -->
				<!-- 					name="show_report" value="Download Report" onclick="myFunction4()"></input> -->
			</div>
		</div>
		</div>
		</div>
		<label>Redeemed on : ${LastRefresh}</label>
		<!-- start: page -->
		<div class="card">
		<div class="card-header">
			<h5>Scheme Analysis</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="header-footer-fix"
					class="table table-hover table-bordered nowrap">
					<thead>
						<tr>
							<th class="text-center" style="min-width: 40px;">Region</th>
							<th class="text-center" style="min-width: 50px;">State</th>
							<th class="text-center" style="min-width: 140px;">Distributors</th>
							<th class="text-center" style="min-width: 80px;">Sup Code</th>
							<th class="text-center" style="min-width: 150px;">Sup Name</th>
							<th class="text-center" style="min-width: 50px;">Terr</th>
							<th class="text-center" style="min-width: 150px;">Terr Name</th>
							<th class="text-center" style="min-width: 60px;">A/C No.</th>
							<th class="text-center" style="min-width: 60px;">Bill To</th>
							<th class="text-center" style="min-width: 80px;">Dlr Cat</th>
							<th class="text-center" style="min-width: 80px;">Cust Type</th>
							<th class="text-center" style="min-width: 120px;">A/C Name</th>
							<th class="text-center" style="min-width: 150px;">Reward Section</th>
							<th class="text-center" style="min-width: 120px;">Reward Type</th>
							<th class="text-center" style="min-width: 100px;">Product</th>
							<th class="text-center" style="min-width: 80px;">Unit</th>
							<th class="text-center" style="min-width: 120px;">Reward Date</th>
							<th class="text-center" >LY</th>
							<th class="text-center" style="min-width: 70px;">Target</th>
							<th class="text-center" >TY</th>
							<th class="text-center" style="min-width: 120px;">TGT Pending</th>
							<th class="text-center" style="min-width: 80px;">Status</th>
							<th class="text-center" style="min-width: 80px;">Add PTS</th>
							<th class="text-center" style="min-width: 150px;">Reward Desc</th>
							<th class="text-center" style="min-width: 80px;">Reward</th>
							<th class="text-center" style="min-width: 70px;">Adjustments</th>
							<th class="text-center" style="min-width: 150px;">Adjustment Reason</th>
							<th class="text-center" style="min-width: 100px;">Gift TO CN</th>
							<th class="text-center" style="min-width: 160px;">Converted CN Value</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 1;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<c:set var="reward_section_total">${info.reward_section}</c:set>
							<c:set var="reward_color">${info.reward_color}</c:set>
							<%
								String reward_section_total = (String) pageContext.getAttribute("reward_section_total");
							%>
							<tr>
								<td class="text-center" style="min-width: 50px;"
									bgcolor="<c:out value='${reward_color}'/>"><input
									type="hidden" id="opa_analysis_id<%=j%>" name="opa_analysis_id"
									style="width: 100%" value="${info.opa_analysis_id}" /> <input
									type="hidden" id="scheme_id<%=j%>" name="scheme_id"
									value="${info.scheme_id}" /> ${info.regn}</td>
								<td class="text-center" style="min-width: 150px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.state}</td>
								<td class="text-center" style="min-width: 120px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.depot}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.sup_code}</td>
								<td class="text-center" style="min-width: 200px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.sup_name}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.terr_code}</td>
								<td class="text-center" style="min-width: 200px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.terr_name}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.dlr_ac_no}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.dlr_bill_to}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.dlr_cat}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.dlr_type}</td>
								<td class="text-center" style="min-width: 380px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.dlr_name}</td>
								<td class="text-center" style="min-width: 150px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_section}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_type}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.product}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.unit}</td>
								<td class="text-center" style="min-width: 120px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_date1}</td>
								<td class="text-center" bgcolor="<c:out value='${reward_color}'/>">${info.reward_ly}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_target}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_ty}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.next_tgt_pending}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_status}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.additional}</td>
								<td class="text-center" style="min-width: 250px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_description}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.reward_total}</td>
								<td class="text-center" style="min-width: 150px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.adjustments}</td>
								<td class="text-center" style="min-width: 250px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.adjustment_reason}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.gift_to_cn_flag}</td>
								<td class="text-center" style="min-width: 100px;"
									bgcolor="<c:out value='${reward_color}'/>">${info.converted_cn_value}</td>


							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</form>
	<!-- end: page -->
<!-- </section> -->

<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<script>
				$(window).load(function(){
					$('.col-xs-12.col-sm-12').css({'overflow-x':'auto'});
			
					$.ajax({
// 					    url: '${pageContext.request.contextPath}/getschemename3',
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
// 					    url: '${pageContext.request.contextPath}/getschemedepot',
					    url: '${pageContext.request.contextPath}/getschemedepotdetails',
					   data: ({schemeid :schemeid}),
					    success: function(data) {

					        var select = $('#depot_name');
					        select.find('option').remove();
							$('<option>').val("").text("--Select--").appendTo(select);
					            $.each(data, function(index, value) {
					            	
					            	 if(value.sch_depot_code == "${deptnm}"){

					  					$('<option selected>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
					              	 } else {
					              		 $('<option>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
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

	                        	 var select = $('#depot_name');
	 					    	select.find('option').remove();
	 					    	$('<option>').val("").text("--Select--").appendTo(select);
	 					           	  $.each(data, function(index, value) {	
	 					           		  
// 	 					            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
	 					            		 
	 					            		 $('<option>').val(value.sch_depot_code).text(value.sch_depot_name).appendTo(select);
	 					    	});

	                         }
	                      });
	        });
					 
				});
				</script>
				
<script type="text/javascript">
	function myFunction3() {
		$("#loading").show();
	}

	function myFunction2() {
		var depot_name = $('#depot_name').val();
        var scheme_name = $('#scheme_name').val();

    window.location.href = "loadhistoryreward?deptnm="+depot_name+"&schnm="+scheme_name+"";

	}

</script>
