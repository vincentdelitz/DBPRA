package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.dao.ProductDAO.ProductExistsException;

public class OfferDAO extends DAO {

	public void insertOffer(int productID, int shopID, int quantity) throws SQLException, ClassNotFoundException, OfferExistsException, ShopNotExistsException {

		String query2 = "SELECT * FROM shop WHERE shopID = ?;";
		String query1 = "SELECT * FROM offer WHERE productID = ? AND shopID = ?;";
		String query = "INSERT INTO offer (productID, shopID, quantity) VALUES (?,?,?);";	
		
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement pstmt2 = con.prepareStatement(query2);		
		pstmt2.setInt(1, shopID);
		ResultSet rs2 = pstmt2.executeQuery();
		
		if (!rs2.next()){
			throw new ShopNotExistsException("error1");
		} else {
		
			PreparedStatement pstmt1 = con.prepareStatement(query1);		
			pstmt1.setInt(1, productID);
			pstmt1.setInt(2, shopID);
			
			ResultSet rs = pstmt1.executeQuery();
			
			if (rs.next()){
				throw new OfferExistsException("error2");
			} else {
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1, productID);
				pstmt.setInt(2, shopID);
				pstmt.setInt(3, quantity);
				
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
			}
			rs.close();
			pstmt1.close();
		}
		rs2.close();
		pstmt2.close();
		con.close();

	}
	
	public void insertOffer2(Connection con, int productID, int shopID, int quantity) throws SQLException, ClassNotFoundException, OfferExistsException, ShopNotExistsException {

		String query2 = "SELECT * FROM shop WHERE shopID = ?;";
		String query1 = "SELECT * FROM offer WHERE productID = ? AND shopID = ?;";
		String query = "INSERT INTO offer (productID, shopID, quantity) VALUES (?,?,?);";	
		
		PreparedStatement pstmt2 = con.prepareStatement(query2);		
		pstmt2.setInt(1, shopID);
		ResultSet rs2 = pstmt2.executeQuery();
		
		if (!rs2.next()){
			throw new ShopNotExistsException("error1");
		} else {
		
			PreparedStatement pstmt1 = con.prepareStatement(query1);		
			pstmt1.setInt(1, productID);
			pstmt1.setInt(2, shopID);
			
			ResultSet rs = pstmt1.executeQuery();
			
			if (rs.next()){
				throw new OfferExistsException("error2");
			} else {
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1, productID);
				pstmt.setInt(2, shopID);
				pstmt.setInt(3, quantity);
				
				pstmt.executeUpdate();
				
				pstmt.close();
			}
			rs.close();
			pstmt1.close();
		}
		rs2.close();
		pstmt2.close();

	}
	
	public static class OfferExistsException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		OfferExistsException(String message){
			super(message);
		}
	}
	
	
	public static class ShopNotExistsException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		ShopNotExistsException(String message){
			super(message);
		}
	}
}
