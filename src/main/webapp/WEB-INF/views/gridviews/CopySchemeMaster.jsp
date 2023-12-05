<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Copy Scheme</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href="marketing"> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="#!">Report</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="copyschememaster">Copy Scheme</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Page-header end -->

	<div class="card">
		<div class="card-header">
			<h5>Scheme Master</h5>
		</div>
		<div class="card-block">
			<div class="dt-responsive table-responsive"><!-- basic-btn -->
				<table id="header-footer-fix"
					class="table table-bordered nowrap table-hover">
					<thead>
						<tr>
							<th class="text-center">Sr.No.</th>
							<th class="text-center">Scheme Name</th>
							<th class="text-center">Scheme Code</th>
							<th class="text-center">Effective From</th>
							<th class="text-center">Effective To</th>
							<th class="text-center">Submission Date</th>
							<th class="text-center">Status</th>
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
								<td><a href="copyschemedetails?scheme_id=${viewprfinfo.scheme_id}">${viewprfinfo.scheme_name}</a></td>
								<td class="text-center">${viewprfinfo.scheme_code}</td>
								<td class="text-center">${viewprfinfo.start_date1}</td>
								<td class="text-center">${viewprfinfo.end_date1}</td>
								<td class="text-center">${viewprfinfo.submission_date1}</td>
								<td class="text-center">${viewprfinfo.active_flag}</td>
							</tr>
							<%
								j = j + 1;
							%>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th class="text-center">Sr.No.</th>
							<th class="text-center">Scheme Name</th>
							<th class="text-center">Scheme Code</th>
							<th class="text-center">Effective From</th>
							<th class="text-center">Effective To</th>
							<th class="text-center">Submission Date</th>
							<th class="text-center">Status</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
