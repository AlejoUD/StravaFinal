package Servidor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import ParteUsuario.usuario;



public class ServidorRemoto extends UnicastRemoteObject implements IServidorRemoto {

	String line;
	String loginS;
	String line2;
	String result2;
	protected ServidorRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cont = 0;
	private Map<Long, usuario> serverState = new HashMap<>();
	private LoginAppService loginService = new LoginAppService();
	private BidAppService bidService = new BidAppService();

	public String holaServidor(){
		cont++;
		System.out.println(" * Client number: " + cont);
		return "Hola mundo!";
	}
	public void loginDatos() {
		BufferedReader br2;
		result2 = "";
		try {
			br2 = new BufferedReader(new FileReader("usuarios.txt"));
			line2 = br2.readLine();
			while (line2 != null) {
				String data[] = line2.split(" ");
				System.out.println("Se ha logueado el usuario con: "+"Email: "+data[4]+" , Contraseña: "+data[7]);
				//result2 = "Se ha logueado el usuario con: "+"Email: "+ data[4]+ " , Contraseña: "+data[7];
				line2 = br2.readLine();
			}
			br2.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	
	//System.out.println("Se ha registrado un nuevo usuario: Nombre: "+data[1]+" , Email: "+data[4]+" , Contraseña: "+data[7]+ " , Peso: "+data[10] + " , Altura: "+data[13]+" , Frecuencia cardiaca maxima: "+data[18]+ " , Frecuencia cardiaca minima: "+data[24] );
	public void registro() {
		BufferedReader br2;
		result2 = "";
		try {
			br2 = new BufferedReader(new FileReader("usuarios.txt"));
			line2 = br2.readLine();
			while (line2 != null) {
				String data[] = line2.split(" ");
				System.out.println("Se ha registrado un nuevo usuario: Nombre: "+data[1]+" , Email: "+data[4]+" , Contraseña: "+data[7]+ " , Peso: "+data[10] + " , Altura: "+data[13]+" , Frecuencia cardiaca maxima: "+data[18]+ " , Frecuencia cardiaca minima: "+data[24]+", Fecha de nacimiento: "+data[29] );
				//result2 = "Se ha logueado el usuario con: "+"Email: "+ data[4]+ " , Contraseña: "+data[7];
				line2 = br2.readLine();
			}
			br2.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] Servidor.ServidorRemoto [ip] [port] [name]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			ServidorRemoto serviceObject = new ServidorRemoto();
			Naming.rebind(name, serviceObject);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
		
		//Perform login() using LoginAppService
		usuario user = loginService.login(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	@Override
	public synchronized void logout(long token) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

}
