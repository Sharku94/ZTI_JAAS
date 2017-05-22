package JAAS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Main {
	public enum Action {action1, action2, logout};

	public static void main(String[] args){
		Main driver = new Main();
		LoginContext loginContext = null;
		System.setProperty("java.security.auth.login.config", "jaas_zti.config");
		while (true){
		try {
			loginContext = new LoginContext("Jaas", new JAAS_CallbackHandler());
			loginContext.login();
			boolean flag = true;
			while (flag)
				flag = driver.performAction(loginContext);
		} catch (LoginException | IOException e) {
			System.out.println(e.getMessage());
		}
		}

	}
	boolean performAction(LoginContext loginContext) throws IOException, LoginException{
		boolean flag = true;
		System.out.println("Wykonaj: action1, action2 lub logout");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		switch (Action.valueOf(buffer.readLine())){
		case action1:
			break;
		case action2:
			break;
		case logout:
			loginContext.logout();
			System.out.println("Wylogowano");
			flag = false;
			break;
		default:
			System.out.println("Bledna akcja");
			break;
		
		}
		return flag;
	}

}
