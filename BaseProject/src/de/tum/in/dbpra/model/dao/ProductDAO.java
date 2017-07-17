package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.ProductBean;
import de.tum.in.dbpra.model.bean.ProductListBean;

public class ProductDAO extends DAO {
	
	public void getProducts(ProductListBean productlist) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM product ORDER BY name ASC;";	
		
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductBean product = new ProductBean();
			product.setProductID(rs.getInt("productid"));
			product.setName(rs.getString("name"));
			product.setType(rs.getString("producttype"));
			product.setPrice(rs.getDouble("price"));
			productlist.setChild(product);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public void getProductsForShop(ProductListBean productlist, int shopID) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT p.* FROM product p JOIN offer o ON p.productID = o.productID WHERE o.shopID = ? ORDER BY name ASC;";	
		
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, shopID);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductBean product = new ProductBean();
			product.setProductID(rs.getInt("productid"));
			product.setName(rs.getString("name"));
			product.setType(rs.getString("producttype"));
			product.setPrice(rs.getDouble("price"));
			productlist.setChild(product);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}

	
	public int insertProduct(Connection con, String name, String type, double price)throws SQLException, ClassNotFoundException, ProductExistsException {
		
		String query = "INSERT INTO product (name,producttype,price) VALUES (?,?::\"producttype\",?);";	
		String query2 = "SELECT productID FROM product WHERE name = ? AND producttype = ?::\"producttype\" and price = ?;";	

		
		PreparedStatement pstmt = con.prepareStatement(query);
		PreparedStatement pstmt2 = con.prepareStatement(query2);
		
		pstmt2.setString(1, name);
		pstmt2.setString(2, type);
		pstmt2.setDouble(3, price);

		ResultSet rs = 	pstmt2.executeQuery();
		
		if (rs.next()){
			throw new ProductExistsException("The Product " + name + " you want to insert does already exist!");
		} else {
		
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			pstmt.setDouble(3, price);
			
			pstmt.executeUpdate();
			
			pstmt2.setString(1, name);
			pstmt2.setString(2, type);
			pstmt2.setDouble(3, price);

			ResultSet rs2 = pstmt2.executeQuery();
			
			rs2.next();
			int productID = rs2.getInt("productID");


			rs.close();
			rs2.close();
			pstmt.close();
			pstmt2.close();
			return productID;
		}
	}
	
		public static class ProductExistsException extends Throwable {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			ProductExistsException(String message){
				super(message);
			}
		}
}
