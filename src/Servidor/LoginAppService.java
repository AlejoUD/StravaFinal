package Servidor;

import ParteUsuario.usuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		usuario user = new usuario();		
		user.setEmail("x");
		user.setNombre("xabat");		
		//Generate the hash of the password
		//String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("a");
		user.setContrasenya("a");
		
		if (user.getEmail().equals(email) && user.getContrasenya().equals(password)) {		
			return user;
		} else {
			return null;
		}
	}
}