<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section role="main" class="content-body">


	<!-- Page-header start -->
	<div class="page-header"
		style="background-color: #027BC6; line-height: 2em;">
		<div class="row align-items-end">
			<div class="col-lg-6">
				<div class="page-header-title">
					<div class="d-inline" style="padding-left: 1em;">
						<h4 style="color: white;">Menu Header Grid</h4>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="page-header-breadcrumb" style="padding-right: 1em;">
					<ul class="breadcrumb-title">
						<li class="breadcrumb-item"><a href="admin"> <i
								class="feather icon-home"></i>
						</a></li>
						<li class="breadcrumb-item"><a href="">System Setups</a></li>
						<li class="breadcrumb-item"><a href="menugroupgrid">Master
								Entry</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<!-- start: page -->
	<div class="card">
		<div class="card-header">
			<h5>Menu Header Grid</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<!-- <li><a href="saveregion"><i class="feather icon-plus" style="color: blue; font-size: 20px; font-weight: bold;"
title="Add New Region "></i></a></li> -->
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>

		<form class="form-horizontal form-field" role="form" id="upload"
			action="uploadMasterEntry" enctype="multipart/form-data">
			<div class="form-group">
				<section class="panel panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<!-- <a href="#" class="fa fa-caret-down"></a> -->
							<!-- <a href="#"
class="fa fa-times"></a> -->
						</div>
						<h6 class="panel-title" style="color:;">Product Master Table
							Entry</h6>
						<div></div>
					</header>
					<div class="panel-body">


						<%-- <input type="hidden" id="branch_id" name="branch_id" />

<div class="col-md-4">
<label class="control-label formmodifiedLable" for="inputDefault">Fin Year</label>
<input type="text" name="fin_year" id="fin_year" value="${JSON.fin_year}" class="form-control" required />

</div> --%>

						<div class="row">
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="col-md-3">
									<input type="button" class="btn btn-primary mb-md" id="prd"
										value="Download Template" onclick="downloadProductMaster()">
								</div>
								<br>
								<div class="col-md-5">
									<input type="file" name="productdoc" id="prd" value="Upload"
										onclick="searchinfo()"> <br> <br> <br>

									<!-- <div class="fileupload fileupload-new" data-provides="fileupload">
<div class="input-append">
<div class="uneditable-input">
<i class="fa fa-file fileupload-exists"></i>
<span class="fileupload-preview"></span>
</div>
<span class="btn btn-default btn-file">
<span class="fileupload-exists">Change</span>
<span class="fileupload-new">Select file</span>
<input type="file" />
</span>
<a href="#" class="btn btn-default fileupload-exists" data-dismiss="fileupload">Remove</a>
</div>
</div> -->



								</div>


								<!-- </div> -->
								<div class="col-md-1"></div>
							</div>
						</div>
					</div>
				</section>

				<section class="panel panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#" class="fa fa-caret-down"></a>
							<!-- <a href="#"
class="fa fa-times"></a> -->
						</div>
						<h6 class="panel-title">Dealer Master Table Entry</h6>
						<div></div>
					</header>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="col-md-3">
									<input type="button" class="btn btn-primary mb-md" id="prd"
										value="Download Template" onclick="downloadDealerMaster()">
								</div>
								<br>
								<div class="col-md-3">
									<input type="file" name="dealerdoc" id="prd" value="Upload"
										onclick="searchinfo()">
								</div>
								<div class="col-md-3"></div>
							</div>
						</div>
					</div>
				</section>

				<br> <br>
				<section class="panel panel">
					<header class="panel-heading">
						<div class="panel-actions">
							<a href="#" class="fa fa-caret-down"></a>
							<!-- <a href="#"
class="fa fa-times"></a> -->
						</div>
						<h6 class="panel-title">Transaction Master Table Entry</h6>
						<div></div>
					</header>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="col-md-3">
									<input type="button" class="btn btn-primary mb-md" id="prd"
										value="Download Template"
										onclick="downloadTransactionMaster()">
								</div>
								<br>
								<div class="col-md-3">
									<input type="file" name="transactiondoc" id="prd"
										value="Upload" onclick="searchinfo()">
								</div>
								<div class="col-md-3"></div>
							</div>
						</div>
					</div>
				</section>
			</div>
			<footer class="panel-footer">
				<div class="row" style="text-align: center">
					<div class="col-sm-12">
						<input type="submit" value="Upload Documents"
							class="btn btn-primary mb-md" />
					</div>
				</div>
			</footer>
		</form>
</section>
<script>
	function downloadDealerMaster() {
		window.location.href = "downloadDealerMaster";
	}

	function downloadProductMaster() {
		window.location.href = "downloadProductMaster";
	}

	function downloadTransactionMaster() {
		window.location.href = "downloadTransactionMaster";
	}
</script>