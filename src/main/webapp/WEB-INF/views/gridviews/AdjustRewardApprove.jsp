<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="apporve_reward" ModelAttribute="Bpil_Opa_Rw_Analysis_Rw"
	method="post" id="Saveform">
	<input type="hidden" name="action" id="action" value="" />
	
	 <!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Adjust Reward Approve</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href=""> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="#!">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="adjustrewardapprove">Adjust Reward Approve</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Page-header end -->

	<!-- start: page -->
	<div class="card">
		<div class="card-header">
			<h5>Reward Approval</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="simpletable"
					class="table table-hover table-bordered nowrap" style="overflow-x: auto;display: block;">
					<thead>
						<tr>
							<th class="text-center"
								style="min-width: 50px !important; font-size: 13px !important;">Select</th>
							<th class="text-center" style="min-width: 50px; font-size: 13px !important;">Detail</th>
							<th class="text-center" style="min-width: 85px; font-size: 13px !important;">Scheme
								Code</th>
							<th class="text-center" style="min-width: 80px; font-size: 13px !important;">Distributors</th>
							<th class="text-center" style="min-width: 40px; font-size: 13px !important;">A/C
								No.</th>
							<th class="text-center" style="min-width: 120px; font-size: 13px !important;">A/C
								Name</th>
							<th class="text-center" 
								style="min-width: 15px !important; font-size: 13px !important;">Type</th>
							<th class="text-center" style="min-width: 55px; font-size: 13px !important;">Reward
								Date</th>
							<th class="text-center" style="min-width: 30px; font-size: 13px !important;">Status</th>
							<th class="text-center" style="min-width: 70px; font-size: 13px !important;">Reward
								Desc</th>
							<th class="text-center" style="min-width: 30px; font-size: 13px !important;">Actual</th>
							<th class="text-center" style="min-width: 30px; font-size: 13px !important;">Requested</th>
							<th class="text-center" style="min-width: 100px; font-size: 13px !important;">Adjustment
								Reason</th>
							<th class="text-center" style="min-width: 20px; font-size: 13px !important;">Gift
								TO CN</th>
							<th class="text-center" style="min-width: 20px; font-size: 13px !important;">Converted
								CN Value</th>
							<th class="text-center" style="min-width: 20px; font-size: 13px !important;">Download
								File</th>

						</tr>
					</thead>
					<tbody>
						<%
							int j = 0;
						%>
						<c:forEach var="info" items="${Info_grid}" varStatus="status">
							<c:set var="interface_status">${info.interface_status}</c:set>
							<c:set var="reward_gift_id">${info.reward_gift_id}</c:set>
							<%
								String interface_status = (String) pageContext.getAttribute("interface_status");
									String reward_gift_id = (String) pageContext.getAttribute("reward_gift_id");
							%>
							<%
								if (interface_status.equals("P")) {
							%>
							<tr
								style="background-color: white; font-size: 11px !important;">
								<%
									} else {
								%>
							
							<tr>
								<%
									}
								%>

								<%
									if (interface_status.equals("P")) {
								%>
								<td
									class="text-center" style="min-width: 50px !important; font-size: 11px !important; height: 44px !important;">

									<div class="clearfix">
										<input name="check" size="2" id="check<%=j%>"
											style="min-width: 50px !important"
											onclick="CheckUserStatusGrid(<%=j%>)" type="checkbox"
											value="" /> <span class="lbl"></span>
									</div> <input type="hidden" id="checkapr<%=j%>"
									name="info[<%=j%>].checkapr" style="width: 100%" value="N" />


								</td>
								<%
									} else {
								%>
								<td
									class="text-center" style="min-width: 100px; font-size: 11px !important; height: 44px !important;">
									<div class="clearfix">
										<span class="lbl"></span>
									</div> <input type="hidden" id="checkapr<%=j%>"
									name="info[<%=j%>].checkapr" style="width: 100%" value="N" />


								</td>
								<%
									}
								%>
								<td class="text-center" style="min-width: 50px; font-size: 11px !important;"><input
									type="button" class="btn btn-primary center"
									id="adjustdetail<%=j%>" style="font-size: 11px !important"
									value="Details" onclick="adjustinfo(<%=j%>)"></td>
								<td class="text-center" style="min-width: 85px; font-size: 11px !important;">${info.attribute2}<input
									type="hidden" id="attribute2<%=j%>"
									name="info[<%=j%>].attribute2" style="width: 100%"
									value="${info.attribute2}" /> <input
									type="hidden" id="dlr_bill_to<%=j%>"
									name="info[<%=j%>].dlr_bill_to" style="width: 100%"
									value="${info.dlr_bill_to}" /><input type="hidden"
									id="opa_analysis_id<%=j%>" name="info[<%=j%>].opa_analysis_id"
									style="width: 100%" value="${info.opa_analysis_id}" /> <input
									type="hidden" id="scheme_id<%=j%>"
									name="info[<%=j%>].scheme_id" value="${info.scheme_id}" /> <input
									type="hidden" id="scheme_name<%=j%>"
									name="info[<%=j%>].scheme_name" value="${info.attribute3}" />
									<input type="hidden" id="opa_rw_an_dealer_id<%=j%>"
									name="info[<%=j%>].opa_rw_an_dealer_id"
									value="${info.opa_rw_an_dealer_id}" />
								</td>
								<input type="hidden" id="regn<%=j%>" name="info[<%=j%>].regn"
									style="min-width: 100%" value="${info.regn}" />
								<input type="hidden" id="state<%=j%>" name="info[<%=j%>].state"
									style="min-width: 100%" value="${info.state}" />
								<td class="text-center" style="min-width: 80px; font-size: 11px !important;">${info.depot}<input
									type="hidden" id="depot<%=j%>" name="info[<%=j%>].depot"
									style="min-width: 100%" value="${info.depot}" /></td>
								<input type="hidden" id="terr_code<%=j%>"
									name="info[<%=j%>].terr_code" style="min-width: 100%"
									value="${info.terr_code}" />
								<input type="hidden" id="terr_name<%=j%>"
									name="info[<%=j%>].terr_name" style="min-width: 100%"
									value="${info.terr_name}" />
								<td class="text-center" style="min-width: 40px; font-size: 11px !important;">${info.dlr_ac_no}<input
									type="hidden" id="dlr_ac_no<%=j%>"
									name="info[<%=j%>].dlr_ac_no" style="min-width: 100%"
									value="${info.dlr_ac_no}" /></td>
								<input type="hidden" id="dlr_bill_to<%=j%>"
									name="info[<%=j%>].dlr_bill_to" style="min-width: 100%"
									value="${info.dlr_bill_to}" />
								<input type="hidden" id="dlr_cat<%=j%>"
									name="info[<%=j%>].dlr_cat" style="min-width: 100%"
									value="${info.dlr_cat}" />
								<input type="hidden" id="dlr_type<%=j%>"
									name="info[<%=j%>].dlr_type" style="min-width: 100%"
									value="${info.dlr_type}" />
								<td class="text-center" style="min-width: 120px; font-size: 11px !important;">${info.dlr_name}<input
									type="hidden" id="dlr_name<%=j%>" name="info[<%=j%>].dlr_name"
									style="min-width: 100%" value="${info.dlr_name}" /></td>
								<td class="text-center" 
									style="min-width: 15px !important; font-size: 11px !important;">${info.reward_type}<input
									type="hidden" id="reward_type<%=j%>"
									name="info[<%=j%>].reward_type" style="min-width: 100%"
									value="${info.reward_type}" /></td>
								<td class="text-center" style="min-width: 55px; font-size: 11px !important;">${info.reward_date1}<input
									type="hidden" id="reward_date<%=j%>"
									name="info[<%=j%>].reward_date" style="min-width: 100%"
									value="${info.reward_date1}" /> <input type="hidden"
									id="rewardDate<%=j%>" name="info[<%=j%>].rewardDate"
									style="min-width: 100%" value="${info.reward_date1}" />
								</td>
								<td class="text-center" style="min-width: 30px; font-size: 11px !important;">${info.reward_status}<input
									type="hidden" id="reward_status<%=j%>"
									name="info[<%=j%>].reward_status" style="min-width: 100%"
									value="${info.reward_status}" /></td>
								<input type="hidden" id="additional<%=j%>"
									name="info[<%=j%>].additional" style="min-width: 100%"
									value="${info.additional}" />
								<td class="text-center" style="min-width: 70px; font-size: 11px !important;">${info.reward_description}<input
									type="hidden" id="reward_description<%=j%>"
									name="info[<%=j%>].reward_description" style="min-width: 100%"
									value="${info.reward_description}" /></td>
								<td class="text-center" style="min-width: 30px; font-size: 11px !important;">${info.reward_total}<input
									type="hidden" id="reward_total<%=j%>"
									name="info[<%=j%>].reward_total" style="min-width: 100%"
									value="${info.reward_total}" /></td>
								<%
									if (interface_status.equals("P")) {
								%>
								<td
									class="text-center" style="min-width: 30px !important; font-size: 11px !important;"><input
									size="1" type="text" id="adjustments<%=j%>"
									name="info[<%=j%>].adjustments" value="${info.adjustments}"
									style="min-width: 75px !important;" class="form-control"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}" /></td>
								<td
									class="text-center" style="min-width: 100px !important; font-size: 11px !important;"><input
									size="4" type="text" id="adjustment_reason<%=j%>"
									name="info[<%=j%>].adjustment_reason" class="form-control"
									style="min-width: 100px !important;"
									value="${info.adjustment_reason}" class="adjustreason" /></td>

								<td class="text-center" style="min-width: 60px; font-size: 11px !important;">
									<%
										if (reward_gift_id.equals("")) {
									%> <input type="hidden" id="reward_gift_id<%=j%>"
									name="info[<%=j%>].reward_gift_id" style="width: 100%"
									value="${info.reward_gift_id}" /> <input type="text" size="1"
									style="min-width: 60px !important" class="form-control"
									id="gift_to_cn_flag<%=j%>" name="info[<%=j%>].gift_to_cn_flag"
									value="${info.gift_to_cn_flag}" readonly /> <%
 	} else {
 %> <input type="hidden" id="reward_gift_id<%=j%>"
									name="info[<%=j%>].reward_gift_id" style="width: 100%"
									value="${info.reward_gift_id}" /> <input type="text" size="1"
									style="min-width: 60px !important" id="gift_to_cn_flag<%=j%>"
									name="info[<%=j%>].gift_to_cn_flag" class="form-control"
									value="${info.gift_to_cn_flag}" onblur="gifttocn(<%=j%>)" /> <%
 	}
 %>
								</td>
								<td
									class="text-center" style="min-width: 20px !important; font-size: 11px !important;"><input
									size="1" type="text" id="converted_cn_value<%=j%>"
									style="min-width: 65px !important;"
									name="info[<%=j%>].converted_cn_value"
									value="${info.converted_cn_value}" class="form-control"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}"
									readonly="readonly" /></td>
								<input type="hidden" id="attribute1<%=j%>"
									name="info[<%=j%>].attribute1" value="${info.attribute1}"
									readonly />
								<td class="text-center" ><a
									href="DowdRwDocument?rw_opa_id=${info.opa_analysis_id}&rw_sch_id=${info.scheme_id}"><i
										class="fa fa-download bigger-160" aria-hidden="true"></i></a></td>
								<%
									} else {
								%>
								<td
									class="text-center" style="min-width: 30px !important; font-size: 11px !important;">${info.adjustments}<input
									type="hidden" id="adjustments<%=j%>"
									style="min-width: 50px !important;"
									name="info[<%=j%>].adjustments" value="${info.adjustments}"
									class="adjustpoints" onkeypress="return isNumber(event);"
									pattern="[0-9]{1,15}" /></td>
								<td class="text-center" style="min-width: 100px; font-size: 11px !important;">${info.adjustment_reason}<input
									type="hidden" id="adjustment_reason<%=j%>"
									name="info[<%=j%>].adjustment_reason" style="min-width: 150px;"
									value="${info.adjustment_reason}" class="adjustreason" /></td>

								<td class="text-center" style="min-width: 20px; font-size: 11px !important;">${info.gift_to_cn_flag}<input
									type="hidden" id="gift_to_cn_flag<%=j%>"
									name="info[<%=j%>].gift_to_cn_flag" style="min-width: 60px;"
									value="${info.gift_to_cn_flag}" class="adjustgift" /></td>
								<td class="text-center" style="min-width: 30px; font-size: 11px !important;">${info.converted_cn_value}<input
									type="hidden" id="converted_cn_value<%=j%>"
									name="info[<%=j%>].converted_cn_value" style="min-width: 60px;"
									value="${info.converted_cn_value}" class="adjustcn"
									onkeypress="return isNumber(event);" pattern="[0-9]{1,15}" /></td>
								<input type="hidden" id="attribute1<%=j%>"
									name="info[<%=j%>].attribute1" value="${info.attribute1}" />
								<td class="text-center" ><a
									href="DowdRwDocument?rw_opa_id=${info.opa_analysis_id}&rw_sch_id=${info.scheme_id}"><i
										class="fa fa-download bigger-160" aria-hidden="true"></i></a></td>
								<%
									}
								%>

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
	<!-- end: page -->

	<div class="form-group">
		<div class="col-md-12" style="text-align: center;">
			<input type="button" class="btn btn-primary btn-sm" id="action1"
				name="apr_selected" value="Approve Selected" onclick="submitform()"></input>
			<input type="button" class="btn btn-primary btn-sm" id="action2"
				name="rj_all" value="Reject Selected" onclick="submitform1()"></input>
			<input type="button" class="btn btn-primary btn-sm" id="action3"
				name="apr_all" value="Approve All" onclick="submitform2()"></input>
		</div>
	</div>

</form>
<script>
$(window).load(function(){
	
	$('.col-xs-12.col-sm-12').css({'overflow-x':'auto'});
	var scheme_id=document.getElementById("scheme_id0").value;
	console.log(scheme_id);
	
});
</script>

<script>

function submitform()
{
	$('#action').val("Approve");
     var aa = confirm('Do you want to approve this scheme adjustment?')
     if(aa == true)
     {
    	 //var table = $('#datatable-editable2').DataTable();
    	 var table = $('#simpletable').DataTable();
    	 
    	 var data = table.$('input, select').serialize();
    	 var formdata = $('#Saveform').serialize();
    	 
         $('#Saveform').submit();
         
//          $.ajax({
//			    url: '${pageContext.request.contextPath}/updateoutput',
//			   type: 'post',
//			    data: data,
//			    success: function(data) {				        	
			    	
//			    }
//			  });
         
         }
     else {
             return false;
         }
}

function submitform1()
{
	$('#action').val("Reject");
     var aa = confirm('Are you sure to reject this scheme adjustment?')
     if(aa == true)
     {
         $('#Saveform').submit();
         }
     else {
             return false;
         }
}

function submitform2()
{
	$('#action').val("ApproveAll");
     var aa = confirm('Do you want to approve All this scheme adjustment?')
     if(aa == true)
     {
    	// var table = $('#datatable-editable2').DataTable();
    	 var table = $('#simpletable').DataTable();
    	 var data = table.$('input, select').serialize();
    	 var formdata = $('#Saveform').serialize();
    	 
         $('#Saveform').submit();
         
//          $.ajax({
//			    url: '${pageContext.request.contextPath}/updateoutput',
//			   type: 'post',
//			    data: data,
//			    success: function(data) {				        	
			    	
//			    }
//			  });
         
         }
     else {
             return false;
         }
}

function submitform3()
{
	$('#action').val("Export");
    $('#Saveform').submit();
}

function CheckUserStatusGrid(id)
{
	var active = "check"+id;
//  	alert("id "+id+" active "+active);
	//var result= id.replace(/[A-Za-z$-]/g, "");
// 	alert(result)
	if(document.getElementById(active).checked == true){
		$("#checkapr"+id).val('Y');
// 		alert($("#checkapr"+id).val());
	}else if(document.getElementById(active).checked == false){
		$("#checkapr"+id).val('N');
// 		alert($("#checkapr"+id).val());
	}
}

function adjustinfo(j)
{
	var scheme_id=document.getElementById("scheme_id"+j).value;	
	var opa_rw_an_dealer_id=document.getElementById("opa_rw_an_dealer_id"+j).value;
	var scheme_name=document.getElementById("scheme_name"+j).value;
	var scheme_code=document.getElementById("attribute2"+j).value;
	var depot=document.getElementById("depot"+j).value;
	var dlr_name=document.getElementById("dlr_name"+j).value;
	var dlr_ac_no=document.getElementById("dlr_ac_no"+j).value;
	
	var x = screen.availWidth-20;
	var y = screen.availHeight-40;
	
	window.open("adjust_reward_detail?scheme_id="+scheme_id+"&opa_rw_an_dealer_id="+opa_rw_an_dealer_id+"&scheme_code="+scheme_code+"&depot="+depot+"&dlr_ac_no="+dlr_ac_no,"Ratting","width="+x+",height="+y+",left=0,top=0,toolbar=0,status=0,");
	
	// window.location.href="adjust_reward_detail?scheme_id="+scheme_id+"&opa_rw_an_dealer_id="+opa_rw_an_dealer_id;
	
}
</script>
