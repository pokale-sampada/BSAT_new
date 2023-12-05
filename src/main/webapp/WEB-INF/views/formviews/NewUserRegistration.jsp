<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">User Registration</h4>

				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">User Management</a></li>
					<li class="breadcrumb-item"><a href="#!">User Registration</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<form id="Regi" action="NewRegistration" class="form-horizontal"
	method="post">
	<div class="card">
		<div class="card-header">
			<h5>User Credentials</h5>
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
					<label class="block">User Name<span class="required">*</span></label>
					<input type="text" name="user_name" id="user_name"
						pattern="[A-Z,a-z,0-9]{1,25}"
						title="only number, uppercase and lowercase letters allowed"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: John Doe" required />
				</div>
				<div class="col-md-3">
					<label class="block">Password <span class="required">*</span></label>
					<input type="Password" name="password" id="password1"
						pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{8,}"
						title="Must contain at least one number, one symbol and one uppercase and lowercase letter, and at least 8 or more characters"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: John Doe" required />
				</div>
				<div class="col-md-3">
					<label class="block">Confirm Password <span
						class="required">*</span></label> <input type="Password" name="password1"
						id="password2" onblur="CheckPassword()"
						pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{8,}"
						title="Must contain at least one number, one symbol and one uppercase and lowercase letter, and at least 8 or more characters"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: John Doe" required />
				</div>

				<div class="col-md-3">
					<label class="block" for="inputSuccess">Menu Group</label> <select
						data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="menu_group_id" id="menu_group_id" onchange="fillmainmenu()"
						data-plugin-options='{ "placeholder": "Select a State", "allowClear": true }'
						required>
						<option>--Select--</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="inputSuccess">User Profile <span
						class="required">*</span>
					</label> <select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="profile_id" id="profile_id"
						data-plugin-options='{ "placeholder": "Select a State", "allowClear": true }'>
						<option>--Select--</option>
					</select>

				</div>

				<input type="hidden" id="user_type" name="user_type">


				<%-- <div class="col-md-3" id="activeDiretory">
					<label class="block" for="inputSuccess">Link Active
						Directory</label> <select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="active_directory_id" id="active_directory_id" array="ADList"
						data-plugin-options='{ "placeholder": "Select a State", "allowClear": true }'>
						<option value="">--Select--</option>
						<c:forEach var="adID" items="${ADList}">
							<option value="${adID.ad_id}">
								<c:out value="${adID.ad_id}" />
							</option>
						</c:forEach>

					</select>
				</div> --%>

				<div class="col-md-3" id="activeDiretory">
					<label class="block" for="inputSuccess">Active Group</label> <select
						data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="active_directory_id" id="active_directory_id" array="ADList"
						data-plugin-options='{ "placeholder": "Select a State", "allowClear": true }'>
						<option value="">--Select--</option>
						<option value="">Outside Permanent Member</option>
						<option value="">Inside Permanent Member</option>
						<option value="">Inside Contract Member</option>
						<%-- <c:forEach var="adID" items="${ADList}">
							<option value="${adID.ad_id}">
								<c:out value="${adID.ad_id}" />
							</option>
						</c:forEach>  --%>

					</select>


				</div>

				<div class="col-md-4">
					<label class="block">Status</label> <input
						class="form-control form-control-sm form-control-primary"
						id="active" type="hidden" name="active" />
					<div class="form-check form-switch">
						<br> <input type="checkbox" name="user_status"
							id="user_status" class="js-primary" data-switchery="true"
							onchange="CheckUserStatus()" />
					</div>


				</div>

				<!-- 	<div class="col-md-3">
					<label class="block" for="inputSuccess">Sub Menu</label> <select
						data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="sub_menu" id="sub_menu"
						data-plugin-options='{ "placeholder": "Select a State", "allowClear": true }'
						required>
						<option>--Select--</option>
					</select>
				</div> -->

				<div class="form-group row">
					<div class="col-md-12">
						<br> <br>
						<table>
							<tr>
								<td><label
									class="col-sm-6 control-label no-padding-top blue"
									style="margin-left: 35%; margin-top: -5%" for="duallist"
									id="am"> Available Menu </label></td>
								<td><label
									class="col-sm-6 control-label no-padding-top blue"
									style="margin-left: 35%; margin-top: -5%" for="duallist"
									id="sm"> Selected Header Menu  </label></td>
								<td><label
									class="col-sm-6 control-label no-padding-top blue"
									style="margin-left: 45%; margin-top: -5%" for="duallist"
									id="sm1"> Sub Menu </label></td>

							</tr>
							<tr>

								<td><button type="button" class="btn btn-primary next"
										id="addall">Add All</button> <select multiple
									class="form-control form-control-sm " name="available_menu"
									id="available_menu" required>
								</select></td>
								<td><button type="button" class="btn btn-primary previous"
										id="removeall">Remove All</button> <select multiple
									class="form-control form-control-sm " name="sel_menu"
									id="sel_menu">
								</select></td>
								<td><button type="button" class="btn btn-primary previous" id="ankita">Available Sub Menu</button> <!-- <select multiple class="form-control form-control-sm " name="sub_menu2" id="sub_menu2"></select>-->
									<select  multiple class="form-control select-checkbox" id="mySelect" name="mySelect" required></select></td>
							</tr>
						</table> 

						<!-- <div class="col-sm-12">
							<select multiple="multiple" size="10" class="dual1"
								name="appl_menu_multiple_select" id="appl_menu_multiple_select">

							</select>
						</div> -->
					</div>
				</div>
				<!-- <select multiple class="form-control select-checkbox" size="20"
					id="mySelect" name="mySelect">
				</select> -->
			</div>
			<div id="deporegion" class="form-group row">
				<div class="col-md-4">
					<label class="block">Region<span class="required">*</span></label>
					<input type="text" name="region_code" id="region_code"
						class="form-control form-control-sm form-control-primary" />
				</div>
				<div class="col-md-4">
					<label class="block">Distributors Code<span
						class="required">*</span></label> <input type="text" name="depot_code"
						id="depot_code"
						class="form-control form-control-sm form-control-primary" />
				</div>
				<div class="col-md-4">
					<label class="block">Territory Code<span class="required">*</span></label>
					<input type="text" name="terr_code" id="terr_code"
						class="form-control form-control-sm form-control-primary" />
				</div>

			</div>

			<div id="marketingsuper" class="form-group row">
				<div class="col-md-6">
					<label class="block">Marketing Supervisor <span
						class="required">*</span></label> <input type="text" name="supervisor_id"
						id="supervisor_id"
						class="form-control form-control-sm form-control-primary" />
				</div>
				<div class="col-md-6">
					<label class="block">Territory Code<span class="required">*</span></label>
					<input type="text" name="pmg_ml_group" id="pmg_ml_group"
						class="form-control form-control-sm form-control-primary" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-6" id="start">
					<spring:bind path="lookup.active_start_date">
						<label class="block">Start Date <span class="required">*</span></label>
						<div class="input-group input-append date">

							<input type="text"
								class="form-control form-control-sm form-control-primary datePicker"
								id="start_date" data-plugin-datepicker name="start_date"
								data-date-format="dd-mm-yyyy" onchange="checkattend()" /> <span
								class="input-group-addon"> <i class="fa fa-calendar"></i>
							</span>
						</div>
					</spring:bind>
				</div>

				<div class="col-md-6" id="end">
					<spring:bind path="lookup.active_end_date">
						<label class="block"> End Date <span class="required">*</span></label>
						<div class="input-group input-append date" id="datePicker1">

							<input type="text"
								class="form-control form-control-sm form-control-primary"
								id="end_date" data-plugin-datepicker name="end_date"
								data-date-format="dd-mm-yyyy" readonly /> <span
								class="input-group-addon"> <i class="fa fa-calendar"></i>
							</span>
						</div>
					</spring:bind>
				</div>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header">
			<h5>User Personal Information</h5>
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
				<input name="user_id" id="user_id" type="hidden" />
				<div class="col-md-4">
					<label class="block">First Name<span class="required">*</span></label>
					<input type="text" name="first_name" id="first_name"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: John" required />

				</div>

				<div class="col-md-4">
					<label class="block">Middle Name</label> <input type="text"
						name="middle_name" id="middle_name"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: Mike" />

				</div>

				<div class="col-md-4">
					<label class="block">Last Name</label> <input type="text"
						name="last_name" id="last_name"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: Doe" />

				</div>

			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block">Contact Number</label> <input type="text"
						name="contact_number" id="contact_number"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: 123" />

				</div>
				<div class="col-md-4">
					<label class="block">E-mail Address<span class="required">*</span></label>
					<input type="email" name="email_address" id="email_address"
						onblur="validateEmail(this);"
						class="form-control form-control-sm form-control-primary"
						placeholder="eg.: JohnDoe@ABC" required />

				</div>
				<div class="col-md-4"></div>

			</div>
		</div>
	</div>
	<footer class="panel-footer">
		<div class="row" style="text-align: center">
			<div class="col-md-12">
				<button type="submit" class="btn btn-sm btn-primary"
					onclick="return confirmValidate()">Submit</button>
				<button type="reset" class="btn btn-sm btn-default">Reset</button>
			</div>
		</div>
	</footer>
</form>
<link rel="stylesheet" type="text/css"
	href="files\bower_components\duallistbox\bootstrap-duallistbox.css">
<script
	src="files\bower_components\duallistbox\jquery.bootstrap-duallistbox.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	$(document).ready(function(event) {
		var v = "${success}";
		if (v == "success") {

			swal({
				title : "Done",
				text : "New User has been created Successfully!",
				icon : "success"
			}).then(function() {

			});
		}
		if (v == "error") {

			swal({
				title : "Error!",
				text : "somthing went wrong.System can not deleted document!",
				icon : "error"
			}).then(function() {

			});
		}

	});
</script>

<script type="text/javascript">



	function submenue(e, e1) {
		
		$.ajax({
			url : '${pageContext.request.contextPath}/submenu',
			data : ({
				name : e

			}),
			success : function(data) {
				
				var select = $('#mySelect');
				var group = $('<optgroup id="'+e+'" label="' + e1 + '" />');
				$.each(data,function(id, name) {

					  $('<option type="checkbox" />').val(id).text(name).appendTo(group);
					//$('<option />').val(value).text(value).appendTo(group);
				});
				group.appendTo(select);
				
		 	 /* 	$("optgroup > option").mousedown(function(e) {
			 		//alert('mousedown clicked');
				    e.preventDefault();
				    $(this).prop('selected', $(this).prop('selected') ? false : true);
				    var self = this;
				    $(this).parent().focus();
				    setTimeout(function() {
				        $(self).parent().scrollTop(originalScrollTop);
				    }, 0);
				    
				    return false;
				});   */
				
				
				
				
				$('optgroup > option').mousedown(function(e) {
				    e.preventDefault();
				    var originalScrollTop = $(this).parent().parent().scrollTop();
				  	$(this).prop('selected', $(this).prop('selected') ? false : true);
				    var self = this;
				    $(this).parent().parent().focus();
				    setTimeout(function() {
				        $(self).parent().parent().scrollTop(originalScrollTop);
				        
				    }, 0);
				  	
				  	return false;
				});
			 	
			 	
			 	  /*    $("optgroup > option").one('click', function (event) {  
			 	           event.preventDefault();
			 	           //do something
			 	           $(this).prop('disabled',false);
			 	     }); */
			 	
 
				

			}
		});
	};

	
</script>
<
<script type="text/javascript">
	/* var opt = {
	 friendchat:[
	 {name:"somefriend1"},
	 {name:"somefriend2"}
	 ],
	 otherchat:[
	 {name:"someother1"},
	 {name:"someother2"}
	 ],
	 friendrequest:[
	 {name:"somerequest1"},
	 {name:"somerequest2"}
	 ],
	 sentrequest:[
	 {name:"somesent1"},
	 {name:"somesent2"}
	 ]
	 }; */

	/* 	$(function(){
	 var $select = $('#mySelect');
	 $.each(opt, function(key, value){
	 var group = $('<optgroup label="' + key + '" />');
	 $.each(value, function(){
	 $('<option />').html(this.name).appendTo(group);
	 });
	 group.appendTo($select);
	 });
	 }); */
</script>
<script type="text/javascript">
	function fillmainmenu() {
		var valueSelected = document.getElementById("menu_group_id").value;
		$.ajax({
			url : '${pageContext.request.contextPath}/testmenu',
			data : ({
				name : valueSelected

			}),
			success : function(data) {
				var select = $('#available_menu');
				select.find('option').remove();
				var myselect = $('#mySelect');
				myselect.empty();
				$.each(data, function(index, value) {

					$('<option>').val(value.menu_header_id).text(
							value.header_name).appendTo(select);

					$("#sel_menu").empty();

				});

			}
		});
	}
	$(document).ready(function() {
		
						$(document).on('click','#available_menu',function(e) {

											var optionSelected = $("option:selected", this);
											if(optionSelected.length == 1){
												var valueSelected = this.value;
												let html = $("#available_menu option:selected").text();
												submenue(valueSelected, html);																								
												var available_menu = $('#available_menu').val();
												var menu = "" + available_menu + "";
                                                var selected_menu = $('#sel_menu');
                                                if (menu != selected_menu) {
													if (html != "") {
														$('<option selected>').val(menu).text($("#available_menu option:selected").text()).appendTo(selected_menu);
													}
													$('#available_menu option:selected').remove();
												}	
                                                
                                             

                                                
											}
										});

						$(document).on('click','#sel_menu',function(e) {
											var optionSelected = $("option:selected", this);
											    if(optionSelected.length==1){
													var valueSelected = this.value;
													let htm = $("#sel_menu option:selected").text();
													
													var sel_menu = $('#sel_menu').val();													                                                    
													var menu = "" + sel_menu + "";
													var selected_menu2 = $('#available_menu');																
													if (menu != selected_menu2) {
														if (htm != "") {
															 $('<option selected>').val(menu).text($("#sel_menu option:selected").text()).appendTo(selected_menu2);
														}
														$('#sel_menu option:selected').remove();			
														const element = document.getElementById(valueSelected);														
														element.remove();
													}	
												
                                                    //$('#sel_menu option:selected').remove();
													$("#sel_menu option").each(function() {
														$(this).prop('selected',true);
													});
													$("#available_menu option").each(function() {
														$(this).prop('selected',false);
												    });
												} 
									

										});
						
						
						
						function confirmValidate() {
							var sel_menu = $('#sel_menu').val();
							var sel_menu2 = $('#available_menu').val();

							if (document.getElementById("active_directory_id").value == ""
									&& document.getElementById("password1").value == ""
									&& document.getElementById("password2").value == "") {
								alert("Please enter password or select Active Directory ID");
								return false;
							} else if ((document.getElementById("password1").value == "" && document
									.getElementById("password2").value != "")
									|| (document.getElementById("password1").value != "" && document
											.getElementById("password2").value == "")) {
								alert("Password doesn't matched");
								return false;
							} else {
								return true;
							}
						}

					});

	
	$(window)
			.load(
					function() {

						$("#deporegion").hide();
						$("#marketingsuper").hide();
						$("#start").hide();
						$("#end").hide();

						$
								.ajax({
									url : '${pageContext.request.contextPath}/loadmenugroupname',

									success : function(data) {

										var select = $('#menu_group_id');
										// alert(select);
										select.find('option').remove();
										$('<option>').val("")
												.text("--select--").appendTo(
														select);
										$.each(data, function(index, value) {
											$('<option>').val(
													value.menu_group_id).text(
													value.group_name).appendTo(
													select);
										});

									}
								});

						$
								.ajax({
									url : '${pageContext.request.contextPath}/loaduserprofile',

									success : function(data) {
										var select = $('#profile_id');
										// alert(select);
										select.find('option').remove();
										$('<option>').val("")
												.text("--select--").appendTo(
														select);
										$.each(data, function(index, value) {
											$('<option>').val(value.profile_id)
													.text(value.profile_name)
													.appendTo(select);
										});

									}
								});

						$
								.ajax({
									url : '${pageContext.request.contextPath}/loadregioncode',
									success : function(data) {

										var select = $('#region_code');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$.each(data, function(index, value) {

											$('<option>').val(value)
													.text(value).appendTo(
															select);

										});

									}
								});

						var selectdepo = $('#depot_code');
						selectdepo.find('option').remove();
						$('<option>').val("").text("--Select--").appendTo(
								selectdepo);

						$
								.ajax({
									url : '${pageContext.request.contextPath}/loadsupervisor',
									success : function(data) {

										var select = $('#supervisor_id');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$.each(data, function(index, value) {

											$('<option>').val(value.user_id)
													.text(value.user_name)
													.appendTo(select);

										});

									}
								});

						var lovtype = "BLINE_TYPE";
						$
								.ajax({
									url : '${pageContext.request.contextPath}/loadbusinessline',
									data : ({
										bline : lovtype
									}),
									success : function(data) {
										var select = $('#pmg_ml_group');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$.each(data, function(index, value) {
											$('<option>').val(value)
													.text(value).appendTo(
															select);
										});

									}
								});

					});

	// 	window.onload=function()
	// 	{

	// 	$("#deporegion").hide();

	// 	}

	$('#profile_id')
			.change(
					function(event) {
						var profile_id = $("select#profile_id").val();
						$("#regn_tsi").hide();
						if (profile_id != "") {

							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadusertype',
										data : ({
											profile_id : profile_id
										}),
										success : function(data) {

											$('#user_type').val(data);

										}
									});
						} else {
							$('#user_type').val("");
						}

						if (profile_id == "2" || profile_id == "5"
								|| profile_id == "1" || profile_id == "12") {

							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadsupervisor',
										success : function(data) {

											var select = $('#supervisor_id');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
											$
													.each(
															data,
															function(index,
																	value) {

																$('<option>')
																		.val(
																				value.user_id)
																		.text(
																				value.user_name)
																		.appendTo(
																				select);

															});

										}
									});

							var lovtype = "BLINE_TYPE";
							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadbusinessline',
										data : ({
											bline : lovtype
										}),
										success : function(data) {
											var select = $('#pmg_ml_group');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
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

							$("#marketingsuper").hide();

							$("#deporegion").show();

						} else if (profile_id == "6") {

							var selectdepo = $('#depot_code');
							selectdepo.find('option').remove();
							$('<option>').val("").text("--Select--").appendTo(
									selectdepo);

							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadregioncode',
										success : function(data) {

											var select = $('#region_code');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
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

							$("#marketingsuper").show();

							$("#deporegion").hide();

						} else {

							var selectdepo = $('#depot_code');
							selectdepo.find('option').remove();
							$('<option>').val("").text("--Select--").appendTo(
									selectdepo);

							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadregioncode',
										success : function(data) {

											var select = $('#region_code');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
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

							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadsupervisor',
										success : function(data) {

											var select = $('#supervisor_id');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
											$
													.each(
															data,
															function(index,
																	value) {

																$('<option>')
																		.val(
																				value.user_id)
																		.text(
																				value.user_name)
																		.appendTo(
																				select);

															});

										}
									});

							var lovtype = "BLINE_TYPE";
							$
									.ajax({
										url : '${pageContext.request.contextPath}/loadbusinessline',
										data : ({
											bline : lovtype
										}),
										success : function(data) {
											var select = $('#pmg_ml_group');
											select.find('option').remove();
											$('<option>').val("").text(
													"--Select--").appendTo(
													select);
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

							$("#marketingsuper").hide();
							$("#deporegion").hide();
						}

						if (profile_id == "5") {
							$("#regn_depo").hide();
						}
						if (profile_id == "12") {
							$("#regn_depo").show();
							$("#regn_tsi").show();
						}
					});

	$('#region_code').change(
			function(event) {
				var region_code = $("select#region_code").val();
				$.ajax({
					url : '${pageContext.request.contextPath}/loaddepotcode',
					data : ({
						region_code : region_code
					}),
					success : function(data) {

						var select = $('#depot_code');
						select.find('option').remove();
						$('<option>').val("").text("--Select--").appendTo(
								select);
						$.each(data, function(index, value) {

							$('<option>').val(value.depot_code).text(
									value.depot_name).appendTo(select);

						});

					}
				});

			});

	$('#depot_code').change(
			function(event) {
				var profile_id = $("select#profile_id").val();
				var region_code = $("select#region_code").val();
				var depot_code = $("select#depot_code").val();
				$.ajax({
					url : '${pageContext.request.contextPath}/loadtsicode',
					data : ({
						depot_code : depot_code
					}),
					success : function(data) {

						var select = $('#terr_code');
						select.find('option').remove();
						$('<option>').val("").text("--Select--").appendTo(
								select);
						$.each(data, function(index, value) {
							region_code

							$('<option>').val(value.terr_code).text(
									value.terr_name).appendTo(select);

						});

					}
				});

			});
	$("#available_menu").removeAttr("required");
	$('#user_name').blur(function() {
		var UserName = $('#user_name').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/FindUserPresence',
			data : ({
				UserName : UserName
			}),
			success : function(data) {

				var r;

				if (data.name != null) {

					document.getElementById("user_name").value = "";

				}

			}
		});
	});
</script>
<script type="text/javascript">
	$('#sub_menu').on('change',function(e) {
				var optionSelected = $("option:selected", this);
				var valueSelected = this.value;
				$.ajax({
					url : '${pageContext.request.contextPath}/submenu',
					data : ({
						name : valueSelected
					}),
					success : function(data) {
						var select = $('#available_menu');
						select.find('option').remove();
						$.each(data, function(index, value) {
							$('<option>').val(value.menu_header_id).text(value.header_name).appendTo(select);
							$("#sel_menu").empty();
						});

					}
				});
			});
</script>

<script type="text/javascript">
	$("#addall").click(function() {
		$('#sel_menu').append($("#available_menu > option"));
		$('#sel_menu > option').prop('selected', true);
		$("#available_menu").empty();
		
	
			
			$("#sel_menu option").each(function() {
			    var optionSelected = $("#sel_menu > option",this);
				var valueSelected = this.value;
				var html = this.text;
				//let html = $("#sel_menu option:selected").text();
				submenue(valueSelected, html);	
			});
	});

	$("#removeall").click(function() {
		$('#available_menu').append($("#sel_menu > option"));
		$('#available_menu > option').prop('selected', false);
		$("#sel_menu").empty();
		$("#mySelect").empty();
	});

	function CheckPassword() {
		var pass1 = $('#password1').val();
		var pass2 = $('#password2').val();

		if (pass1 == pass2) {
			document.getElementById("password2").style.borderColor = "#C0C0C0";
		} else {
			alert("Password doesn't Not Match ");
			document.getElementById("password2").style.borderColor = "#FF0000";
			document.getElementById("password2").value = "";
		}
	}

	function CheckUserStatus() {

		if (document.getElementById("user_status").checked == true) {
			document.getElementById("active").value = 'Y';

			//	alert(document.getElementById("user_status").value );
		} else if (document.getElementById("user_status").checked == false) {
			document.getElementById("active").value = 'N';
			//	alert(document.getElementById("user_status").value );
		}
	}
</script>
<script>
	$(document).ready(function() {
		//alert("working======== ");		
		var a = document.getElementById("").value;
		
		if (document.getElementById("active").value == 'Y') {
			document.getElementById("user_status").checked = true;

			//	alert(document.getElementById("user_status").value );
		} else if (document.getElementById("active").value == 'N') {
			document.getElementById("user_status").checked = false;
			//	alert(document.getElementById("user_status").value );
		}

	});
</script>

<script type="text/javascript" language="javascript">
	function validateEmail(emailField) {
		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

		if (reg.test(emailField.value) == false) {
			alert('Invalid Email Address');
			document.getElementById("email_address").value = "";
			return false;
		}

		return true;
	}
</script>
<script>
	var a = new Date().getDate();
	var a1 = a.toString();
	var b = new Date().getMonth() + 1;
	var b1 = b.toString();
	var c = new Date().getFullYear();
	var c1 = c.toString();

	var q = "-";
	var d = a1.concat(q);
	var d1 = d.concat(b1);
	var d2 = d1.concat(q);
	var sysdate = d2.concat(c1);

	$('#datePicker').datepicker({
		format : 'dd-mm-yyyy',
		startDate : sysdate,
	// 			endDate : sysdate

	}).on('changeDate', function(e) {
		// Revalidate the date field
		$('#eventForm').formValidation('revalidateField', 'date');
	});

	$('#datePicker1').datepicker({
		format : 'dd-mm-yyyy',
		startDate : sysdate

	}).on('changeDate', function(e) {
		// Revalidate the date field
		$('#eventForm').formValidation('revalidateField', 'date');
	});
	

</script>
<style>
#sub_menu {
	background-color: #027BC6;
	color: white;
	width: 250px;
	height: 40px;
	text-align: center;
	margin-left: 80px;
	margin-bottom: 10px;
}

.chk-box {
	outline: none;
}

#sm {
	margin-right: 50px;
}

#sm1 {
	margin-right: 50px;
}

#am {
	margin-right: 50px;
}

#sel_menu {
	margin-left: 80px;
	height: 210px;
	width: 250px;
}

#available_menu {
	margin-left: 50px;
	height: 210px;
	width: 250px;
}

#sub_menu2 {
	width: 250px;
	height: 210px;
	margin-left: 80px;
	margin-top: 0px;
	margin-bottom: 20px;
}

.previous {
	background-color: #027BC6;
	color: white;
	width: 250px;
	height: 40px;
	text-align: center;
	margin-left: 80px;
	margin-bottom: 10px;
}

.next {
	background-color: #027BC6;
	color: white;
	width: 250px;
	height: 40px;
	text-align: center;
	margin-left: 50px;
	margin-bottom: 10px;
}

#ankita {
	width: 250px;
	margin-left: 80px;
	height: 40px;
	color: white;
	background-color: #027BC6;
	text-align: center;
	margin-top: 20px;
	margin-bottom: 10px;
}
#mySelect {
margin-left: 80px;
    height: 210px;
    width: 250px;
    margin-bottom: 20px;
}

.select-checkbox option::before {
  content: "\2610";
  width: 4.3em;
  text-align: center;
  display: inline-block;
}
.select-checkbox option:checked::before {
  content: "\2611";
}


.select-checkbox optgroup:checked::before {
  content: "\2611";
}





</style>












