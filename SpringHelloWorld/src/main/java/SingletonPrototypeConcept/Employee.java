package SingletonPrototypeConcept;

public class Employee {

	private String name;
	private Address address;

	public Employee() {
		System.out.println("employee created");
	}
	
	public Address getAddress() {
		return null;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	
	
}
