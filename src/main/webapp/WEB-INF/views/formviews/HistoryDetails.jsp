
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="card">
	<div class="card-header">
		<h5>Review Scheme Details</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-bordered" method="get">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Name<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_name}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Code</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_code}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Status</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.active_flag}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Type</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary" disabled=""
						name="scheme_type" id="scheme_type"
						value="${JSON.scheme_type}" readonly="readonly">
				</div>
				<!--  Row 2 Started -->
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Business
						Line<span class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled=""
						value="${JSON.scheme_business_line}" required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Serial No<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_srl_no}"
						required>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Budget<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_budget}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Version</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.revision}">
				</div>
				<!--  Row 3 Started -->
				<div class="col-md-4">
					<label class="block" for="inputDefault">Effective Date From<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.start_date1}"
						required>
				</div>
			</div>



			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Effective Date To<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.end_date1}" required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Redemption Date<span
						class="required menu-icon fa red">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.redemp_date1}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Fin Month<span
						class="required re">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_fin_month}"
						required>
				</div>
			</div>

			<!--  Row 4 Started -->
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Overall Volume
						Growth (%)</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.volume_growth}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Overall Value
						Growth (%)</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.value_growth}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Overall Spread (%)</label>
					<input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.spraid}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Fin Year<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.scheme_fin_yr}"
						required>
				</div>
				<!--  Row 5 Started -->
				<div class="col-md-4">
					<label class="block" for="inputDefault">Linked Scheme for
						Gift</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.parent_scheme_name}">
				</div>

				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Level</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary" disabled=""
						name="scheme_level" id="scheme_level" value="${JSON.scheme_level}"
						readonly="readonly">
				</div>
			</div>

			<div class="form-group row">
				<label class="block" for="inputDefault" value="${JSON.objective}">Objective</label>
				<textarea class="form-control form-control-sm form-control-primary"
					rows="3" id="textareaAutosize" data-plugin-textarea-autosize
					disabled=""></textarea>
			</div>
		</form>
	</div>
</div>
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
		<form class="form-horizontal form-bordered" method="get">
			<div class="form-group row">
				<div class="col-md-4" hidden>
					<label class="block" for="inputDefault">Adex id</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.provision_id}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Budget Available<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.budget_available}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Provision Required
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.fin_analysis_flag}">
				</div>
			</div>
		</form>
	</div>
</div>
<div class="card">
	<div class="card-header">
		<h5>Selected Distributors</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<div class="form-group row"></div>
		<div class="form-group row">

			<label class="block" for="inputDefault">Region is ${JSON.appl_regn_code} and selected Distributors are<!-- <span
				 class="regionSpan">${JSON.appl_regn_code}</span>-->
			</label>
		<!--  	<div class="col-md-3">
				<label class="block">and selected Distributors are</label>
			</div>-->

			<div class="col-md-7">
				<select multiple style="height: 170px;" id="sel_depo"
					name="sel_depo"
					class="form-control form-control-sm form-control-primary">
					<c:forEach var="sch_depos" items="${schdepos}" varStatus="status">
						<option selected value="${sch_depos.sch_depot_code}">${sch_depos.sch_depot_name}</option>
					</c:forEach>

				</select>
			</div>
		</div>
	</div>
</div>
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
				<label class="block" for="inputDefault">Scheme Created By</label> <input
					type="text"
					class="form-control form-control-sm form-control-primary"
					id="inputDisabled" disabled="" value="${lastname}  ${firstname}">
			</div>
			<div class="col-md-4">
				<label class="block" for="inputDefault">Scheme Created On</label> <input
					type="text"
					class="form-control form-control-sm form-control-primary"
					id="inputDisabled" disabled="" value="${JSON.creation_date1}">
			</div>
		</div>
	</div>
</div>
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
							<td><%=j%>${grp_reg.sch_details_id}</td>

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
				<label class="control-label formmodifiedLable" for="inputDefault">Total
					Product Outflow of Scheme</label> <input type="text"
					class="form-control form-control-sm form-control-primary"
					id="inputDisabled" disabled="" value="${JSON.scheme_budget}">
			</div>
		</div>
		<div class="form-group row">
			<!-- <div class="col-md-12" style="padding-top: 30px"> -->
			<div class="col-md-4"
				style="overflow-x: scroll; display: inline-block;">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover"
						id="dynamic-table3" style="white-space: nowrap;" cellspacing="0"
						width="100%">

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
											<c:forEach var="prd_outflow_line_type"
												items="${prd_outflow_line_type_list}" varStatus="status">

												<c:set var="prd_outflow_line"
													value="${prd_outflow_line_type}"></c:set>

												<%
													String prd_outflow_line = (String) pageContext.getAttribute("prd_outflow_line");
															String prd_line_sel = (String) pageContext.getAttribute("prd_line_sel");
												%>


												<%
													if (prd_line_sel.equals(prd_outflow_line)) {
												%>
												<option value="${prd_outflow_line_type}" selected>${prd_outflow_line_type}</option>
												<%
													} else {
												%>
												<option value="${prd_outflow_line_type}">${prd_outflow_line_type}</option>
												<%
													}
												%>

												<%-- 							<option value="${grp_reg.sch_prd_line_type}">${grp_reg.sch_prd_line_type}</option> --%>

											</c:forEach>


									</select>

									</td>


									<td>
										<%--                 <input type="text" value="${grp_reg.sch_prd_value}" id="sch_product_outflow_id<%=j2%>" name="sch_product_outflow_id" class="fetchprdval" style="width:100%;" readonly/> --%>

										<select id="sch_product_outflow_id<%=j2%>"
										name="sch_product_outflow_id"
										class="form-control form-control-sm form-control-primary"
										value="${grp_reg.sch_prd_value}" style="width: 100%;" required>
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
			<div class="col-md-8" style="">

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
									style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT VOL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">PROJ VOL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">LLY VAL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">LY VAL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT VAL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">PROJ VAL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">SPD TGT VOL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">SPD TGT VAL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">SPD LY VOL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">SPD LY VAL</th>
								<th class="center"
									style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT SPD</th>
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
										type="text"
										class="form-control form-control-sm form-control-primary"
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
										type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.ly_vol_div}" pattern="###0.00" />"
										id="sch_prd_ly_vol_div<%=j3%>" name="sch_prd_ly_vol_div"
										style="width: 100%;" onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_vol_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_vol_pct<%=j3%>" name="proj_grwth_vol_pct" class="fetchgrwthvolpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
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
										type="text"
										class="form-control form-control-sm form-control-primary"
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
										type="text"
										class="form-control form-control-sm form-control-primary"
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
										type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.ly_val_div}" pattern="###0.00" />"
										id="sch_prd_ly_val_div<%=j3%>" name="sch_prd_ly_val_div"
										style="width: 100%;" onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_val_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_val_pct<%=j3%>" name="proj_grwth_val_pct" class="fetchgrwthvolpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
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
										type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.proj_ty_val_div}" pattern="###0.00" />"
										id="sch_prd_ty_val_div<%=j3%>" name="sch_prd_ty_val_div"
										style="width: 100%;" onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_tgt_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_tgt_vol<%=j3%>" name="sch_prd_spread_tgt_vol" class="fetchspdvol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.spread_tgt_vol}" pattern="###0" />"
										id="sch_prd_spread_tgt_vol<%=j3%>"
										name="sch_prd_spread_tgt_vol" class="fetchspdvol"
										style="width: 100%;" onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_tgt_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_tgt_val<%=j3%>" name="sch_prd_spread_tgt_val" class="fetchspdval"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.spread_tgt_val}" pattern="###0" />"
										id="sch_prd_spread_tgt_val<%=j3%>"
										name="sch_prd_spread_tgt_val" class="fetchspdval"
										style="width: 100%;" onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ly_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ly_vol<%=j3%>" name="sch_prd_spread_mtd_ly_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.spread_mtd_ly_vol}" pattern="###0" />"
										id="sch_prd_spread_mtd_ly_vol<%=j3%>"
										name="sch_prd_spread_mtd_ly_vol" style="width: 100%;"
										onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ly_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ly_val<%=j3%>" name="sch_prd_spread_mtd_ly_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.spread_mtd_ly_val}" pattern="###0" />"
										id="sch_prd_spread_mtd_ly_val<%=j3%>"
										name="sch_prd_spread_mtd_ly_val" style="width: 100%;"
										onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_spd_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_spd_pct<%=j3%>" name="proj_grwth_spd_pct" class="fetchgrwthpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.proj_grwth_spd_pct}" pattern="###0.00" />"
										id="proj_grwth_spd_pct<%=j3%>" name="proj_grwth_spd_pct"
										class="fetchgrwthspdpct" style="width: 100%;"
										onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ty_tgt_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ty_tgt_vol<%=j3%>" name="sch_prd_spread_mtd_ty_tgt_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.spread_mtd_ty_tgt_vol}" pattern="###0" />"
										id="sch_prd_spread_mtd_ty_tgt_vol<%=j3%>"
										name="sch_prd_spread_mtd_ty_tgt_vol" style="width: 100%;"
										onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ty_tgt_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ty_tgt_val<%=j3%>" name="sch_prd_spread_mtd_ty_tgt_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.spread_mtd_ty_tgt_val}" pattern="###0" />"
										id="sch_prd_spread_mtd_ty_tgt_val<%=j3%>"
										name="sch_prd_spread_mtd_ty_tgt_val" style="width: 100%;"
										onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.wt_avg}" groupingUsed = "false" type = "number"/>" id="sch_prd_wt_avg<%=j3%>" name="sch_prd_wt_avg" class="fetchwtavg"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
										value="<fmt:formatNumber value="${grp_reg.wt_avg}" pattern="###0.00" />"
										id="sch_prd_wt_avg<%=j3%>" name="sch_prd_wt_avg"
										class="fetchwtavg" style="width: 100%;"
										onkeypress="return isNumber(event);"
										pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

									</td>
									<td>
										<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.total_prd_bdgt}" groupingUsed = "false" type = "number"/>" id="sch_prd_total_prd_bdgt<%=j3%>" name="sch_prd_total_prd_bdgt"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
										<input type="text"
										class="form-control form-control-sm form-control-primary"
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
		<!--  End Of Col -->
	</div>
</div>
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
		<div class="dt-responsive table-responsive">
			<table id="simpletable"
				class="table table-striped table-bordered nowrap">
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

							<td><div class="col-sm-12 col-md-6 col-lg-4 outer-ellipsis"><a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
									class="typcn typcn-download"></i></a></div></td>

						</tr>
						<%
							i = i + 1;
						%>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="form-group row">
			<div class="col-md-5"></div>

			<div class="col-md-3">
				<input type="hidden" name="scheme_id" id="scheme_id"
					value="${JSON.scheme_id}" /> <input type="button"
					class="btn btn-primary btn-sm" id="show" value="Show All Documents"
					onclick="show_all_doc()" />
			</div>
		</div>
	</div>
</div>
<script>
	$(window).load(function() {
	
	
	

		$('.col-xs-12.col-sm-12').css({
			'overflow-x' : 'auto'
		});
		
		$('.required').css({
			'color' : 'red'
		});
		
		
	});
	
	  function show_all_doc()

     {
       var aa=$('#show').val();

       var s_id=document.getElementById("scheme_id").value;

        // window.location.href="show_doc";

       window.open("show_doc?scheme_id="+s_id,"Ratting","width=750,height=550,left=250,top=200,toolbar=0,status=0,");

     }
	
</script>