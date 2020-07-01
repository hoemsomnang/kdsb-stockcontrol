/**
 * 
 */
var desktop={}
$(document).ready(function(){
	
	/* --------When user click and Scroll on Employee's Name select tag----------*/
	$('#empid').click(function(){
		var empid=$(this).find(":selected").val();
		 $.ajax({
			 url:"/admin/desktop/using/empname/?empid="+empid+"",/*---In laptop Controller---*/
			 type:'POST',
			 dataType:'json',
			 data:{empid:empid},	
		     success:function(desktop){
		    	 $('#addDesktopUsingForm #deptid').val(desktop.deptname)
		    	 $('#addDesktopUsingForm #empname').val(desktop.empname)
		    	 $('#addDesktopUsingForm #position').val(desktop.position)
		    	 $('#addDesktopUsingForm #brid').val(desktop.brname)
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
			 url:"/admin/desktop/using/empname/?empid="+empid+"",/*---In laptop Controller---*/
			 type:'POST',
			 dataType:'json',
			 data:{empid:empid},	
		     success:function(desktop){
		    	 $('#addDesktopUsingForm #deptid').val(desktop.deptname)
		    	 $('#addDesktopUsingForm #empname').val(desktop.empname)
		    	 $('#addDesktopUsingForm #position').val(desktop.position)
		    	 $('#addDesktopUsingForm #brid').val(desktop.brname)
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
		var desid=$(this).find(':selected').val();
		$.ajax({
			url:'/admin/desktop/using/desktop-not-yet-using/?desid='+desid+'',
			type:'POST',
			datatype:'json',
			data:{desid:desid},
			success: function(desktop){
				$('#addDesktopUsingForm #lapmodel').val(desktop.model);
				$('#addDesktopUsingForm #pcname').val(desktop.pcname);
				$('#addDesktopUsingForm #cpu').val(desktop.cpu);
				$('#addDesktopUsingForm #ram').val(desktop.ram);
				$('#addDesktopUsingForm #hhd').val(desktop.hhd);
				$('#addDesktopUsingForm #display').val(desktop.display);
				$('#addDesktopUsingForm #sn').val(desktop.sn);
				$('#addDesktopUsingForm #os').val(desktop.os);
				$('#addDesktopUsingForm #asset').val(desktop.asset)
				var now = new Date(desktop.datein);
			    var day = ("0" + now.getDate()).slice(-2);
			    var month = ("0" + (now.getMonth() + 1)).slice(-2);
			    var datein = now.getFullYear()+"-"+(month)+"-"+(day) 
				
			    var now1 = new Date(desktop.dateusing);
			    var day1 = ("0" + now1.getDate()).slice(-2);
			    var month1 = ("0" + (now1.getMonth() + 1)).slice(-2);
			    var dateusing = now1.getFullYear()+"-"+(month1)+"-"+(day1)
				$('#addDesktopUsingForm #datein').val(datein)
				$('#addDesktopUsingForm #dateusing').val(dateusing)
				
				
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
		var desid=$(this).find(':selected').val();
		$.ajax({
			url:'/admin/desktop/using/desktop-not-yet-using/?desid='+desid+'',
			type:'POST',
			datatype:'json',
			data:{desid:desid},
			success: function(desktop){
				$('#addDesktopUsingForm #lapmodel').val(desktop.model);
				$('#addDesktopUsingForm #pcname').val(desktop.pcname);
				$('#addDesktopUsingForm #cpu').val(desktop.cpu);
				$('#addDesktopUsingForm #ram').val(desktop.ram);
				$('#addDesktopUsingForm #hhd').val(desktop.hhd);
				$('#addDesktopUsingForm #display').val(desktop.display);
				$('#addDesktopUsingForm #sn').val(desktop.sn);
				$('#addDesktopUsingForm #os').val(desktop.os);
				$('#addDesktopUsingForm #asset').val(desktop.asset)
				var now = new Date(desktop.datein);
			    var day = ("0" + now.getDate()).slice(-2);
			    var month = ("0" + (now.getMonth() + 1)).slice(-2);
			    var datein = now.getFullYear()+"-"+(month)+"-"+(day)
			    
			    var now1 = new Date(desktop.dateusing);
			    var day1 = ("0" + now1.getDate()).slice(-2);
			    var month1 = ("0" + (now1.getMonth() + 1)).slice(-2);
			    var dateusing = now1.getFullYear()+"-"+(month1)+"-"+(day1)
				$('#addDesktopUsingForm #datein').val(datein)
				$('#addDesktopUsingForm #dateusing').val(dateusing)
				
			
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
	$('#addDesktopUsingForm').submit(function(event){
		event.preventDefault();
		desktop.submitDesktopUsingToInsert();
	})
	/*-----------------------When user click on update button on table-------------------*/
	$('table #ButtonUpdateDesktopUsing').on('click',function(event){
		event.preventDefault();
		/*--- Get data with JSON with Controller---*/
        var href=$(this).attr('href');
        $.get(href,function(desktop,status){
        	$('#updateDesktopUsingForm #desidEdit').val(desktop.desid)
        	$('#updateDesktopUsingForm #empnameEdit').val(desktop.empname)
        	$('#updateDesktopUsingForm #modelEdit').val(desktop.model)
        	$('#updateDesktopUsingForm #cpuEdit').val(desktop.cpu)
        	$('#updateDesktopUsingForm #ramEdit').val(desktop.ram)
        	$('#updateDesktopUsingForm #hhdEdit').val(desktop.hhd)
        	$('#updateDesktopUsingForm #displayEdit').val(desktop.display)
        	//$('#updateLaptopUsingForm #osEdit').val(laptop.os)
        	$('#updateDesktopUsingForm #assetEdit').val(desktop.asset)
        	$('#updateDesktopUsingForm #snEdit').val(desktop.sn)
        	
        	var indate=new Date(desktop.datein)
        	var dayin = ("0" + (indate.getDate()+1)).slice(-2);
		    var monthin = ("0" + (indate.getMonth() + 1)).slice(-2);
		    var datein = indate.getFullYear()+"-"+(monthin)+"-"+(dayin)
        	$('#updateDesktopUsingForm #dateinEdit').val(datein)
        	
        	var usedate=new Date(desktop.dateusing)
        	var dayuse = ("0" + (usedate.getDate()+1)).slice(-2);
		    var monthuse = ("0" + (usedate.getMonth() + 1)).slice(-2);
		    var dateusing = usedate.getFullYear()+"-"+(monthuse)+"-"+(dayuse)
        	$('#updateDesktopUsingForm #dateusingEdit').val(dateusing)
        	$('#updateDesktopUsingForm #remarkEdit').val(desktop.remark)
        })
        /* show update modal */
        $('#updateDesktopUsingModal').modal();
	})
	/*----------------------End user click on update buuton on table---------------------*/
	
	/*----------------------When user click on submit on update form---------------------*/
	$('#updateDesktopUsingForm').submit(function(event){
		event.preventDefault();
		desktop.submitUpdateDesktopUsing();
	})
	/*--------------------End when user click on submit on update form------------------*/
	
	/*--------------------When user click on delete button in table----------------------*/
	$('table #ButtonDeleteDesktopUsing').click(function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmDesktopUsingButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteDesktopUsingModal').modal();
		
	})
	/*------------------End when user click on delete button in table--------------------*/
	
	/*--------------------End All Event-------------------------------------*/ 
	/*======================================================================*/
	
	
	
	/*----------------All Functions are here--------------------------------*/
	/*---------------Save date into database ------------------------------*/
	desktop.submitDesktopUsingToInsert=(function(){
		var empid=$('#addDesktopUsingForm #empid').val();
		var empname=$('#addDesktopUsingForm #empname').val();
		var desid=$('#addDesktopUsingForm #model').val();
		var dateusing=$('#addDesktopUsingForm #dateusing').val();
		//console.log(dateusing)
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
					url:'/admin/desktop/using/add-Using',
					 data:{desid:desid,empid:empid,empname:empname,dateusing:dateusing},
					 success: function(data){
						 swal.fire({
								title:"Save",
								text:"Data have been saved!",
								type:"success"
							})
						desktop.clearAddFormData();
						$('#addDesktopUsingModal').modal('hide');
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
				$("#addDesktopUsingModal").modal('hide');
			}
		})
	})
    /*-------------Update laptop datea-----------------------------------*/
	desktop.submitUpdateDesktopUsing=function(){
		var desid=$('#updateDesktopUsingForm #desidEdit').val();
		var model=$('#updateDesktopUsingForm #modelEdit').val();
		var cpu=$('#updateDesktopUsingForm #cpuEdit').val();
		var ram=$('#updateDesktopUsingForm #ramEdit').val();
		var hhd=$('#updateDesktopUsingForm #hhdEdit').val();
		var display=$('#updateDesktopUsingForm #displayEdit').val();
		var sn=$('#updateDesktopUsingForm #snEdit').val();
		var asset=$('#updateDesktopUsingForm #assetEdit').val();
		var datein=$('#updateDesktopUsingForm #dateinEdit').val();
		var dateusing=$('#updateDesktopUsingForm #dateusingEdit').val();
		var remark=$('#updateDesktopUsingForm #remarkEdit').val();
		console.log(desid,model,cpu,ram,hhd,display,sn,asset,datein,dateusing,remark);
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
					url:'/admin/desktop/using/update',
					 data:{desid:desid,model:model,cpu:cpu,ram:ram,hhd:hhd,display:display,sn:sn,asset:asset,dateusing:dateusing,remark:remark},
					 success: function(data){
						 swal.fire({
								title:"Update",
								text:"Data have been updated!",
								type:"success"
							})
						desktop.clearAddFormData();
						$('#updateDesktopUsingModal').modal('hide');
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
				$("#updateDesktopUsingModal").modal('hide');
			}
		})
	}
	
	/*--------------Clear Data --------------------------------------------*/
	desktop.clearAddFormData=function(){
		$('#addDesktopUsingForm #deptid').val('');
		$('#addDesktopUsingForm #position').val('');
		$('#addDesktopUsingForm #brid').val('');
		$('#addDesktopUsingForm #pcname').val('');
		$('#addDesktopUsingForm #hhd').val('');
		$('#addDesktopUsingForm #display').val('');
		$('#addDesktopUsingForm #os').val('');
		$('#addDesktopUsingForm #sn').val('');
		$('#addDesktopUsingForm #asset').val('');
		$('#addDesktopUsingForm #datein').val('');
		$('#addDesktopUsingForm #dateusing').val('');
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


