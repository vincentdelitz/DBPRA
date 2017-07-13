package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.ProductListBean;

public class ProductDAO extends DAO{
	
	public void getProducts(ProductListBean productlist) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT productID, name, type, price" +
				" FROM product ORDER BY name ASC";	
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductBean product = new ProductBean();
			product.setProductID(rs.getInt("productid"));
			product.setName(rs.getString("name"));
			product.setType(rs.getString("type"));
			product.setPrice(rs.getDouble("price"));
			productlist.setChild(product);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
}
