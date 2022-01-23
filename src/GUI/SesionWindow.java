package GUI;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import Controladores.SesionController;
import DTO.RetoDTO;
import DTO.SesionDTO;

public class SesionWindow {
	
	private SesionController controller;
	
	public SesionWindow(SesionController bid) {
		this.controller = bid;
	}

	public List<SesionDTO> getSesion() {
		System.out.println(" Mostrando todas las sesiones: ");
		
		List<SesionDTO> sesiones = this.controller.getSesion();
		
		for (SesionDTO sesion : sesiones) {
			System.out.println("\t* " + sesion.getTitulo());
		}
		
		return sesiones;
	}

	
}
