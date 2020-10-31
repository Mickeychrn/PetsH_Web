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
						<li class="has-submenu"><a href="/petsh/home">HOME</a></li>
						<li class="has-submenu"><a href="/petsh/adopt">ADOPT</a></li>
						<li class="has-submenu"><a href="/petsh/forum">FORUM</a></li>
						<li class="has-submenu"><a href="#">ACCOUNT</a>
							<ul class="submenu megamenu">
								<li>
									<ul>
										<li><a href="/petsh/signin">SIGN IN</a></li>
										<li><a href="/petsh/signup">SIGN UP</a></li>
									</ul>
								</li>
							</ul></li>
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
								<li class="breadcrumb-item"><a href="/petsh/home">HOME
										></a></li>
								<li class="breadcrumb-item"><a href="/petsh/adopt">ADOPT
										></a></li>
								<li class="breadcrumb-item active"><a><c:out
											value="${uiModel.petList.petName}"></c:out> </a></li>
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
							<c:out value="${uiModel.petList.petName}" />
						</h4>
						<br>
						<div class="row">
							<div class="col-6">

								<a class="image-popup-no-margins"
									href="${uiModel.petList.petURL}"> <img class="img-fluid"
									alt="" src="${uiModel.petList.petURL}" width="500">
								</a>
							</div>
							<div class="col-6">
								<h5>ID</h5>
								<p>
									<c:out value="${uiModel.petList.petId}" />
								</p>
								<h5>Name</h5>
								<p>
									<c:out value="${uiModel.petList.petName}" />
								</p>
								<h5>Color</h5>
								<p>
									<c:out value="${uiModel.petList.petColor}" />
								</p>
								
								<h5>Category</h5>
								<p>
									<c:out value="${uiModel.petList.petCategory}" />
								</p>
								
								<h5>Gender</h5>
								<p>
									<c:out value="${uiModel.petList.petGender}" />
								</p>
								
								
								
								
								<br>
								<p>
									<a href="/petsh/signin" class="btn btn-primary" role="button">Sign
										In to Adopt</a>
								</p>
							</div>
						</div>
						<div class="row">
							<h1>Description</h1>
						</div>

						<div class="row">
							<p><c:out value="${uiModel.petList.petDescription}" /></p>
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

