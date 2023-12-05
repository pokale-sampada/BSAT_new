<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Financial Year Management</h4>
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
					<li class="breadcrumb-item"><a href="">Financial Year
							Management</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<div class="card">
	<div class="card-header">
		<h5>New Financial Year</h5>
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
			action="save_finYear" method="post" ModelAttribute="Bpil_Fin_Year">
			<div class="form-group row">
				<div class="col-md-4">

					<label class="block"> Fin Year <span class="required">*</span></label>
					<input type="text" name="fin_year" id="fin_year"
						class="form-control form-control-sm form-control-primary"
						value="${JSON.fin_year}" class="col-xs-10 col-sm-7" required />
				</div>
				
				<div class="col-md-4">
					<label class="block">Current Year <span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="current_yr_flag" id="current_yr_flag"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</div>
				<div class="col-md-4">
						<label class="block">Active<span class="required">*</span></label>
					<select data-plugin-selectTwo
						class="form-control form-control-sm form-control-primary populate placeholder"
						name="active_flag" id="active_flag"
						data-plugin-options='{ "placeholder": "Select", "allowClear": true }'
						required>
						<option selected="selected" value="Y">Y</option>
						<option value="N">N</option>
					</select>

						</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
				<label class="block"
					for="form-field-1"> Start Date </label>
					<div class="input-group" id="datePicker1">
								<input class="form-control form-control-sm form-control-primary" id="start_date1" name="start_date"
									data-plugin-datepicker type="date" onchange="checkattend()" /> <span
									class="input-group-addon"> <i
									class="fa fa-calendar bigger-110"></i>
								</span>
							</div>
				</div>
					<div class="col-md-4">
					<label class="block"> End Date </label>
							<div class="input-group" id="datePicker2">
								<input class="form-control form-control-sm form-control-primary" id="end_date1" name="end_date"
									data-plugin-datepicker type="date" onblur="getweeks()" /> <span
									class="input-group-addon"> <i
									class="fa fa-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-md-4">
					<label class="block">No OF Weeks <span class="required">*</span></label>
					<input type="text"
						class="form-control form-control-sm form-control-primary"
						name="no_of_weeks" id="no_of_weeks" value="${JSON.no_of_weeks}"
						required />
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
		function getweeks()
		{
			var sd = $('#start_date1').val();
			var ed = $('#end_date1').val();
			//alert(sd);
			$.ajax({
		        url: '${pageContext.request.contextPath}/loadweeks',
		        data: ({start_date : sd , end_date : ed}),
		        success: function(data) {
		        	
		           $('#no_of_weeks').val(data);
		           
		        }
		      });
		}
		</script>
					