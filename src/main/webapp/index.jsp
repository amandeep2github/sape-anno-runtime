<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Jquery Table</title>
	<link rel="stylesheet" href="./static/bootstrap.min.css">
	<script src="./static/jquery.js"></script>
	<script>
     $(function() {
        
        $('#btn').click(function(){
        	console.log($('#domainClass').val());
          $.ajax({
            //url : "http://localhost:8080/anno-runtime/listDomain.json?domainClassName=com.sapient.tdi.anno.domain.Employee", 
            url : "http://localhost:8080/anno-runtime/listDomain.json?domainClassName="+$('#domainClass').val(),		
            contentType : "json",
            success : function(res){
              var response = res.data;
              console.log(response);
              $('thead').html('');
              $('tbody').html('');
              $('h1').html(res.DataGridName);
              var tr = '<tr>';
              for (var j = 0; j < Object.keys(response[0]).length; j++) {
                  if(res.key && Object.keys(response[0])[j] === res.key.column){
                       var th = '<th style="color:red">';
                       th+= Object.keys(response[0])[j] + '</th>';
                       tr+=th;
                  }else{
                       var th = '<th>';
                       th+= Object.keys(response[0])[j] + '</th>';
                       tr+=th;
                  }
              };
              tr+= '</tr>'; 
               $('thead').append(tr);
              for (var i = 0; i < response.length; i++) {
                var tr = '<tr>';
                for (var j = 0; j < Object.keys(response[i]).length; j++) {
                   var td = '<td>';
                   td+= response[i][Object.keys(response[i])[j]] + '</td>';
                   tr+=td;
                };
                tr+='</tr>';
                 $('tbody').append(tr);
              };
            },
            error : function(){
              alert("error");
            }
          });
        });
     })
	</script>
</head>
<body>
	<div class="container">
		<p></p>
		<br><br><br><br><br><br><br>
		Domain Class : <select id="domainClass">
		 <option value="com.sapient.tdi.anno.domain.Employee">com.sapient.tdi.anno.domain.Employee</option>
		 <option value="com.sapient.tdi.anno.domain.Account">com.sapient.tdi.anno.domain.Account</option>
		</select>
		<button id="btn">Get Data</button>
		<h1>{Data}</h1>
		<hr>
		<table id="table" class='table table-bordered table-striped'>
			<thead>
				
			</thead>
			<tbody>
				
			</tbody>
		</table>	
	</div>
</body>
</html>