<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="https://datatables.net/release-datatables/media/css/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="https://datatables.net/release-datatables/extensions/Responsive/css/responsive.bootstrap.css"/>
<link href="https://datatables.net/release-datatables/extensions/FixedHeader/css/fixedHeader.bootstrap.css" rel="stylesheet">

</head>
<body>

	<div class="card">
		<div class="card-header">
			<h5>Scheme Master</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		
		<div class="card-block">
			<div class="">
				<table id="example"
					class="table table-striped table-bordered nowrap">
					<thead>
						<tr>
							<th class="text-center" width="10%">Sr.No.</th>
							<th class="text-center" width="26%">Scheme Name</th>
							<th class="text-center" width="15%">Scheme Code</th>
							<th class="text-center" width="10%">Effective From</th>
							<th class="text-center" width="10%">Effective To</th>
							<th class="text-center" width="13%">Submission Date</th>
							<th class="text-center" width="16%">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
							int j = 1;
						%>
						<c:forEach var="viewprfinfo" items="${schememaster}"
							varStatus="status">
							<tr>
								<td class="text-center"><%=j%></td>
								<td><a href="schemedetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
								<td>${viewprfinfo.scheme_code}</td>
								<td>${viewprfinfo.start_date1}</td>
								<td>${viewprfinfo.end_date1}</td>
								<td>${viewprfinfo.submission_date1}</td>
								<td>${viewprfinfo.active_flag}</td>
							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
					 <tfoot>
						<tr>
							<th class="text-center" width="10%">Sr.No.</th>
							<th width="26%">Scheme Name</th>
							<th width="15%">Scheme Code</th>
							<th width="10%">Effective From</th>
							<th width="10%">Effective To</th>
							<th width="13%">Submission Date</th>
							<th width="16%">Status</th>
						</tr>
					</tfoot> 
				</table>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
 <script src="https://datatables.net/release-datatables/media/js/jquery.dataTables.js"></script>
 <script src="https://datatables.net/release-datatables/media/js/dataTables.bootstrap.js"></script>
    <script src="https://datatables.net/release-datatables/extensions/FixedHeader/js/dataTables.fixedHeader.js"></script>
    <script src="https://datatables.net/release-datatables/extensions/Responsive/js/dataTables.responsive.js"></script>
    <script src="https://datatables.net/release-datatables/extensions/Responsive/js/responsive.bootstrap.js"></script>
    <script>
$(document).ready(function() {
    var table = $('#example').DataTable( {
        responsive: true
    } );
 
    new $.fn.dataTable.FixedHeader( table );
} );

</script>
</body>
</html>
