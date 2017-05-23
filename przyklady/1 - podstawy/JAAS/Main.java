package JAAS;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Main {

	public static void main(String[] args) throws LoginException {
		LoginContext loginContext = null;
		System.setProperty("java.security.auth.login.config", "jaas_zti.config");
		loginContext = new LoginContext("Jaas", new JAAS_CallbackHandler());
		loginContext.login();

	}

}
