package org.FinancingProduct.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.FinancingProduct.Entity.FinancingProduct;
import org.FinancingProduct.Service.IFinancingProductService;
import org.FinancingProduct.Service.Impl.FinancingProductServiceImpl;


public class AddServelet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");//浏览器识别编码html
		     String id=request.getParameter("id");
			 int risk=Integer.parseInt(request.getParameter("risk"));
			 String income=request.getParameter("income");
			 String saleStarting=request.getParameter("saleStarting");
			 String saleEnd=request.getParameter("saleEnd");
			 String end=request.getParameter("end");
			 FinancingProduct financingProduct=new FinancingProduct(id,risk,income,saleStarting,saleEnd,end);
		     IFinancingProductService financingProductService=new FinancingProductServiceImpl();
		     boolean count=financingProductService.addFinancingProduct(financingProduct);
		    
		     if(count) {
		    	 System.out.println("增加成功！");
		    	 request.getRequestDispatcher("QueryAllServlet").forward(request, response);
		     }else {
		    	 System.out.println("增加失败！");
		     }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
