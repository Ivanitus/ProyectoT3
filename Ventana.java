import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import d_tablas.TableableModel;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JRadioButton;
import java.awt.Font;

public class Ventana {

	private JFrame frmHotel;
	private JTextField email;
	private JPasswordField passwd;
	private JTextField numHabitacionEmpleados;
	private JTextField superficieHabitacionEmpleados;
	private JTextField precioHabitacionesEmpleados;
	private JTextField dniHabitacionEmpleados;
	private JComboBox tiposHabitacionEmpleados;
	private JTextField numHabitacionEliminar;
	private ArrayList<Habitaciones> listaHabitaciones = new ArrayList<>();
	private JTable table;
	private JTextField codigoActividad;
	private JTextField localizacion;
	private JTextField medioTransporte;
	private JTextField dniEmpleadoActividades;
	private JTextField precioActividad;
	private JTextField codActividadEliminar;
	private ArrayList<Actividades> listaActividades = new ArrayList<>();
	private JTextField nombreEmpleadoNuevo;
	private JTextField apellidosEmpleadoNuevo;
	private JTextField dniEmpleadoNuevo;
	private JTextField telefono;
	private JPasswordField passwdEmpleado;
	private JTextField emailEmpleadoNuevo;
	private JTextField salarioEmpleadoNuevo;
	private JTextField antiguedadEmpleadoNuevo;
	private JTextField dniEmpleadoEliminar;
	private ArrayList<Movimientos> listaMovimientos = new ArrayList<>();
	private ArrayList<Reserva> listaReservas = new ArrayList<>();
	private JTextField superficieModificar;
	private JTextField numHabitacionModificar;
	private JTextField precioHabitacionesModificar;
	private JTextField numHabitacionAModificar;
	private JTextField descripcionModificar;
	private JTextField medioTransporteActividadModificar;
	private JTextField localizacionActividadModificar;
	private JTextField codigoActividadModificar;
	private JTextField precioModificarActividades;
	private JTextField codigoActividadAModificar;
	private JTextField nombreEmpleadoModificar;
	private JTextField apellidosEmpleadoModificar;
	private JTextField telefonoEmpleadoModificar;
	private JPasswordField passwordFieldEmpleadoModificar;
	private JTextField textFieldEmailModificarEmpleado;
	private JTextField textFieldSalarioEmpleadoModificar;
	private JTextField textFieldAntiguedadEmpleadoModificar;
	private JTextField textFielddniEmpleadoModificar;
	private ArrayList<Personas> listaPersonas = new ArrayList<>();

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

		TableableModel modelo = new TableableModel();

		frmHotel = new JFrame();
		frmHotel.setResizable(false);
		frmHotel.setTitle("Hotel");
		frmHotel.setBounds(100, 100, 848, 619);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);

		JPanel empleados = new JPanel();
		empleados.setBounds(0, 0, 842, 580);
		frmHotel.getContentPane().add(empleados);
		empleados.setLayout(null);
		empleados.setVisible(false);

		JScrollPane scrollPaneTablasEmpleados = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTablasEmpleados.setBounds(234, 0, 609, 290);
		empleados.add(scrollPaneTablasEmpleados);

		table = new JTable();
		scrollPaneTablasEmpleados.setViewportView(table);
		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(234, 289, 2, 290);
		empleados.add(separator);

		JPanel inicio = new JPanel();
		inicio.setBounds(0, 0, 842, 580);
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

		TimePickerSettings timeSettings = new TimePickerSettings();
		timeSettings.setDisplaySpinnerButtons(false);
		timeSettings.setInitialTimeToNow();

		TimePickerSettings timeSettingsDuracion = new TimePickerSettings();
		timeSettingsDuracion.setDisplaySpinnerButtons(false);

		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(10, 18, 214, 14);
		empleados.add(lblTipo);

		JPanel modificarDatosPersonalesEmpleados = new JPanel();
		modificarDatosPersonalesEmpleados.setBounds(234, 289, 609, 290);
		empleados.add(modificarDatosPersonalesEmpleados);
		modificarDatosPersonalesEmpleados.setLayout(null);

		JLabel label_11 = new JLabel("EL RADIOBUTTON DE LA IZQUIERDA SIRVE PARA MARCAR QUE VALOR VAS A MODIFICAR");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(10, 5, 578, 14);
		modificarDatosPersonalesEmpleados.add(label_11);

		nombreEmpleadoModificar = new JTextField();
		nombreEmpleadoModificar.setBounds(125, 27, 86, 20);
		modificarDatosPersonalesEmpleados.add(nombreEmpleadoModificar);
		nombreEmpleadoModificar.setColumns(10);
		nombreEmpleadoModificar.setEnabled(false);

		apellidosEmpleadoModificar = new JTextField();
		apellidosEmpleadoModificar.setBounds(125, 53, 86, 20);
		modificarDatosPersonalesEmpleados.add(apellidosEmpleadoModificar);
		apellidosEmpleadoModificar.setColumns(10);
		apellidosEmpleadoModificar.setEnabled(false);

		telefonoEmpleadoModificar = new JTextField();
		telefonoEmpleadoModificar.setBounds(125, 83, 86, 20);
		modificarDatosPersonalesEmpleados.add(telefonoEmpleadoModificar);
		telefonoEmpleadoModificar.setColumns(10);
		telefonoEmpleadoModificar.setEnabled(false);

		passwordFieldEmpleadoModificar = new JPasswordField();
		passwordFieldEmpleadoModificar.setBounds(125, 109, 86, 20);
		modificarDatosPersonalesEmpleados.add(passwordFieldEmpleadoModificar);
		passwordFieldEmpleadoModificar.setEnabled(false);

		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setValue(16);
		spinnerEdad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spinnerEdad.getValue() < 16) {
					JOptionPane.showMessageDialog(empleados, "El empleado no puede tener una edad inferior a 16 años");
					spinnerEdad.setValue(16);
				} else if ((int) spinnerEdad.getValue() > 67) {
					JOptionPane.showMessageDialog(empleados, "El empleado no puede tener una edad superior a 67 años");
					spinnerEdad.setValue(67);
				}
			}
		});
		spinnerEdad.setBounds(422, 27, 166, 20);
		modificarDatosPersonalesEmpleados.add(spinnerEdad);
		spinnerEdad.setEnabled(false);

		textFieldEmailModificarEmpleado = new JTextField();
		textFieldEmailModificarEmpleado.setBounds(422, 53, 166, 20);
		modificarDatosPersonalesEmpleados.add(textFieldEmailModificarEmpleado);
		textFieldEmailModificarEmpleado.setColumns(10);
		textFieldEmailModificarEmpleado.setEnabled(false);

		textFieldSalarioEmpleadoModificar = new JTextField();
		textFieldSalarioEmpleadoModificar.setBounds(422, 79, 166, 20);
		modificarDatosPersonalesEmpleados.add(textFieldSalarioEmpleadoModificar);
		textFieldSalarioEmpleadoModificar.setColumns(10);
		textFieldSalarioEmpleadoModificar.setEnabled(false);

		textFieldAntiguedadEmpleadoModificar = new JTextField();
		textFieldAntiguedadEmpleadoModificar.setBounds(422, 105, 166, 20);
		modificarDatosPersonalesEmpleados.add(textFieldAntiguedadEmpleadoModificar);
		textFieldAntiguedadEmpleadoModificar.setColumns(10);
		textFieldAntiguedadEmpleadoModificar.setEnabled(false);

		JComboBox comboBoxTipoEmpleadoModificar = new JComboBox();
		comboBoxTipoEmpleadoModificar.setBounds(250, 130, 166, 20);
		modificarDatosPersonalesEmpleados.add(comboBoxTipoEmpleadoModificar);
		comboBoxTipoEmpleadoModificar.addItem("Administrativo de recepción");
		comboBoxTipoEmpleadoModificar.addItem("Conserje");
		comboBoxTipoEmpleadoModificar.addItem("Recepcionista");
		comboBoxTipoEmpleadoModificar.setEnabled(false);

		JRadioButton rdbtnNombre = new JRadioButton("Nombre:");
		rdbtnNombre.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnNombre.isSelected()) {
					nombreEmpleadoModificar.setEnabled(true);
				} else {
					nombreEmpleadoModificar.setEnabled(false);
					nombreEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnNombre.setBounds(10, 26, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnNombre);

		JRadioButton rdbtnApellidos = new JRadioButton("Apellidos:");
		rdbtnApellidos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnApellidos.isSelected()) {
					apellidosEmpleadoModificar.setEnabled(true);
				} else {
					apellidosEmpleadoModificar.setEnabled(false);
					apellidosEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnApellidos.setBounds(10, 52, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnApellidos);

		JRadioButton rdbtnTelefono = new JRadioButton("Tel\u00E9fono:");
		rdbtnTelefono.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnTelefono.isSelected()) {
					telefonoEmpleadoModificar.setEnabled(true);
				} else {
					telefonoEmpleadoModificar.setEnabled(false);
					telefonoEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnTelefono.setBounds(10, 82, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnTelefono);

		JRadioButton rdbtnClave = new JRadioButton("Clave");
		rdbtnClave.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnClave.isSelected()) {
					passwordFieldEmpleadoModificar.setEnabled(true);
				} else {
					passwordFieldEmpleadoModificar.setEnabled(false);
					passwordFieldEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnClave.setBounds(10, 108, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnClave);

		JRadioButton rdbtnEdadEmpleadoModificar = new JRadioButton("Edad:");
		rdbtnEdadEmpleadoModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnEdadEmpleadoModificar.isSelected()) {
					spinnerEdad.setEnabled(true);
				} else {
					spinnerEdad.setEnabled(false);
					spinnerEdad.setValue(16);
				}
			}
		});
		rdbtnEdadEmpleadoModificar.setBounds(307, 26, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnEdadEmpleadoModificar);

		JRadioButton rdbtnEmailEmpleadoModificar = new JRadioButton("E-mail:");
		rdbtnEmailEmpleadoModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnEmailEmpleadoModificar.isSelected()) {
					textFieldEmailModificarEmpleado.setEnabled(true);
				} else {
					textFieldEmailModificarEmpleado.setEnabled(false);
					textFieldEmailModificarEmpleado.setText(null);
				}
			}
		});
		rdbtnEmailEmpleadoModificar.setBounds(307, 52, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnEmailEmpleadoModificar);

		JRadioButton rdbtnSalario = new JRadioButton("Salario:");
		rdbtnSalario.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnSalario.isSelected()) {
					textFieldSalarioEmpleadoModificar.setEnabled(true);
				} else {
					textFieldSalarioEmpleadoModificar.setEnabled(false);
					textFieldSalarioEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnSalario.setBounds(307, 78, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnSalario);

		JRadioButton rdbtnAntigedad = new JRadioButton("Antig\u00FCedad:");
		rdbtnAntigedad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnAntigedad.isSelected()) {
					textFieldAntiguedadEmpleadoModificar.setEnabled(true);
				} else {
					textFieldAntiguedadEmpleadoModificar.setEnabled(false);
					textFieldAntiguedadEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnAntigedad.setBounds(307, 104, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnAntigedad);

		JRadioButton rdbtnTipoEmpleadoModificar = new JRadioButton("Tipo:");
		rdbtnTipoEmpleadoModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnTipoEmpleadoModificar.isSelected()) {
					comboBoxTipoEmpleadoModificar.setEnabled(true);
				} else {
					comboBoxTipoEmpleadoModificar.setEnabled(false);
				}
			}
		});
		rdbtnTipoEmpleadoModificar.setBounds(135, 130, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnTipoEmpleadoModificar);
		modificarDatosPersonalesEmpleados.setVisible(false);

		ButtonGroup grupoRadioButtonsModificarEmpleado = new ButtonGroup();
		grupoRadioButtonsModificarEmpleado.add(rdbtnNombre);
		grupoRadioButtonsModificarEmpleado.add(rdbtnApellidos);
		grupoRadioButtonsModificarEmpleado.add(rdbtnTelefono);
		grupoRadioButtonsModificarEmpleado.add(rdbtnClave);
		grupoRadioButtonsModificarEmpleado.add(rdbtnEdadEmpleadoModificar);
		grupoRadioButtonsModificarEmpleado.add(rdbtnEmailEmpleadoModificar);
		grupoRadioButtonsModificarEmpleado.add(rdbtnSalario);
		grupoRadioButtonsModificarEmpleado.add(rdbtnAntigedad);
		grupoRadioButtonsModificarEmpleado.add(rdbtnTipoEmpleadoModificar);

		JButton btnModificarEmpleado = new JButton("Modificar");
		btnModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoPersona = "";
				boolean dniValido = false;
				String opcion = "";
				String datoNuevo = "";
				boolean modificarValido = true;
				boolean modificar = false;
				if (rdbtnNombre.isSelected()) {
					tipoPersona="persona";
				} else if (rdbtnApellidos.isSelected()) {
					tipoPersona="persona";
				} else if (rdbtnTelefono.isSelected()) {
					tipoPersona="persona";
				} else if (rdbtnClave.isSelected()) {
					tipoPersona="persona";
				} else if (rdbtnEdadEmpleadoModificar.isSelected()) {
					tipoPersona="persona";
				} else if (rdbtnEmailEmpleadoModificar.isSelected()) {
					tipoPersona="persona";
				} else if (rdbtnSalario.isSelected()) {
					tipoPersona="empleado";
				} else if (rdbtnAntigedad.isSelected()) {
					tipoPersona="empleado";
				} else if (rdbtnTipoEmpleadoModificar.isSelected()) {
					tipoPersona="empleado";
				}
				String emailEmpleado = email.getText();
				String passwdEmpleado = passwd.getText();
				boolean empleado = gesBBDD.inicioSesion(emailEmpleado, passwdEmpleado, empleados);
				if (empleado) {
					Empleados empleadoModificar = gesBBDD.buscarUnEmpleado(emailEmpleado, passwdEmpleado);
					String dniEmpleado = empleadoModificar.getDni();
					String dniModificar = textFielddniEmpleadoModificar.getText();
					dniValido = val.comprobarDNI(dniModificar);
					if (dniValido) {
						if (dniModificar.trim().equalsIgnoreCase(dniEmpleado)) {
							if (rdbtnNombre.isSelected()) {
								opcion = "nombre";
								datoNuevo = nombreEmpleadoModificar.getText();
							} else if (rdbtnApellidos.isSelected()) {
								opcion = "apellidos";
								datoNuevo = apellidosEmpleadoModificar.getText();
							} else if (rdbtnTelefono.isSelected()) {
								opcion = "telefono";
								datoNuevo = telefonoEmpleadoModificar.getText();
							} else if (rdbtnClave.isSelected()) {
								opcion = "clave";
								datoNuevo = passwordFieldEmpleadoModificar.getText();
							} else if (rdbtnEdadEmpleadoModificar.isSelected()) {
								opcion = "edad";
								datoNuevo = (String) spinnerEdad.getValue();
							} else if (rdbtnEmailEmpleadoModificar.isSelected()) {
								opcion = "email";
								datoNuevo = textFieldEmailModificarEmpleado.getText();
							} else if (rdbtnSalario.isSelected()) {
								opcion = "salario";
								datoNuevo = textFieldSalarioEmpleadoModificar.getText();
							} else if (rdbtnAntigedad.isSelected()) {
								opcion = "antiguedad";
								datoNuevo = textFieldAntiguedadEmpleadoModificar.getText();
							} else if (rdbtnTipoEmpleadoModificar.isSelected()) {
								opcion = "tipo";
								datoNuevo = (String) comboBoxTipoEmpleadoModificar.getSelectedItem();
							} else {
								modificarValido = false;
							}
							if (modificarValido) {
								modificar = gesBBDD.modificarPersonas(dniModificar, opcion, datoNuevo, tipoPersona,
										empleados);
								if (modificar) {
									JOptionPane.showMessageDialog(empleados, "Dato modificado con exito");
								}
							} else {
								JOptionPane.showMessageDialog(empleados, "Selecciona un dato para modificar");
							}
						} else {
							JOptionPane.showMessageDialog(empleados, "El DNI introducido no es tu DNI");
						}
					} else {
						JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
					}
				}
			}
		});
		btnModificarEmpleado.setBounds(499, 256, 89, 23);
		modificarDatosPersonalesEmpleados.add(btnModificarEmpleado);

		JButton btnOcultar_6 = new JButton("Ocultar");
		btnOcultar_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnOcultar_6.setBounds(10, 256, 89, 23);
		modificarDatosPersonalesEmpleados.add(btnOcultar_6);

		textFielddniEmpleadoModificar = new JTextField();
		textFielddniEmpleadoModificar.setBounds(499, 225, 89, 20);
		modificarDatosPersonalesEmpleados.add(textFielddniEmpleadoModificar);
		textFielddniEmpleadoModificar.setColumns(10);
		textFielddniEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFielddniEmpleadoModificar.getText().length() == 9) {
					e.consume();
				}
			}
		});

		JLabel lblDniEmpleadoA = new JLabel("Introduce tu DNI:");
		lblDniEmpleadoA.setBounds(383, 228, 109, 14);
		modificarDatosPersonalesEmpleados.add(lblDniEmpleadoA);

		JPanel modificarActividades = new JPanel();
		modificarActividades.setBounds(234, 289, 609, 290);
		empleados.add(modificarActividades);
		modificarActividades.setLayout(null);
		modificarActividades.setVisible(false);

		JLabel label_10 = new JLabel("EL RADIOBUTTON DE LA IZQUIERDA SIRVE PARA MARCAR QUE VALOR VAS A MODIFICAR");
		label_10.setBounds(10, 5, 578, 14);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		modificarActividades.add(label_10);

		descripcionModificar = new JTextField();
		descripcionModificar.setBounds(142, 27, 86, 20);
		modificarActividades.add(descripcionModificar);
		descripcionModificar.setColumns(10);
		descripcionModificar.setEnabled(false);

		JComboBox comboBoxTipoActividadesModificar = new JComboBox();
		comboBoxTipoActividadesModificar.setBounds(142, 53, 86, 20);
		modificarActividades.add(comboBoxTipoActividadesModificar);
		comboBoxTipoActividadesModificar.addItem("Interna");
		comboBoxTipoActividadesModificar.addItem("Externa");
		comboBoxTipoActividadesModificar.setEnabled(false);

		medioTransporteActividadModificar = new JTextField();
		medioTransporteActividadModificar.setBounds(142, 79, 86, 20);
		modificarActividades.add(medioTransporteActividadModificar);
		medioTransporteActividadModificar.setColumns(10);
		medioTransporteActividadModificar.setEnabled(false);

		localizacionActividadModificar = new JTextField();
		localizacionActividadModificar.setBounds(142, 105, 86, 20);
		modificarActividades.add(localizacionActividadModificar);
		localizacionActividadModificar.setColumns(10);
		localizacionActividadModificar.setEnabled(false);

		codigoActividadModificar = new JTextField();
		codigoActividadModificar.setBounds(142, 131, 86, 20);
		modificarActividades.add(codigoActividadModificar);
		codigoActividadModificar.setColumns(10);
		codigoActividadModificar.setEnabled(false);

		TimePicker timePickerHoraModificarActividades = new TimePicker(timeSettings);
		timePickerHoraModificarActividades.setBounds(423, 26, 165, 26);
		modificarActividades.add(timePickerHoraModificarActividades);
		timePickerHoraModificarActividades.setEnabled(false);

		DatePickerSettings dateSettingsModificarActividades = new DatePickerSettings();
		dateSettingsModificarActividades.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsModificarActividades.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsModificarActividades.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsModificarActividades.setGapBeforeButtonPixels(0);
		DatePicker calendarioModificarActividades = new DatePicker(dateSettingsModificarActividades);
		dateSettingsModificarActividades.setDateRangeLimits(LocalDate.now(), null);
		calendarioModificarActividades.setDateToToday();
		calendarioModificarActividades.setBounds(422, 62, 166, 26);
		modificarActividades.add(calendarioModificarActividades);
		calendarioModificarActividades.setEnabled(false);

		JSpinner aforoModificarActividades = new JSpinner();
		aforoModificarActividades.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) aforoModificarActividades.getValue() < 0) {
					aforoModificarActividades.setValue(0);
					JOptionPane.showMessageDialog(empleados, "El aforo no puede ser inferior a 0");
				}
			}
		});
		aforoModificarActividades.setBounds(423, 96, 165, 20);
		modificarActividades.add(aforoModificarActividades);
		aforoModificarActividades.setEnabled(false);

		TimePicker timePickerDuracionModificarActividades = new TimePicker(timeSettingsDuracion);
		timePickerDuracionModificarActividades.setBounds(423, 122, 165, 25);
		modificarActividades.add(timePickerDuracionModificarActividades);
		timePickerHoraModificarActividades.setEnabled(false);

		precioModificarActividades = new JTextField();
		precioModificarActividades.setBounds(142, 157, 86, 20);
		modificarActividades.add(precioModificarActividades);
		precioModificarActividades.setColumns(10);
		precioModificarActividades.setEnabled(false);

		codigoActividadAModificar = new JTextField();
		codigoActividadAModificar.setBounds(423, 158, 165, 30);
		modificarActividades.add(codigoActividadAModificar);
		codigoActividadAModificar.setColumns(10);

		JLabel lblCodigoDeLa_1 = new JLabel(
				"<html><body><center>Codigo de la actividad<br> a modificar: </center></body></html>");
		lblCodigoDeLa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoDeLa_1.setBounds(276, 153, 137, 42);
		modificarActividades.add(lblCodigoDeLa_1);

		JRadioButton rdbtnDescripcion = new JRadioButton("Descripcion: ");
		rdbtnDescripcion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnDescripcion.isSelected()) {
					descripcionModificar.setEnabled(true);
				} else {
					descripcionModificar.setEnabled(false);
					descripcionModificar.setText(null);
				}
			}
		});
		rdbtnDescripcion.setBounds(6, 26, 130, 23);
		modificarActividades.add(rdbtnDescripcion);

		JRadioButton rdbtnTipoModificarActividades = new JRadioButton("Tipo:");
		rdbtnTipoModificarActividades.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnTipoModificarActividades.isSelected()) {
					comboBoxTipoActividadesModificar.setEnabled(true);
				} else {
					comboBoxTipoActividadesModificar.setEnabled(false);
					comboBoxTipoActividadesModificar.setSelectedItem("Interior");
				}
			}
		});
		rdbtnTipoModificarActividades.setBounds(6, 52, 130, 23);
		modificarActividades.add(rdbtnTipoModificarActividades);

		JRadioButton rdbtnMedioTransporte = new JRadioButton("Medio transporte:");
		rdbtnMedioTransporte.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnMedioTransporte.isSelected()) {
					medioTransporteActividadModificar.setEnabled(true);
				} else {
					medioTransporteActividadModificar.setEnabled(false);
					medioTransporteActividadModificar.setText(null);
				}
			}
		});
		rdbtnMedioTransporte.setBounds(6, 78, 130, 23);
		modificarActividades.add(rdbtnMedioTransporte);

		JRadioButton rdbtnLocalizacion = new JRadioButton("Localizaci\u00F3n: ");
		rdbtnLocalizacion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnLocalizacion.isSelected()) {
					localizacionActividadModificar.setEnabled(true);
				} else {
					localizacionActividadModificar.setEnabled(false);
					localizacionActividadModificar.setText(null);
				}
			}
		});
		rdbtnLocalizacion.setBounds(6, 104, 130, 23);
		modificarActividades.add(rdbtnLocalizacion);

		JRadioButton rdbtnCodigo = new JRadioButton("Codigo:");
		rdbtnCodigo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnCodigo.isSelected()) {
					codigoActividadModificar.setEnabled(true);
				} else {
					codigoActividadModificar.setEnabled(false);
					codigoActividadModificar.setText(null);
				}
			}
		});
		rdbtnCodigo.setBounds(6, 130, 109, 23);
		modificarActividades.add(rdbtnCodigo);

		JRadioButton rdbtnHora = new JRadioButton("Hora:");
		rdbtnHora.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnHora.isSelected()) {
					timePickerHoraModificarActividades.setEnabled(true);
				} else {
					timePickerHoraModificarActividades.setEnabled(false);
				}
			}
		});
		rdbtnHora.setBounds(346, 26, 67, 26);
		modificarActividades.add(rdbtnHora);

		JRadioButton rdbtnFecha = new JRadioButton("Fecha:");
		rdbtnFecha.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnFecha.isSelected()) {
					calendarioModificarActividades.setEnabled(true);
				} else {
					calendarioModificarActividades.setEnabled(false);
				}
			}
		});
		rdbtnFecha.setBounds(346, 62, 67, 23);
		modificarActividades.add(rdbtnFecha);

		JRadioButton rdbtnAforo = new JRadioButton("Aforo:");
		rdbtnAforo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnAforo.isSelected()) {
					aforoModificarActividades.setEnabled(true);
				} else {
					aforoModificarActividades.setEnabled(false);
					aforoModificarActividades.setValue(0);
				}
			}
		});
		rdbtnAforo.setBounds(346, 95, 71, 23);
		modificarActividades.add(rdbtnAforo);

		JRadioButton rdbtnDuracion = new JRadioButton("Duraci\u00F3n:");
		rdbtnDuracion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnDuracion.isSelected()) {
					timePickerDuracionModificarActividades.setEnabled(true);
				} else {
					timePickerDuracionModificarActividades.setEnabled(false);
				}
			}
		});
		rdbtnDuracion.setBounds(346, 123, 71, 23);
		modificarActividades.add(rdbtnDuracion);

		JRadioButton rdbtnPrecio = new JRadioButton("Precio:");
		rdbtnPrecio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnPrecio.isSelected()) {
					precioHabitacionesModificar.setEnabled(true);
				} else {
					precioHabitacionesModificar.setEnabled(false);
					precioHabitacionesModificar.setText(null);
				}
			}
		});
		rdbtnPrecio.setBounds(6, 156, 126, 23);
		modificarActividades.add(rdbtnPrecio);

		ButtonGroup grupoRadioButtonsModificarActividades = new ButtonGroup();
		grupoRadioButtonsModificarActividades.add(rdbtnDescripcion);
		grupoRadioButtonsModificarActividades.add(rdbtnTipoModificarActividades);
		grupoRadioButtonsModificarActividades.add(rdbtnMedioTransporte);
		grupoRadioButtonsModificarActividades.add(rdbtnLocalizacion);
		grupoRadioButtonsModificarActividades.add(rdbtnCodigo);
		grupoRadioButtonsModificarActividades.add(rdbtnHora);
		grupoRadioButtonsModificarActividades.add(rdbtnFecha);
		grupoRadioButtonsModificarActividades.add(rdbtnAforo);
		grupoRadioButtonsModificarActividades.add(rdbtnDuracion);
		grupoRadioButtonsModificarActividades.add(rdbtnPrecio);

		JButton btnModificar_1 = new JButton("Modificar");
		btnModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String datoModificar = "";
				String datoNuevo = "";
				boolean existe = false;
				boolean modificar = false;
				try {
					if (rdbtnDescripcion.isSelected()) {
						datoModificar = "descripcion";
						datoNuevo = descripcionModificar.getText();
					} else if (rdbtnTipoModificarActividades.isSelected()) {
						datoModificar = "tipo";
						datoNuevo = (String) comboBoxTipoActividadesModificar.getSelectedItem();
					} else if (rdbtnMedioTransporte.isSelected()) {
						datoModificar = "medio de transporte";
						datoNuevo = medioTransporteActividadModificar.getText();
					} else if (rdbtnLocalizacion.isSelected()) {
						datoModificar = "localizacion";
						datoNuevo = localizacionActividadModificar.getText();
					} else if (rdbtnCodigo.isSelected()) {
						datoModificar = "codigo";
						datoNuevo = codigoActividadModificar.getText();
					} else if (rdbtnHora.isSelected()) {
						datoModificar = "hora";
						datoNuevo = timePickerHoraModificarActividades.toString();
					} else if (rdbtnFecha.isSelected()) {
						datoModificar = "fecha";
						datoNuevo = calendarioModificarActividades.toString();
					} else if (rdbtnAforo.isSelected()) {
						datoModificar = "aforo";
						datoNuevo = String.valueOf(aforoModificarActividades.getValue());
					} else if (rdbtnDuracion.isSelected()) {
						datoModificar = "duracion";
						datoNuevo = timePickerDuracionModificarActividades.getTime().toString();
					} else if (rdbtnPrecio.isSelected()) {
						datoModificar = "precio";
						datoNuevo = precioModificarActividades.getText();
					}
					String codigo = codigoActividadAModificar.getText();
					if (codigo.length() > 0) {
						existe = gesBBDD.actividadExiste(codigo, empleados);
						if (existe) {
							modificar = gesBBDD.modificarActividadesIndividual(codigo, datoModificar, datoNuevo);
							if (modificar) {
								JOptionPane.showMessageDialog(empleados, "Actividad modificada correctamente");
								listaActividades = gesBBDD.mostrarActividades(empleados);
								modelo.rellenarTabla(listaActividades, true);
								listaActividades.clear();
								codigoActividadAModificar.setText(null);
							}
						}
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcion.printStackTrace();
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					exception.printStackTrace();
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcionGenerica.printStackTrace();
				}
			}
		});
		btnModificar_1.setBounds(499, 256, 89, 23);
		modificarActividades.add(btnModificar_1);

		JButton btnOcultar_5 = new JButton("Ocultar");
		btnOcultar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarActividades.setVisible(false);
			}
		});
		btnOcultar_5.setBounds(10, 256, 89, 23);
		modificarActividades.add(btnOcultar_5);

		JPanel modificarHabitaciones = new JPanel();
		modificarHabitaciones.setBounds(234, 289, 608, 290);
		empleados.add(modificarHabitaciones);
		modificarHabitaciones.setLayout(null);
		modificarHabitaciones.setVisible(false);

		JLabel lblExplicacionModificarHabitaciones = new JLabel(
				"EL RADIOBUTTON DE LA IZQUIERDA SIRVE PARA MARCAR QUE VALOR VAS A MODIFICAR");
		lblExplicacionModificarHabitaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblExplicacionModificarHabitaciones.setBounds(10, 11, 578, 14);
		modificarHabitaciones.add(lblExplicacionModificarHabitaciones);

		JRadioButton rdbtnSuperficie = new JRadioButton("Superficie");
		rdbtnSuperficie.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnSuperficie.isSelected()) {
					superficieModificar.setEnabled(true);
				} else {
					superficieModificar.setEnabled(false);
					superficieModificar.setText(null);
				}
			}
		});

		superficieModificar = new JTextField();
		superficieModificar.setBounds(159, 32, 86, 20);
		modificarHabitaciones.add(superficieModificar);
		superficieModificar.setColumns(10);
		superficieModificar.setEnabled(false);

		JComboBox comboBoxTipoHabitacionesModificar = new JComboBox();
		comboBoxTipoHabitacionesModificar.setBounds(159, 58, 86, 20);
		modificarHabitaciones.add(comboBoxTipoHabitacionesModificar);
		comboBoxTipoHabitacionesModificar.addItem("Individual");
		comboBoxTipoHabitacionesModificar.addItem("Matrimonio");
		comboBoxTipoHabitacionesModificar.addItem("Suite");
		comboBoxTipoHabitacionesModificar.setEnabled(false);

		JSpinner numBanosModificar = new JSpinner();
		numBanosModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) numBanosModificar.getValue() < 0) {
					JOptionPane.showMessageDialog(empleados, "El numero de baños no puede ser inferior a 0");
					numBanosModificar.setValue(0);
				}
			}
		});
		numBanosModificar.setBounds(159, 84, 86, 20);
		modificarHabitaciones.add(numBanosModificar);
		numBanosModificar.setEnabled(false);

		JSpinner numCamasModificar = new JSpinner();
		numCamasModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if ((int) numCamasModificar.getValue() < 0) {
					JOptionPane.showMessageDialog(empleados, "El numero de camas no puede ser inferior a 0");
					numCamasModificar.setValue(0);
				}
			}
		});
		numCamasModificar.setBounds(159, 111, 86, 20);
		modificarHabitaciones.add(numCamasModificar);
		numCamasModificar.setEnabled(false);

		numHabitacionModificar = new JTextField();
		numHabitacionModificar.setBounds(306, 137, 86, 20);
		modificarHabitaciones.add(numHabitacionModificar);
		numHabitacionModificar.setColumns(10);
		numHabitacionModificar.setEnabled(false);

		precioHabitacionesModificar = new JTextField();
		precioHabitacionesModificar.setBounds(502, 32, 86, 20);
		modificarHabitaciones.add(precioHabitacionesModificar);
		precioHabitacionesModificar.setColumns(10);
		precioHabitacionesModificar.setEnabled(false);

		JCheckBox chckbxJacuzziModificar = new JCheckBox("");
		chckbxJacuzziModificar.setBounds(502, 57, 90, 23);
		modificarHabitaciones.add(chckbxJacuzziModificar);
		chckbxJacuzziModificar.setEnabled(false);

		JCheckBox checkBoxMatrimonioModificar = new JCheckBox("");
		checkBoxMatrimonioModificar.setBounds(502, 83, 97, 23);
		modificarHabitaciones.add(checkBoxMatrimonioModificar);
		checkBoxMatrimonioModificar.setEnabled(false);

		JCheckBox checkBoxTerraza = new JCheckBox("");
		checkBoxTerraza.setBounds(502, 110, 97, 23);
		modificarHabitaciones.add(checkBoxTerraza);
		checkBoxTerraza.setEnabled(false);

		rdbtnSuperficie.setBounds(10, 32, 143, 23);

		modificarHabitaciones.add(rdbtnSuperficie);

		JRadioButton rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnTipo.isSelected()) {
					comboBoxTipoHabitacionesModificar.setEnabled(true);
				} else {
					comboBoxTipoHabitacionesModificar.setEnabled(false);
					comboBoxTipoHabitacionesModificar.setSelectedItem("Individual");
				}
			}
		});
		rdbtnTipo.setBounds(10, 58, 143, 23);
		modificarHabitaciones.add(rdbtnTipo);

		JRadioButton rdbtnNumeroDeBanos = new JRadioButton("Numero de ba\u00F1os");
		rdbtnNumeroDeBanos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnNumeroDeBanos.isSelected()) {
					numBanosModificar.setEnabled(true);
				} else {
					numBanosModificar.setEnabled(false);
					numBanosModificar.setValue(0);
				}
			}
		});
		rdbtnNumeroDeBanos.setBounds(10, 84, 143, 23);
		modificarHabitaciones.add(rdbtnNumeroDeBanos);

		JRadioButton rdbtnNumeroDeCamas = new JRadioButton("Numero de camas");
		rdbtnNumeroDeCamas.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnNumeroDeCamas.isSelected()) {
					numCamasModificar.setEnabled(true);
				} else {
					numCamasModificar.setEnabled(false);
					numCamasModificar.setValue(0);
				}
			}
		});
		rdbtnNumeroDeCamas.setBounds(10, 110, 143, 23);
		modificarHabitaciones.add(rdbtnNumeroDeCamas);

		JRadioButton rdbtnNumeroHabitacionModificar = new JRadioButton("Numero de la habitacion");
		rdbtnNumeroHabitacionModificar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnNumeroHabitacionModificar.isSelected()) {
					numHabitacionModificar.setEnabled(true);
				} else {
					numHabitacionModificar.setEnabled(false);
					numHabitacionModificar.setText(null);
				}
			}
		});
		rdbtnNumeroHabitacionModificar.setBounds(134, 136, 166, 23);
		modificarHabitaciones.add(rdbtnNumeroHabitacionModificar);

		JRadioButton rdbtnPrecioHabitacion = new JRadioButton("Precio habitacion");
		rdbtnPrecioHabitacion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnPrecioHabitacion.isSelected()) {
					precioHabitacionesModificar.setEnabled(true);
				} else {
					precioHabitacionesModificar.setEnabled(false);
					precioHabitacionesModificar.setText(null);
				}
			}
		});
		rdbtnPrecioHabitacion.setBounds(372, 31, 124, 23);
		modificarHabitaciones.add(rdbtnPrecioHabitacion);

		JRadioButton rdbtnJacuzzi = new JRadioButton("Jacuzzi");
		rdbtnJacuzzi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnJacuzzi.isSelected()) {
					chckbxJacuzziModificar.setEnabled(true);
				} else {
					chckbxJacuzziModificar.setEnabled(false);
					chckbxJacuzziModificar.setSelected(false);
				}
			}
		});
		rdbtnJacuzzi.setBounds(372, 57, 109, 23);
		modificarHabitaciones.add(rdbtnJacuzzi);

		JRadioButton rdbtnMatrimonio = new JRadioButton("Matrimonio");
		rdbtnMatrimonio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnMatrimonio.isSelected()) {
					checkBoxMatrimonioModificar.setEnabled(true);
				} else {
					checkBoxMatrimonioModificar.setEnabled(false);
					checkBoxMatrimonioModificar.setSelected(false);
				}
			}
		});
		rdbtnMatrimonio.setBounds(372, 83, 109, 23);
		modificarHabitaciones.add(rdbtnMatrimonio);

		JRadioButton rdbtnTerraza = new JRadioButton("Terraza");
		rdbtnTerraza.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnTerraza.isSelected()) {
					checkBoxTerraza.setEnabled(true);
				} else {
					checkBoxTerraza.setEnabled(false);
					checkBoxTerraza.setSelected(false);
				}
			}
		});
		rdbtnTerraza.setBounds(372, 110, 109, 23);
		modificarHabitaciones.add(rdbtnTerraza);

		ButtonGroup grupoRadioButtonsModificarHabitaciones = new ButtonGroup();
		grupoRadioButtonsModificarHabitaciones.add(rdbtnSuperficie);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnTipo);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnNumeroDeBanos);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnNumeroDeCamas);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnNumeroHabitacionModificar);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnPrecioHabitacion);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnJacuzzi);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnMatrimonio);
		grupoRadioButtonsModificarHabitaciones.add(rdbtnTerraza);

		JLabel lblNHabitacin = new JLabel("N\u00BA Habitaci\u00F3n a modificar: ");
		lblNHabitacin.setBounds(144, 166, 156, 14);
		modificarHabitaciones.add(lblNHabitacin);

		numHabitacionAModificar = new JTextField();
		numHabitacionAModificar.setBounds(306, 163, 86, 20);
		modificarHabitaciones.add(numHabitacionAModificar);
		numHabitacionAModificar.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datoModificar = "";
				String datoNuevo = "";
				boolean existe = false;
				boolean modificar = false;
				try {
					if (rdbtnSuperficie.isSelected()) {
						datoModificar = "superficie";
						datoNuevo = superficieModificar.getText();
					} else if (rdbtnTipo.isSelected()) {
						datoModificar = "tipo";
						datoNuevo = (String) comboBoxTipoHabitacionesModificar.getSelectedItem();
					} else if (rdbtnNumeroDeBanos.isSelected()) {
						datoModificar = "numero de baños";
						datoNuevo = String.valueOf(numBanosModificar.getValue());
					} else if (rdbtnNumeroDeCamas.isSelected()) {
						datoModificar = "numero de camas";
						datoNuevo = String.valueOf(numCamasModificar.getValue());
					} else if (rdbtnNumeroHabitacionModificar.isSelected()) {
						datoModificar = "numero de la habitacion";
						datoNuevo = numHabitacionModificar.getText();
					} else if (rdbtnPrecioHabitacion.isSelected()) {
						datoModificar = "precio de la habitacion";
						datoNuevo = precioHabitacionesModificar.getText();
					} else if (rdbtnJacuzzi.isSelected()) {
						datoModificar = "jacuzzi";
						if (chckbxJacuzziModificar.isSelected()) {
							datoNuevo = "si";
						} else {
							datoNuevo = "no";
						}
					} else if (rdbtnMatrimonio.isSelected()) {
						datoModificar = "matrimonio";
						if (checkBoxMatrimonioModificar.isSelected()) {
							datoNuevo = "si";
						} else {
							datoNuevo = "no";
						}
					} else if (rdbtnTerraza.isSelected()) {
						datoModificar = "terraza";
						if (checkBoxTerraza.isSelected()) {
							datoNuevo = "si";
						} else {
							datoNuevo = "no";
						}
					}
					int numHabitacion = Integer.parseInt(numHabitacionAModificar.getText());
					if (numHabitacion > 0) {
						existe = gesBBDD.habitacionExiste(numHabitacion, empleados);
						if (existe) {
							modificar = gesBBDD.modificarHabitaciones(numHabitacion, datoNuevo, datoModificar);
							if (modificar) {
								JOptionPane.showMessageDialog(empleados, "Habitación modificada correctamente");
								listaHabitaciones = gesBBDD.mostrarHabitaciones();
								modelo.rellenarTabla(listaHabitaciones, true);
								listaHabitaciones.clear();
								numHabitacionAModificar.setText(null);
							} else {
								JOptionPane.showMessageDialog(empleados, "No ha sido posible modificar la habitación");
							}
						}
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcion.printStackTrace();
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					exception.printStackTrace();
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcionGenerica.printStackTrace();
				}
			}
		});
		btnModificar.setBounds(499, 256, 89, 23);
		modificarHabitaciones.add(btnModificar);

		JButton btnOcultar_4 = new JButton("Ocultar");
		btnOcultar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarHabitaciones.setVisible(false);
			}
		});
		btnOcultar_4.setBounds(10, 256, 89, 23);
		modificarHabitaciones.add(btnOcultar_4);

		JPanel borrarEmpleado = new JPanel();
		borrarEmpleado.setBounds(234, 289, 609, 290);
		empleados.add(borrarEmpleado);
		borrarEmpleado.setLayout(null);
		borrarEmpleado.setVisible(false);

		JLabel lblDniDelEmpleado = new JLabel("DNI del empleado:");
		lblDniDelEmpleado.setBounds(10, 11, 100, 14);
		borrarEmpleado.add(lblDniDelEmpleado);

		dniEmpleadoEliminar = new JTextField();
		dniEmpleadoEliminar.setBounds(120, 8, 86, 20);
		borrarEmpleado.add(dniEmpleadoEliminar);
		dniEmpleadoEliminar.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dniValido = false;
				String dni = dniEmpleadoEliminar.getText();
				dniValido = val.comprobarDNI(dni);
				if (dniValido) {
					gesBBDD.eliminarEmpleados(dni, empleados);
					gesBBDD.eliminarPersonas(dni, empleados);
				} else {
					JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
				}
			}
		});
		btnEliminar.setBounds(499, 256, 89, 23);
		borrarEmpleado.add(btnEliminar);

		JButton btnOcultar_3 = new JButton("Ocultar");
		btnOcultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarEmpleado.setVisible(false);
			}
		});
		btnOcultar_3.setBounds(10, 256, 89, 23);
		borrarEmpleado.add(btnOcultar_3);

		JPanel anadirEmpleado = new JPanel();
		anadirEmpleado.setBounds(234, 289, 609, 290);
		empleados.add(anadirEmpleado);
		anadirEmpleado.setLayout(null);
		anadirEmpleado.setVisible(false);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 101, 14);
		anadirEmpleado.add(lblNombre);

		nombreEmpleadoNuevo = new JTextField();
		nombreEmpleadoNuevo.setBounds(121, 8, 86, 20);
		anadirEmpleado.add(nombreEmpleadoNuevo);
		nombreEmpleadoNuevo.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 36, 101, 14);
		anadirEmpleado.add(lblApellidos);

		apellidosEmpleadoNuevo = new JTextField();
		apellidosEmpleadoNuevo.setBounds(121, 33, 86, 20);
		anadirEmpleado.add(apellidosEmpleadoNuevo);
		apellidosEmpleadoNuevo.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 61, 101, 14);
		anadirEmpleado.add(lblDni);

		dniEmpleadoNuevo = new JTextField();
		dniEmpleadoNuevo.setBounds(121, 58, 86, 20);
		anadirEmpleado.add(dniEmpleadoNuevo);
		dniEmpleadoNuevo.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 86, 101, 14);
		anadirEmpleado.add(lblTelefono);

		telefono = new JTextField();
		telefono.setBounds(121, 83, 86, 20);
		anadirEmpleado.add(telefono);
		telefono.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(391, 36, 101, 14);
		anadirEmpleado.add(lblContrasena);

		passwdEmpleado = new JPasswordField();
		passwdEmpleado.setBounds(502, 33, 86, 20);
		anadirEmpleado.add(passwdEmpleado);

		DatePickerSettings dateSettingsAnadirEmpleado = new DatePickerSettings();
		dateSettingsAnadirEmpleado.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsAnadirEmpleado.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsAnadirEmpleado.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsAnadirEmpleado.setGapBeforeButtonPixels(0);
		DatePicker calendarioAnadirEmpleado = new DatePicker(dateSettingsAnadirEmpleado);
		calendarioAnadirEmpleado.setBounds(121, 111, 172, 30);
		LocalDate fechaMayorEdad = LocalDate.now().minusYears(16);
		dateSettingsAnadirEmpleado.setDateRangeLimits(null, fechaMayorEdad);
		calendarioAnadirEmpleado.setDate(fechaMayorEdad);
		anadirEmpleado.add(calendarioAnadirEmpleado);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(10, 118, 101, 14);
		anadirEmpleado.add(lblFechaNacimiento);

		emailEmpleadoNuevo = new JTextField();
		emailEmpleadoNuevo.setBounds(502, 8, 86, 20);
		anadirEmpleado.add(emailEmpleadoNuevo);
		emailEmpleadoNuevo.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(391, 11, 101, 14);
		anadirEmpleado.add(lblEmail);

		JLabel lblSalario = new JLabel("Salario: ");
		lblSalario.setBounds(391, 61, 101, 14);
		anadirEmpleado.add(lblSalario);

		salarioEmpleadoNuevo = new JTextField();
		salarioEmpleadoNuevo.setBounds(502, 58, 86, 20);
		anadirEmpleado.add(salarioEmpleadoNuevo);
		salarioEmpleadoNuevo.setColumns(10);

		JLabel lblAntigedad = new JLabel("Antig\u00FCedad");
		lblAntigedad.setBounds(391, 86, 101, 14);
		anadirEmpleado.add(lblAntigedad);

		antiguedadEmpleadoNuevo = new JTextField();
		antiguedadEmpleadoNuevo.setBounds(502, 83, 86, 20);
		anadirEmpleado.add(antiguedadEmpleadoNuevo);
		antiguedadEmpleadoNuevo.setColumns(10);

		JLabel lblTipoEmpleadoNuevo = new JLabel("Tipo:");
		lblTipoEmpleadoNuevo.setBounds(391, 118, 36, 14);
		anadirEmpleado.add(lblTipoEmpleadoNuevo);

		JComboBox comboBoxTipoEmpleadoNuevo = new JComboBox();
		comboBoxTipoEmpleadoNuevo.setBounds(422, 112, 166, 20);
		anadirEmpleado.add(comboBoxTipoEmpleadoNuevo);
		comboBoxTipoEmpleadoNuevo.addItem("Administrativo de recepción");
		comboBoxTipoEmpleadoNuevo.addItem("Conserje");
		comboBoxTipoEmpleadoNuevo.addItem("Recepcionista");

		JButton btnInsertar_1 = new JButton("Insertar");
		btnInsertar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				boolean insertar = false;
				boolean dniValido = false;
				try {
					String nombre = nombreEmpleadoNuevo.getText();
					if (nombre.length() > 0 && nombre.length() <= 20) {
						String apellidos = apellidosEmpleadoNuevo.getText();
						if (apellidos.length() > 0 && apellidos.length() <= 20) {
							String dni = dniEmpleadoNuevo.getText();
							dniValido = val.comprobarDNI(dni);
							if (dniValido) {
								String telefonoCadena = telefono.getText();
								if (telefonoCadena.trim().length() == 9) {
									int telefonoInt = Integer.parseInt(telefonoCadena.trim());
									LocalDate fechaNacimiento = calendarioAnadirEmpleado.getDate();
									int edad = (int) Period.between(fechaNacimiento, LocalDate.now()).getYears();
									if (edad >= 16 && edad <= 67) {
										String emailString = emailEmpleadoNuevo.getText();
										if (emailString.length() > 0 && emailString.length() <= 50) {
											Matcher matcher = pattern.matcher(emailString);
											if (matcher.find()) {
												String contrasena = passwdEmpleado.getText();
												if (contrasena.length() > 0 && contrasena.length() <= 20) {
													double salario = Double.parseDouble(salarioEmpleadoNuevo.getText());
													if (salario >= 900) {
														int antiguedadInt = Integer
																.parseInt(antiguedadEmpleadoNuevo.getText());
														if (antiguedadInt >= 0) {
															String tipo = (String) comboBoxTipoEmpleadoNuevo
																	.getSelectedItem();
															Empleados empleado = new Empleados(nombre, apellidos, dni,
																	telefonoInt, contrasena, edad, emailString, salario,
																	antiguedadInt, tipo);
															insertar = gesBBDD.insertarPersonas(empleado);
															if (insertar) {
																JOptionPane.showMessageDialog(empleados,
																		"Empleado insertado con éxito");
																nombreEmpleadoNuevo.setText(null);
																apellidosEmpleadoNuevo.setText(null);
																dniEmpleadoNuevo.setText(null);
																telefono.setText(null);
																calendarioAnadirEmpleado.setDate(fechaMayorEdad);
																emailEmpleadoNuevo.setText(null);
																passwdEmpleado.setText(null);
																salarioEmpleadoNuevo.setText(null);
																antiguedadEmpleadoNuevo.setText(null);
																comboBoxTipoEmpleadoNuevo
																		.setSelectedItem("Administrativo de recepción");
															} else {
																JOptionPane.showMessageDialog(empleados,
																		"No se ha podido insertar el empleado");
															}
														}
													}
												}
											} else {
												JOptionPane.showMessageDialog(empleados, "El correo no es válido");
											}
										}
									}
								}
							}
						}
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcion.printStackTrace();
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					exception.printStackTrace();
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcionGenerica.printStackTrace();
				}
			}
		});
		btnInsertar_1.setBounds(499, 256, 89, 23);
		anadirEmpleado.add(btnInsertar_1);

		JButton btnOcultar_2 = new JButton("Ocultar");
		btnOcultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirEmpleado.setVisible(false);
			}
		});
		btnOcultar_2.setBounds(10, 256, 89, 23);
		anadirEmpleado.add(btnOcultar_2);

		JPanel borrarActividades = new JPanel();
		borrarActividades.setBounds(234, 289, 609, 290);
		empleados.add(borrarActividades);
		borrarActividades.setLayout(null);

		JLabel lblCodigoDeLa = new JLabel("Codigo de la actividad:");
		lblCodigoDeLa.setBounds(10, 11, 124, 14);
		borrarActividades.add(lblCodigoDeLa);

		codActividadEliminar = new JTextField();
		codActividadEliminar.setBounds(144, 8, 86, 20);
		borrarActividades.add(codActividadEliminar);
		codActividadEliminar.setColumns(10);

		JButton btnEliminarActividades = new JButton("Eliminar");
		btnEliminarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean existe = false;
				String codigo = codActividadEliminar.getText();
				existe = gesBBDD.actividadExiste(codigo, empleados);
				if (existe) {
					gesBBDD.eliminarActividades(codigo, empleados);
					JOptionPane.showMessageDialog(empleados, "Actividad eliminada correctamente");
					listaActividades = gesBBDD.mostrarActividades(empleados);
					modelo.rellenarTabla(listaActividades, true);
					listaActividades.clear();
				} else {
					JOptionPane.showMessageDialog(empleados, "No se puede eliminar una actividad que no existe");
				}
			}
		});
		btnEliminarActividades.setBounds(499, 256, 89, 23);
		borrarActividades.add(btnEliminarActividades);

		JButton btnOcultar_1 = new JButton("Ocultar");
		btnOcultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarActividades.setVisible(false);
			}
		});
		btnOcultar_1.setBounds(10, 256, 89, 23);
		borrarActividades.add(btnOcultar_1);
		borrarActividades.setVisible(false);

		JPanel anadirActividades = new JPanel();
		anadirActividades.setBounds(234, 289, 609, 290);
		empleados.add(anadirActividades);
		anadirActividades.setLayout(null);
		anadirActividades.setVisible(false);

		JLabel lblCodigoActividad = new JLabel("Codigo de la actividad:");
		lblCodigoActividad.setBounds(10, 11, 120, 14);
		anadirActividades.add(lblCodigoActividad);

		codigoActividad = new JTextField();
		codigoActividad.setBounds(140, 8, 86, 20);
		anadirActividades.add(codigoActividad);
		codigoActividad.setColumns(10);

		JLabel lblTipoDeLa = new JLabel("Tipo de la actividad:");
		lblTipoDeLa.setBounds(10, 36, 120, 14);
		anadirActividades.add(lblTipoDeLa);

		JComboBox comboBoxTipoActividad = new JComboBox();
		comboBoxTipoActividad.setBounds(140, 33, 86, 20);
		anadirActividades.add(comboBoxTipoActividad);
		comboBoxTipoActividad.addItem("Interna");
		comboBoxTipoActividad.addItem("Externa");
		comboBoxTipoActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTipoActividad.getSelectedItem() == "Interna") {
					medioTransporte.setText("----");
					medioTransporte.setEnabled(false);
				} else if (comboBoxTipoActividad.getSelectedItem() == "Externa") {
					medioTransporte.setText(null);
					medioTransporte.setEnabled(true);
				}
			}
		});

		JLabel lblLocalizacion = new JLabel("Localizacion: ");
		lblLocalizacion.setBounds(10, 61, 120, 14);
		anadirActividades.add(lblLocalizacion);

		localizacion = new JTextField();
		localizacion.setBounds(140, 58, 86, 20);
		anadirActividades.add(localizacion);
		localizacion.setColumns(10);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 86, 120, 14);
		anadirActividades.add(lblHora);

		TimePicker timePicker = new TimePicker(timeSettings);
		timePicker.setBounds(140, 83, 86, 26);
		anadirActividades.add(timePicker);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(10, 121, 120, 14);
		anadirActividades.add(lblFecha);

		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettings.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettings.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettings.setGapBeforeButtonPixels(0);
		DatePicker calendario = new DatePicker(dateSettings);
		dateSettings.setDateRangeLimits(LocalDate.now(), null);
		calendario.setDateToToday();
		calendario.setBounds(140, 114, 205, 30);
		anadirActividades.add(calendario);

		JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setBounds(10, 158, 120, 14);
		anadirActividades.add(lblDuracin);

		TimePicker timePickerDuracion = new TimePicker(timeSettingsDuracion);
		timePickerDuracion.setBounds(140, 150, 86, 26);
		anadirActividades.add(timePickerDuracion);

		JLabel lblDescripcin = new JLabel("Descripcion:");
		lblDescripcin.setBounds(351, 13, 78, 14);
		anadirActividades.add(lblDescripcin);

		JLabel contadorCaracteres = new JLabel("0");
		contadorCaracteres.setBounds(572, 86, 26, 14);
		anadirActividades.add(contadorCaracteres);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(431, 11, 136, 89);
		anadirActividades.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JTextArea descripcion = new JTextArea();
		descripcion.setLineWrap(true);
		descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String descripcionCadena = descripcion.getText();
				int numCaracteres = descripcionCadena.length();
				if (numCaracteres > 300) {
					contadorCaracteres.setForeground(Color.red);
				} else {
					contadorCaracteres.setForeground(Color.black);
				}
				contadorCaracteres.setText(String.valueOf(numCaracteres));
			}
		});
		scrollPane_1.setViewportView(descripcion);

		JLabel lblMedioDeTransporte = new JLabel("Medio de transporte:");
		lblMedioDeTransporte.setBounds(355, 111, 120, 14);
		anadirActividades.add(lblMedioDeTransporte);

		medioTransporte = new JTextField();
		medioTransporte.setBounds(485, 108, 86, 20);
		anadirActividades.add(medioTransporte);
		medioTransporte.setColumns(10);
		medioTransporte.setText("----");
		medioTransporte.setEnabled(false);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(355, 144, 46, 14);
		anadirActividades.add(lblAforo);

		JSpinner spinnerAforo = new JSpinner();
		spinnerAforo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spinnerAforo.getValue() < 0) {
					spinnerAforo.setValue(0);
					JOptionPane.showMessageDialog(empleados, "El aforo no puede ser inferior a 0");
				}
			}
		});
		spinnerAforo.setBounds(485, 144, 86, 20);
		anadirActividades.add(spinnerAforo);

		JLabel lblDniEmpleado = new JLabel("DNI empleado: ");
		lblDniEmpleado.setBounds(355, 180, 111, 14);
		anadirActividades.add(lblDniEmpleado);

		dniEmpleadoActividades = new JTextField();
		dniEmpleadoActividades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniEmpleadoActividades.getText().length() == 9) {
					e.consume();
				}
			}
		});
		dniEmpleadoActividades.setBounds(485, 177, 86, 20);
		anadirActividades.add(dniEmpleadoActividades);
		dniEmpleadoActividades.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 183, 120, 14);
		anadirActividades.add(lblPrecio);

		precioActividad = new JTextField();
		precioActividad.setBounds(140, 180, 86, 20);
		anadirActividades.add(precioActividad);
		precioActividad.setColumns(10);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dniValido = false;
				boolean insertar = false;
				try {
					String codActividad = codigoActividad.getText();
					if (codActividad.length() > 0 && codActividad.length() <= 20) {
						String tipoActividad = (String) comboBoxTipoActividad.getSelectedItem();
						if (tipoActividad.length() > 0 && tipoActividad.length() <= 20) {
							String localizacionString = localizacion.getText();
							if (localizacionString.length() > 0 && localizacionString.length() <= 80) {
								LocalTime horaActividad = timePicker.getTime();
								LocalDate fechaActividad = calendario.getDate();
								String duracionString = timePickerDuracion.getTime().toString();
								double precioDouble = Double.parseDouble(precioActividad.getText());
								if (!duracionString.equals("00:00")) {
									String descripcionString = descripcion.getText();
									if (descripcionString.length() > 0 && descripcionString.length() <= 300) {
										String medioTransporteString = medioTransporte.getText();
										if (medioTransporteString.length() > 0
												&& medioTransporteString.length() <= 20) {
											int aforo = (int) spinnerAforo.getValue();
											String DNIEmpleado = dniEmpleadoActividades.getText();
											dniValido = val.comprobarDNI(DNIEmpleado);
											if (dniValido) {
												dniEmpleadoActividades.setBackground(Color.white);

												Actividades actividad = new Actividades(descripcionString,
														tipoActividad, medioTransporteString, localizacionString,
														codActividad, horaActividad, fechaActividad, aforo,
														duracionString, precioDouble);

												insertar = gesBBDD.insertarActividades(actividad, DNIEmpleado,
														empleados);

												if (insertar) {
													JOptionPane.showMessageDialog(empleados,
															"Actividad insertada con éxito");
													codigoActividad.setText(null);
													comboBoxTipoActividad.setSelectedItem("Interna");
													localizacion.setText(null);
													calendario.setDateToToday();
													descripcion.setText(null);
													medioTransporte.setText(null);
													spinnerAforo.setValue(0);
													dniEmpleadoActividades.setText(null);
													precioActividad.setText(null);
													contadorCaracteres.setText("0");
												} else {
													JOptionPane.showMessageDialog(empleados,
															"La actividad no ha podido ser insertada");
												}
											} else {
												JOptionPane.showMessageDialog(empleados,
														"El DNI introducido no es válido");
											}
										} else {
											JOptionPane.showMessageDialog(empleados,
													"El medio de transporte debe ser inferior o igual a 20 caractéres");
										}
									} else {
										JOptionPane.showMessageDialog(empleados,
												"La descripción debe ser inferior o igual a 300 caratéres");
									}
								} else {
									JOptionPane.showMessageDialog(empleados, "La duración debe ser superior a 00:00");
								}
							} else {
								JOptionPane.showMessageDialog(empleados,
										"La descripción debe ser superior a 0 caractéres e inferior o igual a 80");
							}
						}
					} else {
						JOptionPane.showMessageDialog(empleados,
								"La longitud del código debe ser superior a 0 caractéres e inferior o igual a 20");
					}
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcion.printStackTrace();
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					exception.printStackTrace();
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
					excepcionGenerica.printStackTrace();
				}
			}
		});
		btnInsertar.setBounds(499, 256, 89, 23);
		anadirActividades.add(btnInsertar);

		JButton btnOcultar = new JButton("Ocultar");
		btnOcultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirActividades.setVisible(false);
			}
		});
		btnOcultar.setBounds(10, 256, 89, 23);
		anadirActividades.add(btnOcultar);

		JPanel eliminarHabitaciones = new JPanel();
		eliminarHabitaciones.setBounds(234, 289, 609, 290);
		empleados.add(eliminarHabitaciones);
		eliminarHabitaciones.setLayout(null);
		eliminarHabitaciones.setVisible(false);

		JLabel label_9 = new JLabel("N\u00FAmero habitaci\u00F3n:");
		label_9.setBounds(10, 8, 111, 14);
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		eliminarHabitaciones.add(label_9);

		numHabitacionEliminar = new JTextField();
		numHabitacionEliminar.setBounds(131, 5, 86, 20);
		numHabitacionEliminar.setToolTipText("");
		numHabitacionEliminar.setColumns(10);
		eliminarHabitaciones.add(numHabitacionEliminar);

		JButton btnEliminarHabitacionesEmpleados = new JButton("Eliminar");
		btnEliminarHabitacionesEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean habitacionExiste = false;
				boolean numero = false;
				int numHabitacionInt = 0;
				try {
					numHabitacionInt = Integer.parseInt(numHabitacionEliminar.getText());
					numero = true;
				} catch (NumberFormatException excepcion) {
					JOptionPane.showMessageDialog(empleados, "Debes introducir un número");
				}
				if (numero) {
					habitacionExiste = gesBBDD.habitacionExiste(numHabitacionInt, empleados);
					if (habitacionExiste) {
						gesBBDD.eliminarHabitaciones(numHabitacionInt, empleados);
						numHabitacionEliminar.setText(null);
						try {
							listaHabitaciones = gesBBDD.mostrarHabitaciones();
							modelo.rellenarTabla(listaHabitaciones, true);
						} catch (NullPointerException excepcion) {
							JOptionPane.showMessageDialog(empleados, "No hay habitaciones que mostrar");
						}
					}
				}
			}
		});
		btnEliminarHabitacionesEmpleados.setBounds(499, 255, 89, 23);
		eliminarHabitaciones.add(btnEliminarHabitacionesEmpleados);

		JButton btnOcultarEliminar = new JButton("Ocultar");
		btnOcultarEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarHabitaciones.setVisible(false);
			}
		});
		btnOcultarEliminar.setBounds(10, 254, 97, 25);
		eliminarHabitaciones.add(btnOcultarEliminar);

		JPanel anadirHabitaciones = new JPanel();
		anadirHabitaciones.setBounds(234, 289, 609, 290);
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
		dniHabitacionEmpleados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniHabitacionEmpleados.getText().length() == 9) {
					e.consume();
				}
			}
		});
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
											insertar = gesBBDD.insertarHabitaciones(habitacionAnadir, dniEmpleadoString,
													empleados);
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
											"La superficie debe ser inferior o igual a 20 caractéres");
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
		lblM.setBounds(270, 137, 24, 14);
		anadirHabitaciones.add(lblM);

		JButton btnAnadirHabitaciones = new JButton("A\u00F1adir habitaciones");
		btnAnadirHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirHabitaciones.setVisible(true);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnAnadirHabitaciones.setBounds(10, 36, 214, 23);
		empleados.add(btnAnadirHabitaciones);

		JButton btnEliminarHabitaciones = new JButton("Eliminar habitaciones");
		btnEliminarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(true);
				eliminarHabitaciones.setVisible(true);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnEliminarHabitaciones.setBounds(10, 70, 214, 23);
		empleados.add(btnEliminarHabitaciones);

		JButton btnMostrarHabitaciones = new JButton("Mostrar habitaciones");
		btnMostrarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaHabitaciones = gesBBDD.mostrarHabitaciones();
				modelo.rellenarTabla(listaHabitaciones, true);
				listaHabitaciones.clear();
			}
		});
		btnMostrarHabitaciones.setBounds(10, 138, 214, 23);
		empleados.add(btnMostrarHabitaciones);

		JButton btnAnadirActividades = new JButton("A\u00F1adir actividades");
		btnAnadirActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(true);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnAnadirActividades.setBounds(10, 172, 214, 23);
		empleados.add(btnAnadirActividades);

		JButton btnBorrarActividades = new JButton("Borrar actividades");
		btnBorrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(true);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnBorrarActividades.setBounds(10, 206, 214, 23);
		empleados.add(btnBorrarActividades);

		JButton btnModificarActividades = new JButton("Modificar actividades");
		btnModificarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(true);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnModificarActividades.setBounds(10, 240, 214, 23);
		empleados.add(btnModificarActividades);

		JButton btnMostrarActividades = new JButton("Mostrar actividades");
		btnMostrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaActividades = gesBBDD.mostrarActividades(empleados);
				modelo.rellenarTabla(listaActividades, true);
				listaActividades.clear();
			}
		});
		btnMostrarActividades.setBounds(10, 274, 214, 23);
		empleados.add(btnMostrarActividades);

		JButton btnModificarHabitaciones = new JButton("Modificar habitaciones");
		btnModificarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(true);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnModificarHabitaciones.setBounds(10, 104, 214, 23);
		empleados.add(btnModificarHabitaciones);

		JButton btnAnadirEmpleado = new JButton("A\u00F1adir empleado");
		btnAnadirEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(true);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnAnadirEmpleado.setBounds(10, 308, 214, 23);
		empleados.add(btnAnadirEmpleado);

		JButton btnBorrarEmpleado = new JButton("Borrar empleado");
		btnBorrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(true);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
			}
		});
		btnBorrarEmpleado.setBounds(10, 342, 214, 23);
		empleados.add(btnBorrarEmpleado);

		JButton btnMostrarEmpleados = new JButton("Mostrar empleados");
		btnMostrarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String tipo = "empleados";
				listaPersonas = gesBBDD.mostrarPersonas(tipo, empleados);
				modelo.rellenarTabla(listaPersonas, true);
				listaPersonas.clear();
			}
		});
		btnMostrarEmpleados.setBounds(10, 376, 214, 23);
		empleados.add(btnMostrarEmpleados);

		JButton btnMostrarMovimientos = new JButton("Mostrar movimientos");
		btnMostrarMovimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaMovimientos = gesBBDD.consultarMovimientos();
				modelo.rellenarTabla(listaMovimientos, true);
				listaMovimientos.clear();
			}
		});
		btnMostrarMovimientos.setBounds(10, 410, 214, 23);
		empleados.add(btnMostrarMovimientos);

		JButton btnModificarDatosPersonales = new JButton("Modificar datos personales");
		btnModificarDatosPersonales.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificarDatosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(true);
			}
		});
		btnModificarDatosPersonales.setBounds(10, 512, 214, 23);
		empleados.add(btnModificarDatosPersonales);

		JButton btnMostrarReservas = new JButton("Mostrar reservas");
		btnMostrarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaReservas = gesBBDD.mostrarReservas();
				modelo.rellenarTabla(listaReservas, true);
				listaReservas.clear();
			}
		});
		btnMostrarReservas.setBounds(10, 444, 214, 23);
		empleados.add(btnMostrarReservas);
		btnMostrarReservas.setEnabled(true);

		JButton btnMostrarClientes = new JButton("Mostrar clientes");
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String tipo = "clientes";
				listaPersonas = gesBBDD.mostrarPersonas(tipo, empleados);
				modelo.rellenarTabla(listaPersonas, true);
				listaPersonas.clear();
			}
		});
		btnMostrarClientes.setBounds(10, 478, 214, 23);
		empleados.add(btnMostrarClientes);

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
				try {
					empleadoBoolean = gesBBDD.inicioSesion(emailString, contrasena, inicio);
					if (empleadoBoolean) {
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
						} else {
							JOptionPane.showMessageDialog(frmHotel, "Usuario y/o contraseña incorrectos");
						}
					}
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(inicio, "Fallo en la conexión con la base de datos");
				}
			}
		});

		JButton btnCerrarSesionEmpleados = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesionEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				modelo.vaciarTabla();
				empleados.setVisible(false);
				lblBienvenido.setText("Bienvenido");
				lblTipo.setText("Tipo:");
				frmHotel.setTitle("Hotel");
				email.setText(null);
				passwd.setText(null);
				JOptionPane.showMessageDialog(frmHotel, "Has cerrado sesión correctamente");
				inicio.setVisible(true);
			}
		});
		btnCerrarSesionEmpleados.setBounds(10, 546, 214, 23);
		empleados.add(btnCerrarSesionEmpleados);

		JButton btnVaciarTabla = new JButton("");
		btnVaciarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.vaciarTabla();
			}
		});
		btnVaciarTabla.setBounds(223, 0, 12, 18);
		empleados.add(btnVaciarTabla);

	}
}
