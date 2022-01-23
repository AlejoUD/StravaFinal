package GUI;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import Controladores.RetoController;
import DTO.RetoDTO;
import DTO.SesionDTO;

public class RetoWindow {
	
	private RetoController controller;
	
	//This attributes are user for formatting currencies and date
	public RetoWindow(RetoController bid) {
		this.controller = bid;
	}

	public List<RetoDTO> getRetos() {
		System.out.println(" Mostrando todos los retos: ");
		
		List<RetoDTO> retos = this.controller.getRetos();
		
		for (RetoDTO reto : retos) {
			System.out.println("\t* " + reto.getName());
		}
		
		return retos;
	}

	
}
