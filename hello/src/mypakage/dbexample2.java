package mypakage;

import java.sql.*;

public class dbexample2 {

	public static void main(String[] args) {
		try 
		{
Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql?useSSL=false","root","mohit@77");
			
			Statement stmt = con.createStatement();
			
			String SQL = "insert into Student values('Kalpesh',12,'bba')";
			
			int rowseffected = stmt.executeUpdate(SQL);
			if(rowseffected > 0) 
				System.out.println("Record inserted succcessfully!");
		}
		catch(Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
	}


}
