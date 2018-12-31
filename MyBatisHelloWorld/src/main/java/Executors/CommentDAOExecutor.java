package Executors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import DAO.CommentDAO;
import beans.Comment;

public class CommentDAOExecutor {

	private static Logger LOGGER = Logger.getLogger(CommentDAOExecutor.class);

	public static void main(String[] args) throws FileNotFoundException {
		LOGGER.trace("enter into method");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(new FileInputStream("mybatis-config.xml"));
		SqlSession session = sessionFactory.openSession(true);
		CommentDAO daoImpl = session.getMapper(CommentDAO.class);

		daoImpl.getComments().forEach(System.out::println);
		System.out.println("************************************************");
		System.out.println(daoImpl.getCommentById(1l));
		System.out.println("************************************************");
		// to get the max comment id
		Long commentId = daoImpl.getMaxCommentId();
		Comment comment = new Comment(commentId, "main toh aamir hoon", new Date(), "amanBhandari", 1l);
		daoImpl.addComment(comment);
		System.out.println("************************************************");
		daoImpl.updateComment(comment);
		System.out.println("************************************************");
		daoImpl.deleteComment(2l);
		System.out.println("************************************************");
		System.out.println(daoImpl.getCommentAuthor(1l));

		LOGGER.trace("exit from method");
	}

}
