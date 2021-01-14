package EmailApp;

import java.util.Scanner;

public class Email {
	
	private String first_name;
	private String last_name;
	private String department;
	private String email;
	private String password;
	private String AlternateEmail;
	private int MaxCapacity=600;
	private String companySuffix="abcompany.com";
	
	public Email(String first_name,String last_name) {
		
		this.first_name=first_name;
		this.last_name=last_name;
		
		//Ask for the department
		this.department=setDepartment();
		
		//set random password
		this.password = setRandPassword(8);
		
		//generate email id
		if(this.department==null || this.department=="")
			this.email=this.first_name.toLowerCase()+"."+this.last_name.toLowerCase()+"@"+this.companySuffix;
		else
			this.email=this.first_name.toLowerCase()+"."+this.last_name.toLowerCase()+"@"+this.department+"."+this.companySuffix;
		
	
		System.out.println("Email generated\n"+this.email+"\npassword\n"+this.password);
	}
	
	// method to set department
	private String setDepartment() {
		
		System.out.println("DEPARTMENT CODES: \n 1 for Sales\n 2 for Accounts \n 3 for Development \n 0 for None:  ");
		System.out.println("Enter Department Code");
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int dep=in.nextInt();
		
		switch(dep) {
		
			case 1:return "sales";
			case 2:return "accounts";
			case 3:return "development";
			case 0:return "";
			default:return null;
		}
	}
	
	//method to generate random password
	private String setRandPassword(int length) {
		
		String passwordset="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$_#@*&";
		char[] pass=new char[length];
		int index;
		
		for(int i=0;i<length;i++) {
			
			index = (int) (Math.random()*passwordset.length());
			pass[i]=passwordset.charAt(index);
		}
		return new String(pass);
	}
	
	// set and get methods
	// Thses are set public so main java file can call these if necessary
	public void setMaxCapacity(int cap) {
		this.MaxCapacity=cap;
	}
	
	public void setPassword(String pass) {
		this.password=pass;
	}
	public void setAltEmail(String email) {
		this.AlternateEmail=email;
	}
	
	public int getMaxCapacity() {
		return this.MaxCapacity;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getAltEmail() {
		return this.AlternateEmail;
	}
	
	public void showInfo() {
		
		System.out.println("Name : "+this.first_name+" "+this.last_name);
		System.out.println("Email : "+this.email);
		System.out.println("Alternate mail : "+this.AlternateEmail);
	}

}
