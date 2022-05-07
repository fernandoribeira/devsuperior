package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Db;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn = null;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
					System.out.println("New seller Id: " + id + " created with success!");
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException eRollback) {
					throw new DbException(eRollback.getMessage());
				}
				throw new DbException("No seller created!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException eRollback) {
				throw new DbException(eRollback.getMessage());
			}
			throw new DbException(e.getMessage());
		} finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
		}
	}

	@Override
	public void update(Seller obj) {
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
					+ "WHERE Id = ?");
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			st.setInt(6, obj.getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				System.out.println("Seller Id: " + obj.getId() + " updated with success!");
			} else {
				try {
					conn.rollback();
				} catch (SQLException eRollback) {
					throw new DbException(eRollback.getMessage());
				}
				throw new DbException("No seller updated!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException eRollback) {
				throw new DbException(eRollback.getMessage());
			}
			throw new DbException(e.getMessage());
		} finally {
			Db.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				System.out.println("Seller Id: " + id + " deleted with success!");
			} else {
				try {
					conn.rollback();
				} catch (SQLException eRollback) {
					throw new DbException(eRollback.getMessage());
				}
				throw new DbException("No seller deleted!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException eRollback) {
				throw new DbException(eRollback.getMessage());
			}
			throw new DbException(e.getMessage());
		} finally {
			Db.closeStatement(st);
		}
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepartmentName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department d = instantiateDepartment(rs);
				Seller s = instantiateSeller(rs, d);
				return s;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepartmentName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			rs = st.executeQuery();
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			while (rs.next()) {
				Department d;
				d = map.get(rs.getInt("DepartmentId"));
				if (d == null) {
					d = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), d);
				}
				Seller s = instantiateSeller(rs, d);
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
		}
	}
	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepartmentName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			while (rs.next()) {
				Department d;
				d = map.get(rs.getInt("DepartmentId"));
				if (d == null) {
					d = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), d);
				}		
				Seller s = instantiateSeller(rs, d);
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
		}
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department(
				rs.getInt("DepartmentId"),
				rs.getString("DepartmentName"));
		return department;
	}
	
	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller(
				rs.getInt("Id"),
				rs.getString("Name"),
				rs.getString("Email"),
				new java.util.Date(rs.getTimestamp("BirthDate").getTime()),
				rs.getDouble("BaseSalary"),
				department);
		return seller;
	}

}
