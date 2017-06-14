<!doctype html>
<html>

<head>
<% 
  response.sendRedirect("preLoading.do");
%>	
</head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<body>
	<div class="container"> 
		<div class="navbar-header">
				<h6 style="font-weight: bold;color: blue">Sky</h6>
		</div>       
	  <table class="table">
	    <thead>
	      <tr>
	        <th class="success">Sport</th>
	        <th class="danger"> News</th>
	        <th class="warning">Basket</th>
	      </tr>
	    </thead>
	    <tbody>
	    <tr>
	        <td class="col-xs-3">
	        	<div class="checkbox" align="center">
  					<label><input type="checkbox" value="Arsenal TV" id="ArsenalTV">Arsenal TV</label>
				</div>
				<div class="checkbox" align="center">
  					<label><input type="checkbox" value="Chelsea TV" id="ChelseaTV">Chelsea TV</label>
				</div>
				<div class="checkbox" align="center">
  					<label><input type="checkbox" value="Liverpool TV" id="LiverpoolTV">Liverpool TV</label>
				</div>
			</td>
	        <td class="col-xs-3 col-centered">
	        	<div class="checkbox" align="center">
  					<label><input type="checkbox" value="Sky News" id="SkyNews">Sky News</label>
				</div>
				<div class="checkbox" align="center">
  					<label><input type="checkbox" value="Sky Sports" id="SkySports">Sky Sports</label>
				</div>
			</td>
       		<td class="col-xs-3 col-centered">
       			<div id="basket" align="center">
				</div>
       		</td>
      	</tr>

	    </tbody>
	  </table>    
    </div>
</body>

<script>
	/*BUTTONA MANAGEMENT  */
	$("#ArsenalTV").change(function(event) {
		if($(this).is(':checked'))
			$('#basket').append('<input id="basket_ArsenalTV" value="-'+event.target.value+'"/>');
		else
			$('#basket_ArsenalTV').remove();
	});
	
	$("#ChelseaTV").change(function(event) {
		if($(this).is(':checked'))
			$('#basket').append('<input id="basket_ChelseaTV" value="-'+event.target.value+'"/>');
		else
			$('#basket_ChelseaTV').remove();
	});
	
	$("#LiverpoolTV").change(function(event) {
		if($(this).is(':checked'))
			$('#basket').append('<input id="basket_LiverpoolTV" value="-'+event.target.value+'"/>');
		else
			$('#basket_LiverpoolTV').remove();
	});
	
	$("#SkyNews").change(function(event) {
		if($(this).is(':checked'))
			$('#basket').append('<input id="basket_SkyNews" value="-'+event.target.value+'"/>');
		else
			$('#basket_SkyNews').remove();
	});
	
	$("#SkySports").change(function(event) {
		if($(this).is(':checked'))
			$('#basket').append('<input id="basket_SkySports" value="-'+event.target.value+'"/>');
		else
			$('#basket_SkySports').remove();
	});
</script>
</html>

