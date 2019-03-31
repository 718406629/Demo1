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
<body>
<% 
List<FinancingProduct> list1=(List<FinancingProduct>)request.getAttribute("list1");
%>
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
         for(FinancingProduct financingProduct:list1){
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







<a href="QueryAllServlet">返回</a>

</body>
</html>