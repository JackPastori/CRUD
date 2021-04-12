package br.com.farmacia.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigSQL {

		//usuario do banco
		private static final String USERNAME =  "root";
		//password 
		private static final String PASSWORD = "";
		//caminho 
		private static final String DataBase = "jdbc:MySQL://localhost/Farmacia";
		
		//connector
		public static Connection createConnectiontomysql() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DataBase, USERNAME, PASSWORD);
					return connection;
		}

}
