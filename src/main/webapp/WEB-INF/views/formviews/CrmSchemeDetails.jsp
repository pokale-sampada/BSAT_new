
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="card">
	<div class="card-header">
		<h5>Review Scheme Details</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-bordered" method="get">
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Name<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${SCHEME_NAME}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Code</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${SCHEME_CODE}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Status</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${ACTIVE_FLAG}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Type</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary" disabled=""
						name="scheme_type" id="scheme_type"
						value="${SCHEME_TYPE}" readonly="readonly">
				</div>
				<!--  Row 2 Started -->
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Business
						Line<span class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled=""
						value="${SCHEME_BUSINESS_LINE}" required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Serial No<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${SCHEME_SRL_NO}"
						required>
				</div>

			</div>
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Budget<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${SCHEME_BUDGET}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Version</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${REVISION}">
				</div>
				<!--  Row 3 Started -->
				<div class="col-md-4">
					<label class="block" for="inputDefault">Effective Date From<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${START_DATE}"
						required>
				</div>
			</div>



			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Effective Date To<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${END_DATE}" required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Redemption Date<span
						class="required menu-icon fa red">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${REDEMPTION_DATE}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Fin Month<span
						class="required re">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${SCHEME_FIN_MONTH}"
						required>
				</div>
			</div>

			<!--  Row 4 Started -->
	
			<div class="form-group row">
				<div class="col-md-4">
					<label class="block" for="inputDefault">Fin Year<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${SCHEM_FIN_YEAR}"
						required>
				</div>
				<!--  Row 5 Started -->
				

				<div class="col-md-4">
					<label class="block" for="inputDefault">Scheme Level</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary" disabled=""
						name="scheme_level" id="scheme_level" value="${SCHEME_LEVEL}"
						readonly="readonly">
				</div>
				
					<div class="col-md-4">
					<label class="block" for="inputDefault">Company Type </label> <input
						type="text"
						class="form-control form-control-sm form-control-primary" disabled=""
						name="scheme_level" id="scheme_level" value="${COMPANY_TYPE}"
						readonly="readonly">
				</div>
			</div>

			<div class="form-group row">
				<label class="block" for="inputDefault" value="${SCH_OBJECTIVE}">Objective</label>
				<textarea class="form-control form-control-sm form-control-primary"
					rows="3" id="textareaAutosize" data-plugin-textarea-autosize
					disabled=""></textarea>
			</div>
		</form>
	</div>
</div>
<div class="card">
	<div class="card-header">
		<h5>Budget details</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<form class="form-horizontal form-bordered" method="get">
			<div class="form-group row">
				<div class="col-md-4" hidden>
					<label class="block" for="inputDefault">Adex id</label> <input
						type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${JSON.provision_id}">
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Budget Available<span
						class="required">*</span>
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${BUDGET_AVAILABLE}"
						required>
				</div>
				<div class="col-md-4">
					<label class="block" for="inputDefault">Provision Required
					</label> <input type="text"
						class="form-control form-control-sm form-control-primary"
						id="inputDisabled" disabled="" value="${PROVISION_ID}">
				</div>
			</div>
		</form>
	</div>
</div>

<div class="card">
	<div class="card-header">
		<h5>Scheme Related Details</h5>
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
			<div class="col-md-4">
				<label class="block" for="inputDefault">Scheme Created By</label> <input
					type="text"
					class="form-control form-control-sm form-control-primary"
					id="inputDisabled" disabled="" value="${CREATED_BY} ">
			</div>
			<div class="col-md-4">
				<label class="block" for="inputDefault">Scheme Created On</label> <input
					type="text"
					class="form-control form-control-sm form-control-primary"
					id="inputDisabled" disabled="" value="${JSON.creation_date1}">
			</div>
		</div>
	</div>
</div>


<div class="card">
	<div class="card-header">
		<h5>Document Details</h5>
		<div class="card-header-right">
			<ul class="list-unstyled card-option">
				<li><i class="feather icon-maximize full-card"></i></li>
				<li><i class="feather icon-minus minimize-card"></i></li>
				<li><i class="feather icon-trash-2 close-card"></i></li>
			</ul>
		</div>
	</div>
	<div class="card-block">
		<div class="dt-responsive table-responsive">
			<table id="simpletable"
				class="table table-striped table-bordered nowrap">
				<thead>
					<tr>
						<th style="width: 10%">SR No</th>
						<th style="width: 20%">Document Type</th>
						<th style="width: 30%">Document Title</th>
						<th style="width: 10%">Version</th>
						<th style="width: 15%">Upload Date</th>
						<th style="width: 15%">Download File</th>

					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
					%>
					<c:forEach var="grp_reg" items="${doc_list}" varStatus="status">
						<tr>
							<td><%=i%> <%--                          <input type="hidden" value="${grp_reg.scheme_doc_id}" id="scheme_doc_id<%=i%>" name="scheme_doc_id" /> --%>
							</td>

							<td>${grp_reg.doc_type}</td>

							<td>${grp_reg.doc_title}</td>

							<td>${grp_reg.revision}</td>
							<td>${grp_reg.doc_upload_date1}</td>

							<td><div class="col-sm-12 col-md-6 col-lg-4 outer-ellipsis"><a href="DowdDocument?Doc_id=${grp_reg.scheme_doc_id}"><i
									class="typcn typcn-download"></i></a></div></td>

						</tr>
						<%
							i = i + 1;
						%>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="form-group row">
			<div class="col-md-5"></div>

			<div class="col-md-3">
				<input type="hidden" name="scheme_id" id="scheme_id"
					value="${JSON.scheme_id}" /> <input type="button"
					class="btn btn-primary btn-sm" id="show" value="Show All Documents"
					onclick="show_all_doc()" />
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
alert('${SCHEME_NAME}');
</script>
<script>
	$(window).load(function() {

		$('.col-xs-12.col-sm-12').css({
			'overflow-x' : 'auto'
		});
		
		$('.required').css({
			'color' : 'red'
		});
		
		
	});
	
	  function show_all_doc()

     {
       var aa=$('#show').val();

       var s_id=document.getElementById("scheme_id").value;

        // window.location.href="show_doc";

       window.open("show_doc?scheme_id="+s_id,"Ratting","width=750,height=550,left=250,top=200,toolbar=0,status=0,");

     }
	
</script>