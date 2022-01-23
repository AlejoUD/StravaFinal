package Controladores;

import java.rmi.RemoteException;
import java.util.List;

import DTO.RetoDTO;
import DTO.SesionDTO;
import Remoto.ServiceLocator;

public class SesionController {
	private ServiceLocator serviceLocator;
	
	public SesionController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}


	public List<SesionDTO> getSesion() {
		try {
			return this.serviceLocator.getService().getSesion();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
}
