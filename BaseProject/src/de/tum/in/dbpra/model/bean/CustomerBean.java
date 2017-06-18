package de.tum.in.dbpra.model.bean;

public class CustomerBean {
	private int custkey;
	private String name;
	private String address;
	private double acctbal;
	
	public CustomerBean() {}
	
	public int getCustkey() {
		return custkey;
	}
	public void setCustkey(int custkey) {
		this.custkey = custkey;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the acctbal
	 */
	public double getAcctbal() {
		return acctbal;
	}
	/**
	 * @param acctbal the acctbal to set
	 */
	public void setAcctbal(double acctbal) {
		this.acctbal = acctbal;
	}
	
}
