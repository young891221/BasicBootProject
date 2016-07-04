<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login</title>

<link rel="stylesheet" href="/vendor/bootstrap/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/signin.css" />
<link rel="stylesheet" href="/vendor/font-awesome/css/font-awesome.min.css" />
</head>
<body>
	<div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">ID or Email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="ID or Email" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>

		<p class="lead">
			<div class="col-xs-6 col-sm-6 col-md-3">
				<button type="button" class="btn btn-danger btn-block" onclick="location.href='${apiUrl}'">
					<i class="fa fa-google-plus"></i>
				</button>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-3">
				<button type="button" class="btn btn-primary btn-block " onclick="">
					<i class="fa fa-facebook"></i>
				</button>
			</div>
		</p>
		<p>
			<a href="/joinView">회원가입</a>
		</p>
		<p class="lead">
			<#if state?has_content>
				<p class="lead">${state}</p>
			</#if>
		</p>
		
		
      </form>

    </div> <!-- /container -->

	<script src="/vendor/jquery/dist/jquery.min.js"></script>
	<script src="/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>