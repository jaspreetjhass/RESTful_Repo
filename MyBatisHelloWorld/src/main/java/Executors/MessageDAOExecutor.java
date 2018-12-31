package Executors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import DAO.MessageDAO;
import beans.Message;

public class MessageDAOExecutor {

	private static Logger LOGGER = Logger.getLogger(MessageDAOExecutor.class);

	public static void main(String[] args) throws FileNotFoundException {
		LOGGER.trace("enter into method");
	
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(new FileInputStream("mybatis-config.xml"));
		SqlSession session = sessionFactory.openSession(true);
		MessageDAO daoImpl = session.getMapper(MessageDAO.class);

		daoImpl.getMessages().forEach(System.out::println);
		System.out.println("************************************************");
		System.out.println(daoImpl.getMessageById(1l));
		System.out.println("************************************************");
		// to get the max profile id
		Long messageId = daoImpl.getMaxMessageId();
		Message message = new Message(messageId, "main toh aamir hoon", new Date(),"amanBhandari");
		daoImpl.addMessage(message);
		System.out.println("************************************************");
		daoImpl.updateMessage(message);
		System.out.println("************************************************");
		daoImpl.deleteMessage(2l);
		System.out.println("************************************************");
		System.out.println(daoImpl.getMessageAuthor(1l));

		LOGGER.trace("exit from method");
	}

}
