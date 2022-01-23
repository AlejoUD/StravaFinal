package Servidor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ParteUsuario.usuario;
import window.Principal;


//TODO: Implement Singleton Pattern
public class BidAppService {
	String line;
	String emailContra;
	
	public BidAppService() {
		//TODO: remove when DAO Pattern is implemented
		this.initilizeData();
	}
	
	//TODO: remove when DAO Pattern is implemented
	private void initilizeData() {
		BufferedReader br;
		usuario user0 = new usuario();
		
			try {
				br = new BufferedReader(new FileReader("usuarios.txt"));
				line = br.readLine();
				while (line != null) {
					String data[] = line.split(" ");
					user0.setEmail(data[4]);
					user0.setNombre(data[1]);
					user0.setContrasenya(data[7]);
					line = br.readLine();
				}
				br.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
							
		
	}
}