package executors;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Profile;
import daoImpl.ProfileDAOImpl;
import daos.ProfileDAO;

public class ProfileExecutor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		ProfileDAO profileDAO = context.getBean(ProfileDAOImpl.class);
		profileDAO.getProfileList().forEach(System.out::println);
		System.out.println("*************************************************");
		System.out.println(profileDAO.getProfileById(2018122901l));
		System.out.println("*************************************************");
		Profile profile =  new Profile(2018123106l,"sahilHR","sahil","singh", new Date());
		profileDAO.addProfile(profile);
		System.out.println("*************************************************");
		profileDAO.updateProfile(profile);
		System.out.println("*************************************************");
		profileDAO.deleteProfile("sahilHR");
	}

}
