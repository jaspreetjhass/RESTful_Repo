package executors;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Message;

public class MessageExecutor {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// create operation
		Transaction createTrans = session.beginTransaction();
		Message createdMessage = new Message(3l, "main toh bhai aamir hoon", new Date(), "amanBhandari");
		session.save(createdMessage);
		createTrans.commit();
		session.evict(createdMessage);
		// retrieve operation
		Message getMessage = session.get(Message.class, 2l);
		System.out.println(getMessage);
		session.evict(getMessage);
		// update operation
		Transaction updateTrans = session.beginTransaction();
		Message updatedMessage = new Message(1l, "main toh bhai aamir hoon aajkal", new Date(), "amanBhandari");
		session.update(updatedMessage);
		updateTrans.commit();
		session.evict(updatedMessage);
		// delete operation
		Transaction deleteTrans = session.beginTransaction();
		Message deletedMessage = new Message(2l, null, null, "authorBhandari");
		session.delete(deletedMessage);
		deleteTrans.commit();

		session.close();
		sessionFactory.close();
	}

}
