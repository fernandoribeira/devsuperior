package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			/*
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Fernando Ribeira");
			st.setString(2, "fernando@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			*/
			
			/*
			st = conn.prepareStatement("INSERT INTO department (Name) values ('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);
			*/
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Done! Total rows affected: " + rowsAffected);
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Id = " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
}
