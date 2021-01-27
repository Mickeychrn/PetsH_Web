<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>PETS H</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- App favicon -->
<%@ include file="/WEB-INF/views/include.jsp"%>
<!-- App css -->
<link
	href="${pageContext.request.contextPath }/asset/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/asset/css/app.min.css"
	rel="stylesheet" type="text/css" />

</head>

<body class="authentication-bg authentication-bg-pattern">

	<div class="account-pages mt-5 mb-5">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8 col-lg-6 col-xl-5">
					<div class="card">
					
					<c:set var="signupinfo" value="${profileMap.signupinfo}" />
					
						<c:if test="${signupinfo == 'existemail'}">
							 <div class="p-3">
							<div class="toast fade show" role="alert" aria-live="assertive"
								aria-atomic="true" data-toggle="toast">
								<div class="toast-header">

									<button type="button" class="ml-2 mb-1 close"
										data-dismiss="toast" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="toast-body">This email already exist</div>
							</div>
						</div> 

						</c:if>

						




						<div class="card-body p-4">

							<div class="text-center w-75 m-auto">
								<p>Don't have an account? Create your free account now.</p>
							</div>

							<h5 class="auth-title">Create Account</h5>

							<form action="signup/add" method="post">

								<div class="form-group ">
									<label for="fullname">First Name</label> <input
										class="form-control" type="text" name="firstName"
										placeholder="Enter your first name" required>
								</div>
								<div class="form-group ">
									<label for="fullname">Last Name</label> <input
										class="form-control" type="text" name="lastName"
										placeholder="Enter your last name" required>
								</div>
								<div class="form-group">
									<label for="emailaddress">Email address</label> <input
										class="form-control" type="email" name="eMail" required
										placeholder="Enter your email">
								</div>
								<div class="form-group">
									<label for="password">Password</label> <input
										class="form-control" type="password" required name="password"
										placeholder="Enter your password">
								</div>

								<div class="form-group mb-0 text-center">
									<button class="btn btn-secondary btn-block" type="submit">
										Sign Up</button>
								</div>

							</form>



						</div>
						<!-- end card-body -->
					</div>
					<!-- end card -->

					<div class="row mt-3">
						<div class="col-12 text-center">
							<p class="text-muted">
								Already have account? <a href="/petsh/signin"
									class="text-muted ml-1"><b class="font-weight-semibold">Sign
										In</b></a>
							</p>
						</div>
						<!-- end col -->
					</div>
					<!-- end row -->

				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- end container -->
	</div>
	<!-- end page -->


	<footer class="footer footer-alt"> </footer>

	<!-- Vendor js -->
	<script
		src="${pageContext.request.contextPath }/asset/js/vendor.min.js"></script>

	<!-- App js -->
	<script src="${pageContext.request.contextPath }/asset/js/app.min.js"></script>

</body>
</html>