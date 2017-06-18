package de.tum.in.dbpra.model.bean;

public class LineitemBean {
	private int orderkey;
	private int linenumber;
	private int partkey;
	private int quantity;
	private double extendedprice;
		
	public LineitemBean() {}

	public int getOrderkey() {
		return orderkey;
	}

	public void setOrderkey(int orderkey) {
		this.orderkey = orderkey;
	}

	public int getLinenumber() {
		return linenumber;
	}

	public void setLinenumber(int linenumber) {
		this.linenumber = linenumber;
	}

	public int getPartkey() {
		return partkey;
	}

	public void setPartkey(int partkey) {
		this.partkey = partkey;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getExtendedprice() {
		return extendedprice;
	}

	public void setExtendedprice(double extendedprice) {
		this.extendedprice = extendedprice;
	}
	
	
}
