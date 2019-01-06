package org.jp.SpringHelloWorld;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import factoryConcepts.Bank;
import factoryConcepts.BankFactory;
import factoryConcepts.ICICI;
import factoryConcepts.NewBankFactory;
import factoryConcepts.SBI;

public class App1 {

	public static void main(String[] args) throws BeansException, Exception {
	
		/*System.out.println(SessionFactory.getSessionFactory());
		System.out.println(SessionFactory.getSessionFactory());
		System.out.println(SessionFactory.getSessionFactory());
		*/
		ApplicationContext context =  new ClassPathXmlApplicationContext("/resources/spring.xml");
		/*System.out.println(context.getBean(SessionFactory.class));
		System.out.println(context.getBean(SessionFactory.class));
		System.out.println(context.getBean(Calendar.class).hashCode());
		System.out.println(context.getBean(Calendar.class).hashCode());
		System.out.println(context.getBean(Calendar.class).hashCode());*/
		
		/*Bank bank = context.getBean(Bank.class);
		if(bank instanceof ICICI)
			System.out.println("ICICI bank");
		else if(bank instanceof SBI)
			System.out.println("SBI bank");
		else
			System.out.println("other bank");
			
		*/
		Logger LOGGER = context.getBean(Logger.class);
		LOGGER.info("hello");
		
		System.out.println(context.getBean(NewBankFactory.class)); 
		
		
	}
	
}
