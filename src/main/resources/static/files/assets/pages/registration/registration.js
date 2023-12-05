'use strict';
$(document).ready(function() {

    
	  function callMethod(){
		alert('kkkkkkkkkkkkkk');
		var name1 = $("select#menu_group_id").val();
		$.ajax({
			url: '${pageContext.request.contextPath}/testmenu',
		 	 data: ({name :name1}),
		     success: function(data) {
		    	 alert("onchange is runninbg");
		   	  var select = $('select[name="appl_menu_multiple_select"]');
		   	  var multi_select_menu = $('select[name="appl_menu_multiple_select"]').bootstrapDualListbox();
		       var container1 = multi_select_menu.bootstrapDualListbox('getContainer');
		      container1.find('.btn').addClass('btn-white btn-info btn-bold'); 
		      $.each(data, function(index, value) {
	
		    	  
		    	  $('<option>').val(value.menu_header_id).text(value.header_name).appendTo(select);
		      });
		      multi_select_menu.bootstrapDualListbox('refresh',true);
		     
		     }
			});
		}
		
});
