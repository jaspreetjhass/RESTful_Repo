package pr;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloBean")
@RequestScoped
public class HelloBean {
	
	private String name;
	
	public HelloBean() {
		System.out.println("Hello bean created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPage() {
		System.out.println("inside hello bean");
		return "search";
	}

}
