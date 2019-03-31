package org.FinancingProduct.Service;

import java.util.List;

import org.FinancingProduct.Entity.FinancingProduct;

public interface IFinancingProductService {

	
	public List<FinancingProduct> QueryALLFinancingProduct() ;
	public List<FinancingProduct> QueryFinancingProductById(String id,int risk);
	public boolean addFinancingProduct (FinancingProduct financingProduct);
	public boolean isExist(String id);
}