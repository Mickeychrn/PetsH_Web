<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/include.jsp"%>
<meta charset="utf-8" />
<title>PETS H</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="${pageContext.request.contextPath }/asset/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/app.min.css"
	rel="stylesheet" type="text/css" />

</head>

<body>
	<header id="topnav">
		<div class="navbar-custom">
			<div class="container-fluid">
				<div align="center">

					<h1>PETS H</h1>

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="topbar-menu">
			<div class="container-fluid">
				<div id="navigation">
					<!-- Navigation Menu-->
					<ul class="navigation-menu">
						<li class="has-submenu"><a
							href="/petsh/home/${profileMap.user.userId}">HOME</a></li>
						<li class="has-submenu"><a
							href="/petsh/adopt/${profileMap.user.userId}">ADOPT</a></li>
						<li class="has-submenu"><a
							href="/petsh/forum/${profileMap.user.userId}">FORUM</a></li>
						<li class="has-submenu"><a href="/petsh/profile/${profileMap.user.userId}">PROFILE</a></li>



						<c:set var="authority" value="${profileMap.user.authority}" />
						<c:if test="${authority == 0}">
							<li class="has-submenu"><a href="/petsh/admin/user">ADMIN</a></li>

						</c:if>
						
						<li class="has-submenu"><a href="/petsh/home">LOG OUT</a></li>
						

					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</header>
	<br>
	<br>



	<div class="wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div id="carouselExampleCaptions" class="carousel slide"
								data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carouselExampleCaptions" data-slide-to="0"
										class="active"></li>
									<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
									<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
								</ol>
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img
											src="${pageContext.request.contextPath }/asset/images/1.jpg"
											class="d-block w-100" alt="...">
										<div class="carousel-caption d-none d-md-block">

											<p>Nulla vitae elit libero, a pharetra augue mollis
												interdum.</p>
										</div>
									</div>
									<div class="carousel-item">
										<img
											src="${pageContext.request.contextPath }/asset/images/2.jpg"
											class="d-block w-100" alt="...">
										<div class="carousel-caption d-none d-md-block">

											<p>Lorem ipsum dolor sit amet, consectetur adipiscing
												elit.</p>
										</div>
									</div>
									<div class="carousel-item">
										<img
											src="${pageContext.request.contextPath }/asset/images/4.jpg"
											class="d-block w-100" alt="...">
										<div class="carousel-caption d-none d-md-block">

											<p>Praesent commodo cursus magna, vel scelerisque nisl
												consectetur.</p>
										</div>
									</div>
								</div>
								<a class="carousel-control-prev" href="#carouselExampleCaptions"
									role="button" data-slide="prev"> <span
									class="carousel-control-prev-icon" aria-hidden="true"></span> <span
									class="sr-only">Previous</span>
								</a> <a class="carousel-control-next"
									href="#carouselExampleCaptions" role="button" data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer">
		<div class="container-fluid"></div>
	</footer>



	<script
		src="${pageContext.request.contextPath }/asset/js/vendor.min.js"></script>
	<script src="${pageContext.request.contextPath }/asset/js/app.min.js"></script>


</body>
</html>

