package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "erlanggal";
		String password = "apaansih";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

			System.out.println("Connection Successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
