package SingletonPrototypeConcept;

import java.io.FileNotFoundException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import factoryConcepts.ICICI;

public class App3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("/resources/spring.xml");
		Employee emp = context.getBean(Employee.class);
		System.out.println(emp+""+emp.hashCode());
		System.out.println(emp.getAddress());
		Employee emp1 = context.getBean(Employee.class);
		System.out.println(emp1+""+emp1.hashCode());
		System.out.println(emp1.getAddress());
		
		
		
		System.out.println("*************independent address bean******************************");
		Address add1 = context.getBean(Address.class);
		System.out.println(add1);
		Address add2 = context.getBean(Address.class);
		System.out.println(add2);
		
		
	}
	
}
