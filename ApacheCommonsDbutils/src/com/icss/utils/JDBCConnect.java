package com.icss.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;



public class JDBCConnect {
	
	public static Connection getConnect (){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user="root",password="", url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
		return  DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		
		return null;
	}
}
