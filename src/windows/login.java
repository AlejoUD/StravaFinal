package windows;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class login {

	private JFrame frame;
	private JTextField tEmail;
	private JLabel lContrasenya;
	private JTextField tContrasenya;
	private JButton btnIniciarGoogle;
	private JButton btnIniciarFacebook;
	private JButton btnRegistrarse;
	String line;
	String emailContra;
	public boolean log;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 102, 0));
		frame.setBounds(100, 100, 562, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lEmail = new JLabel("Email");
		lEmail.setBounds(156, 29, 203, 35);
		frame.getContentPane().add(lEmail);
		
		tEmail = new JTextField();
		tEmail.setBounds(156, 75, 203, 30);
		frame.getContentPane().add(tEmail);
		tEmail.setColumns(10);
		
		lContrasenya = new JLabel("Contraseña");
		lContrasenya.setBounds(156, 116, 203, 35);
		frame.getContentPane().add(lContrasenya);
		
		tContrasenya = new JTextField();
		tContrasenya.setColumns(10);
		tContrasenya.setBounds(156, 162, 203, 30);
		frame.getContentPane().add(tContrasenya);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setIcon(null);
		btnIniciarSesion.setBounds(299, 242, 146, 23);
		frame.getContentPane().add(btnIniciarSesion);
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comprobarEmail();
				frame.dispose();
				
			}
		});
		
		btnIniciarGoogle = new JButton("Iniciar sesión con Google");
		btnIniciarGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnIniciarGoogle.setBounds(273, 276, 196, 23);
		frame.getContentPane().add(btnIniciarGoogle);
		
		btnIniciarFacebook = new JButton("Iniciar sesión con Facebook");
		btnIniciarFacebook.setBounds(273, 310, 196, 23);
		frame.getContentPane().add(btnIniciarFacebook);
		
		panel = new JPanel();
		panel.setBounds(75, 276, 162, 23);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(0, 0, 162, 23);
		panel.add(btnRegistrarse);
		
//		JLabel lblNewLabel = new JLabel("");
//		Image img = new ImageIcon(this.getClass().getResource("/strava.jpg")).getImage();
//		lblNewLabel.setIcon(new ImageIcon(img));
//		lblNewLabel.setBounds(69, 11, 400, 358);
//		frame.getContentPane().add(lblNewLabel);
//		
//		lblNewLabel_1 = new JLabel("");
//		Image img1 = new ImageIcon(this.getClass().getResource("/iconoStrava.png")).getImage();
//		lblNewLabel_1.setIcon(new ImageIcon(img1));
//		lblNewLabel_1.setBounds(10, 11, 60, 60);
//		frame.getContentPane().add(lblNewLabel_1);
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new registrarse();
				frame.dispose();
			}
		});
	}
	public String comprobarEmail() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("usuarios.txt"));
			line = br.readLine();
			while (line != null) {
				String data[] = line.split(" ");
				if(data[4].equals(tEmail.getText()) && data[7].equals(tContrasenya.getText())) {
					emailContra = tEmail.getText()+" "+tContrasenya.getText();
					new Principal();
					log = true;
					line = br.readLine();
				}
				else {
					System.out.println("La contraseña o email no coinciden");
					line = br.readLine();
				}
			}
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return emailContra;
	}
}
