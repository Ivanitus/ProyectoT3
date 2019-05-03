import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Ventana {

	private JFrame frmHotel;
	private JTextField email;
	private JPasswordField passwd;
	private JTextField numHabitacionEmpleados;
	private JTextField superficieHabitacionEmpleados;
	private JTextField precioHabitacionesEmpleados;
	private JTextField dniHabitacionEmpleados;
	private JComboBox tiposHabitacionEmpleados;

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

		Validar val = new Validar();

		frmHotel = new JFrame();
		frmHotel.setTitle("Hotel");
		frmHotel.setBounds(100, 100, 848, 619);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);

		JPanel empleados = new JPanel();
		empleados.setBounds(0, 0, 832, 580);
		frmHotel.getContentPane().add(empleados);
		empleados.setLayout(null);
		empleados.setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 0, 598, 290);
		empleados.add(scrollPane);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(234, 289, 2, 290);
		empleados.add(separator);

		JPanel inicio = new JPanel();
		inicio.setBounds(0, 0, 832, 580);
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

		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(10, 5, 214, 14);
		empleados.add(lblBienvenido);

		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(10, 18, 214, 14);
		empleados.add(lblTipo);

		JPanel anadirHabitaciones = new JPanel();
		anadirHabitaciones.setBounds(234, 289, 598, 290);
		empleados.add(anadirHabitaciones);
		anadirHabitaciones.setLayout(null);
		anadirHabitaciones.setVisible(false);

		JLabel label_3 = new JLabel("N\u00FAmero habitaci\u00F3n:");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(10, 17, 124, 16);
		anadirHabitaciones.add(label_3);

		numHabitacionEmpleados = new JTextField();
		numHabitacionEmpleados.setToolTipText("");
		numHabitacionEmpleados.setColumns(10);
		numHabitacionEmpleados.setBounds(146, 14, 116, 22);
		anadirHabitaciones.add(numHabitacionEmpleados);

		JLabel label_4 = new JLabel("N\u00FAmero ba\u00F1os:");
		label_4.setBounds(10, 46, 124, 16);
		anadirHabitaciones.add(label_4);

		JSpinner numBanosEmpleados = new JSpinner();
		numBanosEmpleados.setBounds(146, 43, 116, 22);
		anadirHabitaciones.add(numBanosEmpleados);

		JLabel label_5 = new JLabel("N\u00FAmero camas:");
		label_5.setBounds(10, 78, 124, 16);
		anadirHabitaciones.add(label_5);

		JSpinner numCamasEmpleados = new JSpinner();
		numCamasEmpleados.setBounds(146, 75, 116, 22);
		anadirHabitaciones.add(numCamasEmpleados);

		JCheckBox chckbxJacuzziEmpleados = new JCheckBox("Jacuzzi");
		chckbxJacuzziEmpleados.setBounds(336, 43, 97, 23);
		anadirHabitaciones.add(chckbxJacuzziEmpleados);

		JCheckBox chckbxCamaDeMatrimonioEmpleados = new JCheckBox("Cama de matrimonio");
		chckbxCamaDeMatrimonioEmpleados.setBounds(336, 75, 252, 23);
		anadirHabitaciones.add(chckbxCamaDeMatrimonioEmpleados);

		JCheckBox chckbxTerrazaEmpleados = new JCheckBox("Terraza");
		chckbxTerrazaEmpleados.setBounds(336, 104, 97, 23);
		anadirHabitaciones.add(chckbxTerrazaEmpleados);

		JLabel label_6 = new JLabel("Tipo:");
		label_6.setBounds(10, 107, 56, 16);
		anadirHabitaciones.add(label_6);

		tiposHabitacionEmpleados = new JComboBox();
		tiposHabitacionEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tiposHabitacionEmpleados.getSelectedItem() != "Individual") {
					chckbxCamaDeMatrimonioEmpleados.setSelected(true);
				} else {
					chckbxCamaDeMatrimonioEmpleados.setSelected(false);
				}
			}
		});
		tiposHabitacionEmpleados.setBounds(146, 105, 116, 20);
		anadirHabitaciones.add(tiposHabitacionEmpleados);
		tiposHabitacionEmpleados.addItem("Individual");
		tiposHabitacionEmpleados.addItem("Matrimonio");
		tiposHabitacionEmpleados.addItem("Suite");

		JLabel label_7 = new JLabel("Superficie:");
		label_7.setBounds(10, 136, 116, 16);
		anadirHabitaciones.add(label_7);

		superficieHabitacionEmpleados = new JTextField();
		superficieHabitacionEmpleados.setColumns(10);
		superficieHabitacionEmpleados.setBounds(146, 133, 116, 22);
		anadirHabitaciones.add(superficieHabitacionEmpleados);

		JLabel label_8 = new JLabel("Precio habitaciones:");
		label_8.setBounds(336, 14, 116, 16);
		anadirHabitaciones.add(label_8);

		precioHabitacionesEmpleados = new JTextField();
		precioHabitacionesEmpleados.setColumns(10);
		precioHabitacionesEmpleados.setBounds(472, 11, 116, 22);
		anadirHabitaciones.add(precioHabitacionesEmpleados);

		JLabel label_12 = new JLabel("DNI empleado:");
		label_12.setBounds(336, 136, 116, 16);
		anadirHabitaciones.add(label_12);

		dniHabitacionEmpleados = new JTextField();
		dniHabitacionEmpleados.setColumns(10);
		dniHabitacionEmpleados.setBounds(472, 133, 116, 22);
		anadirHabitaciones.add(dniHabitacionEmpleados);

		JButton button = new JButton("Insertar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dniValido = false;
				boolean insertar = false;
				int numHabitacionInt = 0;
				int numBanosInt = 0;
				int numCamasInt = 0;
				String tipoHabitacionString = "";
				String superficieString = "";
				double precioHabitacionesDouble = 0;
				boolean jacuzziBoolean = false;
				boolean camaMatrimonioBoolean = false;
				boolean terrazaBoolean = false;
				String dniEmpleadoString = "";
				try {
					numHabitacionInt = Integer.parseInt(numHabitacionEmpleados.getText());
					if (numHabitacionInt > 0) {
						numHabitacionEmpleados.setBackground(Color.white);
						numBanosInt = (int) numBanosEmpleados.getValue();
						if (numBanosInt > 0) {
							numBanosEmpleados.setBackground(Color.white);
							numCamasInt = (int) numCamasEmpleados.getValue();
							if (numCamasInt > 0) {
								numCamasEmpleados.setBackground(Color.white);
								tipoHabitacionString = (String) tiposHabitacionEmpleados.getSelectedItem();
								superficieString = superficieHabitacionEmpleados.getText();
								if (superficieString.length() <= 20) {
									superficieHabitacionEmpleados.setBackground(Color.white);
									precioHabitacionesDouble = Double
											.parseDouble(precioHabitacionesEmpleados.getText());
									if (precioHabitacionesDouble > 0) {
										precioHabitacionesEmpleados.setBackground(Color.white);
										jacuzziBoolean = chckbxJacuzziEmpleados.isSelected();
										camaMatrimonioBoolean = chckbxCamaDeMatrimonioEmpleados.isSelected();
										terrazaBoolean = chckbxTerrazaEmpleados.isSelected();
										dniEmpleadoString = dniHabitacionEmpleados.getText();
										dniValido = val.comprobarDNI(dniEmpleadoString);
										if (dniValido) {
											if (dniHabitacionEmpleados.getBackground() != Color.white) {
												dniHabitacionEmpleados.setBackground(Color.white);
											}
											Habitaciones habitacionAnadir = new Habitaciones(superficieString,
													tipoHabitacionString, numBanosInt, numCamasInt, numHabitacionInt,
													precioHabitacionesDouble, jacuzziBoolean, camaMatrimonioBoolean,
													terrazaBoolean);
											insertar = gesBBDD.insertarHabitaciones(habitacionAnadir,
													dniEmpleadoString);
											if (insertar) {
												JOptionPane.showMessageDialog(empleados,
														"Habitación insertada con éxito");
												numHabitacionEmpleados.setText(null);
												numBanosEmpleados.setValue(0);
												numCamasEmpleados.setValue(0);
												tiposHabitacionEmpleados.setSelectedIndex(0);
												superficieHabitacionEmpleados.setText(null);
												precioHabitacionesEmpleados.setText(null);
												chckbxJacuzziEmpleados.setSelected(false);
												chckbxCamaDeMatrimonioEmpleados.setSelected(false);
												chckbxTerrazaEmpleados.setSelected(false);
												dniHabitacionEmpleados.setText(null);
											} else {
												JOptionPane.showMessageDialog(empleados,
														"La habitación no ha podido ser insertada");
											}
										} else {
											JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
											dniHabitacionEmpleados.setBackground(new Color(240, 128, 128));
										}
									} else {
										JOptionPane.showMessageDialog(empleados,
												"El precio de la habitación debe ser superior a 0");
										precioHabitacionesEmpleados.setBackground(new Color(240, 128, 128));
									}
								} else {
									JOptionPane.showMessageDialog(empleados,
											"La superficie debe ser inferior a 20 caractéres");
									superficieHabitacionEmpleados.setBackground(new Color(240, 128, 128));
								}
							} else {
								JOptionPane.showMessageDialog(empleados, "El numero de camas debe ser superior a 0");
								numCamasEmpleados.setBackground(new Color(240, 128, 128));
							}
						} else {
							JOptionPane.showMessageDialog(empleados, "El numero de baños debe ser superior a 0");
							numBanosEmpleados.setBackground(new Color(248, 128, 128));
						}
					} else {
						JOptionPane.showMessageDialog(empleados, "El numero de la habitación debe ser superior a 0");
						numHabitacionEmpleados.setBackground(new Color(248, 128, 128));
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
				}
			}
		});
		button.setBounds(491, 254, 97, 25);
		anadirHabitaciones.add(button);

		JButton button_1 = new JButton("Ocultar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
			}
		});
		button_1.setBounds(10, 254, 97, 25);
		anadirHabitaciones.add(button_1);

		JLabel lblM = new JLabel("m\u00B2");
		lblM.setBounds(270, 137, 13, 14);
		anadirHabitaciones.add(lblM);

		JButton btnAnadirHabitaciones = new JButton("A\u00F1adir habitaciones");
		btnAnadirHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirHabitaciones.setVisible(true);
			}
		});
		btnAnadirHabitaciones.setBounds(10, 36, 214, 23);
		empleados.add(btnAnadirHabitaciones);

		JButton btnEliminarHabitaciones = new JButton("Eliminar habitaciones");
		btnEliminarHabitaciones.setBounds(10, 70, 214, 23);
		empleados.add(btnEliminarHabitaciones);

		JButton btnMostrarHabitaciones = new JButton("Mostrar habitaciones");
		btnMostrarHabitaciones.setBounds(10, 138, 214, 23);
		empleados.add(btnMostrarHabitaciones);

		JButton btnAnadirActividades = new JButton("A\u00F1adir actividades");
		btnAnadirActividades.setBounds(10, 172, 214, 23);
		empleados.add(btnAnadirActividades);

		JButton btnBorrarActividades = new JButton("Borrar actividades");
		btnBorrarActividades.setBounds(10, 206, 214, 23);
		empleados.add(btnBorrarActividades);

		JButton btnModificarActividades = new JButton("Modificar actividades");
		btnModificarActividades.setBounds(10, 240, 214, 23);
		empleados.add(btnModificarActividades);

		JButton btnMostrarActividades = new JButton("Mostrar actividades");
		btnMostrarActividades.setBounds(10, 274, 214, 23);
		empleados.add(btnMostrarActividades);

		JButton btnModificarHabitaciones = new JButton("Modificar habitaciones");
		btnModificarHabitaciones.setBounds(10, 104, 214, 23);
		empleados.add(btnModificarHabitaciones);

		JButton btnAnadirEmpleado = new JButton("A\u00F1adir empleado");
		btnAnadirEmpleado.setBounds(10, 308, 214, 23);
		empleados.add(btnAnadirEmpleado);

		JButton btnBorrarEmpleado = new JButton("Borrar empleado");
		btnBorrarEmpleado.setBounds(10, 342, 214, 23);
		empleados.add(btnBorrarEmpleado);

		JButton btnMostrarEmpleados = new JButton("Mostrar empleados (WIP)");
		btnMostrarEmpleados.setBounds(10, 376, 214, 23);
		empleados.add(btnMostrarEmpleados);
		btnMostrarEmpleados.setEnabled(false);

		JButton btnMostrarMovimientos = new JButton("Mostrar movimientos");
		btnMostrarMovimientos.setBounds(10, 410, 214, 23);
		empleados.add(btnMostrarMovimientos);

		JButton btnModificarDatosPersonales = new JButton("Modificar datos personales");
		btnModificarDatosPersonales.setBounds(10, 512, 214, 23);
		empleados.add(btnModificarDatosPersonales);

		JButton btnMostrarReservas = new JButton("Mostrar reservas (WIP)");
		btnMostrarReservas.setBounds(10, 444, 214, 23);
		empleados.add(btnMostrarReservas);
		btnMostrarReservas.setEnabled(false);

		JButton btnMostrarClientes = new JButton("Mostrar clientes (WIP)");
		btnMostrarClientes.setBounds(10, 478, 214, 23);
		empleados.add(btnMostrarClientes);
		btnMostrarClientes.setEnabled(false);

		JButton iniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		iniciarSesion.setBounds(360, 100, 116, 25);
		inicio.add(iniciarSesion);

		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String emailString = email.getText();
				String contrasena = passwd.getText();
				int idClientePersona = 0;
				String tipoEmpleado = "";
				String nombreEmpleado = "";
				boolean empleadoBoolean;
				empleadoBoolean = gesBBDD.inicioSesion(emailString, contrasena, frmHotel);
				if (empleadoBoolean) {
					email.setText(null);
					passwd.setText(null);
					Empleados empleado = gesBBDD.buscarUnEmpleado(emailString, contrasena);
					empleados.setVisible(true);
					inicio.setVisible(false);
					tipoEmpleado = empleado.getTipo();
					nombreEmpleado = empleado.getNombre() + " " + empleado.getApellidos();
					lblBienvenido.setText(lblBienvenido.getText() + " " + nombreEmpleado);
					if (tipoEmpleado.trim().equalsIgnoreCase("gerente")) {
						frmHotel.setTitle("Hotel: Gerente");
						lblTipo.setText(lblTipo.getText() + " Gerente");
					}
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

		JButton btnCerrarSesionEmpleados = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesionEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirHabitaciones.setVisible(false);
				empleados.setVisible(false);
				lblBienvenido.setText("Bienvenido");
				lblTipo.setText("Tipo:");
				frmHotel.setTitle("Hotel");
				JOptionPane.showMessageDialog(frmHotel, "Has cerrado sesión correctamente");
				inicio.setVisible(true);
			}
		});
		btnCerrarSesionEmpleados.setBounds(10, 546, 214, 23);
		empleados.add(btnCerrarSesionEmpleados);

	}
}
