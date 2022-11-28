<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
	nav ul li{list-style: none;}
	a {text-decoration: none;}
	.container{width: 1000px; margin: auto;}
	nav {background: #1A66B3;}
	nav ul {font-size: 0;margin: 0;padding: 0;}
	nav ul li {display: inline-block;}
	nav ul li a {
		color: #fff;
		display: block;
		font-size: 14px;
		padding: 15px 14px;
		transition: 0.3s linear;
	}
	nav ul li:hover {background: #126d9b;}
	nav ul li ul {
		border-bottom: 5px solid #2ba0db;
		display: none;
		position: absolute;
		width: 250px;
	}
	nav ul li ul li {
		border-top: 1px solid #444;
		display: block;
	}

	nav ul li ul li:first-child {
		border-top: none;
	}

	nav ul li ul li a {
		background:cadetblue;
		display: block;
		padding: 10px 14px;
	}

	nav ul li ul li a:hover {
		background: #126d9b;
	}

	nav .fa.fa-angle-down {
		margin-left: 6px;
	}
</style>

<nav>
	<span style="float: left;line-height: 50px;color: white;margin-left: 15px">order system</span>
	<div class="container">
		<ul id="ding">
			<!-- <li><a href="#">首页</a></li>
			<li><a href="#">关于</a></li>
			<li>
				<a href="#">类别<i class='fa fa-angle-down'></i></a>
				<ul>
					<li><a href="#">类别1</a></li>
					<li><a href="#">类别2</a></li>
					<li><a href="#">类别3</a></li>
				</ul>
			</li>
			<li class='sub-menu'>
				<a href="#">服务<i class='fa fa-angle-down'></i></a>
				<ul>
					<li><a href="#">服务1</a></li>
					<li><a href="#">服务2</a></li>
					<li><a href="#">服务3</a></li>
					<li><a href="#">服务4</a></li>
					<li><a href="#">服务5</a></li>
					<li><a href="#">服务6</a></li>
				</ul>
			</li>
			<li><a href="#">联系我们</a></li> -->
			<%--<li style="float: right;"><a href="/index.html">退出登录</a></li>--%>
			<%--<li style="float: right;"><a href="/userInfo.jsp">个人信息</a></li>--%>
		</ul>
	</div>
</nav>
<script>

	function loadDing(argument) {
		// body...
		list = [
		]
        var JiaoSe=JSON.parse(window.localStorage.nowinfor)["JiaoSe"]

        if (JiaoSe=="管理员") {
			list = [


			{
				"name": '用户信息',
				'url': 'userInfo.jsp'
			},

				{
					"name":"用户管理",
					'url':'table.jsp?'+
					'show='+
					'账号、密码、角色、昵称、年龄、爱好、邮箱、电话、姓名、头像'+
					'&add='+
					'账号、密码、角色、昵称、年龄、爱好、邮箱、电话、姓名、头像'+
					'&fujian='+
					'头像'+
					'&fuwenben='+
					''+
					'&name='+
					'用户管理'
				}



               ,
				{
					"name": 'extit',
					'url': '/index.html'
				}

			]
		}else{
            list=[
                {
                    "name":"order",
                    'url':'table.jsp?'+
                    'show=Name、content、picture、executionime'+
                    ''+
                    '&add='+
                    'Name、content、picture、executionime'+
                    '&fujian='+
                    'picture'+
                    '&fuwenben='+
                    'content'+
                    '&name='+
                    'order'
                }
            ]
        }

	for (var i = 0; i <list.length; i++) {
		if (list[i]["name"]==argument) {
			$('#ding').append('<li><a style="background: #FBFBFB;color: black;" href="'+list[i]["url"]+'">'+list[i]["name"]+'</a></li>')
		}
		else{
            var a=  list[i]["url"];
			$('#ding').append('<li><a href=\''+a+'\'>'+list[i]["name"]+'</a></li>')
		}
	}
	$('nav li').hover(
		function() {
			$('ul', this).stop().slideDown(200);
		},
		function() {
			$('ul', this).stop().slideUp(200);
		}
		);
}
</script>