package de.tum.in.dbpra.model.bean;

import java.sql.Date;

public class VisitorBean {
	private int visitorID;
	private int ticketID;
	private Date buytime;
	private String category;
	private double finalprice;
	private double balance;
	private String firstname;
	private String lastname;
	private String salutation;
	


	
	public VisitorBean() {}




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getSalutation() {
		return salutation;
	}




	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}




	public int getVisitorID() {
		return visitorID;
	}




	public void setVisitorID(int visitorID) {
		this.visitorID = visitorID;
	}




	public int getTicketID() {
		return ticketID;
	}




	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}




	public Date getBuytime() {
		return buytime;
	}




	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public double getFinalprice() {
		return finalprice;
	}




	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}




	public double getBalance() {
		return balance;
	}




	public void setBalance(double balance) {
		this.balance = balance;
	}




	

	
}
