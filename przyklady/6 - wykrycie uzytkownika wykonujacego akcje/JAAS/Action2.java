package JAAS;

import java.security.PrivilegedAction;

import javax.naming.Context;
import javax.security.auth.Subject;

public class Action2 implements PrivilegedAction {

	@Override
	public Object run() {
		
		System.out.print("Wykonano akcje 2 ");
		
		return null;
	}
	

}
