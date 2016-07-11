<#import "/layout/layoutTop.ftl" as layout>
<@layout.layoutTop>
<link rel="stylesheet" href="/css/cover.css" />

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Cover</h3>
						<nav>
							<ul class="nav masthead-nav">
								<li class="active"><a href="#">Home</a></li>
								<li><a href="/board">Board</a></li>
								<li><a href="#">Contact</a></li>
								<li><#if authenticationName??>${authenticationName}님 환영합니다</#if></li>
							</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">Basic Project</h1>
					<p class="lead">Hello! It's a my own Spring Boot Project.</p>
					<p class="lead">
						<a href="/login"
							class="btn btn-lg btn-default">로그인하기</a>
					</p>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Made By <a href="https://github.com/young891221/BasicBootProject">@yj</a>.
						</p>
					</div>
				</div>

			</div>

		</div>

	</div>

</@layout.layoutTop>