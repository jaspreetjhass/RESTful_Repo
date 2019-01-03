package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import beans.Comment;
import daos.CommentDAO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Comment> getComments() {

		List<Comment> commentList = hibernateTemplate.loadAll(Comment.class);

		return commentList;
	}

	@Override
	public Comment getCommentById(Long commentId) {

		Comment comment = hibernateTemplate.get(Comment.class, 1l);

		return comment;
	}

	@Override
	public void addComment(Comment comment) {

		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(comment);
		transaction.commit();

	}

	@Override
	public void updateComment(Comment comment) {

		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(comment);
		transaction.commit();
	}

	@Override
	public void deleteComment(Long commentId) {

		HibernateCallback<Integer> action = session -> {
			Query query = session.createQuery("delete from comment where commentId = :comId");
			query.setLong("comId", commentId);
			Integer count = query.executeUpdate();
			return count;
		};

		System.out.println("Delete operation count is :" + hibernateTemplate.execute(action));
	}

	@Override
	public String getCommentAuthor(Long commentId) {

		String author = (String) hibernateTemplate.find("select author from comment where commentId = ?", commentId)
				.get(0);

		return author;
	}

	@Override
	public Long getMaxCommentId() {

		DetachedCriteria cr = DetachedCriteria.forClass(Comment.class);
		cr.setProjection(Projections.max("commentId"));
		List list = hibernateTemplate.findByCriteria(cr);

		return (Long) list.get(0);
	}

}
