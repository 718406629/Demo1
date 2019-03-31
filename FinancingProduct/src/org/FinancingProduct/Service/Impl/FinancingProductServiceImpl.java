package org.FinancingProduct.Service.Impl;

import java.util.List;

import org.FinancingProduct.Dao.IFinancingProduct;
import org.FinancingProduct.Dao.Impl.FinancingProductImpl;
import org.FinancingProduct.Entity.FinancingProduct;
import org.FinancingProduct.Service.IFinancingProductService;

public class FinancingProductServiceImpl implements IFinancingProductService {
   IFinancingProduct financingProductDao=new FinancingProductImpl();
   
	// A、编写查询方法，查询理财信息
	public List<FinancingProduct> QueryALLFinancingProduct() {
	   return financingProductDao.QueryALLFinancingProduct();
	}
	
	// B、编写查询方法，根据产品代码查询理财信息记录数，以判断产品代码是否重复
		public List<FinancingProduct> QueryFinancingProductById(String id,int risk) {
			return financingProductDao.QueryFinancingProductById(id,risk);
		}
		
		// C、编写增加方法，实现添加理财功能
		
		public boolean addFinancingProduct (FinancingProduct financingProduct) {
			if (!financingProductDao.isExist(financingProduct.getId())) {
				// 不存在就增加
				financingProductDao.addFinancingProduct(financingProduct);
				return true;
			} else {
				//存在
				System.out.println("此人已存在");
				return false;
			}
			
			
		}
		public boolean isExist(String id) {// true:此人存在 false:此人不存在

			return financingProductDao.isExist(id);

		}
}
