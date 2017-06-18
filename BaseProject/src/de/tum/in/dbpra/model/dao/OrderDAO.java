package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.bean.OrderListBean;

public class OrderDAO extends DAO{
	public void getOkOrders(OrderListBean orderlist) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM orders WHERE orderstatus = 'ok';";
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			OrderBean order = new OrderBean();
			order.setOrderkey(rs.getInt("orderkey"));
			order.setCustkey(rs.getInt("custkey"));
			order.setOrderstatus(rs.getString("orderstatus"));
			order.setTotalprice(rs.getDouble("totalprice"));
			order.setOrderdate(rs.getString("orderdate"));
			orderlist.setChild(order);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	public void getNoOrders(OrderListBean orderlist) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM orders WHERE orderstatus = 'no';";
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			OrderBean order = new OrderBean();
			order.setCustkey(rs.getInt("custkey"));
			order.setOrderstatus(rs.getString("orderstatus"));
			order.setTotalprice(rs.getDouble("totalprice"));
			order.setOrderdate(rs.getString("orderdate"));
			orderlist.setChild(order);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
}
