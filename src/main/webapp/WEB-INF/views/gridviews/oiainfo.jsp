<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="save_opa_info" method="post" id="Saveform">
<div>
<!-- start: page -->
	<div class="card">
		<div class="card-header">
			<h5>OIA Setup</h5>
		</div>
		<div class="card-block">
	
		   	<div class="form-group row">
		   	
		   	
		   								<label class="block" style="margin-top:1%; margin-left:6%;" for="inputDefault">Scheme Name : <span
                                            class="required">*</span></label>
			
									
			<div class="col-md-4" style="margin-top:1%;">
					<select class="form-control form-control-sm form-control-primary"
						data-plugin-selectTwo name="scheme_name"
						id="scheme_name" required>
						<option>--Select--</option>
					</select>
			</div>
		   	
		
				<label class="block" style="margin-top:1%; margin-left:6%;">OPA URL : <span class="required">*</span></label>
				
				
		
				<div class="col-md-3" style="margin-top:1%;">
									 <input
											type="text" name="OIA" id="OIA"
											class="form-control form-control-sm" id="inputDisabled"
											required="required">
									</div>
			
			<!-- <div class="col-md-2"> -->
				<button type="button" style="margin-top:9px; margin-left:11px;height:34px;" class="btn btn-primary btn-sm" name="add_row"
					id="add_row" 
					onclick="table_row()">Add </button>
				
		<!-- 	</div> -->
	
			
			<div style="margin-top:6%;">
			
			</div>
			
			
			
			
			<div id="table_row"  style="margin-top:4%;margin-left:4%; display:none;">
						<table
												class="table table-bordered table-striped table-condensed mb-none stripe row-border order-column"
												id="dynamic-table3" >
												<thead >
													<tr>
														<th style="width: 3%; padding: 8px 4px 8px 4px;">SR.NO</th>
														<th style="width: 11%; padding: 8px 5px 8px 5px;">Scheme Id</th>
														<th style="width: 11%; padding: 8px 15px 8px 15px;">OPA URL</th>

													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
			
			</div>
			
			
			
			

	</div>
	<div class="col-md-4">
				<button type="button" style="margin-top:-5%;margin-left:4%;display:none;"  class="btn btn-primary btn-sm" name="del_row"
					id="del_row" 
					onclick="delete_row()">Delete </button>
			</div>
			
	
		<div class="col-md-4" id="cl_save_div" style="margin-top:6%;margin-left:42%;">
				<button class="btn btn-primary btn-sm" name="close"
					id="close" 
					onclick="closed()">Close</button>
					<!-- <button class="btn btn-primary btn-sm" name="edit"
					id="edit" 
					onclick="myFunction1()">Edit</button> -->
					<button class="btn btn-primary btn-sm" name="save"
					id="save" 
					onclick="saving_form()">Save</button>
					<!-- <button class="btn btn-primary btn-sm" name="test"
					id="test" 
					onclick="testt()">test</button> -->
					
			</div>
		</div>
	</div>
	

</div>
 </form>	
	<!-- end: page -->
<script src="resources/newportal/vendor/jquery/jquery.js"></script>

<script>

$(window).load(function() {

$('.required').css({
'color' : 'red'
});



var divide_del = document.getElementById("cl_save_div");
divide_del.style.display = "none";


//localstorage.setItem("count",1);

});
	$('#scheme_name').change(function(event) {
		var scheme_id = $("select#scheme_name").val();

		$.ajax({
			url : '${pageContext.request.contextPath}/getstatus',
			data : ({
				scheme_id : scheme_id
			}),
			success : function(data) {

				$.each(data, function(index, value) {

					if (value.active_flag == "Active") {

						$("#gen_report").show();

					} else {
						$("#gen_report").hide();
					}

				});

			}
		});

	});
	
</script>
<script>
	function myFunction1() {
		//         	setTimeout(myFunction3, 1000);
		//         	  var depot_name = $('#depot_name').val();
		var depot_name = "";
		var scheme_id = $('#scheme_name').val();
		var finanalysis = "0";
		var a = confirm("Do you want to proceed for Reward Processing?");
		if (a == true) {


			window.location.href = "startrewardprocess?scheme_id=" + scheme_id
					+ "&process_flag=R";

		} else {

		}

	}
	
	
	var a=[];
	
	function table_row(){
	//alert("adding row");

	
	
	var schnm = document.getElementById("scheme_name").value;
	 var ourl = document.getElementById("OIA").value;
	 
		
	var map_counter=true;	
	
		

	 if(schnm === ""){
		 
		 alert("Please Enter Scheme Name  ")
		 
	 }else if(ourl === ""){
		 alert("Please Enter OPA Url  ")
		 
	 }else {
		 
		 
		
			
			for (let i = 0; i < a.length; i++) {
				
				if( a[i].scheme_id == schnm || a[i].oia == ourl ){
					
					alert("Please add different scheme name or Oia URL");
					map_counter=false;
					break;
				}
				 
				}
		
			
		 
		 if(map_counter == true){
				var b={"scheme_id":schnm,"oia":ourl};
				a.push(b); 
				
				console.log("the array after Add");
				console.log(a);
		 var divide_del = document.getElementById("cl_save_div");
		    divide_del.style.display = "block";
	
	
	  var counter=localStorage.getItem("count");
	

	
	  var divide_del = document.getElementById("del_row");
	  divide_del.style.display = "block";
	
	
	  var divide = document.getElementById("table_row");
	  divide.style.display = "block";
	
		var scheme_id = $('#scheme_name').val();
		var URL = $('#OIA').val();
		
	//$('#dynamic-table3 tr').last().after('<tr><td><input type = "text" class="class="col-xs-12 col-sm-4" name="akash" value='+counter+' id="akash2" /></td><td><input type = "text" class="class="col-xs-12 col-sm-4" value="'+scheme_id+'" name="scheme_code_common" id="scheme_code" /></td><td><input type = "text" class="class="col-xs-12 col-sm-4" value="'+URL+'" name="URL_common" id="URL" /></td></tr>');
	$('#dynamic-table3 tr').last().after('<tr><td><input type = "text"  name="akash" value='+counter+' id="akash2" /></td><td><input type = "text"  value="'+scheme_id+'" name="scheme_code_common" id="scheme_code" /></td><td><input type = "text"  value="'+URL+'" style="width:528px;" name="URL_common" id="URL" /></td></tr>');
	
	
	
	counter++;

	
	
	localStorage.setItem("count",counter);
		 }
	
	 }
	
	
	}
	
	function delete_row() {
		
		var count = $('#dynamic-table3 tr').length-1;
		
		var sch_id=a[a.length-1].scheme_id;
		
		const filteredPeople = a.filter((item) => item.scheme_id !== sch_id);
		a = filteredPeople;
		console.log("the array after delete");
		console.log(a);
		
		if(count > 0)
			{ 		
				 document.getElementById("dynamic-table3").deleteRow(count);
				
		 			
				 
			}
		
		if(count === 1){
			
			 var divide = document.getElementById("table_row");
			  divide.style.display = "none";
		}
		
		if(count===0){
			 var divide_del = document.getElementById("cl_save_div");
			    divide_del.style.display = "none";
			
			    var divide_2 = document.getElementById("del_row");
			    divide_2.style.display = "none";
		}
		
		var counter2=localStorage.getItem("count");
		var cn=parseInt(counter2);
		
		localStorage.setItem("count",cn-1);
		
		var counter3=localStorage.getItem("count");
		
		//alert("the counter3 value"+counter3);
		
		var tdcount = $('#dynamic-table3 tr').length-1;
		//alert("the tt value"+tdcount);
		
		if(tdcount === 0){
			//alert("inside if");
			var divide_del = document.getElementById("cl_save_div");
			    divide_del.style.display = "none";
			
			    var divide_2 = document.getElementById("del_row");
			    divide_2.style.display = "none";
		}
	
	}

	function myFunction3() {
		$("#loading").show();
	}

	function myFunction2() {
		var depot_name = $('#depot_name').val();
		var scheme_name = $('#scheme_name').val();
		window.location.href = "loadrewarddata?schnm=" + scheme_name + "";
	}
</script>
<script>
	function submitform() {
		$('#action').val("Update");
		var aa = confirm('Do you want to update this scheme?')
		if (aa == true) {
			$('#Saveform').submit();
		} else {
			return false;
		}
	}
	
	function closed(){
		
		event.preventDefault();
		window.location.href = "oiainfo";
		
	}
	
	function testt(){
		
		
		
		
		var resu="true";
		event.preventDefault();
		//alert("counter value__ "+counter);
		var sample = document.getElementsByName('URL_common');
		//console.log(sample[0].defaultValue);
		//alert(sample.length);
		//alert(sample[0].value);
		var counter=0;
		var pointer=0;
		for(var i=0;i<sample.length;i++)
			{
			
			//alert("value------"+sample[i].value)
			var data1 = sample[i].value;
			
			if(sample.length>1){
			for(var j=i+1;j<sample.length;j++)
				{
				
				var data2 = sample[j].value;
				//alert("data1------"+data1)
				//alert("data2--------------"+data2)
				if(data1 == data2)
					{
					//alert("inside iff")
					counter = counter + 1;
					pointer = i;
					}
				}
			}
			}
		//alert("After for loop end "+counter);
		if(counter >= 1)
			{
			alert("duplicate record found for row number "+pointer);
			resu="false";
			}
		
		return resu;
		
// 		let count=0;
// 		var name="";
// 		sample.map((cost) => {
			
// 			console.log("The map iterate URL __ -> "+cost.defaultValue)
			
// 			console.log(count);
// 			console.log("name___  -> "+name);
// 			if(count !== 0){
			
// 				console.log("inside if");
// 				alert("----",name)
// 				alert("----",cost.defaultValue)
// 			if(name == cost.defaultValue){
				
// 				console.log("inside second if");
// 				alert("URL repeat");
// 				count=0;
// 				name="";
// 				 return false;
				 
// 			}
				
// 			}
// 			name=cost.defaultValue;
// 			count++; 
// 			});
	}
	
function testt2(){
		
		
		
		
		var resu="true";
		event.preventDefault();
		//alert("counter value__ "+counter);
		var sample = document.getElementsByName('scheme_code_common');
		//console.log(sample[0].defaultValue);
		//alert(sample.length);
		//alert(sample[0].value);
		var counter=0;
		var pointer=0;
		for(var i=0;i<sample.length;i++)
			{
			
			//alert("value------"+sample[i].value)
			var data1 = sample[i].value;
			
			if(sample.length>1){
			for(var j=i+1;j<sample.length;j++)
				{
				
				var data2 = sample[j].value;
				//alert("data1------"+data1)
				//alert("data2--------------"+data2)
				if(data1 == data2)
					{
					//alert("inside iff")
					counter = counter + 1;
					pointer = i;
					}
				}
			}
			}
		//alert("After for loop end "+counter);
		if(counter >= 1)
			{
			alert("duplicate record found for row number "+pointer);
			resu="false";
			}
		
		return resu;
		
// 		let count=0;
// 		var name="";
// 		sample.map((cost) => {
			
// 			console.log("The map iterate URL __ -> "+cost.defaultValue)
			
// 			console.log(count);
// 			console.log("name___  -> "+name);
// 			if(count !== 0){
			
// 				console.log("inside if");
// 				alert("----",name)
// 				alert("----",cost.defaultValue)
// 			if(name == cost.defaultValue){
				
// 				console.log("inside second if");
// 				alert("URL repeat");
// 				count=0;
// 				name="";
// 				 return false;
				 
// 			}
				
// 			}
// 			name=cost.defaultValue;
// 			count++; 
// 			});
	}
	
	function saving_form(){
		event.preventDefault();
		
			
		 	var aa = confirm('Do you want to update this scheme?')
			if (aa == true) {
				$('#Saveform').submit();
			}else {
				return false;
			} 
	
	
		
	
		
	
		
		
 /*        $.ajax({
        	url: '${pageContext.request.contextPath}/save_opa_info',
            data: ({scheme_code : fin}),
            success: function(data) {
            
            alert("success");

            }
        }); */
		
		
	}

	function submitform1() {
		$('#action').val("Freeze");
		var aa = confirm('Are you sure to freeze this scheme?')
		if (aa == true) {
			$('#Saveform').submit();
		} else {
			return false;
		}
	}
</script>

<script>
	$('.adjustpoints').keyup(
			function() {

				var sum = 0;
				var count = $('.adjustpoints').index(this) + 1;

				$('#sch_tot_cn_pts' + count).val("0");

				var part1_value = $('#part1_value' + count).val();
				var part2_value = $('#part2_value' + count).val();
				var sch_adj_pts = $('#sch_adj_pts' + count).val();

				var sum = parseInt(part1_value) + parseInt(part2_value)
						+ parseInt(sch_adj_pts);

				$('#sch_tot_cn_pts' + count).val(sum);
				$('#attribute1' + count).val("Y");

			});
</script>

<script>
	$(window)
			.load(
					function() {

						$
								.ajax({
									// 					    url: '${pageContext.request.contextPath}/getrwpschemename1',
									url : '${pageContext.request.contextPath}/getrwpschemename_oia',
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

						$
								.ajax({
									url : '${pageContext.request.contextPath}/getschemedepot',
									success : function(data) {
										var select = $('#depot_name');
										select.find('option').remove();
										$('<option>').val("")
												.text("--Select--").appendTo(
														select);
										$
												.each(
														data,
														function(index, value) {
															if (value.depot_name == "${deptnm}") {
																$(
																		'<option selected>')
																		.val(
																				value.depot_name)
																		.text(
																				value.depot_name)
																		.appendTo(
																				select);
															} else {
																$('<option>')
																		.val(
																				value.depot_name)
																		.text(
																				value.depot_name)
																		.appendTo(
																				select);
															}
														});

									}
								});
						
						var counter= 1;
						localStorage.setItem("count", counter);

					});
</script>

<script>
	$(document).ready(function() {

		$("#loading").hide();

	})
</script>