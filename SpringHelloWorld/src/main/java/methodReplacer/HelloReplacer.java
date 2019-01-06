package methodReplacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class HelloReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		Integer output = null;
		Integer output1 = null;
		output = (Integer) args[0];
		output1 = (Integer) args[1];
		System.out.println("hello is modified with param1 " + output + " param2 " + output1);
		return output;
	}

}
