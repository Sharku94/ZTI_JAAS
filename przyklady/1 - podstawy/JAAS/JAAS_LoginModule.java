package JAAS;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JAAS_LoginModule implements LoginModule {

	@Override
	public boolean abort() throws LoginException {
		System.out.println("LoginModule.abort");
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		System.out.println("LoginModule.commit");
		return false;
	}

	@Override
	public void initialize(Subject arg0, CallbackHandler arg1, Map<String, ?> arg2, Map<String, ?> arg3) {
		System.out.println("LoginModule.initialize");

	}

	@Override
	public boolean login() throws LoginException {
		System.out.println("LoginModule.login");
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		System.out.println("LoginModule.login");
		return false;
	}

}
