/**
 * 
 */
var user={}
$(document).ready(function(){
	//When User Click On Update Button
	$('table #ButtonUpdate').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(userlist,status){
			$('#useidEdit').val(userlist.useid);
			$('#usernameEdit').val(userlist.username);
			$('#passwordEdit').val(userlist.password);
		})
		$('#updateUserModal').modal();
	});
	//When User Click On Delete Button
	$('table #ButtonDelete').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmButton').attr('href',href);
		$('#deleteUserModal').modal();
	});
	
	
	/*
	 * When User Click on Submit Button
	 */
	//Add Form
	$("#addUserForm").submit(function(event){
		event.preventDefault();
		user.submitUserToInsert();
		
	})
	//Update Form
	
	
	//Reload Data
	user.reloadData=function(){
		var url = "/admin/user";
		$("#results").load(url);
	}
	
	
	/*
	 * Function
	 */
	
	// Insert Function
	user.submitUserToInsert = function(){
		var username=$("#addUserForm #username").val();
		var password=$("#addUserForm #password").val();
		Swal.fire({
			  title: 'Are you sure?',
			  text: "You want to save this record?",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
			}).then((result) => {
			  if (result.value) {
				  $.ajax({
		                type: "POST",
		                datatype:'json',
		                url: "/admin/user/save",
		                data:{username:username,password:password},
		                success: function (data) {
		                	 Swal.fire(
		   					      'Saved',
		   					      'Data has been saved!',
		   					      'success',
		                	 )
		   					 $('#adduserModal').modal('hide');
		                	// user.reloadData(); 
		                },error : function(e) {
		                	Swal.fire(
			   					      'Érror',
			   					    ) 
		    			}
		            }); 
			  }else{
				  Swal.fire(
					      'Cancel!',
					      'You have cancel',
					    )
				$('#adduserModal').modal('hide');
			  }
			})
	};
	
	//Update Function
	user.submitUserToUpdate=function(){
		
	}


	//DataTable
	
	$(function () {
	    $("#userTable").DataTable();
	   
	  });
}) 