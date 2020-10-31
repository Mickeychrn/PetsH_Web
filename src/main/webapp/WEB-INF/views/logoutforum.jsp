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
			<div class="row">
				<div class="col-12">
					<div class="page-title-box">
						<div class="page-title-right">
							<ol class="breadcrumb m-0">
								<li class="breadcrumb-item"><a href="/petsh/home">HOME
										></a></li>
								<li class="breadcrumb-item active"><a href="/petsh/forum">FORUM
								</a></li>
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
							<div class="row">
								
	                            <div class="col-lg-8">
									<form class="form-inline" action="/petsh/forum/searchbytitle" method="post">
	                                        <div class="form-group" >
	                                            <label for="inputPassword2" class="sr-only">Search</label>
	                                            <input type="search" class="form-control" placeholder="title" name="title">
	                                        	<button class="btn btn-primary waves-effect waves-light" type="submit">Search</button>
	                                        </div>
	                                </form>
	                             </div>
                             </div>
							<br>

							<%-- <table class="table table-borderless table-centered mb-0">
								<thead>
									<tr>
										<th scope="col">Title</th>
										<th scope="col">Time</th>
										<th scope="col">Author</th>
										<th scope="col">Operation</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${uiModel.forumList }" var="singleForum">
										<tr>

											<td><c:out value="${singleForum.forumTitle }" /></td>
											<td><c:out value="${singleForum.createTime }" /></td>
											<td><c:out value="${singleForum.userName }" /></td>
											<td><a class="btn btn-primary waves-effect waves-light" href="/petsh/forum/view/${singleForum.forumId}">More</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table> --%>
							
							
							<br>

							<c:forEach items="${uiModel.forumList }" var="singleForum">
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

			</div>
		</div>



		<!-- end container -->
	</div>

	<footer class="footer">
		<div class="container-fluid"></div>
	</footer>



	<script src="${pageContext.request.contextPath }/asset/js/vendor.min.js"></script>
	<script src="${pageContext.request.contextPath }/asset/js/app.min.js"></script>


</body>
</html>

