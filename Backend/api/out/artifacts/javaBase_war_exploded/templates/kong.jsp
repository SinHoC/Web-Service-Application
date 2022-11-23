<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
	<title>系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link rel="stylesheet" type="text/css" href="../static/main/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/animate.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/bootstrap-select.min.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/awesome-bootstrap-checkbox.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/select2.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/style.css">
	<link rel="stylesheet" type="text/css" href="../static/main/css/theme.css">
	<link rel="stylesheet" type="text/css" href="../static/page.css">

	<script src="../static/jquery-2.1.4.js"></script>
	<script src="../static/bootstrap-3.3.7-dist 2/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../static/main/js/Chart.min.js"></script>
	<script type="text/javascript" src="../static/main/js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="../static/main/js/main.js"></script>
	<script type="text/javascript" src="../static/main/js/index.js"></script>
	<script type="text/javascript" src="../static/page.js"></script>
	<script type="text/javascript" src="../static/Convert_Pinyin.js"></script>
	<script type="text/javascript" src="../static/jquery.form.js"></script>
	<style>

	</style>
</head>

<body class="flat-blue sidebar-collapse">
<jsp:include   page="nav.jsp" flush="true"/>

	<div class="sidebar">
		<div class="menu-control toggle-sidebar">
			<a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i> 个人信息</a>
			<i class="fa fa-bars navicon"></i>
		</div>

	</div>
	<div class="content-container wrap">
		<nav class="navbar navbar-default">
			<div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i> 个人信息</a>
					</div>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title red"><h2>个人信息</h2></span>
				</div>
			</div>
			<div id="showdiv">
				<div class="row">

				</div>
			</div>
		</div>
		
	</div>

	<footer class="footer">
		<span><i class="fa fa-copyright"></i> 系统 </span>
	</footer>
	<script type="application/javascript">
//		loadIndex('个人信息')
loadDing(getQueryString('name'))


	</script>
</body>

</html>
