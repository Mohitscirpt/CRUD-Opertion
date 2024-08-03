package mypakage;


import java.sql.*;

public class dbexample3 {

	public static void main(String[] args) {
		try {
		String branch1="bsc";
		String name1 = "mohit";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mysql?useSSL=false","root","mohit@77");
		
		PreparedStatement ps = con.prepareStatement("update Student set branch=? where name=?");
		ps.setString(1,branch1);
		ps.setString(2, name1);
		
		int count = ps.executeUpdate();
		if(count > 0) {
			System.out.println("update suceesful");
		}
		else {
			System.out.println("update failed"+name1);
		
			
		}
		con.close();	}
		catch( Exception ex) {
			System.out.println("Error:"+ex.getMessage());
			
		}
}

}
