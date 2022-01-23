package Cliente;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import Servidor.IServidorRemoto;
import windows.login;
public class MainCliente {
	public static login clog;
	public static void main(String[] args) {
		
		if (args.length != 3) {
			System.out.println("uso: java [policy] [codebase] ParteUsuario.MainCliente [ip] [port] [name]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			int i =0;
			BufferedReader br2;
			String line2 = "";
			try {
				br2 = new BufferedReader(new FileReader("usuarios.txt"));			
				String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
				IServidorRemoto serviceStub = (IServidorRemoto) java.rmi.Naming.lookup(name);
				//System.out.println("* Message comming from the server: '" + serviceStub.holaServidor() + "'");
				serviceStub.registro();
				serviceStub.loginDatos();
					
				br2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		} catch (Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
