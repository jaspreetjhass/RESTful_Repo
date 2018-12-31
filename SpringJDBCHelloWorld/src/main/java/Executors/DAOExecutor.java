package Executors;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAOImpl.ProfileDAOImpl;
import beans.Profile;

public class DAOExecutor {

	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
		ProfileDAOImpl daoImpl = context.getBean(ProfileDAOImpl.class);
		//getProfileList()
		daoImpl.getProfileList().forEach(System.out::println);
		System.out.println("***********************************************");
		//getProfileByName
		System.out.println(daoImpl.getProfile("jaspreetjhass"));
		System.out.println("***********************************************");
		//addProfile
		Profile profile =  new Profile(2018123104l, "priya", "priya", "singh", new Date());
		daoImpl.addProfile(profile);
		System.out.println("***********************************************");
		//updateProfile
		Profile updatedProfile =  new Profile(2018123104l, "priya", "priya", "kaur", new Date());
		daoImpl.updateProfile(updatedProfile);
		System.out.println("***********************************************");
		//deleteProfile
		daoImpl.deleteProfile("priya");
		System.out.println("***********************************************");
		//getProfileCreatedDate
		System.out.println(daoImpl.getProfileCreatedDate("priya"));
	}
}
