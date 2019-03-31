package org.FinancingProduct.Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.FinancingProduct.DBUtil.DBUtil;
import org.FinancingProduct.Dao.IFinancingProduct;
import org.FinancingProduct.Entity.FinancingProduct;

public class FinancingProductImpl implements IFinancingProduct {

	// A、编写查询方法，查询理财信息
	public List<FinancingProduct> QueryALLFinancingProduct() {
	PreparedStatement pstmt=null;
    ResultSet rs = null;
    FinancingProduct financingProduct=null;
		try {
			 List<FinancingProduct> list=new ArrayList<FinancingProduct>();

			String sql = "select * from FinancingProduct order by saleStarting desc";
			rs = DBUtil.executeQuery(sql, null);
			while(rs.next()) {
				 String id=rs.getString("id");
				 int risk=rs.getInt("risk");
				 String income=rs.getString("income");
				 String saleStarting=rs.getString("saleStarting");
				 String saleEnd=rs.getString("saleEnd");
				 String end=rs.getString("end");
				 financingProduct =new FinancingProduct(id,risk,income,saleStarting,saleEnd,end);
                 list.add(financingProduct);
            	
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
			
		}
		
	
	
	}

	// B、编写查询方法，根据产品代码和风险等级
	public List<FinancingProduct> QueryFinancingProductById(String id,int risk) {
		PreparedStatement pstmt=null;
	    ResultSet rs = null;
	    FinancingProduct financingProduct=null;
	    
		try {
			 List<FinancingProduct> list=new ArrayList<FinancingProduct>();
			 String sql="select *from FinancingProduct where id like? and risk=?";
		
			 Object[] params= {"%"+id+"%",risk};
			 rs=DBUtil.executeQuery(sql, params);
			while(rs.next()) {
				     String id2=rs.getString("id");
					 int risk1=rs.getInt("risk");
					 String income=rs.getString("income");
					 String saleStarting=rs.getString("saleStarting");
					 String saleEnd=rs.getString("saleEnd");
					 String end=rs.getString("end");
				financingProduct=new FinancingProduct(id2,risk1,income,saleStarting,saleEnd,end);
				list.add(financingProduct);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, pstmt,DBUtil.connection);
		}
		
	}
	

	// C、编写增加方法，实现添加理财功能
	
	public boolean addFinancingProduct (FinancingProduct financingProduct) {
		String sql="insert into FinancingProduct(id,risk,income,saleStarting,saleEnd,`end`)values(?,?,?,?,?,?)";
		Object[] params= {financingProduct.getId(),financingProduct.getRisk(),financingProduct.getIncome(),financingProduct.getSaleStarting(),financingProduct.getSaleEnd(),financingProduct.getEnd()};
		 return DBUtil.executeUpdate(sql, params);
	}
	
	//根据产品id判断是否存在
	public boolean isExist(String id) {// true:此人存在 false:此人不存在

		return  QueryFinancingProduct(id)==null? false:true;

	}
	//根据产品代码查询餐品信息 
	public FinancingProduct QueryFinancingProduct(String id) {
		PreparedStatement pstmt=null;
	    ResultSet rs = null;
	    FinancingProduct financingProduct=null;
		try {
			 String sql="select *from FinancingProduct where id=?";
		
			 Object[] params= {id};
			 rs=DBUtil.executeQuery(sql, params);
			while(rs.next()) {
				     String id2=rs.getString("id");
					 int risk1=rs.getInt("risk");
					 String income=rs.getString("income");
					 String saleStarting=rs.getString("saleStarting");
					 String saleEnd=rs.getString("saleEnd");
					 String end=rs.getString("end");
				financingProduct=new FinancingProduct(id2,risk1,income,saleStarting,saleEnd,end);
			}
			return financingProduct;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, pstmt,DBUtil.connection);
		}
		
		
		
	}
	
	
	

	
	
	
	

}
