/**
 * 
 */
var employee={}
$(document).ready(function(){
	/*
	 * When User Click On Update Button in Table
	 */
	$('table #ButtonUpdateEmployee').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(empList,status){
			$("#updateEmployeeForm #empidEdit").val(empList.empid);
			$("#updateEmployeeForm #empnameEdit").val(empList.empname);
			$("#updateEmployeeForm #positionEdit").val(empList.position);
			$("#updateEmployeeForm #teamEdit").val(empList.team);
			$("#updateEmployeeForm #phoneEdit").val(empList.phone);
			$("#updateEmployeeForm #extensionEdit").val(empList.extension);
			$("#updateEmployeeForm #emailEdit").val(empList.email);
			$("#updateEmployeeForm #bridEdit").val(empList.brid);
			$("#updateEmployeeForm #deptidEdit").val(empList.deptid);
			var now = new Date(empList.dob);
			var day = ("0" + now.getDate()).slice(-2);
			var month = ("0" + (now.getMonth() + 1)).slice(-2);
			var dob = now.getFullYear()+"-"+(month)+"-"+(day) 
			$("#updateEmployeeForm #dobEdit").val(dob);	
		})
		$('#updateEmployeeModal').modal();
	});
	
	
	/*
	 * When User Click on Delete Button in Table
	 */
	$('table #ButtonDeleteEmployee').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmEmployeeButton').attr('href',href);
		$('#deleteEmployeeModal').modal();
	});
	
	
	/*
	 * When User Click button Submit on Add Form
	 */
	$("#addEmployeeForm").submit(function(event){
		event.preventDefault();
		employee.submitEmployeeToInsert();
		
	});
	/*
	 * When User click on button submit on Update Form
	 */
	$("#updateEmployeeForm").submit(function(event){
		event.preventDefault();
		employee.submitEmployeeToUpdate();
	})
	
	
	
	/*
	 * Function
	 */
	//Add Form
	employee.submitEmployeeToInsert=function(){
		
		//Get value from form by ID
		var empname=$("#addEmployeeForm #empname").val();
		var sex=$("#addEmployeeForm #sex").val();
		var dob=$("#addEmployeeForm #dob").val();
		var deptid=$("#addEmployeeForm #deptid").val();
		var position=$("#addEmployeeForm #position").val();
		var brid=$("#addEmployeeForm #brid").val();
		var phone=$("#addEmployeeForm #phone").val();
		var extension=$("#addEmployeeForm #extension").val();
		var email=$("#addEmployeeForm #email").val();
		var empdata={ empname,sex,dob,deptid,position,brid,phone,extension,email }
		
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
				//Using Ajax
				$.ajax({
	                type: "POST",
	                datatype:'json',
	                url: "/admin/employee/save",
	                data:{empname:empname,sex:sex,dob:dob,deptid:deptid,position:position,brid:brid,phone:phone,extension:extension,email:email},
	                success: function (data) {
	                	swal.fire({
							title:"saved",
							text:"Data have been saved!",
							type:"success"
						})
	   					 $('#addEmployeeModal').modal('hide');
	                	 employee.clearAddEmployeeData();
	                },error : function(e) {
	                	swal.fire({
							title:"Error",
							text:"Data Error!",
							type:"warning"
						})
						$('#addEmployeeModal').modal('hide');
	                	employee.clearAddEmployeeData();
	    			}
	            }); 
			}else{
				swal.fire({
				     title:"Cancel",
				     text:"You have Cancel!",
				     type:"warning"
				})
				//Close Add Employee Modal
				$("#addEmployeeModal").modal('hide');
				employee.clearAddEmployeeData();
			}
			
		})
		
		
	}
	
	//Update
	employee.submitEmployeeToUpdate=function(){
		
		var empid=$("#updateEmployeeForm #empidEdit").val();
		var empname=$("#updateEmployeeForm #empnameEdit").val();
		var position=$("#updateEmployeeForm #positionEdit").val();
		var team=$("#updateEmployeeForm #teamEdit").val();
		var phone=$("#updateEmployeeForm #phoneEdit").val();
		var extension=$("#updateEmployeeForm #extensionEdit").val();
		var email=$("#updateEmployeeForm #emailEdit").val();
		var brid=$("#updateEmployeeForm #bridEdit").val();
		var deptid=$("#updateEmployeeForm #deptidEdit").val();
		var dob=$("#updateEmployeeForm #dobEdit").val();
		var data={empid,empname,position,team,phone,extension,email,brid,deptid,dob}
		
		swal.fire({
			title:"Are you sure!",
			text:"You want to update this record?",
			type:"infor",
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes'
		}).then((result)=>{
			if(result.value){
				$.ajax({
					type:"POST",
					datatype:"json",
					url:"/admin/employee/update",
					data:{empid:empid,empname:empname,position:position,team:team,phone:phone,extension:extension,email:email,brid:brid,deptid:deptid,dob:dob},
					success: function(data){
						Swal.fire(
							      'Updated',
							      'Data has been updated!',
							      'success',
							    ) 
				      $("#updateEmployeeModal").modal('hide');	
					},error:function(){
						Swal.fire(
							      'Error',
							    ) 
					$("#updateEmployeeModal").modal('hide');
					}
				})
				
				
				
			}else{
				Swal.fire(
						'Cancel!',
					    'You have cancel',
		   				) 
		   	$("#updateEmployeeModal").modal('hide');	
			}
		})
		
		
	}
	
	//Clear data in Form
	employee.clearAddEmployeeData=function(){
		$("#addEmployeeForm #empname").val('');
		$("#addEmployeeForm #sex").val('');
		$("#addEmployeeForm #dob").val('');
		$("#addEmployeeForm #deptid").val('');
		$("#addEmployeeForm #position").val('');
		$("#addEmployeeForm #team").val('');
		$("#addEmployeeForm #brid").val('');
		$("#addEmployeeForm #phone").val('');
		$("#addEmployeeForm #extension").val('');
		$("#addEmployeeForm #email").val('');
		
	}
	
	
	$(function () {
	    //Using Data Table
	    $("#employeeTableHQ").DataTable();
	    $("#employeeTableSaenSokh").DataTable();
	   
	   })
	    
 });
	
