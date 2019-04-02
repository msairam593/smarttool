$(document).ready(function(){
	$('#comboboxcountry').on('change',function(){
	  var countryid = $('#comboboxcountry option:selected').val();
	  if(countryid=='-1'){
		  alert("please select country");
		  return;
	  }
	  $.ajax({
			type: 'GET',
			url: '/tool/platform/getalloperators',
			
			data:{countryid:countryid},
			success: function(result){
			var result = JSON.parse(result);
			if( result== ''){
				alert("Operators not mapped")
			}else{var s ='';
			s +='<option value="-1"> Select Operator </option>';
			 for(var i=0; i< result.length; i++){
			s += '<option value="'+result[i].id+'">'+result[i].name+'</option>';
			}
			$('#operatordropdown').html(s); }
			
			}
		});
	  });
	
	
	$('#operatordropdown').on('change',function(){
		  var operatorid = $('#operatordropdown option:selected').val();
		  if(operatorid=='-1'){
			  alert("please select Operator");
			  return;
		  }
		  $.ajax({
				type: 'GET',
				url: '/tool/platform/getallpartners',
				data:{operatorid:operatorid},
				success: function(result){
				var result = JSON.parse(result);
				if(result == ''){
					alert(" partners not mapped for this Operator");
				}else {
				var s ='';
				s +='<option value="-1"> Select Partner </option>';
				 for(var i=0; i< result.length; i++){
				s += '<option value="'+result[i].id+'">'+result[i].partnername+'</option>';
				}
				$('#partnerdropdown').html(s); 
				}}
			});
		  });	
	
	$('#partnerdropdown').on('change',function(){
		  var partnerid = $('#partnerdropdown option:selected').val();
		  if(partnerid=='-1'){
			  alert("please select Partner");
			  return;
		  }
		  $.ajax({
				type: 'GET',
				url: '/tool/platform/getallmodes',
				
				data:{partnerid:partnerid},
				success: function(result){
				var result = JSON.parse(result);
				if (result == '') {
					alert(" Mode Details not mapped for this partner ");
				} else {
					var s ='';
					s +='<option value="-1"> Select Mode </option>';
					 for(var i=0; i< result.length; i++){
					s += '<option value="'+result[i].id+'">'+result[i].name+'</option>';
					}
					$('#modedropdown').html(s); 
					}
				}
				
			});
		  });	
	$('#modedropdown').on('click',function(){
		  var modeid = $('#modedropdown option:selected').val();
		  if(modeid=='-1'){
			  alert("please select valid Mode");
			  return;
		  }
		  });	
	$("#checkusername").change(function(){
				  var username = $('#checkusername').val();
				  $.ajax({
						type: 'GET',
						url: '/tool/userstatus',
						
						data:{username:username},
						success: function(result){
							$('#check').html(result); 
						}
						
					});
				  });
});