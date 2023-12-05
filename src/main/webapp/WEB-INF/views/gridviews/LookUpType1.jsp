
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-6">
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Menu Header Grid</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="Lookupgrid">System
							Setups</a></li>
					<li class="breadcrumb-item"><a href="Lookupgrid">Look Up
							Grid</a></li>
					<li class="breadcrumb-item"><a href="Lookupgrid">New Look
							Up</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="card">
	<div class="card-header">
		<h5>Menu Header Grid</h5>
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

<section role="main" class="content-body">


	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal form-field" role="form" id="sample-form"
				action="SaveLookup1" method="post">
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<!-- <a href="#" class="fa fa-caret-down"></a> -->
							<!--  <a href="#"
								class="fa fa-times"></a> -->
						</div>

						<h2 class="panel-title">LookUp Detail</h2>

					</header>
					<div class="panel-body">
						<div class="form-group">

							<div class="col-md-4">
								<spring:bind path="lookup.lookup_type">
									<label class="control-label">LookUp Type <span
										class="required">*</span></label>
									<input type="text" class="form-control" id="lookup_type"
										value="${alllookuplist1.lookup_type}" placeholder="Lookup Type"
										name="${status.expression}">
								</spring:bind>
							</div>
							<div class="col-md-4">
								<spring:bind path="lookup.active_start_date">
									<label class="control-label">Start Date </label>
									<div class="input-group input-append date">

										<input type="text" class="form-control datePicker"
											id="active_start_date" data-plugin-datepicker
											value="${alllookuplist1.active_start_date}"
											name="${status.expression}" data-date-format="dd-mm-yyyy"
											onchange="checkattend()" /> <span class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</span>
									</div>
								</spring:bind>
							</div>
							<div class="col-md-4">
								<spring:bind path="lookup.active_end_date">
									<label class="control-label"> End Date</label>
									<div class="input-group input-append date" id="datePicker1">

										<input type="text" class="form-control" id="active_end_date"
											data-plugin-datepicker value="${alllookuplist1.active_end_date}"
											name="${status.expression}" data-date-format="dd-mm-yyyy"
											 readonly /> <span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span>
									</div>
								</spring:bind>
							</div>
							<!-- <div class="col-sm-6">
								<label class="control-label">Menu Group Name <span
									class="required">*</span></label>
								<div class="switch switch-primary">
									<input type="checkbox" name="switch" data-plugin-ios-switch
										checked="checked" />
								</div>
							</div> -->
							
						</div>
					</div>

				</section>
				<section class="panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#" class="fa fa-caret-down"></a>
							<!-- <a href="#"
					class="fa fa-times"></a> -->
						</div>
						<h2 class="panel-title">All LookUp Detail</h2>

					</header>
					<div class="panel-body">
						<div class="table-responsive">
							<%
								int n1 = 0;
							%>
							
							<input type="hidden" id="rowcount1" name="rowcount1">
							<table class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column"

								id="dynamic-table1"
								>
								<thead>
									<tr>
										<th class="center">SR No</th>
										<th class="text center">Lookup Code</th>
										<th class="text center">Meaning</th>
										<th class="text center">Description</th>

										<th class="text center">Start Date</th>
										<th class="text center">End Date</th>
									</tr>
								</thead>
								<tbody>
									<%-- <%
										int j = 1;
									%>
									<tr>
										<td class="text center col-xs-12 col-sm-4"><%=j%></td>

										<td class="text center"><input type="text"
											class="form-control" id="lookup_code<%=j%>"
											name="lookup_code" class="col-xs-12 col-sm-4" required /></td>
										<td class="text center"><input type="text"
											class="form-control" id="meaning<%=j%>" name="meaning" class="col-xs-12 col-sm-4"
											required /></td>
										<td class="text center"><input type="text"
											class="form-control" id="description<%=j%>"
											name="description" class="col-xs-12 col-sm-4" required /></td>
										<td class="text center">

											<div class="input-group input-append date">

												<input type="text" class="form-control" id="active_start_date<%=j%>" name="l_active_start_date" class="col-xs-12 col-sm-4" data-plugin-datepicker
													data-date-format="dd-mm-yyyy" readonly /> 
													<!-- <span
													class="input-group-addon"> <i class="fa fa-calendar"></i>
												</span> -->
											</div>

										</td>
										<td class="text center">

											<div class="input-group input-append date">

												<input type="text" class="form-control"
													id="active_end_date<%=j%>" type="text"
													name="l_active_end_date" class="col-xs-12 col-sm-4" data-plugin-datepicker
													data-date-format="dd-mm-yyyy" readonly /> 
													<!-- <span
													class="input-group-addon"> <i class="fa fa-calendar"></i>
												</span> -->
											</div>

										</td>

									</tr>
									<%
										j = j + 1;
									%> --%>


								</tbody>
							</table>
							
						</div>
					</div>
				</section>
				<footer class="panel-footer">
					<div class="row" style="text-align: center">
						<div class="col-sm-12">

							<input type="button" class="btn btn-primary mb-md"
								value="Add Row" onclick="AddRow()">
							<button type="submit" class="btn btn-primary mb-md"
								onclick="return confirmValidate()">Save</button>

						</div>
						
						
						
					</div>
				</footer>
			</form>
		</div>
		<!-- col-md-6 -->
	</div>

</section>
<!-- ace scripts -->
 		<script src="<c:url value='/resources/assets/js/ace-elements.min.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/resources/assets/js/ace.min.js'/>" type="text/javascript"></script>
<script>
	$(document).ready(function() {

		$('.date-picker5').datepicker({
			autoclose : true,
			todayHighlight : true
		})
		//show datepicker when clicking on the icon
		.next().on(ace.click_event, function() {
			$(this).prev().focus();
		});

		$('#lookup_type').blur(function(event) {
			//	alert("hiii");
			// display of instance details table field from instance id
			var name = $('#lookup_type').val();
			var x = document.getElementById("lookup_type").value;
			if (x == null || x == "") {
				document.getElementById("lookup_type").value = "";
				document.getElementById("active_start_date").value = "";
				document.getElementById("active_end_date").value = "";

				return false;

			}

			else {
				//		alert("hiii1");

				$.get('getTagsLookUp', {
					tagName : name
				}, function(response) {
					//alert("hiii121");

					$.each(response, function(index, value) {

						var lookup_type = value.lookup_type;

						//  alert(value.lookup_type);     		              		
						if (lookup_type != null || lookup_type != 0) {
							alert("Lookup type is already present");
							$('#lookup_type').val("");

						} else {

						}
					});
				});

			}
		});
	});
</script>

<%@ page import="java.lang.Math"%>
<%@ page import="java.util.Calendar"%>
<%
	int daysToSubtract = 6;

	Calendar c = Calendar.getInstance();

	System.out.println("Current date : " + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE) + "-"
			+ c.get(Calendar.YEAR));

	// add days to current date

	c = Calendar.getInstance();

	c.add(Calendar.DATE, -daysToSubtract);

	System.out.println("Date (before): " + c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH) + 1) + "-"
			+ c.get(Calendar.YEAR));

	String str1 = Integer.toString(c.get(Calendar.DATE));
	String str2 = Integer.toString(c.get(Calendar.MONTH) + 1);
	String str3 = Integer.toString(c.get(Calendar.YEAR));

	String s = str1.concat("-");
	String s1 = s.concat(str2);
	String s2 = s1.concat("-");
	String s3 = s2.concat(str3);

	//  System.out.println("display date "+s3);
%>
<script>
	$(document).ready(function() {
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

		var day =
<%=str1%>
	var mon =
<%=str2%>
	var year =
<%=str3%>
	var dd = day.toString();
		var mm = mon.toString();
		var yy = year.toString();

		var day1 = dd.concat(q);
		var day2 = day1.concat(mm);
		var day3 = day2.concat(q);
		var enddate = day3.concat(yy);

		$('.datePicker').datepicker({

			format : 'dd-mm-yyyy',
			startDate : sysdate,
		//  endDate: '5-8-2099'
		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});
		$('.datePicker1').datepicker({

			format : 'dd-mm-yyyy',
			startDate : sysdate,
			endDate : '5-8-2099'
		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});
		$('#eventForm').formValidation({
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				name : {
					validators : {
						notEmpty : {
							message : 'The name is required'
						}
					}
				},
				date : {
					validators : {
						notEmpty : {
							message : 'The date is required'
						},
						date : {
							format : 'MM/DD/YYYY',
							message : 'The date is not a valid'
						}
					}
				}
			}
		});
	});
</script>

 <!--  <script>
	function AddRow()
	//add rows for 1st grid
	{
		//$('#dynamic-table1 tr').last().after('<tr><td><center>'+$('#dynamic-table1 tr').length+'</center></td><td><input type="text" value="" id="lookup_code'+$('#dynamic-table1 tr').length+'" name="lookup_code" style="width:100%;" required/></td><td><input type="text" id="meaning'+$('#dynamic-table1 tr').length+'" name="meaning"  style="width:100%;" required/></td><td><input type="text" style="width:100%;" id="description'+$('#dynamic-table1 tr').length+'" value="" name="description" required/></td><td><input class="form-control date-picker" id="active_start_date'+$('#dynamic-table1 tr').length+'" value=" " name="active_start_date"  onchange="checkattend()" type="text" style="width:100%;" /></td><td><input class="form-control date-picker1" id="active_end_date'+$('#dynamic-table1 tr').length+'" value="" name="active_end_date"  type="text" style="width:100%;" /></td></tr>');
		$('#dynamic-table1 tr')
				.last()
				.after(
						'<tr><td class="text center col-xs-12 col-sm-4">'
								+ $('#dynamic-table1 tr').length
								+ '</td><td class="text center col-xs-12 col-sm-4"><input type="text" class="form-control" value="" id="lookup_code'
								+ $('#dynamic-table1 tr').length
								+ '" name="lookup_code" required/></td><td class="text center col-xs-12 col-sm-4"><input type="text" class="form-control" id="meaning'
								+ $('#dynamic-table1 tr').length
								+ '" name="meaning" required/></td><td class="text center col-xs-12 col-sm-4"><input type="text" class="form-control" id="description'
								+ $('#dynamic-table1 tr').length
								+ '" value="" name="description"  required/></td><td><div class="input-group"><input type="text" class="form-control" id="active_start_date'
								+ $('#dynamic-table1 tr').length
								+ '"  name="l_active_start_date"  data-plugin-datepicker"><span class="input-group-addon"><i class="fa fa-calendar"></i></span></div></td><td><div class="input-group" ><input type="text" class="form-control" id="active_end_date'
								+ $('#dynamic-table1 tr').length
								+ '"  name="l_active_end_date" data-plugin-datepicker"><span class="input-group-addon"><i class="fa fa-calendar"></i></span></div></td></tr>');

		$('#rowcount1').val($('#dynamic-table1 tr').length - 1);

		$('.datePicker1').datepicker({
			autoclose : true,
			todayHighlight : true
		})
		//show datepicker when clicking on the icon
		.next().on(ace.click_event, function() {
			$(this).prev().focus();
		});

	}
 
</script> -->

 
 
 
 <script>
function AddRow()              //add rows for 1st grid
{	
		//$('#dynamic-table1 tr').last().after('<tr><td><center>'+$('#dynamic-table1 tr').length+'</center></td><td><input type="text" class="form-control" value="" id="lookup_code'+$('#dynamic-table1 tr').length+'" name="lookup_code" style="width:100%;" required/></td><td><input type="text" class="form-control" id="meaning'+$('#dynamic-table1 tr').length+'" name="meaning"  style="width:100%;" required/></td><td><input type="text" class="form-control" style="width:100%;" id="description'+$('#dynamic-table1 tr').length+'" value="" name="description" required/></td><td><input class="form-control date-picker" id="active_start_date'+$('#dynamic-table1 tr').length+'" value=" " name="active_start_date"  onchange="checkattend()" type="text" style="width:100%;" /></td><td><input class="form-control date-picker1" id="active_end_date'+$('#dynamic-table1 tr').length+'" value="" name="active_end_date"  type="text" style="width:100%;" /></td></tr>');
		$('#dynamic-table1 tr').last().after('<tr>'+
				'<td>'+$('#dynamic-table1 tr').length+'</td>'+
				'<td class="text center"><input type="text" class="form-control" value="" id="lookup_code'+$('#dynamic-table1 tr').length+'" name="lookup_code" required/></td>'+
				'<td class="text center"><input type="text" class="form-control" id="meaning'+$('#dynamic-table1 tr').length+'" name="meaning"  required/></td>'+
				'<td class="text center"><input type="text" class="form-control" style="width:100%;" id="description'+$('#dynamic-table1 tr').length+'" value="" name="description" required/></td>'+
				'<td class="text center"><input class="form-control date-picker5" id="active_start_date'+$('#dynamic-table1 tr').length+'" name="l_active_start_date" type="text" data-date-format="dd-mm-yyyy" readonly/></td>'+
				'<td class="text center"><input class="form-control date-picker5" id="active_end_date'+$('#dynamic-table1 tr').length+'" type="text" name="l_active_end_date" data-date-format="dd-mm-yyyy" readonly/></td>'+
				'</tr>');
		
		$('#rowcount1').val($('#dynamic-table1 tr').length-1);
			
		 $('.date-picker5').datepicker({
				autoclose: true,
				todayHighlight: true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function(){
				$(this).prev().focus();
			});

		}
</script>
 


<script>
	function checkattend() {
		// alert("hello");
		var complain_date = $('#active_start_date').val();

		//	alert(complain_date);

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

		$('#datePicker1').datepicker({

			format : 'dd-mm-yyyy',
			startDate : complain_date,
		// endDate: sysdate
		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date')
		});

	}
</script>