package de.tum.in.dbpra.model.bean;

public class LocationBean {
  public LocationBean() {}

  private String name;
  private String type;
  private int shopID;
  private String shoptype;
  private String areaname;
  
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public String getType() {return type;}
  public void setType(String type) {this.type = type;}

  public String getAreaName() {return areaname;}
  public void setAreaName(String areaname) {this.areaname = areaname;}
  
  public String getShopType() {return shoptype;}
  public void setShopType(String shoptype) {this.shoptype = shoptype;}
  
  public int getShopID() {return shopID; }
  public void setShopID(int shopID) {this.shopID = shopID;}
  
}
