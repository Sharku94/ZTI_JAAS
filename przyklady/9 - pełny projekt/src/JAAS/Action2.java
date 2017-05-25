package JAAS;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.naming.Context;
import javax.security.auth.Subject;

public class Action2 implements PrivilegedAction {

	@Override
	public Object run() {
		AccessControlContext context =AccessController.getContext();
		Subject subject = Subject.getSubject(context);
		JAAS_Principal principal = (JAAS_Principal) subject.getPrincipals().iterator().next();
		if(principal.getName().equals("user1")){
			System.out.print("Wykonano akcje 2 przez uzytkownika " + principal.getName());
			return null;
		}
		System.out.println("BRAK DOSTEPU DLA UZYTKOWNIKA "+principal.getName());

		
		return null;
	}
	

}