package org.FinancingProduct.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//通用的数据库操作方法
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String UPWD = "15214329839";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;

	//通用的查询总数（分页查询）
	public static int getTotalCount(String sql) {
		int count=-1;
		try {
			createPrepareStatement(sql, null);
		    rs=pstmt.executeQuery();
		    if(rs.next()) {
		    	count=rs.getInt(1);
		    }
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, connection);
		}
		
		
		return count;
		
		
	}
	
	
	
	
	// 通用的增删改
	public static boolean executeUpdate(String sql, Object[] params) {

		try {

			// setxxx()方法个数依赖于？号的个数，而？de 个数又与数组的params个数一致
			createPrepareStatement(sql, params);
			int count = pstmt.executeUpdate();
			if (count > 0) {

				return true;

			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, pstmt, connection);
		}

	}

	// 通用的查:返回值是一个集合 集合类型可以存储任何类型
	// 适合查询任何类型
	public static ResultSet executeQuery(String sql, Object[] params) {

		try {
			createPrepareStatement(sql, params);

			rs = pstmt.executeQuery();
			return rs;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} // finally {
//				try {
//
//					if (pstmt != null)
//						pstmt.close();
//					if (connection != null)
//						connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

//			}
		}
	

	public static Connection getconnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(URL, USERNAME, UPWD);

	}

	public static PreparedStatement createPrepareStatement(String sql, Object[] params)
			throws ClassNotFoundException, SQLException {
		pstmt = getconnection().prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);

			}
		}
		return pstmt;
	}

	public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
