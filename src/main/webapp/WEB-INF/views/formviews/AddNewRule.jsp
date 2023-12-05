<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/themify-icons.css">

<link rel="stylesheet" type="text/css" href="css/icofont.css">

<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/feather.css">

<link rel="stylesheet" type="text/css" href="css/themify-icons.css">
<link rel="stylesheet" type="text/css"
	href="css/datatables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="css/buttons.datatables.min.css">

<link rel="stylesheet" type="text/css" href="css/pages.css">
</head>
<body>

							<!-- Page-header start -->
                                <div class="page-header" style="background-color: #027BC6;line-height: 2em;">
                                    <div class="row align-items-end">
                                        <div class="col-lg-8">
                                            <div class="page-header-title">
                                                <div class="d-inline" style="padding-left: 1em;">
                                                    <h4 style="color: white;">Add New Rule</h4>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="page-header-breadcrumb" style="padding-right: 1em;">
                                                <ul class="breadcrumb-title">
                                                    <li class="breadcrumb-item">
                                                        <a href="marketing"> <i class="feather icon-home"></i> </a>
                                                    </li>
                                                   <!--  <li class="breadcrumb-item"><a href="#!">Rule Libraryyyy</a>
                                                    </li> -->
                                                    <li class="breadcrumb-item"><a href="launchscheme">Add New Rule</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              <!-- Page-header end -->

 <!-- <section role="main" class="content-body">
	<header class="page-header">
		<h2></h2>

		<div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li><a href=""> <i class="fa fa-home"></i>
				</a></li>
				<li><span>Rule Libraryyyy</span></li>
				<li><span>Add New Rule</span></li>
			</ol>

			<a class="sidebar-right-toggle" data-open="sidebar-right"></a>
		</div>
	</header> -->

	<form action="addnewrule" method="post" ModelAttribute="Bpil_Rule_Library" enctype="multipart/form-data">
		<!-- start: page -->
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					
				</div>
				<h2 class="panel-title">Add New Rule</h2>

			</header>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-4">
						<label class="control-label" for="inputSuccess">Rule Name
							: </label> <input type="text" class="form-control" name="rule_name"
							id="rule_name" placeholder="Rule Name"></input>
					</div>
					<div class="col-md-4">
						<label class="control-label" for="inputSuccess">Description
							: </label> <input type="text" class="form-control" name="comments"
							id="comments" placeholder="Description"></input>
					</div>
					<div class="col-md-4">
						<label class="control-label" for="inputSuccess">Upload
							File : </label> <input multiple="" type="file" name="doc_file"
							onsubmit="return validation(this)" required></input>
					</div>
				</div>
			</div>

			<hr>
			<div class="form-group">
				<div class="col-md-12" style="text-align: center;">
					<input type="submit" class="btn btn-primary" id="action3"
						value="Add Rule"></input>
				</div>
			</div>
		</section>
		<!-- end: page -->



	</form>
</section>

<script src="resources/newportal/vendor/jquery/jquery.js"></script>

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

<script>
	function validation(thisform)
	{
	   with(thisform)
	   {
	      if(validateFileExtension(file, "valid_msg", "pdf/doc/image files are only allowed!",
	      new Array("pdf","doc","docx","xls","xlsx","txt")) == false)
	      {
	         return false;
	      }	     
	   }
	}
	</script>
</html>