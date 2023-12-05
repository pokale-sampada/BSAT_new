<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Menu Management</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="">Configuration
							Setups</a></li>
					<li class="breadcrumb-item"><a href="">Menu Management</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<div class="card">
	<div class="card-header">
		<h5>Add Menu Group</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><a href="newmenugroup"><i class="feather icon-plus"
						style="color: blue; font-size: 20px; font-weight: bold;"
						title="Add New Region "></i></a></li>
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-field" role="form"
			action="save_menugroup" ModelAttribute="Bpil_MenuGroup" method="post">
			<div class="form-group row">
				<input type="hidden" id="menu_group_id" name="menu_group_id"
					value="${JSON.menu_group_id}" />
				<div class="col-md-4">

					<label class="block"> Menu Group Name <span
						class="required">*</span></label> <input
						class="form-control form-control-sm form-control-primary"
						id="group_name" type="text" name="group_name"
						value="${JSON.group_name}" required />

				</div>
				<div class="col-md-4">

					<label class="block"> Menu Group Description<span
						class="required">*</span></label> <input
						class="form-control form-control-sm form-control-primary "
						id="group_description" type="text" name="group_description"
						value="${JSON.group_description}" required />
				</div>
				<div class="col-md-4">

					<label class="block"> Start Date</label>
					<div class="input-group input-append date" id="datePicker1">
						<input
							class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary"
							data-plugin-datepicker id="group_start_date"
							value="${JSON.group_start_date1}" name="group_start_date"
							type="date" /> <span class="input-group-addon"> <i
							class="fa fa-calendar bigger-110"></i>
						</span>
					</div>

				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block"> End Date</label>
					<div class="input-group input-append date" id="datePicker2">
						<input
							class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary"
							data-plugin-datepicker data-date-format="dd-mm-yyyy"
							id="group_end_date" value="${JSON.group_end_date1}"
							name="group_end_date" type="date" /> <span
							class="input-group-addon"> <i
							class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>

				<div class="col-md-4">
					<input
						class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary"
						id="active" type="hidden" name="active" value="${JSON.active}" />
					<label class="block">Active</label>
					<div class="switch switch-primary">
						<input name="activecheck" id="activecheck" data-plugin-ios-switch
							class="border-checkbox" type="checkbox"
							onchange="CheckMenuGroupStatus()" />
					</div>
					<span class="lbl"></span>
				</div>
				<div class="col-md-4"></div>
			</div>
			<footer class="panel-footer">
				<div class="row" style="text-align: center">
					<div class="col-sm-12">
						<button type="submit" class="btn btn-primary btn-sm">Save</button>
						<!-- <button type="button" class="btn btn-primary btn-sm"
							onclick="Previouspage()">Back</button> -->
					</div>
				</div>
			</footer>
		</form>
	</div>
</div>
<div class="card">
	<div class="card-header">
		<h5>Menu Group</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<!-- <li><a href="saveregion"><i class="feather icon-plus" style="color: blue; font-size: 20px; font-weight: bold;"
					title="Add New Region "></i></a></li> -->
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<div class="form-group row">
			<div class="col-md-3">
				<label class="block">Select Menu Levels</label>
			</div>
			<div class="col-md-3">
				<select
					class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm"
					name="menu_level" id="menu_level" onchange="validate_level()">

					<option value="select">--Select--</option>
					<option value="1">Level 1</option>
					<option value="2">Level 2</option>
					<option value="3">Level 3</option>
				</select>
			</div>
		</div>
	</div>
</div>
<div class="card" id="menu_header" hidden>
	<div class="card-header">
		<h5>Add Menu Header</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<!-- <li><a href="newmenuheaderline"><i
						class="feather icon-plus"
						style="color: blue; font-size: 20px; font-weight: bold;"
						title="Add New Region "></i></a></li> -->
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-field" role="form"
			action="save_menuHeader" ModelAttribute="Bpil_Menu_Header"
			method="post">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block">Menu Group Name <span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary populate placeholder"
						name="menu_group_id" id="menu_group_id1"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.menu_group_id}"></option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="block">Header Menu Name <span
						class="required">*</span></label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						name="header_name" id="header_name" value="${JSON.header_name}"
						required />

				</div>
				<div class="col-md-4">
					<label class="block">Header Menu Action <span
						class="required">*</span></label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						name="action_name" id="action_name" value="${JSON.action_name}"
						required />

				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block"> Start Date</label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary "
							id="header_start_date" data-plugin-datepicker
							data-date-format="dd-mm-yyyy" name="header_start_date"
							value="${JSON.header_start_date1}" type="date"
							onchange="checkattend()" /> <span class="input-group-addon">
							<i class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>

				<div class="col-md-4">
					<label class="block"> End Date </label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary "
							id="header_end_date" data-date-format="dd-mm-yyyy"
							data-plugin-datepicker name="header_end_date"
							value="${JSON.header_end_date1}" type="date" /> <span
							class="input-group-addon"> <i
							class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="col-md-4">
					<input class="form-control form-control-sm form-control-primary"
						id="header_active" type="hidden" name="header_active"
						value="${JSON.header_active}" /> <label class="block">Active</label>
					<div class="switch switch-primary">
						<input type="checkbox" name="header_activecheck"
							class="border-checkbox" id="header_activecheck"
							data-plugin-ios-switch value=""
							onchange="CheckMenuHeaderStatus()" />
					</div>
				</div>
			</div>
			<footer class="panel-footer">
				<div class="row" style="text-align: center">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<input type="submit" value="Save" class="btn btn-primary btn-sm" />
					</div>
					<div class="col-md-4"></div>
				</div>
			</footer>
		</form>
	</div>
</div>
<div class="card" id="menu_line" hidden>
	<div class="card-header">
		<h5>Add Menu Line</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<!-- <li><a href="newmenugroup"><i class="feather icon-plus"
						style="color: blue; font-size: 20px; font-weight: bold;"
						title="Add New Region "></i></a></li> -->
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-field" role="form"
			action="save_menuLine" ModelAttribute="Bpil_Menu_Line" method="post">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block">Menu Group Name <span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="menu_group_id" id="menu_group_id2"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.menu_group_id}"></option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="block">Header Menu Name <span
						class="required">*</span></label> <select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="menu_header_id" id="menu_header_id"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.menu_header_id}"></option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="block">Menu Line Name <span class="required">*</span></label>
					<input type="text"
						class="form-control form-control-sm form-control-primary"
						name="line_name" id="line_name" value="${JSON.line_name}" required />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block">Menu Line Action <span
						class="required">*</span></label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						name="action_name" id="action_name" value="${JSON.action_name}"
						required />

				</div>
				<div class="col-md-3">
					<label class="block"> Start Date</label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary "
							id="line_start_date" data-plugin-datepicker
							data-date-format="dd-mm-yyyy" name="line_start_date"
							value="${JSON.line_start_date}" type="date"
							onchange="checkattend()" /> <span class="input-group-addon">
							<i class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>

				<div class="col-md-3">
					<label class="block"> End Date </label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary "
							id="line_end_date" data-date-format="dd-mm-yyyy"
							data-plugin-datepicker name="line_end_date"
							value="${JSON.line_end_date}" type="date" /> <span
							class="input-group-addon"> <i
							class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="col-md-3">
					<input class="form-control form-control-sm form-control-primary"
						id="line_active" type="hidden" name="line_active"
						value="${JSON.line_active}" /> <label class="block">Active</label>
					<div class="switch switch-primary">
						<input type="checkbox" name="line_activechk" id="line_activechk"
							data-plugin-ios-switch value="" onchange="CheckMenuLineStatus()" />
					</div>
				</div>
			</div>
			<footer class="panel-footer">
				<div class="row" style="text-align: center">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<input type="submit" value="Save" class="btn btn-primary btn-sm" />
					</div>
					<div class="col-md-4"></div>
				</div>
			</footer>
		</form>
	</div>
</div>
<div class="card" id="submenu_line" hidden>
	<div class="card-header">
		<h5>Add Sub Menu Line</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<!-- <li><a href="newmenugroup"><i class="feather icon-plus"
						style="color: blue; font-size: 20px; font-weight: bold;"
						title="Add New Region "></i></a></li> -->
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-field" role="form"
			action="save_submenuLine" ModelAttribute="Bpil_SubMenu_Line"
			method="post">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block">Menu Group Name <span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="menu_group_id" id="menu_group_id3"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.menu_group_id}"></option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="block">Header Menu Name <span
						class="required">*</span></label> <select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="menu_header_id" id="menu_header_id1"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.menu_header_id}"></option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="block">Menu Line Name <span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="menu_line_id" id="menu_line_id"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.menu_line_id}"></option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block">SubMenu Line Name <span
						class="required">*</span></label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						name="submenuline_name" id="submenuline_name"
						value="${JSON.submenuline_name}" required />
				</div>
				<div class="col-md-4">
					<label class="block">SubMenu Line Action <span
						class="required">*</span></label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						name="subMenu_action_name" id=subMenu_action_name
						value="${JSON.subMenu_action_name}" required />

				</div>
				<div class="col-md-4">
					<label class="block"> Start Date</label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary "
							id="subline_start_date" data-plugin-datepicker
							data-date-format="dd-mm-yyyy" name="subline_start_date"
							value="${JSON.subline_start_date}" type="date"
							onchange="checkattend()" /> <span class="input-group-addon">
							<i class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block"> End Date </label>
					<div class="input-group input-append date" id="datePicker1">
						<input class="form-control form-control-sm form-control-primary "
							id="subline_end_date" data-date-format="dd-mm-yyyy"
							data-plugin-datepicker name="subline_end_date"
							value="${JSON.subline_end_date}" type="date" /> <span
							class="input-group-addon"> <i
							class="fa fa-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="col-md-4">
					<input class="form-control form-control-sm form-control-primary"
						id="subline_active" type="hidden" name="subline_active"
						value="${JSON.subline_active}" /> <label class="block">Active</label>
					<div class="switch switch-primary">
						<input type="checkbox" name="subline_activechk"
							id="line_activechk" data-plugin-ios-switch value=""
							onchange="CheckSubMenuLineStatus()" />
					</div>
				</div>
			</div>
			<footer class="panel-footer">
				<div class="row" style="text-align: center">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<input type="submit" value="Save" class="btn btn-primary btn-sm" />
					</div>
					<div class="col-md-4"></div>
				</div>
			</footer>
		</form>
	</div>
</div>
<script>
	function CheckSubMenuLineStatus() {
		if (document.getElementById("subline_activechk").checked == true) {
			document.getElementById("subline_active").value = 'Y';
		} else {
			document.getElementById("subline_active").value = 'N';
		}
	}
	function CheckMenuGroupStatus() {
		if (document.getElementById("activecheck").checked == true) {
			document.getElementById("active").value = 'Y';
		} else {
			document.getElementById("active").value = 'N';
		}
	}
	function Previouspage() {
		window.location.href = "admin";
	}
	function CheckMenuHeaderStatus() {

		if (document.getElementById("header_activecheck").checked == true) {
			document.getElementById("header_active").value = 'Y';
		} else if (document.getElementById("header_activecheck").checked == false) {
			document.getElementById("header_active").value = 'N';
		}
	}
	function CheckMenuLineStatus() {

		if (document.getElementById("line_activechk").checked == true) {
			document.getElementById("line_active").value = 'Y';
		} else if (document.getElementById("line_activechk").checked == false) {
			document.getElementById("line_active").value = 'N';
		}
	}
</script>
<script>
	$(document)
			.ready(
					function() {

						/*  $(document).on('change','#scheme_business_line',function(){ 
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
						      }); */
						$(document)
								.on(
										'change',
										'#menu_group_id2',
										function() {
											var menu_group_id = $(
													"select#menu_group_id2")
													.val();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/loadmenuheaders',
														data : ({
															menu_group_id : menu_group_id
														}),
														success : function(data) {

															var select = $('#menu_header_id');
															select.find(
																	'option')
																	.remove();
															$('<option>')
																	.val("")
																	.text(
																			"--Select--")
																	.appendTo(
																			select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {
																				$(
																						'<option>')
																						.val(
																								value.menu_header_id)
																						.text(
																								value.header_name)
																						.appendTo(
																								select);

																			});

														}
													});
										});

						$(document)
								.on(
										'change',
										'#menu_group_id3',
										function() {
											var menu_group_id = $(
													"select#menu_group_id3")
													.val();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/loadmenuheaders',
														data : ({
															menu_group_id : menu_group_id
														}),
														success : function(data) {

															var select = $('#menu_header_id1');
															select.find(
																	'option')
																	.remove();
															$('<option>')
																	.val("")
																	.text(
																			"--Select--")
																	.appendTo(
																			select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {
																				$(
																						'<option>')
																						.val(
																								value.menu_header_id)
																						.text(
																								value.header_name)
																						.appendTo(
																								select);

																			});

														}
													});
										});
						$(document)
								.on(
										'change',
										'#menu_header_id1',
										function() {
											var menu_header_id = $(
													"select#menu_header_id1")
													.val();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/loadmenulines',
														data : ({
															menu_header_id : menu_header_id
														}),
														success : function(data) {

															var select = $('#menu_line_id');
															select.find(
																	'option')
																	.remove();
															$('<option>')
																	.val("")
																	.text(
																			"--Select--")
																	.appendTo(
																			select);
															$
																	.each(
																			data,
																			function(
																					index,
																					value) {
																				$(
																						'<option>')
																						.val(
																								value.menu_line_id)
																						.text(
																								value.line_name)
																						.appendTo(
																								select);

																			});

														}
													});
										});
					});
	function validate_level() {
		var level = $('#menu_level').val();
		if (level == 1) {
			$.ajax({
				url : '${pageContext.request.contextPath}/loadmenugroup',

				success : function(data) {
					var select = $('#menu_group_id1');
					// alert(select);
					select.find('option').remove();
					$('<option>').val("").text("--Select--").appendTo(select);
					$.each(data, function(index, value) {
						if (value.menu_group_id == "${JSON.menu_group_id}") {
							$('<option selected>').val(value.menu_group_id)
									.text(value.group_name).appendTo(select);
						} else {
							$('<option>').val(value.menu_group_id).text(
									value.group_name).appendTo(select);
						}
					});

				}
			});
			document.getElementById("menu_header").hidden = false;
			document.getElementById("menu_line").hidden = true;
			document.getElementById("submenu_line").hidden = true;
		} else if (level == 2) {
			$.ajax({
				url : '${pageContext.request.contextPath}/loadmenugroup',

				success : function(data) {
					var select = $('#menu_group_id2');
					// alert(select);
					select.find('option').remove();
					$('<option>').val("").text("--Select--").appendTo(select);
					$.each(data, function(index, value) {
						if (value.menu_group_id == "${JSON.menu_group_id}") {
							$('<option selected>').val(value.menu_group_id)
									.text(value.group_name).appendTo(select);
						} else {
							$('<option>').val(value.menu_group_id).text(
									value.group_name).appendTo(select);
						}
					});

				}
			});
			document.getElementById("menu_header").hidden = true;
			document.getElementById("menu_line").hidden = false;
			document.getElementById("submenu_line").hidden = true;
		} else if (level == 3) {

			$.ajax({
				url : '${pageContext.request.contextPath}/loadmenugroup',

				success : function(data) {
					var select = $('#menu_group_id3');
					// alert(select);
					select.find('option').remove();
					$('<option>').val("").text("--Select--").appendTo(select);
					$.each(data, function(index, value) {
						if (value.menu_group_id == "${JSON.menu_group_id}") {
							$('<option selected>').val(value.menu_group_id)
									.text(value.group_name).appendTo(select);
						} else {
							$('<option>').val(value.menu_group_id).text(
									value.group_name).appendTo(select);
						}
					});

				}
			});
			document.getElementById("menu_header").hidden = true;
			document.getElementById("menu_line").hidden = true;
			document.getElementById("submenu_line").hidden = false;
		} else {
			document.getElementById("menu_header").hidden = true;
			document.getElementById("menu_line").hidden = true;
			document.getElementById("submenu_line").hidden = true;

		}
	}
</script>