package executors;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Profile;

public class ProfileExecutor {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		//create operation
		Transaction createTrans = session.beginTransaction();
		Profile createdProfile =  new Profile(null,"ekta","ekta","thakur",new Date());
		session.save(createdProfile);
		createTrans.commit();
		session.evict(createdProfile);
		//retrieve operation
		Profile getProfile = session.get(Profile.class, 2018122901l);
		System.out.println(getProfile);
		session.evict(getProfile);
		//update operation
		Transaction updateTrans = session.beginTransaction();
		Profile updatedProfile =  new Profile(2018123105l,"ektaThakur","ekta","thakur",new Date());
		session.update(updatedProfile);
		updateTrans.commit();
		session.evict(updatedProfile);
		//delete operation
		Transaction deleteTrans = session.beginTransaction();
		Profile deletedProfile =  new Profile(2018123105l,null,null,null,null);
		session.delete(deletedProfile);
		deleteTrans.commit();
		
		session.close();
		sessionFactory.close();
	}

}
