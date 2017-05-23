package JAAS;

import java.io.Serializable;
import java.security.Principal;

public class JAAS_Principal implements Principal, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String name;
	
	public JAAS_Principal(String name) {
		this.name = name;
	}
@Override
public String getName() {
	return name;
}
public String toString(){
	return name;
}
public int hashCode(){
	return name.hashCode();
}
public boolean equals(Object o){
	if (!(o instanceof JAAS_Principal))
		return false;
	JAAS_Principal obj = (JAAS_Principal) o;
	if (name.equals(obj.getName()))
		return true;
	return false;
	
}}
