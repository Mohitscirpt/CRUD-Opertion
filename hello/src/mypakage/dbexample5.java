package mypakage;



import java.util.*;
import java.sql.*;


public class dbexample5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql?useSSL=false","root","mohit@77");
			
			System.out.println("inside insert record(");
			String sql = "insert into Student(name,rollnumber,branch) values(?,?,?)";
			PreparedStatement pd =  con.prepareStatement(sql);
			System.out.println("Enter the name:");
			pd.setString(1,sc.nextLine()); 
			System.out.println("Enter the rollno:");
			pd.setInt(2,Integer.parseInt(sc.nextLine()));
			System.out.println("Enter the branch:");
			pd.setString(3,sc.nextLine());
			
			int row = pd.executeUpdate();
			if(row > 0) {
				System.out.println("Record inserted succesfull:");
				
			}
			con.close();	
			}
			catch( Exception ex) {
				System.out.println("Error:"+ex.getMessage());
				
			}

	}

}
