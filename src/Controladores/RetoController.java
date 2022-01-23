package Controladores;

import java.rmi.RemoteException;
import java.util.List;

import DTO.RetoDTO;
import Remoto.ServiceLocator;

public class RetoController {
	//Reference to the Service Locator
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}

	public List<RetoDTO> getRetos() {
		try {
			return this.serviceLocator.getService().getRetos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
