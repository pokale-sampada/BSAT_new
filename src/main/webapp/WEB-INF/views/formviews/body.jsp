	
			
			<section role="main" class="content-body">
				<header class="page-header">
					<!-- <h2>Create Scheme</h2> -->

					<div class="right-wrapper pull-right">
						<ol class="breadcrumbs">
							<li>
								<a href="index.html">
									<i class="fa fa-home"></i>
								</a>
							</li>
							<li><span>Scheme Management</span></li>
							<li><span>Create Scheme</span></li>
						</ol>

						
					</div>
				</header>

				<!-- start: page -->
				<div class="row">
					<div class="col-lg-6">
						<section class="panel form-wizard" id="w1">
							
					</div>
					<div class="row">
						<div class="col-xs-12">
							<section class="panel form-wizard" id="w4">
								<header class="panel-heading">
									<div class="panel-actions">
										<a href="#" class="fa fa-caret-down"></a>
										<a href="#" class="fa fa-times"></a>
									</div>

									<h2 class="panel-title">Create Scheme</h2>
								</header>
								<div class="panel-body">
									<div class="wizard-progress wizard-progress-lg">
										<div class="steps-progress">
											<div class="progress-indicator"></div>
										</div>
										<ul class="wizard-steps">
											<li class="active">
												<a href="#w4-account" data-toggle="tab"><span>1</span>Scheme Details</a>
											</li>
											<li>
												<a href="#w4-profile" data-toggle="tab"><span>2</span>Budget Details</a>
											</li>
											<li>
												<a href="#w4-billing" data-toggle="tab"><span>3</span>Depots Selection</a>
											</li>
											<li>
												<a href="#w4-confirm" data-toggle="tab"><span>4</span>Scheme Related Details</a>
											</li>
											<!-- <li>
												<a href="#w4-pof" data-toggle="tab"><span>5</span>Upload Documents</a>
											</li> -->
										</ul>
									</div>

									<form class="form-horizontal" novalidate="novalidate">
										<div class="tab-content">
											<div id="w4-account" class="tab-pane active">
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-username">Scheme Name</label>
													<div class="col-sm-3">
														<input type="text" class="form-control" name="username" id="w4-username" required>
													</div>
													<label class="col-sm-3 control-label" for="w4-username">Fin Year</label>
													<div class="col-sm-3">
														<select class="form-control" name="exp-month" required>
															<option>2019</option>
															<option>2018</option>

														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-username">Status</label>
													<div class="col-sm-3">
														<select class="form-control" name="exp-month" required>
															<option>In Progress</option>
															<option>New</option>

														</select>
													</div>
													<label class="col-sm-3 control-label" for="w4-username">Fin Month</label>
													<div class="col-sm-3">
														<select class="form-control" name="exp-month" required>
															<option>January</option>
															<option>February</option>

														</select>
													</div>

												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-password">Scheme Code</label>
													<div class="col-sm-3">
														<input type="text" class="form-control" name="password" id="w4-password" required minlength="6">
													</div>
													<label class="col-sm-3 control-label" for="w4-username">Effective From Date</label>
													<div class="col-sm-3">
														<div class="input-group">
															<span class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</span>
															<input type="text" data-plugin-datepicker class="form-control">
														</div>
													</div>

												</div>
											</div>

											<div id="w4-profile" class="tab-pane">
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-first-name">Adex Id</label>
													<div class="col-sm-9">
														<input type="text" class="form-control" name="first-name" id="w4-first-name" required>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-last-name">Budget Available</label>
													<div class="col-sm-9">
														<input type="text" class="form-control" name="last-name" id="w4-last-name" required>
													</div>
												</div>
											</div>
											<div id="w4-billing" class="tab-pane">
												<div class="form-group">
													<label class="col-md-3 control-label">Select Depots</label>


													<div class="col-md-6">
														<select multiple data-plugin-selectTwo class="form-control populate">
															<optgroup value="Alaskan/Hawaiian Time Zone">
																<option value="AK">Alaska</option>
																<option value="HI">Hawaii</option>
															</optgroup>
															<optgroup label="Pacific Time Zone">
																<option value="CA">California</option>
																<option value="NV">Nevada</option>
																<option value="OR">Oregon</option>
																<option value="WA">Washington</option>
															</optgroup>
															<optgroup label="Mountain Time Zone">
																<option value="AZ">Arizona</option>
																<option value="CO">Colorado</option>
																<option value="ID">Idaho</option>
																<option value="MT">Montana</option>
																<option value="NE">Nebraska</option>
																<option value="NM">New Mexico</option>
																<option value="ND">North Dakota</option>
																<option value="UT">Utah</option>
																<option value="WY">Wyoming</option>
															</optgroup>
															<optgroup label="Central Time Zone">
																<option value="AL">Alabama</option>
																<option value="AR">Arkansas</option>
																<option value="IL">Illinois</option>
																<option value="IA">Iowa</option>
																<option value="KS">Kansas</option>
																<option value="KY">Kentucky</option>
																<option value="LA">Louisiana</option>
																<option value="MN">Minnesota</option>
																<option value="MS">Mississippi</option>
																<option value="MO">Missouri</option>
																<option value="OK">Oklahoma</option>
																<option value="SD">South Dakota</option>
																<option value="TX">Texas</option>
																<option value="TN">Tennessee</option>
																<option value="WI">Wisconsin</option>
															</optgroup>
															<optgroup label="Eastern Time Zone">
																<option value="CT">Connecticut</option>
																<option value="DE">Delaware</option>
																<option value="FL">Florida</option>
																<option value="GA">Georgia</option>
																<option value="IN">Indiana</option>
																<option value="ME">Maine</option>
																<option value="MD">Maryland</option>
																<option value="MA">Massachusetts</option>
																<option value="MI">Michigan</option>
																<option value="NH">New Hampshire</option>
																<option value="NJ">New Jersey</option>
																<option value="NY">New York</option>
																<option value="NC">North Carolina</option>
																<option value="OH">Ohio</option>
																<option value="PA">Pennsylvania</option>
																<option value="RI">Rhode Island</option>
																<option value="SC">South Carolina</option>
																<option value="VT">Vermont</option>
																<option value="VA">Virginia</option>
																<option value="WV">West Virginia</option>
															</optgroup>
														</select>
													</div>
												</div>

											</div>
											<div id="w4-confirm" class="tab-pane">
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-first-name">Scheme Created By</label>
													<div class="col-sm-3">
														<input type="text" class="form-control" name="first-name" id="w4-first-name" required>
													</div>
													<label class="col-sm-3 control-label" for="w4-last-name">Scheme Created On</label>
													<div class="col-sm-3">
														<input type="text" class="form-control" name="last-name" id="w4-last-name" required>
													</div>

												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label" for="w4-first-name">Customer club class</label>
													<div class="col-sm-3">
														<div class="radio-custom radio-primary">
															<input id="awesome" name="porto_is" type="radio" value="awesome" required />
															<label for="awesome">Awesome</label>
														</div>
														<div class="radio-custom radio-primary">
															<input id="very-awesome" name="porto_is" type="radio" value="very-awesome" />
															<label for="very-awesome">Very Awesome</label>
														</div>
														<div class="radio-custom radio-primary">
															<input id="ultra-awesome" name="porto_is" type="radio" value="ultra-awesome" />
															<label for="ultra-awesome">Ultra Awesome</label>
														</div>
														<label class="error" for="porto_is"></label>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label">Customer Type <span class="required">*</span></label>
													<div class="col-sm-9">
														<div class="checkbox-custom chekbox-primary">
															<input id="for-project" value="project" type="checkbox" name="for[]" required />
															<label for="for-project">Prolinks-Industrial (15)</label>
														</div>
														<div class="checkbox-custom chekbox-primary">
															<input id="for-website" value="website" type="checkbox" name="for[]" />
															<label for="for-website">Ultratech Dealer (3)</label>
														</div>
														<div class="checkbox-custom chekbox-primary">
															<input id="for-all" value="all" type="checkbox" name="for[]" />
															<label for="for-all">Prolinks Dealer (4)</label>
														</div>
														<label class="error" for="for[]"></label>
													</div>
												</div>

											</div>
											<!-- <div id="w4-pof" class="tab-pane">
													<div class="row">
															<div class="col-xs-12">
																<section class="panel">
																	<header class="panel-heading">
																		<div class="panel-actions">
																			<a href="#" class="fa fa-caret-down"></a>
																			<a href="#" class="fa fa-times"></a>
																		</div>
														
																		<h2 class="panel-title">File Upload Drag'n Drop</h2>
																	</header>
																	<div class="panel-body">
															
																		<form action="/upload" class="dropzone dz-square" id="dropzone-example"></form>
																	</div>
																</section>
															</div>
														</div>
											</div>	 -->
										</div>
									</form>
								</div>
								
							</section>
						</div>
					</div>
					
				</div>
				<!-- end: page -->
			</section>
	

	