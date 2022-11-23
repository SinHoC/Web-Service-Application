<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
	<title>系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>



<!-- 	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../static/main/css/animate.css">
	<link href="https://cdn.bootcdn.net/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" rel="stylesheet">
	<script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
-->

<link rel="stylesheet" type="text/css" href="../static/main/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../static/main/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../static/main/css/bootstrap-select.min.css">
<script type="text/javascript" src="../static/main/js/bootstrap-select.min.js"></script>



<link rel="stylesheet" type="text/css" href="../static/main/css/awesome-bootstrap-checkbox.css">
<link rel="stylesheet" type="text/css" href="../static/jquery.dataTables.min.css">

<link rel="stylesheet" type="text/css" href="../static/main/css/select2.css">
<link rel="stylesheet" type="text/css" href="../static/main/css/style.css">
<link rel="stylesheet" type="text/css" href="../static/main/css/theme.css">
<link rel="stylesheet" type="text/css" href="../static/page.css">

<script src="../static/jquery.min.js"></script>
<script src="../static/bootstrap.min.js"></script>

<script type="text/javascript" src="../static/main/js/Chart.min.js"></script>
<script type="text/javascript" src="../static/main/js/main.js"></script>
<script type="text/javascript" src="../static/main/js/index.js"></script>
<script type="text/javascript" src="../static/page.js"></script>
<script type="text/javascript" src="../static/Convert_Pinyin.js"></script>
<script type="text/javascript" src="../static/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="../static/jquery.form.js"></script>

<script type="text/javascript" src="../static/wangEditor.min.js"></script>
<style type="text/css">
	#datatable_xs {
		text-align: center;
	}

	th {
		text-align: center;
	}

	.alert {
		display: none;
		position: fixed;
		top: 50%;
		left: 50%;
		min-width: 300px;
		max-width: 600px;
		transform: translate(-50%, -50%);
		z-index: 99999;
		text-align: center;
		padding: 15px;
		border-radius: 3px;
	}

	.alert-success {
		color: #3c763d;
		background-color: #dff0d8;
		border-color: #d6e9c6;
	}

	.alert-info {
		color: #31708f;
		background-color: #d9edf7;
		border-color: #bce8f1;
	}

	.alert-warning {
		color: #8a6d3b;
		background-color: #fcf8e3;
		border-color: #faebcc;
	}

	.alert-danger {
		color: #a94442;
		background-color: #f2dede;
		border-color: #ebccd1;
	}

	td {
		text-align: center!important;
		vertical-align: middle!important;
	}

	.dataTables_length {
		display: none!important;
	}

	.toolbar {
		border: 1px solid #ccc;
		width: 100%;
	}

	.text {
		border: 1px solid #ccc;
		width: 100%;
	}

	.w-e-panel-container {
		width: 80%!important;
		margin-left: -100px!important;
	}
</style>

</head>

<body class="flat-blue sidebar-collapse">
<jsp:include   page="nav.jsp" flush="true"/>

	<div class="alert"></div>

	<div class="sidebar">
		<div class="menu-control toggle-sidebar">
			<a class="navbar-brand" href="#" class="atitle"></a>
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
						<a class="navbar-brand" href="#"><span class="atitle"></span>列表</a>
					</div>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title red"><h2><span class="atitle"></span>列表</h2>
				</span>
			</div>
			<button id="tianjiadianbu" class="btn btn-primary btn-sm">
				添加<span class="atitle"></span>
			</button>
			<button id="tianjiadianbu2" style="display: none" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#addUserModal">
				展示弹窗
			</button>
		</div>

		<div class="row">
			<table class="table display" id="datatable_xs" style="border: 1px solid RGBA(62, 70, 81, 1);width: 100%">
				<thead>
					<tr id="tou">
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<!-- 模态框示例（Modal） -->
<div class="form-horizontal" role="form" id="form_data" style="margin: 20px;">
	<div class="modal fadein" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<span class="atitle"></span>信息
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="add" role="form">

					</form>
				</div>
				<div class="modal-footer">
					<button id="guanbi" type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" id="tijiao" class="btn btn-primary">
						提交
					</button><span id="tip"> </span>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</div>

<footer class="footer">
	<span><i class="fa fa-copyright"></i> 系统 </span>
</footer>
<script type="application/javascript">
	$('.modal-dialog').css('width', '80%')
	$('.modal-dialog').css('margin-left', '50px')
	$.ajaxSetup({
		async: false
	});
	var title = "专题学习管理"
	if (getQueryString("name")) {
		title=getQueryString('name')
	}
	setTimeout(function(){
//		loadIndex(title)
        loadDing(getQueryString('name'))

    },750)

	$('.atitle').each(function(i, o) {
		$(o).text(title)
	})
	$('#atitle').val(title + '列表')
	var showString = '封面图、标题、副标题、内容、测试、测试2、操作'
	if (getQueryString("show")) {
		showString=getQueryString('show')+'、操作'
	}
	var addString = '封面图、标题、副标题、内容、测试、测试2'
	if (getQueryString("add")) {
		addString=getQueryString('add')
	}
	var fujian = '封面图'
	if (getQueryString("fujian")) {
		fujian=getQueryString('fujian')
	}

	var keyword = "所属人"
	var fuwenben=''
	if (getQueryString("fuwenben")) {
		fuwenben=getQueryString('fuwenben')
	}
	var changdi = ''
//	$.post('../getdata', {'database': 'admin',
//		'table': 'FenLeiGuanLi'},function(data) {
//			data = JSON.parse(data)
//
//			for(var i in data.data) {
//				changdi = changdi + '<option value="' + data.data[i]["FenLeiMingChen"] + '">' + data.data[i]["FenLeiMingChen"] + '</option>'
//			}
//			changdi = '<select class="form-control" name="' + (pinyin.getFullChars("分类")) + '">' + changdi + '</select>'
//		})
	var tfuwenbenEditor
	var prompt = function(message, style, time) {
		style = (style === undefined) ? 'alert-success' : style;
		time = (time === undefined) ? 1200 : time;
		$('<div>')
		.appendTo('body')
		.addClass('alert ' + style)
		.html(message)
		.show()
		.delay(time)
		.fadeOut();
	};

			// 成功提示
			var success_prompt = function(message, time) {
				prompt(message, 'alert-success', time);
			};

			// 失败提示
			var fail_prompt = function(message, time) {
				prompt(message, 'alert-danger', time);
			};

			// 提醒
			var warning_prompt = function(message, time) {
				prompt(message, 'alert-warning', time);
			};

			// 信息提示
			var info_prompt = function(message, time) {
				prompt(message, 'alert-info', time);
			};

			$('#YongYouZhe').val(window.localStorage.nowname)

			$('#tijiao').click(function() {

				var a = $("#add").serializeArray()
				dic = {}
				for(var i in a) {
					var d = a[i]
					dic[d["name"]] = d["value"]
				}
				if(fuwenben != '') {
					var akey = pinyin.getFullChars(fuwenben)
					dic[akey] = tfuwenbenEditor.txt.html()
				}
				dic["table"] = pinyin.getFullChars(title)
				dic["database"] = 'admin'
//				dic[pinyin.getFullChars(keyword)] = JSON.parse(window.localStorage.nowuser).ZhangHao
				var aurl = '../savedata'
				if(isbianji == true) {
					dic['id'] = tdata['id']

					aurl = '../updatedata'
				}
				$.post(aurl, dic, function(data) {
					$('#add')[0].reset();
					$('#guanbi').click()
					success_prompt('操作成功', 750)

					$("#datatable_xs").dataTable()._fnAjaxUpdate();

				})

			})

			function toujianli(data) {
				$.post('../deldata', {
					"id": data.id,
					database: 'admin',
					table: pinyin.getFullChars(title),
				}, function(data) {
					success_prompt(data.msg, 750)
					$("#datatable_xs").dataTable()._fnAjaxUpdate();
				})
			}
			$('#tianjiadianbu').click(function() {
				isbianji = false
				$('#tianjiadianbu2').click()
			})
			var isbianji = false
			var tdata

			function bianji(data) {
				tdata = data
				$('#tianjiadianbu').click()

				$('#add input').each(function(i, o) {
					if($(o).attr('type') == 'file') {

						return true
					}

					$(o).val(data[$(o).attr('name')])

				})
				$('#add select').each(function(i, o) {
					if($(o).attr('type') == 'file') {

						return true
					}

					$(o).val(data[$(o).attr('name')])

				})
				if(fuwenben != '') {
					// alert(data[pinyin.getFullChars(fuwenben)])
					// debugger
					tfuwenbenEditor.txt.html(data[pinyin.getFullChars(fuwenben)])

				}
				isbianji = true
			}

			function zhuangtai(data) {
				data.ZhuangTai = (data.ZhuangTai == "禁用" ? "启用" : "禁用")
				$.post('updatedata', data, function(data) {
					success_prompt('操作成功', 750)
					$("#datatable_xs").dataTable()._fnAjaxUpdate();
				})
			}

			var arr = showString.split('、')
			var string = ''
			var barr = []

			var arr2 = addString.split('、')

			for(var i in arr2) {
				if(arr2[i] == '操作') {

				} else {
					if(arr2[i] == fujian) {
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							'<input type="file" class="form-control" id="' + pinyin.getFullChars(arr2[i]) + '" name="uploadFile" >' +
							'<input type="text" class="form-control" name="' + pinyin.getFullChars(arr2[i]) + '" style="display:none">' +

							'</div>' +
							'</div>')

						$('#' + pinyin.getFullChars(arr2[i])).change(function() {
							var tname = $(this).attr('id')
							var options  = {	
			url:'../uploadfile',   //同action
			type:'post',
			beforeSend:function(xhr){//请求之前

			},	
			success:function(data)	
			{   
				// 　　　　　　	alert(data.msg)
				data=JSON.parse(data)
				$('input').each(function(i, o) {
					if($(o).attr('name') == tname) {
						$(o).val(data.path)
					}
				})
			},

			complete:function(xhr){

			},
			error: function(xhr,status,msg){

			}}

			$("#add").ajaxSubmit(options);
		})

					} else if(arr2[i] == fuwenben) {
						$('#add').append('<div id="' + pinyin.getFullChars(arr2[i]) + '1" class="toolbar"></div>')
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							'<div class="text" id="' + pinyin.getFullChars(arr2[i]) + '2" name="' + pinyin.getFullChars(arr2[i]) + '2">' +
							'</div>' +
							'</div>' +
							'</div>')
						var E = window.wangEditor

						tfuwenbenEditor = new E('#' + pinyin.getFullChars(arr2[i]) + '1', '#' + pinyin.getFullChars(arr2[i]) + '2')
						// 自定义菜单配置
						tfuwenbenEditor.customConfig.menus = [
						'head',
						'bold',
						'italic',
						'image',
						'head',  
						'bold',  
						'fontSize',  
						'fontName',  
						'italic',  
						'underline',  
						'strikeThrough',  
						'foreColor',  
						'backColor',  
						'link',  
						'list',  
						'justify',  
						'quote',  
						'emoticon',  
						'image', 
						'table', 
						'video', 
						'code', 
						'undo', 
						'redo' 
						]

						tfuwenbenEditor.create()


					}
					else if(arr2[i]=='封杀'||arr2[i]=='禁言'){
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							'<select class="form-control" id="' + pinyin.getFullChars(arr2[i]) + '" name="' + pinyin.getFullChars(arr2[i]) + '" ><option value="是">是</option><option value="否">否</option></select>' +
							'</div>' +
							'</div>')
					}
					else if(arr2[i]=='角色'){
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							'<select class="form-control" id="' + pinyin.getFullChars(arr2[i]) + '" name="' + pinyin.getFullChars(arr2[i]) + '" ><option value="管理员">管理员</option><option value="用户">用户</option></select>' +
							'</div>' +
							'</div>')
					}
					else if(arr2[i].indexOf('时间')!=-1){
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							'<input type="date" class="form-control" id="' + pinyin.getFullChars(arr2[i]) + '" name="' + pinyin.getFullChars(arr2[i]) + '" placeholder="请输入' + arr2[i] + '">' +
							'</div>' +
							'</div>')
					}
					else if(arr2[i]=='分类') {
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							changdi +
							'</div>' +
							'</div>')
						continue
					}
					else {
						$('#add').append('<div class="form-group">' +
							'<label for="user_id" class="col-sm-3 control-label">' + arr2[i] + '</label>' +
							'<div class="col-sm-9">' +
							'<input type="text" class="form-control" id="' + pinyin.getFullChars(arr2[i]) + '" name="' + pinyin.getFullChars(arr2[i]) + '" placeholder="请输入' + arr2[i] + '">' +
							'</div>' +
							'</div>')
					}

				}
			}

			for(var i in arr) {

				if(arr[i] == "头像") {
					string = string + '<th>' + arr[i] + '</th>'
					barr.push({
						"render": function(data, type, row) {
							// alert(JSON.stringify(pinyin.getFullChars(arr[i])))
							file:///Users/linlixiang/Desktop/JavaProject/%E4%BA%BA%E5%8A%9B%E8%B5%84%E6%BA%902/out/artifacts/javaBase_war_exploded//upload/O1CN01fPE2Qq1jbjVbbRsqz_!!0-fleamarket.jpg_728x728.jpg
							var html = "<img style='width:60px;height:60px' src='" + row['TouXiang'] + "'/>"
							return html;
						}
					})
					continue

				}

				// <i class='fa fa-arrow-up'></i>
				if(arr[i] == "操作") {
					string = string + '<th>' + arr[i] + '</th>'
					barr.push({
						"render": function(data, type, row) {
							var html = "<a href='javascript:void(0);' onclick='toujianli(" + JSON.stringify(row) + ")'  class='up btn btn-default btn-xs'> 删除</a>"
							+"<a href='javascript:void(0);' onclick='bianji(" + JSON.stringify(row) + ")'  class='up btn btn-default btn-xs'> 编辑</a>"
							return html;
						}
					})
					continue
				}
				if(arr[i] == fujian) {
					string = string + '<th>' + arr[i] + '</th>'
					barr.push({
						"render": function(data, type, row) {
							var html = "<a href='../" + row[pinyin.getFullChars(fujian)] + "'>附件</a>"
							return html;
						}
					})
					continue
				}

				string = string + '<th>' + arr[i] + '</th>'
				barr.push({
					'data': pinyin.getFullChars(arr[i])
				})
			}

			$('#tou').append(string)

			function shengcheng() {
				//表格生成
				$('#datatable_xs').DataTable({
					'sScrollX':true,
					'bAutoWidth':true,
					'language': {
						"sProcessing": "处理中...",
						"sLengthMenu": "显示 _MENU_ 项结果",
						"sZeroRecords": "没有匹配结果",
						"sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
						"sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
						"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
						"sInfoPostFix": "",
						"sSearch": "搜索:",
						"sUrl": "",
						"sEmptyTable": "表中数据为空",
						"sLoadingRecords": "载入中...",
						"sInfoThousands": ",",
						"oPaginate": {
							"sFirst": "首页",
							"sPrevious": "上页",
							"sNext": "下页",
							"sLast": "末页"
						},
						"oAria": {
							"sSortAscending": ": 以升序排列此列",
							"sSortDescending": ": 以降序排列此列"
						}
					},
					"processing": true,
					"searching": false,
					"serverSide": false,
					"ajax": {
						'type': 'post',
						data: {
							database: 'admin',
							table: pinyin.getFullChars(title)
						},
						"url": "../getdata",
					},
					"columns": barr
				});
			}
			shengcheng()

			if (window.localStorage.role=="用户") {
				// $('#tianjiadianbu').hide()
			}
		</script>
	</body>

	</html>