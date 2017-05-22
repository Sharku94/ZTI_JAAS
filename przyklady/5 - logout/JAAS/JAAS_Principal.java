package JAAS;

import java.io.Serializable;
import java.security.Principal;

public class JAAS_Principal implements Principal, Serializable {
	
	private final String name;
	
	public JAAS_Principal(String name) {
		this.name = name;
	}
@Override
public String getName() {
	return name;
}
}
