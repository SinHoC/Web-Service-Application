<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="../static/login2/css/style.css" />
	<script type="text/javascript" src="../static/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../static/Convert_Pinyin.js"></script>
	<script type="text/javascript" src="../static/jquery.form.js"></script>

</head>
<body>
<div class="container">
	<div class="main">
		<div class="bg"></div>
		<form class="formone" id="denglu" action="/" method="get">
			<div class="title">登录</div>
			<div class="username"><input type="text" name="ZhangHao" id="ZhangHao" v-model="username" value="" placeholder="请输入账号" /></div>
			<div class="password"><input type="password" name="MiMa" v-model="password" id="MiMa" value="" placeholder="请输入密码" /></div>
			<!-- <div class="verification">是否验证？</div> -->
			<div class="loginbtn" onclick="denglu()">
				<div class="btnbg">登录</div><button type="button">登录</button>
			</div>
			<div class="registerbtn">
				<div class="btnbg">注册</div><button type="button">注册</button>
			</div>
		</form>
		<div class="registerpage">
			<form class="formtwo" id="zhuce" action="/" method="">
				<div class="registertitle">注册</div>
				<div class="savename"><input type="text" name="ZhangHao" id="ZhangHao2" value="" placeholder="请输入账号"/></div>
				<div class="savepassword"><input type="password" name="MiMa" id="MiMa2" value="" placeholder="请输入密码"/></div>
				<div class="btn_list">
					<div class="okbtn"  onclick="zhuce()"><button type="button">确认</button></div>
					<div class="resetbtn"><button type="button">撤销</button></div>
				</div>
			</form>

		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	let formone=document.querySelector('.formone');
	let registerpage=document.querySelector('.registerpage');
	let registerbtn=document.querySelector('.registerbtn');
	let resetbtn=document.querySelector('.resetbtn');
	registerbtn.addEventListener("click",()=>{
		formone.style.display='none';
	registerpage.style.display="flex";
	})
	resetbtn.addEventListener("click",()=>{
		formone.style.display='flex';
	registerpage.style.display="none";
	})



	var dic = {}
	var nname = ''
	function zhuce(){
		if($('#ZhangHao2').val()==''||$('#MiMa2').val()==''){
			alert("请完善信息");
			return
		}
		var a = $("#zhuce").serializeArray()
		for(var i in a){
			var d = a[i]
			dic[d["name"]]=d["value"]
		}
		nname=dic["ZhangHao"]

		var dic2 = {}
		dic2["table"]=pinyin.getFullChars("用户管理")
		dic2["database"]='admin'
		$.post('../getdata',dic2,function(data){
			var arr =  JSON.parse(data).data
			for(var i in arr){
				var d = arr[i]
				if (d["ZhangHao"]==nname) {
					alert("用户已存在")
					return
				}
			}

			var a = $("#zhuce").serializeArray()
			dic = {}
			for(var i in a){
				var d = a[i]
				dic[d["name"]]=d["value"]
			}
			dic["JiaoSe"]="用户"
			dic["table"]=pinyin.getFullChars("用户管理")
			dic["database"]='admin'
			var t = dic
			$.post('../savedata',t,function(data){
				alert(JSON.parse(data).msg)
				location.reload()
			})
		})



	}

	function denglu(){
		var a = $("#denglu").serializeArray()
		dic = {}
		for(var i in a){
			var d = a[i]
			dic[d["name"]]=d["value"]
		}
		dic["table"]=pinyin.getFullChars("用户管理")
		dic["database"]='admin'
		$.post('../getdata',dic,function(data){
			var arr =  JSON.parse(data).data
			for(var i in arr){
				var d = arr[i]
				if (d["ZhangHao"]==dic["ZhangHao"]&&d["MiMa"]==dic["MiMa"]) {
					window.localStorage.nowuser = JSON.stringify(d)
					window.localStorage.nowinfor=JSON.stringify(d)
					alert("登录成功")
					location.href="userInfo.jsp"
					return
				}
			}
			alert("账号或密码错误")
		})

	}
</script>
</html>
