<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.omfys.bsat.model.EurekaL0OutPutModel"%>
<%@page import="com.omfys.bsat.model.EurekaEmpMaster"%>

	<!-- <header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="it"> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Scheme Analysis</span></li>
			</ol>
			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header> -->

	<form action="updateoutput" method="post" id="Saveform">
		<div class="form-group">
			<div class="col-md-12">

				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Scheme Name
						: </label> <select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>

				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">Transactional
						Cycle Name : </label> <select class="form-control input-sm mb-md"
						name="cycle_name" id="cycle_name" required="required">
						<option>--Select--</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">Q1</option>
					</select>
				</div>

				<!-- <div class="col-md-4">
					<label class="control-label" for="inputSuccess">Product
						Name:</label> <select class="form-control input-sm mb-md"
						name="product_name" id="product_name" required="required">
						<option>--Select--</option>
						<option value="AG">Aquaguard (AG)</option>
						<option value="EC">Euroclean (EC)</option>
						<option value="EA">EuroAir (EA)</option>
					</select>
				</div> -->

				<div class="col-md-4">
					<label class="control-label" for="inputSuccess">L2 EmpId:</label> <select class="form-control input-sm mb-md"
						 name="emp_id" id="emp_id" required="required">
						<option>--Select--</option>
						</select>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12" style="text-align: center;">
				<input type="button" class="btn btn-primary" id="action4"
					name="gen_report" value="Show Report" onclick="myFunction2()"></input>
				<input type="button" class="btn btn-primary" id="action5"
					name="show_report" value="Download Report" onclick="myFunction4()"></input>
			</div>
		</div>

		<hr>
		<!-- start: page -->
		<section class="panel">

			<%-- <div class="form-group">
				<div class="col-md-12">
					<div class="col-md-4">
						<label class="control-label" for="inputSuccess">Incentive for Lead</label>
						<input type="text" class="form-control" name="flat_incentive" value="${Final_Incentives.final_flat_incentive}"/>
					</div>
					<div class="col-md-4">
						<label class="control-label" for="inputSuccess">Performance Incentive</label>
						<input type="text" class="form-control" name="performance_incentive" value="${Final_Incentives.final_performance_incentive}"/>
					</div>
					<div class="col-md-4">
						<label class="control-label" for="inputSuccess">Additional Incentive</label>
						<input type="text" class="form-control" name="additional_incentive" value="${Final_Incentives.final_additional_incentive}"/>
					</div>
				</div>
			</div> --%>

			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>
				<h2 class="panel-title">Reward Details</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th class="center" width="10%">EMP ID</th>
						    <th class="center" width="30%">Emp Name</th>
						    <th class="center" width="10%">Designation</th> 
							<th class="center" width="60%">Commission (L0/L1)</th>
							<th class="center" width="30%">Sku_Incentive (L0/L1)</th>
							<th class="center" width="20%"> Team Sales Commission (L1/L2)</th>
							<th class="center" width="10%"> EC EA Productivity (L1)</th>
							<th class="center" width="50%"> AG Productivity (L1)</th>
							<th class="center" width="30%"> Quarterly Commission (L2)</th>
							<th class="center" width="30%"> Operative incentive (L2)</th>
							<th class="center" width="50%"> Final Net Value (L0/L1)</th>
							<th class="center" width="50%"> Final Collected Value (L0/L1)</th>
							<th class="center" width="30%"> Total incentive</th>
							<th class="center" width="30%"> Incentive Payout Status</th>
							<th class="center" width="30%"> Tot Incentive Payable</th>
						</tr>
					</thead>
					<tbody>
						<%-- <%
							int j = 1;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<tr>

								<td>${info.emp_id}</td>
								<td>${info.commission}</td>
								<td>${info.sku_incentive}</td>
								
								<td>${info.l0_productivity_of_ec_ea}</td>
								<td>${info.l0_productivity_of_ag}</td>
								<td>${info.l0_sku_incentive}</td>
								<td>${info.l0_commission}</td>
								
								<td>${info.l1_productivity_of_ec_ea}</td>
								<td>${info.l1_productivity_of_ag}</td>
								<td>${info.l1_sku_incentive}</td>
								<td>${info.l1_team_sales_commiss}</td>
								<td>${info.l1_commission}</td>
								
								<td>${info.l2_commission}</td>
								<td>${info.l2_qua_commission}</td>
								<td>${info.l2_oper_incentive}</td>
							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach> --%>
						<c:set var="cycle">${cycle}</c:set>
						<%
							String cycle = (String) pageContext.getAttribute("cycle");
						%>
						<%-- <c:set var="Info_grid">${Info_grid}</c:set> --%>
						<%
							//System.out.println("on JSP Page");
							ArrayList<EurekaEmpMaster> L2level = new ArrayList<EurekaEmpMaster>();
							L2level = (ArrayList<EurekaEmpMaster>) request.getAttribute("Info_grid");
							if (cycle.equals("7")) {

								List<EurekaEmpMaster> L1level = L2level.get(0).getL1level();
								for (int j = 0; j < L1level.size(); j++) {
									List<EurekaEmpMaster> L0level = L2level.get(0).getL1level().get(j).getL0level();
									for (int k = 0; k < L0level.size(); k++) {
						%>
						<tr>

							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalNetValue());
						  	  %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalCollectedValue());
								%>
							</td>
							
							<td><%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td><%
							        if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive()==0){
							        	out.println("NA");
							        }else{
							        	out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status());							        	
							        }
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
										+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
							}
									
								%>
							</td>
						</tr>
						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_sku_incentive());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_team_sales_commiss());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							</td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalNetValue());
							   %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalCollectedValue());
							  %>
							</td>
							<td><% out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
								+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
								+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							
							</td>
							<td><%
							     if(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
											+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
											+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag()==0){
							    	 out.println("NA");
							     }else{
							    	 out.println(L2level.get(0).getL1level().get(j).getL1_status());
							     }
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL1_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
										+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
										+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
							}
									
								%>
							</td>

						</tr>
						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getHrDesignation());
								%>
							</td>
							<td></td>
							<td></td>
							<td><%
									out.println(L2level.get(0).getL2_commission());
								%></td>
							<td></td>
							<td></td>
							<td>
								<%-- <%
									out.println(L2level.get(0).getL2_qua_commission());
								%> --%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL2_oper_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%>
							</td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%></td>

						</tr>
						<%
							 }
							else if (cycle.equals("9")) {

								List<EurekaEmpMaster> L1level = L2level.get(0).getL1level();
								for (int j = 0; j < L1level.size(); j++) {
									List<EurekaEmpMaster> L0level = L2level.get(0).getL1level().get(j).getL0level();
									for (int k = 0; k < L0level.size(); k++) {
						%>
						<tr>

							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalNetValue());
						  	  %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalCollectedValue());
							  %>
							</td>
							<td><%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td><%
							     if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive()==0){
							    	 out.println("NA"); 
							     }else{
							    	 out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status());
							     }
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
										+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
							}
									
								%>
							</td>
						</tr>
						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_sku_incentive());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_team_sales_commiss());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							</td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalNetValue());
							   %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalCollectedValue());
							  %>
							</td>
							<td><% out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
								+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
								+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							
							</td>
							<td><%
									out.println(L2level.get(0).getL1level().get(j).getL1_status());
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL1_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
										+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
										+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
							}
									
								%>
							</td>

						</tr>
						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getHrDesignation());
								%>
							</td>
							<td></td>
							<td></td>
							<td><%
									out.println(L2level.get(0).getL2_commission());
								%></td>
							<td></td>
							<td></td>
							<td>
								<%-- <%
									out.println(L2level.get(0).getL2_qua_commission());
								%> --%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL2_oper_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%>
							</td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%></td>

						</tr>
						<%
							 }
							else if (cycle.equals("10")) {

								List<EurekaEmpMaster> L1level = L2level.get(0).getL1level();
								for (int j = 0; j < L1level.size(); j++) {
									List<EurekaEmpMaster> L0level = L2level.get(0).getL1level().get(j).getL0level();
									for (int k = 0; k < L0level.size(); k++) {
						%>
						<%-- <tr>

							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalNetValue());
						  	  %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalCollectedValue());
								%>
							</td>
							
							<td><%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td><%
							     if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive()==0){
							    	 out.println("NA");
							     }else{
							    	 out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status());
							     }
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
										+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
							}
									
								%>
							</td>
						</tr>
 --%>						<%
							}
						%>
						<%-- <tr>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_sku_incentive());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_team_sales_commiss());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							</td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalNetValue());
							   %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalCollectedValue());
							  %>
							</td>
							<td><% out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
								+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
								+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							
							</td>
							<td><%
							    if(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
										+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
										+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag()==0){
							    	out.println("NA");
							    }else{
							    	out.println(L2level.get(0).getL1level().get(j).getL1_status());
							    }
									
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL1_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
										+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
										+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
							}
									
								%>
							</td>

						</tr>
 --%>						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getHrDesignation());
								%>
							</td>
							<td></td>
							<td></td>
							<td><%
									out.println(L2level.get(0).getL2_commission());
								%></td>
							<td></td>
							<td></td>
							<td>
								<%
									out.println(L2level.get(0).getL2_qua_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL2_oper_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%>
							</td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%></td>

						</tr>
						<%
							 }

							else if (cycle.equals("8")) {

								List<EurekaEmpMaster> L1level = L2level.get(0).getL1level();
								for (int j = 0; j < L1level.size(); j++) {
									List<EurekaEmpMaster> L0level = L2level.get(0).getL1level().get(j).getL0level();
									for (int k = 0; k < L0level.size(); k++) {
						%>
						<tr>

							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalNetValue());
						  	  %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_finalCollectedValue());
							  %>
							</td>
							<td><%
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
											+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%>
							</td>
							<td><%
							   if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
										+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive()==0){
								   out.println("NA");								   
							   }else{
								   out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status());
							   }
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission() 
										+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
							}
									
								%>
							</td>
						</tr>
						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getHrDesignation());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_commission());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_sku_incentive());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_team_sales_commiss());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							</td>
							<td></td>
							<td></td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalNetValue());
							   %>
							</td>
							<td>
							  <%
									out.println(L2level.get(0).getL1level().get(j).getL1_finalCollectedValue());
							  %>
							</td>
							<td><% out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
								+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
								+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
								%>
							
							</td>
							<td><%
							      if(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
											+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
											+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag()==0){
							    	  out.println("NA");
							      }else{
							    	  out.println(L2level.get(0).getL1level().get(j).getL1_status());
							      }
								%></td>
							<td>
							<% if(L2level.get(0).getL1level().get(j).getL1_status().equals("HOLD"))
							{
								out.println(0);
							}else
							{
								out.println(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
										+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
										+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag());
							}
									
								%>
							</td>

						</tr>
						<%
							}
						%>
						<tr>
							<td>
								<%
									out.println(L2level.get(0).getEmpId());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getEmpName());
								%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getHrDesignation());
								%>
							</td>
							<td></td>
							<td></td>
							<td><%
									out.println(L2level.get(0).getL2_commission());
								%></td>
							<td></td>
							<td></td>
							<td>
								<%-- <%
									out.println(L2level.get(0).getL2_qua_commission());
								%> --%>
							</td>
							<td>
								<%
									out.println(L2level.get(0).getL2_oper_incentive());
								%>
							</td>
							<td></td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%>
							</td>
							<td></td>
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%></td>

						</tr>
						<%
							 }
						%>
 					</tbody>
				</table>
			</div>
		</section>
		</form>
		


		<script src="resources/newportal/vendor/jquery/jquery.js"></script>

		<script>
	$(document).ready(function() {
		//$('#datatable-editable').DataTable().draw();
		//$('#datatable-editable1').DataTable().draw();
	});
</script>
	<script>

	function myFunction3() {
		$("#loading").show();
	}

	function myFunction4() {
		window.location.href = "downloadeurekaReportl2";
	}

	function myFunction2() {
		var scheme_name = document.getElementById("scheme_name").value;
		//window.location.href = "showSalesSchAnReportSoap?scheme_name="+scheme_name;
		var cycle_name = document.getElementById("cycle_name").value;
		//var product_name = document.getElementById("product_name").value;
		var emp_id = document.getElementById("emp_id").value;
		window.location.href = "showEurekaSchAnalysisSoapRest2?cycle_name="+cycle_name+"&emp_id="+emp_id;
	}	
</script>



		<script>
$(window)
.load(
		function() {
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
		
</script>

<script>


var emp_id = $("select#emp_id").val();
$.ajax({
	url: '${pageContext.request.contextPath}/getalll2',	
	data: ({sbl : emp_id}),
	success: function(data) {				        	
	    	
		var select = $('#emp_id');
	    select.find('option').remove();
	    $('<option>').val("").text("--Select--").appendTo(select);
	    $.each(data, function(index, value) {	
	    	
	    	/* var l2_details = value.empId + '('
			+ value.empName + ')'; */
	    	var l2_details =  value.empId  +  '-' 
			+ value.empName ;
			
	    	$('<option>').val(value.empId).text(l2_details).appendTo(select);
	    });

	}
}); 


</script>

	
		