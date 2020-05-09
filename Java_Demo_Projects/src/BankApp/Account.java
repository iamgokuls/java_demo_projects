package BankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Account {
	
private Connection conn=null;

private int amount;
Scanner sc=new Scanner(System.in);
	
	Account(){
		
		Connect_database db=new Connect_database();
		conn=db.connectdb();
	}
	
	
	public void check_balance(String acc_no) throws SQLException {
		
		String query="SELECT balance FROM account WHERE acc_no="+"\'"+acc_no+"\'";
        Statement statement = conn.createStatement();
        
		//execute query
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {				 
		  
		   String Name = rs.getString("balance");
		   System.out.println("Current Balance : " + Name); 
		}
		statement.close();
		
	}
	
	public void withdraw(String acc_no) throws SQLException {
		System.out.println("Enter Amout to withdraw");
		amount=sc.nextInt();
		
		String query="UPDATE account SET balance=balance-"+amount+"WHERE acc_no="+"\'"+acc_no+"\'";
		
		//create statement
		Statement statement = conn.createStatement();

		//execute query
		statement.executeUpdate(query);
		
		System.out.println("Successfully withdrawn "+amount);
		this.check_balance(acc_no);
		
		statement.close();
		
	}
	
	public void deposit(String acc_no) throws SQLException {
		System.out.println("Enter Amout to deposit");
		amount=sc.nextInt();
		String query="UPDATE account SET balance=balance+"+amount+"WHERE acc_no="+"\'"+acc_no+"\'";
		
		//create statement
		Statement statement = conn.createStatement();

		//execute query
		statement.executeUpdate(query);
		
		System.out.println("Successfully deposied "+amount);
		this.check_balance(acc_no);
		
		statement.close();
		
		
	}
	
	public void transfer(String acc_no) {
		
		System.out.println("Enter recepient bank account number");
		String recv_no=sc.nextLine();
		
		System.out.println("Enter Amout to transfer");
		amount=sc.nextInt();
		
		
		try {
			
			Statement statement;
			
			String query="UPDATE account SET balance=balance-"+amount+"WHERE acc_no="+"\'"+acc_no+"\'";
			statement = conn.createStatement();
			//execute query
			statement.executeUpdate(query);
			
			query="UPDATE account SET balance=balance+"+amount+"WHERE acc_no="+"\'"+recv_no+"\'";
			
			statement.executeUpdate(query);
			
			System.out.println("Successfully transfered "+amount+" to "+recv_no);
			
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
	public void delete_account(String acc_no) {
		
		try {
			
			Statement statement;
			
			String query="DELETE FROM account WHERE acc_no="+"\'"+acc_no+"\'";
			statement = conn.createStatement();
			//execute query
			statement.executeUpdate(query);
			
			System.out.println("Successfully deleted your account");
			
			statement.close();
			
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public void close() throws SQLException {
		conn.close();
		System.out.println("\nConnection closed.....\nThanks for using our service");
	}
	
	

}
