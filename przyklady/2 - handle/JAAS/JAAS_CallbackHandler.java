package JAAS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class JAAS_CallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callback) throws IOException, UnsupportedCallbackException {

		
		NameCallback nameCallback = (NameCallback) callback[0];
		System.out.println(nameCallback.getPrompt());
		nameCallback.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
		
		PasswordCallback passwordCallback = (PasswordCallback) callback[1];
		System.out.println(passwordCallback.getPrompt());
		passwordCallback.setPassword((new BufferedReader(new InputStreamReader(System.in))).readLine().toCharArray());
		
	}

}