<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/include.jsp"%>
<meta charset="utf-8" />
<%@ include file="/WEB-INF/views/include.jsp"%>
<title>PETS H</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- third party css -->
<link
	href="${pageContext.request.contextPath}/assetadmin/libs/datatables/dataTables.bootstrap4.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assetadmin/libs/datatables/responsive.bootstrap4.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assetadmin/libs/datatables/buttons.bootstrap4.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assetadmin/libs/datatables/select.bootstrap4.css"
	rel="stylesheet" type="text/css" />
<!-- third party css end -->

<!-- App css -->
<link
	href="${pageContext.request.contextPath}/assetadmin/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assetadmin/css/icons.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assetadmin/css/app.min.css"
	rel="stylesheet" type="text/css" />

</head>

<body>

	<!-- Begin page -->
	<div id="wrapper">

		<!-- Topbar Start -->
		<div class="navbar-custom">
			<ul class="list-unstyled topnav-menu float-right mb-0">

			</ul>
			<div class="logo-box"></div>

			<ul class="list-unstyled topnav-menu topnav-menu-left m-0">
				<li>
					<button class="button-menu-mobile waves-effect">
						<span></span> <span></span> <span></span>
					</button>
				</li>
			</ul>
		</div>
		<!-- end Topbar -->

		<!-- ========== Left Sidebar Start ========== -->
		<div class="left-side-menu">

			<div class="slimscroll-menu">

				<!--- Sidemenu -->
				<div id="sidebar-menu">

					<ul class="metismenu" id="side-menu">

						<li class="menu-title">ADMIN BOARD</li>

						<li><a href="/petsh/admin/user"> <svg width="1em"
									height="1em" viewBox="0 0 16 16"
									class="bi bi-chevron-double-right" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
										d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
  <path fill-rule="evenodd"
										d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
</svg> <span> User Management </span>
						</a></li>
						<li><a href="/petsh/admin/pet"> <svg width="1em"
									height="1em" viewBox="0 0 16 16"
									class="bi bi-chevron-double-right" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
										d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
  <path fill-rule="evenodd"
										d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
</svg> <span> Pet Management </span>
						</a></li>
						<li><a href="/petsh/admin/post"> <svg width="1em"
									height="1em" viewBox="0 0 16 16"
									class="bi bi-chevron-double-right" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
										d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
  <path fill-rule="evenodd"
										d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
</svg> <span> Post Management </span>
						</a></li>
						<li><a href="/petsh/admin/comment"> <svg width="1em"
									height="1em" viewBox="0 0 16 16"
									class="bi bi-chevron-double-right" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
										d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
  <path fill-rule="evenodd"
										d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
</svg> <span> Comment Management </span>
						</a></li>

						<a href="/petsh/home">
							<li class="menu-title mt-2">LOG OUT</li>
						</a>

					</ul>

				</div>


				<div class="clearfix"></div>

			</div>


		</div>

		<div class="content-page">
			<div class="content">

				<!-- Start Content-->
				<div class="container-fluid">

					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">

								<h4 class="page-title">USER</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<div class="col-6">


										<form
											action="/petsh/admin/user/update/${profileMap.user.userId}/update"
											method="post">

											<div class="form-group ">
												<label for="fullname">ID</label> <input type="text"
													class="form-control" name="updateId" id="example-disable"
													disabled="" value="${profileMap.user.userId}">
											</div>

											<div class="form-group ">
												<label for="fullname">First Name</label> <input
													value="${profileMap.user.firstName}" class="form-control"
													type="text" name="firstName"
													placeholder="Enter your first name" required>
											</div>
											<div class="form-group ">
												<label for="fullname">Last Name</label> <input
													value="${profileMap.user.lastName}" class="form-control"
													type="text" name="lastName"
													placeholder="Enter your last name" required>
											</div>
											<div class="form-group">
												<label for="emailaddress">Email address</label> <input
													value="${profileMap.user.eMail}" class="form-control"
													type="email" name="eMail" required
													placeholder="Enter your email">
											</div>
											<div class="form-group">
												<label for="password">Bio</label>
												<textarea class="form-control" id="example-textarea"
													rows="5" name="userBio">${profileMap.user.userBio}</textarea>
											</div>
											
											
											
											<div class="form-group">
												<label for="password">Authority</label>
												<c:set var="authority" value="${profileMap.user.authority}" />
												<c:if test="${authority == 0}">
												<select class="form-control" id="example-select" name="authority">
                                                            <option value="0" selected="selected">User</option>
                                                            <option value="1">Administrator</option>
                                                </select>
												</c:if> 
												<c:if test="${authority == 1}">
												
												<select class="form-control" id="example-select" name="authority">
                                                            <option value="0" >User</option>
                                                            <option value="1" selected="selected">Administrator</option>
                                                </select>
												
												</c:if>
											</div>
											
											
											
											
											
											
											
											
											

											<div class="form-group mb-0 text-center">
												<button class="btn btn-primary " type="submit">
													UPGRADE</button>
												
											</div>

										</form>
									</div>


								</div>
								<!-- end card body-->
							</div>
							<!-- end card -->
						</div>
						<!-- end col-->
					</div>


				</div>
				<!-- container -->

			</div>
			<!-- content -->


		</div>

	</div>
	<script
		src="${pageContext.request.contextPath}/assetadmin/js/vendor.min.js"></script>

	<!-- third party js -->
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/dataTables.bootstrap4.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/responsive.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/dataTables.buttons.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/buttons.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/buttons.html5.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/buttons.flash.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/buttons.print.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/dataTables.keyTable.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/datatables/dataTables.select.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/pdfmake/pdfmake.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assetadmin/libs/pdfmake/vfs_fonts.js"></script>
	<!-- third party js ends -->

	<!-- Datatables init -->
	<script
		src="${pageContext.request.contextPath}/assetadmin/js/pages/datatables.init.js"></script>

	<!-- App js -->
	<script
		src="${pageContext.request.contextPath}/assetadmin/js/app.min.js"></script>

</body>
</html>