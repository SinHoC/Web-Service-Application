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
					<div class="col-sm-1 col-lg-4"></div>
					<form action="daoruaction" method="post" enctype="multipart/form-data" id="form" style="display: none">
						<input type="file" name="the_file" id="tx">
					</form>
					<form action="#">
						<div class="col-lg-4 col-sm-10" id="neirong">
							<img id="gaitouxiang" src="../static/头像.png" style="display: block;width: 100px;height: 100px;border-radius: 50px;margin-left: auto;margin-right: auto;" />
						</div>
					</form>
					<div class="col-lg-4 col-sm-1 "></div>
				</div>
			</div>
		</div>
		
	</div>

	<footer class="footer">
		<span><i class="fa fa-copyright"></i> 系统 </span>
	</footer>
	<script type="application/javascript">
//		loadIndex('个人信息')
loadDing('个人信息')

		$('#gaitouxiang').click(function(){
			$('#tx').click()
		})
		$('#tx').change(function(){

			var options  = {	
			url:'../uploadfile',   //同action
			type:'post',
			beforeSend:function(xhr){//请求之前

			},	
			success:function(data)	
			{   
				// 　　　　　　	alert(data.msg)
				data=JSON.parse(data)
				$('#gaitouxiang').attr('src',data.path)
				$('#TouXiang').val(data.path)
			},

			complete:function(xhr){

			},
			error: function(xhr,status,msg){

			}	
		};	
		$("#form").ajaxSubmit(options);
	})

		var s = '账号、密码、角色、昵称、年龄、爱好、邮箱、电话、姓名、头像'
		var f = "头像"
		var arr = s.split('、')
		for (var i = 0; i<arr.length; i++) {
			var biaoti = arr[i]
			if (biaoti==f) {
				$('#neirong').append('<div class="form-group">'+
					'<label for="name">'+biaoti+'</label>'+
					'					<form action="daoruaction" method="post" enctype="multipart/form-data" id="form2">'+
					'<input type="file" class="form-control" name="icon" tid = "'+pinyin.getFullChars(biaoti)+'" id="'+pinyin.getFullChars(biaoti)+'1" placeholder="请输入'+biaoti+'">'+
					'</form>'+
					'<input type="text" id="'+pinyin.getFullChars(biaoti)+'"  name="'+pinyin.getFullChars(biaoti)+'" style="display:none;"/>'+
					'</div>')
				$('#'+pinyin.getFullChars(biaoti)+'1').change(function(){
					var tname = pinyin.getFullChars(f)
					var options  = {
						url:'daoruaction',   //同action
						type:'post',
						beforeSend:function(xhr){//请求之前

						},	
						success:function(data)	
						{   
							
							$('#'+tname).val(data.path)
						},

						complete:function(xhr){

						},
						error: function(xhr,status,msg){

						}	
					};
					$("#form2").ajaxSubmit(options);
				})
				continue
			}
			$('#neirong').append('<div class="form-group">'+
				'<label for="name">'+biaoti+'</label>'+
				'<input type="text" class="form-control" id="'+pinyin.getFullChars(biaoti)+'" name="'+pinyin.getFullChars(biaoti)+'" placeholder="请输入'+biaoti+'">'+
				'</div>')

		}
		$('#TouXiang').parent().css('display','none')
		$('#neirong').append('<div class="form-group">'+
			'<button id="tijiao" class="btn">修改</button>'+
			'</div>')
		var tdic = {}
		$('#tijiao').click(function(){
			var aid = tdic["id"]
			tdic={}
			tdic["id"]=aid
			$('input').each(function(i,o){
				if ($(o).attr('name')=='the_file') {
					return true
				}
				tdic[$(o).attr('name')]=$(o).val()
			})
			tdic["TouXiang"]=$('#gaitouxiang').attr('src')
			tdic["table"]=pinyin.getFullChars('用户管理')
			tdic["database"]='admin'
			delete tdic["icon"]
			$.post('../updatedata',tdic,function(data){
				alert(JSON.parse(data).msg)
			})
		})

		$('#ZhangHao').attr('disabled','disabled')
		$('#YuE').attr('disabled','disabled')
		$('#JiaoSe').attr('disabled','disabled')
		$('#MiMa').attr('type','password')
		var biglist = []
		var tlist =[]
		$.post("../getdata",{table:pinyin.getFullChars("用户管理"),database:'admin'},function(result){

			for(var i in JSON.parse(result).data){
				if(JSON.parse(window.localStorage.nowinfor).ZhangHao==JSON.parse(result).data[i]["ZhangHao"]){
					window.localStorage.nowinfor = JSON.stringify(JSON.parse(result).data[i])
					var dic = JSON.parse(result).data[i]
					tdic=dic
					for(var i in dic){
						$('#'+i).val(dic[i])
					}
				}
			}

			if($('#TouXiang').val()!=''){
				$('#gaitouxiang').attr('src',$('#TouXiang').val())
			}
			if($('#'+pinyin.getFullChars(f)).val()!=''){
				$('#'+pinyin.getFullChars(f)).after('<a href="'+$('#'+pinyin.getFullChars(f)).val()+'">查看'+f+'</a>')
			}
		})
	</script>
</body>

</html>
