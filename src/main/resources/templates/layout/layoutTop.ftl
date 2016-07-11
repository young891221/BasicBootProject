<#macro layoutTop>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Basic</title>

<link rel="stylesheet" href="/vendor/bootstrap/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/signin.css" />
<link rel="stylesheet" href="/vendor/font-awesome/css/font-awesome.min.css" />
</head>
<body ng-app="basic">

	<#nested/>

	<script src="/vendor/jquery/dist/jquery.min.js"></script>
	<script src="/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="/vendor/angular/angular.min.js"></script>
	
	<script src="/js/app.js"></script>
	
	<!-- board -->
	<script src="/js/modules/board.js"></script>
	<script src="/js/controllers/boardController.js"></script>
	<script src="/js/services/boardService.js"></script>
	
</body>
</html>
</#macro>