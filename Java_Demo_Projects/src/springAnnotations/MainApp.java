package springAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-ann.xml");
		
		Phone ph=(Phone) context.getBean("redmi");
		
		ph.showInfo();
		
		((AbstractApplicationContext) context).close();

	}

}
