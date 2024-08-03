package mypakage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class dbexample7{
       private static Connection connection = null;
		private static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			dbexample7 std = new dbexample7();
			int choice =0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysql?useSSL=false","root","mohit@77");
			 
				 while(choice !=4) {
					 System.out.println("enter the choice");
					 System.out.println("1. insert record");
					 System.out.println("2. show record:");
					 
					 System.out.println("3. exitinmg");
					 
					 choice = Integer.parseInt(sc.nextLine());
				 switch(choice) {
				 case 1:
					 std.insertRecord();
					 break;
				 
			     case 2:
					 std.showtable();
					 break;
				 case 3:
					 System.out.print("Exiting......");
					 break;
				 default :
					 System.out.print("defalut value");
					 break;
				 }
				 }
				
			}
			catch(Exception ex) {
				throw new RuntimeException("somthing went wrong");
				
			}
			
		}
		private void insertRecord() throws SQLException {
			System.out.println("inside insert record");
			String sql = "insert into Student(name,rollnumber,branch) values(?,?,?)";
			PreparedStatement pd =  connection.prepareStatement(sql);
			System.out.println("Enter the name:");
			pd.setString(1,sc.nextLine());
			System.out.println("Enter the rollno:");
			pd.setDouble(2,Double.parseDouble(sc.nextLine()));
			System.out.println("Enter the branch:");
			pd.setString(3,sc.nextLine());
			
			int row = pd.executeUpdate();
			if(row > 0) {
				System.out.println("Record inserted succesfull:");
				
				
		}
	}
		public void showtable() throws Exception{

			try {
				
				
				Statement stmt=connection.createStatement();
				ResultSet res = stmt.executeQuery("Select *from Student");
				
				while(res.next()) {
					System.out.println(res.getString("name") + "\t" + 
							res.getInt("rollnumber") + "\t" + 
							res.getString("branch"));
				}
				connection.close();

				
				
			}
			catch(Exception ex) {
				System.out.println("Error:"+ex.getMessage());
				
			}
			
		}
				 

}


