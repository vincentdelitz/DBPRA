package de.tum.in.dbpra.model.bean;

public class PartBean {
	private int partkey;
	private String name;
	private String type;
	private int size;
	private int container;
	private double retailprice;

	
	public PartBean() {}


	public int getPartkey() {
		return partkey;
	}


	public void setPartkey(int partkey) {
		this.partkey = partkey;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	public int getContainer() {
		return container;
	}


	public void setContainer(int container) {
		this.container = container;
	}
	
	public double getRetailprice() {
		return retailprice;
	}


	public void setRetailprice(double retailprice) {
		this.retailprice = retailprice;
	}
	

	
}
