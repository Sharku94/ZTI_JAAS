package JAAS;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class Action1 implements PrivilegedAction {
@Override
public Object run() {
	AccessController.checkPermission(new JAAS_Permission("access"));
	
	System.out.print("Wykonano akcje 1 ");
	return new Integer(0);
}
}
