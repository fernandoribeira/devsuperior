package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Db;
import exception.DbStandardException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
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
			throw new DbStandardException(e.getMessage());
		} finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
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
				Seller seller = instantiateSeller(rs, d);
				list.add(seller);
			}
			return list;
		} catch (SQLException e) {
			throw new DbStandardException(e.getMessage());
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
				rs.getDate("Birthdate"),
				rs.getDouble("BaseSalary"),
				department);
		return seller;
	}

}
