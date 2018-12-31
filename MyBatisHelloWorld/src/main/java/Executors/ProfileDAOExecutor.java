package Executors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DAO.ProfileDAO;
import beans.Profile;

public class ProfileDAOExecutor {

	public static void main(String[] args) throws FileNotFoundException {

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(new FileInputStream("mybatis-config.xml"));
		SqlSession session = sessionFactory.openSession(true);
		ProfileDAO daoImpl = session.getMapper(ProfileDAO.class);

		daoImpl.getProfileList().forEach(System.out::println);
		System.out.println("************************************************");
		System.out.println(daoImpl.getProfile("amanBhandari"));
		System.out.println("************************************************");
		//to get the max profile id
		Long profileId = session.selectOne("getMaxId");
		Profile profile = new Profile(profileId, "sahilHdr", "sahil", "singh", new Date());
		daoImpl.addProfile(profile);
		System.out.println("************************************************");
		daoImpl.updateProfile(profile);
		System.out.println("************************************************");
		daoImpl.deleteProfile("sahilHdr");
		System.out.println("************************************************");
		System.out.println(daoImpl.getProfileCreatedDate("jaspreetjhass", 2018122901l));

	}

}
