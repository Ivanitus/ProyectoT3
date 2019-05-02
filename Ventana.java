import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Ventana {

	private JFrame frmHotel;
	private JTextField email;
	private JPasswordField passwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GestionBBDD gesBBDD = new GestionBBDD();

		frmHotel = new JFrame();
		frmHotel.setTitle("Hotel");
		frmHotel.setBounds(100, 100, 848, 527);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);

		JPanel inicio = new JPanel();
		inicio.setBounds(0, 0, 830, 480);
		frmHotel.getContentPane().add(inicio);
		inicio.setLayout(null);

		JLabel label = new JLabel("Iniciar Sesi\u00F3n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(368, 13, 100, 16);
		inicio.add(label);

		JLabel label_1 = new JLabel("E-mail:");
		label_1.setBounds(313, 37, 56, 16);
		inicio.add(label_1);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(391, 34, 116, 22);
		inicio.add(email);

		JLabel label_2 = new JLabel("Contrase\u00F1a:");
		label_2.setBounds(312, 64, 75, 16);
		inicio.add(label_2);

		passwd = new JPasswordField();
		passwd.setBounds(391, 62, 116, 22);
		inicio.add(passwd);

		JButton iniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		iniciarSesion.setBounds(360, 100, 116, 25);
		inicio.add(iniciarSesion);

		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String emailString = email.getText();
				String contrasena = passwd.getText();
				int idClientePersona = 0;
				String tipoEmpleado = "";
				boolean empleadoBoolean;
				empleadoBoolean = gesBBDD.inicioSesion(emailString, contrasena, frmHotel);
				if (empleadoBoolean) {
					JOptionPane.showMessageDialog(frmHotel, "Empleado");
					email.setText(null);
					passwd.setText(null);
					Empleados empleado = gesBBDD.buscarUnEmpleado(emailString, contrasena);
					tipoEmpleado = empleado.getTipo();
					
				} else {
					idClientePersona = gesBBDD.inicioSesionCliente(emailString, contrasena);
					if (idClientePersona > 0) {
						JOptionPane.showMessageDialog(frmHotel, "Cliente");
						email.setText(null);
						passwd.setText(null);
					} else {
						JOptionPane.showMessageDialog(frmHotel, "Usuario y/o contraseña incorrectos");
					}
				}
			}
		});
	}
}
