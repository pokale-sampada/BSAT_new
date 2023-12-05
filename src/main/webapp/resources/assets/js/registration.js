'use strict';
$(document).ready(function() {

	$('#menu_group_id').on('change', function(e) {
		
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
		$.ajax({
			url: '/testmenu',
			data: ({ name: valueSelected }),
			success: function(data) {

				var select = $('select[name="appl_menu_multiple_select"]');
				var multi_select_menu = select.bootstrapDualListbox();
				//var container1 = multi_select_menu.bootstrapDualListbox('getContainer');
				//container1.find('.btn').addClass('btn-white btn-info btn-bold');

				$.each(data, function(index, value) {

					$('<option>').val(value.menu_header_id).text(value.header_name).appendTo(select);
				});
				multi_select_menu.bootstrapDualListbox('refresh', true);

			}
		});
	});

});
/* 


<script
	src="<c:url value='/resources/assets/js/bootstrap-multiselect.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/select2.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/assets/js/jquery.bootstrap-duallistbox.min.js'/>"
	type="text/javascript"></script>
<script src="/path/to/cdn/jquery.slim.min.js"></script>

 */