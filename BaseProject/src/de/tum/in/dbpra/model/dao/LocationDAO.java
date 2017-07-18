package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.LocationBean;

public class LocationDAO extends DAO {
  public void getShopDetails(ArrayList<LocationBean> locations, int product_id, int shop_id) throws ClassNotFoundException, SQLException {
    String query = "SELECT name, shoptype, areaname, type FROM product " +
      "JOIN offer ON product.productid = offer.productid " +
      "JOIN shop ON offer.shopid = shop.shopid " +
      "JOIN area ON shop.areaid = area.areaid " +
      "WHERE product.productid = ? AND shop.shopid = ?";
    
    Connection con = getConnection();
    PreparedStatement pstmt = con.prepareStatement(query);
    pstmt.setInt(1, product_id);
    pstmt.setInt(2, shop_id);
    
    ResultSet rs = pstmt.executeQuery();
    
    while(rs.next()) {
      LocationBean location = new LocationBean();
      location.setName(rs.getString("name"));
      location.setShopType(rs.getString("shoptype"));
      location.setAreaName(rs.getString("areaname"));
      location.setType(rs.getString("type"));
      locations.add(location);
    }
    
    rs.close();
    pstmt.close();
    con.close();
  }
}
