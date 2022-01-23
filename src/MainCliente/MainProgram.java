package MainCliente;

import java.util.List;

import Controladores.LoginController;
import Controladores.RetoController;
import Controladores.SesionController;
import DTO.RetoDTO;
import DTO.SesionDTO;
import GUI.LoginDialog;
import GUI.RetoWindow;
import GUI.SesionWindow;
import Remoto.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		LoginDialog loginDialog = new LoginDialog(loginController);			
		RetoController retoController = new RetoController(serviceLocator);			
		RetoWindow retoWindow = new RetoWindow(retoController);
		SesionController sesionController = new SesionController(serviceLocator);			
		SesionWindow sesionWindow = new SesionWindow(sesionController);
		
		//Login
		loginDialog.login();		
		
		//Get Reto
		List<RetoDTO> retos = retoWindow.getRetos(); //RELLENAR
		
		//Get Sesion
		List<SesionDTO> sesiones = sesionWindow.getSesion(); //RELLENAR

		//Logout
		loginDialog.logout();
	}
}