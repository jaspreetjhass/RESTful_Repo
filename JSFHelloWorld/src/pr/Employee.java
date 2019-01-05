package pr;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Employee {

	
	public Employee() {
		System.out.println("Employee created");
	}
}
