package com.SpringJdbc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		
		
		  Student s=(Student) context.getBean("StudentBean",Student.class);
		  
		  System.out.println("No of students:");
		  System.out.println(s.NoOfStudents().get(0));
		  
		  
		  
		  System.out.println("\nBefore Insertion, updation & deletion\n"); s.getInfo();
		  //select operation
		  
		  
		  s.insertOp(); // insertion 
		  s.updateOp(); // updation 
		  s.deleteOp(); //deletion
		  
		  System.out.println("\nAfter Inserion , updation & deletion\n"); s.getInfo();
		 
		
		MarkDao m=(MarkDao) context.getBean("MarkDao");
		System.out.println("\nNumber of elements in mark table");
		m.getDetails();
		 
		

	}

}
