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
			<div class="row">
				<div class="col-12">
					<div class="page-title-box">
						<div class="page-title-right">
							<ol class="breadcrumb m-0">
								<li class="breadcrumb-item"><a href="/petsh/home/${profileMap.user.userId}">HOME
										></a></li>
								<li class="breadcrumb-item"><a href="/petsh/forum/${profileMap.user.userId}">FORUM
										> </a></li>
								<li class="breadcrumb-item active">${profileMap.forum.forumTitle }</li>
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
						<h1 align="center">${profileMap.forum.forumTitle }</h1>
						<br> <br> <br>
						<c:out value="${profileMap.forum.forumContent }" />
						<br> <br> <br>

						<form
							action="/petsh/forum/${profileMap.user.userId}/view/${profileMap.forum.forumId }/addComment"
							method="post">

							<div class="form-group">
								<label>Comment:</label>
								<textarea class="form-control" name="CommentContent" rows="3" required="required"></textarea>
							</div>


							<input type="submit" value="Comment" class="btn btn-info" />
						</form>
					</div>
				</div></div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="card-box">
						<c:forEach items="${profileMap.comments }" var="comment">
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

 