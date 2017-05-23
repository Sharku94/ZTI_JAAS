package JAAS;

import java.security.PrivilegedAction;

public class Action1 implements PrivilegedAction {
@Override
public Object run() {
	System.out.print("Wykonano akcje 1 ");
	return null;
}
}
