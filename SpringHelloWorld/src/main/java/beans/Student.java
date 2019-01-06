package beans;

public class Student {

	private String name;

	private Student(String name) {
		System.out.println("string exec");
		this.name=name;
	}
	
	private Student(Integer in) {
		System.out.println("in executed");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
}