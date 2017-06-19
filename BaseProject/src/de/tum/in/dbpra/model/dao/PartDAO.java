package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.OrderBean;
import de.tum.in.dbpra.model.bean.OrderListBean;
import de.tum.in.dbpra.model.bean.PartBean;
import de.tum.in.dbpra.model.bean.PartListBean;

public class PartDAO extends DAO{
	
	public void getParts(PartListBean partlist) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM part ORDER BY name ASC";	
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PartBean part = new PartBean();
			part.setPartkey(rs.getInt("partkey"));
			part.setName(rs.getString("name"));
			part.setSize(rs.getInt("size"));
			part.setContainer(rs.getInt("container"));
			part.setRetailprice(rs.getInt("retailprice"));
			partlist.setChild(part);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
public void getPartsSearch(PartListBean partlist, String column, String matchType, String searchparam) throws SQLException, ClassNotFoundException {
		
		String query = "SELECT * FROM part WHERE " +column+ " " +matchType+ " ? ORDER BY name ASC";	
		
		if(matchType.equals("like")) {
			query = "SELECT *, CASE WHEN \"" +column+ "\" IN (SELECT \"" +column+ "\" FROM part WHERE \"" +column+ "\" LIKE '%?%') THEN 1 ELSE 0 END AS \"match\" FROM part";
		} else {
			query = "SELECT *, CASE WHEN \"" +column+ "\" IN (SELECT \"" +column+ "\" FROM part WHERE \"" +column+ "\" = ?) THEN 1 ELSE 0 END AS \"match\" FROM part";
		}
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		if(column.equals("partkey")) {
			pstmt.setInt(1, Integer.parseInt(searchparam));
		} else if(column.equals("name")) {
			pstmt.setString(1, searchparam);
		} else if(column.equals("type")) {
			pstmt.setString(1, searchparam);
		} else if(column.equals("size")) {
			pstmt.setInt(1, Integer.parseInt(searchparam));
		} else if(column.equals("container")) {
			pstmt.setInt(1, Integer.parseInt(searchparam));
		} /*else if(column.equals("retailprice")) {
			pstmt.setDouble(1, part.getRetailprice());
		}*/
		
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PartBean part = new PartBean();
			part.setPartkey(rs.getInt("partkey"));
			part.setName(rs.getString("name"));
			part.setType(rs.getString("type"));
			part.setSize(rs.getInt("size"));
			part.setContainer(rs.getInt("container"));
			part.setRetailprice(rs.getInt("retailprice"));
			part.setMatch(rs.getInt("match"));
			partlist.setChild(part);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
}
