<%@page import="java.util.List"%>
<%@page import="org.FinancingProduct.Entity.FinancingProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
	 
	 $("tr:odd").css("background-color","lightgray");
	

 });

 
 
 
 </script>

<body><%
List<FinancingProduct> list=(List<FinancingProduct>)request.getAttribute("list");
%>
<form action="QueryServlet">
产品代码<input name="id" type="text">
风险评级
<select name="risk">
  <option value ="1">R1</option>
  <option value ="2">R2</option>
  <option value="3">R3</option>
</select>
<input type="submit" value="查询">
</form>
<a href="add.jsp">新增理财信息</a>


<table border="1px">

<tr>
        <th>产品代码</th>
        <th>风险评级</th>
        <th>预期收益</th>
        <th>发售起始日</th>
        <th>发售截至日</th>
        <th>产品到期日</th>
<tr>
      
	      <% 
         for(FinancingProduct financingProduct:list){
        	 %>	 
        <tr>   
          <td><%=financingProduct.getId() %></td>  
		  <td><%=financingProduct.getRisk() %></td>  
		  <td><%=financingProduct.getIncome() %></td>
		  <td><%=financingProduct.getSaleStarting() %></td>
		  <td><%=financingProduct.getSaleEnd() %></td>
		  <td><%=financingProduct.getEnd() %></td>
       </tr> 
        <%	 
         }
       
	      %>    
      
	     

</table>







</body>
</html>