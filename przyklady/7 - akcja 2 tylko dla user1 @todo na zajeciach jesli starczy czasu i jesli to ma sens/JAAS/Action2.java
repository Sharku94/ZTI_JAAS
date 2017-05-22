package JAAS;

import java.security.PrivilegedAction;

import javax.security.auth.Subject;

public class Action2 implements PrivilegedAction {
	private Subject subject = null;
	public Action2(Subject subject) {
		this.subject = subject;
	}
	@Override
	public Object run() {
		if (subject.getPrincipals().iterator().next().getName().equals("user1")){
		System.out.print("Wykonano akcje 2 ");
		System.out.println("przez uzytkownika " +subject.getPrincipals().iterator().next().getName());
		}
		else{
			System.out.println("Nie masz uprawnien!");
		}
		return null;
	}
	

}
