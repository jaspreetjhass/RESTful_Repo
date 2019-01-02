package listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import DAO.CacheDAO;
import beans.BranchBusinessDate;

public class CacheLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("cache loader listener initialized");

		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());

		SqlSession session = context.getBean(SqlSessionTemplate.class);

		ServletContext sc = sce.getServletContext();
		String branchCode = sc.getInitParameter("branchCode");

		CacheDAO cacheDAO = session.getMapper(CacheDAO.class);
		Date changeBusinessDate = cacheDAO.getBusinessDate(branchCode);

		BranchBusinessDate branchBusinessDate = new BranchBusinessDate();
		branchBusinessDate.setChangeBusinessDate(changeBusinessDate);

		sc.setAttribute("businessDate", branchBusinessDate);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("cache loader listener destroyed");
	}

}
