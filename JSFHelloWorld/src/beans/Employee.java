package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "emp")
@RequestScoped
public class Employee implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 5878382879358279085L;

	private Integer code;
	private String name;
	@ManagedProperty(value = "#{add}")
	private Address address;

	public Employee() {
		System.out.println("employee created");
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPage() {
		return "/employee/empDetails";
	}
	
	public void getListener(ActionEvent event)
	{
		System.out.println(event);
	}
	
	public void valueChanged(ValueChangeEvent event)
	{
		System.out.println(event);
	}
}
