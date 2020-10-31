<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>

<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Blog Template">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">
<link rel="shortcut icon" href="favicon.ico">

<!-- FontAwesome JS-->
<script defer
	src="https://use.fontawesome.com/releases/v5.7.1/js/all.js"></script>

<!-- Theme CSS -->
<link id="theme-style" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets1/css/theme-1.css">

</head>

<body>

	<header class="header text-center">
		<h1 class="blog-name pt-lg-4 mb-0">
			<a href="/pets/signin/${profileMap.user.userId}">${profileMap.user.firstName}
				${profileMap.user.lastName}</a>
		</h1>

		<nav class="navbar navbar-expand-lg navbar-dark">

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navigation" aria-controls="navigation"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div id="navigation" class="collapse navbar-collapse flex-column">
				<div class="profile-section pt-3 pt-lg-0">
					<img class="profile-image mb-3 rounded-circle mx-auto"
						src="${profileMap.user.userPhoto}" alt="image">

					<div class="bio mb-3">
						Hi, my name is Anthony Doe. Briefly introduce yourself here. You
						can also provide a link to the about page.<br>
					</div>
					<!--//bio-->
					<hr>
				</div>
				<!--//profile-section-->

				<ul class="navbar-nav flex-column text-left">
					<li class="nav-item active"><a class="nav-link"
						href="/petsh/myprofile/${profileMap.user.userId}">My Profile <span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item "><a class="nav-link"
						href="/petsh/mypet/${profileMap.user.userId}">My Pet</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/petsh/mypost/${profileMap.user.userId}">My Post</a></li>
				</ul>

				<div class="my-2 my-md-3">
					<a class="btn btn-primary"
						href="/petsh/home/${profileMap.user.userId}">HOME</a>
				</div>
			</div>
		</nav>
	</header>
	<!--//main-wrapper-->
	<div class="main-wrapper">
		<section class="cta-section theme-bg-light py-5">
			<div class="container text-center"></div>
			<!--//container-->
		</section>


		<section class="blog-list px-3 py-5 p-md-5">

			<div class="form-group">
				<label>Last Name:</label> 
				<input class="form-control" value="${profileMap.user.lastName }" name="lastName">
			</div>
			<div class="form-group">
				<label>First Name:</label> 
				<input class="form-control" value="${profileMap.user.firstName }" name="firstName">
			</div>

			<div class="form-group">
				<label>E-Mail</label> 
				<input class="form-control" value="${profileMap.user.eMail }" name="email">
			</div>
			<div class="form-group">
				<label>Profile Photo</label> <br> 
				<input type="file" id="imgurl" accept="image/png,image/gif,image/jpeg" />
			</div>
			<br> <input type="button" value="Update" />





		</section>



	</div>

	<!-- Javascript -->
	<script src="assets/plugins/jquery-3.3.1.min.js"></script>
	<script src="assets/plugins/popper.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>

	<!-- Style Switcher (REMOVE ON YOUR PRODUCTION SITE) -->
	<script src="assets/js/demo/style-switcher.js"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script>
		var lastName = $('input[name="lastName"]').val();
		var firstName = $('input[name="firstName"]').val();
		var password = $('input[name="password"]').val();
		var email = $('input[name="email"]').val();

		$('input[name="lastName"]').on('change', function() {
			lastName = $('input[name="lastName"]').val();
		});

		$('input[name="firstName"]').on('change', function() {
			firstName = $('input[name="firstName"]').val();
		});

		$('input[name="password"]').on('change', function() {
			password = $('input[name="password"]').val();
		});

		$('input[name="email"]').on('change', function() {
			email = $('input[name="email"]').val();
		});

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
				url : "/updateprofile",
				data : {
					content : result,
					lastName : lastName,
					firstName : firstName,
					password : password,
					email : email,

				},
				success : function(msg) {
					window.location.href = '';
					alert("you have added a pet");
				},
				error : function(msg) {
					alert("fail");
				}

			});
		});
	</script>
</body>
</html>


