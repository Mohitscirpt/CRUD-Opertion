package mypakage;

import java.sql.*;
public class dbexmplae1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql?useSSL=false","root","mohit@77");
			
			Statement stmt=con.createStatement();
			ResultSet res = stmt.executeQuery("Select *from empolyee1");
			
			while(res.next()) {
				System.out.println(res.getInt(1) + "\t" + 
						res.getString("name") + "\t" + 
						res.getString("address"));
			}
			con.close();

			
			
		}
		catch(Exception ex) {
			System.out.println("Error:"+ex.getMessage());
			
		}
	}
}
	
  

			

			
			

			
			
			
			
		

