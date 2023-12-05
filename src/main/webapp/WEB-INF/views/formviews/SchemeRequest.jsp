<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">New Scheme Request</h4>

				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="marketing"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="schemerequest">New
							Scheme Request</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->

<div class="card">
	<div class="card-header">
		<h5>Create Scheme</h5>
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
			<div class="col-md-12">
				<div id="wizard">
					<section>
						<form class="wizard-form" id="example-advanced-form"
							action="savescheme_request" ModelAttribute="New_Scheme_mstr"
							method="Post" enctype="multipart/form-data">
							<input type="hidden" name="scheme_id" id="scheme_id" value="" />
							<h3>Scheme Details</h3>
							<fieldset>
								<!-- ------------ 1st Row -----------  -->
								<div class="form-group row">
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme Name<span
                                            class="required">*</span></label> <input
											type="text" name="scheme_name" id="scheme_name"
											class="form-control form-control-sm" id="inputDisabled"
											required="required">
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme Code</label> <input
											type="text" name="scheme_code" id="scheme_code"
											class="form-control form-control-sm" readonly="readonly">
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Fin Year<span
                                        class="required">*</span> </label> <select
											class="form-control form-control-sm" name="scheme_fin_yr"
											id="scheme_fin_yr" onchange="GenerateCode()">
										</select>
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme Type<span
                                            class="required">*</span></label> <select
											class="form-control form-control-sm" name="scheme_type"
											id="scheme_type">
										</select>
									</div>

								</div>
								<!-- ------------ 2nd Row ----------- -->
								<div class="form-group row">
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme Status</label>
										<input type="text" name="active_flag" id="active_flag"
											value="Incomplete" class="form-control form-control-sm"
											readonly="readonly">
									</div>

									<div class="col-md-3">
										<label class="block" for="inputDefault">Fin Month<span
                                            class="required">*</span></label><select
											class="form-control form-control-sm" name="scheme_fin_month"
											id="scheme_fin_month" onchange="GenerateCode()">

											<option value="">--Select--</option>

											<option value="Apr">Apr</option>
											<option value="May">May</option>
											<option value="Jun">Jun</option>
											<option value="Jul">Jul</option>
											<option value="Aug">Aug</option>
											<option value="Sep">Sep</option>
											<option value="Oct">Oct</option>
											<option value="Nov">Nov</option>
											<option value="Dec">Dec</option>
											<option value="Jan">Jan</option>
											<option value="Feb">Feb</option>
											<option value="Mar">Mar</option>


										</select>
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Linked Scheme
											for Gift</label> <select class="form-control form-control-sm"
											name="parent_scheme_code" id="parent_scheme_code">
											<option value="">--Select--</option>

										</select>
									</div>

									<div class="col-md-3">
										<label class="block" for="inputDefault">Approver level<span
                                         class="required">*</span></label>
										<select class="form-control form-control-sm"
											name="scheme_level" id="scheme_level">

											<option value="">--Select--</option>

										</select>
									</div>
								</div>
								<!-- ------------ 3rd Row -----------  -->
								<div class="form-group row">
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme Serial
											No. </label> <input type="text" name="scheme_srl_no"
											id="scheme_srl_no" class="form-control form-control-sm"
											readonly="readonly">
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme Budget
										</label> <input type="text" name="scheme_budget" id="scheme_budget"
											value="0" pattern="[0-9]+([\.,][0-9]+)?" step="0.01"
											class="form-control form-control-sm" readonly="readonly">
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Version</label> <input
											type="text" class="form-control form-control-sm"
											name="revision" id="revision" value="1" pattern="[0-9]{1,15}"
											readonly="readonly">
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Scheme
											Business Line</label> <input type="hidden" value=""
											name="pmg_user_id" id="pmg_user_id"></input> <select
											class="form-control form-control-sm"
											id="scheme_business_line" onchange="GenerateCode()"
											name="scheme_business_line" readonly="readonly" value=""></select>
									</div>
								</div>
								<div class="form-group row">
									<!-- ------------ Fourth Row -----------  -->
									<div class="col-md-3">
										<label class="block" for="inputDefault"> Effective Date From
										<span class="required">*</span></label>
										<div class="input-group" id="datePicker1">

											<input type="date" id="start_date"
												onblur="changedateformat1(),checkstart()" name="start_date"
												placeholder="Start Date"
												class="form-control form-control-sm ">
										</div>
									</div>

									<div class="col-md-3">
										<label class="block" for="inputDefault"> Effective
									Date To<span class="required">*</span>	</label>
										<div class="input-group" id="datePicker">

											<input type="date" id="end_date" placeholder="End Date"
												name="end_date" onblur="changedateformat2(),checkattend()"
												class="form-control form-control-sm ">
										</div>
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault"> Redemption
											Date</label>
										<div class="input-group" id="datePicker2">
											<input type="text" id="redemption_date"
												placeholder="Redemption Date" name="redemption_date"
												class="form-control form-control-sm" readonly="readonly">
										</div>
									</div>
									<input type ="hidden" name="start_datedup" id="start_datedup" />
									<input type ="hidden" name="end_datedup" id="end_datedup" />
									
								</div>
							</fieldset>
							<h3>Distributor Selection</h3>
							<fieldset>
								<div class="form-group row">
									<!-- <div class="col-md-1"></div> -->
									<div class="col-md-3" hidden>
										<label class="block" for="inputDefault" hidden> Adex
											id</label> <input type="text" class="form-control form-control-sm"
											name="provision_id" id="provision_id"
											onkeypress="return isNumber(event);" pattern="[0-9]{1,15}"
											value="1" required="required" hidden>
									</div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Budget
											Available</label> <input type="text"
											class="form-control form-control-sm" name="budget_available"
											id="budget_available" onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.,][0-9]+)?" step="0.01"
											required="required">
									</div>
									<div class="col-md-1"></div>
									<div class="col-md-3">
										<label class="block" for="inputDefault">Provision
											Required </label> <select class="form-control form-control-sm"
											id="fin_analysis_flag1" name="fin_analysis_flag1" value="">
											<option value="N">N</option>
											<option value="Y">Y</option>
										</select> <input type="text" name="fin_analysis_flag"
											id="fin_analysis_flag" value="N"
											class="form-control form-control-sm" style="font-size: 16px"
											readonly hidden /> <input type="hidden" name="total_sch_vol"
											id="total_sch_vol" value="0" class="form-control"
											style="font-size: 16px" readonly /> <input type="hidden"
											name="total_sch_val" id="total_sch_val" value="0"
											class="form-control" style="font-size: 16px" readonly /> <input
											type="hidden" name="total_sch_qlfd_dlrs"
											id="total_sch_qlfd_dlrs" value="0" class="form-control"
											style="font-size: 16px" readonly /> <input type="hidden"
											name="sch_actual_budget" id="sch_actual_budget" value="0"
											class="form-control" style="font-size: 16px" readonly /> <input
											type="hidden" name="sch_reward_eff_price"
											id="sch_reward_eff_price" value="0" class="form-control"
											style="font-size: 16px" readonly /> <input type="hidden"
											name="reference_sch_id" id="reference_sch_id" value="0"
											class="form-control" style="font-size: 16px" readonly /> <input
											type="hidden" name="confidence_pct" id="confidence_pct"
											value="0" class="form-control" style="font-size: 16px"
											readonly /> <input type="hidden" name="outflow" id="outflow"
											value="0" class="form-control" style="font-size: 16px"
											readonly>
									</div>

								</div>
								<div class="form-group row">
								<div class="col-md-1">
										</div>
									<div class="col-md-5">
										<label class="block">Region <span class="required">*</span>
										</label>
										<div>

											<select multiple class="form-control form-control-sm "
												style="height: 170px;" name="appl_regn_code"
												id="appl_regn_code" required>
											</select>
										</div>
									</div>
									<div class="col-md-5">
										<label class="block">Selected Region <span class="required">*</span>
										</label>
										<div>

											<select multiple class="form-control form-control-sm "
												style="height: 170px;" name="sel_regn"
												id="sel_regn" required>
											</select>
										</div>
									</div>
									</div>
										<div class="form-group row">
								<div class="col-md-1">
										</div>
									<div class="col-md-5">
										<label class="block">Distributor <span class="required">*</span>
										</label>
										<div>
											<select multiple style="height: 170px;" name="depot"
												id="depot" class="form-control form-control-sm " required>
											</select>
										</div>
									</div>
									<div class="col-md-5">
										<label class="block">Selected Distributors <span class="required">*</span>
										</label>
										<div>
											<select multiple style="height: 170px;" id="sel_depo"
												name="sel_depo" class="form-control form-control-sm ">
											</select>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-1">
										</div>
									<div class="col-md-5">
											<label class="control-label  no-padding-right">Dealers
												<span class="required">*</span>
											</label>
											<div>
												<select multiple style="height: 170px;" name="level"
													id="level" class="form-control mb-md">
												</select>
											</div>
									</div>
									<div class="col-md-5">
											<label class="control-label  no-padding-right">Selected Dealers
												<span class="required">*</span>
											</label>
											<div>
												<select multiple style="height: 170px;" name="sel_level"
													id="sel_level" class="form-control mb-md">
												</select>
											</div>
									</div>
									
								</div>
							</fieldset>
							<h3>Budget Details</h3>
							<fieldset>
								<div class="form-group row">
									<label class="control-label"><b>Scheme Related
											Details</b><span class="required">*</span> </label>
								</div>
								<div class="form-group row">
									<div class="col-md-3">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Scheme Created By</label> <input
											type="text" name="created_by" id="created_by"
											value="${lastname}  ${firstname}"
											class="form-control form-control-sm" id="inputDisabled">
									</div>
									<div class="col-md-3">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Scheme Created On</label> <input
											type="text" name="created_on" id="created_on"
											class="form-control form-control-sm" id="inputDisabled">
									</div>
									<div class="col-md-1"></div>
									<div class="col-md-5">
										<label class="block" for="w4-first-name">Customer club
											class</label>
										<div class="form-radio">

											<div class="radio radio-inline">
												<label> <input type="radio" name="cust_club_class"
													value="XP"> <i class="helper"></i>Registered
												</label>
											</div>
											<div class="radio radio-inline">
												<label> <input type="radio" name="cust_club_class"
													value="Non XP"> <i class="helper"></i>Non
													Registered
												</label>
											</div>
											<div class="radio radio-inline">
												<label> <input type="radio" name="cust_club_class"
													checked="checked" value=""> <i class="helper"></i>All
												</label>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<label class="control-label"><b>Customer Type </b><span
										class="required">*</span> </label>
								</div>
								<div class="form-group row">
									<div class="col-md-4">
									<label class="block">Select Customer Type
										</label>
										<div>
										<select multiple class="form-control form-control-sm "
											style="height: 170px;" name="cust_type" id="cust_type"
											required>
											<option value="select">--select--</option>
											<option value="All">All</option>
											<option value="15">Prolinks-Industrial</option>
											<option value="3">Ultratech Dealer(3)</option>
											<option value="4">Prolinks Dealer(4)</option>
											<option value="5">Dealer(5)</option>
											<option value="54">Retail Special Dealer</option>
											<option value="55">Retail Site Operations</option>
											<option value="56">Non Paint Dealer-CC</option>
											<option value="57">PXT Dealer(57)</option>
											<option value="58">Distributor-Retail</option>
											<option value="53">Wholesaler(53)</option>
											<option value="6">Contractor(6)</option>
											<option value="65">Retail Projects Strong</option>
											<option value="7">Alternate Distribution(7)</option>
											<option value="1001">Sales</option>
											<option value="66">Prolinks Special Dealer(66)</option>
										</select></div>
									</div>
									<div class="col-md-4">
										<label class="block">Selected Customer Type <i
											class="menu-icon fa red"> *</i>
										</label>
										<div>
											<select multiple style="height: 170px;" id="cust_type_s"
												name="cust_type_s" class="form-control form-control-sm ">
											</select>
										</div>
									</div>
								</div>
								<div class="border-checkbox-section" hidden>
									<div class="form-group row">
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													name="cust_type" value="15" id=""> <label
													class="border-checkbox-label" for="checkbox0">Prolinks-Industrial</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="3" checked="checked"> <label
													class="border-checkbox-label" for="checkbox1">Ultratech
													Dealer(3)</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="4"> <label
													class="border-checkbox-label" for="checkbox2">Prolinks
													Dealer(4)</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="5"> <label
													class="border-checkbox-label" for="checkbox3">Dealer(5)</label>
											</div>
										</div>
									</div>
								</div>
								<div class="border-checkbox-section" hidden>
									<div class="form-group row">
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													name="cust_type" value="54" id="" checked="checked">
												<label class="border-checkbox-label" for="checkbox0">Retail
													Special Dealer</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="55" checked="checked"> <label
													class="border-checkbox-label" for="checkbox1">Retail
													Site Operations</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="56"> <label
													class="border-checkbox-label" for="checkbox2">Non
													Paint Dealer-CC</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="57"> <label
													class="border-checkbox-label" for="checkbox3">PXT
													Dealer(57)</label>
											</div>
										</div>
									</div>
								</div>
								<div class="border-checkbox-section" hidden>
									<div class="form-group row">
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													name="cust_type" value="58" id="checkbox0"> <label
													class="border-checkbox-label" for="checkbox0">Distributor-Retail</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													id="checkbox1" name="cust_type" value="53"
													checked="checked"> <label
													class="border-checkbox-label" for="checkbox1">Wholesaler(53)</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													id="checkbox2" name="cust_type" value="6"> <label
													class="border-checkbox-label" for="checkbox2">Contractor(6)</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													id="checkbox3" name="cust_type" value="65"
													checked="checked"> <label
													class="border-checkbox-label" for="checkbox3">Retail
													Projects Strong</label>
											</div>
										</div>
									</div>
								</div>
								<div class="border-checkbox-section" hidden>
									<div class="form-group row">
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="7" checked="checked"> <label
													class="border-checkbox-label" for="checkbox1">Alternate
													Distribution(7)</label>
											</div>
										</div>
										<div class="col-md-3">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox" id=""
													name="cust_type" value="1001"> <label
													class="border-checkbox-label" for="checkbox2">Sales</label>
											</div>
										</div>
										<div class="col-md-4">
											<div
												class="border-checkbox-group border-checkbox-group-primary">
												<input class="border-checkbox" type="checkbox"
													name="cust_type" value="66" id=""><label
													class="border-checkbox-label" for="checkbox0">Prolinks
													Special Dealer(66)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group row">
									<label class="control-label"><b>Product Details </b><span
										class="">*</span> </label>
								</div>
								<div class="form-group row">

									<div class="col-md-4">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Overall Volume Growth (%)</label> <input
											type="text" class="form-control form-control-sm"
											name="volume_growth" id="volume_growth" value="0"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.][0-9]+)?" step="0.01">
									</div>
									<div class="col-md-4">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Overall Value Growth (%)</label> <input
											type="text" class="form-control form-control-sm"
											name="value_growth" id="value_growth" value="0"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.,][0-9]+)?" step="0.01">
									</div>
									<div class="col-md-4">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Overall Spread (%)</label> <input
											type="text" class="form-control form-control-sm"
											name="spraid" id="spraid" value="0"
											onkeypress="return isNumber(event);"
											pattern="[0-9]+([\.,][0-9]+)?" step="0.01">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-12">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Objective</label>
										<textarea class="form-control form-control-sm"
											name="objective" id="objective" onblur="validateobjective()"
											rows="4" cols="3"></textarea>
									</div>
								</div>
								<div class="form-group row">
									<label class="block"><b>Product Outflow Details </b><span
										class="">*</span> </label>
								</div>
								<div class="form-group row">
									<div class="col-md-4">
										<label class="control-label formmodifiedLable"
											for="inputDefault">Total Product Outflow of Scheme</label> <input
											type="text" name="total_prd_outflow"
											class="form-control form-control-sm" id="total_prd_outflow"
											value="0" readonly="readonly">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-6">
										<div class="table-responsive">

											<input type="hidden" id="rowcount3" name="rowcount3" value="">

											<table
												class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column"
												id="dynamic-table3">
												<thead>
													<tr>
														<th style="width: 3%; padding: 8px 4px 8px 4px;">SR.NO</th>
														<th style="width: 11%; padding: 8px 5px 8px 5px;">PRD
															LINE TYPE</th>
														<th style="width: 11%; padding: 8px 15px 8px 15px;">PRODUCT</th>

													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
									</div>
									<div class="col-md-6">

										<div class="table-responsive" style="overflow-x: auto;">
											<table id="dynamic-table4"
												class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column">
												<thead>
													<tr>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">LLY
															VOL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">LY
															VOL&nbsp&nbsp</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">TGT
															GWT VOL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">PROJ
															VOL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">LLY
															VAL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">LY
															VAL&nbsp&nbsp</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">TGT
															GWT VAL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">PROJ
															VAL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">SPD
															TGT VOL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">SPD
															TGT VAL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">SPD
															LY VOL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">SPD
															LY VAL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">TGT
															GWT SPD</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">SPD
															TY TGT VOL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">SPD
															TY TGT VAL</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">WT
															AVG</th>
														<th style="width: 11%; padding: 8px 10px 8px 10px;">PRD
															BDGT</th>
													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="form-group row">

									<!-- <div class="col-md-3"> -->
									<input type="button" class="btn btn-primary btn-sm"
										value="Add Row" onclick="AddRow2()">
									<!-- </div> -->


									<input type="button" class="btn btn-primary btn-sm"
										value="Delete Row" onclick="delRow2()">


								</div>
							</fieldset>
							<h3>Scheme Related Details</h3>
							<fieldset>
								<div class="form-group row">
									<div class="col-md-6">

										<label>Upload Scheme Document </label> <input type="file"
											name="doc_file" id="id-input-file-3"
											onsubmit="return validation(this)" class="form-control"
											multiple="">

									</div>
									<div class="col-md-6">

										<label>Upload Other Document </label> <input type="file"
											name="doc_file1" id="id-input-file-4"
											onsubmit="return validation(this)" class="form-control"
											multiple="">

									</div>

								</div>
								<div class="form-group row">
									<div class="col-md-6">

										<label>Scheme Document Comment </label>
										<textarea name="scheme_document_comment"
											id="scheme_document_comment" rows="6" cols="3"
											onblur="validateobjective()" class="form-control" multiple=""></textarea>

									</div>
									<div class="col-md-6">

										<label>Other Document Comment </label>
										<textarea name="other_document_comment"
											id="other_document_comment" rows="6" cols="3"
											onblur="validateobjective()" class="form-control" multiple=""></textarea>

									</div>
								</div>
								<div class="form-group row">
									<div class="table-responsive">

										<input type="hidden" id="rowcount1" name="rowcount1" value="">

										<table
											class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column"
											id="dynamic-table1">
											<thead>
												<tr>
													<th>Sr. No.</th>
													<th>Reward Group</th>
													<th>Reward Item</th>
													<th>Reward Code</th>
													<th>Effective Price in Rs.</th>
												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>

										<div class="form-group row">
											<input type="button"
												class="btn btn-primary btn-sm text-center" value="Add Row"
												onclick="AddRow()"> <input type="button"
												class="btn btn-primary btn-sm text-center"
												value="Delete Row" onclick="delRow()">

										</div>

										<div class="wizard-actions">
											<input type="button" name="Financial Analysis"
												value="Primary Financial Analysis" id="FinancialAnalysis"
												class="mb-xs mt-xs mr-xs btn btn-primary"
												onclick="financialanalysis()" style="display: none;">
											<center>
												<button type="submit" class="btn btn-primary btn-sm"
													id="save" >Save</button>
											</center>
											<!--                 onclick="return confirm('Are you sure to create this scheme?')" -->
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</section>
				</div>
			</div>
		</div>
	</div>


</div>

<script type="text/javascript">
function checkdate()
{
	 var startdate=document.getElementById("start_date").value;

		
		var mm = startdate.substring(5,7);
		var dd = startdate.substring(8,10);
		var yy = startdate.substring(0,4);
	    var startdate2 = dd+"-"+mm+"-"+yy;

	    
	    document.getElementById("start_datedup").value=startdate2;
		 var enddate=document.getElementById("end_date").value;
			
			var mm1 = enddate.substring(5,7);
			var dd1 = enddate.substring(8,10);
			var yy1 = enddate.substring(0,4);
		    var enddate2 = dd1+"-"+mm1+"-"+yy1;
		 document.getElementById("end_datedup").value=enddate2;  
		 
		 
		 
		
		var a= document.getElementById("end_datedup").value;
		var b= document.getElementById("start_datedup").value;
		
		   console.log(a);
		   console.log(b);
	}
</script>
<script>

$(window).load(function() {

	$('.required').css({
	'color' : 'red'
	});

	});
	
function loadLevel()
{
	
var level = ["L0 Level","L1 Level","L2 Level"];
var select = $('#level');

	
	select.find('option').remove();



for( var i = 0; i<level.length; i++)
	
	{
	 $('<option>').val(level[i]).text(level[i]).appendTo(select);
	}

}

function delRow2() {
	
	$('#rowcount3').val($('#dynamic-table3 tr').length-1);
	var count = $('#rowcount3').val();
	
	
	if(count > 0)
		{ 		
			 document.getElementById("dynamic-table3").deleteRow(count);
			 document.getElementById("dynamic-table4").deleteRow(count);
	 			
			 
		}
	prdoutflowTotal();
}


/* <select class="form-control mb-md" name="scheme_name"
	id="scheme_name" required>
</select> */


function AddRow2()
{

	
	$('#dynamic-table3 tr').last().after('<tr>'
			+'<td ><center>'
			+'<div id="loading'+$('#dynamic-table3 tr').length+'">'
			+'<img src="../files/assets/images/Loading1.gif" alt="BASS" style="width:80%;height:20%;margin-left: 16%;margin-top: 0%;" class="">'
			+'</div>'
			+'<div id="sch_prd_outflow_id'+$('#dynamic-table3 tr').length+'">'
	        +($('#dynamic-table3 tr').length)+'<input type="hidden" id="sch_prd_outflow_unique_id'+$('#dynamic-table3 tr').length+'" name="sch_prd_outflow_unique_id"/>'
	        +'</div>'
	        +'</center></td>'
	        +'<td ><select class="form-control form-control-sm " name="sch_prd_outflow_line_type" id="sch_prd_outflow_line_type'+$('#dynamic-table3 tr').length+'" class="col-xs-12 col-sm-4" required><option value="">--Select--</option></select></td>'
	        +'<td ><select class="form-control form-control-sm " name="sch_product_outflow_id" id="sch_product_outflow_id'+$('#dynamic-table3 tr').length+'" class="col-xs-12 col-sm-4" required><option value="">--Select--</option></select></td>'
	        +'</tr>'
	        );
	        
	$('#dynamic-table4 tr').last().after('<tr>'
			+'<td ><input type="hidden" id="sch_prd_lly_vol'+$('#dynamic-table4 tr').length+'" name="sch_prd_lly_vol" class="col-xs-12 col-sm-4" value="0" readonly/>'
			+'<input type="text" class="form-control form-control-sm" id="sch_prd_lly_vol_div'+$('#dynamic-table4 tr').length+'" name="sch_prd_lly_vol_div" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
			+'<td ><input type="hidden" id="sch_prd_ly_vol'+$('#dynamic-table4 tr').length+'" name="sch_prd_ly_vol" class="col-xs-12 col-sm-4" value="0" readonly/>'
			+'<input type="text" class="form-control form-control-sm" id="sch_prd_ly_vol_div'+$('#dynamic-table4 tr').length+'" name="sch_prd_ly_vol_div" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
			+'<td ><input type="text" class="form-control form-control-sm" style="width:100%;" id="proj_grwth_vol_pct'+$('#dynamic-table4 tr').length+'" value="0" name="proj_grwth_vol_pct" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required readonly/></td>'		
			+'<td ><input type="hidden" id="sch_prd_ty_vol'+$('#dynamic-table4 tr').length+'" name="sch_prd_ty_vol" class="col-xs-12 col-sm-4" value="0" readonly required/>'
			+'<input type="text" class="form-control form-control-sm" id="sch_prd_ty_vol_div'+$('#dynamic-table4 tr').length+'" name="sch_prd_ty_vol_div" class="col-xs-12 col-sm-4" value="0" readonly required/></td>'
			+'<td ><input type="hidden" id="sch_prd_lly_val'+$('#dynamic-table4 tr').length+'" name="sch_prd_lly_val" class="col-xs-12 col-sm-4" value="0" readonly/>'
			+'<input type="text" class="form-control form-control-sm" id="sch_prd_lly_val_div'+$('#dynamic-table4 tr').length+'" name="sch_prd_lly_val_div" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'<td ><input type="hidden" id="sch_prd_ly_val'+$('#dynamic-table4 tr').length+'" name="sch_prd_ly_val" class="col-xs-12 col-sm-4" value="0" readonly/>'
	        +'<input type="text" class="form-control form-control-sm" id="sch_prd_ly_val_div'+$('#dynamic-table4 tr').length+'" name="sch_prd_ly_val_div" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" class= "" style="width:100%;" id="proj_grwth_val_pct'+$('#dynamic-table4 tr').length+'" value="0" name="proj_grwth_val_pct" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required readonly/></td>'
	        +'<td ><input type="hidden" id="sch_prd_ty_val'+$('#dynamic-table4 tr').length+'" name="sch_prd_ty_val" class="col-xs-12 col-sm-4" value="0" readonly required/>'
	        +'<input type="text" class="form-control form-control-sm" id="sch_prd_ty_val_div'+$('#dynamic-table4 tr').length+'" name="sch_prd_ty_val_div" class="col-xs-12 col-sm-4" value="0" readonly required/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" style="width:100%;" id="sch_prd_spread_tgt_vol'+$('#dynamic-table4 tr').length+'" name="sch_prd_spread_tgt_vol" value="0" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" style="width:100%;" id="sch_prd_spread_tgt_val'+$('#dynamic-table4 tr').length+'" name="sch_prd_spread_tgt_val" value="0" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" id="sch_prd_spread_mtd_ly_vol'+$('#dynamic-table4 tr').length+'" name="sch_prd_spread_mtd_ly_vol" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" id="sch_prd_spread_mtd_ly_val'+$('#dynamic-table4 tr').length+'" name="sch_prd_spread_mtd_ly_val" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm"  style="width:100%;" id="proj_grwth_spd_pct'+$('#dynamic-table4 tr').length+'" value="0" name="proj_grwth_spd_pct" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" id="sch_prd_spread_mtd_ty_tgt_vol'+$('#dynamic-table4 tr').length+'" name="sch_prd_spread_mtd_ty_tgt_vol" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" id="sch_prd_spread_mtd_ty_tgt_val'+$('#dynamic-table4 tr').length+'" name="sch_prd_spread_mtd_ty_tgt_val" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm"  style="width:100%;" id="sch_prd_wt_avg'+$('#dynamic-table4 tr').length+'" value="0" name="sch_prd_wt_avg" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required readonly/></td>'
	        +'<td ><input type="text" class="form-control form-control-sm" id="sch_prd_total_prd_bdgt'+$('#dynamic-table4 tr').length+'" name="sch_prd_total_prd_bdgt" class="col-xs-12 col-sm-4" value="0" readonly/></td>'
	        +'</tr>'
	        );

$('#rowcount3').val($('#dynamic-table3 tr').length-1);
var count = $('#rowcount3').val();

$('#loading'+count).hide();

var prd_line_type = "PRD_OUTFLOW_LINE_TYPE";
$.ajax({
        url: '${pageContext.request.contextPath}/loadschemetype',
        data: ({scheme : prd_line_type}),
        success: function(data) {
           var select = $('#sch_prd_outflow_line_type'+count);
           select.find('option').remove();
           $('<option>').val("").text("--Select--").appendTo(select);
              $.each(data, function(index, value) {
           	
           			$('<option>').val(value).text(value).appendTo(select);

           	
           });

        }
      });


$('#sch_prd_outflow_line_type'+count).change(function(){
    var datavalue =$('#sch_prd_outflow_line_type'+count).val();
    
    if(datavalue == "All Product") {
    	
    	
        var select = $('#sch_product_outflow_id'+count);
        select.find('option').remove();

        $('<option>').val("").text("--Select--").appendTo(select);
		$('<option>').val("All").text("All Product").appendTo(select);


	} else
    if(datavalue == "Product Category") {
    	
    	$.ajax({
//             url: '${pageContext.request.contextPath}/loadproductcat',
            url: '${pageContext.request.contextPath}/loadqmisproductgrp',
            success: function(data) {

                var select = $('#sch_product_outflow_id'+count);
                select.find('option').remove();

    		$('<option>').val("").text("--Select--").appendTo(select);
                   $.each(data, function(index, value) {
    		$('<option>').val(value.prd_cat).text(value.prd_cat).appendTo(select);
                });

            }
          });
    
    	
    } else if (datavalue == "Product Code") {
    $.ajax({
        url: '${pageContext.request.contextPath}/loadproductcode',
        success: function(data) {

            var select = $('#sch_product_outflow_id'+count);
            select.find('option').remove();

		$('<option>').val("").text("--Select--").appendTo(select);
               $.each(data, function(index, value) {
		$('<option>').val(value.prd_code).text(value.prd_code).appendTo(select);
            });

        }
      });
    } else  {
    	var select = $('#sch_product_outflow_id'+count);
        select.find('option').remove();
        $('<option>').val("").text("--Select--").appendTo(select);
    }
    
    var sch_prd_lly_vol = document.getElementById("sch_prd_lly_vol"+count);
    sch_prd_lly_vol.value = "0";
    var sch_prd_lly_vol_div = document.getElementById("sch_prd_lly_vol_div"+count);
    sch_prd_lly_vol_div.value = "0";

    var sch_prd_ly_vol = document.getElementById("sch_prd_ly_vol"+count);
	  sch_prd_ly_vol.value = "0";
	  var sch_prd_ly_vol_div = document.getElementById("sch_prd_ly_vol_div"+count);
	  sch_prd_ly_vol_div.value = "0";
	  
	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
	  proj_grwth_vol_pct.value = "0";
	  proj_grwth_vol_pct.readOnly = true;
	  
	  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
	  sch_prd_ty_vol.value = "0";
	  sch_prd_ty_vol.readOnly = true;
	  var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
	  sch_prd_ty_vol_div.value = "0";
	  sch_prd_ty_vol_div.readOnly = true;
    
    var sch_prd_lly_val = document.getElementById("sch_prd_lly_val"+count);
	  sch_prd_lly_val.value = "0";
	  var sch_prd_lly_val_div = document.getElementById("sch_prd_lly_val_div"+count);
	  sch_prd_lly_val_div.value = "0";
	  
	  var sch_prd_ly_val = document.getElementById("sch_prd_ly_val"+count);
	  sch_prd_ly_val.value = "0";
	  var sch_prd_ly_val_div = document.getElementById("sch_prd_ly_val_div"+count);
	  sch_prd_ly_val_div.value = "0";
	  
	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
	  proj_grwth_val_pct.value = "0";
	  proj_grwth_val_pct.readOnly = true;
	  
	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
	  sch_prd_ty_val.value = "0";
	  sch_prd_ty_val.readOnly = true;
	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
	  sch_prd_ty_val_div.value = "0";
	  sch_prd_ty_val_div.readOnly = true;
	  
	  var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
	  sch_prd_spread_tgt_vol.value = "0";
	  sch_prd_spread_tgt_vol.readOnly = true;
	  
	  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
	  sch_prd_spread_tgt_val.value = "0";
	  sch_prd_spread_tgt_val.readOnly = true;
	  
	  var sch_prd_spread_mtd_ly_vol = document.getElementById("sch_prd_spread_mtd_ly_vol"+count);
	  sch_prd_spread_mtd_ly_vol.value = "0";
	  
	  var sch_prd_spread_mtd_ly_val = document.getElementById("sch_prd_spread_mtd_ly_val"+count);
	  sch_prd_spread_mtd_ly_val.value = "0";
	  
	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
	  proj_grwth_spd_pct.value = "0";
	  proj_grwth_spd_pct.readOnly = true;
	  
	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
	  sch_prd_spread_mtd_ty_tgt_vol.value = "0";
	  
	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
	  sch_prd_spread_mtd_ty_tgt_val.value = "0";
	  
	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
	  sch_prd_wt_avg.value = "0";
	  sch_prd_wt_avg.readOnly = true;
	  
	  var sch_prd_total_prd_bdgt = document.getElementById("sch_prd_total_prd_bdgt"+count);
	  sch_prd_total_prd_bdgt.value = "0";
	  
	  prdoutflowTotal();
});

$('#sch_product_outflow_id'+count).change(function(){
    
	$('#loading'+count).show();
	$('#sch_prd_outflow_id'+count).hide();
	
	var sch_prd_lly_vol = document.getElementById("sch_prd_lly_vol"+count);
    sch_prd_lly_vol.value = "0";
    var sch_prd_lly_vol_div = document.getElementById("sch_prd_lly_vol_div"+count);
    sch_prd_lly_vol_div.value = "0";
	
    var sch_prd_ly_vol = document.getElementById("sch_prd_ly_vol"+count);
	sch_prd_ly_vol.value = "0";
	var sch_prd_ly_vol_div = document.getElementById("sch_prd_ly_vol_div"+count);
	sch_prd_ly_vol_div.value = "0";
	
	var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
	proj_grwth_vol_pct.value = "0";
	proj_grwth_vol_pct.readOnly = true;
	
	var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
	sch_prd_ty_vol.value = "0";
	sch_prd_ty_vol.readOnly = true;
	var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
	sch_prd_ty_vol_div.value = "0";
	sch_prd_ty_vol_div.readOnly = true;
	
    var sch_prd_lly_val = document.getElementById("sch_prd_lly_val"+count);
	sch_prd_lly_val.value = "0";
	var sch_prd_lly_val_div = document.getElementById("sch_prd_lly_val_div"+count);
	sch_prd_lly_val_div.value = "0";
	
	var sch_prd_ly_val = document.getElementById("sch_prd_ly_val"+count);
	sch_prd_ly_val.value = "0";
	var sch_prd_ly_val_div = document.getElementById("sch_prd_ly_val_div"+count);
	sch_prd_ly_val_div.value = "0";
	
	var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
	proj_grwth_val_pct.value = "0";
	proj_grwth_val_pct.readOnly = true;
	
	var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
	sch_prd_ty_val.value = "0";
	sch_prd_ty_val.readOnly = true;
	var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
	sch_prd_ty_val_div.value = "0";
	sch_prd_ty_val_div.readOnly = true;
	
	var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
	sch_prd_spread_tgt_vol.value = "0";
	sch_prd_spread_tgt_vol.readOnly = true;
	  
	var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
	sch_prd_spread_tgt_val.value = "0";
	sch_prd_spread_tgt_val.readOnly = true;
	
	var sch_prd_spread_mtd_ly_vol = document.getElementById("sch_prd_spread_mtd_ly_vol"+count);
	sch_prd_spread_mtd_ly_vol.value = "0";
	
	var sch_prd_spread_mtd_ly_val = document.getElementById("sch_prd_spread_mtd_ly_val"+count);
	sch_prd_spread_mtd_ly_val.value = "0";
	
	var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
	proj_grwth_spd_pct.value = "0";
	proj_grwth_spd_pct.readOnly = true;
	
	var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
	sch_prd_spread_mtd_ty_tgt_vol.value = "0";
	
	var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
	sch_prd_spread_mtd_ty_tgt_val.value = "0";
	
	var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
	sch_prd_wt_avg.value = "0";
	sch_prd_wt_avg.readOnly = true;
	
	var sch_prd_total_prd_bdgt = document.getElementById("sch_prd_total_prd_bdgt"+count);
	sch_prd_total_prd_bdgt.value = "0";
	
	prdoutflowTotal();
    
	var datavalue =$('#sch_prd_outflow_line_type'+count).val();
    var prdvalue =$('#sch_product_outflow_id'+count).val();
    
    var sch_prd_spread_tgt_vol_v =$('#sch_prd_spread_tgt_vol'+count).val();
    var sch_prd_spread_tgt_val_v =$('#sch_prd_spread_tgt_val'+count).val();
    
    var from_date=document.getElementById("start_date").value;
	
	var mm = from_date.substring(5,7);
	var dd = from_date.substring(8,10);
	var yy = from_date.substring(0,4);

    
    var startdate = dd+"-"+mm+"-"+yy;
    
    
	var to_date=document.getElementById("end_date").value;
	
	var mm1 = to_date.substring(5,7);
	var dd1 = to_date.substring(8,10);
	var yy1 = to_date.substring(0,4);
	
    var enddate = dd1+"-"+mm1+"-"+yy1;
  // alert("Start date : "+startdate+"End Date : "+enddate);
  
     var zones = $('#depot').val();
      var zones2 = $('#sel_depo').val();
	var depotcodes = ""+zones+"";
	var depotcodes2 = ""+zones2+"";
	str_array = depotcodes.split(',');
    
    var custtypes = jQuery.map($(':checkbox[name=cust_type]:checked'), function (n, i) {
        return n.value;
    }).join(',');
    
    //alert(zones2);
   // alert(zones);
  //  alert(str_array);
    
    	$.ajax({
            url: '${pageContext.request.contextPath}/loadproductoutflow',
            data: ({datavalue : datavalue,prdvalue : prdvalue,
            		startdate : startdate,enddate : enddate,
            		depotcodes : depotcodes2,custtypes : custtypes,
            		sch_prd_spread_tgt_vol : sch_prd_spread_tgt_vol_v,
            		sch_prd_spread_tgt_val : sch_prd_spread_tgt_val_v}),
            success: function(data) {

            	$('#sch_prd_lly_vol'+count).val(data.LLY_VOL);
            	if(data.LLY_VOL != 0) {
            		$('#sch_prd_lly_vol_div'+count).val(data.LLY_VOL / 1000);
            	} else {
            		$('#sch_prd_lly_vol_div'+count).val(data.LLY_VOL);
            	}
            	
            	$('#sch_prd_lly_val'+count).val(data.LLY_VAL);
				if(data.LLY_VAL != 0) {
					$('#sch_prd_lly_val_div'+count).val(data.LLY_VAL / 10000000);
            	} else {
            		$('#sch_prd_lly_val_div'+count).val(data.LLY_VAL);
            	}
            	
            	$('#sch_prd_ly_vol'+count).val(data.LY_VOL);
				if(data.LY_VOL != 0) {
					$('#sch_prd_ly_vol_div'+count).val(data.LY_VOL / 1000);
            	} else {
            		$('#sch_prd_ly_vol_div'+count).val(data.LY_VOL);
            	}
            	
            	$('#sch_prd_ly_val'+count).val(data.LY_VAL);
				if(data.LY_VAL != 0) {
					$('#sch_prd_ly_val_div'+count).val(data.LY_VAL / 10000000);
            	} else {
            		$('#sch_prd_ly_val_div'+count).val(data.LY_VAL);
            	}
            	$('#sch_prd_spread_mtd_ly_vol'+count).val(data.SPREAD_MTD_LY_VOL);
            	$('#sch_prd_spread_mtd_ly_val'+count).val(data.SPREAD_MTD_LY_VAL);
            	
            	
            	if(data.LLY_VOL == 0 && data.LLY_VAL == 0 && data.LY_VOL == 0 && data.LY_VAL == 0) {
          		
            		var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
                	sch_prd_spread_tgt_vol.readOnly = false;
            		  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
            		  sch_prd_spread_tgt_val.readOnly = false;
                	
          		  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
          		  sch_prd_ty_vol.readOnly = false;
          		var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
        		  sch_prd_ty_vol_div.readOnly = false;
                	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
                	  sch_prd_ty_val.readOnly = false;
                	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
                	  sch_prd_ty_val_div.readOnly = false;
                	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
                	  sch_prd_spread_mtd_ty_tgt_vol.readOnly = false;
                    	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
                    	  sch_prd_spread_mtd_ty_tgt_val.readOnly = false;
                	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
                	  proj_grwth_vol_pct.readOnly = true;
                	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
                	  proj_grwth_val_pct.readOnly = true;
                	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
                	  proj_grwth_spd_pct.readOnly = true;
                	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
                	  sch_prd_wt_avg.readOnly = false;
          	  
          		  
          	  } else {
          		  
          		var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
            	sch_prd_spread_tgt_vol.readOnly = false;
        		  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
        		  sch_prd_spread_tgt_val.readOnly = false;
            	
          		  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
          		  sch_prd_ty_vol.readOnly = true;
          		var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
        		  sch_prd_ty_vol_div.readOnly = true;
                	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
                	  sch_prd_ty_val.readOnly = true;
                	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
                	  sch_prd_ty_val_div.readOnly = true;
                	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
                	  sch_prd_spread_mtd_ty_tgt_vol.readOnly = true;
                    	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
                    	  sch_prd_spread_mtd_ty_tgt_val.readOnly = true;
                	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
                	  proj_grwth_vol_pct.readOnly = false;
                	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
                	  proj_grwth_val_pct.readOnly = false;
                	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
                	  proj_grwth_spd_pct.readOnly = false;
                	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
                	  sch_prd_wt_avg.readOnly = false;
          	  }
            	
            	$('#loading'+count).hide();
            	$('#sch_prd_outflow_id'+count).show();

            	prdoutflowgrwth(count);
            }
          });
    	
});



$('#sch_prd_spread_tgt_vol'+count).blur(function(){
	
	$('#loading'+count).show();
	$('#sch_prd_outflow_id'+count).hide();
	
	var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
	sch_prd_spread_tgt_vol.readOnly = true;
	  
	var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
	sch_prd_spread_tgt_val.readOnly = true;
	
	var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
	proj_grwth_vol_pct.readOnly = true;
	
	var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
	proj_grwth_val_pct.readOnly = true;
	
	var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
	proj_grwth_spd_pct.readOnly = true;
	
	var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
	sch_prd_ty_vol.readOnly = true;
	var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
	sch_prd_ty_vol_div.readOnly = true;
	
	var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
	sch_prd_ty_val.readOnly = true;
	var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
	sch_prd_ty_val_div.readOnly = true;
	
	var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
	sch_prd_wt_avg.readOnly = true;
	
    
	var datavalue =$('#sch_prd_outflow_line_type'+count).val();
    var prdvalue =$('#sch_product_outflow_id'+count).val();
    
    var sch_prd_spread_tgt_vol_v =$('#sch_prd_spread_tgt_vol'+count).val();
    var sch_prd_spread_tgt_val_v =$('#sch_prd_spread_tgt_val'+count).val();
    
    var from_date=document.getElementById("start_date").value;
	//alert("Start date is :"+from_date);
	var mm = from_date.substring(5,7);
	var dd = from_date.substring(8,10);
	var yy = from_date.substring(0,4);

    
    var startdate = dd+"-"+mm+"-"+yy;
    
	var to_date=document.getElementById("end_date").value;
	
	var mm1 = to_date.substring(5,7);
	var dd1 = to_date.substring(8,10);
	var yy1 = to_date.substring(0,4);
	
    var enddate = dd1+"-"+mm1+"-"+yy1;
  // alert("Start date : "+startdate+"End Date : "+enddate);
   
    //var depotcodes =String($('#duallist').val());
    
     var zones = $('#depot').val();
	var depotcodes = ""+zones+"";
	str_array = depotcodes.split(',');
    
    
    var custtypes = jQuery.map($(':checkbox[name=cust_type]:checked'), function (n, i) {
        return n.value;
    }).join(',');
   
   
    	
    	$.ajax({
            url: '${pageContext.request.contextPath}/loadproductoutflow',
            data: ({datavalue : datavalue,prdvalue : prdvalue,
            		startdate : startdate,enddate : enddate,
            		depotcodes : depotcodes,custtypes : custtypes,
            		sch_prd_spread_tgt_vol : sch_prd_spread_tgt_vol_v,
            		sch_prd_spread_tgt_val : sch_prd_spread_tgt_val_v}),
            success: function(data) {

            	$('#sch_prd_lly_vol'+count).val(data.LLY_VOL);
            	if(data.LLY_VOL != 0) {
            		$('#sch_prd_lly_vol_div'+count).val(data.LLY_VOL / 1000);
            	} else {
            		$('#sch_prd_lly_vol_div'+count).val(data.LLY_VOL);
            	}
            	$('#sch_prd_lly_val'+count).val(data.LLY_VAL);
            	if(data.LLY_VAL != 0) {
					$('#sch_prd_lly_val_div'+count).val(data.LLY_VAL / 10000000);
            	} else {
            		$('#sch_prd_lly_val_div'+count).val(data.LLY_VAL);
            	}
            	$('#sch_prd_ly_vol'+count).val(data.LY_VOL);
            	if(data.LY_VOL != 0) {
					$('#sch_prd_ly_vol_div'+count).val(data.LY_VOL / 1000);
            	} else {
            		$('#sch_prd_ly_vol_div'+count).val(data.LY_VOL);
            	}
            	$('#sch_prd_ly_val'+count).val(data.LY_VAL);
            	if(data.LY_VAL != 0) {
					$('#sch_prd_ly_val_div'+count).val(data.LY_VAL / 10000000);
            	} else {
            		$('#sch_prd_ly_val_div'+count).val(data.LY_VAL);
            	}
            	$('#sch_prd_spread_mtd_ly_vol'+count).val(data.SPREAD_MTD_LY_VOL);
            	$('#sch_prd_spread_mtd_ly_val'+count).val(data.SPREAD_MTD_LY_VAL);
            	
            	
            	if(data.LLY_VOL == 0 && data.LLY_VAL == 0 && data.LY_VOL == 0 && data.LY_VAL == 0) {
          		
            		var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
                	sch_prd_spread_tgt_vol.readOnly = false;
            		  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
            		  sch_prd_spread_tgt_val.readOnly = false;
                	
          		  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
          		  sch_prd_ty_vol.readOnly = false;
          		var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
        		  sch_prd_ty_vol_div.readOnly = false;
                	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
                	  sch_prd_ty_val.readOnly = false;
                	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
                	  sch_prd_ty_val_div.readOnly = false;
                	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
                	  sch_prd_spread_mtd_ty_tgt_vol.readOnly = false;
                    	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
                    	  sch_prd_spread_mtd_ty_tgt_val.readOnly = false;
                	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
                	  proj_grwth_vol_pct.readOnly = true;
                	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
                	  proj_grwth_val_pct.readOnly = true;
                	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
                	  proj_grwth_spd_pct.readOnly = true;
                	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
                	  sch_prd_wt_avg.readOnly = false;
          	  
          		  
          	  } else {
          		  
          		var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
            	sch_prd_spread_tgt_vol.readOnly = false;
        		  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
        		  sch_prd_spread_tgt_val.readOnly = false;
            	
          		  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
          		  sch_prd_ty_vol.readOnly = true;
          		var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
        		  sch_prd_ty_vol_div.readOnly = true;
                	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
                	  sch_prd_ty_val.readOnly = true;
                	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
                	  sch_prd_ty_val_div.readOnly = true;
                	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
                	  sch_prd_spread_mtd_ty_tgt_vol.readOnly = true;
                    	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
                    	  sch_prd_spread_mtd_ty_tgt_val.readOnly = true;
                	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
                	  proj_grwth_vol_pct.readOnly = false;
                	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
                	  proj_grwth_val_pct.readOnly = false;
                	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
                	  proj_grwth_spd_pct.readOnly = false;
                	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
                	  sch_prd_wt_avg.readOnly = false;
          	  }
            	
            	$('#loading'+count).hide();
            	$('#sch_prd_outflow_id'+count).show();

            	prdoutflowgrwth(count);
            }
          });

	
});




$('#sch_prd_spread_tgt_val'+count).blur(function(){
	
	$('#loading'+count).show();
	$('#sch_prd_outflow_id'+count).hide();
	
	var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
	sch_prd_spread_tgt_vol.readOnly = true;
	  
	var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
	sch_prd_spread_tgt_val.readOnly = true;
	
	var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
	proj_grwth_vol_pct.readOnly = true;
	
	var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
	proj_grwth_val_pct.readOnly = true;
	
	var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
	proj_grwth_spd_pct.readOnly = true;
	
	var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
	sch_prd_ty_vol.readOnly = true;
	var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
	sch_prd_ty_vol_div.readOnly = true;
	
	var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
	sch_prd_ty_val.readOnly = true;
	var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
	sch_prd_ty_val_div.readOnly = true;
	
	var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
	sch_prd_wt_avg.readOnly = true;
	
   
	var datavalue =$('#sch_prd_outflow_line_type'+count).val();
    var prdvalue =$('#sch_product_outflow_id'+count).val();
    
    var sch_prd_spread_tgt_vol_v =$('#sch_prd_spread_tgt_vol'+count).val();
    var sch_prd_spread_tgt_val_v =$('#sch_prd_spread_tgt_val'+count).val();
    
    var from_date=document.getElementById("start_date").value;
	//alert("Start date is :"+from_date);
	var mm = from_date.substring(5,7);
	var dd = from_date.substring(8,10);
	var yy = from_date.substring(0,4);

    
    var startdate = dd+"-"+mm+"-"+yy;
    
	var to_date=document.getElementById("end_date").value;
	
	var mm1 = to_date.substring(5,7);
	var dd1 = to_date.substring(8,10);
	var yy1 = to_date.substring(0,4);
	
    var enddate = dd1+"-"+mm1+"-"+yy1;
   //alert("Start date : "+startdate+"End Date : "+enddate);
    
   /*  var startdate =$('#start_date').val();
    var enddate =$('#end_date').val(); */
    //var depotcodes =String($('#duallist').val());
    
     var zones = $('#depot').val();
	var depotcodes = ""+zones+"";
	str_array = depotcodes.split(',');
    
    
    
    var custtypes = jQuery.map($(':checkbox[name=cust_type]:checked'), function (n, i) {
        return n.value;
    }).join(',');
   
   
    	
    	$.ajax({
            url: '${pageContext.request.contextPath}/loadproductoutflow',
            data: ({datavalue : datavalue,prdvalue : prdvalue,
            		startdate : startdate,enddate : enddate,
            		depotcodes : depotcodes,custtypes : custtypes,
            		sch_prd_spread_tgt_vol : sch_prd_spread_tgt_vol_v,
            		sch_prd_spread_tgt_val : sch_prd_spread_tgt_val_v}),
            success: function(data) {

            	$('#sch_prd_lly_vol'+count).val(data.LLY_VOL);
            	if(data.LLY_VOL != 0) {
            		$('#sch_prd_lly_vol_div'+count).val(data.LLY_VOL / 1000);
            	} else {
            		$('#sch_prd_lly_vol_div'+count).val(data.LLY_VOL);
            	}
            	$('#sch_prd_lly_val'+count).val(data.LLY_VAL);
            	if(data.LLY_VAL != 0) {
					$('#sch_prd_lly_val_div'+count).val(data.LLY_VAL / 10000000);
            	} else {
            		$('#sch_prd_lly_val_div'+count).val(data.LLY_VAL);
            	}
            	$('#sch_prd_ly_vol'+count).val(data.LY_VOL);
            	if(data.LY_VOL != 0) {
					$('#sch_prd_ly_vol_div'+count).val(data.LY_VOL / 1000);
            	} else {
            		$('#sch_prd_ly_vol_div'+count).val(data.LY_VOL);
            	}
            	$('#sch_prd_ly_val'+count).val(data.LY_VAL);
            	if(data.LY_VAL != 0) {
					$('#sch_prd_ly_val_div'+count).val(data.LY_VAL / 10000000);
            	} else {
            		$('#sch_prd_ly_val_div'+count).val(data.LY_VAL);
            	}
            	$('#sch_prd_spread_mtd_ly_vol'+count).val(data.SPREAD_MTD_LY_VOL);
            	$('#sch_prd_spread_mtd_ly_val'+count).val(data.SPREAD_MTD_LY_VAL);
            	
            	
            	if(data.LLY_VOL == 0 && data.LLY_VAL == 0 && data.LY_VOL == 0 && data.LY_VAL == 0) {
          		
            		var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
                	sch_prd_spread_tgt_vol.readOnly = false;
            		  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
            		  sch_prd_spread_tgt_val.readOnly = false;
                	
          		  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
          		  sch_prd_ty_vol.readOnly = false;
          		var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
        		  sch_prd_ty_vol_div.readOnly = false;
                	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
                	  sch_prd_ty_val.readOnly = false;
                	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
                	  sch_prd_ty_val_div.readOnly = false;
                	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
                	  sch_prd_spread_mtd_ty_tgt_vol.readOnly = false;
                    	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
                    	  sch_prd_spread_mtd_ty_tgt_val.readOnly = false;
                	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
                	  proj_grwth_vol_pct.readOnly = true;
                	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
                	  proj_grwth_val_pct.readOnly = true;
                	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
                	  proj_grwth_spd_pct.readOnly = true;
                	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
                	  sch_prd_wt_avg.readOnly = false;
          	  
          		  
          	  } else {
          		  
          		var sch_prd_spread_tgt_vol = document.getElementById("sch_prd_spread_tgt_vol"+count);
            	sch_prd_spread_tgt_vol.readOnly = false;
        		  var sch_prd_spread_tgt_val = document.getElementById("sch_prd_spread_tgt_val"+count);
        		  sch_prd_spread_tgt_val.readOnly = false;
            	
          		  var sch_prd_ty_vol = document.getElementById("sch_prd_ty_vol"+count);
          		  sch_prd_ty_vol.readOnly = true;
          		var sch_prd_ty_vol_div = document.getElementById("sch_prd_ty_vol_div"+count);
        		  sch_prd_ty_vol_div.readOnly = true;
                	  var sch_prd_ty_val = document.getElementById("sch_prd_ty_val"+count);
                	  sch_prd_ty_val.readOnly = true;
                	  var sch_prd_ty_val_div = document.getElementById("sch_prd_ty_val_div"+count);
                	  sch_prd_ty_val_div.readOnly = true;
                	  var sch_prd_spread_mtd_ty_tgt_vol = document.getElementById("sch_prd_spread_mtd_ty_tgt_vol"+count);
                	  sch_prd_spread_mtd_ty_tgt_vol.readOnly = true;
                    	  var sch_prd_spread_mtd_ty_tgt_val = document.getElementById("sch_prd_spread_mtd_ty_tgt_val"+count);
                    	  sch_prd_spread_mtd_ty_tgt_val.readOnly = true;
                	  var proj_grwth_vol_pct = document.getElementById("proj_grwth_vol_pct"+count);
                	  proj_grwth_vol_pct.readOnly = false;
                	  var proj_grwth_val_pct = document.getElementById("proj_grwth_val_pct"+count);
                	  proj_grwth_val_pct.readOnly = false;
                	  var proj_grwth_spd_pct = document.getElementById("proj_grwth_spd_pct"+count);
                	  proj_grwth_spd_pct.readOnly = false;
                	  var sch_prd_wt_avg = document.getElementById("sch_prd_wt_avg"+count);
                	  sch_prd_wt_avg.readOnly = false;
          	  }
            	
            	$('#loading'+count).hide();
            	$('#sch_prd_outflow_id'+count).show();

            	prdoutflowgrwth(count);
            }
          });

}); 



$('#proj_grwth_vol_pct'+count).blur(function(){
	
	var sch_prd_ly_vol= parseFloat($('#sch_prd_ly_vol'+count).val());
	var sch_prd_ly_vol_div= parseFloat($('#sch_prd_ly_vol_div'+count).val());
	var proj_grwth_vol_pct= parseFloat($('#proj_grwth_vol_pct'+count).val());
	var pct = parseFloat(proj_grwth_vol_pct) + 100;
	
	if(sch_prd_ly_vol != 0) {
		var sch_prd_ty_vol = (sch_prd_ly_vol * pct / 100).toFixed(2);
	} else {
		var sch_prd_ty_vol = (proj_grwth_vol_pct).toFixed(2);
	}
	$('#sch_prd_ty_vol'+count).val(sch_prd_ty_vol);
	if(sch_prd_ly_vol_div != 0) {
		var sch_prd_ty_vol_div = (sch_prd_ly_vol_div * pct / 100).toFixed(2);	
	} else {
		if(proj_grwth_vol_pct != 0) {
			var sch_prd_ty_vol_div = (proj_grwth_vol_pct / 1000).toFixed(2);
		} else {
			var sch_prd_ty_vol_div = (proj_grwth_vol_pct).toFixed(2);
		}
	}
	$('#sch_prd_ty_vol_div'+count).val(sch_prd_ty_vol_div);
	
	var sch_prd_wt_avg= parseFloat($('#sch_prd_wt_avg'+count).val());
	var sch_prd_total_prd_bdgt = (sch_prd_ty_vol * sch_prd_wt_avg).toFixed(2); 
	$('#sch_prd_total_prd_bdgt'+count).val(sch_prd_total_prd_bdgt);
	
	 prdoutflowTotal();

}); 

$('#proj_grwth_val_pct'+count).blur(function(){
	
	var sch_prd_ly_val= parseFloat($('#sch_prd_ly_val'+count).val());
	var sch_prd_ly_val_div= parseFloat($('#sch_prd_ly_val_div'+count).val());
	var proj_grwth_val_pct= parseFloat($('#proj_grwth_val_pct'+count).val());
	var pct = parseFloat(proj_grwth_val_pct) + 100;
	
	if(sch_prd_ly_val != 0) {
		var sch_prd_ty_val = (sch_prd_ly_val * pct / 100).toFixed(2);	
	} else {
		var sch_prd_ty_val = (proj_grwth_val_pct).toFixed(2);
	}
	$('#sch_prd_ty_val'+count).val(sch_prd_ty_val);
	if(sch_prd_ly_val_div != 0) {
		var sch_prd_ty_val_div = (sch_prd_ly_val_div * pct / 100).toFixed(2);	
	} else {
		if(proj_grwth_val_pct != 0) {
			var sch_prd_ty_val_div = (proj_grwth_val_pct / 10000000).toFixed(2);	
		} else {
			var sch_prd_ty_val_div = (proj_grwth_val_pct).toFixed(2);
		}
		
	}
	$('#sch_prd_ty_val_div'+count).val(sch_prd_ty_val_div);
	

}); 

$('#proj_grwth_spd_pct'+count).blur(function(){
	
	var sch_prd_spread_mtd_ly_vol= parseFloat($('#sch_prd_spread_mtd_ly_vol'+count).val());
	var sch_prd_spread_mtd_ly_val= parseFloat($('#sch_prd_spread_mtd_ly_val'+count).val());
	var proj_grwth_spd_pct= parseFloat($('#proj_grwth_spd_pct'+count).val());
	var pct = parseFloat(proj_grwth_spd_pct) + 100;
	
	var sch_prd_spread_mtd_ty_tgt_vol = parseInt(sch_prd_spread_mtd_ly_vol * pct / 100);
	$('#sch_prd_spread_mtd_ty_tgt_vol'+count).val(sch_prd_spread_mtd_ty_tgt_vol);
	var sch_prd_spread_mtd_ty_tgt_val = parseInt(sch_prd_spread_mtd_ly_val * pct / 100);
	$('#sch_prd_spread_mtd_ty_tgt_val'+count).val(sch_prd_spread_mtd_ty_tgt_val);

}); 

$('#sch_prd_ty_vol'+count).blur(function(){
	
	var sch_prd_ty_vol= parseFloat($('#sch_prd_ty_vol'+count).val());
	var sch_prd_wt_avg= parseFloat($('#sch_prd_wt_avg'+count).val());
	
	if(proj_grwth_val_pct != 0) {
		var sch_prd_ty_vol_div= (sch_prd_ty_vol / 1000).toFixed(2);	
	} else {
		var sch_prd_ty_vol_div= (sch_prd_ty_vol).toFixed(2);
	}
	$('#sch_prd_ty_vol_div'+count).val(sch_prd_ty_vol_div);
	
	var sch_prd_total_prd_bdgt = (sch_prd_ty_vol * sch_prd_wt_avg).toFixed(2); 
	$('#sch_prd_total_prd_bdgt'+count).val(sch_prd_total_prd_bdgt);
	
	 prdoutflowTotal();

}); 

$('#sch_prd_ty_vol_div'+count).blur(function(){
	
	var sch_prd_ty_vol_div= parseFloat($('#sch_prd_ty_vol_div'+count).val());
	var sch_prd_wt_avg= parseFloat($('#sch_prd_wt_avg'+count).val());
	
	var sch_prd_ty_vol= (sch_prd_ty_vol_div * 1000).toFixed(2);
	$('#sch_prd_ty_vol'+count).val(sch_prd_ty_vol);
	
	var sch_prd_total_prd_bdgt = (sch_prd_ty_vol * sch_prd_wt_avg).toFixed(2); 
	$('#sch_prd_total_prd_bdgt'+count).val(sch_prd_total_prd_bdgt);
	
	 prdoutflowTotal();

});


$('#sch_prd_wt_avg'+count).blur(function(){
	
	var sch_prd_ty_vol= parseFloat($('#sch_prd_ty_vol'+count).val());
	var sch_prd_wt_avg= parseFloat($('#sch_prd_wt_avg'+count).val());
	
	var sch_prd_total_prd_bdgt = (sch_prd_ty_vol * sch_prd_wt_avg).toFixed(2); 
	$('#sch_prd_total_prd_bdgt'+count).val(sch_prd_total_prd_bdgt);
	
	 prdoutflowTotal();

}); 


}

function prdoutflowgrwth(count){
	
	
	var sch_prd_ly_vol= parseFloat($('#sch_prd_ly_vol'+count).val());
	var sch_prd_ly_vol_div= parseFloat($('#sch_prd_ly_vol_div'+count).val());
	var sch_prd_ly_val= parseFloat($('#sch_prd_ly_val'+count).val());
	var sch_prd_ly_val_div= parseFloat($('#sch_prd_ly_val_div'+count).val());
	var sch_prd_spread_mtd_ly_vol= parseFloat($('#sch_prd_spread_mtd_ly_vol'+count).val());
	var sch_prd_spread_mtd_ly_val= parseFloat($('#sch_prd_spread_mtd_ly_val'+count).val());
	var proj_grwth_vol_pct= parseFloat($('#proj_grwth_vol_pct'+count).val());
	var proj_grwth_val_pct= parseFloat($('#proj_grwth_val_pct'+count).val());
	var proj_grwth_spd_pct= parseFloat($('#proj_grwth_spd_pct'+count).val());
	var pct_vol = parseFloat(proj_grwth_vol_pct) + 100;
	var pct_val = parseFloat(proj_grwth_val_pct) + 100;
	var pct_spd = parseFloat(proj_grwth_spd_pct) + 100;
	
	if(sch_prd_ly_vol != 0) {
		var sch_prd_ty_vol = (sch_prd_ly_vol * pct_vol / 100).toFixed(2);	
	} else {
		var sch_prd_ty_vol = (proj_grwth_vol_pct).toFixed(2);
	}
	$('#sch_prd_ty_vol'+count).val(sch_prd_ty_vol);
	if(sch_prd_ly_vol_div != 0) {
		var sch_prd_ty_vol_div = (sch_prd_ly_vol_div * pct_vol / 100).toFixed(2);	
	} else {
		if(proj_grwth_vol_pct != 0) {
			var sch_prd_ty_vol_div = (proj_grwth_vol_pct / 1000).toFixed(2);
		} else {
			var sch_prd_ty_vol_div = (proj_grwth_vol_pct).toFixed(2);
		}
	}
	$('#sch_prd_ty_vol_div'+count).val(sch_prd_ty_vol_div);
	if(sch_prd_ly_val != 0) {
		var sch_prd_ty_val = (sch_prd_ly_val * pct_val / 100).toFixed(2);	
	} else {
		var sch_prd_ty_val = (proj_grwth_val_pct).toFixed(2);
	}
	$('#sch_prd_ty_val'+count).val(sch_prd_ty_val);
	if(sch_prd_ly_val_div != 0) {
		var sch_prd_ty_val_div = (sch_prd_ly_val_div * pct_val / 100).toFixed(2);	
	} else {
		if(proj_grwth_val_pct != 0) {
			var sch_prd_ty_val_div = (proj_grwth_val_pct / 10000000).toFixed(2);	
		} else {
			var sch_prd_ty_val_div = (proj_grwth_val_pct).toFixed(2);
		}
	}
	$('#sch_prd_ty_val_div'+count).val(sch_prd_ty_val_div);
	var sch_prd_spread_mtd_ty_tgt_vol = parseInt(sch_prd_spread_mtd_ly_vol * pct_spd / 100);
	$('#sch_prd_spread_mtd_ty_tgt_vol'+count).val(sch_prd_spread_mtd_ty_tgt_vol);
	var sch_prd_spread_mtd_ty_tgt_val = parseInt(sch_prd_spread_mtd_ly_val * pct_spd / 100);
	$('#sch_prd_spread_mtd_ty_tgt_val'+count).val(sch_prd_spread_mtd_ty_tgt_val);
	
	var sch_prd_wt_avg= parseFloat($('#sch_prd_wt_avg'+count).val());
	var sch_prd_total_prd_bdgt = (sch_prd_ty_vol * sch_prd_wt_avg).toFixed(2); 
	$('#sch_prd_total_prd_bdgt'+count).val(sch_prd_total_prd_bdgt);
	
	 prdoutflowTotal();
}



function prdoutflowTotal(){
	
	
	$('#rowcount3').val($('#dynamic-table3 tr').length-1);
	var count3 = $('#rowcount3').val();
		
	var total = 0;
	$('#total_prd_outflow').val(total);
	var lineTotal=0;
	var i=1;
	
	for(i=1; i<=count3; i++){
		 lineTotal = $('#sch_prd_total_prd_bdgt'+i).val();
		
		 total = Number(total)+Number(lineTotal);

	}
	
	var totalsum = (total).toFixed(2);
	
	$('#total_prd_outflow').val(totalsum);
	$('#scheme_budget').val(totalsum);
}





</script>



<script>

function delRow1() {
	
	$('#rowcount2').val($('#dynamic-table2 tr').length-1);
	var count = $('#rowcount2').val();
	
	
	if(count > 1)
		{ 		
			 document.getElementById("dynamic-table2").deleteRow(count);
	 			
			 
		}
}
function AddRow1()
{

$('#dynamic-table2 tr').last().after('<tr>'
		+'<td ><center>'+($('#dynamic-table2 tr').length-1)+'<input type="hidden" id="sch_prd_unique_id'+$('#dynamic-table2 tr').length+'" name="sch_prd_unique_id"></center></td>'
		+'<td ><select name="sch_prd_line_type" id="sch_prd_line_type'+$('#dynamic-table2 tr').length+'" class="col-xs-12 col-sm-4" required><option value="">--Select--</option></select></td>'
		+'<td ><select name="sch_product_id" id="sch_product_id'+$('#dynamic-table2 tr').length+'" class="col-xs-12 col-sm-4" required><option value="">--Select--</option></select></td>'
		+'<td ><input type="text" id="sch_prd_exceptions'+$('#dynamic-table2 tr').length+'" name="sch_prd_exceptions" class="col-xs-12 col-sm-4"></td>'
		+'<td ><input type="text" class= "calvolgrwthavg" style="width:100%;" id="vol_grwth_pct'+$('#dynamic-table2 tr').length+'" value="0" name="vol_grwth_pct" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required/></td>'
		+'<td ><input type="text" class= "calvalgrwthavg" style="width:100%;" id="val_grwth_pct'+$('#dynamic-table2 tr').length+'" value="0" name="val_grwth_pct" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required/></td>'
		+'<td ><input type="text" class= "calspreadavg" id="spread_pct'+$('#dynamic-table2 tr').length+'" value="0" name="spread_pct" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required/></td>'
		+'<td ><input type="text" style="width:100%;" id="spend_per_ltr'+$('#dynamic-table2 tr').length+'" value="0" name="spend_per_ltr" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required/></td>'
		+'</tr>');

$('#rowcount2').val($('#dynamic-table2 tr').length-1);
var count = $('#rowcount2').val();

var prd_line_type = "PRD_LINE_TYPE";
$.ajax({
        url: '${pageContext.request.contextPath}/loadschemetype',
        data: ({scheme : prd_line_type}),
       success: function(data) {
           var select = $('#sch_prd_line_type'+count);
           select.find('option').remove();
           $('<option>').val("").text("--Select--").appendTo(select);
              $.each(data, function(index, value) {
           	
           			$('<option>').val(value).text(value).appendTo(select);

           	
           });

        }
      });

$(document).on('change','#sch_prd_line_type'+count,function(){
/* $('#sch_prd_line_type'+count).change(function(){ */
    var datavalue =$('#sch_prd_line_type'+count).val();
    
    if(datavalue == "All") {
        var select = $('#sch_product_id'+count);
        select.find('option').remove();

		$('<option>').val("All").text("All").appendTo(select);

    }
    else if(datavalue == "Product Category") {
    	
    	$.ajax({
            url: '${pageContext.request.contextPath}/loadproductcat',
            success: function(data) {

                var select = $('#sch_product_id'+count);
                select.find('option').remove();

    		$('<option>').val("").text("--Select--").appendTo(select);
                   $.each(data, function(index, value) {
    		$('<option>').val(value.prd_cat).text(value.prd_cat).appendTo(select);
                });

            }
          });
    
    	
    } else if (datavalue == "Product Code") {
    $.ajax({
        url: '${pageContext.request.contextPath}/loadproductcode',
        success: function(data) {

            var select = $('#sch_product_id'+count);
            select.find('option').remove();

		$('<option>').val("").text("--Select--").appendTo(select);
               $.each(data, function(index, value) {
		$('<option>').val(value.prd_code).text(value.prd_code).appendTo(select);
            });

        }
      });
    } else  {
    	var select = $('#sch_product_id'+count);
        select.find('option').remove();
        $('<option>').val("").text("--Select--").appendTo(select);
    }
});




function calgrowthpercent() {
	var vol_gwt = $('#volume_growth').val();
	var val_gwt = $('#value_growth').val();
	var spread = $('#spraid').val();
	
	var sum = parseFloat(vol_gwt) + parseFloat(val_gwt) + parseFloat(spread);
	
	if(sum > 0) {
		return true;
	}
	else {
		return false;
	}
	
}

function calvolpercent()
{

		$('#rowcount2').val($('#dynamic-table2 tr').length-1);
		var count = $('#rowcount2').val();

		
		 var avg=0;
		var vol_gwt = $('#volume_growth').val();

			var sum = 0;					
			for(var i=2;i<=count;i++)
				{
					var data = parseFloat($('#vol_grwth_pct'+i).val());	
					
					sum = sum  + data;	
				}
			
			avg = sum /(count-1);
			
			if(vol_gwt == avg)
			{
			
			return true;
			}
			else{
// 				alert("Percentage value not matching with header");
				for(var i=2;i<=count;i++)
				{
					$('#vol_grwth_pct'+i).val("0");	
					
						
				}
				return false;
			} 
			
}
function calvalpercent() {

		$('#rowcount2').val($('#dynamic-table2 tr').length-1);
		var count = $('#rowcount2').val();

		var avg=0;
		var val_gwt = $('#value_growth').val();

			var sum = 0;					
			for(var i=2;i<=count;i++)
				{
					var data = parseFloat($('#val_grwth_pct'+i).val());	
					
					sum = sum  + data;							
				}
			
			avg = sum /(count-1);
			
			if(val_gwt == avg)
			{
				return true;
			}
			else{
// 				alert("Percentage value not matching with header");
				for(var i=2;i<=count;i++)
				{
					$('#val_grwth_pct'+i).val("0");	
					
											
				}
				return false;
			}
			
}

function calspreafpercent() {
	
		$('#rowcount2').val($('#dynamic-table2 tr').length-1);
		var count = $('#rowcount2').val();

		var avg=0;
		var spread = $('#spraid').val();

			var sum = 0;					
			for(var i=2;i<=count;i++)
				{
					var data = parseFloat($('#spread_pct'+i).val());	
					
					sum = sum  + data;							
				}
			
			avg = sum /(count-1);
			
			if(spread == avg)
			{
				return true;
			}
			else{
// 				alert("Percentage value not matching with header");
				for(var i=2;i<=count;i++)
				{
					$('#spread_pct'+i).val("0");	
					
					sum = sum  + data;							
				}
				return false;
			}
	
}

</script>

<script>

function delRow() {
	
	$('#rowcount1').val($('#dynamic-table1 tr').length - 1);
	var count = $('#rowcount1').val();
	
	
	if(count > 0)
		{ 	
			 document.getElementById("dynamic-table1").deleteRow(count);
	 			
			 
		}
}

function AddRow()
{
$('#dynamic-table1 tr').last().after('<tr>'
		+'<td ><center>'+($('#dynamic-table1 tr').length)+'<input type="hidden" id="gift_id'+$('#dynamic-table1 tr').length+'" name="gift_id"></center></td>'
		+'<td ><select class="form-control form-control-sm " name="gift_group" id="gift_group'+$('#dynamic-table1 tr').length+'" class="col-xs-12 col-sm-4" required><option value="">--Select--</option></select></td>'
		+'<td ><select class="form-control form-control-sm " name="gift_name" id="gift_name'+$('#dynamic-table1 tr').length+'" class="col-xs-12 col-sm-4" required><option value="">--Select--</option></select></td>'
		+'<td ><input class="form-control" type="text" style="width:100%;" id="gift_code'+$('#dynamic-table1 tr').length+'" value="" name="gift_code" readonly/></td>'
		+'<td ><input class="form-control" type="text" style="width:100%;" id="effective_price'+$('#dynamic-table1 tr').length+'" value="" name="effective_price" onkeypress="return isNumber(event);" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" readonly/></td>'
		+'</tr>');

$('#rowcount1').val($('#dynamic-table1 tr').length-1);

var count = $('#rowcount1').val();

    $.ajax({
        url: '${pageContext.request.contextPath}/loadschemegroup1',
        data:({datavalue :'GIFT_GROUP'}),
        success: function(data) {
            var select = $('#gift_group'+count);
            select.find('option').remove();

$('<option>').val("").text("--Select--").appendTo(select);
                     $.each(data, function(index, value) {
$('<option>').val(value).text(value).appendTo(select);
            });
        }
      });

    $(document).on('change','#gift_group'+count,function(){
   /*  $('#gift_group'+count).change(function(){ */
        var datavalue =$('#gift_group'+count).val();
   //alert("Gift Group is"+datavalue);
    $.ajax({
        url: '${pageContext.request.contextPath}/getschemegroup1',
        data:({groupname :datavalue}),
        success: function(data) {
            var select = $('#gift_name'+count);
            select.find('option').remove();

	$('<option>').val("").text("--Select--").appendTo(select);
                     $.each(data, function(index, value) {
	$('<option>').val(value.gift_id).text(value.gift_name).appendTo(select);
            });

        }
      });
    
    $('#gift_code'+count).val("");
    $('#effective_price'+count).val("");
    
     });
    
    $(document).on('change','#gift_name'+count,function(){
   /*  $('#gift_name'+count).change(function(){ */
        var datavalue =$('#gift_name'+count).val();
    $.ajax({
        url: '${pageContext.request.contextPath}/getgiftcode',
        data:({groupname :datavalue}),
        success: function(data) {
           $('#gift_code'+count).val(data.gift_code);
           $('#effective_price'+count).val(data.effective_price);
        }
      });
     });    
 
}

function isNumber(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode;

	if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
    
	return false;

	
return true;
}    


      $('.fetchgrpid').mousedown(function(){
            var count = $('.fetchgrpid').index(this)+1;
        $.ajax({
            url: '${pageContext.request.contextPath}/loadschemegroup1',
            data:({datavalue :'GIFT_GROUP'}),
            success: function(data) {
                var select = $('#gift_group'+count);
                select.find('option').remove();

$('<option>').val("").text("--Select--").appendTo(select);
                         $.each(data, function(index, value) {
$('<option>').val(value).text(value).appendTo(select);
                });

            }
          });
        }); 

        $('.fetchgrpid').change(function(){

            var count = $('.fetchgrpid').index(this)+1;
            var datavalue =$('#gift_group'+count).val();
        $.ajax({
            url: '${pageContext.request.contextPath}/getschemegroup1',
            data:({groupname :datavalue}),
            success: function(data) {
                var select = $('#gift_name'+count);
                select.find('option').remove();

$('<option>').val("").text("--Select--").appendTo(select);
                         $.each(data, function(index, value) {
$('<option>').val(value.gift_id).text(value.gift_name).appendTo(select);
                });
            }
          });
         }); 
</script>



<script>
function business_line1(){
	var pmg = document.getElementById("pmguser").value;
	document.getElementById("pmg_user_id").value = pmg;
	
	  $.ajax({
      	url: '${pageContext.request.contextPath}/loadpmguser',
      	data:({user_id :pmg}),
          success: function(data) {
       
        	  document.getElementById("scheme_business_line").value = data.pmg_ml_group;
        	  var fin=document.getElementById("scheme_fin_yr").value;
        		var sline=document.getElementById("scheme_business_line").value;
        		var srno=document.getElementById("scheme_srl_no").value;

        		var scode=fin+"-"+sline+"-"+srno;

        		document.getElementById("scheme_code").value=scode;
        	  document.getElementById("created_by").value = data.last_name +" "+ data.first_name;
          }
      });

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
//window.open("primaryfinancialanalysis?price="+p,"Ratting","width=750,height=450,left=250,top=200,toolbar=0,status=0,");


    var sc_name=document.getElementById("scheme_name").value;

    var sc_id=document.getElementById("scheme_id").value;

window.open("primaryfinancialanalysis?scheme_name="+sc_name+"&scheme_id="+sc_id+"&price="+p,"Ratting","width=750,height=550,left=100,top=100,toolbar=0,status=0,");

}
</script>
<script>
    window.onload=function checkbuttons()
    {

        var count=${count};
        //alert("count "+count);
        if(count==20)
            {
            $("#submit1").hide();
            $("#save").hide();
            }else
                {

        $("#submit1").hide();
//         $("#FinancialAnalysis").hide();
                }
    }
    </script>



<script>
    $(document).ready(function() {
        	

            $.ajax({
            	url: '${pageContext.request.contextPath}/loadfinyear',
                success: function(data) {
                	var select = $('#scheme_fin_yr');
                    select.find('option').remove();
					$('<option>').val("").text("--Select--").appendTo(select);
                    $.each(data, function(index, value) {
                    	if(value.current_yr_flag == "Y") {
							$('<option selected>').val(value.fin_year).text(value.fin_year).appendTo(select);
                        }
                        else {
                        	$('<option>').val(value.fin_year).text(value.fin_year).appendTo(select);
                        }
                    });

                }
            });





            var lovtype = "BLINE_TYPE";
            $.ajax({
            	url: '${pageContext.request.contextPath}/loadschemebusinessline',
                data: ({bline : lovtype}),
                success: function(data) {
                
                	var select = $('#scheme_business_line');
                    select.find('option').remove();
// 					$('<option>').val("").text("--Select--").appendTo(select);
                    $.each(data, function(index, value) {
						$('<option>').val(value).text(value).appendTo(select);
                    });

                }
            });
             
            
             
            var scheme_business_line = $("select#scheme_business_line").val();
            var scheme_fin_yr = $("select#scheme_fin_yr").val();
            $.ajax({
            	url: '${pageContext.request.contextPath}/getparentschemename',	
            	data: ({sbl : scheme_business_line,sfy : scheme_fin_yr}),
            	success: function(data) {				        	
            	    	
            		var select = $('#parent_scheme_code');
            	    select.find('option').remove();
            	    $('<option>').val("").text("--Select--").appendTo(select);
            	    $.each(data, function(index, value) {	
            	    	$('<option>').val(value.scheme_id).text(value.scheme_name).appendTo(select);
            	           		 
            	    });

            	}
            });
             
             
            $(document).on('change','#scheme_type',function(){ 
           /*  $('#scheme_type').change(function(event) { */
            	 
            	var schemetyp = $('#scheme_type').val();
            	 
            	var lovtype = "BLINE_TYPE";
                $.ajax({
                	url: '${pageContext.request.contextPath}/loadschemebusinessline',
                    data: ({bline : lovtype}),
                    success: function(data) {
                    	var select = $('#scheme_business_line');
                        select.find('option').remove();
                            
                        if(schemetyp == "CN59") {
                        	$('<option>').val("").text("--Select--").appendTo(select);
                            $.each(data, function(index, value) {
                            	if(value == "CN59") {
                            		$('<option>').val(value).text(value).appendTo(select);
                            	}
                            });
                        }else {
                        	$('<option>').val("").text("--Select--").appendTo(select);
                            $.each(data, function(index, value) {
								$('<option>').val(value).text(value).appendTo(select);
                            });
                        }
                        
                        GenerateCode();
                    }
                });
            	 
          /*   }); */
          
                if(schemetyp == "National"){
					$('#Hierarchy_level_div').show();
                	
                	var select = $('#scheme_level');
                	select.find('option').remove();
                	$('<option>').val("Level1").text("Level 1").appendTo(select);
                	
                }else if(schemetyp == "Regional"){
                	$('#Hierarchy_level_div').show();
                	
                	var select = $('#scheme_level');
                	select.find('option').remove();
                	$('<option>').val("Level1").text("Level 1").appendTo(select);
                	$('<option>').val("Level2").text("Level 2").appendTo(select);
                	
                }else if(schemetyp == "Branch"){
                	$('#Hierarchy_level_div').show();
                	
                	var select = $('#scheme_level');
                	select.find('option').remove();
                	$('<option>').val("Level1").text("Level 1").appendTo(select);
                	$('<option>').val("Level2").text("Level 2").appendTo(select);
                	$('<option>').val("Level3").text("Level 3").appendTo(select);
                }
                
                //Hierarchy_level                
                
                
            }); 


            var lovtype = "SCHEME_TYPE";
            $.ajax({
            	url: '${pageContext.request.contextPath}/loadschemetype',
                data: ({scheme : lovtype}),
                success: function(data) {
                	var select = $('#scheme_type');
                    select.find('option').remove();
                    $.each(data, function(index, value) {
                    	if(value == 'DEALER')  
                        {
     						$('<option selected>').val(value).text(value).appendTo(select);

                        }else{
         					$('<option>').val(value).text(value).appendTo(select);

                        }
							
                    });

                }
            });

             
            var custype = "PRNT_CUST_TYPE";
            $.ajax({
            	url: '${pageContext.request.contextPath}/loadcusttype',
                data: ({custype : custype}),
                success: function(data) {
                	var select = $('#attribute3');
                    select.find('option').remove();
                    $.each(data, function(index, value) {
                    	var nos = '';
                        var custypeno = value;
                        	                          	
                        $('<option>').val(value.ITEM_CODE).text(value.ITEM_CODEDESCRIPTION).appendTo(select);

                        	
                    });

                }
            });
             
            $(document).on('change','#scheme_business_line',function(){ 
           /*  $('#scheme_business_line').change(function(event) { */
            	var scheme_business_line = $("select#scheme_business_line").val();
            	var scheme_fin_yr = $("select#scheme_fin_yr").val();
            	$.ajax({
            		url: '${pageContext.request.contextPath}/getparentschemename',	
            	    data: ({sbl : scheme_business_line,sfy : scheme_fin_yr}),
            	    success: function(data) {				        	
            	    	
            	    	var select = $('#parent_scheme_code');
            	    	select.find('option').remove();
            	    	$('<option>').val("").text("--Select--").appendTo(select);
            	        $.each(data, function(index, value) {	
            	        	$('<option>').val(value.scheme_id).text(value.scheme_name).appendTo(select);
            	           		 
            	    	});

            	    }
            	});
            });
             
            $(document).on('change','#scheme_fin_yr',function(){
           /* 	$('#scheme_fin_yr').change(function(event) { */
            	var scheme_business_line = $("select#scheme_business_line").val();
            	var scheme_fin_yr = $("select#scheme_fin_yr").val();
            	$.ajax({
            		url: '${pageContext.request.contextPath}/getparentschemename',	
            	    data: ({sbl : scheme_business_line,sfy : scheme_fin_yr}),
            	    success: function(data) {				        	
            	    	
            	    	var select = $('#parent_scheme_code');
            	    	select.find('option').remove();
            	    	$('<option>').val("").text("--Select--").appendTo(select);
            	        $.each(data, function(index, value) {	
            	        	$('<option>').val(value.scheme_id).text(value.scheme_name).appendTo(select);
            	           		 
            	    	});

            	    }
            	});
            });
             
            $(document).on('change','#scheme_fin_month',function(){
           	/* $('#scheme_fin_month').change(function(event) { */
            	var scheme_business_line = $("select#scheme_business_line").val();
            	var scheme_fin_yr = $("select#scheme_fin_yr").val();
            	$.ajax({
            		url: '${pageContext.request.contextPath}/getparentschemename',	
            	    data: ({sbl : scheme_business_line,sfy : scheme_fin_yr}),
            	    success: function(data) {				        	
            	    	
            	    	var select = $('#parent_scheme_code');
            	    	select.find('option').remove();
            	    	$('<option>').val("").text("--Select--").appendTo(select);
            	        $.each(data, function(index, value) {	
            	        	$('<option>').val(value.scheme_id).text(value.scheme_name).appendTo(select);
            	           		 
            	    	});

            	    }
            	});
            });

         // Load DS Region   
         $.ajax({
         	url: '${pageContext.request.contextPath}/loadDSRregion',
             success: function(data) {
             	var select = $('#appl_regn_code');
                 select.find('option').remove();
					$('<option>').val("").text("--select--").appendTo(select);
           	    $.each(data, function(index, value) {
						$('<option>').val(value).text(value).appendTo(select);
                 });

             }
         });
         
         $(document).on('change','#appl_regn_code',function(){
        	   // alert('Change Happened');
        	    var region = $('#appl_regn_code').val();
     			 var Region = ""+region+"";
     			 
           	 //var region = $("select#appl_regn_code").val();
           	  var regn_select = $('#sel_regn');
           	 $('<option selected>').val(Region).text(Region).appendTo(regn_select);
              
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
         
        
    
        /*  $('#appl_regn_code').change(function(event) {
         	
        	 alert("In change event");
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


         }); */
         
         
         
         
         var arr = [];
         var arr2 = [];
         
        $(document).on('change','#depot',function(){
        /*  $('#depot').change(function(event) { */
         	
		 var region = $('#depot').val();
		 var Region = ""+region+"";   
		
		 if(region == '179')
		 {
			 loadLevel();
			 $('#level').change(function(event) {
			     	
				 var region = $('#level').val();
				 var Region = ""+region+"";   
				
				
				 
				 var e = document.getElementById("level");
				 var strUser = e.options[e.selectedIndex].text;
				 var Region2 = ""+strUser+""; 
				 
				
				 
				 $("#level option:selected").each(function () {
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
				
		 }else{
		 
		 var e = document.getElementById("depot");
		 var strUser = e.options[e.selectedIndex].text;
		 var Region2 = ""+strUser+""; 
		 var select = $('#level');
		 select.find('option').remove();
		 $('<option>').val('NA').text('NA').appendTo(select);
		select.prop("disabled", "disabled");
		 
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
         }
		 });
         
         $(document).on('change','#attribute1',function(){
            /* $('#attribute1').change(function(event) { */
            	var schprod = $("select#attribute1").val();

                if(schprod == "1") {
					$("#attribute2").val("New Product + New Scheme");
				}else if(schprod == "2") {
					$("#attribute2").val("New Product + Existing Scheme");
				}else if(schprod == "3") {
					$("#attribute2").val("Existing Product + New Scheme");
					
				}else if(schprod == "4") {
					$("#attribute2").val("Existing Product + Existing Scheme");
				}else {
					$("#attribute2").val("");
				}
                    
				if(schprod != "") {
						

                    var sc_name=document.getElementById("scheme_name").value;

                    var sc_id=document.getElementById("scheme_id").value;

                  	window.open("primaryfinancialanalysis?scheme_name="+sc_name+"&scheme_id="+sc_id+"&schprod="+schprod,"Ratting","width=750,height=550,left=100,top=100,toolbar=0,status=0,");
				}

       		});
                
           
              	
                

        });
         
        $(document).on('change','#cust_type',function(){
       	 var cust_type = $('#cust_type').val();
       	 var select = $('#cust_type_s');
       	 if(cust_type == 'All')
       		 {
	       		 $('<option selected>').val('15').text('Prolinks-Industrial').appendTo(select);
	       		 $('<option selected>').val('3').text('Ultratech Dealer(3)').appendTo(select);
	       		 $('<option selected>').val('4').text('Prolinks Dealer(4)').appendTo(select);
	       		 $('<option selected>').val('5').text('Dealer(5)').appendTo(select);
	       		 $('<option selected>').val('54').text('Retail Special Dealer').appendTo(select);
	       		 $('<option selected>').val('55').text('Retail Site Operations').appendTo(select);
	       		 $('<option selected>').val('56').text('Non Paint Dealer-CC').appendTo(select);
	       		 $('<option selected>').val('57').text('PXT Dealer(57)').appendTo(select);
	       		 $('<option selected>').val('58').text('Distributor-Retail').appendTo(select);
	       		 $('<option selected>').val('53').text('Wholesaler(53)').appendTo(select);
	       		 $('<option selected>').val('6').text('Contractor(6)').appendTo(select);
	       		 $('<option selected>').val('65').text('Retail Projects Strong').appendTo(select);
	       		 $('<option selected>').val('7').text('Alternate Distribution(7)').appendTo(select);
	       		 $('<option selected>').val('1001').text('Sales').appendTo(select);
	       		 $('<option selected>').val('66').text('Prolinks Special Dealer(66)').appendTo(select);
       		 }else if(cust_type == 'select')
       			 {
       			
       			 	select.find('option').remove();	
       			 }/* else
       				 {
       				 $('<option selected>').val(cust_type).text(cust_type).appendTo(select);
       				 } */
       			 
       		 });

       $(document).ready(function(){    
        	
        	GenerateCode();
        	
              AddRow();
              AddRow1();
              AddRow2();
              

        });
 
    </script>

<script>

    function submitform()
    {
    	
    	
    	
    	var scheme_budget = $('#scheme_budget').val();
    	var fin_analysis_flag = $('#fin_analysis_flag').val();
    	$("form").submit(function(){
    		  if(scheme_budget == "0" && fin_analysis_flag == "N") {
    			  alert('Scheme Provision cannot be 0. Please provide proper value.');
    		     return false;
    		  } 
    		  else {
    			  var aa = confirm('Do you want to create this scheme?');

    		         if(aa == true)
    		         {

    			  this.submit();
    	             }
    		         else {

    		             return false;
    	             }

    		  }
    		});
    	
    }

    </script>
<script>
    function addbudget()
    {
    	 var budget=document.getElementById("manual_provision").value;

         document.getElementById("scheme_budget").value=budget; 
    }
    
    function checkstart()
    {
    	//alert("In checkStart");
    	var start_date=$('#start_date').val();
		 var end_date=$('#end_date').val();
		
		 if(end_date==null || end_date==0)
			 {
			 var a1= start_date.substr(0,4);
			 var a2 = start_date.substr(5,6);
			 var a3 = start_date.substr(8,10);				
			 var q="-";				
			 var str1=a1.concat(q);		
			 var str2=str1.concat(a2.substr(0,2).concat(q));			
		     var str3=str2.concat(a3);
		    
			 var dateOne = new Date(str3);
			// alert("in date checking :    date one is "+dateOne)
			 }
		 else
			 {
			 var a1= start_date.substr(0,4);
			 var a2 = start_date.substr(5,6);
			 var a3 = start_date.substr(8,10);				
			 var q="-";				
			 var str1=a1.concat(q);		
			 var str2=str1.concat(a2);			
		     var str3=str2.concat(a3);
									
				//commising
			 var b1= end_date.substr(0,4);
			 var b2 = end_date.substr(5,6);
			 var b3 = end_date.substr(8,10);			
			 var str5=b1.concat(q);		
			 var str6=str5.concat(b2);			
			 var str7=str6.concat(b3);							
						
			var dateOne = new Date(str3);
			
			var dateTwo = new Date(str7);
			//alert("Date one is:"+dateOne);
			//alert("Date two is:"+dateTwo);
			 if ( dateOne <= dateTwo )
			     {
				   			 			         
			      }	else {	
			    	  			alert("Please Check Start Date should be less than End Date");
								$('#start_date').val("");
								 $('#end_date').val("");
								 $('#redemption_date').val("");
					 	 }
			 }
		    	
    }
    
    </script>


<script>       

        	
        	
function changedateformat2(){
	/* var to_date=document.getElementById("end_date").value;
	
	var mm = to_date.substring(0,2);
	var dd = to_date.substring(3,5);
	var yy = to_date.substring(6,10);
	
	document.getElementById("end_date").value = dd+"-"+mm+"-"+yy; */
}
	
</script>

<script>
function checkattend()
{
		//alert("in attend");
	 var start_date=$('#start_date').val();
	 //alert(start_date);
	 var end_date=$('#end_date').val();
	 //alert(end_date);
	 if(start_date!=null )
		 {
		//installation	 
		 var s1= start_date.substr(0,4);
		 var s2 = start_date.substr(5,6);
		 var s3 = start_date.substr(8,10);
		
		var q="-";				
		var str1=s1.concat(q);		
		var str2=str1.concat(s2.substr(0,2).concat(q));	
		var str3=str2.concat(s3);
			
//commising
		var b1= end_date.substr(0,4);
		 var b2 = end_date.substr(5,6);
		 var b3 = end_date.substr(8,10);			
		 var str5=b1.concat(q);		
		var str6=str5.concat(b2.substr(0,2).concat(q));			
		var str7=str6.concat(b3);

		var dateOne = new Date(str3);
       var dateTwo = new Date(str7);
		
       if ( dateOne <= dateTwo )
       {
    	
    	   var a=document.getElementById("end_date").value;
         
           var month=a.substring(5,7);
          
           var year=a.substring(0,4);
           
           var day = ${redemption_day};
          
           if(month=="01")
               {
               var a1=day+"-02-"+year;
              
               document.getElementById("redemption_date").value=a1;
               }else if(month=="02")
               {
                   var a1=day+"-03-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="03")
               {
                   var a1=day+"-04-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="04")
               {
                   var a1=day+"-05-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="05")
               {
                   var a1=day+"-06-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="06")
               {
                   var a1=day+"-07-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="07")
               {
                   var a1=day+"-08-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="08")
               {
                   var a1=day+"-09-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="09")
               {
                   var a1=day+"-10-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="10")
               {
                   var a1=day+"-11-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="11")
               {
                   var a1=day+"-12-"+year;
   document.getElementById("redemption_date").value=a1;
               }else if(month=="12")
               {
               	year = parseInt(year) + 1;
                   var a1=day+"-01-"+year;
   document.getElementById("redemption_date").value=a1;
               }else {
               	document.getElementById("redemption_date").value="";
               }
	         
        }

		else {		       
			alert("Please Check Start Date should be less than End Date");	
				$('#end_date').val("");
				$('#redemption_date').val("");
		     }

		 }else
			 {
			 alert("Please check Invoice date first");
			 
			 } 
	 
	checkdate();
	
       }
</script>


<script>
$(window).load(function(){

    var fullDate = new Date();

     var n = fullDate.toString();
    var m=n.substring(4,7);

    var twoDigitMonth=0;

    if(m=='Jan' || m=='an')
        {
        twoDigitMonth=01;
        }else if(m=='Feb' || m=='eb')
            {
            twoDigitMonth=02;
            }else if(m=='Mar' || m=='ar'){
                twoDigitMonth=03;
            }else if(m=='Apr' || m=='pr'){
                twoDigitMonth=04;
            }else if(m=='May' || m=='ay'){
                twoDigitMonth=05;
            }else if(m=='Jun' || m=='un'){
                twoDigitMonth=06;
            }else if(m=='Jul' || m=='ul'){
                twoDigitMonth=07;
            }else if(m=='Aug' || m=='ug'){
                twoDigitMonth=08;
            }else if(m=='Sep' || m=='ep'){
                twoDigitMonth=09;
            }else if(m=='Oct' || m=='ct'){
                twoDigitMonth=10;
            }else if(m=='Nov' || m=='ov'){
                twoDigitMonth=11;
            }else if(m=='Dec' || m=='ec'){
                twoDigitMonth=12;
            }else{}



    var twoDigitDate = fullDate.getDate()+"";
    if(twoDigitDate.length==1)    twoDigitDate="0" +twoDigitDate;

    var currentDate = twoDigitDate + "-" + twoDigitMonth + "-" + fullDate.getFullYear();

    document.getElementById("created_on").value=currentDate;
    //alert(currentDate);
});

</script>



<script>
$(window).load(function(){
	
	/* var schemetyp = $("scheme_type").val();
	
	alert("schemetyp----->>"+schemetyp);
	
	 if(schemetyp == "National"){
     	$('#Hierarchy_level_div').hide();
     }else if(schemetyp == "Regional"){
     	$('#Hierarchy_level_div').show();
     	
     	var select = $('#scheme_level');
     	select.find('option').remove();
     	$('<option>').val("Level1").text("Level 1").appendTo(select);
     	$('<option>').val("Level2").text("Level 2").appendTo(select);
     	
     }else if(schemetyp == "Branch"){
    	  */
    	 
     	$('#Hierarchy_level_div').show();
     	
     	var select = $('#scheme_level');
     	select.find('option').remove();
     	$('<option>').val("Level1").text("Level 1").appendTo(select);
     	$('<option>').val("Level2").text("Level 2").appendTo(select);
     	$('<option>').val("Level3").text("Level 3").appendTo(select);
    // }
	
});


</script>