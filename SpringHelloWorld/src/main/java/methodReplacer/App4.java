package methodReplacer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App4 {

	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("/resources/spring.xml");
		HelloWorld hello  = context.getBean(HelloWorld.class);
		
		hello.sayHello(1234,456);
		hello.sayHello1(567, 3434);
	}
	
}
