package de.tum.in.dbpra.model.bean;

public class LocationBean {
  public LocationBean() {}

  private String name;
  private String type;
  private String shoptype;
  private String areaname;
  
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public String getType() {return type;}
  public void setType(String type) {this.type = type;}

  public int getAreaName() {return areaname;}
  public void setAreaName(int size) {this.areaname = areaname;}
  
  public int getShopType() {return shoptype;}
  public void setShopType(int container) {this.shoptype = shoptype;}
  
}
