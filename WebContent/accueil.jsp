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

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link
	href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<jsp:include page="menu.jsp" />
			</div>
			<!--/span-->
			<div class="span9">
				<div class="hero-unit">
					<h1>Bonjour à tous!</h1>
					<p>Bienvenue sur le site qui recense la consommation éléctrique
						de chacun des équipements des maisons ayant participer au projet
						Irise.</p>
					<p>
						<a href="#" class="btn btn-primary btn-large">Learn more
							&raquo;</a>
					</p>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<h2>Maison la plus consommatrice</h2>

						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Maison</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${householdMax}" var="household">
									<tr>
										<td><c:out value="${household.key}" /></td>
										<td><c:out value="${household.value}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>


						<!-- 						</p> -->
						<p>
							<a class="btn" href="maxConsumptionHousehold">View details
								&raquo;</a>
						</p>
					</div>
					<!--/span-->
					<div class="span4">
						<h2>Equipement qui consomme le plus</h2>
						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Equipement</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${appliancedMax}" var="appliance">
									<tr>
										<td><c:out value="${appliance.key}" /></td>
										<td><c:out value="${appliance.value}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<p>
							<a class="btn" href="maxConsumptionAppliance">View details
								&raquo;</a>
						</p>
					</div>
					<!--/span-->
					<div class="span4">
						<h2>Jour de consommation le plus important</h2>
						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Date</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
<%-- 								<c:forEach items="${dateMax}" var="date"> --%>
									<tr>
										<td><c:out value="${dateMax.key}" /></td>
										<td><c:out value="${dateMax.value}" /></td>
									</tr>
<%-- 								</c:forEach> --%>

							</tbody>
						</table>
						<p>
							<a class="btn" href="maxConsumptionDate">View details &raquo;</a>
						</p>
					</div>
					<!--/span-->
				</div>
				<!--/row-->
				<div class="row-fluid">
					<div class="span4">
						<h2>Maison la plus économe</h2>
						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Maison</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${householdMin}" var="householdM">
									<tr>
										<td><c:out value="${householdM.key}" /></td>
										<td><c:out value="${householdM.value}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<p>
							<a class="btn" href="minConsumptionHousehold">View details
								&raquo;</a>
						</p>
					</div>
					<!--/span-->
					<div class="span4">
						<h2>Equipement le plus économe</h2>
						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Equipement</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${applianceMin}" var="appliance">
									<tr>
										<td><c:out value="${appliance.key.applianceName}" /></td>
										<td><c:out value="${appliance.value}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<p>
							<a class="btn" href="minConsumptionAppliance">View details
								&raquo;</a>
						</p>
					</div>
					<!--/span-->
					<div class="span4">
						<h2>Jour de consommation de la plus faible consommation</h2>
						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th>Date</th>
									<th>Consommation</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dateMin}" var="date">
									<tr>
										<td><c:out value="${date.key}" /></td>
										<td><c:out value="${date.value}" /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<p>
							<a class="btn" href="minConsumptionDate">View details &raquo;</a>
						</p>
					</div>
					<!--/span-->
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

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-transition.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-alert.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-modal.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-dropdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-scrollspy.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-tab.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-tooltip.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-popover.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-button.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-collapse.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-carousel.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap-typeahead.js"></script>

</body>
</html>
