package de.tum.in.dbpra.model.dao;

import java.sql.*;
import java.util.ArrayList;

import de.tum.in.dbpra.model.bean.OfferProductBean;

public class OfferProductDAO extends DAO {
	public ArrayList<OfferProductBean> getOffer(String pname)
			throws ClassNotFoundException, SQLException, OffersNotFoundException {
		String query = "SELECT area.areaID, areaname, shop.shopID, quantity, product.productID, name, product.price FROM offer join shop on(shop.shopID=offer.shopID) join product on "
				+ "(product.productID=offer.productID) join area on (area.areaID=shop.areaID) where lower(name) like lower('"+pname+"');";

		//execute query
		Connection con = getConnection();
		con.setAutoCommit(false);
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		ArrayList<OfferProductBean> offers = new ArrayList<OfferProductBean>();

		int count = 0;
		
		//fill offerBean
		while (rs.next()) {
			OfferProductBean p = new OfferProductBean();
			p.setPname(rs.getString("name"));
			p.setProductID(rs.getInt("productID"));
			p.setAreaID(rs.getInt("areaID"));
			p.setQuantity(rs.getInt("quantity"));
			p.setPrice(rs.getDouble("price"));
			p.setAreaname(rs.getString("areaname"));
			p.setShopID(rs.getInt("shopID"));
			offers.add(p);
			count++;
		}
		//if count=0, there is no result in the result set.
		//So we consider it as an exception and rollback the transaction
		if (count == 0) {
			rs.close();
			pstmt.close();
			con.rollback();
			con.close();
			throw new OffersNotFoundException("There is no offer for "+pname+"!");

		} 
		//otherwise commit it
		else {
			count=0;
			for(int i=0;i<offers.size();i++) {
				if(offers.get(i).getQuantity()==0) {
					count++;
				}
			}
			if(count==offers.size()) {
				throw new OffersNotFoundException(pname + " is sold out!");
			}
			rs.close();
			pstmt.close();
			con.commit();
			con.close();
		}
		return offers;
	}

	public static class OffersNotFoundException extends Throwable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		OffersNotFoundException(String message) {
			super(message);
		}
	}
}