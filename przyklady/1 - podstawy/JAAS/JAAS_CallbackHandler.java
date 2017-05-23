package JAAS;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class JAAS_CallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] arg0) throws IOException, UnsupportedCallbackException {
		System.out.println("CallbackHandler.handle");

	}

}
