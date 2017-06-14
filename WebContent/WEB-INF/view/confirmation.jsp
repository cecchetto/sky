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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<body>
	<div class="container">
		<div class="navbar-header">
			<h2 style="font-weight: bold; color: blue">Sky</h2>
			<h6 style="font-weight: bold; color: black">Congratulations!!!
				customerID : ${customerID} You added successfully this products
				more:</h6>

		</div>

		<!-- FILL DIFFERENT TABLE BASED ON category VALUE TABLE **SPORT** -->
		<%-- <table class="table">
			<thead>
				<tr>
					<th class="info">Products</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productsList}" var="product">
					<tr>
						<td class="col-xs-3">
							<div class="checkbox" align="center">
								<label><input type="text">${product}</label>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table> --%>
	</div>
</html>