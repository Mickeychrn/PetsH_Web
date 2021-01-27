<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>PETS H</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
						<li class="has-submenu"><a href="/petsh/home/${profileMap.user.userId}">HOME</a></li>
						<li class="has-submenu"><a href="/petsh/adopt/${profileMap.user.userId}">ADOPT</a></li>
						<li class="has-submenu"><a href="/petsh/forum/${profileMap.user.userId}">FORUM</a></li>
						<li class="has-submenu"><a href="/petsh/profile/${profileMap.user.userId}">PROFILE</a></li>
						<c:set var="authority" value="${profileMap.user.authority}" />
						<c:if test="${authority == 1}">
							<li class="has-submenu"><a href="/petsh/admin/user">ADMIN</a></li>

						</c:if>
						<li class="has-submenu"><a href="/petsh/home">LOG OUT</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</header>


	<div class="wrapper">
		<div class="container-fluid">

			<!-- start page title -->
			<div class="row">
				<div class="col-12">
					<div class="page-title-box">
						<div class="page-title-right">
							<ol class="breadcrumb m-0">
								<li class="breadcrumb-item"><a href="/petsh/home/${profileMap.user.userId}">HOME
										></a></li>
								<li class="breadcrumb-item"><a href="/petsh/adopt/${profileMap.user.userId}">ADOPT
										></a></li>
								<li class="breadcrumb-item active"><a><c:out
											value="${profileMap.pet.petName}"></c:out> </a></li>
							</ol>
						</div>
						<h4 class="page-title">PETS</h4>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="card-box">
						<h4 class="header-title">
							The detail of
							<c:out value="${profileMap.pet.petName}" />
						</h4>
						<br>
						<div class="row">
							<div class="col-6">

								<a class="image-popup-no-margins"
									href="${profileMap.pet.petURL}"> <img class="img-fluid"
									alt="" src="${profileMap.pet.petURL}" width="500">
								</a>
							</div>
							<div class="col-6">
								<h5>ID</h5>
								<p>
									<c:out value="${profileMap.pet.petId}" />
								</p>
								<h5>Name</h5>
								<p>
									<c:out value="${profileMap.pet.petName}" />
								</p>
								<h5>Color</h5>
								<p>
									<c:out value="${profileMap.pet.petColor}" />
								</p>
								
								
								<h5>Category</h5>
								<p>
									<c:out value="${profileMap.pet.petCategory}" />
								</p>
								<h5>Gender</h5>
								<p>
									<c:out value="${profileMap.pet.petGender}" />
								</p>
								<br>
								<c:set var="isadopted" value="${profileMap.pet.isAdopted}" />
								<c:if test="${isadopted == false}">
									<p>
										<a
											href="/petsh/adopt/${profileMap.user.userId}/view/${profileMap.pet.petId}/adopt"
											class="btn btn-danger" role="button">Adopt</a>
									</p>
								</c:if>
							</div>
						</div>
						<div class="row">
							<h1>Description</h1>
						</div>

						<div class="row">
							<p><c:out value="${profileMap.pet.petDescription}" /></p>
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

