package beans;

import java.util.Properties;

public class Employee {

	private Properties property;

	public Properties getProperty() {
		return property;
	}

	public void setProperty(Properties property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "Employee [property=" + property + "]";
	}
	
}
