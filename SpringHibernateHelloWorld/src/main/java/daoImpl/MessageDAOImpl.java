package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Message;
import daos.MessageDAO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Message> getMessages() {

		Session session = sessionFactory.openSession();
		List<Message> messageList = null;
		try {
			Criteria criteria = session.createCriteria(Message.class);
			messageList = criteria.list();
		} catch (RuntimeException exception) {
			System.err.println("exception occured while getting the message data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}

		return messageList;
	}

	@Override
	public Message getMessageById(Long messageId) {

		Session session = sessionFactory.openSession();
		Message message = null;
		try {
			Query query = session.createQuery("from Message where messageId = :msgId");
			query.setLong("msgId", messageId);
			message = (Message) query.uniqueResult();
		} catch (RuntimeException exception) {
			System.err.println("exception occured while getting the message data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}
		return message;
	}

	@Override
	public void addMessage(Message message) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(message);
			transaction.commit();
			System.out.println("Message is added to the database");
		} catch (RuntimeException exception) {
			System.err.println("exception occured while saving the message data");
			transaction.rollback();
		} finally {
			System.out.println("Closing the session");
			session.close();

		}

	}

	@Override
	public void updateMessage(Message message) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(message);
			transaction.commit();
			System.out.println("Message is updated to the database");
		} catch (RuntimeException exception) {
			System.err.println("exception occured while updating the message data");
			transaction.rollback();
		} finally {
			System.out.println("Closing the session");
			session.close();
		}

	}

	@Override
	public void deleteMessage(Long messageId) {

		Session session = sessionFactory.openSession();
		try {

			Query query = session.createQuery("delete from Message where messageId = :msgId");
			query.setLong("msgId", messageId);
			Integer count = query.executeUpdate();
			if (count > 1) {
				System.out.println("Message record deleted successfully");
			}
		} catch (RuntimeException exception) {
			System.err.println("exception occured while deleting the message data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}

	}

	@Override
	public String getMessageAuthor(Long messageId) {
		Session session = sessionFactory.openSession();
		String author = null;
		try {

			Query query = session.createQuery("select author from Message where messageId = :msgId");
			query.setLong("msgId", messageId);
			author = (String) query.uniqueResult();
		} catch (RuntimeException exception) {
			System.err.println("exception occured while getting the message data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}
		return author;
	}

}
