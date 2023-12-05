<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="rulelibrary" method="post">
	<!-- start: page -->
	<div class="card">
		<div class="card-header">
			<h5>Rule Library</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive">
				<table id="simpletable"
					class="table table-striped table-bordered nowrap">
					<thead>
						<tr>
							<th style="width: 5%">Sr.No.</th>
							<th style="width: 10%">select</th>
							<th style="width: 35%">Rule Name</th>
							<th style="width: 30%">No of Files</th>
							<th style="width: 40%">Comments</th>
						</tr>
					</thead>
					<tbody>
						<%
						int j = 1;
						%>
						<c:forEach var="info" items="${Ruledata}" varStatus="status">
							<tr id="tbl">
								<td><%=j%> <input type="hidden" name="rule_id"
									id="rule_id<%=j%>" value="${info.rule_id}" /></td>
								<td id="chk">
									<div class="clearfix">
										<input name="sel1" id="sel<%=j%>"
											class="ace ace-switch ace-switch-6" type="checkbox"
											onblur="CheckUserStatus(<%=j%>)" value="0" /> <span
											class="lbl"></span>
									</div>
								</td>

								<td>${info.rule_name}</td>
								<td>${info.attribute1}</td>
								<td>${info.comments}</td>

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
			<a href="addrule" style="" class="btn btn-primary btn-sm"
				onclick="addrule()">Add New Ruleoo</a> <input type="submit"
				class="btn btn-primary btn-sm" id="action3" value="Download file"
				onclick="checkdata()"></input> <input type="button"
				class="btn btn-primary btn-sm" id="action4" value="Delete"
				onclick="deletedata()"></input>
				<input type="button"
				class="btn btn-primary btn-sm" id="action5" value="Check"
				onclick="checkdata()"></input>

		</div>
	</div>

</form>
<!-- </section> -->

<script>
function myFunction()
{
	alert();
	console.log("gdysgdusuydgusghshdshtrtyurii");

	}

function deletedata()
{
	console.log("gdysgdusuydgusghshdshtrtyurii");
	alert("hii shilpi");
	<!--
	var d = row.parentNode.parentNode.rowIndex;
	console.log(d);
	document.getElementsByName('simpletable').deleteRow(d);
	alert('iiiiiiiiiiiiiiiiii');
	document.getElementsById('simpletable').deleteRow(0);-->
	

 			
 	}
 	
 	
function addrule()
{
	
	
}
</script>


<script src="resources/newportal/vendor/jquery/jquery.js">

</script>

<script>

	$(document).ready(function() {
		//alert("***");

		//	$.getJSON('${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval', // ${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval
		//	function(json) {
		/*
		$('#datatable-editable').dataTable( {
		    "aaData": json,
		    "columns": [
		        { "data": "scheme_id" } ,
		        { "data": "scheme_name" },
		        { "data": "scheme_code" },
		        { "data": "start_date1" }, 
		        { "data": "end_date1" },
		        { "data": "submission_date1" },
		        { "data": "active_flag" }
		    ]
		})
		 */

		//	var tr;
		/*
		$('#datatable-editable').DataTable().destroy();
		 */

		/* 	for (var i = 0; i < json.length; i++) {

				tr = $('<tr/>');
				tr.append("<td>" +i+"</td>");
				tr.append("<td>" + json[i].scheme_name + "</td>");
				tr.append("<td>" +  json[i].scheme_code + "</td>");
				tr.append("<td>" + json[i].start_date1 + "</td>");
				tr.append("<td>" + json[i].end_date1 + "</td>");
				tr.append("<td>" + json[i].submission_date1 + "</td>");
				tr.append("<td>" + json[i].active_flag + "</td>");
		
				$('#datatable-editable').find('tbody').append(tr);
				//$('#datatable-editable').append(tr);
			}
		 */

		$('#datatable-editable').DataTable().draw();

		/* 	});  */

		//var oTable = $('#datatable-editable').DataTable( );
		// to reload
		//oTable.ajax.reload();
		/*
		var table = $('#datatable-editable').DataTable();
		table.draw();
		 */

		/*
		$.ajax({
		'url': "${pageContext.request.contextPath}/load_Pending_IT_Scheme_Approval",
		'method': "GET",
		'contentType': 'application/json'
		}).done( function(data) {
		$('#datatable-editable').dataTable( {
		    "aaData": data,
		    "columns": [
		        { "data": "scheme_id" } ,
		        { "data": "scheme_name" },
		        { "data": "scheme_code" },
		        { "data": "start_date1" }, 
		        { "data": "end_date1" },
		        { "data": "submission_date1" },
		        { "data": "active_flag" }
		    ]
		})
		}); */

	});
</script>

<script type="text/javascript">
function deletedata()
{
	/* alert("shilpi byee");
	
		  const table = document.getElementById("simpletable");
		  for (const [index, row] of [...table.rows].entries()) {
		    if (row.querySelector('input:checked')) {
		      table.deleteRow(index);
		    
		  }
		} */
		
		const table = document.getElementById("simpletable");
		  for (const [index, row] of [...table.rows].entries()) {
		    if (row.querySelector('input:checked')) {
		    	var prd_line_type = table.deleteRow(index);
		    	console.log(prd_line_type);
		    }
		  }
		      
		
	$.ajax({
        url: '${pageContext.request.contextPath}/deleterow',
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



	}

function CheckUserStatus(j) {

	if (document.getElementById("sel"+j).checked == true) {
		document.getElementById("sel"+j).value = $('#rule_id'+j).val();

	} else if (document.getElementById("sel"+j).checked == false) {
		document.getElementById("sel"+j).value = 0;
	}
}


function checkdata()

{
	
	alert("checkedddd");
 	var linelen = document.getElementsByName('sel').length;	
 		for (var i=1; i<=linelen; i++) 
 		{
			
 			if(document.getElementsByName('sel')[i].checked)
 				{					
 					var aa =$('#rule_id'+i).val(); 
 					$('#sel'+i).val(aa); 
 				}else
 				{
 				}
 		}	
 	}	
 	
</script>
