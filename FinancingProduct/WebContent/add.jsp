<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=UTF-8">

<title>新增理财信息</title>
</head>
<body>
<h1>新增理财信息</h1>
	<form action="AddServelet">
		产品代码: <input type="text" name="id" id="id"><br> 风险评级 <select name="risk" id="risk">
			<option value="1">R1</option>
			<option value="2">R2</option>
			<option value="3">R3</option>
		</select><br> 预期收益: <input type="text" name="income" id="income"><br> 发售起始日: <input
			type="text" name="saleStarting" id="saleStarting"><br> 发售截至日: <input type="text" name="saleEnd" id="saleEnd"><br>
		产品到期日: <input type="text" name="end" id="end"><br>
     <input type="submit" value="提交">
     
     
	</form>
</body>
</html>