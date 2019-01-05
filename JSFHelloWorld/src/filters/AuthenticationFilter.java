package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("filter destroy called");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {

		System.out.println("filter doFilter called");
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getRequestURI().contains("faces")) {
			fc.doFilter(req, res);
		} else {
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			
			if (name.equals("jaspreet") && password.equals("jpjhass"))
				fc.doFilter(req, res);
			else {
				System.out.println("not authorized user");
				HttpServletResponse response = (HttpServletResponse) res;
				response.sendRedirect(req.getServletContext().getContextPath() + "/error/error.jsp");
			}
		}

	}

	@Override
	public void init(FilterConfig fc) throws ServletException {

		System.out.println("filter init called");

	}

}
