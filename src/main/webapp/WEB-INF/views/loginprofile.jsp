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
											<label>Profile Photo</label> <br> <input type="file"
												id="imgurl" accept="image/png,image/gif,image/jpeg"
												required="required" /><br>
											<br> <input type="button" value="POST"
												class="btn btn-info" required="required" />
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
										<ul class="nav nav-pills navtab-bg">
											<li class="nav-item"><a href="#information"
												data-toggle="tab" aria-expanded="false"
												class="nav-link active"> Information </a></li>
											<li class="nav-item"><a href="#mypost" data-toggle="tab"
												aria-expanded="true" class="nav-link "> My Post </a></li>

											<li class="nav-item"><a href="#mypet" data-toggle="tab"
												aria-expanded="false" class="nav-link"> My Pet </a></li>
										</ul>

										<div class="tab-content">



											<div class="tab-pane show active" id="information">

												<h5 class="mb-3 text-uppercase bg-light p-2">
													<i class="mdi mdi-account-circle mr-1"></i> Personal Info
												</h5>

												<form
													action="/petsh/profile/${profileMap.user.userId}/updateprofileinfo"
													method="post">

													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="firstname">First Name</label> <input
																	class="form-control"
																	value="${profileMap.user.firstName }" name="firstName"
																	required="required">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="lastname">Last Name</label> <input
																	class="form-control"
																	value="${profileMap.user.lastName }" name="lastName"
																	required="required">
															</div>
														</div>
														<!-- end col -->
													</div>
													<!-- end row -->

													<div class="row">
														<div class="col-12">
															<div class="form-group">
																<label for="userbio">Bio</label>
																<textarea class="form-control" rows="4" name="userbio">${profileMap.user.userBio }</textarea>
															</div>
														</div>
														<!-- end col -->
													</div>
													<!-- end row -->

													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="useremail">Email Address</label> <input
																	class="form-control" value="${profileMap.user.eMail }"
																	name="email" required="required">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="userpassword">Password</label> <input
																	type="password" class="form-control" name="password"
																	placeholder="Enter password"
																	value="${profileMap.user.password }"
																	required="required">
															</div>
														</div>



														<!-- end col -->
													</div>

													<div class="text-right">
														<button type="submit" class="btn btn-info">UPDATE</button>
													</div>
												</form>


												<!-- end row -->



												<div class="text-right"></div>

											</div>


											<div class="tab-pane" id="mypost">

												<!-- Story Box-->
												
												<form class="form-inline"
													action="/petsh/profile/${profileMap.user.userId}/mypostsearch"
													method="post">

													<div class="text-right">
														
																<input
																	class="form-control"
																	name="searchvalue"
																	placeholder="Title"
																	required="required">
																	<button type="submit" class="btn btn-info">SEARCH</button>
															
														
													</div>
												</form>
												<br>




												<c:forEach items="${profileMap.myforums }" var="singleForum">
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
																href="/petsh/profile/${profileMap.user.userId}/deletemypost/${singleForum.forumId}">Delete</a>
															/<a
																href="/petsh/profile/${profileMap.user.userId}/myPostdetail/${singleForum.forumId}">Update</a>
														</p>
													</div>

												</c:forEach>



											</div>

											<div class="tab-pane" id="mypet">

												<c:forEach items="${profileMap.mypets }" var="singlePet">

													<div class="border border-light p-2 mb-3">
														<div class="media">
															<a
																href="/petsh/adopt/${profileMap.user.userId}/view/${singlePet.petId}"><img
																class="mr-2 avatar-sm rounded-circle"
																src="${singlePet.petURL }"></a>
															<div class="media-body">
																<h5 class="m-0">
																	<a
																		href="/petsh/adopt/${profileMap.user.userId}/view/${singlePet.petId}">${singlePet.petName }</a>
																</h5>
																<p class="text-muted">
																	<small>${singlePet.petColor }</small>
																</p>


																<a
																	href="/petsh/profile/${profileMap.user.userId}/deletemypet/${singlePet.petId}">Delete</a>
															</div>
														</div>

													</div>
												</c:forEach>
											</div>


											<!-- end settings content-->

										</div>
										<!-- end tab-content -->
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
		var result;
		$('input[type=file]').on('change', function() {
			var reader = new FileReader();
			reader.onload = function(e) {
				result = reader.result;
			}
			reader.readAsDataURL(this.files[0])
		});
		$('input[type=button]').click(function() {
			var data = "content=" + result;

			$.ajax({
				type : "post",
				url : "updateprofile",
				data : {
					content : result,
				},
				success : function(msg) {
					window.location.href = '';
					alert("You have updated profile photo");
				},
				error : function(msg) {
					alert("Please choose file");
				}

			});
		});
	</script>

</body>
</html>

