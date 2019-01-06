package factoryConcepts;

import org.springframework.beans.factory.FactoryBean;

public class NewBankFactory implements FactoryBean<Bank>{

	@Override
	public Bank getObject() throws Exception {

		Bank bank = (Bank)Class.forName("factoryConcepts.SBI").newInstance();

		return bank;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Bank.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}


}
