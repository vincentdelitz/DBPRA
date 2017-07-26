package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.LocationBean;

public class LocationDAO extends DAO {
  public void getShopDetails(ArrayList<LocationBean> locations, int product_id, int shop_id) throws ClassNotFoundException, SQLException {
    String query = "SELECT name, shoptype, offer.shopid, areaname, area.areaid, type FROM product " +
      "JOIN offer ON product.productid = offer.productid " +
      "JOIN shop ON offer.shopid = shop.shopid " +
      "JOIN area ON shop.areaid = area.areaid " +
      "WHERE product.productid = ? AND shop.shopid = ?";
    
    Connection con = getConnection();
	con.setAutoCommit(false);

    PreparedStatement pstmt = con.prepareStatement(query);
    pstmt.setInt(1, product_id);
    pstmt.setInt(2, shop_id);
    
    ResultSet rs = pstmt.executeQuery();
    
    while(rs.next()) {
      LocationBean location = new LocationBean();
      location.setProductName(rs.getString("name"));
      location.setShopType(rs.getString("shoptype"));
      location.setAreaID(rs.getInt("areaid"));
      location.setAreaName(rs.getString("areaname"));
      location.setAreaType(rs.getString("type"));
      location.setShopID(rs.getInt("shopid"));
      locations.add(location);
    }
    
    con.commit();
    rs.close();
    pstmt.close();
    con.close();
  }
}