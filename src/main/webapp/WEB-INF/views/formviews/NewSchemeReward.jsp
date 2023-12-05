
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="css/bootstrap4-toggle.css">
	<link rel="stylesheet" href="doc/stylesheet.css">
<!-- Page-header start -->
<div class="page-header"
	style="background-color: #027BC6; line-height: 2em;">
	<div class="row align-items-end">
		<div class="col-lg-8">f
			<div class="page-header-title">
				<div class="d-inline" style="padding-left: 1em;">
					<h4 style="color: white;">Scheme Reward Details</h4>

				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb" style="padding-right: 1em;">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="admin"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Masters</a></li>
					<li class="breadcrumb-item"><a href="schemerewardgrid">Gifts</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->
<form action="save_scheme_reward" class="form-horizontal"
	ModelAttribute="Bpil_Gift_Master" id="Saveform" method="Post"
	enctype="multipart/form-data">
	<div class="card">
		<div class="card-header">
			<h5>Scheme Reward Details</h5>
			<div class="card-header-right">
				<ul class="list-unstyled card-option">
					<li><i class="feather icon-maximize full-card"></i></li>
					<li><i class="feather icon-minus minimize-card"></i></li>
					<li><i class="feather icon-trash-2 close-card"></i></li>
				</ul>
			</div>
		</div>
		<div class="card-block">
			<input type="hidden" name="scheme_id" id="scheme_id"
				value="<%=request.getParameter("scheme_id")%>"> <input
				type="hidden" name="test" id="test" value="" />
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="password2">Gift Group</label> <select
						name="gift_group" id="gift_group"
						class="form-control form-control-sm form-control-primary"
						onChange="fetchdata()">
					</select>
				</div>
				<div class="col-md-3">
					<label class="block">Gift Code </label> <input type="hidden"
						name="gift_id" id="gift_id" class="col-xs-12 col-sm-4"
						value="${JSON.gift_id}" /> <input type="text" name="gift_code"
						id="gift_code"
						class="form-control form-control-sm form-control-primary"
						value="${JSON.gift_code}" />
				</div>
				<div class="col-md-3">
					<label class="block" for="form-field-1"> Gift Brand Name </label> <input
						type="text" name="gift_brand_name" id="gift_brand_name"
						class="form-control form-control-sm form-control-primary"
						value="${JSON.gift_brand_name}" />
				</div>
				<div class="col-md-3">
					<label class="block" for="form-field-1"> Gift UOM </label> <input
						type="text" name="gift_uom" id="gift_uom"
						class="form-control form-control-sm form-control-primary"
						value="${JSON.gift_uom}" required />
				</div>

			</div>
			<div class="form-group row">
				<div class="col-md-3">
					<label class="block" for="form-field-1">Gift Name </label> <input
						type="text" name="gift_name" id="gift_name"
						class="form-control form-control-sm form-control-primary"
						value="${JSON.gift_name}" required /> <select
						style="display: none" name="FOC" id="FOC" onChange="fetchdesc()"
						class="form-control form-control-sm form-control-primary">
					</select>
				</div>
				<div class="col-md-3">
					<label class="block" for="form-field-1"> Effective Price </label> <input
						type="text" name="effective_price" id="effective_price"
						onkeypress="return isNumber(event);"
						value="${JSON.effective_price}"
						class="form-control form-control-sm form-control-primary" required />
				</div>
				<div class="col-md-3">
					<label class="block" for="form-field-1"> Gift value in CN </label>
					<input type="text" name="attribute1" id="attribute1"
						onkeypress="return isNumber(event);" value="${JSON.attribute1}"
						class="form-control form-control-sm form-control-primary" required />
				</div>
				<div class="col-md-3">
					<label class="block" for="form-field-1"> Gift Expiry </label> <select
						name="attribute2" id="attribute2"
						class="form-control form-control-sm form-control-primary" required>
						<option value="">--Select--</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<!--  Row 3 Started -->
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<label class="block" for="inputDefault">Gift Description</label>
					<textarea name="gift_description" id="gift_description"
						class="form-control form-control-sm form-control-primary"
						value="${JSON.gift_description}" rows="6" cols="3"
						style="width: 800px; height: 100px;">${JSON.gift_description}</textarea>
				</div>
			</div>
				<!-- <div class="form-group row">
			
			
				
				<input type="checkbox"  checked data-toggle="toggle" id="toggle1" value="Active" data-size="xs" onchange="checkData()">
			</div> -->
			
			
			<div class="form-group row">
				<div class="col-md-5"></div>
				<div class="col-md-1">
					<input type="submit" value="Save" class="btn btn-primary btn-sm">
				</div>
			</div>

		</div>
	</div>
</form>

<script>
    window.onload = function () {
      
       $.ajax({
	        url: '${pageContext.request.contextPath}/loadgiftgroup',
	        
	        success: function(data) {
	            var select = $('#gift_group');
	            select.find('option').remove();
	              $.each(data, function(index, value) {
	            	  if(value.lookup_code == "${JSON.gift_group}"){
				    	  $('<option selected>').val(value.lookup_code).text(value.lookup_code).appendTo(select);
				      }else{
				        	$('<option>').val(value.lookup_code).text(value.lookup_code).appendTo(select);
				      }
	            });
	        }
	      });
       
   	
		if("${JSON.gift_group}" == "FOC"){
		       $.ajax({
			        url: '${pageContext.request.contextPath}/loadFOC',
			        
			        success: function(data) {
			            var select = $('#FOC');
			            select.find('option').remove();
			           
			              $.each(data, function(index, value) {
			            	  if(value.SKU == "${JSON.gift_name}"){
			            		  $('<option selected>').val(value.SKU).text(value.SKU).appendTo(select);
			            	  }else{
			            		  $('<option>').val(value.SKU).text(value.SKU).appendTo(select);
			            	  }
			            });
			        }
			      });
			
			document.getElementById("gift_name").style.display = "none";
			document.getElementById("FOC").style.display = "block";
		}else{
			document.getElementById("gift_name").style.display = "block";
			document.getElementById("FOC").style.display = "none";
		}
		if("${JSON.gift_group}" == "GIFT"){
			var select = $('#attribute2');
 			var options = $('#attribute2 option');
 			var values = $.map(options ,function(option) {
 				if(option.value == "${JSON.attribute2}")
 					{
 					$('#attribute2').val(option.value).change();
 					
 					}
 			});
			document.getElementById("attribute2").disabled=false;
		}else{
			
			document.getElementById("attribute2").disabled=true;
		}
      
    }	
</script>

<script>
/* function checkData()
{
	var str="Y";
	 if($("#toggle1").prop("checked") == true) {
         alert("Checkbox is checked.");
         str="Y";
         $("#toggle1").val(str);
       }
       else if($("#toggle1").prop("checked") == false) {
         alert("Checkbox is unchecked.");
         str="N";
         $("#toggle1").val(str);
       }
	 alert(($("#toggle1").val()));
	} */
    function validateobjective()
    {
        var len=document.getElementById("objective").value;

         var n = len.length;

        if(n<10)
            {
            alert("Please enter valid description");
            $("#objective").css('border', '1px solid red');
            }else
                {
                $("#objective").css('border', '1px solid gray');
                }
    }
    </script>

<script type="text/javascript">
    	function fetchdata(){
    		var giftId = document.getElementById("gift_group").value;
    		if(giftId == "FOC"){
    			

    		       $.ajax({
    			        url: '${pageContext.request.contextPath}/loadFOC',
    			        
    			        success: function(data) {
    			            var select = $('#FOC');
    			            select.find('option').remove();
    			            $('<option>').val("").text("--select--").appendTo(select);
    			              $.each(data, function(index, value) {
    						  $('<option>').val(value.FOC).text(value.SKU).appendTo(select);
    			            });
    			        }
    			      });
    			
    			document.getElementById("gift_name").style.display = "none";
    			document.getElementById("FOC").style.display = "block";
    		}else{
    			document.getElementById("gift_name").style.display = "block";
    			document.getElementById("FOC").style.display = "none";
    			
    			document.getElementById("gift_name").value = "";
    			document.getElementById("gift_description").value = "";
    		}
    		
			if(giftId == "GIFT"){
    			
    			document.getElementById("attribute2").disabled=false;
    		}else{
    			
    			document.getElementById("attribute2").disabled=true;
    		}
    	}
    	
    	function fetchdesc(){
    		var e = document.getElementById("FOC");
    		var option = e.options[e.selectedIndex].text;
    		$('#gift_name').val(option);
    		
    		$.ajax({
		        url: '${pageContext.request.contextPath}/getDesc?desc='+option,
		        
		        success: function(data) {
		        	$('#gift_description').val(data);
		        }
		      });
    	}
    </script>



<script>	
	function submitform()
	{		
	
	        
		 
		 
	}
	
	

	</script>

<script>
    // Number Validation
    		function isNumber(evt) {
        	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        
        	if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            
        	return false;

        	
        return true;
    	}    
		</script>


<script src="doc/script.js"></script>
	<script src="js/bootstrap4-toggle.js"></script>
<script src="<c:url value='/resources/assets/js/jquery.2.1.1.min.js'/>"
	type="text/javascript"></script>

<script type="text/javascript">
        window.jQuery
                || document.write("<script src='assets/js/jquery.min.js'>"
                        + "<"+"/script>");
    </script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
        if ('ontouchstart' in document.documentElement)
            document
                    .write("<script src='assets/js/jquery.mobile.custom.min.js'>"
                            + "<"+"/script>");
    </script>
<script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"
	type="text/javascript"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
          <script src="assets/js/excanvas.min.js"></script>
        <![endif]-->
<script
	src="<c:url value='/resources/assets/js/jquery-ui.custom.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/jquery.ui.touch-punch.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/chosen.jquery.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/fuelux.spinner.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/bootstrap-datepicker.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/bootstrap-timepicker.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/moment.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/daterangepicker.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/bootstrap-datetimepicker.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/bootstrap-colorpicker.min.js'/>"
	type="text/javascript"></script>

<script src="<c:url value='/resources/assets/js/jquery.knob.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/jquery.autosize.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/jquery.inputlimiter.1.3.1.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/jquery.maskedinput.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/bootstrap-tag.min.js'/>"
	type="text/javascript"></script>
<!-- ace scripts -->
<script src="<c:url value='/resources/assets/js/ace-elements.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/ace.min.js'/>"
	type="text/javascript"></script>

<!-- page specific plugin scripts -->
<script src="<c:url value='/resources/assets/js/jquery.raty.min.js'/>"
	type="text/javascript"></script>

<script
	src="<c:url value='/resources/assets/js/typeahead.jquery.min.js'/>"
	type="text/javascript"></script>

<script
	src="<c:url value='/resources/assets/js/bootstrap-multiselect.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/select2.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/jquery.bootstrap-duallistbox.min.js'/>"
	type="text/javascript"></script>


<script type="text/javascript">
        jQuery(function($) {

              var demo1 = $('select[name="appl_depot_code1[]"]').bootstrapDualListbox({infoTextFiltered: '<span class="label label-purple label-lg">Filtered</span>'});
              var container1 = demo1.bootstrapDualListbox('getContainer');
                container1.find('.btn').addClass('btn-white btn-info btn-bold');
              $(document).one('ajaxloadstart.page', function(e) {
                    $('[class*=select2]').remove();
					$('select[name="appl_depot_code1[]"]').bootstrapDualListbox('destroy');
                    $('.rating').raty('destroy');
                    $('.multiselect').multiselect('destroy');
                });
              
//               var demo2 = $('.demo2').bootstrapDualListbox({
//             	  nonSelectedListLabel: 'Non-selected',
//             	  selectedListLabel: 'Selected',
//             	  preserveSelectionOnMove: 'moved',
//             	  moveOnSelect: false,
//             	  nonSelectedFilter: 'ion ([7-9]|[1][0-2])'
//             	});

            $('#id-disable-check').on('click', function() {
                var inp = $('#form-input-readonly').get(0);
                if (inp.hasAttribute('disabled')) {
                    inp.setAttribute('readonly', 'true');
                    inp.removeAttribute('disabled');
                    inp.value = "This text field is readonly!";
                } else {
                    inp.setAttribute('disabled', 'disabled');
                    inp.removeAttribute('readonly');
                    inp.value = "This text field is disabled!";
                }
            });

            if (!ace.vars['touch']) {
                $('.chosen-select').chosen({
                    allow_single_deselect : true
                });
                //resize the chosen on window resize

                $(window).off('resize.chosen').on('resize.chosen', function() {
                    $('.chosen-select').each(function() {
                        var $this = $(this);
                        $this.next().css({
                            'width' : $this.parent().width()
                        });
                    })
                }).trigger('resize.chosen');
                //resize chosen on sidebar collapse/expand
                $(document).on('settings.ace.chosen',
                        function(e, event_name, event_val) {
                            if (event_name != 'sidebar_collapsed')
                                return;
                            $('.chosen-select').each(function() {
                                var $this = $(this);
                                $this.next().css({
                                    'width' : $this.parent().width()
                                });
                            })
                        });

                $('#chosen-multiple-style .btn').on(
                        'click',
                        function(e) {
                            var target = $(this).find('input[type=radio]');
                            var which = parseInt(target.val());
                            if (which == 2)
$('#form-field-select-4').addClass(
                                        'tag-input-style');
                            else
$('#form-field-select-4').removeClass(
                                        'tag-input-style');
                        });
            }

            $('[data-rel=tooltip]').tooltip({
                container : 'body'
            });
            $('[data-rel=popover]').popover({
                container : 'body'
            });

            $('textarea[class*=autosize]').autosize({
                append : "\n"
            });
            $('textarea.limited').inputlimiter({
                remText : '%n character%s remaining...',
                limitText : 'max allowed : %n.'
            });

            $.mask.definitions['~'] = '[+-]';
            $('.input-mask-date').mask('99/99/9999');
            $('.input-mask-phone').mask('(999) 999-9999');
            $('.input-mask-eyescript').mask('~9.99 ~9.99 999');
            $(".input-mask-product").mask("a*-999-a999", {
                placeholder : " ",
                completed : function() {
                    alert("You typed the following: " + this.val());
                }
            });

            $("#input-size-slider").css('width', '200px').slider(
                    {
                        value : 1,
                        range : "min",
                        min : 1,
                        max : 8,
                        step : 1,
                        slide : function(event, ui) {
                            var sizing = [ '', 'input-sm', 'input-lg',
                                    'input-mini', 'input-small',
                                    'input-medium', 'input-large',
                                    'input-xlarge', 'input-xxlarge' ];
                            var val = parseInt(ui.value);
                            $('#form-field-4').attr('class', sizing[val]).val(
                                    '.' + sizing[val]);
                        }
                    });

            $("#input-span-slider").slider(
                    {
                        value : 1,
                        range : "min",
                        min : 1,
                        max : 12,
                        step : 1,
                        slide : function(event, ui) {
                            var val = parseInt(ui.value);
                            $('#form-field-5').attr('class', 'col-xs-' + val)
                                    .val('.col-xs-' + val);
                        }
                    });

            //"jQuery UI Slider"
            //range slider tooltip example
            $("#slider-range")
                    .css('height', '200px')
                    .slider(
                            {
                                orientation : "vertical",
                                range : true,
                                min : 0,
                                max : 100,
                                values : [ 17, 67 ],
                                slide : function(event, ui) {
                                    var val = ui.values[$(ui.handle).index() - 1]
                                            + "";

                                    if (!ui.handle.firstChild) {
                                        $(
                                                "<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
.prependTo(ui.handle);
                                    }
$(ui.handle.firstChild).show().children()
                                            .eq(1).text(val);
                                }
}).find('span.ui-slider-handle').on('blur',
                            function() {
                                $(this.firstChild).hide();
                            });

            $("#slider-range-max").slider({
                range : "max",
                min : 1,
                max : 10,
                value : 2
            });

            $("#slider-eq > span").css({
                width : '90%',
                'float' : 'left',
                margin : '15px'
            }).each(function() {
                // read initial values from markup and remove that
                var value = parseInt($(this).text(), 10);
                $(this).empty().slider({
                    value : value,
                    range : "min",
                    animate : true

                });
            });

            $("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item

            $('#id-input-file-1 , #id-input-file-2').ace_file_input({
                no_file : 'No File ...',
                btn_choose : 'Choose',
                btn_change : 'Change',
                droppable : false,
                onchange : null,
                thumbnail : false
            //| true | large
            //whitelist:'gif|png|jpg|jpeg'
            //blacklist:'exe|php'
            //onchange:''
            //
            });
            //pre-show a file name, for example a previously selected file
//$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])

            $('#id-input-file-3').ace_file_input({
                style : 'well',
                btn_choose : 'Drop files here or click to choose',
                btn_change : null,
                no_icon : 'ace-icon fa fa-cloud-upload',
                droppable : true,
                thumbnail : 'small'//large | fit
                //,icon_remove:null//set null, to hide remove/reset button
                /**,before_change:function(files, dropped) {
                    //Check an example below
                    //or examples/file-upload.html
                    return true;
                }*/
                /**,before_remove : function() {
                    return true;
                }*/
                ,
                preview_error : function(filename, error_code) {
                    //name of the file that failed
                    //error_code values
                    //1 = 'FILE_LOAD_FAILED',
                    //2 = 'IMAGE_LOAD_FAILED',
                    //3 = 'THUMBNAIL_FAILED'
                    //alert(error_code);
                }

            }).on('change', function() {
                //console.log($(this).data('ace_input_files'));
                //console.log($(this).data('ace_input_method'));
            });

            //$('#id-input-file-3')
            //.ace_file_input('show_file_list', [
            //{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
            //{type: 'file', name: 'hello.txt'}
            //]);

            //dynamically change allowed formats by changing allowExt && allowMime function
            $('#id-file-format').removeAttr('checked').on(
                    'change',
                    function() {
                        var whitelist_ext, whitelist_mime;
                        var btn_choose
                        var no_icon
                        if (this.checked) {
                            btn_choose = "Drop images here or click to choose";
                            no_icon = "ace-icon fa fa-picture-o";

                            whitelist_ext = [ "jpeg", "jpg", "png", "gif",
                                    "bmp" ];
                            whitelist_mime = [ "image/jpg", "image/jpeg",
                                    "image/png", "image/gif", "image/bmp" ];
                        } else {
                            btn_choose = "Drop files here or click to choose";
                            no_icon = "ace-icon fa fa-cloud-upload";

                            whitelist_ext = null;//all extensions are acceptable
                            whitelist_mime = null;//all mimes are acceptable
                        }
                        var file_input = $('#id-input-file-3');
file_input.ace_file_input('update_settings', {
                            'btn_choose' : btn_choose,
                            'no_icon' : no_icon,
                            'allowExt' : whitelist_ext,
                            'allowMime' : whitelist_mime
                        })
                        file_input.ace_file_input('reset_input');

file_input.off('file.error.ace').on('file.error.ace',
                                function(e, info) {
//console.log(info.file_count);//number of selected files
//console.log(info.invalid_count);//number of invalid files
//console.log(info.error_list);//a list of errors in the following format

                                    //info.error_count['ext']
                                    //info.error_count['mime']
                                    //info.error_count['size']

                                    //info.error_list['ext']  = [list of file names with invalid extension]
                                    //info.error_list['mime'] = [list of file names with invalid mimetype]
                                    //info.error_list['size'] = [list of file names with invalid size]

                                    /**
                                    if( !info.dropped ) {
                                        //perhapse reset file field if files have been selected, and there are invalid files among them
                                        //when files are dropped, only valid files will be added to our file array
                                        e.preventDefault();//it will rest input
                                    }
                                     */

                                    //if files have been selected (not dropped), you can choose to reset input
                                    //because browser keeps all selected files anyway and this cannot be changed
                                    //we can only reset file field to become empty again
                                    //on any case you still should check files with your server side script
                                    //because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
                                });

                    });

            $('#spinner1').ace_spinner({
                value : 0,
                min : 0,
                max : 200,
                step : 10,
                btn_up_class : 'btn-info',
                btn_down_class : 'btn-info'
            }).closest('.ace-spinner').on('changed.fu.spinbox', function() {
                //alert($('#spinner1').val())
            });
            $('#spinner2').ace_spinner({
                value : 0,
                min : 0,
                max : 10000,
                step : 100,
                touch_spinner : true,
                icon_up : 'ace-icon fa fa-caret-up bigger-110',
                icon_down : 'ace-icon fa fa-caret-down bigger-110'
            });
            $('#spinner3').ace_spinner({
                value : 0,
                min : -100,
                max : 100,
                step : 10,
                on_sides : true,
                icon_up : 'ace-icon fa fa-plus bigger-110',
                icon_down : 'ace-icon fa fa-minus bigger-110',
                btn_up_class : 'btn-success',
                btn_down_class : 'btn-danger'
            });
            $('#spinner4').ace_spinner({
                value : 0,
                min : -100,
                max : 100,
                step : 10,
                on_sides : true,
                icon_up : 'ace-icon fa fa-plus',
                icon_down : 'ace-icon fa fa-minus',
                btn_up_class : 'btn-purple',
                btn_down_class : 'btn-purple'
            });

//$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
            //or
//$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
//$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0

            //datepicker plugin
            //link
            $('.date-picker').datepicker({
                autoclose : true,
                todayHighlight : true
            })
            //show datepicker when clicking on the icon
            .next().on(ace.click_event, function() {
                $(this).prev().focus();
            });

            //or change it into a date range picker
            $('.input-daterange').datepicker({
                autoclose : true
            });

            //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
            $('input[name=date-range-picker]').daterangepicker({
                'applyClass' : 'btn-sm btn-success',
                'cancelClass' : 'btn-sm btn-default',
                locale : {
                    applyLabel : 'Apply',
                    cancelLabel : 'Cancel',
                }
            }).prev().on(ace.click_event, function() {
                $(this).next().focus();
            });

            $('#timepicker1').timepicker({
                minuteStep : 1,
                showSeconds : true,
                showMeridian : false
            }).next().on(ace.click_event, function() {
                $(this).prev().focus();
            });

$('#date-timepicker1').datetimepicker().next().on(ace.click_event,
                    function() {
                        $(this).prev().focus();
                    });

            $('#colorpicker1').colorpicker();

            $('#simple-colorpicker-1').ace_colorpicker();
            //$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
            //$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
            //var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
            //picker.pick('red', true);//insert the color if it doesn't exist

            $(".knob").knob();

            var tag_input = $('#form-field-tags');
            try {
                tag_input.tag({
                    placeholder : tag_input.attr('placeholder'),
                    //enable typeahead by specifying the source array
                    source : ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
                /**
                //or fetch data from database, fetch those that match "query"
                source: function(query, process) {
                  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
                  .done(function(result_items){
                    process(result_items);
                  });
                }
                 */
                })

                //programmatically add a new
                var $tag_obj = $('#form-field-tags').data('tag');
                $tag_obj.add('Programmatically Added');
            } catch (e) {
                //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
                tag_input.after(
                        '<textarea id="' + tag_input.attr('id') + '" name="'
                                + tag_input.attr('name') + '" rows="3">'
                                + tag_input.val() + '</textarea>').remove();
                //$('#form-field-tags').autosize({append: "\n"});
            }

            /////////
            $('#modal-form input[type=file]').ace_file_input({
                style : 'well',
                btn_choose : 'Drop files here or click to choose',
                btn_change : null,
                no_icon : 'ace-icon fa fa-cloud-upload',
                droppable : true,
                thumbnail : 'large'
            })

            //chosen plugin inside a modal will have a zero width because the select element is originally hidden
            //and its width cannot be determined.
            //so we set the width after modal is show
            $('#modal-form').on(
                    'shown.bs.modal',
                    function() {
                        if (!ace.vars['touch']) {
$(this).find('.chosen-container').each(
                                    function() {
$(this).find('a:first-child').css(
                                                'width', '210px');
$(this).find('.chosen-drop').css(
                                                'width', '210px');
$(this).find('.chosen-search input')
                                                .css('width', '200px');
                                    });
                        }
                    })
            /**
            //or you can activate the chosen plugin after modal is shown
            //this way select element becomes visible with dimensions and chosen works as expected
            $('#modal-form').on('shown', function () {
                $(this).find('.modal-chosen').chosen();
            })
             */

            $(document)
                    .one(
                            'ajaxloadstart.page',
                            function(e) {
$('textarea[class*=autosize]').trigger(
                                        'autosize.destroy');
$('.limiterBox,.autosizejs').remove();
                                $(
'.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu')
                                        .remove();
                            });

        });
    </script>

<script>
        var a = new Date().getDate();
        var a1 = a.toString();
        var b = new Date().getMonth() + 1;
        var b1 = b.toString();
        var c = new Date().getFullYear();
        var c1 = c.toString();

        var q = "-";
        var d = a1.concat(q);
        var d1 = d.concat(b1);
        var d2 = d1.concat(q);
        var sysdate = d2.concat(c1);

        $('#datePicker').datepicker({
            format : 'dd-mm-yyyy',
            //startDate : sysdate,
            //endDate : sysdate

        }).on('changeDate', function(e) {
            // Revalidate the date field
            $('#eventForm').formValidation('revalidateField', 'date');
        });

        $('#datePicker1').datepicker({
            format : 'dd-mm-yyyy',
            //startDate : sysdate

        }).on('changeDate', function(e) {
            // Revalidate the date field
            $('#eventForm').formValidation('revalidateField', 'date');
        });
    </script>


<script>
function AddRow()           
{
$('#dynamic-table1 tr').last().after('<tr><td><center>'+($('#dynamic-table1 tr').length-1)+'<input type="hidden" id="gift_id'+$('#dynamic-table1 tr').length+'" name="gift_id"></center></td><td><select name="gift_group" id="gift_group'+$('#dynamic-table1 tr').length+'" class="col-xs-12 col-sm-4"><option>--Select--</option><option>aa</option></select></td><td><select name="gift_name" id="gift_name'+$('#dynamic-table1 tr').length+'" class="col-xs-12 col-sm-4"><option>--Select--</option><option>aa</option></select></td><td><input type="text" style="width:100%;" id="gift_code'+$('#dynamic-table1 tr').length+'" value="" name="gift_code" readonly/></td><td><input type="text" style="width:100%;" id="effective_price'+$('#dynamic-table1 tr').length+'" value="" name="effective_price" /></td></tr>');

$('#rowcount1').val($('#dynamic-table1 tr').length-1);

var count = $('#rowcount1').val();

// 	$.ajax({
// 	    url: '${pageContext.request.contextPath}/getschemegroup',	
// 	    data:({datavalue :'GIFT_GROUP'}),
// 	    success: function(data) {				        	
// 	    	var select = $('#gift_group'+count);
// 	    	select.find('option').remove();
	    	
// 	    	$('<option>').val("").text("--select--").appendTo(select);
// 	           	  $.each(data, function(index, value) {		        	
// 	    	  $('<option>').val(value.gift_group).text(value.gift_group).appendTo(select);
// 	    	});
	
// 	    }
// 	  });
  
	$.ajax({
	    url: '${pageContext.request.contextPath}/loadschemegroup1',	
	    data:({datavalue :'GIFT_GROUP'}),
	    success: function(data) {				        	
	    	var select = $('#gift_group'+count);
	    	select.find('option').remove();
	    	
	    	$('<option>').val("").text("--select--").appendTo(select);
	           	  $.each(data, function(index, value) {		        	
	    	  $('<option>').val(value).text(value).appendTo(select);
	    	});
	
	    }
	  });
	
	$.ajax({
	    url: '${pageContext.request.contextPath}/getschemegroup1',	
	  //  data:({datavalue :'GIFT_GROUP'}),
	    success: function(data) {				        	
	    	var select = $('#gift_name'+count);
	    	select.find('option').remove();
	    	
	    	$('<option>').val("").text("--select--").appendTo(select);
	           	  $.each(data, function(index, value) {		        	
	    	  $('<option>').val(value.gift_id).text(value.gift_name).appendTo(select);
	    	});
	
	    }
	  });
}
</script>

<script>
$(window).load(function(){

    var fullDate = new Date();


     var n = fullDate.toString();
    var m=n.substring(4,7);

    var twoDigitMonth=0;

    if(m=='Jan' || m=='an')
        {
        twoDigitMonth=01;
        }else if(m=='Feb' || m=='eb')
            {
            twoDigitMonth=02;
            }else if(m=='Mar' || m=='ar'){
                twoDigitMonth=03;
            }else if(m=='Apr' || m=='pr'){
                twoDigitMonth=04;
            }else if(m=='May' || m=='ay'){
                twoDigitMonth=05;
            }else if(m=='Jun' || m=='un'){
                twoDigitMonth=06;
            }else if(m=='Jul' || m=='ul'){
                twoDigitMonth=07;
            }else if(m=='Aug' || m=='ug'){
                twoDigitMonth=08;
            }else if(m=='Sep' || m=='ep'){
                twoDigitMonth=09;
            }else if(m=='Oct' || m=='ct'){
                twoDigitMonth=10;
            }else if(m=='Nov' || m=='ov'){
                twoDigitMonth=11;
            }else if(m=='Dec' || m=='ec'){
                twoDigitMonth=12;
            }else{}



    var twoDigitDate = fullDate.getDate()+"";
    if(twoDigitDate.length==1)    twoDigitDate="0" +twoDigitDate;

    var currentDate = twoDigitDate + "-" + twoDigitMonth + "-" + fullDate.getFullYear();

    document.getElementById("created_on").value=currentDate;
    //alert(currentDate);
})
</script>






</body>
</html>

