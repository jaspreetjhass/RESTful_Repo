package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

public class HelloBean {

	public HelloBean() {
		System.out.println("bean created");
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
