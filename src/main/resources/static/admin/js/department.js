/**
 * 
 */
var dept={}
$(document).ready(function(){
	
	//When User Click on Update Button
	$('table #ButtonUpdateDepartment').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(deptList,status){
			$('#deptidEdit').val(deptList.deptid);
			$('#deptnameEdit').val(deptList.deptname);
			});
		$('#updateDepartmentModal').modal();
	});
	//When User Click On Delete Button
	$('table #ButtonDeleteDepartment').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmDepartmentButton').attr('href',href);
		$('#deleteDepartmentModal').modal();
	});
	
	
	
	/*
	 * When User Click on Submit Button 
	 */
	//Add Form
	$("#addDepartmentForm").submit(function(event){
		event.preventDefault();
		dept.submitDepartmentToInsert();
	})
	//Update Form
	$("#updateDepartmentForm").submit(function(event){
		event.preventDefault();
		dept.submitDepartmentToUpdate();
	});
	
	/*
	 * Function
	 */
	//Add Form
	dept.submitDepartmentToInsert=function(){
		var deptname=$("#addDepartmentForm #deptname").val();
		//SweetAlert
		swal.fire({
			title:"Are you sure!",
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
	                url: "/admin/department/save",
	                data:{deptname:deptname},
	                success: function (data) {
	                	 Swal.fire(
	   					      'Saved',
	   					      'Data has been saved!',
	   					      'success',
	   					    ) 
	   					 $('#addDepartmentModal').modal('hide');
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
			 $('#addDepartmentModal').modal('hide');
			}
		})
	}
	
	//Update Form
	dept.submitDepartmentToUpdate=function(){
		
		var deptid=$("#updateDepartmentForm #deptidEdit").val();
		var deptname=$("#updateDepartmentForm #deptnameEdit").val();
		swal.fire({
			title:"Are you sure!",
			text:"You want to save this record?",
			type:"infor",
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes'
		}).then((result)=>{
			if(result.value){
				$.ajax({
					type:'POST',
					datatype:'json',
					url:'/admin/department/update',
					data:{deptid:deptid,deptname:deptname},
					success:function(data){
						Swal.fire(
		   					      'Update',
		   					      'Data has been updated!',
		   					      'success',
		   					    ) 
		   					$("#updateDepartmentModal").modal('hide');
					},error: function(e) {
	                	Swal.fire(
		   					      'Érror',
		   					    ) 
	    			}
				})
			}else{
				swal.fire(
						'Cancel',
						'You have canceled'
				)
				$("#updateDepartmentModel").modal('hide');
			}
		})
	}
	
	
	
	
	//DataTable For Department Table
	$(function () {
	    $("#departmentTable").DataTable();
	    
	    
	  });
	
	
});
