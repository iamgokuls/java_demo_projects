package pack_jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect_database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/demo1", "postgres", "billiondreams")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
            String query="SELECT name FROM student";
            Statement statement = conn.createStatement();
            
			//execute query
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {				 
			  
			   String Name = rs.getString("name");
			   System.out.println("Name : " + Name); 
			}
            
			statement.close();
            conn.close();
    		System.out.println("Connection closed !");

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
