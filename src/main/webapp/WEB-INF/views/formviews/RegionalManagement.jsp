<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Regional Management</h4>
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
					<li class="breadcrumb-item"><a href="">Regional Management</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<div class="card">
	<div class="card-header">
		<h5>Regional Management</h5>
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
				<label class="block">Select Hierarchy Levels</label>
			</div>
			<div class="col-md-3">
				<select
					class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm"
					name="level" id="level" onchange="validate_level()">

					<option value="select">--Select--</option>
					<option value="1">Level 1</option>
					<option value="2">Level 2</option>
					<option value="3">Level 3</option>
					<option value="4">Level 4</option>
				</select>
			</div>
		</div>
	</div>
</div>
<div class="card" id="headuarters" hidden>
	<div class="card-header">
		<h5>Headquarters</h5>
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
		<form class="form-horizontal form-field" role="form"
			action="saveHeadquarter" ModelAttribute="Bpil_Headquarter_Master"
			method="post">
			<div class="form-group row">
				<%-- <input type="hidden" id="headquarter_id" name=headquarter_id
					value="${JSON.headquarter_id}" /> --%>
				<div class="col-md-4">

					<label class="block"> Headquarter Name <span
						class="required">*</span></label> <input
						class="form-control form-control-sm form-control-primary"
						id="headquarter_name" type="text" name="headquarter_name"
						value="${JSON.headquarter_name}" required />

				</div>
				<div class="col-md-4">

					<label class="block"> Headquarter Code<span
						class="required">*</span></label> <input
						class="form-control form-control-sm form-control-primary "
						id="headquarter_code" type="text" name="headquarter_code"
						value="${JSON.headquarter_code}" required />
				</div>
				<div class="col-md-4">
					<label class="block">Active<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="is_active" id="is_active"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</div>
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
<div class="card" id="region" hidden>
	<div class="card-header">
		<h5>Region</h5>
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
		<form class="form-horizontal form-field" role="form" ModelAttribute="Bpil_Region_Master"
			action="saveRegion" method="post">
			<div class="form-group row">
				<input type="hidden" id="region_id" name="menu_group_id"
					value="${JSON.region_id}" />

				<div class="col-md-3">
					<label class="block">Headquarter<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary populate placeholder"
						name="headquarter_id" id="headquarter_id"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.headquarter_id}"></option>
					</select>
				</div>
				<div class="col-md-3">
					<label class="control-label">Region Code<span
						class="required">*</span></label> <input id="group_code" type="text"
						name="group_code" value="${JSON.region_code}" class="form-control"
						required />

				</div>

				<div class="col-md-3">
					<label class="control-label">Region Name<span
						class="required">*</span></label> <input id="group_name" type="text"
						name="group_name" value="${JSON.region_name}" class="form-control"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label" for="url"> Active</label> <select
						data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="active" id="active" value="${JSON.is_active}"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</div>
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
<div class="card" id="distributors" hidden>
	<div class="card-header">
		<h5>Distributor</h5>
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
		<form class="form-horizontal form-field" role="form" ModelAttribute="Bpil_Depot_Master"
			action="saveDistributor" method="post">
			<div class="form-group row">
				 <input type="hidden" id="depot_id" name="depot_id"
					value="${JSON.depot_id}" />

				<div class="col-md-3">
					<label class="block">Headquarter<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="headquarter_id1" id="headquarter_id1"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required onchange="loadRegion()">
						<option selected="selected" value="${JSON.headquarter_id}"></option>
					</select>
				</div>
				<div class="col-md-3">
					<label class="block">Region<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="regn" id="regn"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.regn}"></option>
					</select>
				</div>
				<div class="col-md-3">
					<label class="control-label">Distributor Code<span
						class="required">*</span></label> <input id="depot_code" type="text"
						name="depot_code" value="${JSON.depot_code}" class="form-control form-control-sm form-control-primary"
						required />

				</div>

				<div class="col-md-3">
					<label class="control-label">Distributor Name<span
						class="required">*</span></label> <input id="depot_name" type="text"
						name="depot_name" value="${JSON.depot_name}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-3">
					<label class="control-label">Address Line1<span
						class="required">*</span></label> <input id="address_line1" type="text"
						name="address_line1" value="${JSON.address_line1}" class="form-control form-control-sm form-control-primary"
						required />

				</div>

				<div class="col-md-3">
					<label class="control-label">Address Line2<span
						class="required">*</span></label> <input id="address_line2" type="text"
						name="address_line2" value="${JSON.address_line2}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label">Address Line3<span
						class="required">*</span></label> <input id="address_line3" type="text"
						name="address_line3" value="${JSON.address_line3}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label">State<span
						class="required">*</span></label> <input id="state" type="text"
						name="state" value="${JSON.state}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
			
			</div>
			<div class="form-group row">
				<div class="col-md-3">
					<label class="control-label">City<span
						class="required">*</span></label> <input id="city" type="text"
						name="city" value="${JSON.city}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label">PinCode<span
						class="required">*</span></label> <input id="pin_code" type="text"
						name="pin_code" value="${JSON.pin_code}" class="form-control form-control-sm form-control-primary"/>

				</div>
				<div class="col-md-3">
					<label class="control-label">Email Address<span
						class="required">*</span></label> <input id="email_address" type="text"
						name="email_address" value="${JSON.email_address}" class="form-control form-control-sm form-control-primary"/>

				</div>
				
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
<div class="card" id="dealers" hidden>
	<div class="card-header">
		<h5>Dealer</h5>
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
		<form class="form-horizontal form-field" role="form" ModelAttribute="Bpil_Dealer_Master"
			action="saveDealer" method="post">
			<div class="form-group row">
				 <input type="hidden" id="orcl_dlr_id" name="orcl_dlr_id"
					value="${JSON.orcl_dlr_id}" /> 

				<div class="col-md-3">
					<label class="block">Headquarter<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary populate placeholder"
						name="headquarter_id2" id="headquarter_id2"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.headquarter_id}"></option>
					</select>
				</div>
				<div class="col-md-3">
					<label class="block">Region<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary populate placeholder"
						name="region_id" id="region_id2"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.region_id}"></option>
					</select>
				</div>
				<div class="col-md-3">
					<label class="block">Distributor<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary form-control form-control-sm form-control-primary-sm form-control form-control-sm form-control-primary-primary populate placeholder"
						name="depot_code" id="depot_code1"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="${JSON.depot_code}"></option>
					</select>
				</div>
				<div class="col-md-3">
					<label class="control-label">Account No<span
						class="required">*</span></label> <input id="dealer_code" type="text"
						name="dealer_code" value="${JSON.dealer_code}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
			</div>
			<div class="form-group row">
			<div class="col-md-3">
					<label class="control-label">Address Line1<span
						class="required">*</span></label> <input id="address_line_1" type="text"
						name="address_line_1" value="${JSON.address_line_1}" class="form-control form-control-sm form-control-primary"
						required />

				</div>

				<div class="col-md-3">
					<label class="control-label">Address Line2<span
						class="required">*</span></label> <input id="address_line_2" type="text"
						name="address_line_2" value="${JSON.address_line_2}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label">Address Line3<span
						class="required">*</span></label> <input id="address_line_3" type="text"
						name="address_line_3" value="${JSON.address_line_3}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label">City<span
						class="required">*</span></label> <input id="city" type="text"
						name="city" value="${JSON.city}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				</div>
				<div class="form-group row">
				<div class="col-md-3">
					<label class="control-label">PinCode<span
						class="required">*</span></label> <input id="pin_code" type="text"
						name="pin_code" value="${JSON.pin_code}" class="form-control form-control-sm form-control-primary"/>

				</div>
				<div class="col-md-3">
					<label class="control-label">State<span
						class="required">*</span></label> <input id="state" type="text"
						name="state" value="${JSON.state}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label">Country<span
						class="required">*</span></label> <input id="country" type="text"
						name="country" value="${JSON.country}" class="form-control form-control-sm form-control-primary"
						required />

				</div>
				<div class="col-md-3">
					<label class="control-label" for="url"> Primary Flag</label> <select
						data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="primary_flag" id="primary_flag" value="${JSON.primary_flag}"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</div>
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
<script>

function validate_level() {
		var level = $('#level').val();
		if (level == 1) {
			
			document.getElementById("headuarters").hidden = false;
			document.getElementById("region").hidden = true;
			document.getElementById("distributors").hidden = true;
			document.getElementById("dealers").hidden = true;
			
		} else if (level == 2) {
			 $.ajax({
				url : '${pageContext.request.contextPath}/loadheadquarter',

				success : function(data) {
					var select = $('#headquarter_id');
					// alert(select);
					select.find('option').remove();
					$('<option>').val("").text("--Select--").appendTo(select);
					$.each(data, function(index, value) {
						if (value.headquarter_id == "${JSON.headquarter_id}") {
							$('<option selected>').val(value.headquarter_id)
									.text(value.headquarter_name).appendTo(select);
						} else {
							$('<option>').val(value.headquarter_id).text(
									value.headquarter_name).appendTo(select);
						}
					});

				}
			});
			document.getElementById("headuarters").hidden = true;
			document.getElementById("region").hidden = false;
			document.getElementById("distributors").hidden = true;
			document.getElementById("dealers").hidden = true;
		} 
		else if (level == 3) {

			 $.ajax({
					url : '${pageContext.request.contextPath}/loadheadquarter',

					success : function(data) {
						var select = $('#headquarter_id1');
						// alert(select);
						select.find('option').remove();
						$('<option>').val("").text("--Select--").appendTo(select);
						$.each(data, function(index, value) {
							if (value.headquarter_id == "${JSON.headquarter_id}") {
								$('<option selected>').val(value.headquarter_id)
										.text(value.headquarter_name).appendTo(select);
							} else {
								$('<option>').val(value.headquarter_id).text(
										value.headquarter_name).appendTo(select);
							}
						});

					}
				});
			document.getElementById("headuarters").hidden = true;
			document.getElementById("region").hidden = true;
			document.getElementById("distributors").hidden = false;
			document.getElementById("dealers").hidden = true;
		}
		else if (level == 4) {

			 $.ajax({
					url : '${pageContext.request.contextPath}/loadheadquarter',

					success : function(data) {
						var select = $('#headquarter_id2');
						// alert(select);
						select.find('option').remove();
						$('<option>').val("").text("--Select--").appendTo(select);
						$.each(data, function(index, value) {
							if (value.headquarter_id == "${JSON.headquarter_id}") {
								$('<option selected>').val(value.headquarter_id)
										.text(value.headquarter_name).appendTo(select);
							} else {
								$('<option>').val(value.headquarter_id).text(
										value.headquarter_name).appendTo(select);
							}
						});

					}
				});
			document.getElementById("headuarters").hidden = true;
			document.getElementById("region").hidden = true;
			document.getElementById("distributors").hidden = true;
			document.getElementById("dealers").hidden = false;
		}
		else {
			document.getElementById("headuarters").hidden = true;
			document.getElementById("region").hidden = true;
			document.getElementById("distributors").hidden = true;
			document.getElementById("dealers").hidden = true;

		}
	}
	
$(document)
.ready(
		function() {
			
			   $(document).on('change','#headquarter_id1',function(){ 
	      	var headquarter_id = $("select#headquarter_id1").val();
	      	$.ajax({
	      		url: '${pageContext.request.contextPath}/loadRegions',	
	      	    data: ({headquarter_id : headquarter_id}),
	      	    success: function(data) {				        	
	      	    	var select = $('#regn');
	      	    	select.find('option').remove();
	      	    	$('<option>').val("").text("--Select--").appendTo(select);
	      	        $.each(data, function(index, value) {	
	      	        	$('<option>').val(value.region_name).text(value.region_name).appendTo(select);
	      	           		 
	      	    	});

	      	    }
	      	});
	      });
			
	
		
$(document).on('change','#headquarter_id2',function(){ 
  	var headquarter_id = $("select#headquarter_id2").val();
  	$.ajax({
  		url: '${pageContext.request.contextPath}/loadRegions',	
  	    data: ({headquarter_id : headquarter_id}),
  	    success: function(data) {				        	
  	    	
  	    	var select = $('#region_id2');
  	    	select.find('option').remove();
  	    	$('<option>').val("").text("--Select--").appendTo(select);
  	        $.each(data, function(index, value) {	
  	        	$('<option>').val(value.region_name).text(value.region_name).appendTo(select);
  	           		 
  	    	});

  	    }
  	});
  });
  
$(document).on('change','#region_id2',function(){ 
  	var region_name = $("select#region_id2").val();
  	$.ajax({
  		url: '${pageContext.request.contextPath}/loadDistributors',	
  	    data: ({region_name : region_name}),
  	    success: function(data) {				        	
  	    	
  	    	var select = $('#depot_code1');
  	    	select.find('option').remove();
  	    	$('<option>').val("").text("--Select--").appendTo(select);
  	        $.each(data, function(index, value) {	
  	        	$('<option>').val(value.depot_code).text(value.depot_code).appendTo(select);
  	           		 
  	    	});

  	    }
  	});
  });
  
		});
</script>