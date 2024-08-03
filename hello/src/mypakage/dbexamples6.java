package mypakage;

import java.util.*;
import java.sql.*;

public class dbexamples6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "mohit@77");

            System.out.println("Inside insert record...");

            // Get user input
            System.out.println("Enter the name:");
            String name = sc.nextLine();
            System.out.println("Enter the rollno:");
            int rollNumber = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the branch:");
            String branch = sc.nextLine(); 

            // Create SQL statement
            String sql = "INSERT INTO Student (name, rollnumber, branch) VALUES ('" + name + "', " + rollNumber + ", '" + branch + "')";

            // Execute the SQL statement
            Statement stmt = con.createStatement();
            int rowsInserted = stmt.executeUpdate(sql);
            
            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully.");
            }

            con.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            sc.close(); // Close scanner in finally block
        }
    }

}
