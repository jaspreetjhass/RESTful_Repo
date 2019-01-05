package ap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.ProfileBean;

@Repository
public class ProfileMainControl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<ProfileBean> getProfileList() {
		List<ProfileBean> profileList = new ArrayList<ProfileBean>();

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(ProfileBean.class);
		profileList = criteria.list();
		session.close();

		return profileList;
	}

}
