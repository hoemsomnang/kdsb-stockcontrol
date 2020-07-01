/**
 * 
 */
var laptop={}
$(document).ready(function(){
	
	/* --------When user click and Scroll on Employee's Name select tag----------*/
	$('#empid').click(function(){
		var empid=$(this).find(":selected").val();
		 $.ajax({
			 url:"/admin/laptop/using/empname/?empid="+empid+"",/*---In laptop Controller---*/
			 type:'POST',
			 dataType:'json',
			 data:{empid:empid},	
		     success:function(laptop){
		    	 $('#addLaptopUsingForm #deptid').val(laptop.deptname)
		    	 $('#addLaptopUsingForm #empname').val(laptop.empname)
		    	 $('#addLaptopUsingForm #position').val(laptop.position)
		    	 $('#addLaptopUsingForm #brid').val(laptop.brname)
		     },error : function() {
             	swal.fire({
					title:"Error",
					text:"Data Error!",
					type:"warning"
				})
		 }
	})
	});
	$('#empid').change(function(){
		var empid=$(this).find(":selected").val();
		 $.ajax({
			 url:"/admin/laptop/using/empname/?empid="+empid+"",/*---In laptop Controller---*/
			 type:'POST',
			 dataType:'json',
			 data:{empid:empid},	
		     success:function(laptop){
		    	 $('#addLaptopUsingForm #deptid').val(laptop.deptname)
		    	 $('#addLaptopUsingForm #empname').val(laptop.empname)
		    	 $('#addLaptopUsingForm #position').val(laptop.position)
		    	 $('#addLaptopUsingForm #brid').val(laptop.brname)
		     },error : function() {
             	swal.fire({
					title:"Error",
					text:"Data Error!",
					type:"warning"
				})
		 }
	})
	});
	/*--------------End Employee's Name select Tag------------------------*/
	
	/*------------When user click on Laptop Model -----------------------*/
	$('#model').click(function(){
		var lapid=$(this).find(':selected').val();
		$.ajax({
			url:'/admin/laptop/using/laptop-not-yet-using/?lapid='+lapid+'',
			type:'POST',
			datatype:'json',
			data:{lapid:lapid},
			success: function(laptop){
				$('#addLaptopUsingForm #lapmodel').val(laptop.model);
				$('#addLaptopUsingForm #pcname').val(laptop.pcname);
				$('#addLaptopUsingForm #cpu').val(laptop.cpu);
				$('#addLaptopUsingForm #ram').val(laptop.ram);
				$('#addLaptopUsingForm #hhd').val(laptop.hhd);
				$('#addLaptopUsingForm #display').val(laptop.display);
				$('#addLaptopUsingForm #os').val(laptop.sn);
				$('#addLaptopUsingForm #asset').val(laptop.asset)
				var now = new Date(laptop.datein);
			    var day = ("0" + (now.getDate()+1)).slice(-2);
			    var month = ("0" + (now.getMonth() + 1)).slice(-2);
			    var datein = now.getFullYear()+"-"+(month)+"-"+(day) 
				
			    var now1 = new Date(laptop.dateusing);
			    var day1 = ("0" + (now1.getDate()+1)).slice(-2);
			    var month1 = ("0" + (now1.getMonth() + 1)).slice(-2);
			    var dateusing = now1.getFullYear()+"-"+(month1)+"-"+(day1)
				$('#addLaptopUsingForm #datein').val(datein)
				$('#addLaptopUsingForm #dateusing').val(dateusing)
				
				
			},error: function(){
				swal.fire({
					title:"Error",
					text:"Data Error!",
					type:"warning"
				})
			}
				
		})
	});
	$('#model').change(function(){
		var lapid=$(this).find(':selected').val();
		$.ajax({
			url:'/admin/laptop/using/laptop-not-yet-using/?lapid='+lapid+'',
			type:'POST',
			datatype:'json',
			data:{lapid:lapid},
			success: function(laptop){
				$('#addLaptopUsingForm #lapmodel').val(laptop.model);
				$('#addLaptopUsingForm #pcname').val(laptop.pcname);
				$('#addLaptopUsingForm #cpu').val(laptop.cpu);
				$('#addLaptopUsingForm #ram').val(laptop.ram);
				$('#addLaptopUsingForm #hhd').val(laptop.hhd);
				$('#addLaptopUsingForm #display').val(laptop.display);
				$('#addLaptopUsingForm #os').val(laptop.sn);
				$('#addLaptopUsingForm #asset').val(laptop.asset)
				var now = new Date(laptop.datein);
			    var day = ("0" + now.getDate()).slice(-2);
			    var month = ("0" + (now.getMonth() + 1)).slice(-2);
			    var datein = now.getFullYear()+"-"+(month)+"-"+(day)
			    
			    var now1 = new Date(laptop.dateusing);
			    var day1 = ("0" + now1.getDate()).slice(-2);
			    var month1 = ("0" + (now1.getMonth() + 1)).slice(-2);
			    var dateusing = now1.getFullYear()+"-"+(month1)+"-"+(day1)
				$('#addLaptopUsingForm #datein').val(datein)
				$('#addLaptopUsingForm #dateusing').val(dateusing)
				
			
			},error: function(){
				swal.fire({
					title:"Error",
					text:"Data Error!",
					type:"warning"
				})
			}
				
		})
	});
	/*------------End user click on Laptop Model-----------------------------*/
	/*========================================================================*/
	
	
	
	
	/*------------------All Event are here----------------------------------*/
	/*------------When User Click on Submit button on Add Form---------------*/
	$('#addLaptopUsingForm').submit(function(event){
		event.preventDefault();
		laptop.submitLaptopUsingToInsert();
	})
	/*-----------------------When user click on update button on table-------------------*/
	$('table #ButtonUpdateLaptopInstock').on('click',function(event){
		event.preventDefault();
		/*--- Get data with JSON with Controller---*/
        var href=$(this).attr('href');
        $.get(href,function(laptop,status){
        	$('#updateLaptopUsingForm #lapidEdit').val(laptop.lapid)
        	$('#updateLaptopUsingForm #empnameEdit').val(laptop.empname)
        	$('#updateLaptopUsingForm #modelEdit').val(laptop.model)
        	$('#updateLaptopUsingForm #cpuEdit').val(laptop.cpu)
        	$('#updateLaptopUsingForm #ramEdit').val(laptop.ram)
        	$('#updateLaptopUsingForm #hhdEdit').val(laptop.hhd)
        	$('#updateLaptopUsingForm #displayEdit').val(laptop.display)
        	//$('#updateLaptopUsingForm #osEdit').val(laptop.os)
        	$('#updateLaptopUsingForm #assetEdit').val(laptop.asset)
        	$('#updateLaptopUsingForm #snEdit').val(laptop.sn)
        	
        	var indate=new Date(laptop.datein)
        	var dayin = ("0" + indate.getDate()).slice(-2);
		    var monthin = ("0" + (indate.getMonth() + 1)).slice(-2);
		    var datein = indate.getFullYear()+"-"+(monthin)+"-"+(dayin)
        	$('#updateLaptopUsingForm #dateinEdit').val(datein)
        	
        	var usedate=new Date(laptop.dateusing)
        	var dayuse = ("0" + usedate.getDate()).slice(-2);
		    var monthuse = ("0" + (usedate.getMonth() + 1)).slice(-2);
		    var dateusing = usedate.getFullYear()+"-"+(monthuse)+"-"+(dayuse)
        	$('#updateLaptopUsingForm #dateusingEdit').val(dateusing)
        	$('#updateLaptopUsingForm #remarkEdit').val(laptop.remark)
        })
        /* show update modal */
        $('#updateLaptopInstockModal').modal();
	})
	/*----------------------End user click on update buuton on table---------------------*/
	
	/*----------------------When user click on submit on update form---------------------*/
	$('#updateLaptopUsingForm').submit(function(event){
		event.preventDefault();
		laptop.submitUpdateLaptopUsing();
	})
	/*--------------------End when user click on submit on update form------------------*/
	
	/*--------------------When user click on delete button in table----------------------*/
	$('table #ButtonDeleteLaptopInstock').click(function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmLaptopInstockButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteLaptopInstockModal').modal();
		
	})
	/*------------------End when user click on delete button in table--------------------*/
	
	/*--------------------End All Event-------------------------------------*/ 
	/*======================================================================*/
	
	
	
	/*----------------All Functions are here--------------------------------*/
	/*---------------Save date into database ------------------------------*/
	laptop.submitLaptopUsingToInsert=(function(){
		var empid=$('#addLaptopUsingForm #empid').val();
		var empname=$('#addLaptopUsingForm #empname').val();
		var lapid=$('#addLaptopUsingForm #model').val();
		var dateusing=$('#addLaptopUsingForm #dateusing').val();
		console.log(dateusing)
        //var lapdata={empid,empname,model}
        swal.fire({
			title:"Are your sure?",
			text:"You want to update this record?",
			type:'infor',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes'
		}).then((result)=>{
			if(result.value){
				$.ajax({
					type:'POST',
					datatype:'json',
					url:'/admin/laptop/using/add-Using',
					 data:{lapid:lapid,empid:empid,empname:empname,dateusing:dateusing},
					 success: function(data){
						 swal.fire({
								title:"Save",
								text:"Data have been saved!",
								type:"success"
							})
						laptop.clearAddFormData();
						$('#addLaptopInstockModal').modal('hide');
					 },error:function(){
						 swal.fire({
								title:"Error",
								text:"Contact Developer!",
								type:"warning"
							})
					 }
					
				})
			}else{
				swal.fire({
					title:"Cancel",
					text:"You have canceled",
					type:"warning"
				})
				$("#addLaptopInstockModal").modal('hide');
			}
		})
	})
    /*-------------Update laptop datea-----------------------------------*/
	laptop.submitUpdateLaptopUsing=function(){
		var lapid=$('#updateLaptopUsingForm #lapidEdit').val();
		var model=$('#updateLaptopUsingForm #modelEdit').val();
		var cpu=$('#updateLaptopUsingForm #cpuEdit').val();
		var ram=$('#updateLaptopUsingForm #ramEdit').val();
		var hhd=$('#updateLaptopUsingForm #hhdEdit').val();
		var display=$('#updateLaptopUsingForm #displayEdit').val();
		var sn=$('#updateLaptopUsingForm #snEdit').val();
		var asset=$('#updateLaptopUsingForm #assetEdit').val();
		var datein=$('#updateLaptopUsingForm #dateinEdit').val();
		var dateusing=$('#updateLaptopUsingForm #dateusingEdit').val();
		var remark=$('#updateLaptopUsingForm #remarkEdit').val();
		//console.log(lapid,model,cpu,ram,hhd,display,sn,asset,datein,dateusing,remark);
		/* Using sweetAlert */
		swal.fire({
			title:"Are your sure?",
			text:"You want to update this record?",
			type:'infor',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes'
		}).then((result)=>{
			if(result.value){
				$.ajax({
					type:'POST',
					datatype:'json',
					url:'/admin/laptop/using/update',
					 data:{lapid:lapid,model:model,cpu:cpu,ram:ram,hhd:hhd,display:display,sn:sn,asset:asset,dateusing:dateusing,remark:remark},
					 success: function(data){
						 swal.fire({
								title:"Update",
								text:"Data have been updated!",
								type:"success"
							})
						laptop.clearAddFormData();
						$('#updateLaptopInstockModal').modal('hide');
					 },error:function(){
						 swal.fire({
								title:"Error",
								text:"Contact Developer!",
								type:"warning"
							})
					 }
					
				})
			}else{
				swal.fire({
					title:"Cancel",
					text:"You have canceled",
					type:"warning"
				})
				$("#updateLaptopInstockModal").modal('hide');
			}
		})
	}
	
	/*--------------Clear Data --------------------------------------------*/
	laptop.clearAddFormData=function(){
		$('#addLaptopUsingForm #deptid').val('');
		$('#addLaptopUsingForm #position').val('');
		$('#addLaptopUsingForm #brid').val('');
		$('#addLaptopUsingForm #pcname').val('');
		$('#addLaptopUsingForm #hhd').val('');
		$('#addLaptopUsingForm #display').val('');
		$('#addLaptopUsingForm #os').val('');
		$('#addLaptopUsingForm #sn').val('');
		$('#addLaptopUsingForm #asset').val('');
		$('#addLaptopUsingForm #datein').val('');
		$('#addLaptopUsingForm #dateusing').val('');
	}
	
	
	/*----------------End All functions-------------------------------------*/
	/*======================================================================*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * When user click on delete button in table
	 
	$('table #ButtonDeleteLaptopInstock').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmLaptopInstockButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteLaptopInstockModal').modal();
	})
*/	
	
})


