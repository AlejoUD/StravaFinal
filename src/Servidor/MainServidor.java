package Servidor;

import java.rmi.Naming;
public class MainServidor {

	public static void main(String[] args) {	
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IServidorRemoto remoteFacade = new ServidorRemoto();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Servidor v1 '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Servidor Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
