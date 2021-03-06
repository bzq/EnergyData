<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>EnergyData</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Le styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" />

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"
	type="text/javascript"></script>

<link
	href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->


</head>

<body>

	<jsp:include page="../header.jsp" />

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<jsp:include page="../menu.jsp" />
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">

				<div class="row-fluid">
					<div class="span12">
						<table class="table table-bordered table-striped table-condensed">
							<caption>
								<h4>Consommation totale de chaque équipement</h4>
							</caption>
							<thead>
								<tr>
									<th>Equipement</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listotalConsumptionAppliance}"
									var="appliance">
									<tr>
										<td><c:out value="${appliance.key.applianceName}" /></td>
										<td><c:out value="${appliance.value}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>


					</div>
				</div>
				<!--/row-->
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer>
		<p>&copy; EnergyData 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->


</body>
</html>
