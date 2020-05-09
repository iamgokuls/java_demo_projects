package BankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect_database {
	
private String username="postgres";
private String password="billiondreams";
Connection conn=null;
	
	public Connection connectdb() {
		
		try {
			 conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/demo1", "postgres", "billiondreams"); 

           if (conn != null) {
               System.out.println("Connected to the database!");
               
           } else {
               System.out.println("Failed to make connection!");
               
           }
           

       } catch (SQLException e) {
           System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
       } catch (Exception e) {
           e.printStackTrace();
       }
		
		return conn;
		
	}

}
