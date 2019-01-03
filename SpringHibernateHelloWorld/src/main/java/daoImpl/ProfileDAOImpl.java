package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.Profile;
import daos.ProfileDAO;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Profile addProfile(Profile profile) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(profile);
			transaction.commit();
			System.out.println("Profile is added to the database");
		} catch (RuntimeException exception) {
			System.err.println("exception occured while saving the profile data");
			transaction.rollback();
		} finally {
			System.out.println("Closing the session");
			session.close();
			
		}

		return profile;
	}

	public Profile updateProfile(Profile profile) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(profile);
			transaction.commit();
			System.out.println("Profile is updated to the database");
		} catch (RuntimeException exception) {
			System.err.println("exception occured while updating the profile data");
			transaction.rollback();
		} finally {
			System.out.println("Closing the session");
			session.close();
		}

		return profile;
	}

	public void deleteProfile(String profileName) {
		Session session = sessionFactory.openSession();
		try {

			Query query = session.createQuery("delete from Profile where profileName = :profileNm");
			query.setString("profileNm", profileName);
			Integer count = query.executeUpdate();
			if (count > 1) {
				System.out.println("Profile record deleted successfully");
			}
		} catch (RuntimeException exception) {
			System.err.println("exception occured while deleting the profile data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}

	}

	public Profile getProfileByName(String profileName) {
		Session session = sessionFactory.openSession();
		Profile profile = null;
		try {

			Query query = session.createQuery("from Profile where profileName = :profileNm");
			query.setString("profileNm", profileName);
			profile = (Profile) query.uniqueResult();
		} catch (RuntimeException exception) {
			System.err.println("exception occured while getting the profile data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}
		return profile;
	}

	public Profile getProfileById(Long profileId) {
		Session session = sessionFactory.openSession();
		Profile profile = null;
		try {
			Query query = session.createQuery("from Profile where profileId = :profileId");
			query.setLong("profileId", profileId);
			profile = (Profile) query.uniqueResult();
		} catch (RuntimeException exception) {
			System.err.println("exception occured while getting the profile data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}
		return profile;
	}

	public List<Profile> getProfileList() {
		Session session = sessionFactory.openSession();
		List<Profile> profileList = null;
		try {
			Criteria criteria = session.createCriteria(Profile.class);
			profileList = criteria.list();
		} catch (RuntimeException exception) {
			System.err.println("exception occured while getting the profile data from database");
		} finally {
			System.out.println("Closing the session");
			session.close();
		}

		return profileList;
	}

}
