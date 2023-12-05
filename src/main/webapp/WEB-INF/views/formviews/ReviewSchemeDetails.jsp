
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form action="savescheme_request" class="form-horizontal" id="Saveform"
	method="Post" enctype="multipart/form-data">
	<!--  Scheme Review Panel-->
	<div class="card">
		<div class="card-header">
			<h5>Scheme Details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Name</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.scheme_name}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Code</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.scheme_code}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Status</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.active_flag}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Type</label> <input type="text" class="form-control form-control-sm form-control-primary" name="scheme_type"
						id="scheme_type" value="${JSON.scheme_type}" readonly="readonly">
				</div>
			</div>
			<!--  Row 2 Started -->
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Business Line</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled=""
						value="${JSON.scheme_business_line}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Serial No</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_srl_no}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Scheme
						Budget</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.scheme_budget}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Version</label>
					<input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.revision}">
				</div>
			</div>
			<!--  Row 3 Started -->
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputDefault">Effective
						Date From</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.start_date1}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Effective
						Date To</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.end_date1}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Redemption
						Date</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.redemp_date1}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Fin
						Month</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.scheme_fin_month}">
				</div>
			</div>
			<!--  Row 4 Started -->
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputDefault">Overall
						Volume Growth (%)</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.volume_growth}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Overall
						Value Growth (%)</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.value_growth}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Overall
						Spread (%)</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.spraid}">
				</div>
				<div class="col-md-3">
					<label class="block" for="inputDefault">Fin
						Year</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.scheme_fin_yr}">
				</div>
			</div>
			<!--  Row 5 Started -->
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputDefault">Linked
						Scheme for Gift</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.parent_scheme_name}">
				</div>
			
			
				<div class="col-md-10">
					<label class="block" for="inputDefault"
						value="${JSON.objective}">Objective</label>
					<textarea class="form-control form-control-sm form-control-primary" rows="3" id="textareaAutosize"
						data-plugin-textarea-autosize disabled=""></textarea>
				</div>
			</div>
		</div>
	</div>
	<!--  End of Scheme Review Panel-->

	<!--  Budget details  Panel-->
	<div class="card">
		<div class="card-header">
			<h5>Budget details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Adex
						id</label> <input type="text" class="form-control form-control-sm form-control-primary" id="inputDisabled"
						disabled="" value="${JSON.provision_id}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Budget
						Available</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.budget_available}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Provision
						Required </label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.fin_analysis_flag}">
				</div>
			</div>
		</div>
	</div>
	<!--  End of Budget Panel-->
	<!--  Selected Depots-->
	<div class="card">
		<div class="card-header">
			<h5>Selected Depots</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-2">
					<label class="block" for="inputDefault">Region
						is <b>${JSON.appl_regn_code}</b>
					</label>
				</div>

				<div class="col-md-3">
					<label class="control-label">and selected
						depots are</label>
				</div>
				<div class="col-md-7">
					<select id="tags-input-multiple" class="form-control form-control-sm form-control-primary" multiple disabled=""
						style="width: 250px; height: 150px">
						<c:forEach var="sch_depos" items="${schdepos}" varStatus="status">
							<option selected value="${sch_depos.sch_depot_code}">${sch_depos.sch_depot_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<!--  End of Selected Depots-->
	<!--  Scheme Related Details-->
	<div class="card">
		<div class="card-header">
			<h5>Scheme Related Details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme
						Created By</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${lastname}  ${firstname}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme
						Created On</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.creation_date1}">
				</div>
			</div>
		</div>
	</div>
	<!--  End of Scheme Related Details-->

	<!--  Scheme Reward Details-->
	<div class="card">
		<div class="card-header">
			<h5>Scheme Reward Details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="table-responsive">
					<table
						class="table table-bordered table-striped table-condensed mb-none">
						<thead>
							<tr>
								<th style="width: 10%">SR No</th>
								<th style="width: 15%">Reward Group</th>
								<th style="width: 30%">Reward Item</th>
								<th style="width: 20%">Reward Code</th>
								<th style="width: 20%">Effective Price in Rs.</th>

							</tr>
						</thead>
						<tbody>
							<%
									int j = 1;
								%>
							<c:forEach var="grp_reg" items="${gift_list}" varStatus="status">
								<tr>
									<td><%=j%> ${grp_reg.sch_details_id}</td>
									<td>${grp_reg.gift_group}</td>
									<td>${grp_reg.attribute1}</td>
									<td>${grp_reg.sch_gift_code}</td>
									<td>${grp_reg.gift_effective_price}</td>
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
	</div>
	<!--  End of Scheme Reward Details-->
	<!--  Product Outflow Details-->
	<div class="card">
		<div class="card-header">
			<h5>Product Outflow Details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputDefault">Total
						Product Outflow of Scheme</label> <input type="text" class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_budget}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4" style="overflow: auto; white-space: nowrap; padding-left: 0; padding-right: 0;">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dynamic-table3" style="">

							<thead>
								<tr>
									<th class="center" style="width: 3%; padding: 8px 4px 8px 4px;">SR.NO</th>
									<th class="center" style="width: 6%; padding: 8px 5px 8px 5px;">PRD
										LINE TYPE</th>
									<th class="center"
										style="width: 6%; padding: 8px 15px 8px 15px;">PRODUCT</th>
								</tr>
							</thead>

							<tbody>

								<%
												int j2 = 1;
											%>
								<c:forEach var="grp_reg" items="${product_outflow_list}"
									varStatus="status">

									<tr>
										<td>
											<div id="loading<%=j2%>" style="display: none;">
												<img src="resources/login_assets/Loading1.gif" alt="BASS"
													style="width: 70%; height: 15%; margin-left: 16%; margin-top: 0%;"
													class="">
											</div>

											<div id="sch_prd_outflow_id<%=j2%>">
												<center>
													<%=j2%></center>
												<input type="hidden"
													value="${grp_reg.sch_prd_outflow_unique_id}"
													id="sch_prd_outflow_unique_id<%=j2%>"
													name="sch_prd_outflow_unique_id" />
											</div>
										</td>
										<td>
											<%--                     <input type="text" value="${grp_reg.sch_prd_line_type}" id="sch_prd_outflow_line_type<%=j2%>" name="sch_prd_outflow_line_type" class="fetchprdlinetype" style="width:100%;" readonly/> --%>

											<select id="sch_prd_outflow_line_type<%=j2%>"
											name="sch_prd_outflow_line_type"
											class="form-control form-control-sm form-control-primary"
											style="width: 100%;" required>
												<option value="">--Select--</option>
												<c:set var="prd_line_sel"
													value="${grp_reg.sch_prd_line_type}"></c:set>
									
													<option value="${grp_reg.sch_prd_line_type}" selected>${grp_reg.sch_prd_line_type}</option>
						


										</select>

										</td>
										
										
										

										<td>
											<%--                 <input type="text" value="${grp_reg.sch_prd_value}" id="sch_product_outflow_id<%=j2%>" name="sch_product_outflow_id" class="fetchprdval" style="width:100%;" readonly/> --%>

											<select id="sch_product_outflow_id<%=j2%>"
											name="sch_product_outflow_id" class="fetchprdval"
											value="${grp_reg.sch_prd_value}" style="width: 100%;"
											required>
												<option value="${grp_reg.sch_prd_value}">${grp_reg.sch_prd_value}</option>
										</select>
										</td>

									</tr>
									<%
													j2 = j2 + 1;
												%>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- End of Col-mod-3 -->
				<div class="col-md-8" style="padding-left: 0; padding-right: 0;">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dynamic-table4"
							style="display: block; overflow: auto; white-space: nowrap;"
							cellspacing="0" width="100%">

							<thead>
								<tr>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">LLY VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">LY VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT
										VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">PROJ VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">LLY VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">LY VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT
										VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">PROJ VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">SPD TGT
										VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">SPD TGT
										VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">SPD LY VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">SPD LY VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT
										SPD</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">SPD TY TGT
										VOL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">SPD TY TGT
										VAL</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">WT AVG</th>
									<th class="center"
										style="width: 5%; padding: 8px 10px 8px 10px;">PRD BDGT</th>
								</tr>
							</thead>
							<tbody>

								<%
												int j3 = 1;
											%>
								<c:forEach var="grp_reg" items="${product_outflow_list}"
									varStatus="status">

									<tr>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.lly_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_lly_vol<%=j3%>" name="sch_prd_lly_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="hidden"
											value="<fmt:formatNumber value="${grp_reg.lly_vol}" pattern="###0.00" />"
											id="sch_prd_lly_vol<%=j3%>" name="sch_prd_lly_vol"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly /> <input
											type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.lly_vol_div}" pattern="###0.00" />"
											id="sch_prd_lly_vol_div<%=j3%>" name="sch_prd_lly_vol_div"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />
										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.ly_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_ly_vol<%=j3%>" name="sch_prd_ly_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="hidden"
											value="<fmt:formatNumber value="${grp_reg.ly_vol}" pattern="###0.00" />"
											id="sch_prd_ly_vol<%=j3%>" name="sch_prd_ly_vol"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly /> <input
											type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.ly_vol_div}" pattern="###0.00" />"
											id="sch_prd_ly_vol_div<%=j3%>" name="sch_prd_ly_vol_div"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_vol_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_vol_pct<%=j3%>" name="proj_grwth_vol_pct" class="fetchgrwthvolpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.proj_grwth_vol_pct}" pattern="###0.00" />"
											id="proj_grwth_vol_pct<%=j3%>" name="proj_grwth_vol_pct"
											class="fetchgrwthvolpct" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_ty_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_ty_vol<%=j3%>" name="sch_prd_ty_vol" class="fetchprdtyvol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="hidden"
											value="<fmt:formatNumber value="${grp_reg.proj_ty_vol}" pattern="###0.00" />"
											id="sch_prd_ty_vol<%=j3%>" name="sch_prd_ty_vol"
											class="fetchprdtyvol" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly /> <input
											type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.proj_ty_vol_div}" pattern="###0.00" />"
											id="sch_prd_ty_vol_div<%=j3%>" name="sch_prd_ty_vol_div"
											class="fetchprdtyvol_div" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.lly_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_lly_val<%=j3%>" name="sch_prd_lly_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="hidden"
											value="<fmt:formatNumber value="${grp_reg.lly_val}" pattern="###0.00" />"
											id="sch_prd_lly_val<%=j3%>" name="sch_prd_lly_val"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly /> <input
											type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.lly_val_div}" pattern="###0.00" />"
											id="sch_prd_lly_val_div<%=j3%>" name="sch_prd_lly_val_div"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.ly_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_ly_val<%=j3%>" name="sch_prd_ly_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="hidden"
											value="<fmt:formatNumber value="${grp_reg.ly_val}" pattern="###0.00" />"
											id="sch_prd_ly_val<%=j3%>" name="sch_prd_ly_val"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly /> <input
											type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.ly_val_div}" pattern="###0.00" />"
											id="sch_prd_ly_val_div<%=j3%>" name="sch_prd_ly_val_div"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_val_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_val_pct<%=j3%>" name="proj_grwth_val_pct" class="fetchgrwthvolpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.proj_grwth_val_pct}" pattern="###0.00" />"
											id="proj_grwth_val_pct<%=j3%>" name="proj_grwth_val_pct"
											class="fetchgrwthvalpct" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_ty_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_ty_val<%=j3%>" name="sch_prd_ty_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="hidden"
											value="<fmt:formatNumber value="${grp_reg.proj_ty_val}" pattern="###0.00" />"
											id="sch_prd_ty_val<%=j3%>" name="sch_prd_ty_val"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly /> <input
											type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.proj_ty_val_div}" pattern="###0.00" />"
											id="sch_prd_ty_val_div<%=j3%>" name="sch_prd_ty_val_div"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_tgt_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_tgt_vol<%=j3%>" name="sch_prd_spread_tgt_vol" class="fetchspdvol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.spread_tgt_vol}" pattern="###0" />"
											id="sch_prd_spread_tgt_vol<%=j3%>"
											name="sch_prd_spread_tgt_vol" class="fetchspdvol"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_tgt_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_tgt_val<%=j3%>" name="sch_prd_spread_tgt_val" class="fetchspdval"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.spread_tgt_val}" pattern="###0" />"
											id="sch_prd_spread_tgt_val<%=j3%>"
											name="sch_prd_spread_tgt_val" class="fetchspdval"
											style="width: 100%;" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ly_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ly_vol<%=j3%>" name="sch_prd_spread_mtd_ly_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text"
											value="<fmt:formatNumber value="${grp_reg.spread_mtd_ly_vol}" pattern="###0" />"
											id="sch_prd_spread_mtd_ly_vol<%=j3%>"
											name="sch_prd_spread_mtd_ly_vol" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ly_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ly_val<%=j3%>" name="sch_prd_spread_mtd_ly_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.spread_mtd_ly_val}" pattern="###0" />"
											id="sch_prd_spread_mtd_ly_val<%=j3%>"
											name="sch_prd_spread_mtd_ly_val" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_spd_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_spd_pct<%=j3%>" name="proj_grwth_spd_pct" class="fetchgrwthpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.proj_grwth_spd_pct}" pattern="###0.00" />"
											id="proj_grwth_spd_pct<%=j3%>" name="proj_grwth_spd_pct"
											class="fetchgrwthspdpct" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ty_tgt_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ty_tgt_vol<%=j3%>" name="sch_prd_spread_mtd_ty_tgt_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.spread_mtd_ty_tgt_vol}" pattern="###0" />"
											id="sch_prd_spread_mtd_ty_tgt_vol<%=j3%>"
											name="sch_prd_spread_mtd_ty_tgt_vol" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ty_tgt_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ty_tgt_val<%=j3%>" name="sch_prd_spread_mtd_ty_tgt_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.spread_mtd_ty_tgt_val}" pattern="###0" />"
											id="sch_prd_spread_mtd_ty_tgt_val<%=j3%>"
											name="sch_prd_spread_mtd_ty_tgt_val" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.wt_avg}" groupingUsed = "false" type = "number"/>" id="sch_prd_wt_avg<%=j3%>" name="sch_prd_wt_avg" class="fetchwtavg"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.wt_avg}" pattern="###0.00" />"
											id="sch_prd_wt_avg<%=j3%>" name="sch_prd_wt_avg"
											class="fetchwtavg" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

										</td>
										<td>
											<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.total_prd_bdgt}" groupingUsed = "false" type = "number"/>" id="sch_prd_total_prd_bdgt<%=j3%>" name="sch_prd_total_prd_bdgt"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
											<input type="text" class="form-control form-control-sm form-control-primary mb-md"
											value="<fmt:formatNumber value="${grp_reg.total_prd_bdgt}" pattern="###0.00" />"
											id="sch_prd_total_prd_bdgt<%=j3%>"
											name="sch_prd_total_prd_bdgt" style="width: 100%;"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

										</td>
									</tr>
									<%
													j3 = j3 + 1;
												%>
								</c:forEach>


							</tbody>

						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  End of Product Outflow Details-->
	<!--  Document Details-->
	<div class="card">
		<div class="card-header">
			<h5>Document Details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<div class="form-group row">
				<div class="table-responsive">
					<table
						class="table table-bordered table-striped table-condensed mb-none">
						<thead>
							<tr>
								<th style="width: 10%">SR No</th>
								<th style="width: 20%">Document Type</th>
								<th style="width: 30%">Document Title</th>
								<th style="width: 10%">Version</th>
								<th style="width: 15%">Upload Date</th>
								<th style="width: 15%">Download File</th>

							</tr>
						</thead>
						<tbody>
							<%
									int i = 1;
								%>
							<c:forEach var="grp_reg" items="${doc_list}" varStatus="status">
								<tr>
									<td><%=i%> <%--                          <input type="hidden" value="${grp_reg.scheme_doc_id}" id="scheme_doc_id<%=i%>" name="scheme_doc_id" /> --%>
									</td>

									<td>${grp_reg.doc_type}</td>

									<td>${grp_reg.doc_title}</td>

									<td>${grp_reg.revision}</td>
									<td>${grp_reg.doc_upload_date1}</td>

									<td><div
											class="col-sm-12 col-md-6 col-lg-4 outer-ellipsis">
											<a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
												class="typcn typcn-download"></i></a>
										</div></td>

								</tr>
								<%
										i = i + 1;
									%>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<input type="hidden" name="scheme_id" id="scheme_id"
					value="${JSON.scheme_id}" /> <input type="button"
					class="btn btn-primary btn-sm" id="show" value="Show All Documents"
					onclick="show_all_doc()" />
			</div>
		</div>
	</div>

	<div class="wizard-actions">

		<c:set var="status" value="${JSON.active_flag}"></c:set>
		<%
															String statuschk = (String) pageContext.getAttribute("status");
															if (statuschk.equals("Ready To Launch")) {
														%>
		<center>
			<input type="button" name="" value="Launch Scheme" id="launchscheme"
				style="margin-bottom: 5%" onclick="LaunchScheme()"
				class="btn btn-primary btn-sm">
		</center>

		<%
															} else if (statuschk.equals("Review")) {
														%>

		<center>
			<input type="button" name="" value="Last Year Financial Analysis"
				style="margin-bottom: 5%" id="financialanalysis"
				onclick="performanalysis()" class="btn btn-primary btn-sm">
		</center>
		<%
															} else if (statuschk.equals("Provisioned")) {
														%>
		<center>
			<input type="button" name="" value="Modify Scheme" id="modifyscheme"
				style="margin-bottom: 5%" onclick="ModifyScheme()"
				class="btn btn-primary"> <input type="button" name=""
				value="Submit for Approval" id="approval" style="margin-bottom: 5%"
				onclick="ApprovalScheme()" class="btn btn-primary btn-sm">
		</center>

		<!-- Check Submit scheme for approval status -->

		<%
															} else if (statuschk.equals("Incomplete") || statuschk.equals("Rejected") || statuschk.equals("Cancel")) {
														%>
		<center>
			<input type="button" name="" value="Submit For Approval"
				id="submitschemeforapproval" style="margin-bottom: 5%"
				onclick="ApprovalScheme()" class="btn btn-primary btn-sm">
		</center>
		<%
															}
														%>

	</div>



</form>
<script>
function performanalysis()
{
	var a=confirm("Do you want to proceed for Finantial Analysis?");
	if(a==true)
	    {
    var sc_name=document.getElementById("scheme_name").value;

    var sc_id=document.getElementById("scheme_id").value;
    
    window.location.href="starthistfinancialanalysis?scheme_id="+sc_id+"&process_flag=F";

 // window.open("histfinancialanalysis?scheme_name="+sc_name+"&scheme_id="+sc_id,"Historical Analysis","width=800,height=800,left=200,top=200,toolbar=0,status=0");

	    }else
        {

        }



}

function ModifyScheme()
{
var a=confirm("Do you want to proceed for scheme modification in Submit Scheme Menu?");
if(a==true)
    {
    var scheme_id=document.getElementById("scheme_id").value;
window.location.href="reviewschememodify?scheme_id="+scheme_id;
    }else
        {

        }
}

function LaunchScheme()
{

    var a=confirm("Do you want to proceed to Launch Scheme?");
if(a==true)
    {
    var scheme_id=document.getElementById("scheme_id").value;
    

    window.location.href="launchschememodify?scheme_id="+scheme_id;
    
    
    }else
        {

        }
}
function ApprovalScheme()
{
	
	var scheme_budget = $('#scheme_budget').val();
	
	if(scheme_budget == 0) {
        alert('Scheme Provision cannot be 0. Please provide proper value.');
} else {

    var a=confirm("Do you want to proceed for Approval of Scheme?");
if(a==true)
    {
    var scheme_id=document.getElementById("scheme_id").value;
	window.location.href="approveschememodify?scheme_id="+scheme_id;
    }else
        {

        }
}
}

function cancelScheme()
{

    var a=confirm("Do you want to proceed?");
	if(a==true)
    {
   		 var scheme_id=document.getElementById("scheme_id").value;
		window.location.href="schemecancel?schemeid="+scheme_id;
    }else
        {

        }
}

</script>
<script>
function deletefile(x,y)
{

		var a=confirm("Do you want to proceed?");
		if(a==true)
		    {
		window.location.href="DeleteDoc?Doc_id="+x+"&scheme_id="+y;

    }else
        {

        }
}
</script>

<script>
function GenerateCode()
{
var fin=document.getElementById("scheme_fin_yr").value;
var sline=document.getElementById("scheme_business_line").value;
var srno=document.getElementById("scheme_srl_no").value;

var scode=fin+"-"+sline+"-"+srno;

document.getElementById("scheme_code").value=scode;
//alert(scode);
}
</script>


<script>
function financialanalysis()
{
var p=document.getElementById("sch_reward_eff_price").value;


    var sc_name=document.getElementById("scheme_name").value;

    var sc_id=document.getElementById("scheme_id").value;


window.open("financialanalysis1?scheme_name="+sc_name+"&scheme_id="+sc_id+"&price="+p,"Ratting","width=750,height=550,left=250,top=200,toolbar=0,status=0,");

    $("#update1").hide();
    $("#FinancialAnalysis").hide();
    $("#submit1").show();

}
</script>
<script>
function submitform1()
{
        var id=document.getElementById("scheme_id").value;
        var budget=document.getElementById("scheme_budget").value;

window.location.href="statusrequested?scheme_id="+id+"&budget="+budget;

}
</script>

<script>
    function submitform()
    {
         var aa = confirm('Do you want to update this scheme?')
         if(aa == true)
         {
             $('#Saveform').submit();
             }
         else {
                 return false;
             }
    }
    </script>

<script type="text/javascript">

     function show_all_doc()

     {
       var aa=$('#show').val();

       var s_id=document.getElementById("scheme_id").value;

        // window.location.href="show_doc";

       window.open("show_doc?scheme_id="+s_id,"Ratting","width=750,height=550,left=250,top=200,toolbar=0,status=0,");

     } 

     </script>
