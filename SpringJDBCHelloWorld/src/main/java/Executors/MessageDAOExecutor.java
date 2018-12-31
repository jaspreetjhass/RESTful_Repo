package Executors;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAOImpl.MessageDAOImpl;
import beans.Message;

public class MessageDAOExecutor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageDAOImpl daoImpl = context.getBean(MessageDAOImpl.class);
		// getMessageList()
		daoImpl.getMessages().forEach(System.out::println);
		System.out.println("***********************************************");
		// getMessageById
		System.out.println(daoImpl.getMessageById(1l));
		System.out.println("***********************************************");
		// addMessage
		Message message = new Message(2l, "hello kya haal chaal", new Date(), "jaspreetjhass");
		daoImpl.addMessage(message);
		System.out.println("***********************************************");
		// updateMessage
		Message updatedMessage = new Message(2l, "hello kya haal chaal hai bhai", new Date(), "jaspreetjhass");
		daoImpl.updateMessage(updatedMessage);
		System.out.println("***********************************************");
		// deleteMessage
		daoImpl.deleteMessage(1l);
		System.out.println("***********************************************");
		// getMessageAuthorName
		System.out.println(daoImpl.getMessageAuthor(2l));

	}
}
