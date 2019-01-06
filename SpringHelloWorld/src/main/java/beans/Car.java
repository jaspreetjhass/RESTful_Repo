package beans;

public class Car {

	private String name;
	private Engine engine;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", engine=" + engine + "]";
	}
	
}
