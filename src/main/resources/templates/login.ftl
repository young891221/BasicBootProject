<#import "/layout/layout.ftl" as layout>
<@layout.layout>
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
				<div class="col-xs-8 col-sm-8 col-md-3">
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

</@layout.layout>