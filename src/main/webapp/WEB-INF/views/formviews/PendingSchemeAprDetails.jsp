
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




<!-- start: page -->
<div class="row">
	<div class="col-md-12">
		<form action="submitSchemeApproval" class="form-horizontal"
			id="Saveform" method="Post" enctype="multipart/form-data">
			<!--  Scheme Review Panel-->
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
					<input type="hidden" name="scheme_id" id="scheme_id"
						value="${JSON.scheme_id}" />
					<div class="form-group row">
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Name</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_name}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Code</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_code}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Status</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.active_flag}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Type</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								name="scheme_type" id="scheme_type" value="${JSON.scheme_type}"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Business
								Line</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled=""
								value="${JSON.scheme_business_line}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Serial No</label>
							<input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_srl_no}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Scheme Budget</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_budget}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Version</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.revision}">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-3">
							<label class="block" for="inputDefault">Effective Date
								From</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.start_date1}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Effective Date To</label>
							<input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.end_date1}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Redemption Date</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.redemp_date1}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Fin Month</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_fin_month}">
						</div>
					</div>
					<div class="form-group row">
						<!--  Row 4 Started -->
						<div class="col-md-3">
							<label class="block" for="inputDefault">Overall Volume
								Growth (%)</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.volume_growth}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Overall Value
								Growth (%)</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.value_growth}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Overall Spread
								(%)</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.spraid}">
						</div>
						<div class="col-md-3">
							<label class="block" for="inputDefault">Fin Year</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_fin_yr}">
						</div>
					</div>
					<div class="form-group row">
						<!--  Row 5 Started -->
						<div class="col-md-3">
							<label class="block" for="inputDefault">Linked Scheme for
								Gift</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled=""
								value="${JSON.parent_scheme_name}">
						</div>
						<div class="col-md-10">
							<label class="block" for="inputDefault" value="${JSON.objective}">Objective</label>
							<textarea
								class="form-control form-control-sm form-control-primary"
								rows="3" id="textareaAutosize" data-plugin-textarea-autosize
								disabled=""></textarea>
						</div>
					</div>
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
					<div class="form-group row">
						<div class="col-md-4" hidden>
							<label class="block" for="inputDefault">Adex id</label> <input
								type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.provision_id}">
						</div>
						<div class="col-md-4">
							<label class="block" for="inputDefault">Budget Available</label>
							<input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.budget_available}">
						</div>
						<div class="col-md-4">
							<label class="block" for="inputDefault">Provision
								Required </label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.fin_analysis_flag}">
						</div>
					</div>
				</div>
			</div>
			<!--  End of Budget Panel-->
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
					<div class="form-group row">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<label class="control-label  no-padding-right">Region <i
								class="menu-icon fa red"> *</i>
							</label>
							<div>
								<select multiple style="height: 170px;" name="appl_regn_code"
									id="appl_regn_code"
									class="form-control form-control-sm form-control-primary"
									value="${JSON.appl_regn_code}" required>
								</select>
							</div>
						</div>
						<div class="col-md-5">
							<label class="block">Selected Region <i
								class="menu-icon fa red"> *</i>
							</label>
							<div>
								<select multiple class="form-control form-control-sm "
									style="height: 170px;" name="sel_regn" id="sel_regn">
								</select>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<label class="control-label  no-padding-right">Distributors
								<i class="menu-icon fa red"> *</i>
							</label>
							<div>
								<select multiple style="height: 170px;" name="depot" id="depot"
									class="form-control form-control-sm form-control-primary"
									required>

									<c:forEach var="sch_depos" items="${schdepos}"
										varStatus="status">
										<option selected value="${sch_depos.sch_depot_code}">${sch_depos.sch_depot_name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-5">
							<label class="control-label  no-padding-right">Selected
								Distributors <i class="menu-icon fa red"> *</i>
							</label>
							<div>
								<select multiple style="height: 170px;" id="sel_depo"
									name="sel_depo"
									class="form-control form-control-sm form-control-primary">
									<c:forEach var="sch_depos" items="${schdepos}"
										varStatus="status">
										<option selected value="${sch_depos.sch_depot_code}">${sch_depos.sch_depot_name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<label class="control-label  no-padding-right">Dealers <i
								class="menu-icon fa red"> *</i>
							</label>
							<div>
								<select multiple style="height: 170px;" name="level" id="level"
									class="form-control mb-md" readonly>
									<c:forEach var="levels" items="${depo1}" varStatus="status">
										<option selected value="${levels}">${levels}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-5">
							<label class="control-label  no-padding-right">Selected Dealers <i
								class="menu-icon fa red"> *</i>
							</label>
							<div>
								<select multiple style="height: 170px;" name="sel_level" id="sel_level"
									class="form-control mb-md">
									<c:forEach var="levels" items="${depo1}" varStatus="status">
										<option selected value="${levels}">${levels}</option>
									</c:forEach>
								</select>
							</div>
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
							<label class="block" for="inputDefault">Scheme Created By</label>
							<input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${lastname}  ${firstname}">
						</div>
						<div class="col-md-4">
							<label class="block" for="inputDefault">Scheme Created On</label>
							<input type="text"
								class="form-control form-control-sm form-control-primary"
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

									<c:forEach var="grp_reg" items="${gift_list}"
										varStatus="status">
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
							<label class="block" for="inputDefault">Total Product
								Outflow of Scheme</label> <input type="text"
								class="form-control form-control-sm form-control-primary"
								id="inputDisabled" disabled="" value="${JSON.scheme_budget}">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-4"
							style="overflow-x: scroll; display: inline-block; padding-left: 0; padding-right: 0;">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dynamic-table3" style="white-space: nowrap;"
									cellspacing="0" width="100%">

									<thead>
										<tr>
											<th class="center"
												style="width: 3%; padding: 8px 4px 8px 4px;">SR.NO</th>
											<th class="center"
												style="width: 6%; padding: 8px 5px 8px 5px;">PRD LINE
												TYPE</th>
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
															name="sch_prd_outflow_unique_id"
															class="form-control form-control-sm form-control-primary" />
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
												style="width: 5%; padding: 8px 10px 8px 10px;">SPD LY
												VOL</th>
											<th class="center"
												style="width: 5%; padding: 8px 10px 8px 10px;">SPD LY
												VAL</th>
											<th class="center"
												style="width: 5%; padding: 8px 10px 8px 10px;">TGT GWT
												SPD</th>
											<th class="center"
												style="width: 5%; padding: 8px 10px 8px 10px;">SPD TY
												TGT VOL</th>
											<th class="center"
												style="width: 5%; padding: 8px 10px 8px 10px;">SPD TY
												TGT VAL</th>
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
													class="form-control form-control-sm form-control-primary mb-md"
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
													class="form-control form-control-sm form-control-primary mb-md"
													value="<fmt:formatNumber value="${grp_reg.ly_vol_div}" pattern="###0.00" />"
													id="sch_prd_ly_vol_div<%=j3%>" name="sch_prd_ly_vol_div"
													style="width: 100%;" onkeypress="return isNumber(event);"
													pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

												</td>
												<td>
													<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.proj_grwth_vol_pct}" groupingUsed = "false" type = "number"/>" id="proj_grwth_vol_pct<%=j3%>" name="proj_grwth_vol_pct" class="fetchgrwthvolpct"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" required readonly/> --%>
													<input type="text"
													value="<fmt:formatNumber value="${grp_reg.proj_grwth_vol_pct}" pattern="###0.00" />"
													id="proj_grwth_vol_pct<%=j3%>" name="proj_grwth_vol_pct"
													style="width: 100%;" onkeypress="return isNumber(event);"
													class="form-control form-control-sm form-control-primary mb-md"
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
													class="form-control form-control-sm form-control-primary mb-md"
													value="<fmt:formatNumber value="${grp_reg.proj_ty_vol_div}" pattern="###0.00" />"
													id="sch_prd_ty_vol_div<%=j3%>" name="sch_prd_ty_vol_div"
													style="width: 100%;" onkeypress="return isNumber(event);"
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
													value="<fmt:formatNumber value="${grp_reg.proj_grwth_val_pct}" pattern="###0.00" />"
													id="proj_grwth_val_pct<%=j3%>" name="proj_grwth_val_pct"
													style="width: 100%;"
													class="form-control form-control-sm form-control-primary"
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
													value="<fmt:formatNumber value="${grp_reg.spread_tgt_vol}" pattern="###0" />"
													id="sch_prd_spread_tgt_vol<%=j3%>"
													class="form-control form-control-sm form-control-primary mb-md"
													name="sch_prd_spread_tgt_vol" style="width: 100%;"
													onkeypress="return isNumber(event);"
													pattern="[0-9]+([\.][0-9]+)?" step="0.01" />

												</td>
												<td>
													<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_tgt_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_tgt_val<%=j3%>" name="sch_prd_spread_tgt_val" class="fetchspdval"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
													<input type="text"
													class="form-control form-control-sm form-control-primary mb-md"
													value="<fmt:formatNumber value="${grp_reg.spread_tgt_val}" pattern="###0" />"
													id="sch_prd_spread_tgt_val<%=j3%>"
													name="sch_prd_spread_tgt_val" style="width: 100%;"
													onkeypress="return isNumber(event);"
													pattern="[0-9]+([\.][0-9]+)?" step="0.01" />

												</td>
												<td>
													<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ly_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ly_vol<%=j3%>" name="sch_prd_spread_mtd_ly_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
													<input type="text"
													class="form-control form-control-sm form-control-primary mb-md"
													value="<fmt:formatNumber value="${grp_reg.spread_mtd_ly_vol}" pattern="###0" />"
													id="sch_prd_spread_mtd_ly_vol<%=j3%>"
													name="sch_prd_spread_mtd_ly_vol" style="width: 100%;"
													onkeypress="return isNumber(event);"
													class="form-control form-control-sm form-control-primary"
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
													class="form-control form-control-sm form-control-primary mb-md"
													value="<fmt:formatNumber value="${grp_reg.proj_grwth_spd_pct}" pattern="###0.00" />"
													id="proj_grwth_spd_pct<%=j3%>" name="proj_grwth_spd_pct"
													class="fetchgrwthspdpct" style="width: 100%;"
													onkeypress="return isNumber(event);"
													pattern="[0-9]+([\.][0-9]+)?" step="0.01" required />

												</td>
												<td>
													<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ty_tgt_vol}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ty_tgt_vol<%=j3%>" name="sch_prd_spread_mtd_ty_tgt_vol"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
													<input type="text"
													class="form-control form-control-sm form-control-primary mb-md"
													value="<fmt:formatNumber value="${grp_reg.spread_mtd_ty_tgt_vol}" pattern="###0" />"
													id="sch_prd_spread_mtd_ty_tgt_vol<%=j3%>"
													name="sch_prd_spread_mtd_ty_tgt_vol" style="width: 100%;"
													onkeypress="return isNumber(event);"
													pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly />

												</td>
												<td>
													<%--                 		<input type="text" value="<fmt:formatNumber value = "${grp_reg.spread_mtd_ty_tgt_val}" groupingUsed = "false" type = "number"/>" id="sch_prd_spread_mtd_ty_tgt_val<%=j3%>" name="sch_prd_spread_mtd_ty_tgt_val"  style="width:100%;" onkeypress="return isNumber(event);" pattern="[0-9]+([\.][0-9]+)?" step="0.01" readonly/> --%>
													<input type="text"
													class="form-control form-control-sm form-control-primary mb-md"
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
													style="width: 100%;" onkeypress="return isNumber(event);"
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

											<td><a
												href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
													class="fa fa-download bigger-160" aria-hidden="true"></i></a></td>

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
							class="btn btn-primary btn-sm" id="show"
							value="Show All Documents" onclick="show_all_doc()" />
					</div>
				</div>
			</div>
			<!--  End of Document Details-->


			<div class="form-group row">
				<div class="col-md-12">

					<label class="block" for="inputDefault">Comments</label>
					<textarea class="form-control form-control-sm form-control-primary"
						rows="3" name="comment" id="comment" data-plugin-textarea-autosize
						value="${JSON.provision_comments}">${JSON.provision_comments}</textarea>

				</div>
				

			</div>
			<div class="form-group row">
				<div class="col-md-12" style="text-align: center; margin-top: 40px;">

					<input type="hidden" name="action" id="action" value="" />

					<button type="button" class="btn btn-primary btn-sm "
						value="Approve" onclick="submitform()">Approve</button>

					<button type="button" class="btn btn-primary btn-sm "
						value="Reject" onclick="submitform1()">Reject</button>

					<button type="button" class="btn btn-primary btn-sm "
						value="Info Needed" onclick="submitform2()" style="display: none;">Need
						Info</button>

					<%
							Integer profileid = (Integer) session.getAttribute("profileid");
							if (profileid == 6) {
						%>
					<button type="button" class="btn btn-success center" id="update1"
						style="margin-left: 45%" onclick="schemeCancel()">Edit
						Scheme</button>
					<button type="button" class="btn btn-success center" id="submit1"
						style="margin-left: 45%" onclick="submitcancellation()">Submit</button>
					<%
							}
						%>

				</div>
			</div>
		</form>
	</div>
</div>

<!--  End Of First Panels -->
<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<script>
		$(window).load(function() {

			$("#submit1").hide();
		});
	</script>

<script type="text/javascript">
		function show_all_doc()

		{
			var aa = $('#show').val();

			var s_id = document.getElementById("scheme_id").value;

			// window.location.href="show_doc";

			window
					.open("show_doc?scheme_id=" + s_id, "Ratting",
							"width=750,height=550,left=250,top=200,toolbar=0,status=0,");

		}

		function submitform() {
			$('#action').val("Approve");
			var aa = $('#comments').val();
			var con = confirm('Do you want to Approve this scheme?')
			if (con == true) {
				$('#Saveform').submit();
			} else {
				return false;
			}
			//	 		 if(aa != null && aa !="")
			//	 			 {
			//	 			 	$('#Saveform').submit();
			//	 			 }
			//	 		 else{
			//	 			 alert("Please enter comments.");
			//	 		 }
		}

		function submitform1() {
			$('#action').val("Reject");
			var aa = $('#comment').val();
			if (aa != null && aa != "") {

				var con = confirm('Do you want to Reject this scheme?')
				if (con == true) {
					$('#Saveform').submit();
				} else {
					return false;
				}

			} else {
				alert("Please enter comments.");
			}
		}

		function submitform2() {
			$('#action').val("Info Needed");
			var aa = $('#comments').val();
			if (aa != null && aa != "") {
				$('#Saveform').submit();
			} else {
				alert("Please enter comments.");
			}
		}
	</script>


<script type="text/javascript">
	function checkForSelectedVal() {
			//var productCodeVal = document.getElementById("sch_prd_code1").value;
			if (productCodeVal == "All" || productCodeVal == undefined) {
				document.getElementById("add3").disabled = true;
			} else {
				document.getElementById("add3").disabled = false;
			}
		} 
		$(window)
				.load(
						function() {
							
							document.getElementById("SchemeProcessingDetails").style.display = "none";
							document.getElementById("sch_dir_name").value = "BPIL_SCH_ML7_1734_1718";
							document.getElementById("fin_an_batch_file").value = "BPIL_SCH_ML7_1734_1718_FIN_AN_Batch.bat";
							document.getElementById("sch_an_batch_file").value = "BPIL_SCH_ML7_1734_1718_SCH_AN_Batch.bat";
							document.getElementById("prc_rw_batch_file").value = "BPIL_SCH_ML7_1734_1718_RW_AN_Batch.bat";
							document.getElementById("opa_whatif_url").value = "https://bergerindiaprod--tst1.custhelp.com/web-determinations/startsession/BPIL_SCH_ML7_1734_1718_WhatIf";
							document.getElementById("attribute4").value = "1";
							document.getElementById("attribute5").value = "IT Request";							

							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadfinyear',

										success : function(data) {
											var select = $('#scheme_fin_yr');
											select.find('option').remove();
											$
													.each(
															data,
															function(index,
																	value) {
																//alert(value.scheme_fin_yr);
																$('<option>')
																		.val(
																				value.fin_year)
																		.text(
																				value.fin_year)
																		.appendTo(
																				select);
															});

										}
									});

							var lovtype = "BLINE_TYPE";
							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadschemebusinessline',
										data : ({
											bline : lovtype
										}),
										success : function(data) {
											var select = $('#scheme_business_line');
											// alert(select); -->
											select.find('option').remove();
											$
													.each(
															data,
															function(index,
																	value) {
																$('<option>')
																		.val(
																				value)
																		.text(
																				value)
																		.appendTo(
																				select);
															});

										}
									});

							var lovtype = "SCHEME_TYPE";
							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadschemetype',
										data : ({
											scheme : lovtype
										}),
										success : function(data) {
											var select = $('#scheme_type');
											// alert(select); -->
											select.find('option').remove();
											$
													.each(
															data,
															function(index,
																	value) {
																if (value == "${JSON.scheme_type}") {
																	$(
																			'<option selected>')
																			.val(
																					value)
																			.text(
																					value)
																			.appendTo(
																					select);
																} else {
																	$(
																			'<option>')
																			.val(
																					value)
																			.text(
																					value)
																			.appendTo(
																					select);
																}
															});

										}
									});

			
							
							$('#rowcount3').val($('#dynamic-table3 tr').length-1);
var count = $('#rowcount3').val();
							$.ajax({
    url: '${pageContext.request.contextPath}/loadproductcode',
    success: function(data) {
    
        var select = $('#sch_prd_code'+count);
        select.find('option').remove();

	$('<option>').val("").text("--Select--").appendTo(select);
	if(count == 1) {
	$('<option>').val("All").text("All").appendTo(select);
	} else if(count != 1){
		$("#sch_prd_code1 option[value='All']").remove();
	}
           $.each(data, function(index, value) {
	$('<option>').val(value.prd_code).text(value.prd_code).appendTo(select);
        });

    }
  });

							$.ajax({
			                 	url: '${pageContext.request.contextPath}/loadDSRregion',
			                     success: function(data) {
			                     	var select = $('#appl_regn_code');
			                    	var regn_select = $('#sel_regn');
			                     	  $('<option selected>').val('C2').text('C2').appendTo(regn_select);
			                         select.find('option').remove();
			        					$('<option >').val("").text("--select--").appendTo(select);
			                   	    $.each(data, function(index, value) {
			                            if(value == "${JSON.appl_regn_code}") {
			                            	//alert("In if");
			                                $('<option selected>').val(value).text(value).appendTo(select);
			                                $('<option selected>').val(value).text(value).appendTo(regn_select);
			                                    }else{
			      									$('<option>').val(value).text(value).appendTo(select);
			                                    }

			                         });

			                     }
			                 });

			                 
			                $('#appl_regn_code').change(function(event) {
			                 	
			               	 
			               	 var region = $('#appl_regn_code').val();
			         			 var Region = ""+region+"";
			         			 
			               	 //var region = $("select#appl_regn_code").val();
			                  
			                	$.ajax({
			                    	url: '${pageContext.request.contextPath}/loaddependentDSRregion',
			                        data: ({ava_region :Region}),
			                      
			                        success: function(data) {

			                        	 var select = $('#depot');

			                        	 	
			                        		select.find('option').remove();
			                            $.each(data, function(index, value) {
			                           	 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
			                            });
			                            
			                            
			                          
			                            
			                 
			                        }
			                    });


			                });

			        
			                var arr = [];
			                var arr2 = [];
			                
			        	$('#depot').change(function(event) {
			                	
			       		 var region = $('#depot').val();
			       		 var Region = ""+region+"";   
			       		
			       		
			       		 
			       		 var e = document.getElementById("depot");
			       		 var strUser = e.options[e.selectedIndex].text;
			       		 var Region2 = ""+strUser+""; 
			       		 
			       		
			       		 
			       		 $("#depot option:selected").each(function () {
			       			   var $this = $(this);
			       			   if ($this.length) {
			       			    var selText = $this.text();
			       			    var selval = $this.val();
			       			    
			       			   
			       			    
			       			    arr.push(selText);
			       			    arr2.push(selval);
			       			    
			       			   
			       			    
			       			   }
			       			});
			       		 
			       		 
			       		 var select = $('#sel_depo');
			       		 select.find('option').remove();
			       		 
			       		 for (var i = 0; i < arr.length; i++) {
			       			 $('<option selected>').val(arr2[i]).text(arr[i]).appendTo(select);
			       		        //$('#sel_depo').val(arr);
			       		    }
			                });
			                 
			                 
			         });
		
		
		
	</script>





<script>
	$(document).ready(function(){
	
		
		$.ajax({
     	url: '${pageContext.request.contextPath}/loadDSRregion',
         success: function(data) {
         	var select = $('#appl_regn_code');
         	var regn_select = $('#sel_regn');
       	  $('<option selected>').val('C2').text('C2').appendTo(regn_select);
             select.find('option').remove();
				$('<option >').val("").text("--select--").appendTo(select);
       	    $.each(data, function(index, value) {
                if(value == "${JSON.appl_regn_code}") {
                    $('<option selected>').val(value).text(value).appendTo(select);
                    $('<option selected>').val(value).text(value).appendTo(regn_select);
                        }else{
			$('<option>').val(value).text(value).appendTo(select);
                        }

             });

         }
     });

     
    $('#appl_regn_code').change(function(event) {
     	
   	 
   	 var region = $('#appl_regn_code').val();
			 var Region = ""+region+"";
			 
   	 //var region = $("select#appl_regn_code").val();
      
    	$.ajax({
        	url: '${pageContext.request.contextPath}/loaddependentDSRregion',
            data: ({ava_region :Region}),
          
            success: function(data) {

            	 var select = $('#depot');

            	 	
            		select.find('option').remove();
                $.each(data, function(index, value) {
               	 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
                });
                
                
              
                
     
            }
        });


    });


    var arr = [];
    var arr2 = [];
    
$('#depot').change(function(event) {
    	
	 var region = $('#depot').val();
	 var Region = ""+region+"";   
	
	
	 
	 var e = document.getElementById("depot");
	 var strUser = e.options[e.selectedIndex].text;
	 var Region2 = ""+strUser+""; 
	 
	
	 
	 $("#depot option:selected").each(function () {
		   var $this = $(this);
		   if ($this.length) {
		    var selText = $this.text();
		    var selval = $this.val();
		    
		   
		    
		    arr.push(selText);
		    arr2.push(selval);
		    
		   
		    
		   }
		});
	 
	 
	 var select = $('#sel_depo');
	 select.find('option').remove();
	 
	 for (var i = 0; i < arr.length; i++) {
		 $('<option selected>').val(arr2[i]).text(arr[i]).appendTo(select);
	        //$('#sel_depo').val(arr);
	    }
    });
    
    
    
    
	});
	
	
	</script>







</section>
