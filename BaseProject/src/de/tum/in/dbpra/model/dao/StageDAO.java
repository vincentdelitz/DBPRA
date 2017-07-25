package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;

public class StageDAO extends DAO {

	public void getPersonalStages(StageListBean stagelist, String firstname, String lastname) throws SQLException, ClassNotFoundException, VisitorNotFoundException, SeveralVisitorsFouncException {

		String query1 = "SELECT count(*) as count FROM visitor v JOIN person p ON v.visitorID = p.personID WHERE firstname = ? AND lastname = ?;";

		String query2 = "SELECT DISTINCT person.personID, person.firstname, person.lastname, stage.stageNr, stage.stagename, stage.size, band.bandName, band.performanceStart, band.performanceEnd"
				+ " FROM stage INNER JOIN lineup"
				+ " ON stage.stageNr = lineup.stageNr INNER JOIN band ON lineup.bandID = band.bandID"
				+ " INNER JOIN timetable ON timetable.bandID = band.bandID INNER JOIN visitor"
				+ " ON timetable.visitorID = visitor.visitorID INNER JOIN Person ON visitor.visitorID = person.personID"
				+ " WHERE person.firstname = ? AND person.lastname = ?"
				+ " ORDER BY person.personID, stage.stageNr, band.performanceStart;";

		Connection con = getConnection();
		 con.setAutoCommit(false);

		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, firstname);
		pstmt1.setString(2, lastname);

		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		int number = rs1.getInt("count");
		
		if (number == 0){
			con.rollback();
			rs1.close();
			pstmt1.close();
			throw new VisitorNotFoundException("error1");
		} else if (number > 1) {
			con.rollback();
			rs1.close();
			pstmt1.close();
			throw new SeveralVisitorsFouncException("error2");
		} else {
			PreparedStatement pstmt2 = con.prepareStatement(query2);
			pstmt2.setString(1, firstname);
			pstmt2.setString(2, lastname);
			ResultSet rs2 = pstmt2.executeQuery();

			while (rs2.next()) {
				StageBean stage = new StageBean();
				stage.setPersID(rs2.getString("personID"));
				stage.setPersFirstName(rs2.getString("firstname"));
				stage.setPersLastName(rs2.getString("lastname"));
				stage.setStageID(rs2.getInt("stagenr"));
				stage.setName(rs2.getString("stagename"));
				stage.setSize(rs2.getDouble("size"));
				stage.setBandName(rs2.getString("bandName"));
				stage.setPerformanceStart(rs2.getTimestamp("performanceStart"));
				stage.setPerformanceEnd(rs2.getTimestamp("performanceEnd"));
				stagelist.setChild(stage);
			}
			rs2.close();
			pstmt2.close();
			
		}

		con.commit();
		rs1.close();
		pstmt1.close();
		con.close();

	}
	
	public void getPersonalStagesByID(StageListBean stagelist, String firstname, String lastname, int ticketID) throws SQLException, ClassNotFoundException, VisitorNotFoundException, SeveralVisitorsFouncException {


		String query = "SELECT DISTINCT person.personID, person.firstname, person.lastname, stage.stageNr, stage.stagename, stage.size, band.bandName, band.performanceStart, band.performanceEnd"
				+ " FROM stage INNER JOIN lineup"
				+ " ON stage.stageNr = lineup.stageNr INNER JOIN band ON lineup.bandID = band.bandID"
				+ " INNER JOIN timetable ON timetable.bandID = band.bandID INNER JOIN visitor"
				+ " ON timetable.visitorID = visitor.visitorID INNER JOIN Person ON visitor.visitorID = person.personID"
				+ " WHERE person.firstname = ? AND person.lastname = ? AND visitor.ticketid = ?"
				+ " ORDER BY person.personID, stage.stageNr, band.performanceStart;";

		Connection con = getConnection();

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, firstname);
		pstmt.setString(2, lastname);
		pstmt.setInt(3, ticketID);

		ResultSet rs = pstmt.executeQuery();
		
		int count = 0;
		while (rs.next()) {
			StageBean stage = new StageBean();
			stage.setPersID(rs.getString("personID"));
			stage.setPersFirstName(rs.getString("firstname"));
			stage.setPersLastName(rs.getString("lastname"));
			stage.setStageID(rs.getInt("stagenr"));
			stage.setName(rs.getString("stagename"));
			stage.setSize(rs.getDouble("size"));
			stage.setBandName(rs.getString("bandName"));
			stage.setPerformanceStart(rs.getTimestamp("performanceStart"));
			stage.setPerformanceEnd(rs.getTimestamp("performanceEnd"));
			stagelist.setChild(stage);
			count ++;
		} 
		
		if (count == 0) {
			throw new VisitorNotFoundException("error3");
		}

		rs.close();
		pstmt.close();
		con.close();

	}
	
	public static class VisitorNotFoundException extends Throwable {
		private static final long serialVersionUID = 1L;
		VisitorNotFoundException(String message){
			super(message);
		}
	}
	public static class SeveralVisitorsFouncException extends Throwable {
		private static final long serialVersionUID = 1L;
		SeveralVisitorsFouncException(String message){
			super(message);
		}
	}

}
