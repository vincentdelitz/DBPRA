package de.tum.in.dbpra.model.dao;

import de.tum.in.dbpra.model.bean.CustomerBean;

public class OrderDAO extends DAO{
	public void getOkOrders(OrderBean order) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM orders WHERE status = 'ok';";
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			order.setCustkey(rs.getInteger("custkey"));
			order.setOrderstatus(rs.getString("orderstatus"));
			order.setTotalprice(rs.getDouble("totalprice"));
			order.setOrderdate(rs.getString("orderdate"));
		} else {
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public void getNoOrders(OrderBean order) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM orders WHERE status = 'No';";
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			order.setCustkey(rs.getInteger("custkey"));
			order.setOrderstatus(rs.getString("orderstatus"));
			order.setTotalprice(rs.getDouble("totalprice"));
			order.setOrderdate(rs.getString("orderdate"));
		} else {
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
}
