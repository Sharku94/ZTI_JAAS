package JAAS;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JAAS_LoginModule implements LoginModule {
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;

	@Override
	public boolean abort() throws LoginException {
		System.out.println("LoginModule.abort");
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		System.out.println("LoginModule.commit");
		return true;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> arg2, Map<String, ?> arg3) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		

	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callbackArray = new Callback[2];
		callbackArray[0] = new NameCallback("Username:");
		callbackArray[1] = new PasswordCallback("Password:", false);
		try {
			callbackHandler.handle(callbackArray);
		} catch (IOException | UnsupportedCallbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		System.out.println("LoginModule.login");
		return false;
	}

}
