package mypakage;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class dbexample4 {

	public static void main(String[] args) {
		try {
			String branch1="BBA";
			String name1 = "mohit";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql?useSSL=false","root","mohit@77");
			
			PreparedStatement ps = con.prepareStatement("delete from Student where name=?");
		   // ps.setString(1,branch1);
		    ps.setString(1, name1);
			
			int count = ps.executeUpdate();
			if(count > 0) {
				System.out.println("delete suceesful");
				
			}
			else {
				System.out.println("delete failed"); 
			
				
			}
		}
			catch( Exception ex) {
				System.out.println("Error:"+ex.getMessage());
				
			}
			
		// TODO Auto-generated method stub

	} 

}
