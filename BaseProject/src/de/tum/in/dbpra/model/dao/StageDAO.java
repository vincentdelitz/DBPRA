package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.tum.in.dbpra.model.bean.StageBean;
import de.tum.in.dbpra.model.bean.StageListBean;

public class StageDAO extends DAO {

	public void getPersonalStages(StageListBean stagelist, String visitorid) throws SQLException, ClassNotFoundException {

		
		String query = "SELECT DISTINCT person.personID, person.firstname, person.lastname, stage.stageNr, stage.stagename, stage.size, band.bandName, band.performanceStart, band.performanceEnd"
				+ " FROM stage INNER JOIN lineup"
				+ " ON stage.stageNr = lineup.stageNr INNER JOIN band ON lineup.bandID = band.bandID"
				+ " INNER JOIN timetable ON timetable.bandID = band.bandID INNER JOIN visitor"
				+ " ON timetable.visitorID = visitor.visitorID INNER JOIN Person ON visitor.visitorID = person.personID"
				+ " WHERE person.personid = ?"
				+ " ORDER BY person.personID, stage.stageNr, band.performanceStart;";

		Connection con = getConnection();
		// con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement(query);
		
		/*if(firstname.equals("")||firstname.equals(null)){
			throw new SQLException("Please enter a first name");
		}
		
		if(lastname.equals("")||lastname.equals(null)){
			throw new SQLException("Please enter a last name");
		}*/
		
		pstmt.setInt(1, Integer.parseInt(visitorid));

		ResultSet rs = pstmt.executeQuery();

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
		}

		// con.commit();
		rs.close();
		pstmt.close();
		con.close();

	}

}
