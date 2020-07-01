var IP={}
$(document).ready(function(){
	
	/*---------All Events are here ----------*/
	
	/*--------When User click on button update in table -----------*/
	$('.updateIPTwentySecondButton').on('click',function(event){
	    event.preventDefault();
	    var href=$(this).attr('href');
	    $.get(href,function(IP,status){
	    	/*--- pass value from JSON to UpdateIPForm in UpdateModal ----*/
	    	$('#updateIPForm #id').val(IP.id);
	    	$('#updateIPForm #macaddress').val(IP.macaddress);
	    	$('#updateIPForm #username').val(IP.username);
	    	$('#updateIPForm #sn').val(IP.sn);
	    	$('#updateIPForm #location').val(IP.location);
	    	$('#updateIPForm #pcname').val(IP.pcname);
	    	$('#updateIPForm #antivirus').val(IP.antivirus);
	    	$('#updateIPForm #remark').val(IP.ramark);
	    	$('#updateIPForm #extension').val(IP.extension);
	    	
	    	$('#updateIPModal').modal();
	    })
	})
	
	/*---------- When user Click on Submit Button On updateForm ---------*/
	$('#updateIPForm').submit(function(event){
		event.preventDefault();
		IP.submitUpdateIP();
		
	})
	/*--------- When User Click on delete Button in Table --------*/
	$('table .deleteIPTwentySecondButton').on('click',function(event){
		event.preventDefault();
		/*-- Get action from href attribute from table --*/
		var href=$(this).attr('href');
		/*-- Pass href from table to Modal --*/
		$('#deleteConfirmIPButton').attr('href',href);
		$('#deleteDeviceModal').modal();
	})
	/*---------- End All Event -------------*/
	/*=====================================*/
	
	
	/*--------- All Functions are here ---------*/
	/*--------- Submit Update Function --------*/
	IP.submitUpdateIP=function(){
		var id=$('#updateIPForm #id').val();
    	var macaddress=$('#updateIPForm #macaddress').val();
    	var username=$('#updateIPForm #username').val();
    	var sn=$('#updateIPForm #sn').val();
    	var location=$('#updateIPForm #location').val();
    	var pcname=$('#updateIPForm #pcname').val();
    	var antivirus=$('#updateIPForm #antivirus').val();
    	var ramark=$('#updateIPForm #remark').val();
    	var extension=$('#updateIPForm #extension').val();
    	var data={id,macaddress,username,sn,location,pcname,antivirus,ramark,extension}
    	//console.log(data);
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
 	                type: 'POST',
 	                datatype:'json',
 	                url: "/admin/IP-Seven/update",
 	                data:{id:id,macaddress:macaddress,username:username,sn:sn,location:location,pcname:pcname,antivirus:antivirus,ramark:ramark,extension:extension},
 	                success: function (data) {
 	                	swal.fire({
 							title:"update",
 							text:"Data have been update!",
 							type:"success"
 						})
 						
 						$("#updateIPModal").modal('hide');
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
 				
 				$("#updateIPModal").modal('hide');
 			}
 		})
	}
	
	
});
