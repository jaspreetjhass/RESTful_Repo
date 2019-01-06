package org.jp.SpringHelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.ApplicationContextProvider;
import beans.Bank;
import beans.Car;
import beans.Message;
import beans.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context =  new ClassPathXmlApplicationContext("/resources/spring.xml");
    	/*Profile profile = context.getBean(Profile.class);
    	System.out.println(profile);
    	
    	Employee emp = context.getBean(Employee.class);
    	System.out.println(emp);
    	
    	Student st =  context.getBean(Student.class);
    	System.out.println(st.getName());
    	*/
    	
    	Student st = ApplicationContextProvider.getApplicationContext().getBean(Student.class);
    	System.out.println(st);
    	
    	Message msg = ApplicationContextProvider.getApplicationContext().getBean(Message.class);
    	System.out.println(msg);
    	
    	Car car = ApplicationContextProvider.getApplicationContext().getBean(Car.class);
    	System.out.println(car);
    	
    	System.out.println(Bank.bankName);
    }
}
