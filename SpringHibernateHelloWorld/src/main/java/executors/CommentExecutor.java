package executors;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;

import beans.Comment;
import daoImpl.CommentDAOImpl;
import daos.CommentDAO;

public class CommentExecutor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		CommentDAO commentDAO = context.getBean(CommentDAOImpl.class);
		commentDAO.getComments().forEach(System.out::println);
		System.out.println("*************************************************");
		System.out.println(commentDAO.getCommentById(1l));
		System.out.println("*************************************************");
		Long commentId = commentDAO.getMaxCommentId();
		System.out.println(commentId);
		Comment comment = new Comment(2l, "sahi hai bhai aish kar harry mere veer", new Date(), "jaspreetjhass", 2l);
		//commentDAO.addComment(comment);
		System.out.println("*************************************************");
		commentDAO.updateComment(comment);
		System.out.println("*************************************************");
		//commentDAO.deleteComment(2l);
		System.out.println(commentDAO.getCommentAuthor(1l));
		
	}

}
