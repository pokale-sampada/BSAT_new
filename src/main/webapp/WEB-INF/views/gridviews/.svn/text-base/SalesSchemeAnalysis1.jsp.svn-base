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
					
				<div class="col-md-6">
				<label class="control-label" for="inputSuccess">Scheme Name
						: </label>
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
						required="required">
						<option>--Select--</option>
					</select>
				</div>
					
				<div class="col-md-6">
				<label class="control-label" for="inputSuccess">Transactional
						Cycle Name : </label>
					<select class="form-control input-sm mb-md" name="cycle_name"
						id="cycle_name" required="required">
						<option>--Select--</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">Q1</option>
					</select>
				</div>
					
				<!-- <div class="col-md-4">
				<label class="control-label" for="inputSuccess">Product Name:</label>
					<select class="form-control input-sm mb-md" name="product_name"
						id="product_name" required="required">
						<option>--Select--</option>
						<option value="AG">Aquaguard (AG)</option>
						<option value="EC">Euroclean (EC)</option>
						<option value="EA">EuroAir (EA)</option>
					</select>
				</div> -->
			</div>
		</div>

        <div class="form-group">
			<div class="col-md-12">
					
				<div class="col-md-4">
				<label class="control-label" for="inputSuccess">L2 Employees
						: </label>
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="l2_emp_id" id="l2_emp_id"
						required="required" onchange="loadL1()">
						<option>--Select--</option>
					</select>
				</div>
					
				<div class="col-md-4">
				<label class="control-label" for="inputSuccess">L1 Employees
						: </label>
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="l1_emp_id" id="l1_emp_id"
						required="required" onchange="loadL0()">
						<option>--Select--</option>
					</select>
				</div>
					
				<div class="col-md-4">
				<label class="control-label" for="inputSuccess">L0 Employees
						: </label>
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="l0_emp_id" id="l0_emp_id"
						required="required">
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
						<c:set var="cycle">${cycle}</c:set>
						<%
							String cycle = (String) pageContext.getAttribute("cycle");
						%>
						<%
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
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%></td>  
							<td><%
							   if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive()==0){
								   out.println("NA");
							   }else{
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_status());
								}%></td>
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
							}%>
							</td>
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
							<td>
								<%
									out.println(L2level.get(0).getL2_commission());
								%>
							</td>
							<td></td>
							<td></td>
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
							<td></td>
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
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%></td>
							<td><%
							        if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive() ==0){
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
									+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag() == 0 ){
								out.println("NA");
							}else{
							out.println(L2level.get(0).getL1level().get(j).getL1_status());
							}%></td>
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
						<%-- <tr>
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
							<td>
								<%
									out.println(L2level.get(0).getL2_commission());
								%>
							</td>
							<td></td>
							<td></td>
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
							<td></td>
						</tr> --%>
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
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%></td>
							<td><%
							        if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive()==0){
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
								%></td>
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
							<td>
								<%-- <%
									out.println(L2level.get(0).getL2_commission());
								%> --%>
							</td>
							<td></td>
							<td></td>
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
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%></td>
							<td></td>
							<td></td>

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
									out.println(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive());
								%></td>
							<td><%
							   if(L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_commission()+ L2level.get(0).getL1level().get(j).getL0level().get(k).getL0_sku_incentive() == 0){
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
								%></td>
							<td><%
							if(L2level.get(0).getL1level().get(j).getL1_commission() + L2level.get(0).getL1level().get(j).getL1_sku_incentive()
									+ L2level.get(0).getL1level().get(j).getL1_team_sales_commiss() + L2level.get(0).getL1level().get(j).getL1_productivity_of_ec_ea()
									+ L2level.get(0).getL1level().get(j).getL1_productivity_of_ag() ==0){
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
							<td>
								<%
									out.println(L2level.get(0).getL2_commission());
								%>
							</td>
							<td></td>
							<td></td>
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
							<td><% out.println(L2level.get(0).getL2_commission() + L2level.get(0).getL2_qua_commission() + L2level.get(0).getL2_oper_incentive());%></td>
							<td></td>
							<td></td>
						</tr>
						<%
							}
						%>
						
						</tbody>
				</table>
			</div>
		</section>


<%-- 		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>
				<h2 class="panel-title">Document Details</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable1"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<!-- <th class="center" width="10%">Region</th>
							<th class="center" width="20%">State</th>
							<th class="center" width="10%">Depo</th> -->


							<th class="center">Sr. No.</th>
							<th class="center">Document Type</th>
							<th class="center">Document Title</th>
							<th class="center">Reference Number</th>
							<th class="center">Upload Date</th>
							<th class="center">Download File</th>
						</tr>
					</thead>
					<tbody>

						<%
							int i = 1;
						%>
						<c:forEach var="grp_reg" items="${doc_list}" varStatus="status">

							<tr>
								<td><%=i%> <input type="hidden"
									value="${grp_reg.scheme_doc_id}" id="scheme_doc_id<%=i%>"
									name="scheme_doc_id" /></td>

								<td><input type="text" class="lovdata" id="doc_type<%=i%>"
									name="doc_type" value="${grp_reg.doc_type}"
									style="width: 100%;" readonly /></td>

								<td><input type="text" id="doc_title<%=i%>"
									name="doc_title" value="${grp_reg.doc_title}"
									style="width: 100%;" readonly /></td>

								<td><input type="text" id="doc_srl_no<%=i%>"
									name="doc_srl_no" value="${JSON.scheme_srl_no}"
									style="width: 100%;" readonly /></td>
								<td><input type="text" id="doc_upload_date<%=i%>"
									name="doc_upload_date" value="${grp_reg.doc_upload_date1}"
									style="width: 100%;" readonly /></td>

								<td><a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
										class="fa fa-download bigger-160" aria-hidden="true"></i></a></td>
							</tr>
							<%
								i = i + 1;
							%>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</section> --%>


	</form>
	<!-- end: page -->

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	$(document).ready(function() {
		$('#datatable-editable').DataTable().draw();
		$('#datatable-editable1').DataTable().draw();
	});
</script>


<script>

var l2_emp_id = $("select#l2_emp_id").val();
$.ajax({
	url: '${pageContext.request.contextPath}/getalll2',	
	data: ({sbl : l2_emp_id}),
	success: function(data) {				        	
	    	
		var select = $('#l2_emp_id');
	    select.find('option').remove();
	    $('<option>').val("").text("--Select--").appendTo(select);
	    $.each(data, function(index, value) {	
	    	var l2_details = value.empId +  '-' 
			+ value.empName ;
	    	$('<option>').val(value.empId).text(l2_details).appendTo(select);
	    });
	}
}); 


</script>
<script>
function loadL1(){
	var l1_emp_id = $("select#l1_emp_id").val();    
	var l2_emp_id = $("#l2_emp_id").val();
	
	$.ajax({
		url: '${pageContext.request.contextPath}/getalll1?l2EmpId='+l2_emp_id,	
		data: ({ sbl : l2_emp_id }),
		success: function(data) {				        	
			var select = $('#l1_emp_id');
		    select.find('option').remove();
		    $('<option>').val("").text("--Select--").appendTo(select);
		    $.each(data, function(index, value) {
		    	var l1_details = value.empId +  '-' 
				+ value.empName ;
		    	$('<option>').val(value.empId).text(l1_details).appendTo(select);
		    });
		}
	});
		
}

function loadL0(){
	var l0_emp_id = $("select#l0_emp_id").val();
	var l1_emp_id = $("#l1_emp_id").val();
	
	$.ajax({
		url: '${pageContext.request.contextPath}/getalll0?l1EmpId='+l1_emp_id,	
		data: ({ sbl : l0_emp_id }),
		success: function(data) {				        	
			var select = $('#l0_emp_id');
		    select.find('option').remove();
		    $('<option>').val("").text("--Select--").appendTo(select);
		    $.each(data, function(index, value) {	
		    	
		    	var l0_details = value.empId +  '-' 
				+ value.empName ;
		    	$('<option>').val(value.empId).text(l0_details).appendTo(select);
		    });

		}
	});

}

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
		window.location.href = "downloadeurekaReport";
	}
</script>

<script>
	function myFunction2() {
		var scheme_name = document.getElementById("scheme_name").value;
		//window.location.href = "showSalesSchAnReportSoap?scheme_name="+scheme_name;
		var cycle_name = document.getElementById("cycle_name").value;
		//var product_name = document.getElementById("product_name").value;
		var l2_emp_id = document.getElementById("l2_emp_id").value;
		var l1_emp_id = document.getElementById("l1_emp_id").value;
		var l0_emp_id = document.getElementById("l0_emp_id").value;
		window.location.href = "showEurekaSchAnalysisSoap22?cycle_name="+cycle_name+"&l2EmpId="+l2_emp_id+"&l1EmpId="+l1_emp_id+"&l0EmpId="+l0_emp_id;
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

		$("#loading").hide();

	});
</script>


