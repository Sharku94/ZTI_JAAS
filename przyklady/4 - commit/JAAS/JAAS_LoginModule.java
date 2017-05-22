package JAAS;

import java.io.IOException;
import java.util.Map;
import java.util.jar.Attributes.Name;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JAAS_LoginModule implements LoginModule {
	public static final String[][] USERS = {{"user1","password1"},{"user2","password2"}};
	
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;
	private JAAS_Principal jaas_Principal = null;

	@Override
	public boolean abort() throws LoginException {

		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		boolean flag = false;
		if (subject !=null && !subject.getPrincipals().contains(jaas_Principal)){
			subject.getPrincipals().add(jaas_Principal);
			flag = true;
		}

		return flag;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> arg2, Map<String, ?> arg3) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		

	}

	@Override
	public boolean login() throws LoginException {
		boolean flag = false;
		Callback[] callbackArray = new Callback[2];
		callbackArray[0] = new NameCallback("Username:");
		callbackArray[1] = new PasswordCallback("Password:", false);
		try {
			callbackHandler.handle(callbackArray);
			String name = ((NameCallback)callbackArray[0]).getName();
			String password = new String(((PasswordCallback) callbackArray[1]).getPassword());
			int i = 0;
			while (i < USERS.length){
				if (USERS[i][0].equals(name) && USERS[i][1].equals(password)){
					System.out.println("Autentykacja przebiegla pomyslnie");
					jaas_Principal = new JAAS_Principal(name);
					flag = true;
					break;
				}
				i++;				
			}
			if(!flag)
				throw new FailedLoginException("Blad autentykacji!");
		} catch (IOException | UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean logout() throws LoginException {

		return false;
	}

}
