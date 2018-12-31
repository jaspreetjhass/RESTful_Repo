package Executors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import DAO.ProfileDAO;
import beans.Profile;

public class ProfileDAOExecutor {

	private static Logger LOGGER = Logger.getLogger(ProfileDAOExecutor.class);

	public static void main(String[] args) throws FileNotFoundException {
		LOGGER.trace("enter into method");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(new FileInputStream("mybatis-config.xml"));
		SqlSession session = sessionFactory.openSession(true);
		ProfileDAO daoImpl = session.getMapper(ProfileDAO.class);

		daoImpl.getProfileList().forEach(System.out::println);
		System.out.println("************************************************");
		System.out.println(daoImpl.getProfile("amanBhandari"));
		System.out.println("************************************************");
		// to get the max profile id
		Long profileId = session.selectOne("getMaxId");
		Profile profile = new Profile(profileId, "sahilHdr", "sahil", "singh", new Date());
		daoImpl.addProfile(profile);
		System.out.println("************************************************");
		daoImpl.updateProfile(profile);
		System.out.println("************************************************");
		daoImpl.deleteProfile("sahilHdr");
		System.out.println("************************************************");
		System.out.println(daoImpl.getProfileCreatedDate("jaspreetjhass", 2018122901l));

		LOGGER.trace("exit from method");
	}

}
