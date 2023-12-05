<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<!-- <li><span>Scheme Approval</span></li>
				<li><span>List Of Schemes</span></li> -->
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header>

	<!-- start: page -->
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<a href="#"></a>


			</div>
			<h2 class="panel-title">Reason For Scheme Cancel</h2>

		</header>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-12">
					<form action="financialanalysis" class="form-horizontal"
						ModelAttribute="New_Scheme_mstr" id="Saveform" method="Post"
						enctype="multipart/form-data">
						<input type="hidden" name="schemeid" id="test" value="${schemeid}" />

						<textarea name="comment" id="comment" rows="6" cols="80"></textarea>
						<button type="button" class="btn btn-primary center"
							onclick="submitform()">OK</button>
					</form>

				</div>
			</div>

		</div>
	</section>
	<!-- end: page -->
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>
	function submitform() {

		//var sid = ${schemeid};
		
		
		var cancelcomment = document.getElementById("comment").value;
		//alert(cancelcomment);
		//window.location.href="save_schemecancel_comment?schemeid="+sid+"&comment="+cancelcomment;
		if (cancelcomment == "") {
			alert("Please Enter comment");
		} else {
			if (window.opener != null && !window.opener.closed) {

				var txtName = window.opener.document.getElementById("comment");
				

				txtName.value = cancelcomment;
			}
			window.close();
		}
	}
	function abc() {

		window.close();
	}
</script>
