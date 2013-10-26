/**
 * 
 */

$(document).ready( function() {
	
	$("#nameCombo").change(function() {
		var selected = $(this).val();
		var post_url = "nickname/";
		$.ajax({
	          type: "POST", 
	          url: post_url,
	          data: { "user_id" : selected},
	          success: function(result) {
	            $("#nicknameComboDiv").html(result);
	          },
	          error: function(xhr, status, error){
	        	  $("#nicknameComboDiv").html(status);
	          }
	      }); 
	      event.preventDefault();
	      return false;
	});

});

function onNickNameChange() {
	alert('got it');
}
