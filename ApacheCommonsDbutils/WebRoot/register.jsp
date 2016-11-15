<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/easyui.css">
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<title>注册</title>
</head>
<body>
<div>
	<form id="mm" action="easyui-index-layout.html">
		用户名：&emsp;&emsp;&emsp;&emsp;&emsp;<input id="name" type="text" name="name"  ><br>
		密码：&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input id="pwd" type="password" name="pwd" ><br>
		
		<div id="msg" style="color:red;"></div>
		<a id="submintid" class="easyui-linkbutton" href="javascript:void(0)">提交</a>
		
	</form>

</div>

</body>

<script type="text/javascript">
	/*$(function(){
		var btn=$("#submitbtn");
		btn.click(function(){
			var obj={
			url:"registerAction",
			
			}
			$.ajax(obj);
		});
		
	});
	*/
	
	$(function(){
	var submintid=$("#submintid");
	submintid.click(function(){
		var obj={
			url:"RegesterServlet",
			//把表单数据当做参数传到后台
			data:$("#mm").serializeArray(),
			dataType:"json",
 
			success:function(data){
			//回传的数据要是json格式的，否则会执行error函数
				if(data.msg=="success"){
					$("#mm").submit();
				}else{
					$("#msg").text(data.msg);
				}
			
			},
			error:function(){
			alert("sdfsf");
			},
		};
		$.ajax(obj);
	
	});
		
	});
	
	
	
	
	/*
	$(function(){
				var a=document.getElementById("name").value;
				alert(a);
				$('#mm').form({
			    url:'RegesterServlet',
			    onSubmit: function(param){
			    	param.p1=$("#name").val();
			    	alert($("#name").val());
			    	param.p2=$("#pwd").val();
			        // do some check
			        // return false to prevent submit;
			    },
			    success:function(data){
			        alert(data)
			    }
			});
	
	
	});
	
*/
</script>
</html>