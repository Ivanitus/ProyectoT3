import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import d_tablas.TableableModel;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Ventana {

	private JFrame frmHotel;
	private JTextField email;
	private JPasswordField passwd;
	private JTable tablaClientes;
	private JTextField modificarNombre;
	private JTextField modificarApellidos;
	private JTextField modificarTelefono;
	private JTextField modificarEmail;
	private JPasswordField modificarClave;
	private JTextField modificarInteres;
	private JTextField bajaCliente;
	private ArrayList<Actividades> listaActividades = new ArrayList<>();
	private ArrayList<Habitaciones> listaHabitaciones = new ArrayList<>();
	private JTextField reservarHabitacionesNº;
	private JTextField reservarHabitacionesDni;
	private JTextField dniReservaActividades;
	private JTextField codigoReservaActividades;
	private JTextField nºcancelarHabitacion;
	private JTextField textfieldCodigoCancelarActividad;
	private JTextField textFieldDniCancelarActividad;
	private JTextField txtMenuRegistrarNuevo;
	private JTextField NombreRegistro;
	private JTextField apellidosRegistro;
	private JTextField dniRegisro;
	private JTextField telefonoRegistro;
	private JPasswordField claveRegistro;
	private JTextField emailRegistro;
	private JTextField interesRegistro;
	private JPasswordField confirmarClave;
	private JTable tableInvitado;
	private ArrayList<MostrarReservaActividadCliente> listaMostrarReservaActividadCliente = new ArrayList<>();
	private ArrayList<MostrarReservaHabitacionCliente> listaMostrarReservaHabitacionCliente = new ArrayList<>();
	private ArrayList<Clientes> listaMostrarDatosCliente = new ArrayList<>();

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
					System.out.println("Fallo en la ejecución de la aplicación");
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
		TableableModel modelo = new TableableModel();
		Validar validar = new Validar();

		frmHotel = new JFrame();
		frmHotel.setResizable(false);
		frmHotel.setTitle("Hotel");
		frmHotel.setBounds(100, 100, 848, 619);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);

		JPanel invitado = new JPanel();
		invitado.setBounds(0, 0, 842, 580);
		frmHotel.getContentPane().add(invitado);
		invitado.setLayout(null);
		invitado.setVisible(false);

		JPanel registrarse = new JPanel();
		registrarse.setBounds(0, 0, 842, 580);
		frmHotel.getContentPane().add(registrarse);
		registrarse.setLayout(null);
		registrarse.setVisible(false);

		JPanel clientes = new JPanel();
		clientes.setBounds(0, 0, 842, 580);
		frmHotel.getContentPane().add(clientes);
		clientes.setLayout(null);
		clientes.setVisible(false);

		JPanel inicio = new JPanel();
		inicio.setBounds(0, 0, 842, 580);
		frmHotel.getContentPane().add(inicio);
		inicio.setLayout(null);

		JPanel darDeBaja = new JPanel();
		darDeBaja.setBounds(236, 289, 607, 290);
		clientes.add(darDeBaja);
		darDeBaja.setLayout(null);
		darDeBaja.setVisible(false);

		JPanel modificar = new JPanel();
		modificar.setBounds(236, 289, 607, 290);
		clientes.add(modificar);
		modificar.setLayout(null);
		modificar.setVisible(false);

		JPanel cancelarReservaActividades = new JPanel();
		cancelarReservaActividades.setBounds(236, 289, 607, 290);
		clientes.add(cancelarReservaActividades);
		cancelarReservaActividades.setLayout(null);
		cancelarReservaActividades.setVisible(false);

		JPanel mostrarReservasCliente = new JPanel();
		mostrarReservasCliente.setBounds(236, 289, 607, 290);
		clientes.add(mostrarReservasCliente);
		mostrarReservasCliente.setLayout(null);
		mostrarReservasCliente.setVisible(false);

		JPanel CancelarReservaHabitacion = new JPanel();
		CancelarReservaHabitacion.setBounds(236, 289, 607, 290);
		clientes.add(CancelarReservaHabitacion);
		CancelarReservaHabitacion.setLayout(null);
		CancelarReservaHabitacion.setVisible(false);

		JPanel reservarActividades = new JPanel();
		reservarActividades.setBounds(236, 289, 607, 290);
		clientes.add(reservarActividades);
		reservarActividades.setLayout(null);
		reservarActividades.setVisible(false);

		JPanel reservarHabitaciones = new JPanel();
		reservarHabitaciones.setBounds(236, 289, 607, 290);
		clientes.add(reservarHabitaciones);
		reservarHabitaciones.setVisible(false);
		reservarHabitaciones.setLayout(null);
		reservarHabitaciones.setVisible(false);

		JSeparator separatorInvitados = new JSeparator();
		separatorInvitados.setOrientation(SwingConstants.VERTICAL);
		separatorInvitados.setBounds(234, 289, 2, 290);
		invitado.add(separatorInvitados);

		JScrollPane scrollPaneInvitado = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneInvitado.setBounds(234, 0, 609, 290);
		invitado.add(scrollPaneInvitado);

		tableInvitado = new JTable();
		scrollPaneInvitado.setViewportView(tableInvitado);
		tableInvitado.setModel(modelo);
		tableInvitado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JLabel bienvenidoClientes = new JLabel("Bienvenido Invitado");
		bienvenidoClientes.setBounds(10, 5, 214, 14);
		invitado.add(bienvenidoClientes);
		bienvenidoClientes.setVisible(false);

		JButton btnMostrarActividades = new JButton("Mostrar Actividades");
		btnMostrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaActividades = gesBBDD.mostrarActividades(clientes);
				modelo.rellenarTabla(listaActividades, true);
				listaActividades.clear();

			}
		});
		btnMostrarActividades.setBounds(10, 36, 214, 23);
		invitado.add(btnMostrarActividades);

		JButton btnMostrarHabitaciones = new JButton("Mostrar Habitaciones");
		btnMostrarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaHabitaciones = gesBBDD.mostrarHabitaciones();
				modelo.rellenarTabla(listaHabitaciones, true);
				listaHabitaciones.clear();
			}
		});
		btnMostrarHabitaciones.setBounds(10, 70, 214, 23);
		invitado.add(btnMostrarHabitaciones);

		JButton btnVolverAInicio = new JButton("Volver a Inicio");
		btnVolverAInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				invitado.setVisible(false);
				inicio.setVisible(true);
				registrarse.setVisible(false);
			}
		});
		btnVolverAInicio.setBounds(10, 546, 214, 23);
		invitado.add(btnVolverAInicio);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.vaciarTabla();
			}
		});
		btnNewButton.setBounds(223, 0, 12, 18);
		invitado.add(btnNewButton);

		txtMenuRegistrarNuevo = new JTextField();
		txtMenuRegistrarNuevo.setForeground(Color.BLACK);
		txtMenuRegistrarNuevo.setBackground(Color.WHITE);
		txtMenuRegistrarNuevo.setEditable(false);
		txtMenuRegistrarNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenuRegistrarNuevo
				.setText("Menu Registrar Nuevo Usuario, rellene los campos solicitados para un registro correcto");
		txtMenuRegistrarNuevo.setBounds(162, 23, 505, 20);
		registrarse.add(txtMenuRegistrarNuevo);
		txtMenuRegistrarNuevo.setColumns(10);

		JLabel nombreRegistro = new JLabel("Nombre:");
		nombreRegistro.setBounds(108, 94, 75, 14);
		registrarse.add(nombreRegistro);

		JLabel lblApellidosRegistro = new JLabel("Apellidos:");
		lblApellidosRegistro.setBounds(437, 94, 75, 14);
		registrarse.add(lblApellidosRegistro);

		JLabel lblDniRegistro = new JLabel("DNI:");
		lblDniRegistro.setBounds(108, 129, 75, 14);
		registrarse.add(lblDniRegistro);

		JLabel lblTelefonoRegistro = new JLabel("Telefono:");
		lblTelefonoRegistro.setBounds(108, 166, 75, 14);
		registrarse.add(lblTelefonoRegistro);

		JLabel lblClaveRegistro = new JLabel("Clave:");
		lblClaveRegistro.setBounds(108, 201, 46, 14);
		registrarse.add(lblClaveRegistro);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(437, 129, 46, 14);
		registrarse.add(lblEdad);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(437, 166, 46, 14);
		registrarse.add(lblEmail);

		JLabel lblInteresRegistro = new JLabel("Interes:");
		lblInteresRegistro.setBounds(437, 201, 46, 14);
		registrarse.add(lblInteresRegistro);

		JLabel lblConfimarClave = new JLabel("Confimar Clave:");
		lblConfimarClave.setBounds(108, 240, 94, 14);
		registrarse.add(lblConfimarClave);

		confirmarClave = new JPasswordField();
		confirmarClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (confirmarClave.getText().length() == 20) {
					e.consume();
				}
			}
		});
		confirmarClave.setBounds(212, 233, 86, 20);
		registrarse.add(confirmarClave);

		NombreRegistro = new JTextField();
		NombreRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (NombreRegistro.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();

				}
			}
		});
		NombreRegistro.setBounds(212, 91, 86, 20);
		registrarse.add(NombreRegistro);
		NombreRegistro.setColumns(10);

		apellidosRegistro = new JTextField();
		apellidosRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (apellidosRegistro.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();

				}
			}
		});
		apellidosRegistro.setBounds(538, 91, 86, 20);
		registrarse.add(apellidosRegistro);
		apellidosRegistro.setColumns(10);

		dniRegisro = new JTextField();
		dniRegisro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniRegisro.getText().length() == 9) {
					e.consume();
				}
			}
		});
		dniRegisro.setBounds(212, 126, 86, 20);
		registrarse.add(dniRegisro);
		dniRegisro.setColumns(10);

		telefonoRegistro = new JTextField();
		telefonoRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (telefonoRegistro.getText().length() == 9) {
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				}
			}
		});
		telefonoRegistro.setBounds(212, 163, 86, 20);
		registrarse.add(telefonoRegistro);
		telefonoRegistro.setColumns(10);

		claveRegistro = new JPasswordField();
		claveRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (claveRegistro.getText().length() == 20) {
					e.consume();
				}
			}
		});
		claveRegistro.setBounds(212, 198, 86, 20);
		registrarse.add(claveRegistro);

		DatePickerSettings dateSettingsRegistroClientes = new DatePickerSettings();
		dateSettingsRegistroClientes.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsRegistroClientes.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsRegistroClientes.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsRegistroClientes.setGapBeforeButtonPixels(0);
		DatePicker RegistroClientes = new DatePicker(dateSettingsRegistroClientes);
		dateSettingsRegistroClientes.setDateRangeLimits(null, LocalDate.now());
		RegistroClientes.setDateToToday();
		RegistroClientes.setBounds(538, 124, 166, 26);
		registrarse.add(RegistroClientes);

		emailRegistro = new JTextField();
		emailRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (emailRegistro.getText().length() == 50) {
					e.consume();
				}
			}
		});
		emailRegistro.setBounds(538, 163, 86, 20);
		registrarse.add(emailRegistro);
		emailRegistro.setColumns(10);

		interesRegistro = new JTextField();
		interesRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (interesRegistro.getText().length() == 40) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();

				}
			}
		});
		interesRegistro.setBounds(538, 198, 86, 20);
		registrarse.add(interesRegistro);
		interesRegistro.setColumns(10);

		JButton enviarRegistroCliente = new JButton("Enviar");
		enviarRegistroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean validarDni = false;
				boolean validarEmail = false;

				try {

					String nombre = NombreRegistro.getText();

					if (nombre.length() > 0 && nombre.length() <= 20) {

						String apellidos = apellidosRegistro.getText();
						if (apellidos.length() > 0 && apellidos.length() <= 40) {

							String dni = dniRegisro.getText();
							validarDni = validar.comprobarDNI(dni);
							if (validarDni) {

								LocalDate fechaNacimiento = RegistroClientes.getDate();
								int edad = (int) Period.between(fechaNacimiento, LocalDate.now()).getYears();

								if (edad >= 18 && edad < 99) {

									String telefono = telefonoRegistro.getText();
									if (telefono.length() == 9) {
										int telefonoInt = Integer.parseInt(telefono);
										String email = emailRegistro.getText();

										if (email.length() > 0 && email.length() <= 50) {

											validarEmail = validar.comprobarEmail(email);
											if (validarEmail) {

												String clave = claveRegistro.getText();

												if (clave.length() > 0 && clave.length() <= 20) {

													String confirClave = confirmarClave.getText();

													if (clave.equalsIgnoreCase(confirClave)) {

														String interes = interesRegistro.getText();

														if (interes.length() > 0 && interes.length() <= 40) {

															Clientes cliente = new Clientes(nombre, apellidos, dni,
																	telefonoInt, edad, email, interes);

															boolean insertar = gesBBDD.insertarPersonas(cliente);

															if (insertar) {
																JOptionPane.showMessageDialog(registrarse,
																		"Registro realizado con exito");
																registrarse.setVisible(false);
																clientes.setVisible(true);
																confirmarClave.setText("");
																NombreRegistro.setText("");
																apellidosRegistro.setText("");
																dniRegisro.setText("");
																telefonoRegistro.setText("");
																claveRegistro.setText("");
																emailRegistro.setText("");
																interesRegistro.setText("");

															} else {
																JOptionPane.showMessageDialog(registrarse,
																		"No se ha podido realizar el registro.");

																confirmarClave.setText("");
																NombreRegistro.setText("");
																apellidosRegistro.setText("");
																dniRegisro.setText("");
																telefonoRegistro.setText("");
																claveRegistro.setText("");
																emailRegistro.setText("");
																interesRegistro.setText("");

															}

														} else {
															JOptionPane.showMessageDialog(registrarse,
																	"El registro de interes no puede ser mayor a 40 caracteres o estar vacio");
														}

													} else {
														JOptionPane.showMessageDialog(registrarse,
																"Las claves no coinciden.");
													}

												} else {
													JOptionPane.showMessageDialog(registrarse,
															"La clave no puede ser mayor a 20 caracteres.");
												}
											} else {
												JOptionPane.showMessageDialog(registrarse, "El email no es valido.");
											}
										} else {
											JOptionPane.showMessageDialog(registrarse,
													"El email supera la longitud establecida.");
										}
									} else {
										JOptionPane.showMessageDialog(registrarse,
												"El telefono tiene que tener 9 digitos y no estar vacio.");
									}
								} else {
									JOptionPane.showMessageDialog(registrarse,
											"La edad no puede ser inferior a 18 años.");
								}
							} else {
								JOptionPane.showMessageDialog(registrarse, "El DNI introducido no es valido");
							}
						} else {
							JOptionPane.showMessageDialog(registrarse,
									"El campo apellidos no puede ser mayor a 40 caracteres ni estar vacio.");
						}

					} else {
						JOptionPane.showMessageDialog(registrarse,
								"El campo nombre no puede ser mayor a 20 caracteres ni estar vacio");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}
			}
		});
		enviarRegistroCliente.setBounds(535, 319, 89, 23);
		registrarse.add(enviarRegistroCliente);

		JButton volverRegistroCliente = new JButton("Volver");
		volverRegistroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarse.setVisible(false);
				CancelarReservaHabitacion.setVisible(true);
				modificar.setVisible(false);
				reservarActividades.setVisible(false);
				reservarHabitaciones.setVisible(false);
				darDeBaja.setVisible(false);
				// calendarioReservarHabitaciones.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				inicio.setVisible(true);
				mostrarReservasCliente.setVisible(false);
				invitado.setVisible(false);

			}
		});
		volverRegistroCliente.setBounds(212, 319, 89, 23);
		registrarse.add(volverRegistroCliente);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(234, 0, 609, 290);
		clientes.add(scrollPane);

		tablaClientes = new JTable();
		scrollPane.setViewportView(tablaClientes);
		tablaClientes.setModel(modelo);
		tablaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(234, 289, 2, 290);
		clientes.add(separator);

		JLabel lblNewLabel = new JLabel("Bienvenido ");
		lblNewLabel.setBounds(10, 5, 214, 14);
		clientes.add(lblNewLabel);

		JLabel cancelacionHabitacion = new JLabel(
				"<html><body><center>Menu de Cancelacion de reserva realizada, por favor rellene los campos solicitados.</center></body></html>");
		cancelacionHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		cancelacionHabitacion.setBounds(10, 11, 578, 39);
		CancelarReservaHabitacion.add(cancelacionHabitacion);

		JLabel lblFechaCancelacionHabitacion = new JLabel("Fecha Entrada:");
		lblFechaCancelacionHabitacion.setBounds(35, 114, 89, 14);
		CancelarReservaHabitacion.add(lblFechaCancelacionHabitacion);

		JLabel lblNHab = new JLabel("N\u00BA Habitacion:");
		lblNHab.setBounds(35, 78, 105, 14);
		CancelarReservaHabitacion.add(lblNHab);

		nºcancelarHabitacion = new JTextField();
		nºcancelarHabitacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (nºcancelarHabitacion.getText().length() == 11) {
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				}
			}
		});
		nºcancelarHabitacion.setBounds(163, 75, 86, 20);
		CancelarReservaHabitacion.add(nºcancelarHabitacion);
		nºcancelarHabitacion.setColumns(10);

		DatePickerSettings dateSettingsCancelarHabitacionEntrada = new DatePickerSettings();
		dateSettingsCancelarHabitacionEntrada.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsCancelarHabitacionEntrada.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsCancelarHabitacionEntrada.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsCancelarHabitacionEntrada.setGapBeforeButtonPixels(0);
		DatePicker calendarioCancelarHabitacion = new DatePicker(dateSettingsCancelarHabitacionEntrada);
		dateSettingsCancelarHabitacionEntrada.setDateRangeLimits(LocalDate.now(), null);
		calendarioCancelarHabitacion.setDateToToday();
		calendarioCancelarHabitacion.setBounds(163, 109, 166, 26);
		CancelarReservaHabitacion.add(calendarioCancelarHabitacion);

		JButton btnOcultar_3 = new JButton("Ocultar");
		btnOcultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CancelarReservaHabitacion.setVisible(false);
				nºcancelarHabitacion.setText("");
				calendarioCancelarHabitacion.setDateToToday();
			}
		});
		btnOcultar_3.setBounds(35, 227, 89, 23);
		CancelarReservaHabitacion.add(btnOcultar_3);

		JButton btnEnviar_1 = new JButton("Enviar");
		btnEnviar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean cancelar = false;
				boolean buscar = false;

				try {

					int cancelarHabitacion = Integer.parseInt(nºcancelarHabitacion.getText());

					boolean existenciaHabitacion = gesBBDD.habitacionExiste(cancelarHabitacion, clientes);

					if (existenciaHabitacion) {

						LocalDate entrada = calendarioCancelarHabitacion.getDate();

						if (entrada.isAfter(LocalDate.now())) {

							buscar = gesBBDD.buscarReservaHabitacion(cancelarHabitacion, entrada, clientes);

							if (buscar) {

								cancelar = gesBBDD.cancelarReservaHabitacion(cancelarHabitacion, entrada, clientes);

								if (cancelar) {
									JOptionPane.showMessageDialog(clientes, "La reserva se ha cancelado con exito");
									nºcancelarHabitacion.setText("");
									calendarioCancelarHabitacion.setDateToToday();
								}
							} else {
								JOptionPane.showMessageDialog(clientes, "No se ha encontrado la reserva");
							}
						} else {
							JOptionPane.showMessageDialog(clientes, "Ya no es posible cancelar la reserva");
						}
					} else {
						JOptionPane.showMessageDialog(clientes, "La habitacion no existe");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}
			}
		});
		btnEnviar_1.setBounds(467, 227, 89, 23);
		CancelarReservaHabitacion.add(btnEnviar_1);

		JButton btnMostrarActividadesReservadas = new JButton("Reserva de Actividades");
		btnMostrarActividadesReservadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String emailCliente = email.getText();
				String passwdCliente = passwd.getText();

				int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente);

				if (cliente > 0) {

					Clientes clienteMostrar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente);
					String dni = clienteMostrar.getDni();

					tablaClientes.setVisible(true);
					listaMostrarReservaActividadCliente = gesBBDD.mostrarReservaActividad(clientes, dni);
					modelo.rellenarTabla(listaMostrarReservaActividadCliente, true);
					listaMostrarReservaActividadCliente.clear();
				}
			}
		});
		btnMostrarActividadesReservadas.setBounds(25, 131, 215, 33);
		mostrarReservasCliente.add(btnMostrarActividadesReservadas);

		JButton btnMostrarHabitacionesReservadas = new JButton("Reserva de Habitaciones");
		btnMostrarHabitacionesReservadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String emailCliente = email.getText();
				String passwdCliente = passwd.getText();

				int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente);

				if (cliente > 0) {

					Clientes clienteMostrar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente);
					String dni = clienteMostrar.getDni();

					tablaClientes.setVisible(true);
					listaMostrarReservaHabitacionCliente = gesBBDD.mostrarReservaHabitacion(clientes, dni);
					modelo.rellenarTabla(listaMostrarReservaHabitacionCliente, true);
					listaMostrarReservaHabitacionCliente.clear();
				}

			}
		});
		btnMostrarHabitacionesReservadas.setBounds(348, 131, 215, 33);
		mostrarReservasCliente.add(btnMostrarHabitacionesReservadas);

		JButton btnOcultar_5 = new JButton("Ocultar");
		btnOcultar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelo.vaciarTabla();
				mostrarReservasCliente.setVisible(false);
				tablaClientes.setVisible(false);
			}
		});
		btnOcultar_5.setBounds(254, 211, 89, 23);
		mostrarReservasCliente.add(btnOcultar_5);
		mostrarReservasCliente.setVisible(false);

		JLabel textoCancelarActividad = new JLabel(
				"<html><body><center>Menu de Cancelacion de reserva realizada, por favor rellene los campos solicitados.</center></body></html>");
		textoCancelarActividad.setHorizontalAlignment(SwingConstants.CENTER);
		textoCancelarActividad.setBounds(10, 11, 578, 22);
		cancelarReservaActividades.add(textoCancelarActividad);

		JLabel codigoCancelarActividades = new JLabel("Codigo Actividad:");
		codigoCancelarActividades.setBounds(34, 116, 125, 14);
		cancelarReservaActividades.add(codigoCancelarActividades);

		JLabel fechaCancelarActividad = new JLabel("DNI:");
		fechaCancelarActividad.setBounds(34, 88, 46, 14);
		cancelarReservaActividades.add(fechaCancelarActividad);

		textfieldCodigoCancelarActividad = new JTextField();
		textfieldCodigoCancelarActividad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textfieldCodigoCancelarActividad.getText().length() == 20) {
					e.consume();
				}
			}
		});
		textfieldCodigoCancelarActividad.setBounds(169, 113, 86, 20);
		cancelarReservaActividades.add(textfieldCodigoCancelarActividad);
		textfieldCodigoCancelarActividad.setColumns(10);

		textFieldDniCancelarActividad = new JTextField();
		textFieldDniCancelarActividad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldDniCancelarActividad.getText().length() == 9) {
					e.consume();
				}
			}
		});
		textFieldDniCancelarActividad.setBounds(169, 85, 86, 20);
		cancelarReservaActividades.add(textFieldDniCancelarActividad);
		textFieldDniCancelarActividad.setColumns(10);

		JSpinner spinnerModificarEdad = new JSpinner();
		spinnerModificarEdad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spinnerModificarEdad.getValue() < 18 || (int) spinnerModificarEdad.getValue() > 99) {
					JOptionPane.showMessageDialog(clientes,
							"La edad no puede ser inferior a 18 años ni superior a 99.");
					spinnerModificarEdad.setValue(18);
				}
			}
		});
		spinnerModificarEdad.setBounds(266, 208, 86, 20);
		modificar.add(spinnerModificarEdad);

		JButton btnOcultar_4 = new JButton("Ocultar");
		btnOcultar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cancelarReservaActividades.setVisible(false);
				textfieldCodigoCancelarActividad.setText("");
				textFieldDniCancelarActividad.setText("");

			}
		});
		btnOcultar_4.setBounds(34, 232, 89, 23);
		cancelarReservaActividades.add(btnOcultar_4);

		JButton btnEnviar_2 = new JButton("Enviar");
		btnEnviar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String emailCliente = email.getText();
				String passwdCliente = passwd.getText();
				boolean cancelar = false;

				try {

					Clientes clienteCancelacionActividad = gesBBDD.buscarUnCliente(emailCliente, passwdCliente);

					String dni = clienteCancelacionActividad.getDni();
					String dniIntroducido = textFieldDniCancelarActividad.getText();
					if (dni.equalsIgnoreCase(dniIntroducido)) {

						String cancelarActividad = textfieldCodigoCancelarActividad.getText();
						boolean existenciaActividad = gesBBDD.actividadExiste(cancelarActividad, clientes);

						if (existenciaActividad) {

							boolean existenciaReserva = gesBBDD.buscarReservaActividad(dni, cancelarActividad,
									clientes);

							if (existenciaReserva) {

								cancelar = gesBBDD.cancelarReservaActividad(cancelarActividad, dni, clientes);

								if (cancelar) {
									textFieldDniCancelarActividad.setText("");
									textfieldCodigoCancelarActividad.setText("");
								}
							} else {
								JOptionPane.showMessageDialog(clientes, "La reserva indicada no existe");

							}
						} else {
							JOptionPane.showMessageDialog(clientes, "La actividad no existe");
						}
					} else {
						JOptionPane.showMessageDialog(clientes,
								"El DNI introducido no coincide con el relacionado a ud.");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}
			}
		});
		btnEnviar_2.setBounds(470, 232, 89, 23);
		cancelarReservaActividades.add(btnEnviar_2);

		JRadioButton rdbtnMoNombre = new JRadioButton("Nombre");
		rdbtnMoNombre.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {

				if (rdbtnMoNombre.isSelected()) {
					modificarNombre.setEnabled(true);
				} else {
					modificarNombre.setEnabled(false);
					modificarNombre.setText("");

				}
			}
		});
		rdbtnMoNombre.setBounds(140, 51, 98, 23);
		modificar.add(rdbtnMoNombre);

		JRadioButton rdbtnApellidos = new JRadioButton("Apellidos");
		rdbtnApellidos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (rdbtnApellidos.isSelected()) {
					modificarApellidos.setEnabled(true);
				} else {
					modificarApellidos.setEnabled(false);
					modificarApellidos.setText("");
				}
			}
		});
		rdbtnApellidos.setBounds(140, 77, 98, 23);
		modificar.add(rdbtnApellidos);

		JRadioButton rdbtnEdadModificar = new JRadioButton("Edad");
		rdbtnEdadModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (rdbtnEdadModificar.isSelected()) {
					spinnerModificarEdad.setEnabled(true);
				} else {
					spinnerModificarEdad.setEnabled(false);
				}
			}
		});
		rdbtnEdadModificar.setBounds(140, 207, 109, 23);
		modificar.add(rdbtnEdadModificar);

		JRadioButton rdbtnMoTelefono = new JRadioButton("Telefono");
		rdbtnMoTelefono.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (rdbtnMoTelefono.isSelected()) {
					modificarTelefono.setEnabled(true);
				} else {
					modificarTelefono.setEnabled(false);
					modificarTelefono.setText("");
				}
			}
		});
		rdbtnMoTelefono.setBounds(140, 103, 98, 23);
		modificar.add(rdbtnMoTelefono);

		JRadioButton rdbtnMoClave = new JRadioButton("Clave");
		rdbtnMoClave.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (rdbtnMoClave.isSelected()) {
					modificarClave.setEnabled(true);
				} else {
					modificarClave.setEnabled(false);
					modificarClave.setText("");
				}
			}
		});
		rdbtnMoClave.setBounds(140, 129, 98, 23);
		modificar.add(rdbtnMoClave);

		JRadioButton rdbtnMoEmail = new JRadioButton("Email");
		rdbtnMoEmail.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnMoEmail.isSelected()) {
					modificarEmail.setEnabled(true);
				} else {
					modificarEmail.setEnabled(false);
					modificarEmail.setText("");
				}
			}
		});
		rdbtnMoEmail.setBounds(140, 155, 98, 23);
		modificar.add(rdbtnMoEmail);

		JRadioButton rdbtnMoInteres = new JRadioButton("Interes");
		rdbtnMoInteres.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnMoInteres.isSelected()) {
					modificarInteres.setEnabled(true);
				} else {
					modificarInteres.setEnabled(false);
					modificarInteres.setText("");
				}
			}
		});
		rdbtnMoInteres.setBounds(140, 181, 98, 23);
		modificar.add(rdbtnMoInteres);

		ButtonGroup grupoRadioButtonsModificarClientes = new ButtonGroup();
		grupoRadioButtonsModificarClientes.add(rdbtnMoNombre);
		grupoRadioButtonsModificarClientes.add(rdbtnApellidos);
		grupoRadioButtonsModificarClientes.add(rdbtnMoTelefono);
		grupoRadioButtonsModificarClientes.add(rdbtnEdadModificar);
		grupoRadioButtonsModificarClientes.add(rdbtnMoClave);
		grupoRadioButtonsModificarClientes.add(rdbtnMoEmail);
		grupoRadioButtonsModificarClientes.add(rdbtnMoInteres);

		modificarNombre = new JTextField();
		modificarNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (modificarNombre.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();

				}
				if (e.getKeyChar() == 'º' || e.getKeyChar() == 'ª') {
					e.consume();
				}
			}
		});

		modificarNombre.setBounds(266, 52, 86, 20);
		modificar.add(modificarNombre);
		modificarNombre.setColumns(10);
		modificarNombre.setEnabled(false);

		modificarApellidos = new JTextField();
		modificarApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (modificarApellidos.getText().length() == 40) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();

				}
			}
		});
		modificarApellidos.setBounds(266, 78, 86, 20);
		modificar.add(modificarApellidos);
		modificarApellidos.setColumns(10);
		modificarApellidos.setEnabled(false);

		modificarTelefono = new JTextField();
		modificarTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (modificarTelefono.getText().length() == 9) {
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				}
			}
		});
		modificarTelefono.setBounds(266, 104, 86, 20);
		modificar.add(modificarTelefono);
		modificarTelefono.setColumns(10);
		modificarTelefono.setEnabled(false);

		modificarEmail = new JTextField();
		modificarEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (modificarEmail.getText().length() == 50) {
					e.consume();
				}
			}
		});
		modificarEmail.setBounds(265, 156, 86, 20);
		modificar.add(modificarEmail);
		modificarEmail.setColumns(10);
		modificarEmail.setEnabled(false);

		modificarClave = new JPasswordField();
		modificarClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (modificarClave.getText().length() == 20) {
					e.consume();
				}
			}
		});
		modificarClave.setBounds(266, 130, 86, 20);
		modificar.add(modificarClave);
		modificarClave.setEnabled(false);

		modificarInteres = new JTextField();
		modificarInteres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (modificarInteres.getText().length() == 40) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();

				}
			}
		});
		modificarInteres.setBounds(265, 182, 86, 20);
		modificar.add(modificarInteres);
		modificarInteres.setColumns(10);
		modificarInteres.setEnabled(false);

		JButton btnOcultar = new JButton("Ocultar");
		btnOcultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modificar.setVisible(false);
				grupoRadioButtonsModificarClientes.clearSelection();
			}
		});
		btnOcultar.setBounds(19, 245, 89, 23);
		modificar.add(btnOcultar);

		JButton btnModificar = new JButton("Enviar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// ORDENES MODIFICAR DATOS EN BBDD

				String tipoPersona = "";
				boolean dniValidado = false;
				String opcion = "";
				String datoNuevo = "";
				boolean modificarValidado = true;
				boolean modificar = false;
				String dni = "";

				if (rdbtnMoNombre.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnApellidos.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnMoTelefono.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnMoClave.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnEdadModificar.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnMoEmail.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnMoInteres.isSelected()) {
					tipoPersona = "cliente";
				}

				try {

					String emailCliente = email.getText();
					String passwdCliente = passwd.getText();

					int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente);

					if (cliente > 0) {

						Clientes clienteModificar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente);
						dni = clienteModificar.getDni();

						if (rdbtnMoNombre.isSelected()) {
							opcion = "nombre";
							datoNuevo = modificarNombre.getText();
						} else if (rdbtnApellidos.isSelected()) {
							opcion = "apellidos";
							datoNuevo = modificarApellidos.getText();
						} else if (rdbtnMoTelefono.isSelected()) {
							opcion = "telefono";
							datoNuevo = modificarTelefono.getText();
						} else if (rdbtnMoClave.isSelected()) {
							opcion = "clave";
							datoNuevo = modificarClave.getText();
						} else if (rdbtnMoEmail.isSelected()) {
							opcion = "email";
							datoNuevo = modificarEmail.getText();
						} else if (rdbtnMoInteres.isSelected()) {
							opcion = "interes";
							datoNuevo = modificarInteres.getText();
						} else if (rdbtnEdadModificar.isSelected()) {
							opcion = "edad";

							datoNuevo = String.valueOf(spinnerModificarEdad.getValue());

						} else {
							modificarValidado = false;
						}

						if (modificarValidado) {
							modificar = gesBBDD.modificarPersonas(dni, opcion, datoNuevo, tipoPersona, clientes);

							if (modificar) {
								JOptionPane.showMessageDialog(clientes, "Dato modificado con exito");
								modificarNombre.setText("");
								modificarApellidos.setText("");
								modificarTelefono.setText("");
								modificarEmail.setText("");
								modificarInteres.setText("");
								grupoRadioButtonsModificarClientes.clearSelection();
							}
						} else {
							JOptionPane.showMessageDialog(clientes, "Introduce un dato a modificar");
						}
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}
			}
		});
		btnModificar.setBounds(448, 245, 89, 23);
		modificar.add(btnModificar);

		JLabel lblNewLabel_1 = new JLabel(
				"<html><body><center>Menu Modificacion de datos personales, pulse la circunferencia correspondiente al cambio<br> que"
						+ " desea hacer.</center></body></html>");
		lblNewLabel_1.setBounds(10, 11, 578, 30);
		modificar.add(lblNewLabel_1);

		JLabel textoReservaHabitaciones = new JLabel(
				"<html><body><center>Menu Reserva de Actividades, introduzca los campos señalados, si tiene dudas sobre la actividad pulse previamente"
						+ " en mostrar actividades.</center></body></html>");
		textoReservaHabitaciones.setBounds(10, 11, 578, 35);
		reservarActividades.add(textoReservaHabitaciones);

		JLabel lblDniReservaActividades = new JLabel("DNI:");
		lblDniReservaActividades.setBounds(27, 75, 46, 14);
		reservarActividades.add(lblDniReservaActividades);

		JLabel lblCodigoReservaActividades = new JLabel("Codigo:");
		lblCodigoReservaActividades.setBounds(27, 100, 115, 14);
		reservarActividades.add(lblCodigoReservaActividades);

		JLabel lblNumeroDePersonasReservaActividades = new JLabel("N\u00BA de Personas:");
		lblNumeroDePersonasReservaActividades.setBounds(27, 125, 115, 14);
		reservarActividades.add(lblNumeroDePersonasReservaActividades);

		dniReservaActividades = new JTextField();
		dniReservaActividades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniReservaActividades.getText().length() == 9) {
					e.consume();
				}
			}
		});
		dniReservaActividades.setBounds(156, 72, 86, 20);
		reservarActividades.add(dniReservaActividades);
		dniReservaActividades.setColumns(10);

		codigoReservaActividades = new JTextField();
		codigoReservaActividades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (codigoReservaActividades.getText().length() == 20) {
					e.consume();
				}
			}
		});
		codigoReservaActividades.setBounds(156, 97, 86, 20);
		reservarActividades.add(codigoReservaActividades);
		codigoReservaActividades.setColumns(10);

		JSpinner numPersonasReservaActividades = new JSpinner();
		numPersonasReservaActividades.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if ((int) numPersonasReservaActividades.getValue() < 0
						|| (int) numPersonasReservaActividades.getValue() > 4) {
					numPersonasReservaActividades.setValue(0);
					JOptionPane.showMessageDialog(clientes,
							"El valor introducido no puede ser menor de 0 ni mayor a 4");

				}
			}
		});
		numPersonasReservaActividades.setBounds(156, 122, 86, 20);
		reservarActividades.add(numPersonasReservaActividades);

		JButton btnOcultar_2 = new JButton("Ocultar");
		btnOcultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				reservarActividades.setVisible(false);
				dniReservaActividades.setText("");
				codigoReservaActividades.setText("");
				numPersonasReservaActividades.setValue(0);

			}
		});
		btnOcultar_2.setBounds(27, 233, 89, 23);
		reservarActividades.add(btnOcultar_2);

		JButton btnEnviarReservaActividades = new JButton("Enviar"); // ERROR AL RESERVAR ACTIVIDAD CODIGO 12
		btnEnviarReservaActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean enviar = false;
				boolean validado = false;
				boolean existenciaActividad = false;
				int disponibilidad = 0;

				try {

					String dni = dniReservaActividades.getText();
					validado = validar.comprobarDNI(dni);

					if (validado) {

						int numPersonas = (int) numPersonasReservaActividades.getValue();

						if (numPersonas > 0) {

							String codigo = codigoReservaActividades.getText();
							existenciaActividad = gesBBDD.actividadExiste(codigo, clientes);

							if (existenciaActividad) {

								disponibilidad = gesBBDD.calcularActividadesDisponibles(codigo, clientes);

								if (disponibilidad > 0 && disponibilidad >= numPersonas) {

									Apunta apunta = new Apunta(numPersonas);
									enviar = gesBBDD.reservarActividades(dni, codigo, apunta, clientes);

									if (enviar) {

										JOptionPane.showMessageDialog(clientes, "Reserva realizada con exito");
										dniReservaActividades.setText("");
										numPersonasReservaActividades.setValue(0);
										codigoReservaActividades.setText("");

									} else {
										JOptionPane.showMessageDialog(clientes, "No se ha podido realizar la reserva");
									}
								} else {
									JOptionPane.showMessageDialog(clientes,
											"No hay plazas en la actividad selecionada" + " disculpen las molestias");
								}
							} else {
								JOptionPane.showMessageDialog(clientes,
										"El codigo introducido no corresponde con" + " ninguna actividad");
							}
						} else {
							JOptionPane.showMessageDialog(clientes, "Debe ser mayor a 0 para realizar la reserva");
						}
					} else {
						JOptionPane.showMessageDialog(clientes, "El DNI introducido no es correcto");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}

			}
		});
		btnEnviarReservaActividades.setBounds(462, 233, 89, 23);
		reservarActividades.add(btnEnviarReservaActividades);

		JLabel lblMenuReservaDe = new JLabel(
				"<html><body><center>Menu Reserva de Habitaciones, introduzca los campos señalados, si tiene dudas sobre la habitacion pulse previamente"
						+ " en mostrar habitaciones.</center></body></html>");
		lblMenuReservaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuReservaDe.setBounds(60, 11, 477, 42);
		reservarHabitaciones.add(lblMenuReservaDe);

		JLabel lblNHabitacionReserva = new JLabel("N\u00BA Habitacion:");
		lblNHabitacionReserva.setBounds(35, 84, 89, 14);
		reservarHabitaciones.add(lblNHabitacionReserva);

		JLabel lblDniReservarHabita = new JLabel("DNI:");
		lblDniReservarHabita.setBounds(35, 115, 66, 14);
		reservarHabitaciones.add(lblDniReservarHabita);

		JLabel lblNumeroDePersonas = new JLabel("N\u00BA de Personas:");
		lblNumeroDePersonas.setBounds(35, 143, 103, 14);
		reservarHabitaciones.add(lblNumeroDePersonas);

		JLabel lblFechaEntrada = new JLabel("Fecha Entrada:");
		lblFechaEntrada.setBounds(301, 84, 89, 14);
		reservarHabitaciones.add(lblFechaEntrada);

		JLabel lblFechaSalida = new JLabel("Fecha Salida");
		lblFechaSalida.setBounds(301, 139, 89, 14);
		reservarHabitaciones.add(lblFechaSalida);

		reservarHabitacionesNº = new JTextField();
		reservarHabitacionesNº.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (reservarHabitacionesNº.getText().length() == 11) {
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				}
			}
		});
		reservarHabitacionesNº.setBounds(169, 81, 86, 20);
		reservarHabitaciones.add(reservarHabitacionesNº);
		reservarHabitacionesNº.setColumns(10);

		reservarHabitacionesDni = new JTextField();
		reservarHabitacionesDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (reservarHabitacionesDni.getText().length() == 9) {
					e.consume();
				}
			}
		});
		reservarHabitacionesDni.setBounds(169, 112, 86, 20);
		reservarHabitaciones.add(reservarHabitacionesDni);
		reservarHabitacionesDni.setColumns(10);

		JSpinner spinnerReservarHabitacion = new JSpinner();
		spinnerReservarHabitacion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spinnerReservarHabitacion.getValue() < 0 || (int) spinnerReservarHabitacion.getValue() > 4) {
					spinnerReservarHabitacion.setValue(0);
					JOptionPane.showMessageDialog(clientes, "El valor no puede ser menor de 0 ni mayor a 4");

				}
			}
		});
		spinnerReservarHabitacion.setBounds(169, 140, 86, 20);
		reservarHabitaciones.add(spinnerReservarHabitacion);

		DatePickerSettings dateSettingsReservarHabitacionesEntrada = new DatePickerSettings();
		dateSettingsReservarHabitacionesEntrada.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsReservarHabitacionesEntrada.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsReservarHabitacionesEntrada.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsReservarHabitacionesEntrada.setGapBeforeButtonPixels(0);
		DatePicker calendarioReservarHabitaciones = new DatePicker(dateSettingsReservarHabitacionesEntrada);
		dateSettingsReservarHabitacionesEntrada.setDateRangeLimits(LocalDate.now(), null);
		calendarioReservarHabitaciones.setDateToToday();
		calendarioReservarHabitaciones.setBounds(388, 79, 166, 26);
		reservarHabitaciones.add(calendarioReservarHabitaciones);

		DatePickerSettings dateSettingsReservarHabitacionesSalida = new DatePickerSettings();
		dateSettingsReservarHabitacionesSalida.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsReservarHabitacionesSalida.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsReservarHabitacionesSalida.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsReservarHabitacionesSalida.setGapBeforeButtonPixels(0);
		DatePicker calendarioReservarHabitacionesSalida = new DatePicker(dateSettingsReservarHabitacionesSalida);
		dateSettingsReservarHabitacionesSalida.setDateRangeLimits(LocalDate.now(), null);
		calendarioReservarHabitacionesSalida.setDateToToday();
		calendarioReservarHabitacionesSalida.setBounds(388, 134, 166, 26);
		reservarHabitaciones.add(calendarioReservarHabitacionesSalida);

		JButton btnOcultar_1 = new JButton("Ocultar");
		btnOcultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				reservarHabitaciones.setVisible(false);
				reservarHabitacionesNº.setText("");
				reservarHabitacionesDni.setText("");
				spinnerReservarHabitacion.setValue(0);
				calendarioReservarHabitaciones.setDateToToday();
				calendarioReservarHabitacionesSalida.setDateToToday();
			}
		});
		btnOcultar_1.setBounds(35, 244, 89, 23);
		reservarHabitaciones.add(btnOcultar_1);

		JButton btnEnviar = new JButton("Enviar");// RESERVAR HABITACIONJES
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean enviar = false;
				boolean validado = false;
				boolean existenciaHabitacion = false;
				boolean disponibilidad;

				try {

					int numeroHabitacion = Integer.parseInt(reservarHabitacionesNº.getText());

					existenciaHabitacion = gesBBDD.habitacionExiste(numeroHabitacion, clientes);

					if (existenciaHabitacion) {

						String dni = reservarHabitacionesDni.getText();

						validado = validar.comprobarDNI(dni);

						if (validado) {

							int numPersonas = (int) spinnerReservarHabitacion.getValue();

							if (numPersonas > 0) {

								LocalDate fechaentrada = calendarioReservarHabitaciones.getDate();

								LocalDate fechasalida = calendarioReservarHabitacionesSalida.getDate();

								if (fechaentrada.isBefore(fechasalida) && fechasalida.isAfter(fechaentrada)) {

									Reserva reservaHabitacion = new Reserva(fechaentrada, fechasalida, numPersonas);
									disponibilidad = gesBBDD.comprobarDisponibilidadHabitaciones(numeroHabitacion,
											reservaHabitacion);
									if (disponibilidad) {

										reservaHabitacion = gesBBDD.calcularPrecioReserva(numeroHabitacion,
												reservaHabitacion);
										enviar = gesBBDD.reservaHabitaciones(numeroHabitacion, dni, reservaHabitacion,
												clientes);

										if (enviar) {

											JOptionPane.showMessageDialog(clientes, "Reserva realizada con exito");
											reservarHabitacionesNº.setText("");
											reservarHabitacionesDni.setText("");
											spinnerReservarHabitacion.setValue(0);
											calendarioReservarHabitaciones.setDateToToday();
											calendarioReservarHabitacionesSalida.setDateToToday();

										} else {

											JOptionPane.showMessageDialog(clientes,
													"No se ha podido realizar la reserva");
										}
									} else {
										JOptionPane.showMessageDialog(clientes,
												"La habitacion selecionada no esta disponible en esas fechas");
									}
								} else {
									JOptionPane.showMessageDialog(clientes,
											"Revise las fechas, no estan bien configuradas");
								}

							} else {
								JOptionPane.showMessageDialog(clientes,
										"El numero de personas introducido no es correcto");
							}
						} else {
							JOptionPane.showMessageDialog(clientes, "El DNI no existe");
						}
					} else {
						JOptionPane.showMessageDialog(clientes, "La habitacion no existe");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}
			}
		});
		btnEnviar.setBounds(448, 244, 89, 23);
		reservarHabitaciones.add(btnEnviar);

		JLabel darseBaja = new JLabel("Darse de Baja");
		darseBaja.setBounds(267, 22, 183, 14);
		darDeBaja.add(darseBaja);

		JLabel IntroduceDni = new JLabel("Introduce tu DNI:");
		IntroduceDni.setBounds(72, 85, 113, 14);
		darDeBaja.add(IntroduceDni);

		bajaCliente = new JTextField();
		bajaCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (bajaCliente.getText().length() == 9) {
					e.consume();
				}
			}
		});
		bajaCliente.setBounds(195, 82, 97, 20);
		darDeBaja.add(bajaCliente);
		bajaCliente.setColumns(10);

		JButton btnOcultarBaja = new JButton("Ocultar");
		btnOcultarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				darDeBaja.setVisible(false);
				bajaCliente.setText("");
			}
		});
		btnOcultarBaja.setBounds(37, 196, 89, 23);
		darDeBaja.add(btnOcultarBaja);

		JButton btnEnviarBaja = new JButton("Enviar");
		btnEnviarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean validacion = false;
				boolean realizado;

				try {

					String DNI = bajaCliente.getText();
					validacion = validar.comprobarDNI(DNI);

					if (validacion) {

						realizado = gesBBDD.darseBajaCliente(DNI, clientes);

						if (realizado) {
							JOptionPane.showMessageDialog(clientes, "Dado de baja con exito");
							clientes.setVisible(false);
							inicio.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(clientes, "No se ha podido realizar la accion");
						}
					} else {

						JOptionPane.showMessageDialog(clientes, "El DNI introducido no es correcto");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(clientes, "El dato introducido no es valido");
				}
			}
		});
		btnEnviarBaja.setBounds(424, 196, 89, 23);
		darDeBaja.add(btnEnviarBaja);

		JButton btnmodificar = new JButton("Modificar datos");// MODIFICAR
		btnmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modificar.setVisible(true);
				darDeBaja.setVisible(false);
				reservarHabitaciones.setVisible(false);
				reservarActividades.setVisible(false);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				inicio.setVisible(false);
				invitado.setVisible(false);
				mostrarReservasCliente.setVisible(false);

			}
		});

		btnmodificar.setBounds(10, 36, 214, 23);
		clientes.add(btnmodificar);

		JButton btnreservar = new JButton("Reservar Actividades");
		btnreservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				reservarActividades.setVisible(true);
				reservarHabitaciones.setVisible(false);
				modificar.setVisible(false);
				darDeBaja.setVisible(false);
				inicio.setVisible(false);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				invitado.setVisible(false);
				mostrarReservasCliente.setVisible(false);
			}
		});
		btnreservar.setBounds(10, 105, 214, 23);
		clientes.add(btnreservar);

		JButton btncancelarActividades = new JButton("Cancelar Reserva Actividades");
		btncancelarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				reservarActividades.setVisible(false);
				reservarHabitaciones.setVisible(false);
				modificar.setVisible(false);
				darDeBaja.setVisible(false);
				inicio.setVisible(false);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(true);
				invitado.setVisible(false);
				mostrarReservasCliente.setVisible(false);
			}
		});
		btncancelarActividades.setBounds(10, 139, 214, 23);
		clientes.add(btncancelarActividades);

		JButton btnmostrardisponibilidad = new JButton("Mostrar  actividades");
		btnmostrardisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tablaClientes.setVisible(true);
				listaActividades = gesBBDD.mostrarActividades(clientes);
				modelo.rellenarTabla(listaActividades, true);
				listaActividades.clear();

			}
		});
		btnmostrardisponibilidad.setBounds(10, 70, 214, 23);
		clientes.add(btnmostrardisponibilidad);

		JButton btnmostrarreserva = new JButton("Mostrar reservas");
		btnmostrarreserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				darDeBaja.setVisible(false);
				modificar.setVisible(false);
				reservarHabitaciones.setVisible(false);
				reservarActividades.setVisible(false);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				inicio.setVisible(false);
				mostrarReservasCliente.setVisible(true);
				invitado.setVisible(false);

			}
		});
		btnmostrarreserva.setBounds(10, 275, 214, 23);
		clientes.add(btnmostrarreserva);

		JButton btndardebaja = new JButton("Darse de baja");
		btndardebaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				darDeBaja.setVisible(true);
				modificar.setVisible(false);
				reservarHabitaciones.setVisible(false);
				reservarActividades.setVisible(false);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				inicio.setVisible(false);
				mostrarReservasCliente.setVisible(false);
				invitado.setVisible(false);

			}
		});
		btndardebaja.setBounds(10, 512, 214, 23);
		clientes.add(btndardebaja);

		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				email.setText(null);
				passwd.setText(null);
				clientes.setVisible(false);
				darDeBaja.setVisible(false);
				reservarHabitaciones.setVisible(false);
				modificar.setVisible(false);
				inicio.setVisible(true);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				mostrarReservasCliente.setVisible(false);
				invitado.setVisible(false);
				tablaClientes.setVisible(false);
				modelo.vaciarTabla();
				JOptionPane.showMessageDialog(frmHotel, "Sesion Cerrada con exito");
			}
		});
		btnCerrarSesin.setBounds(10, 546, 214, 23);
		clientes.add(btnCerrarSesin);

		JButton btnReservaHabitacionesPanel = new JButton("Reserva Habitaciones");
		btnReservaHabitacionesPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				reservarHabitaciones.setVisible(true);
				modificar.setVisible(false);
				darDeBaja.setVisible(false);
				reservarActividades.setVisible(false);
				CancelarReservaHabitacion.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				inicio.setVisible(false);
				calendarioReservarHabitaciones.setVisible(true);
				calendarioReservarHabitacionesSalida.setVisible(true);
				mostrarReservasCliente.setVisible(false);
				invitado.setVisible(false);

			}
		});
		btnReservaHabitacionesPanel.setBounds(10, 207, 214, 23);
		clientes.add(btnReservaHabitacionesPanel);

		JButton btnCancelarReservaHabitaciones = new JButton("Cancelar Reserva Habitaciones");
		btnCancelarReservaHabitaciones.addActionListener(new ActionListener() {// cancelarReservaHabitacion
			public void actionPerformed(ActionEvent e) {

				CancelarReservaHabitacion.setVisible(true);
				modificar.setVisible(false);
				reservarActividades.setVisible(false);
				reservarHabitaciones.setVisible(false);
				darDeBaja.setVisible(false);
				calendarioReservarHabitaciones.setVisible(false);
				cancelarReservaActividades.setVisible(false);
				inicio.setVisible(false);
				mostrarReservasCliente.setVisible(false);
				invitado.setVisible(false);
			}
		});
		btnCancelarReservaHabitaciones.setBounds(10, 241, 214, 23);
		clientes.add(btnCancelarReservaHabitaciones);

		JButton btnMostrarDisponibilidadHabitaciones = new JButton("Mostrar Habitaciones");
		btnMostrarDisponibilidadHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tablaClientes.setVisible(true);
				listaHabitaciones = gesBBDD.mostrarHabitaciones();
				modelo.rellenarTabla(listaHabitaciones, true);
				listaHabitaciones.clear();
			}
		});
		btnMostrarDisponibilidadHabitaciones.setBounds(10, 173, 214, 23);
		clientes.add(btnMostrarDisponibilidadHabitaciones);

		JButton botonVaciarTablaClientes = new JButton("");
		botonVaciarTablaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.vaciarTabla();
			}
		});
		botonVaciarTablaClientes.setBounds(223, 0, 12, 18);
		clientes.add(botonVaciarTablaClientes);

		JButton btnMostrarDatos = new JButton("Mostrar Datos");
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String emailCliente = email.getText();
				String passwdCliente = passwd.getText();

				int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente);

				if (cliente > 0) {

					Clientes clienteMostrar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente);
					String dni = clienteMostrar.getDni();

					tablaClientes.setVisible(true);
					listaMostrarDatosCliente = gesBBDD.listaMostrarDatosClientes(clientes, dni);
					modelo.rellenarTabla(listaMostrarDatosCliente, true);
					listaMostrarDatosCliente.clear();
				}
			}
		});
		btnMostrarDatos.setBounds(10, 309, 214, 23);
		clientes.add(btnMostrarDatos);

		JLabel label = new JLabel("Iniciar Sesi\u00F3n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(410, 171, 100, 16);
		inicio.add(label);

		JLabel label_1 = new JLabel("E-mail:");
		label_1.setBounds(314, 210, 56, 16);
		inicio.add(label_1);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(391, 207, 196, 22);
		inicio.add(email);

		JLabel label_2 = new JLabel("Contrase\u00F1a:");
		label_2.setBounds(314, 248, 75, 16);
		inicio.add(label_2);

		passwd = new JPasswordField();
		passwd.setBounds(391, 245, 196, 22);
		inicio.add(passwd);

		JButton iniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		iniciarSesion.setBounds(314, 288, 116, 25);
		inicio.add(iniciarSesion);

		JButton Registrarse = new JButton("Registrarse");
		Registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				registrarse.setVisible(true);
				inicio.setVisible(false);
				invitado.setVisible(false);
				clientes.setVisible(false);

			}
		});
		Registrarse.setBounds(471, 288, 116, 25);
		inicio.add(Registrarse);

		JButton entrarComoInvitado = new JButton("Entrar Como Invitado");
		entrarComoInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invitado.setVisible(true);
				inicio.setVisible(false);
				tablaClientes.setVisible(false);
				clientes.setVisible(false);
			}
		});
		entrarComoInvitado.setBounds(314, 324, 275, 23);
		inicio.add(entrarComoInvitado);

		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String emailString = email.getText();
				String contrasena = passwd.getText();
				int idClientePersona = 0;
				String tipoEmpleado = "";
				boolean empleadoBoolean;
				empleadoBoolean = gesBBDD.inicioSesion(emailString, contrasena, inicio);
				if (empleadoBoolean) {
					Empleados empleado = gesBBDD.buscarUnEmpleado(emailString, contrasena);
					tipoEmpleado = empleado.getTipo();

				} else {
					idClientePersona = gesBBDD.inicioSesionCliente(emailString, contrasena);
					if (idClientePersona > 0) {
						inicio.setVisible(false);
						clientes.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(frmHotel, "Usuario y/o contraseña incorrectos");
					}
				}
			}
		});
	}
}
