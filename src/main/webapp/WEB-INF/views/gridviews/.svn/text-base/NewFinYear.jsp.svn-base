<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="resources/newportal/vendor/jquery/jquery.js"></script>
<link rel="stylesheet" href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />
<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>
				<li><span><span><a href="fin_year">System Setups</a></span></span></li>
				<li><span><span><a href="fin_year">Financial Year Detail</a></span></span></li>
				<li><span>New Financial Year</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>
	<!-- start: page -->
	<div class="row">
		<div class="col-md-12">
		<form class="form-horizontal form-field" role="form" id="newbranch"
				action="save_fin_year" ModelAttribute="Bpil_Fin_Year">
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<!-- <a href="#" class="fa fa-caret-down"></a> --> <!-- <a href="#"
					class="fa fa-times"></a> -->
			</div>
			<h6 class="panel-title">New Financial Year</h6>
			<div></div>
		</header>
		<div class="panel-body">
          
			<div class="form-group">
				<input type="hidden" id="branch_id" name="branch_id" />
			  
				<div class="col-md-4">
				<label class="control-label formmodifiedLable" for="inputDefault">Fin Year</label>
					<input type="text" name="fin_year" id="fin_year" value="${JSON.fin_year}" class="form-control" required />

				</div>
				<div class="col-md-4">
					<label class="control-label formmodifiedLable" for="inputDefault">No OF Weeks
					</label> <input type="text" class="form-control" id="no_of_weeks" name="no_of_weeks" readonly>
				</div>
				<div class="col-md-4">
					<label class="control-label formmodifiedLable" for="inputDefault">Current Year 
				   </label> <select name="current_yr_flag" id="current_yr_flag"	class="form-control" required >
																<option selected="selected" value="Y">Y</option>
																<option  value="N">N</option></select>
				</div>
				<div class="col-md-4"><label class="control-label formmodifiedLable" for="inputDefault">Start Date</label>
					<div class="input-group input-append date" id="datePicker1">
														
														<input type="text"  id="start_date1" name="start_date" data-plugin-datepicker class="form-control" data-date-format="dd-mm-yyyy" onblur="checkattend()"/>
														<span class="input-group-addon">
															<i class="fa fa-calendar"></i>
														</span>
													</div>
													
				</div>
				<div class="col-md-4"><label class="control-label formmodifiedLable" for="inputDefault">End Date</label>
					<div class="input-group input-append date" id="datePicker2"> 
														
														<input type="text" id="end_date1" name="end_date" data-plugin-datepicker data-date-format="dd-mm-yyyy" class="form-control" onblur="getweeks()"/>
														<span class="input-group-addon">
															<i class="fa fa-calendar"></i></span></div>
													
				</div>
				
				<div class="col-md-4">
					<label class="control-label formmodifiedLable" for="inputDefault">Active
				   </label> <select name="active_flag" id="active_flag"	class="form-control" required >
																<option selected="selected" value="Y">Y</option>
																<option  value="N">N</option></select>
				</div>
						
		<!-- <div class="row">
		<div class="col-md-12">
			<div class="col-md-5"></div>
			<div class="col-md-5">
			<input type="submit" value="Save" class="btn btn-primary mb-md"/>
			</div>
			</div>
			<div class="col-md-2">
			</div>
			</div> -->
		</div>
		</div>
		<footer class="panel-footer">
						<div class="row" style="text-align: center">
							<div class="col-sm-12">
								<input type="submit" value="Save" class="btn btn-primary mb-md"/>
							</div>
						</div>
					</footer>
	</section>
	</form>
	</div>
	</div>
</section>
<script>
		function getweeks()
		{
			
			var a=new Date().getDate();
		    var a1=a.toString();
		    var b=new Date().getMonth()+1;
		    var b1=b.toString();
		    var c=new Date().getFullYear();
		    var c1=c.toString();
		
		    var q="-";
		    var d=a1.concat(q);
		    var d1=d.concat(b1);
		    var d2=d1.concat(q);
		    var sysdate=d2.concat(c1);
		    
		    $('#datePicker2')
            .datepicker({


                format: 'dd-mm-yyyy',
                 //startDate: sysdate
                 
            })
             .on('changeDate', function(e) {
                 // Revalidate the date field
					$('#eventForm').formValidation('revalidateField', 'date');
            }); 
		    
		    
			
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
		 <!--  <script>
				    var a=new Date().getDate();
				    var a1=a.toString();
				    var b=new Date().getMonth()+1;
				    var b1=b.toString();
				    var c=new Date().getFullYear();
				    var c1=c.toString();
				
				    var q="-";
				    var d=a1.concat(q);
				    var d1=d.concat(b1);
				    var d2=d1.concat(q);
				    var sysdate=d2.concat(c1);
				
				$('#datePicker1')
				    .datepicker({
				        format: 'dd-mm-yyyy',
				        // startDate: sysdate
				         
				    })
				     .on('changeDate', function(e) {
				         // Revalidate the date field
				         $('#eventForm').formValidation('revalidateField', 'date');
				    });
				
				 $('#datePicker2')
                .datepicker({


                    format: 'dd-mm-yyyy',
                     //startDate: sysdate
                     
                })
                 .on('changeDate', function(e) {
                     // Revalidate the date field
						$('#eventForm').formValidation('revalidateField', 'date');
                }); 
				
		</script>  -->
		 <script>
		function checkattend()
         {
			// alert("hello");
             var complain_date = $('#header_start_date').val();
             
		//	alert(complain_date);
			
			    var a=new Date().getDate();
			    var a1=a.toString();
			    var b=new Date().getMonth()+1;
			    var b1=b.toString();
			    var c=new Date().getFullYear();
			    var c1=c.toString();
			
			    var q="-";
			    var d=a1.concat(q);
			    var d1=d.concat(b1);
			    var d2=d1.concat(q);
			    var sysdate=d2.concat(c1);
			    
			    
			    $('#datePicker1')
			    .datepicker({
						
			        format: 'dd-mm-yyyy',
			         startDate: complain_date,
			      //   endDate: sysdate
			    })
			     .on('changeDate', function(e) {
			         // Revalidate the date field
			         $('#eventForm').formValidation('revalidateField', 'date');
			    });  
			
			
			/*  $('#datePicker2')
			    .datepicker({
						
			        format: 'dd-mm-yyyy',
			         startDate: complain_date,
			      //   endDate: sysdate
			    })
			     .on('changeDate', function(e) {
			         // Revalidate the date field
			         $('#eventForm').formValidation('revalidateField', 'date');
			    });   */
			
 
         }

		</script>
		 

