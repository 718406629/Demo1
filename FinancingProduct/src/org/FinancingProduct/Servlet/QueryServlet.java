package org.FinancingProduct.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.FinancingProduct.Entity.FinancingProduct;
import org.FinancingProduct.Service.IFinancingProductService;
import org.FinancingProduct.Service.Impl.FinancingProductServiceImpl;


 
public class QueryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");//浏览器识别编码html
	    String id=request.getParameter("id");
		int risk=Integer.parseInt(request.getParameter("risk"));
		IFinancingProductService financingProductService=new FinancingProductServiceImpl();
		List<FinancingProduct> list1=financingProductService.QueryFinancingProductById(id, risk);
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("info.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}