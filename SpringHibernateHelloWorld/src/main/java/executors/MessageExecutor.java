package executors;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Message;
import daoImpl.MessageDAOImpl;
import daos.MessageDAO;

public class MessageExecutor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		MessageDAO messageDAO = context.getBean(MessageDAOImpl.class);
		messageDAO.getMessages().forEach(System.out::println);
		System.out.println("*************************************************");
		System.out.println(messageDAO.getMessageById(1l));
		System.out.println("*************************************************");
		Message message = new Message(3l, "travelling to paris", new Date(), "amanBhandari");
		 messageDAO.addMessage(message);
		System.out.println("*************************************************");
		 messageDAO.updateMessage(message);
		System.out.println("*************************************************");
		 messageDAO.deleteMessage(3l);
	}

}
