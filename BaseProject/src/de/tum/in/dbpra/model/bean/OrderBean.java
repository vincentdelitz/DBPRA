package de.tum.in.dbpra.model.bean;

public class OrderBean {
	private int orderkey;
	private int custkey;
	private double totalprice;
	private String orderdate;

	
	public OrderBean() {}


	public int getOrderkey() {
		return orderkey;
	}


	public void setOrderkey(int orderkey) {
		this.orderkey = orderkey;
	}


	public int getCustkey() {
		return custkey;
	}


	public void setCustkey(int custkey) {
		this.custkey = custkey;
	}


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public String getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	

	
}
