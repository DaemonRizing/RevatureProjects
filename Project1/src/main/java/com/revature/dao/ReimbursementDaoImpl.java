package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	private static Logger log = Logger.getRootLogger(); 

	@Override
	public List<Reimbursement> getReimbursement() {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT";

		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)) {

			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				int requestId = rs.getInt("REQUEST_ID");
				r.setId(requestId);

				int managerId = rs.getInt("MANAGER_ID");
				r.setManagerId(managerId);

				int empId = rs.getInt("EMP_ID");
				r.setEmpId(empId);

				int status = rs.getInt("STATUS");
				r.setStatus(status);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String description = rs.getString("DESCRIPTION");
				r.setDescription(description);	

				reimbursementList.add(r);
			}

		} catch ( SQLException e) {
			log.error(e.getMessage());
		} 

		return reimbursementList;
	}

	@Override
	public int createReimbursement(Reimbursement reimbursement) {
		int requestCreated = 0;
		String sql = "INSERT INTO REIMBURSEMENT (EMP_ID, AMOUNT, STATUS, MANAGER_ID, DESCRIPTION) VALUES(?, ?, ?, ?, ?)";

		try (Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement cs = con.prepareStatement(sql);) {
			
		
			cs.setInt(1, reimbursement.getEmpId());
			cs.setDouble(2, reimbursement.getAmount());
			cs.setInt(3, reimbursement.getStatus());
			cs.setInt(4, reimbursement.getManagerId());
			cs.setString(5, reimbursement.getDescription());
			cs.execute();
			requestCreated = 1;
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return requestCreated;
	}

	@Override
	public List<Reimbursement> getReimbursementByEmployeeId(int id) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE EMP_ID = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setInt(1, id);
				
				rs = ps.executeQuery(); 

			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				int requestId = rs.getInt("REQUEST_ID");
				r.setId(requestId);

				int managerId = rs.getInt("MANAGER_ID");
				r.setManagerId(managerId);

				int empId = rs.getInt("EMP_ID");
				r.setEmpId(empId);

				int status = rs.getInt("STATUS");
				r.setStatus(status);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String description = rs.getString("DESCRIPTION");
				r.setDescription(description);	

				reimbursementList.add(r);
				System.out.println("Checking ReimbursementDaoIml");
				System.out.println(r.toString());
			}

		} catch ( SQLException e) {
			log.error(e.getMessage());
		} 

		return reimbursementList;
	}

	@Override
	public int updateReimbursement(Reimbursement reimbursement) {
		int reqUpdated = 0;
		
		String sql = "UPDATE REIMBURSEMENT" 
				+ " SET STATUS = ?,"
				+ " MANAGER_ID = ?"
				+ " WHERE REQUEST_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
	
			ps.setInt(1, reimbursement.getStatus());
			ps.setInt(2, reimbursement.getManagerId());
			ps.setInt(3, reimbursement.getId());
			
			reqUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		
		return reqUpdated;
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(int status) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setInt(1, status);
				
				rs = ps.executeQuery(); 

			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				int requestId = rs.getInt("REQUEST_ID");
				r.setId(requestId);

				int managerId = rs.getInt("MANAGER_ID");
				r.setManagerId(managerId);

				int empId = rs.getInt("EMP_ID");
				r.setEmpId(empId);

				int stat = rs.getInt("STATUS");
				r.setStatus(stat);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String description = rs.getString("DESCRIPTION");
				r.setDescription(description);	

				reimbursementList.add(r);
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		} 

		return reimbursementList;
	}
	

	@Override
	public List<Reimbursement> getReimbursementByManagerId(int id) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE MANAGER_ID = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setInt(1, id);
				
				rs = ps.executeQuery(); 

			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				int requestId = rs.getInt("REQUEST_ID");
				r.setId(requestId);

				int managerId = rs.getInt("MANAGER_ID");
				r.setManagerId(managerId);

				int empId = rs.getInt("EMP_ID");
				r.setEmpId(empId);

				int status = rs.getInt("STATUS");
				r.setStatus(status);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String description = rs.getString("DESCRIPTION");
				r.setDescription(description);	

				reimbursementList.add(r);
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		} 

		return reimbursementList;
	}

	@Override
	public List<Reimbursement> getReimbursementById(int id) {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUEST_ID = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setInt(1, id);
				
				rs = ps.executeQuery(); 

			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				int requestId = rs.getInt("REQUEST_ID");
				r.setId(requestId);

				int managerId = rs.getInt("MANAGER_ID");
				r.setManagerId(managerId);

				int empId = rs.getInt("EMP_ID");
				r.setEmpId(empId);

				int status = rs.getInt("STATUS");
				r.setStatus(status);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String description = rs.getString("DESCRIPTION");
				r.setDescription(description);	

				reimbursementList.add(r);
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		} 

		return reimbursementList;
	}


}
