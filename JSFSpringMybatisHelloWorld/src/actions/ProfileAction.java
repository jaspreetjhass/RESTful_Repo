package actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import beans.Profile;
import dao.ProfileDAO;

@ManagedBean(name = "profileAction")
@RequestScoped
public class ProfileAction extends BaseProfileAction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6222815995219211331L;

	public ProfileAction() {
		System.out.println("profile action created");
	}
	
	@Override
	public String getProfileList() {

		SqlSession session = getSession();
		ProfileDAO profileDAO = session.getMapper(ProfileDAO.class);
		profileBean.setProfileList(profileDAO.getProfileList());
		session.close();
		return null;
	}

	@Override
	public String getProfile() {
		SqlSession session = getSession();
		ProfileDAO profileDAO = session.getMapper(ProfileDAO.class);
		List list =  new ArrayList();
		Profile profile = profileDAO.getProfile(profileBean.getProfileName());
		list.add(profile);
		profileBean.setProfileList(list);
		session.close();
		return null;
	}

	private SqlSession getSession() {
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);
		SqlSessionFactory sessionFactory = null;
		try {
			sessionFactory = appContext.getBean(SqlSessionFactoryBean.class).getObject();
		} catch (Exception e) {
			System.err.println("exception occured while getting sessionFactory");
		}
		return sessionFactory.openSession(true);
	}
}
