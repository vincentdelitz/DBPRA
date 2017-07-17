package de.tum.in.dbpra.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import de.tum.in.dbpra.model.bean.ShiftBean;

public class ShiftDAO extends DAO {
		
	public void getShiftByName(ArrayList <ShiftBean> shiftList, String firstname, String lastname) throws SQLException, ClassNotFoundException, EmployeeNotFoundException, SeveralEmployeesFoundException{
		
		String query1 = "SELECT p.personID FROM employee e JOIN person p ON e.employeeID = p.personID WHERE p.firstname = ? and p.lastname = ?;";
		String query2 = "SELECT s.* FROM shift s JOIN person p ON s.employeeID = p.personID WHERE p.firstname = ? and p.lastname = ?;";
		
		Connection con = getConnection();

		PreparedStatement pstmt1 = con.prepareStatement(query1);
		PreparedStatement pstmt2 = con.prepareStatement(query2);

		pstmt1.setString(1, firstname);
		pstmt1.setString(2, lastname);

		ResultSet rs1 = pstmt1.executeQuery();

		int size = 0;
		while (rs1.next()) {
			size++;
		}
		
		if (size == 0) {
			throw new EmployeeNotFoundException("error1");
		} else if (size > 1) {
			throw new SeveralEmployeesFoundException("error2");
		} else {
			pstmt2.setString(1, firstname);
			pstmt2.setString(2, lastname);
			ResultSet rs2 = pstmt2.executeQuery();
			
			while (rs2.next()){
				ShiftBean shift = new ShiftBean();
				shift.setEmployeeID(rs2.getInt("employeeID"));
				shift.setAreaID(rs2.getInt("areaID"));
				shift.setStarttime(rs2.getTimestamp("starttime"));
				shift.setEndtime(rs2.getTimestamp("endtime"));
				shift.setAdditionInfo(rs2.getString("additionInfo"));
				shiftList.add(shift);
			}

			rs2.close();
			pstmt2.close();
		}

		rs1.close();
		pstmt1.close();
		con.close();

	}

	public void getShiftByID(ArrayList <ShiftBean> shiftList, int ID, String firstname, String lastname) throws SQLException, ClassNotFoundException, EmployeeNotFoundException {
		String query = "SELECT s.* " +
				"FROM employee e, person p, shift s " +
				"WHERE e.employeeID = p.personID AND e.employeeID = s.employeeID " +
				"AND e.employeeID = ? AND p.firstname = ? AND p.lastname = ?;";
		
		Connection con = getConnection();

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ID);
		pstmt.setString(2, firstname);
		pstmt.setString(3, lastname);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			ShiftBean shift = new ShiftBean();
			shift.setEmployeeID(rs.getInt("employeeID"));
			shift.setAreaID(rs.getInt("areaID"));
			shift.setStarttime(rs.getTimestamp("starttime"));
			shift.setEndtime(rs.getTimestamp("endtime"));
			shift.setAdditionInfo(rs.getString("additionInfo"));
			shiftList.add(shift);
		} else {
			throw new EmployeeNotFoundException("error3");
		}
		
		rs.close();
		pstmt.close();
		con.close();
	}
	
	
	public static class EmployeeNotFoundException extends Throwable {
		private static final long serialVersionUID = 1L;
		EmployeeNotFoundException(String message){
			super(message);
		}
	}
	public static class SeveralEmployeesFoundException extends Throwable {
		private static final long serialVersionUID = 1L;
		SeveralEmployeesFoundException(String message){
			super(message);
		}
	}


}

