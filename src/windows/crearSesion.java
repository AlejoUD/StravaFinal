package windows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ParteUsuario.usuario;
import Servidor.Entrenamiento;

public class crearSesion extends JFrame {
	

	private JFrame frame;
	
	private JTextField tTitulo = new JTextField();
	private JLabel lTitulo = new JLabel("Titulo");
	private JTextField tFechaInicio = new JTextField();
	private JLabel lFechaInicio = new JLabel("Fecha Inicio");
	private JTextField tDistancia = new JTextField();
	private JLabel lDistancia = new JLabel("Distancia");
	private JTextField tDuracion = new JTextField();
	private JLabel lDuracion = new JLabel("Duración");
	private JTextField tDeporte = new JTextField();
	private JLabel lDeporte = new JLabel("Deporte");
	private JTextField tHora = new JTextField();
	private JLabel lHora = new JLabel("Hora de Inicio");
	File file;
	FileWriter fw;
	PrintWriter pw;
	
	private JButton btnCrearSesion = new JButton("Crear Sesion");
	private JButton btnSalir = new JButton("Salir");
	
	JPanel panel = new JPanel();
	JPanel acciones = new JPanel();
	
	public crearSesion() {
		setTitle("Crear Sesion de Entrenamiento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 400);
			
		setLocationRelativeTo(null);
		setLayout(new BorderLayout()); 
		
		 panel.setLayout(new GridLayout(6,2));
		 panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 add(panel, BorderLayout.CENTER);
		 
		 acciones.setLayout(new GridLayout(1,2));
		 acciones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 add(acciones, BorderLayout.NORTH);
		
		 acciones.add(btnCrearSesion);
		 acciones.add(btnSalir);
		 panel.add(lTitulo);
		 panel.add(tTitulo);
		 panel.add(lDeporte);
		 panel.add(tDeporte);
		 panel.add(lDistancia);
		 panel.add(tDistancia);
		 panel.add(lFechaInicio);
		 panel.add(tFechaInicio);
		 panel.add(lHora);
		 panel.add(tHora);
		 panel.add(lDuracion);
		 panel.add(tDuracion);
		 
		 file = new File("sesiones.txt");
			try {
				fw = new FileWriter(file,true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pw = new PrintWriter(fw);
		 
		 
	    //Botones funcionamiento
	    
		 btnCrearSesion.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Entrenamiento entreno = new Entrenamiento();
	            	entreno.setTitulo(tTitulo.getText());
	            	entreno.setFechaInicio(tFechaInicio.getText());
	    			Integer distanciaTest = Integer.parseInt(tDistancia.getText());
	    			entreno.setDistancia(distanciaTest);
	    			entreno.setDuracion(tDuracion.getText());
	    			entreno.setDeporte(tDeporte.getText());
	    			entreno.setHoraInicio(tHora.getText());
;	                crearSesion(entreno);
	            	
	            
	            }
	        });
		 
		 btnSalir.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 frame.dispose();

	            }
	        });
		 
	    
		setResizable(true);
		setVisible(true);
		
	}
	
	public Entrenamiento crearSesion(Entrenamiento entrenamiento) {
		
			entrenamiento.setTitulo(tTitulo.getText());
			entrenamiento.setFechaInicio(tFechaInicio.getText());
			Integer distanciaTest = Integer.parseInt(tDistancia.getText());
			entrenamiento.setDistancia(distanciaTest);
			entrenamiento.setDuracion(tDuracion.getText());
			entrenamiento.setDeporte(tDeporte.getText());
			entrenamiento.setHoraInicio(tHora.getText());
			System.out.println(entrenamiento.toString());
			System.out.println(entrenamiento.getTitulo());
			pw.println("Titulo: "+entrenamiento.getTitulo()+ " , Fecha Inicio: " + entrenamiento.getFechaInicio()+ " , Distancia: "+ entrenamiento.getDistancia() +" , Duracion: " + entrenamiento.getDuracion()+ " , Deporte: "+ entrenamiento.getDeporte()+ " , Hora de Inicio: "+ entrenamiento.getHoraInicio());
			pw.flush();
			pw.close();
		return entrenamiento;
	}
	
	public static void main(String[] args) {
		crearSesion v3 = new crearSesion();
	}

	}




