/**
 * 
 */

$(document).ready(function(){
	var desktop={}
	/*
	 * When user click on update button in table to get Single Data
	 */
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
	/*
	 * When user click on delete button in table
	 */
	$('table .ButtonDeleteDesktopInstock').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmDesktopInstockButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteDesktopInstockModal').modal();
	})
	
	
	/*
	 * When user click on submit button on Form Add New Laptop Instock
	 */
	$("#addDesktopInstockForm").submit(function(event){
		event.preventDefault();
		desktop.submitDesktopInstockToInsert();
	});
	
	/*
	 * When user click on submit buuton on Update form 
	 */
	$("#updateDesktopInstockForm").submit(function(event){
		event.preventDefault();
		desktop.submitDesktopInstockToUpdate();
	})
	
	
	/*
	 *  Functions 
	 */
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
	
	
	
	/*
	 * Function Clear All data From Form
	 */
	desktop.clearAddFormData=function(){
		$('#addDesktopInstockForm #model').val('');
		$('#addDesktopInstockForm #cpu').val('');
		$('#addDesktopInstockForm #ram').val('');
		$('#addDesktopInstockForm #hhd').val('');
		$('#addDesktopInstockForm #display').val('');
		$('#addDesktopInstockForm #os').val('');
		$('#addDesktopInstockForm #sn').val('');
		$('#addDesktopInstockForm #asset').val('');
		$('#addDesktopInstockForm #datein').val('');
		$('#addDesktopInstockForm #brid').val('');
	}
	
	//Datatable
	$(function(){
		
		$("#desktopTableSaenSokh").DataTable();
		$("#desktopTableHQ").DataTable();
	})
})


