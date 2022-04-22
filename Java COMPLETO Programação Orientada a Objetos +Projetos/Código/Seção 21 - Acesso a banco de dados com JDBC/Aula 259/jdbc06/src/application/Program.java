package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Program {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.openConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement("UPDATE seller SET BaseSalary = 1000 WHERE DepartmentId = 1");
			int rowsAffected1 = st.executeUpdate();
			
			/*
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error!");
			}
			*/

			st = conn.prepareStatement("UPDATE seller SET BaseSalary = 2000 WHERE DepartmentId = 2");
			int rowsAffected2 = st.executeUpdate();
			
			conn.commit();
			
			System.out.println("Done! Rows1 affected: " + rowsAffected1);
			System.out.println("Done! Rows2 affected: " + rowsAffected2);
		} catch (SQLException e1) {
			try {
				System.out.println("Erro!");
				System.out.println("Tentando rollback...");
				conn.rollback();
				System.out.println("Rollback executado com sucesso!");
			} catch (SQLException e2) {
				System.out.println("Falha na execução do rollback.");
				System.out.println(e2.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
}
