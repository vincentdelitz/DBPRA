package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import de.tum.in.dbpra.model.dao.OfferDAO.OfferExistsException;
import de.tum.in.dbpra.model.dao.OfferDAO.ShopNotExistsException;
import de.tum.in.dbpra.model.dao.ProductDAO.ProductExistsException;

public class SuperDAO extends DAO {
	public void insertProductAndOffer (int quantity, int shopID, String name, String type, double price) throws ClassNotFoundException, SQLException, ProductExistsException, OfferExistsException, ShopNotExistsException {
		
		Connection con = getConnection();
		con.setAutoCommit(false);
		try {
			ProductDAO product = new ProductDAO();
			int productID = product.insertProduct(con, name, type, price);
			
			OfferDAO offer = new OfferDAO();
			offer.insertOffer2(con, productID, shopID, quantity);
		} catch (Throwable e) {
			con.rollback();
			throw e;
		}
		con.commit();
		con.close();
	}
	
}
