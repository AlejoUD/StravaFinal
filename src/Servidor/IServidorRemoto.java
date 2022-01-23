package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServidorRemoto extends Remote {

	String holaServidor() throws RemoteException;
	void registro() throws RemoteException;
	void loginDatos() throws RemoteException;
	//Remote facade
	public long login(String email, String password) throws RemoteException;
	public void logout(long token) throws RemoteException; 
}
