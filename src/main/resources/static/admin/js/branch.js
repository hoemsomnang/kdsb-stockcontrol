/**
 * 
 */
var branch={}
$(document).ready(function(){
	
	//When User Click on Update Button
	$('table #ButtonUpdateBranch').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(brList,status){
			$('#bridEdit').val(brList.brid);
			$('#brnameEdit').val(brList.brname);
			});
		$('#updateBranchModal').modal();
	});
	//When User Click On Delete Button
	$('table #ButtonDeleteBranch').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmBranchButton').attr('href',href);
		$('#deleteBranchModal').modal();
	});
	
	/*
	 * When User Click on Submit button 
	 */
	//Add Form
	$('#addBranchForm').submit(function(event){
		event.preventDefault();
		branch.submitBranchToInsert();
	})
	
	//Update Form
	$('#updateBranchForm').submit(function(event){
		event.preventDefault();
        branch.submitBranchToUpdate();
	})
	/*
	 * Function
	 */
	
	//Add Fomr
	branch.submitBranchToInsert=function(){
		var brname=$("#addBranchForm #brname").val();
        swal.fire({
        	title:"Are you sure?",
        	text:"You want to save this record?",
        	type:"infor",
        	showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
        }).then((result)=>{
        	if(result.value){
        		$.ajax({
	                type: "POST",
	                datatype:'json',
	                url: "/admin/branch/save",
	                data:{brname:brname},
	                success: function (data) {
	                	 Swal.fire(
	   					      'Saved',
	   					      'Data has been saved!',
	   					      'success',
	                	 )
	   					 $('#addBranchModal').modal('hide');
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
			   $('#addBranchModal').modal('hide');
        	}
        })	
	}
	
	//Update Form
	branch.submitBranchToUpdate=function(){
		var brid=$("#updateBranchForm #bridEdit").val();
		var brname=$("#updateBranchForm #brnameEdit").val();
		swal.fire({
        	title:"Are you sure?",
        	text:"You want to update this record?",
        	type:"infor",
        	showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
        }).then((result)=>{
        	if(result.value){
        		$.ajax({
	                type: "POST",
	                datatype:'json',
	                url: "/admin/branch/update",
	                data:{brid:brid,brname:brname},
	                success: function (data) {
	                	 Swal.fire(
	   					      'Update',
	   					      'Data has been updated!',
	   					      'success',
	   					    ) 
	   					 $('#updateBranchModal').modal('hide');
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
        	}
        })
	}
	
	
	//DataTable For Department Table
	$(function () {
	    $("#branchTable").DataTable();
	    
	  });
	
});
