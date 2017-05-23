package JAAS;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Main {

	public static void main(String[] args){
		LoginContext loginContext = null;
		System.setProperty("java.security.auth.login.config", "jaas_zti.config");
		try {
			loginContext = new LoginContext("Jaas", new JAAS_CallbackHandler());
			loginContext.login();
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
