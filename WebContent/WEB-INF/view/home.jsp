<!doctype html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
	padding-bottom: 60px;
}
</style>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<body>
	
	
	<c:set var = "resultWS" scope = "session" value = "${resultWebServiceLocation}"/>
	<c:if test="${resultWS != 'Failure exception'}">
		<div class="container" id="conteineHeader">
			<div class="navbar-header">
					<c:set var="customer" scope="session" value="${customerIDBean}" />
					<h2 style="font-weight: bold; color: blue"><span class="label label-primary">Sky</span></h2>
			</div>
		</div>
		<!-- MANAGE OFFER PRODUCTS -->
		<div class="container" id="conteinerOfferProducts">
			<h6 style="color: black">Welcome 
						: <b>${customer.customerID}</b> new offers for you!!!</h6>
						
			<table class="col-xs-1" id="basketTable">
					<thead>
						<tr>
							<th style="font-weight: bold"><span class="label label-warning">Basket</span></th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
					
				</table>
				<input id="confirmationButton" class="btn btn-info btn-sm" type="submit"
					disabled="disabled" value="Checkout">
	
			<!-- FILL DIFFERENT TABLE BASED ON category VALUE TABLE **SPORT** -->
			<table class="table" id="sport">
				<thead>
					<tr>
						<th class="info">Sport</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sportsProductList}" var="sportProduct">
						<tr>
							<td class="col-xs-3">
								<div class="checkbox" align="center">
									<label><input type="checkbox"
										value="${sportProduct.product}" id="${sportProduct.product}">${sportProduct.product}</label>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- FILL DIFFERENT TABLE BASED ON category VALUE TABLE **NEWS** -->
			<table class="table" id="News">
				<thead>
					<tr>
						<th class="info">News</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${newsProductList}" var="newProduct">
						<tr>
							<td class="col-xs-3">
								<div class="checkbox" align="center">
									<label><input type="checkbox"
										value="${newProduct.product}" id="${newProduct.product}">${newProduct.product}</label>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${resultWS == 'Failure exception'}">
		<div class="container" id="conteineHeader">
			<div class="navbar-header">
					<c:set var="customer" scope="session" value="${customerIDBean}" />
					<h2 style="font-weight: bold; color: blue"><span class="label label-primary">Sky</span></h2>
					<h6 style="color: black">Dear customer, something wrong trying to retrieve offer based on your location..</h6>
			</div>
		</div>
	</c:if>
	<!-- MANAGE CONFIRMATION PRODUCTS -->
	<div class="container" id="conteinerChoosenProducts" hidden="true">
		<div class="navbar-header">
			<h6 style="color: black">Congratulations  
					: <b>${customer.customerID}</b> now you have these offers more</h6>

			<table class="col-xs-4" id="resultTable">
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</body>

<script>
	/*BUTTONs MANAGEMENT */
	$("input:checkbox")
			.click(
					function() {
						var inputID = "basket_" + $(this).val();
						if ($(this).is(":checked")) {
							$('#basketTable tbody')
									.append(
											'<tr id="basket_'
													+ $(this).val()
													+ '"><td class="col-xs-3"><div align="center"><span class="label label-primary">'+$(this).val()+'</span></div></td></tr>');
							/*ACTIVATION BUTTON BASED ON BASKET CONTAINER  */
							$('#confirmationButton').attr("disabled",false);
						} else
							deleteRowDeSelected(inputID);

					});
	
	/*DELETE ROW UNCHECKING FROM BASKET TABLE  */
	function deleteRowDeSelected(inputID) {
		var numRows = 0;
		$('#basketTable').closest('table').find('tbody > tr').each(function() {
			numRows = numRows + 1;
			var idr = this.id;
			if (idr == inputID) {
				$(this).remove();
			}
		});
		if (numRows == 1) {
			/*DEACTIVATION BUTTON BASED ON BASKET CONTAINER  */
			$('#confirmationButton').attr("disabled",true);
		}
	};
	
	
	/*PASS PARAMETERS TO BACKEND FOR THE CONFIRMATION */
	$('#confirmationButton').click(function(event) {
		var productsInBasket = new Array();
		$('#basketTable').closest('table').find('tbody > tr').each(function() {
			var idr = this.id;
			productsInBasket.push(idr);
		});
		var postData = { values: productsInBasket};
		$.ajax({
			  type: "POST",
			  url: "confirmation.do",
			  data: postData,
			  dataType : "json",
			  async:false,
			  
			  success: function (data) {
				  $("#conteinerOfferProducts").hide("slow", function() {
					  $("#conteinerChoosenProducts").show();
				  });
				  for(var i = 0; i < data.length ; i++)
				  {
					  $('#resultTable tbody')
						.append(
								'<tr><td class="col-xs-3"><div align="center"><span class="label label-success">'+data[i]+'</span></div></td></tr>');
				  }
        	  }	
			});
	});
</script>
</html>