package org.FinancingProduct.Entity;

public class FinancingProduct {
  private String id;
  private int risk;
  private String income;
  private String saleStarting;
  private String saleEnd;
  private String end;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getRisk() {
	return risk;
}
public void setRisk(int risk) {
	this.risk = risk;
}
public String getIncome() {
	return income;
}
public void setIncome(String income) {
	this.income = income;
}
public String getSaleStarting() {
	return saleStarting;
}
public void setSaleStarting(String saleStarting) {
	this.saleStarting = saleStarting;
}
public String getSaleEnd() {
	return saleEnd;
}
public void setSaleEnd(String saleEnd) {
	this.saleEnd = saleEnd;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}
public FinancingProduct(String id, int risk, String income, String saleStarting, String saleEnd, String end) {

	this.id = id;
	this.risk = risk;
	this.income = income;
	this.saleStarting = saleStarting;
	this.saleEnd = saleEnd;
	this.end = end;
}
public FinancingProduct() {
	
}
public String toString() {
	
	return this.id+"-"+this.risk+"-"+this.income+"-"+this.saleStarting+"-"+this.saleEnd+"-"+this.end;
	
}	





	
	
}
