<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href="admin"> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Settings</span></li>
				<li><span>Edit Profile</span></li>
				<!-- <li><span>Scheme Details</span></li> -->
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>
	<div class="row">
		<div class="col-md-12">
			<div class="tabs">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#popular" data-toggle="tab">Edit
							Profile</a></li>
					
				</ul>
				<div class="tab-content">
					<div id="popular" class="tab-pane active">
						<section class="panel">
							<header class="panel-heading">
								

								<h2 class="panel-title"></h2>

							</header>
							<div class="panel-body">
								<div class="form-body">
									<c:forEach var="user" items="${User_Details}"
										varStatus="status">

										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">First Name </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.first_name}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">Middle Name </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.middle_name}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">Last Name </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.last_name}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">Contact No </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.contact_number}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">Email Id </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.email_address}">
										</div>

										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">Role </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.user_type}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">Creation Date </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.creation_date}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">User Id:- </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.user_id}">
										</div>
										<div class="col-md-4">
											<label class="control-label formmodifiedLable"
												for="inputDefault">User Name:- </label> <input type="text"
												class="form-control" id="inputDisabled" disabled=""
												value="${user.user_name}">
										</div>
									</c:forEach>
								</div>




							</div>
							<input name="checkpass" id="checkpass" value="" type="hidden" />


						</section>
					</div>

				</div>
			</div>
		</div>

	</div>




</section>
