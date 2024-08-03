package mypakage;
import java.sql.*;

public class dbexampes8 {

	public static void main(String[] args) {
	Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
            conn = DriverManager.getConnection(connectionUrl, "root", "mohit@77");

            PreparedStatement pstmt = conn.prepareStatement("SELECT name,rollnumber ,branch FROM Student");
            ResultSet result = pstmt.executeQuery();
            ResultSetMetaData resmd = result.getMetaData();

            System.out.println("Total columns: " + resmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + resmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + resmd.getColumnTypeName(1));
            System.out.println("Column Type Name of 2st column: " + resmd.getColumnTypeName(2));


            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


	}


