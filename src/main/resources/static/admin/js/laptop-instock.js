/**
 * 
 */
var laptop={}
$(document).ready(function(){

	/*
	 * When user click on update button in table to get Single Data
	 */
	$('table #ButtonUpdateLaptopInstock').on('click',function(event){
		event.preventDefault();
		//Get Data From json with LaptopController
		var href=$(this).attr('href');
		$.get(href,function(laptopList,status){
			$("#updateLaptopInstockForm #lapidEdit").val(laptopList.lapid);
			$("#updateLaptopInstockForm #modelEdit").val(laptopList.model);
			$("#updateLaptopInstockForm #cpuEdit").val(laptopList.cpu);
			$("#updateLaptopInstockForm #ramEdit").val(laptopList.ram);
			$("#updateLaptopInstockForm #hhdEdit").val(laptopList.hhd);
			$("#updateLaptopInstockForm #displayEdit").val(laptopList.display);
			$("#updateLaptopInstockForm #osEdit").val(laptopList.os);
			$("#updateLaptopInstockForm #snEdit").val(laptopList.sn);
			$("#updateLaptopInstockForm #assetEdit").val(laptopList.asset);
			$("#updateLaptopInstockForm #bridEdit").val(laptopList.brid);
			var now = new Date(laptopList.datein);
			var day = ("0" + now.getDate()).slice(-2);
			var month = ("0" + (now.getMonth() + 1)).slice(-2);
			var datein = now.getFullYear()+"-"+(month)+"-"+(day) 
			$("#updateLaptopInstockForm #dateinEdit").val(datein);
		})
		$('#updateLaptopInstockModal').modal();
		
	})
	/*
	 * When user click on delete button in table
	 */
	$('table #ButtonDeleteLaptopInstock').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteConfirmLaptopInstockButton').attr('href',href);
		//Show Delete Modal Popup
		$('#deleteLaptopInstockModal').modal();
	})
	
	
	/*
	 * When user click on submit button on Form Add New Laptop Instock
	 */
	$("#addLaptopInstockForm").submit(function(event){
		event.preventDefault();
		laptop.submitLaptopInstockToInsert();
	});
	
	/*
	 * When user click on submit buuton on Update form 
	 */
	$("#updateLaptopInstockForm").submit(function(event){
		event.preventDefault();
		laptop.submitLaptopInstockToUpdate();
	})
	
	
	/*
	 *  Functions 
	 */
	//Insert Instock Function
	laptop.submitLaptopInstockToInsert=function(){
		var model=$('#addLaptopInstockForm #model').val();
		var cpu=$('#addLaptopInstockForm #cpu').val();
		var ram=$('#addLaptopInstockForm #ram').val();
		var hhd=$('#addLaptopInstockForm #hhd').val();
		var display=$('#addLaptopInstockForm #display').val();
		var os=$('#addLaptopInstockForm #os').val();
		var sn=$('#addLaptopInstockForm #sn').val();
		var asset=$('#addLaptopInstockForm #asset').val();
		var datein=$('#addLaptopInstockForm #datein').val();
		var brid=$('#addLaptopInstockForm #brid').val();
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
	                url: "/admin/laptop/instock/save",
	                data:{model:model,cpu:cpu,ram:ram,hhd:hhd,display:display,os:os,sn:sn,asset:asset,datein:datein,brid:brid},
	                success: function (data) {
	                	swal.fire({
							title:"saved",
							text:"Data have been saved!",
							type:"success"
						})
						laptop.clearAddFormData();
						$("#addLaptopInstockModal").modal('hide');
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
				laptop.clearAddFormData();
				$("#addLaptopInstockModal").modal('hide');
			}
		})
		
		
		
	}
	//Update Instock Function
	laptop.submitLaptopInstockToUpdate=function(){
		var model=$('#updateLaptopInstockForm #modelEdit').val();
		var cpu=$('#updateLaptopInstockForm #cpuEdit').val();
		var ram=$('#updateLaptopInstockForm #ramEdit').val();
		var hhd=$('#updateLaptopInstockForm #hhdEdit').val();
		var display=$('#updateLaptopInstockForm #displayEdit').val();
		var os=$('#updateLaptopInstockForm #osEdit').val();
		var sn=$('#updateLaptopInstockForm #snEdit').val();
		var asset=$('#updateLaptopInstockForm #assetEdit').val();
		var datein=$('#updateLaptopInstockForm #dateinEdit').val();
		var brid=$('#updateLaptopInstockForm #bridEdit').val();
		var lapid=$('#updateLaptopInstockForm #lapidEdit').val();
		var laptopdata={lapid:lapid,model,cpu,ram,hhd,display,os,sn,asset,datein,brid}
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
					url:'/admin/laptop/instock/update',
					 data:{lapid:lapid,model:model,cpu:cpu,ram:ram,hhd:hhd,display:display,os:os,sn:sn,asset:asset,datein:datein,brid:brid},
					 success: function(data){
						 swal.fire({
								title:"update",
								text:"Data have been updated!",
								type:"success"
							})
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
	
	
	
	/*
	 * Function Clear All data From Form
	 */
	laptop.clearAddFormData=function(){
		$('#addLaptopInstockForm #model').val('');
		$('#addLaptopInstockForm #cpu').val('');
		$('#addLaptopInstockForm #ram').val('');
		$('#addLaptopInstockForm #hhd').val('');
		$('#addLaptopInstockForm #display').val('');
		$('#addLaptopInstockForm #os').val('');
		$('#addLaptopInstockForm #sn').val('');
		$('#addLaptopInstockForm #asset').val('');
		$('#addLaptopInstockForm #datein').val('');
		$('#addLaptopInstockForm #brid').val('');
	}
	
	//Datatable
	$(function(){
		
		$("#laptopTableHQ").DataTable();
		$("#laptopTableSaenSokh").DataTable();
	})
})


