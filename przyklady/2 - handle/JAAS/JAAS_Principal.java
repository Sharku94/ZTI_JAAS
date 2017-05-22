package JAAS;

import java.io.Serializable;
import java.security.Principal;

public class JAAS_Principal implements Principal, Serializable {
@Override
public String getName() {
	System.out.println("Principal.getName");
	return null;
}
}
