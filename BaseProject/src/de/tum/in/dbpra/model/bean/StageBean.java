package de.tum.in.dbpra.model.bean;

public class StageBean {
	private String persID;
	private String persFirstName;
	private String persLastName;
	private int stageID;
	private String name;
	private double size;
	private String performanceStart;
	private String performanceEnd;

	
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
	
	public void setPerformanceStart(String performanceStart) {
		this.performanceStart = performanceStart;
	}
	
	public String getPerformanceStart() {
		return performanceStart;
	}
	
	public void setPerformanceEnd(String performanceEnd) {
		this.performanceEnd = performanceEnd;
	}
	
	public String getPerformanceEnd() {
		return performanceEnd;
	}

	
}
