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


<link
	href="${pageContext.request.contextPath }/asset/libs/custombox/custombox.min.css"
	rel="stylesheet">

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


	<div class="wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="page-title-box">
						<div class="page-title-right">
							<ol class="breadcrumb m-0">
								<li class="breadcrumb-item"><a
									href="/petsh/home/${profileMap.user.userId}">HOME ></a></li>
								<li class="breadcrumb-item active">FORUM</li>
							</ol>
						</div>
						<h4 class="page-title">FORUM</h4>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h1 align="center">WELCOME TO FORUM</h1>
							<br>
							<div class="row">
								<div class="col-lg-8">
									<form class="form-inline"
										action="/petsh/forum/${profileMap.user.userId}/searchbytitle"
										method="post">
										<div class="form-group">
											<label for="inputPassword2" class="sr-only">Search</label> <input
												type="search" class="form-control" placeholder="title"
												name="searchtitle">
											<button class="btn btn-primary waves-effect waves-light"
												type="submit">Search</button>
										</div>
									</form>
								</div>
								<div class="col-lg-2"></div>
								<div class="col-lg-2">
									<a href="#custom-modal"
										class="btn btn-info waves-effect waves-light"
										data-animation="fadein" data-plugin="custommodal"
										data-overlayColor="#38414a"> Add New</a>
								</div>
							</div>
							<br>

							<c:forEach items="${profileMap.forums }" var="singleForum">
								<div class="border border-light p-2 mb-3">
									<div class="media">
										<div class="media-body">
											<h5 class="m-0">
												<a
													href="/petsh/forum/${profileMap.user.userId}/view/${singleForum.forumId}">${singleForum.forumTitle }</a>
											</h5>
											<p class="text-muted">
												<small>${singleForum.createTime }</small>
											</p>

										</div>
									</div>
									<p>${singleForum.forumContent }</p>
									<p class="text-muted">
										<a
											href="/petsh/forum/${profileMap.user.userId}/view/${singleForum.forumId}">More</a>
									</p>
								</div>
							</c:forEach>

						</div>
						<!-- end card-body -->
					</div>
					<!-- end card-->
				</div>
				<!-- end col -->

				<!-- Modal -->
				<div id="custom-modal" class="modal-demo">
					<button type="button" class="close"
						onclick="Custombox.modal.close();">
						<span>&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="custom-modal-title">Add Forum</h4>

					<div class="custom-modal-text text-left">
						<form action="${profileMap.user.userId}/addforum" method="post">
							<div class="form-group">
								<label>Forum Title</label> <input name="forumTitle"
									class="form-control" required="required">
							</div>
							<div class="form-group">
								<label>Forum Content</label>
								<textarea class="form-control" name="forumContent" rows="3"
									required="required"></textarea>
							</div>
							<button type="submit" class="btn btn-primary">POST</button>
						</form>
					</div>
				</div>
			</div>
		</div>



		<!-- end container -->
	</div>

	<footer class="footer">
		<div class="container-fluid"></div>
	</footer>



	<script
		src="${pageContext.request.contextPath }/asset/libs/custombox/custombox.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/asset/js/vendor.min.js"></script>
	<script src="${pageContext.request.contextPath }/asset/js/app.min.js"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
</body>
</html>

