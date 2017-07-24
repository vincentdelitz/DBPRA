package de.tum.in.dbpra.model.bean;

import java.sql.Timestamp;

public class StageBean {
	private String persID;
	private String persFirstName;
	private String persLastName;
	private int stageID;
	private String name;
	private double size;
	private String bandName;
	private Timestamp performanceStart;
	private Timestamp performanceEnd;

	
	public StageBean() {}
	
	public String getPersID() {
		return persID;
	}
	
	public void setPersID(String persID) {
		this.persID = persID;
	}
	
	public String getPersFirstName() {
		return persFirstName;
	}
	
	public void setPersFirstName(String persFirstName) {
		this.persFirstName = persFirstName;
	}
	
	public String getPersLastName() {
		return persLastName;
	}
	
	public void setPersLastName(String persLastName) {
		this.persLastName = persLastName;
	}

	public int getStageID() {
		return stageID;
	}


	public void setStageID(int stageID) {
		this.stageID = stageID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double size) {
		this.size = size;
	}
	
	public String getBandName() {
		return bandName;
	}
	
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	
	public void setPerformanceStart(Timestamp performanceStart) {
		this.performanceStart = performanceStart;
	}
	
	public Timestamp getPerformanceStart() {
		return performanceStart;
	}
	
	public void setPerformanceEnd(Timestamp performanceEnd) {
		this.performanceEnd = performanceEnd;
	}
	
	public Timestamp getPerformanceEnd() {
		return performanceEnd;
	}

	
}
