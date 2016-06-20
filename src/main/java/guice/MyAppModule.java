package guice;

import com.google.inject.AbstractModule;

class MyAppModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IsomeDao.class).to(MyAppDAO.class);
		
	}
	
}