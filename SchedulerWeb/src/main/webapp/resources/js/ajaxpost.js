/**
 * 
 */

$(document).ready( function() {
	
	$("#campusCombo").change(function() {
		var campusId = $(this).val();
		var post_url = "/Scheduler/department/getDepartmentCombo/" + campusId;
		if (campusId != null) {
		$.ajax({
	          type: "GET", 
	          url: post_url,
	          success: function(result) {
	            $("#departmentComboDiv").html(result);
	          },
	          error: function(xhr, status, error){
	        	  $("#departmentComboDiv").html(status);
	          }
	      }); 
		}
	      event.preventDefault();
	      return false;
	});

});

function onNickNameChange() {
	var id = $("#departmentCombo").val();
	var date = $("#appDate").val();
	
	var myValue = id + ":" + date;
	var post_url = "/Scheduler/departmenttimeslot/gettimeslotcombo/" + myValue;
	$.ajax({
          type: "GET", 
          url: post_url,
          success: function(result) {
            $("#timeslotComboDiv").html(result);
          },
          error: function(xhr, status, error){
        	  $("#timeslotComboDiv").html(status);
          }
      }); 
      event.preventDefault();
      return false;
}
