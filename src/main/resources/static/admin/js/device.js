/**
 * 
 */
var device={}
$(document).ready(function(){

	/*---- All Events are here ----*/
	// * When user click on submit button on Form Add New Laptop Instock
	$("#addDesktopInstockForm").submit(function(event){
		event.preventDefault();
		device.submitDeviceToInsert();
	});
	/*---- When user click on update button in table ----*/
	$('table .ButtonUpdateDevice').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href')
		$.get(href,function(device,status){
			
			  $('#updateDesktopInstockForm #nameEdit').val(device.name);
			  $('#updateDesktopInstockForm #devidEdit').val(device.devid);
		      $('#updateDesktopInstockForm #modelEdit').val(device.model);
		      $('#updateDesktopInstockForm #qtyEdit').val(device.qty);
		      $('#updateDesktopInstockForm #assetEdit').val(device.asset);
		      $('#updateDesktopInstockForm #versionEdit').val(device.version);
		      $('#updateDesktopInstockForm #remarkEdit').val(device.remark);
		      $('#updateDesktopInstockForm #cateidEdit').val(device.cateid);
		      $('#updateDesktopInstockForm #location2Edit').val(device.location2);
		      $('#updateDesktopInstockForm #bridEdit').val(device.brid);
		      $('#updateDesktopInstockForm #statusEdit').val(device.status);
		        var indate=new Date(device.datein)
	        	var dayin = ("0" + (indate.getDate()+1)).slice(-2);
			    var monthin = ("0" + (indate.getMonth() + 1)).slice(-2);
			    var datein = indate.getFullYear()+"-"+(monthin)+"-"+(dayin)
		      $('#updateDesktopInstockForm #dateinEdit').val(datein);
		      
			    var usingdate=new Date(device.datein)
	        	var dayusing = ("0" + (usingdate.getDate()+1)).slice(-2);
			    var monthusing = ("0" + (usingdate.getMonth() + 1)).slice(-2);
			    var dateusing = usingdate.getFullYear()+"-"+(monthusing)+"-"+(dayusing);
			   $('#updateDesktopInstockForm #dateusingEdit').val(dateusing);
		      
			$('#updateDeviceModal').modal();
		})
	})
	/*----- When user Click on submit in form update ----*/
	$('#updateDesktopInstockForm').submit(function(event){
		event.preventDefault();
		device.submitUpdateDevice();
	})
	/*---- When user click on delte button in table ----*/
	$('table .ButtonDeleteDevice').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmDeviceButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteDeviceModal').modal();

	})
	/*---- End All Events -----*/
	
	
	/*---- All functions are here ----*/
	
	/*------ This function is using for insert ----*/
	device.submitDeviceToInsert=function(){
      var name=$('#addDesktopInstockForm #name').val();
      var model=$('#addDesktopInstockForm #model').val();
      var qty=$('#addDesktopInstockForm #qty').val();
      var asset=$('#addDesktopInstockForm #asset').val();
      var version=$('#addDesktopInstockForm #version').val();
      var remark=$('#addDesktopInstockForm #remark').val();
      var cateid=$('#addDesktopInstockForm #cateid').val();
      var location2=$('#addDesktopInstockForm #location2').val();
      var brid=$('#addDesktopInstockForm #brid').val();
      var status=$('#addDesktopInstockForm #status').val();
      var datein=$('#addDesktopInstockForm #datein').val();
      var dateusing=$('#addDesktopInstockForm #dateusing').val();
      //var data={name,model,qty,asset,version,remark,cateid,location2,brid,status,datein,dateusing}
      /*------ Using SweetAlert2 ------*/
      swal.fire({
			title:"Are your sure?",
			text:"You want to save this record?",
			type:'infor',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes'
		}).then((result)=>{
			if(result.value){
				$.ajax({
	                type: 'POST',
	                datatype:'json',
	                url: "/admin/device/save",
	                data:{name:name,model:model,qty:qty,asset:asset,version:version,remark:remark,cateid:cateid,location2:location2,brid:brid,status:status,datein:datein,dateusing:dateusing},
	                success: function (data) {
	                	swal.fire({
							title:"saved",
							text:"Data have been saved!",
							type:"success"
						})
						device.clearFormInsert();
						$("#addDeviceModal").modal('hide');
	                },error : function(e) {
	                	swal.fire({
							title:"Error",
							text:"Data Error!",
							type:"warning"
						})
	    			}
	            }); 
			}else{
				swal.fire(
					"Cancel",
					"You have canceled",
					"infor"
				)
				device.clearFormInsert();
				$("#addDeviceModal").modal('hide');
			}
		})
      
	}
	/*------ This function is using for update ------*/
	device.submitUpdateDevice=function(){
		      var name=$('#updateDesktopInstockForm #nameEdit').val();
		      var model=$('#updateDesktopInstockForm #modelEdit').val();
		      var qty=$('#updateDesktopInstockForm #qtyEdit').val();
		      var asset=$('#updateDesktopInstockForm #assetEdit').val();
		      var version=$('#updateDesktopInstockForm #versionEdit').val();
		      var remark=$('#updateDesktopInstockForm #remarkEdit').val();
		      var cateid=$('#updateDesktopInstockForm #cateidEdit').val();
		      var location2=$('#updateDesktopInstockForm #location2Edit').val();
		      var brid=$('#updateDesktopInstockForm #bridEdit').val();
		      var status=$('#updateDesktopInstockForm #statusEdit').val();
		      var datein=$('#updateDesktopInstockForm #dateinEdit').val();
		      var dateusing=$('#updateDesktopInstockForm #dateusingEdit').val();
		      var devid=$('#updateDesktopInstockForm #devidEdit').val();
		      
		      //var data={name,model,qty,asset,version,remark,cateid,location2,brid,status,datein,dateusing}
		      //console.log(data);
		      /*------ Using SweetAlert2 ------*/
		      swal.fire({
					title:"Are your sure?",
					text:"You want to save this record?",
					type:'infor',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes'
				}).then((result)=>{
					if(result.value){
						$.ajax({
			                type: 'POST',
			                datatype:'json',
			                url: "/admin/device/update",
			                data:{name:name,model:model,qty:qty,asset:asset,
			                	version:version,remark:remark,cateid:cateid,
			                	location2:location2,brid:brid,status:status,
			                	datein:datein,dateusing:dateusing,devid:devid},
			                success: function (data) {
			                	swal.fire({
									title:"update",
									text:"Data have been update!",
									type:"success"
								})
								device.clearFormUpdate();
								$("#updateDeviceModal").modal('hide');
			                },error : function(e) {
			                	swal.fire({
									title:"Error",
									text:"Data Error!",
									type:"warning"
								})
			    			}
			            }); 
					}else{
						swal.fire(
							"Cancel",
							"You have canceled",
							"infor"
						)
						device.clearFormUpdate();
						$("#updateDeviceModal").modal('hide');
					}
				})
		   
	   //device.clearFormUpdate();
		
		
	}
	
	/*------ End all functions ------*/
	/*var desktop={}
	
	 * When user click on update button in table to get Single Data
	 
	$('table .ButtonUpdateDesktopInstock').on('click',function(event){
		event.preventDefault();
		//Get Data From json with LaptopController
		var href=$(this).attr('href');
		$.get(href,function(desktops,status){
			$("#updateDesktopInstockForm #desidEdit").val(desktops.desid);
			$("#updateDesktopInstockForm #modelEdit").val(desktops.model);
			$("#updateDesktopInstockForm #cpuEdit").val(desktops.cpu);
			$("#updateDesktopInstockForm #ramEdit").val(desktops.ram);
			$("#updateDesktopInstockForm #hhdEdit").val(desktops.hhd);
			$("#updateDesktopInstockForm #displayEdit").val(desktops.display);
			$("#updateDesktopInstockForm #osEdit").val(desktops.os);
			$("#updateDesktopInstockForm #snEdit").val(desktops.sn);
			$("#updateDesktopInstockForm #assetEdit").val(desktops.asset);
			$("#updateDesktopInstockForm #bridEdit").val(desktops.brid);
			var now = new Date(desktops.datein);
			var day = ("0" + now.getDate()).slice(-2);
			var month = ("0" + (now.getMonth() + 1)).slice(-2);
			var datein = now.getFullYear()+"-"+(month)+"-"+(day) 
			$("#updateDesktopInstockForm #dateinEdit").val(datein);
		})
		$('#updateDesktopInstockModal').modal();
		
	})
	
	 * When user click on delete button in table
	 
	$('table .ButtonDeleteDesktopInstock').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmDesktopInstockButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteDesktopInstockModal').modal();
	})
	
	
	
	
	
	 * When user click on submit buuton on Update form 
	 
	$("#updateDesktopInstockForm").submit(function(event){
		event.preventDefault();
		desktop.submitDesktopInstockToUpdate();
	})
	
	
	
	 *  Functions 
	 
	//Insert Instock Function
	desktop.submitDesktopInstockToInsert=function(){
		var model=$('#addDesktopInstockForm #model').val();
		var cpu=$('#addDesktopInstockForm #cpu').val();
		var ram=$('#addDesktopInstockForm #ram').val();
		var hhd=$('#addDesktopInstockForm #hhd').val();
		var display=$('#addDesktopInstockForm #display').val();
		var os=$('#addDesktopInstockForm #os').val();
		var sn=$('#addDesktopInstockForm #sn').val();
		var asset=$('#addDesktopInstockForm #asset').val();
		var datein=$('#addDesktopInstockForm #datein').val();
		var brid=$('#addDesktopInstockForm #brid').val();
		var laptopdata={model,cpu,ram,hhd,display,os,sn,asset,datein,brid}
		//Using Swal Alert
		swal.fire({
			title:"Are your sure?",
			text:"You want to save this record?",
			type:'infor',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes'
		}).then((result)=>{
			if(result.value){
				$.ajax({
	                type: 'POST',
	                datatype:'json',
	                url: "/admin/desktop/instock/save",
	                data:{model:model,cpu:cpu,ram:ram,hhd:hhd,display:display,os:os,sn:sn,asset:asset,datein:datein,brid:brid},
	                success: function (data) {
	                	swal.fire({
							title:"saved",
							text:"Data have been saved!",
							type:"success"
						})
						//desktop.clearAddFormData();
						$("#addDesktopInstockModal").modal('hide');
	                },error : function(e) {
	                	swal.fire({
							title:"Error",
							text:"Data Error!",
							type:"warning"
						})
	    			}
	            }); 
			}else{
				swal.fire(
					"Cancel",
					"You have canceled",
					"infor"
				)
				///desktop.clearAddFormData();
				$("#addDesktopInstockModal").modal('hide');
			}
		})
		
		
		
	}
	//Update Instock Function
	desktop.submitDesktopInstockToUpdate=function(){
		var model=$('#updateDesktopInstockForm #modelEdit').val();
		var cpu=$('#updateDesktopInstockForm #cpuEdit').val();
		var ram=$('#updateDesktopInstockForm #ramEdit').val();
		var hhd=$('#updateDesktopInstockForm #hhdEdit').val();
		var display=$('#updateDesktopInstockForm #displayEdit').val();
		var os=$('#updateDesktopInstockForm #osEdit').val();
		var sn=$('#updateDesktopInstockForm #snEdit').val();
		var asset=$('#updateDesktopInstockForm #assetEdit').val();
		var datein=$('#updateDesktopInstockForm #dateinEdit').val();
		var brid=$('#updateDesktopInstockForm #bridEdit').val();
		var desid=$('#updateDesktopInstockForm #desidEdit').val();
		var laptopdata={desid:desid,model,cpu,ram,hhd,display,os,sn,asset,datein,brid}
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
					url:'/admin/desktop/instock/update',
					 data:{desid:desid,model:model,cpu:cpu,ram:ram,hhd:hhd,display:display,os:os,sn:sn,asset:asset,datein:datein,brid:brid},
					 success: function(data){
						 swal.fire({
								title:"update",
								text:"Data have been updated!",
								type:"success"
							})
						$('#updateDesktopInstockModal').modal('hide');
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
				$("#updateDesktopInstockModal").modal('hide');
			}
		})
		
	}
	
	
	/*------ Clear AddForm ------*/
	device.clearFormInsert=function(){
		 $('#addDesktopInstockForm #name').val('');
	     $('#addDesktopInstockForm #model').val('');
	     $('#addDesktopInstockForm #qty').val('');
	     $('#addDesktopInstockForm #asset').val('');
	     $('#addDesktopInstockForm #version').val('');
	     $('#addDesktopInstockForm #remark').val('');
	     $('#addDesktopInstockForm #cateid').val('');
	     $('#addDesktopInstockForm #location2').val('');
	     $('#addDesktopInstockForm #brid').val('');
	     $('#addDesktopInstockForm #status').val('');
	     $('#addDesktopInstockForm #datein').val('');
	     $('#addDesktopInstockForm #dateusing').val('');
	}
	/*----- Clear Update Form ----*/
	device.clearFormUpdate=function(){
		  $('#updateDesktopInstockForm #nameEdit').val('');
		  $('#updateDesktopInstockForm #devidEdit').val('');
	      $('#updateDesktopInstockForm #modelEdit').val('');
	      $('#updateDesktopInstockForm #qtyEdit').val('');
	      $('#updateDesktopInstockForm #assetEdit').val('');
	      $('#updateDesktopInstockForm #versionEdit').val('');
	      $('#updateDesktopInstockForm #remarkEdit').val('');
	      $('#updateDesktopInstockForm #cateidEdit').val('');
	      $('#updateDesktopInstockForm #location2Edit').val('');
	      $('#updateDesktopInstockForm #bridEdit').val('');
	      $('#updateDesktopInstockForm #statusEdit').val('');
	}
	
	
	
	//Datatable
	$(function(){
		$("#deviceTable").DataTable();
	})
})


