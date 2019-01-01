package Executors;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAOImpl.ProfileDAOImpl;
import beans.Profile;

public class ProfileExecutor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		ProfileDAOImpl daoImpl = context.getBean(ProfileDAOImpl.class);

		daoImpl.getProfileList().forEach(System.out::println);
		System.out.println("************************************************");
		System.out.println(daoImpl.getProfile("amanBhandari"));
		System.out.println("************************************************");
		// to get the max profile id
		Long profileId = daoImpl.getMaxProfileId();
		Profile profile = new Profile(profileId, "sahilHdr", "sahilHDR", "singh", new Date());
//		daoImpl.addProfile(profile);
		System.out.println("************************************************");
		//daoImpl.updateProfile(profile);
		System.out.println("************************************************");
		//daoImpl.deleteProfile("sahilHdr");
		System.out.println("************************************************");
		System.out.println(daoImpl.getProfileCreatedDate("jaspreetjhass", 2018122901l));
		System.gc();

	}
}
