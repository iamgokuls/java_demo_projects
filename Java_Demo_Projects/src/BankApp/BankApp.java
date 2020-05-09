package BankApp;

import java.sql.SQLException;
import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Account ac=new Account();
		
		System.out.println("Enter your Bank account Number");
		Scanner in=new Scanner(System.in);
		String acc_no=in.nextLine();
		
		System.out.println("OPERATIONS:\n 1 for Balance Enquiry \n 2 for Deposit \n 3 for Withdraw \n 4 for Transfer \n");
		System.out.println("Enter your option:");
		int op=in.nextInt();
		in.nextLine();
		switch(op) {
		
			case 1:ac.check_balance(acc_no);
					break;
			case 2:ac.deposit(acc_no);
					break;
			case 3:ac.withdraw(acc_no);
					break;
			case 4: ac.transfer(acc_no);
					break;
			default:System.out.println("Invalid input");
		}
		ac.close();
	}

}
