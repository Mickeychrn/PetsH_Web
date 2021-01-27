<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/include.jsp"%>
<meta charset="utf-8" />
<title>PETS H</title>
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
						<li class="has-submenu"><a
							href="/petsh/home/${profileMap.user.userId}">HOME</a></li>
						<li class="has-submenu"><a
							href="/petsh/adopt/${profileMap.user.userId}">ADOPT</a></li>
						<li class="has-submenu"><a
							href="/petsh/forum/${profileMap.user.userId}">FORUM</a></li>
						<li class="has-submenu"><a 
							href="/petsh/profile/${profileMap.user.userId}">PROFILE</a></li>


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
	<br>
	<br>



	<div class="wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">

							<div class="row">
								<div class="col-lg-4 col-xl-4">
									<div class="card-box text-center">
										<img src="${profileMap.user.userPhoto}"
											class="rounded-circle avatar-lg img-thumbnail"
											alt="profile-image">
										<div class="text-left mt-3">
											<label>Profile Photo</label> <br>
										</div>



										<h4 class="mb-0">${profileMap.user.firstName}
											${profileMap.user.lastName}</h4>



										<div class="text-left mt-3">



											<h4 class="font-13 text-uppercase">About Me :</h4>
											<p class="text-muted font-13 mb-3">${profileMap.user.userBio}</p>
											<p class="text-muted mb-2 font-13">
												<strong>First Name :</strong> <span class="ml-2">
													${profileMap.user.firstName}</span>
											</p>

											<p class="text-muted mb-2 font-13">
												<strong>Last Name :</strong><span class="ml-2">
													${profileMap.user.lastName}</span>
											</p>

											<p class="text-muted mb-2 font-13">
												<strong>Email :</strong> <span class="ml-2 ">${profileMap.user.eMail}</span>
											</p>

											<p class="text-muted mb-1 font-13">
												<strong>Authority :</strong> <span class="ml-2"> <c:set
														var="authority" value="${profileMap.user.authority}" /> <c:if
														test="${authority == 0}">USER</c:if> <c:if
														test="${authority == 1}">ADMINISTRATOR</c:if>
												</span>
											</p>
										</div>

									</div>

								</div>
								<!-- end col-->

								<div class="col-lg-8 col-xl-8">
									<div class="card-box">

										<form
											action="/petsh/profile/${profileMap.user.userId}/myPostUpdate/${profileMap.myforums.forumId }"
											method="post">

											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label for="firstname">Forum Title</label> <input
															class="form-control"
															value="${profileMap.myforums.forumTitle }"
															name="forumTitle" required="required">
													</div>
												</div>

												<!-- end col -->
											</div>
											<!-- end row -->

											<div class="row">
												<div class="col-12">
													<div class="form-group">
														<label for="userbio">Forum Content</label>
														<textarea class="form-control" rows="4"
															name="forumContent">${profileMap.myforums.forumContent }</textarea>
													</div>
												</div>
												<!-- end col -->
											</div>
											<!-- end row -->



											<div class="text-right">
												<a href="/petsh/profile/${profileMap.user.userId}"><input type="button" class="btn btn-info" value="Back" /></a>
												<button type="submit" class="btn btn-info">UPDATE</button>
											</div>
										</form>

									</div>

									<!-- end card-box-->

								</div>
								<!-- end col -->
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
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script>
		
	</script>

</body>
</html>

