package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Db;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
					System.out.println("New departement Id: " + id + " created with success!");
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException eRollback) {
					throw new DbException(eRollback.getMessage());
				}
				throw new DbException("No department created!");
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
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				System.out.println("Department Id: " + obj.getId() + " updated with success!");
			} else {
				try {
					conn.rollback();
				} catch (SQLException eRollback) {
					throw new DbException(eRollback.getMessage());
				}
				throw new DbException("No department updated!");
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
			st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				System.out.println("Department Id: " + id + " deleted with success!");
			} else {
				try {
					conn.rollback();
				} catch (SQLException eRollback) {
					throw new DbException(eRollback.getMessage());
				}
				throw new DbException("No department deleted!");
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
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ? ORDER BY Name");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department d = instantiateDepartment(rs);
				return d;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Db.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();
			List<Department> list = new ArrayList<>();
			while (rs.next()) {
				Department d = instantiateDepartment(rs);
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
		}
	}
	
	public Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department(
				rs.getInt("Id"),
				rs.getString("Name"));
		return department;
	}

}
