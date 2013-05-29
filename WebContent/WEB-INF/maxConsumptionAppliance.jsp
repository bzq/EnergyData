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

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Project name</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">
						Logged in as <a href="#" class="navbar-link">Username</a>
					</p>
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Sidebar</li>
						<li><a href="index">Accueil</a></li>
						<li><a href="getMeasures">Toutes les mesures</a></li>
						<li><a href="dateMeasure">Fenetre
								glissante</a></li>
						<li><a href="totalConsumptionHousehold">Total par maison</a></li>
						<li><a href="totalConsumptionAppliance">Total par
								équipement</a></li>
						<li><a href="maxConsumptionHousehold">Maison énergivore</a></li>
						<li class="active"><a href="maxConsumptionAppliance">Equipement
								énergivore</a></li>
						<li><a href="minConsumptionHousehold">Maison économe</a></li>
						<li><a href="minConsumptionAppliance">Equipement économe</a></li>
						<li><a href="#">Link</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">

				<div class="row-fluid">
					<div class="span12">
						<table class="table table-bordered table-striped table-condensed">
							<caption>
								<h4>Equipement énergivore</h4>
							</caption>
							<thead>
								<tr>
									<th>Equipement</th>
									<th>Consommation</th>
									<th>Nombre d'équipement éléctrique</th>
									<th>Date début</th>
									<th>Date fin</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="${appliance[0]}" /></td>
									<td><c:out value="${appliance[1]}" /></td>
									<td><c:out value="${appliance[2]}" /></td>
									<td><c:out value="${appliance[3]}" /></td>
									<td><c:out value="${appliance[4]}" /></td>
								</tr>

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
