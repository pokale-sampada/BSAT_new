<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <!-- start: page -->
<div class="card">
	<form action="closestatus" class="form-horizontal form-bordered">
		<div class="card-block">
			<div class="form-group row">
				<div class="col-md-2"></div>
				<div class="col-md-2">
				<label class="block">Scheme Name</label></div>
				<div class="col-md-4">
					<select class="form-control populate mb-md input-sm"
						name="scheme_name" id="scheme_name">
						<option>--Select--</option>
					</select>
				</div>
				<div class="col-md-3">
					<input type="Submit" class="btn btn-primary btn-sm" value="Interface">
				</div>
			</div>
		</div>
	</form>
</div>
<script>
	$(window)
			.load(
					function() {
						$
								.ajax({
									// 					    url: '${pageContext.request.contextPath}/getschemename2',
									url : '${pageContext.request.contextPath}/getinterfaceschemename',
									success : function(data) {
										var select = $('#scheme_name');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$
												.each(
														data,
														function(index, value) {
															var scheme_nm_code = value.scheme_name
																	+ '('
																	+ value.scheme_code
																	+ ')';
															if (value.scheme_id == "${scheme_id}") {
																$(
																		'<option selected>')
																		.val(
																				value.scheme_id)
																		.text(
																				scheme_nm_code)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.scheme_id)
																		.text(
																				scheme_nm_code)
																		.appendTo(
																				select);
															}
														});

									}
								});
					});
</script> </section>