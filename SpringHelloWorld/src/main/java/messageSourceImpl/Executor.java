package messageSourceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executor {

	
	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("/resources/spring.xml");
		
		System.out.println(context.getMessage("param1",new Object[]{"txnName"},"not found", null));
		
	}
	
}
