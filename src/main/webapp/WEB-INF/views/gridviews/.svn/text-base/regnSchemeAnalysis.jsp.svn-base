
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Scheme Analysis</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<form action="updateoutput" method="post" id="Saveform">
		<div class="form-group">
			<div class="col-md-12">
				
				<div class="col-md-4">
				<label class="control-label" for="inputSuccess">Scheme Name
						: </label>
					<select class="form-control input-sm mb-md populate"
						data-plugin-selectTwo name="scheme_name" id="scheme_name"
						required="required">
						
						<option value="${scheme_id}">--Select--</option>
											
					</select>
				</div>
				<div class="col-md-4"></div>
				
				<div class="col-md-4">
				<label class="control-label" for="inputSuccess">Distributors Name
						: </label>
					<select class="form-control input-sm mb-md populate" name="depot_name"
						data-plugin-selectTwo id="depot_name" required="required">
						<option>--Select--</option>
					</select>
				</div>
				
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12" style="text-align: center;">
				<input type="button" class="btn btn-primary" id="action4"
					name="gen_report" value="Show Report" onclick="myFunction2()"></input>
				<input type="button" class="btn btn-primary" id="action5"
					name="show_report" value="Download Report" onclick="myFunction4()"></input>
			</div>
		</div>

		<hr>
		<label><strong>Last Refreshed : ${LastRefresh}</strong>	</label>
		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a> 
				</div>
				<h2 class="panel-title">Reward Details</h2>

			</header>
			<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<th class="center" width="10%">Region</th>
							<th class="center" width="20%">State</th>
							<th class="center" width="10%">Distributors</th>
							<th class="center" width="10%">Sup Code</th>
							<th class="center" width="20%">Sup Name</th>
							<th class="center" width="5%">Terr</th>
							<th class="center" width="40%">Terr Name</th>
							<th class="center" width="10%">A/C No.</th>
							<th class="center" width="10%">Bill To</th>
							<th class="center" width="15%">Dlr Cat</th>
							<th class="center" width="15%">Cust Type</th>
							<th class="center" width="40%">A/C Name</th>
							<th class="center" width="20%">Reward Section</th>
							<th class="center" width="15%">Reward Type</th>
							<th class="center" width="15%">Product</th>
							<th class="center" width="15%">Unit</th>
							<th class="center" width="20%">Reward Date</th>
							<th class="center">LY</th>
							<th class="center" width="15%">Target</th>
							<th class="center" width="15%">TY</th>
							<th class="center" width="15%">TGT Pending</th>
							<th class="center" width="15%">Status</th>
							<th class="center" width="15%">Add PTS</th>
							<th class="center" width="20%">Reward Desc</th>
							<th class="center" width="15%">Reward</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 1;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<c:set var="reward_section_total">${info.reward_section}</c:set>
							<c:set var="reward_color">${info.reward_color}</c:set>
							<%
								String reward_section_total = (String) pageContext.getAttribute("reward_section_total");
							%>
							<tr>

								<td bgcolor="<c:out value='${reward_color}'/>"><input
									type="hidden" id="opa_analysis_id<%=j%>" name="opa_analysis_id"
									style="width: 100%" value="${info.opa_analysis_id}" /> <input
									type="hidden" id="scheme_id<%=j%>" name="scheme_id"
									value="${info.scheme_id}" /> ${info.regn}<input type="hidden"
									id="regn<%=j%>" name="regn" style="width: 100%"
									value="${info.regn}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.state}<input
									type="hidden" id="state<%=j%>" name="state" style="width: 100%"
									value="${info.state}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.depot}<input
									type="hidden" id="depot<%=j%>" name="depot" style="width: 100%"
									value="${info.depot}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.sup_code}<input
									type="hidden" id="sup_code<%=j%>" name="sup_code"
									style="width: 100%" value="${info.sup_code}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.sup_name}<input
									type="hidden" id="sup_name<%=j%>" name="sup_name"
									style="width: 100%" value="${info.sup_name}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.terr_code}<input
									type="hidden" id="terr_code<%=j%>" name="terr_code"
									style="width: 100%" value="${info.terr_code}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.terr_name}<input
									type="hidden" id="terr_name<%=j%>" name="terr_name"
									style="width: 100%" value="${info.terr_name}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_ac_no}<input
									type="hidden" id="dlr_ac_no<%=j%>" name="dlr_ac_no"
									style="width: 100%" value="${info.dlr_ac_no}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_bill_to}<input
									type="hidden" id="dlr_bill_to<%=j%>" name="dlr_bill_to"
									style="width: 100%" value="${info.dlr_bill_to}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_cat}<input
									type="hidden" id="dlr_cat<%=j%>" name="dlr_cat"
									style="width: 100%" value="${info.dlr_cat}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_type}<input
									type="hidden" id="dlr_type<%=j%>" name="dlr_type"
									style="width: 100%" value="${info.dlr_type}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.dlr_name}<input
									type="hidden" id="dlr_name<%=j%>" name="dlr_name"
									style="width: 100%" value="${info.dlr_name}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_section}<input
									type="hidden" id="reward_section<%=j%>" name="reward_section"
									style="width: 100%" value="${info.reward_section}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_type}<input
									type="hidden" id="reward_type<%=j%>" name="reward_type"
									style="width: 100%" value="${info.reward_type}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.product}<input
									type="hidden" id="product<%=j%>" name="product"
									style="width: 100%" value="${info.product}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.unit}<input
									type="hidden" id="unit<%=j%>" name="unit" style="width: 100%"
									value="${info.unit}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_date1}<input
									type="hidden" id="reward_date<%=j%>" name="reward_date"
									style="width: 100%" value="${info.reward_date1}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ly}<input
									type="hidden" id="reward_ly<%=j%>" name="reward_ly"
									style="width: 100%" value="${info.reward_ly}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_target}<input
									type="hidden" id="reward_target<%=j%>" name="reward_target"
									style="width: 100%" value="${info.reward_target}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_ty}<input
									type="hidden" id="reward_ty<%=j%>" name="reward_ty"
									style="width: 100%" value="${info.reward_ty}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.next_tgt_pending}<input
									type="hidden" id="next_tgt_pending<%=j%>"
									name="next_tgt_pending" style="width: 100%"
									value="${info.next_tgt_pending}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_status}<input
									type="hidden" id="reward_status<%=j%>" name="reward_status"
									style="width: 100%" value="${info.reward_status}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.additional}<input
									type="hidden" id="additional<%=j%>" name="additional"
									style="width: 100%" value="${info.additional}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_description}<input
									type="hidden" id="reward_description<%=j%>"
									name="reward_description" style="width: 100%"
									value="${info.reward_description}" /></td>
								<td bgcolor="<c:out value='${reward_color}'/>">${info.reward_total}<input
									type="hidden" id="reward_total<%=j%>" name="reward_total"
									style="width: 100%" value="${info.reward_total}" /></td>
							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
		
		
			<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a> 
				</div>
				<h2 class="panel-title">Document Details</h2>

			</header>
		<div class="panel-body">
				<table class="table table-bordered table-striped"
					id="datatable-editable1"
					data-url="assets/ajax/ajax-datatables-sample.json">
					<thead>
						<tr>
							<!-- <th class="center" width="10%">Region</th>
							<th class="center" width="20%">State</th>
							<th class="center" width="10%">Depo</th> -->
							
							
							 <th class="center" >Sr. No.</th>
                             <th class="center">Document Type</th>
                             <th class="center" >Document Title</th>
                             <th class="center">Reference Number</th>
                             <th class="center" >Upload Date </th>
                             <th class="center" >Download File</th>
						</tr>
					</thead>
					 <tbody>

        											<%int i=1; %>
                    								<c:forEach var="grp_reg" items="${doc_list}" varStatus="status">

										                <tr>
										                <td>
										                     <%=i%>
										                         <input type="hidden" value="${grp_reg.scheme_doc_id}" id="scheme_doc_id<%=i%>" name="scheme_doc_id" />
										                     
										                 </td>
										
										                <td> 
										                        <input type="text"class="lovdata" id="doc_type<%=i%>" name="doc_type" value="${grp_reg.doc_type}" style="width:100%;" readonly/>
										
										                    
										                </td>
										
										                <td>
										                    <input type="text" id="doc_title<%=i%>" name="doc_title" value="${grp_reg.doc_title}" style="width:100%;" readonly/>
										                   </td>
										
										                <td>
										                    <input type="text" id="doc_srl_no<%=i%>" name="doc_srl_no" value="${JSON.scheme_srl_no}" style="width:100%;" readonly/>
										                   </td>
										                <td>
										                    <input type="text" id="doc_upload_date<%=i%>" name="doc_upload_date" value="${grp_reg.doc_upload_date1}" style="width:100%;" readonly/>
										                   </td>
										
										                <td>
										                    <a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i class="fa fa-download bigger-160" aria-hidden="true"></i></a>
										                   </td>
										                </tr>
                										<% i=i+1; %>
                    								</c:forEach>


                                					</tbody>
				</table>
			</div>
			</section>
			
		
		
		
	</form>
	<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	$(document).ready(function() {
		$('#datatable-editable').DataTable().draw();
		$('#datatable-editable1').DataTable().draw();
	});
</script>




<script>
function abc()
{
$.ajax({
    url: '${pageContext.request.contextPath}/getschemenameregn',	
    success: function(data) {				        	
    	
    	var select = $('#scheme_name');
    	select.find('option').remove();
    	$('<option>').val("").text("--Select--").appendTo(select);
           	  $.each(data, function(index, value) {	
           		 var scheme_nm_code = value.scheme_name + '(' + value.scheme_code + ')';
           		  if(value.scheme_id == "${scheme_id}"){
    	  			$('<option selected>').val(value.scheme_id).text(scheme_nm_code).appendTo(select);
           		  }else{
           			$('<option>').val(value.scheme_id).text(scheme_nm_code).appendTo(select);
           		  }
    	});

    }
  });
  
var region = "${scheme_id}";
$.ajax({
    url: '${pageContext.request.contextPath}/getschemeregnanalysis',
//    data: ({depot :region}),
    success: function(data) {

        var select = $('#depot_name');
        select.find('option').remove();
        $('<option>').val("").text("--Select--").appendTo(select);
// 		$('<option>').val("").text("--Select--").appendTo(select);
            $.each(data, function(index, value) {
            	
            	 if(value.depot_code == "${deptnm}"){

					$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
            	 } else {
            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
            	 }

        });

    }
 });



$('#scheme_name').change(function(event) {
    var region = $("select#scheme_name").val();
    $.ajax({
        url: '${pageContext.request.contextPath}/getschemeregnanalysis',
//        data: ({depot :region}),
        success: function(data) {

            var select = $('#depot_name');
            select.find('option').remove();
            $('<option>').val("").text("--Select--").appendTo(select);
// 			$('<option>').val("").text("--Select--").appendTo(select);
	            $.each(data, function(index, value) {
	            	
// 	            	 if(value.depot_code == "${deptnm}"){

// 						$('<option selected>').val(value.depot_code).text(value.depot_name).appendTo(select);
// 	            	 } else {
	            		 $('<option>').val(value.depot_code).text(value.depot_name).appendTo(select);
// 	            	 }

            });

        }
     });

});

}

</script>
<script>
        function myFunction1()
        {
        	
        	setTimeout(myFunction3, 1000);
        	  var depot_name = $('#depot_name').val();
              var scheme_id = $('#scheme_name').val();
              var finanalysis = "0";
              
        	$.ajax({
			    url: '${pageContext.request.contextPath}/callopa',
			    data:({depot_name : depot_name ,scheme_id : scheme_id, finanalysis : finanalysis}),
			    success: function(data) {				        	
			    	
			       		$("#loading").hide();
			       		myFunction2();
			    }
			  });
             		
    	
        		
        	
       //	 window.location.href = "loadoutputdata?deptnm="+depot_name+"&&schnm="+scheme_name+"";
        }
        
        function myFunction3()
        {
        	$("#loading").show();	
        }

        function myFunction2()
        {
//         	 $("#gen_report").hide(); 
            var depot_name = $('#depot_name').val();
            var scheme_name = $('#scheme_name').val();

        window.location.href = "loadregnoutputdata?deptnm="+depot_name+"&&schnm="+scheme_name+"";
        //$("#show_details").show();
        }
        </script>

		
		<script>
		    function submitform()
		    {
		    	$('#action').val("Update");
		         var aa = confirm('Do you want to update this scheme?')
		         if(aa == true)
		         {
		             $('#Saveform').submit();
		             }
		         else {
		                 return false;
		             }
		    }
		    
		    function submitform1()
		    {
		    	$('#action').val("Freeze");
		         var aa = confirm('Are you sure to freeze this scheme?')
		         if(aa == true)
		         {
		             $('#Saveform').submit();
		             }
		         else {
		                 return false;
		             }
		    }
		    </script>
		    
<script>
		 $('.docalculation').keyup(function(){
			 
			 $('#sch_total'+count).val("0"); 
			 
			var count = $('.docalculation').index(this)+1;
			 var sch_ty_tot_vol = $('#sch_ty_tot_vol'+count).val();  
			 var sch_adjusted = $('#sch_adjusted'+count).val();  
			 
			 var sum = parseInt(sch_ty_tot_vol) + parseInt(sch_adjusted);
			 
			 $('#sch_total'+count).val(sum);  
			 $('#change_flag'+count).val("Y");  
		 });		
		</script>
		
		
		
		<script>
	$(document).ready(function(){
		
		$("#loading").hide();
		
	});
	</script>