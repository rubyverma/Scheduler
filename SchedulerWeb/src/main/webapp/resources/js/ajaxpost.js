/**
Author - Shalin Banjara
Usage - All the jQuery and Ajax function for generating dynamic combo boxes based on user selections
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
		$("#campusCombo").attr('disabled','disabled');
		$("#datepicker").attr('disabled','disabled');
	      event.preventDefault();
	      return false;
	});

});


function onNickNameChange() {
	$("#departmentCombo").attr('disabled','disabled');
	$("#campusCombo").attr('disabled','disabled');
	var id = $("#departmentCombo").val();
	var date = $("#datepicker").val();
	
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
function validate(){
	var x = $("#departmentTimeId").val();
	var y = $('#departmentTimeId option').size();
	if (y<2){
		alert("Sorry, all the time for selected department for selected date is full or this department does not operate on the date specified.");
		return false;
		}
	if (x == '-1'){
		alert("Please select one available time-slot");
		return false;
	}
	else {
		return true;
		}
}
