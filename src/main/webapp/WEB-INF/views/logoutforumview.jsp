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
								<li class="breadcrumb-item"><a href="/petsh/forum">FORUM
										> </a></li>
								<li class="breadcrumb-item active">${forumModel.forum.forumTitle }</li>
							</ol>
						</div>
						<h4 class="page-title">FORUM</h4>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
				<div class="card-box">
					<div class="card-body">
						<h1 align="center">${forumModel.forum.forumTitle }</h1>
						<br> <br> <br>
						<c:out value="${forumModel.forum.forumContent }" />
						<br> <br> <br>

						<div align="center">
							<a href="/petsh/signin" class="btn btn-primary" role="button">Sign
								In to Comment</a>
						</div>
					</div>
				</div></div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="card-box">
						<c:forEach items="${forumModel.comments }" var="comment">
							<div class="border border-light p-2 mb-3">
								<div class="media">
									<img class="mr-2 avatar-sm rounded-circle"
										src="${comment.userURL} ">
									<div class="media-body">
										<h5 class="m-0">${comment.userName }</h5>
										<p class="text-muted">
											<small>${comment.commentDate }</small>
										</p>
									</div>
								</div>
								<p>${comment.content }</p>


							</div>
						</c:forEach>

					</div>
					<!-- end card-box-->
				</div>
				<!-- end col -->
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

