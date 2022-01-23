package windows;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Principal {

	private JFrame frame;
	public final JTextField tUsuarios = new JTextField();


	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCrearReto = new JButton("Crear Reto");
		btnCrearReto.setBounds(10, 72, 169, 45);
		frame.getContentPane().add(btnCrearReto);
		
		JButton btnCrearEntrenamiento = new JButton("Crear Entrenamiento");
		btnCrearEntrenamiento.setBounds(218, 72, 169, 45);
		frame.getContentPane().add(btnCrearEntrenamiento);
		
		JButton btnObtenerReto = new JButton("Ver los retos");
		btnObtenerReto.setBounds(437, 72, 169, 45);
		frame.getContentPane().add(btnObtenerReto);
		
		JButton btnAceptarReto = new JButton("Aceptar Reto");
		btnAceptarReto.setBounds(657, 72, 169, 45);
		frame.getContentPane().add(btnAceptarReto);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(678, 207, 89, 33);
		frame.getContentPane().add(btnLogout);
		tUsuarios.setBounds(10, 272, 66, 1);
		frame.getContentPane().add(tUsuarios);
		tUsuarios.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/iconoStrava.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 11, 59, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/fondo.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(0, 0, 894, 282);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new login();
				frame.dispose();
			}
		});
		
		btnCrearReto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new crearReto();
				frame.dispose();
			}
		});
		btnCrearEntrenamiento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new crearSesion();
				frame.dispose();
			}
		});
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Principal();
				frame.dispose();
			}
		});
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
