package SingletonPrototypeConcept;

public class Address {

	private String city;
	private String street;

	public Address() {
		System.out.println("address created");
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	
}
