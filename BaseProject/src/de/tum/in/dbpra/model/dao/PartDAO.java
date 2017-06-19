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
		
		String query = "SELECT partkey, COALESCE(name, \"\") AS name, COALESCE(\"type\", \"\") AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice" +
				" FROM part ORDER BY name ASC";	
		
		Connection con = getConnection();
		
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PartBean part = new PartBean();
			part.setPartkey(rs.getInt("partkey"));
			part.setName(rs.getString("name"));
			part.setSize(rs.getInt("size"));
			part.setContainer(rs.getInt("container"));
			part.setRetailprice(rs.getDouble("retailprice"));
			partlist.setChild(part);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
	
public void getPartsSearch(PartListBean partlist, String column, String matchType, String searchparam, String orderparam) throws SQLException, ClassNotFoundException {
		
		if(orderparam==null) {
			orderparam = "partkey";
		} else if(!orderparam.equals("partkey")) {
			orderparam += " ,partkey";
		}
	
		String query = "SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice" +
				", 0 AS \"match\" FROM part ORDER BY " +orderparam;
		boolean correctsearch = true;
		boolean likesearch = false;
		
		if(column!=null) {
			if(!(column.equals("name") || column.equals("type"))) {
				matchType = "exact";
			}
		}
	
		if(column==null || matchType==null || searchparam==null) {
			query = "SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice" +
					", 0 AS \"match\" FROM part ORDER BY " +orderparam;
			correctsearch = false;
		} else if(matchType.equals("like")) {
			query = "SELECT * " +
					", CASE WHEN \"" +column+ "\" IN (SELECT \"" +column+ "\" FROM (SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice FROM part) TMP1 WHERE \"" +column+ "\" LIKE ?) THEN 1 ELSE 0 END AS \"match\" " +
							"FROM (SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice FROM part) TMP2 ORDER BY " +orderparam;
			
			/*query = "SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice" +
					", CASE WHEN \"" +column+ "\" IN (SELECT \"" +column+ "\" FROM part WHERE \"" +column+ "\" LIKE ?) THEN 1 ELSE 0 END AS \"match\" FROM part ORDER BY " +orderparam;*/
			likesearch = true;
		} else {
			query = "SELECT * " +
					", CASE WHEN \"" +column+ "\" IN (SELECT \"" +column+ "\" FROM (SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice FROM part) TMP1 WHERE \"" +column+ "\" = ?) THEN 1 ELSE 0 END AS \"match\" " +
							"FROM (SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice FROM part) TMP2 ORDER BY " +orderparam;
			
			/*query = "SELECT partkey, COALESCE(name, '') AS name, COALESCE(\"type\", '') AS \"type\", COALESCE(size, 0) AS size, COALESCE(container, 0) AS container, COALESCE(retailprice, 0.0) AS retailprice" +
					", CASE WHEN \"" +column+ "\" IN (SELECT \"" +column+ "\" FROM part WHERE \"" +column+ "\" = ?) THEN 1 ELSE 0 END AS \"match\" FROM part ORDER BY " +orderparam;*/
		}
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		try {
			if(correctsearch && likesearch) {
				if(column.equals("partkey")) {
					pstmt.setInt(1, Integer.parseInt(searchparam));
				} else if(column.equals("name")) {
					pstmt.setString(1, "%" +searchparam+ "%");
				} else if(column.equals("type")) {
					pstmt.setString(1, "%" +searchparam+ "%");
				} else if(column.equals("size")) {
					pstmt.setInt(1, Integer.parseInt(searchparam));
				} else if(column.equals("container")) {
					pstmt.setInt(1, Integer.parseInt(searchparam));
				} else if(column.equals("retailprice")) {
					pstmt.setDouble(1, Double.parseDouble(searchparam));
				}
			} else if(correctsearch) {
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
				} else if(column.equals("retailprice")) {
					pstmt.setDouble(1, Double.parseDouble(searchparam));
				}
			}
		} catch(Exception e) {
			query = "SELECT *, 0 AS \"match\" FROM part ORDER BY " +orderparam;
			con = getConnection();
			pstmt = con.prepareStatement(query);
		}

		
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PartBean part = new PartBean();
			part.setPartkey(rs.getInt("partkey"));
			part.setName(rs.getString("name"));
			part.setType(rs.getString("type"));
			part.setSize(rs.getInt("size"));
			part.setContainer(rs.getInt("container"));
			part.setRetailprice(rs.getDouble("retailprice"));
			part.setMatch(rs.getInt("match"));
			partlist.setChild(part);
		} 
		
		con.commit();
		rs.close();
		pstmt.close();
		con.close();
		
	}
	
}
