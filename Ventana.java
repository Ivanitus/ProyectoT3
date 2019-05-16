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
import javax.swing.BoxLayout;
import java.awt.Toolkit;

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
	private ArrayList<MovimientosHabitacionesClientes> listaMovimientos = new ArrayList<>();
	private ArrayList<ReservaHabitacionesClientes> listaReservas = new ArrayList<>();
	private JTextField superficieModificar;
	private JTextField numHabitacionModificar;
	private JTextField precioHabitacionesModificar;
	private JTextField numHabitacionAModificar;
	private JTextField medioTransporteActividadModificar;
	private JTextField localizacionActividadModificar;
	private JTextField codigoActividadModificar;
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
	private ArrayList<ReservaActividadesClientes> listaReservaActividades = new ArrayList<>();

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
					System.out.println("Fallo en la ejecuci�n de la aplicaci�n");
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
		frmHotel.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/logos/logoJava.png")));
		frmHotel.setResizable(false);
		frmHotel.setTitle("Hotel River Camps");
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
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (email.getText().length() == 50) {
					e.consume();
				}
			}
		});
		email.setColumns(10);
		email.setBounds(391, 34, 116, 22);
		inicio.add(email);

		JLabel label_2 = new JLabel("Contrase\u00F1a:");
		label_2.setBounds(312, 64, 75, 16);
		inicio.add(label_2);

		passwd = new JPasswordField();
		passwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (passwd.getText().length() == 20) {
					e.consume();
				}
			}
		});
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

		JPanel mostrarReservas = new JPanel();
		mostrarReservas.setBounds(234, 289, 609, 290);
		empleados.add(mostrarReservas);
		mostrarReservas.setLayout(null);
		mostrarReservas.setVisible(false);

		JButton btnMostrarReservasHabitaciones = new JButton("Mostrar reservas habitaciones");
		btnMostrarReservasHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaReservas = gesBBDD.mostrarReservasHabitaciones();
				modelo.rellenarTabla(listaReservas, true);
				listaReservas.clear();
			}
		});
		btnMostrarReservasHabitaciones.setBounds(12, 133, 211, 25);
		mostrarReservas.add(btnMostrarReservasHabitaciones);

		JButton btnMostrarReservasActividades = new JButton("Mostrar reservas actividades");
		btnMostrarReservasActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaReservaActividades = gesBBDD.mostrarReservasActividades(empleados);
				modelo.rellenarTabla(listaReservaActividades, true);
				listaReservaActividades.clear();
			}
		});
		btnMostrarReservasActividades.setBounds(386, 133, 211, 25);
		mostrarReservas.add(btnMostrarReservasActividades);

		JButton button_2 = new JButton("Ocultar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarReservas.setVisible(false);
			}
		});
		button_2.setBounds(12, 254, 89, 23);
		mostrarReservas.add(button_2);

		JPanel modificarDatosPersonalesEmpleados = new JPanel();
		modificarDatosPersonalesEmpleados.setBounds(234, 289, 609, 290);
		empleados.add(modificarDatosPersonalesEmpleados);
		modificarDatosPersonalesEmpleados.setLayout(null);
		modificarDatosPersonalesEmpleados.setVisible(false);

		JLabel label_11 = new JLabel("EL RADIOBUTTON DE LA IZQUIERDA SIRVE PARA MARCAR QUE VALOR VAS A MODIFICAR");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(10, 5, 578, 14);
		modificarDatosPersonalesEmpleados.add(label_11);

		nombreEmpleadoModificar = new JTextField();
		nombreEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (nombreEmpleadoModificar.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		nombreEmpleadoModificar.setBounds(125, 27, 86, 20);
		modificarDatosPersonalesEmpleados.add(nombreEmpleadoModificar);
		nombreEmpleadoModificar.setColumns(10);
		nombreEmpleadoModificar.setEnabled(false);

		apellidosEmpleadoModificar = new JTextField();
		apellidosEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (apellidosEmpleadoModificar.getText().length() == 40) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		apellidosEmpleadoModificar.setBounds(125, 53, 86, 20);
		modificarDatosPersonalesEmpleados.add(apellidosEmpleadoModificar);
		apellidosEmpleadoModificar.setColumns(10);
		apellidosEmpleadoModificar.setEnabled(false);

		telefonoEmpleadoModificar = new JTextField();
		telefonoEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (telefonoEmpleadoModificar.getText().length() == 9) {
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		telefonoEmpleadoModificar.setBounds(125, 83, 86, 20);
		modificarDatosPersonalesEmpleados.add(telefonoEmpleadoModificar);
		telefonoEmpleadoModificar.setColumns(10);
		telefonoEmpleadoModificar.setEnabled(false);

		passwordFieldEmpleadoModificar = new JPasswordField();
		passwordFieldEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (passwordFieldEmpleadoModificar.getText().length() == 20) {
					e.consume();
				}
			}
		});
		passwordFieldEmpleadoModificar.setBounds(125, 109, 86, 20);
		modificarDatosPersonalesEmpleados.add(passwordFieldEmpleadoModificar);
		passwordFieldEmpleadoModificar.setEnabled(false);

		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setValue(16);
		spinnerEdad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) spinnerEdad.getValue() < 16) {
					JOptionPane.showMessageDialog(empleados, "El empleado no puede tener una edad inferior a 16 a�os");
					spinnerEdad.setValue(16);
				} else if ((int) spinnerEdad.getValue() > 67) {
					JOptionPane.showMessageDialog(empleados, "El empleado no puede tener una edad superior a 67 a�os");
					spinnerEdad.setValue(67);
				}
			}
		});
		spinnerEdad.setBounds(422, 27, 166, 20);
		modificarDatosPersonalesEmpleados.add(spinnerEdad);
		spinnerEdad.setEnabled(false);

		textFieldEmailModificarEmpleado = new JTextField();
		textFieldEmailModificarEmpleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldEmailModificarEmpleado.getText().length() == 50) {
					e.consume();
				}
			}
		});
		textFieldEmailModificarEmpleado.setBounds(422, 53, 166, 20);
		modificarDatosPersonalesEmpleados.add(textFieldEmailModificarEmpleado);
		textFieldEmailModificarEmpleado.setColumns(10);
		textFieldEmailModificarEmpleado.setEnabled(false);

		textFieldSalarioEmpleadoModificar = new JTextField();
		textFieldSalarioEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		textFieldSalarioEmpleadoModificar.setBounds(422, 79, 166, 20);
		modificarDatosPersonalesEmpleados.add(textFieldSalarioEmpleadoModificar);
		textFieldSalarioEmpleadoModificar.setColumns(10);
		textFieldSalarioEmpleadoModificar.setEnabled(false);

		textFieldAntiguedadEmpleadoModificar = new JTextField();
		textFieldAntiguedadEmpleadoModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		textFieldAntiguedadEmpleadoModificar.setBounds(422, 105, 166, 20);
		modificarDatosPersonalesEmpleados.add(textFieldAntiguedadEmpleadoModificar);
		textFieldAntiguedadEmpleadoModificar.setColumns(10);
		textFieldAntiguedadEmpleadoModificar.setEnabled(false);

		JComboBox comboBoxTipoEmpleadoModificar = new JComboBox();
		comboBoxTipoEmpleadoModificar.setBounds(250, 130, 166, 20);
		modificarDatosPersonalesEmpleados.add(comboBoxTipoEmpleadoModificar);
		comboBoxTipoEmpleadoModificar.addItem("Administrativo de recepci�n");
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
				boolean modificarValido = false;
				boolean modificar = false;
				boolean emailValido = false;
				if (rdbtnNombre.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnApellidos.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnTelefono.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnClave.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnEdadEmpleadoModificar.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnEmailEmpleadoModificar.isSelected()) {
					tipoPersona = "persona";
				} else if (rdbtnSalario.isSelected()) {
					tipoPersona = "empleado";
				} else if (rdbtnAntigedad.isSelected()) {
					tipoPersona = "empleado";
				} else if (rdbtnTipoEmpleadoModificar.isSelected()) {
					tipoPersona = "empleado";
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
						try {
							if (dniModificar.trim().equalsIgnoreCase(dniEmpleado)) {
								if (rdbtnNombre.isSelected()) {
									opcion = "nombre";
									datoNuevo = nombreEmpleadoModificar.getText();
									if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
										modificarValido = true;
									}
								} else if (rdbtnApellidos.isSelected()) {
									opcion = "apellidos";
									datoNuevo = apellidosEmpleadoModificar.getText();
									if (datoNuevo.length() > 0 && datoNuevo.length() <= 40) {
										modificarValido = false;
									}
								} else if (rdbtnTelefono.isSelected()) {
									opcion = "telefono";
									datoNuevo = telefonoEmpleadoModificar.getText();
									if (datoNuevo.length() == 9) {
										modificarValido = true;
									}
								} else if (rdbtnClave.isSelected()) {
									opcion = "clave";
									datoNuevo = passwordFieldEmpleadoModificar.getText();
									if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
										modificarValido = true;
									}
								} else if (rdbtnEdadEmpleadoModificar.isSelected()) {
									opcion = "edad";
									datoNuevo = String.valueOf((int) spinnerEdad.getValue());
									modificarValido = true;
								} else if (rdbtnEmailEmpleadoModificar.isSelected()) {
									opcion = "email";
									datoNuevo = textFieldEmailModificarEmpleado.getText();
									emailValido = val.comprobarEmail(datoNuevo);
									if (emailValido) {
										if (datoNuevo.length() > 0 && datoNuevo.length() <= 50) {
											modificarValido = true;
										} else {
											modificarValido = false;
											JOptionPane.showMessageDialog(empleados,
													"El e-mail no puede tener m�s de 50 caract�res");
										}
									} else {
										modificarValido = false;
										JOptionPane.showMessageDialog(empleados, "El e-mail introducido no es v�lido");
									}
								} else if (rdbtnSalario.isSelected()) {
									opcion = "salario";
									datoNuevo = textFieldSalarioEmpleadoModificar.getText();
									if (datoNuevo.length() > 0) {
										modificarValido = true;
									}
								} else if (rdbtnAntigedad.isSelected()) {
									opcion = "antiguedad";
									datoNuevo = textFieldAntiguedadEmpleadoModificar.getText();
									if (datoNuevo.length() > 0) {
										modificarValido = true;
									}
								} else if (rdbtnTipoEmpleadoModificar.isSelected()) {
									opcion = "tipo";
									datoNuevo = (String) comboBoxTipoEmpleadoModificar.getSelectedItem();
									if (datoNuevo.length() > 0 && datoNuevo.length() <= 27) {
										modificarValido = true;
									}
								} else {
									modificarValido = false;
								}
								if (modificarValido) {
									modificar = gesBBDD.modificarPersonas(dniModificar, opcion, datoNuevo, tipoPersona,
											empleados);
									if (modificar) {
										nombreEmpleadoModificar.setBackground(Color.white);
										apellidosEmpleadoModificar.setBackground(Color.white);
										telefonoEmpleadoModificar.setBackground(Color.white);
										passwordFieldEmpleadoModificar.setBackground(Color.white);
										spinnerEdad.setBackground(Color.white);
										textFieldEmailModificarEmpleado.setBackground(Color.white);
										textFieldSalarioEmpleadoModificar.setBackground(Color.white);
										textFieldAntiguedadEmpleadoModificar.setBackground(Color.white);
										comboBoxTipoEmpleadoModificar.setBackground(Color.white);
										JOptionPane.showMessageDialog(empleados, "Dato modificado con exito");
									}
								} else {
									JOptionPane.showMessageDialog(empleados, "Selecciona un dato para modificar");
									if (rdbtnNombre.isSelected()) {
										nombreEmpleadoModificar.setBackground(new Color(240, 128, 128));
									} else if (rdbtnApellidos.isSelected()) {
										apellidosEmpleadoModificar.setBackground(new Color(240, 128, 128));
									} else if (rdbtnTelefono.isSelected()) {
										telefonoEmpleadoModificar.setBackground(new Color(240, 128, 128));
									} else if (rdbtnClave.isSelected()) {
										passwordFieldEmpleadoModificar.setBackground(new Color(240, 128, 128));
									} else if (rdbtnEdadEmpleadoModificar.isSelected()) {
										spinnerEdad.setBackground(new Color(240, 128, 128));
									} else if (rdbtnEmailEmpleadoModificar.isSelected()) {
										textFieldEmailModificarEmpleado.setBackground(new Color(240, 128, 128));
									} else if (rdbtnSalario.isSelected()) {
										textFieldSalarioEmpleadoModificar.setBackground(new Color(240, 128, 128));
									} else if (rdbtnAntigedad.isSelected()) {
										textFieldAntiguedadEmpleadoModificar.setBackground(new Color(240, 128, 128));
									} else if (rdbtnTipoEmpleadoModificar.isSelected()) {
										comboBoxTipoEmpleadoModificar.setBackground(new Color(240, 128, 128));
									}
								}
							} else {
								JOptionPane.showMessageDialog(empleados, "El DNI introducido no es tu DNI");
							}
						} catch (NumberFormatException excepcion) {
							JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
						} catch (NullPointerException exception) {
							JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
						} catch (Exception excepcionGenerica) {
							JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
						}

					} else {
						JOptionPane.showMessageDialog(empleados, "El DNI introducido no es v�lido");
					}
				}
			}
		});

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

		DatePickerSettings dateSettingsModificarActividades = new DatePickerSettings();
		dateSettingsModificarActividades.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsModificarActividades.setFormatForDatesCommonEra("yyyy/MM/dd");
		dateSettingsModificarActividades.setFormatForDatesBeforeCommonEra("uuuu/MM/dd");
		dateSettingsModificarActividades.setGapBeforeButtonPixels(0);

		JPanel modificarActividades = new JPanel();
		modificarActividades.setBounds(234, 289, 609, 290);
		empleados.add(modificarActividades);
		modificarActividades.setLayout(null);
		modificarActividades.setVisible(false);

		JLabel label_10 = new JLabel("EL RADIOBUTTON DE LA IZQUIERDA SIRVE PARA MARCAR QUE VALOR VAS A MODIFICAR");
		label_10.setBounds(10, 5, 578, 14);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		modificarActividades.add(label_10);

		JScrollPane scrollPaneDescripcionModificar = new JScrollPane();
		scrollPaneDescripcionModificar.setBounds(142, 27, 126, 61);
		modificarActividades.add(scrollPaneDescripcionModificar);
		scrollPaneDescripcionModificar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDescripcionModificar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneDescripcionModificar.setEnabled(false);

		JTextArea descripcionModificar = new JTextArea();
		descripcionModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (descripcionModificar.getText().length() == 300) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		scrollPaneDescripcionModificar.setViewportView(descripcionModificar);
		descripcionModificar.setLineWrap(true);
		descripcionModificar.setEnabled(false);

		JComboBox comboBoxTipoActividadesModificar = new JComboBox();
		comboBoxTipoActividadesModificar.setBounds(142, 97, 86, 20);
		modificarActividades.add(comboBoxTipoActividadesModificar);
		comboBoxTipoActividadesModificar.addItem("Interna");
		comboBoxTipoActividadesModificar.addItem("Externa");
		comboBoxTipoActividadesModificar.setEnabled(false);

		medioTransporteActividadModificar = new JTextField();
		medioTransporteActividadModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (medioTransporteActividadModificar.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		medioTransporteActividadModificar.setBounds(142, 123, 86, 20);
		modificarActividades.add(medioTransporteActividadModificar);
		medioTransporteActividadModificar.setColumns(10);
		medioTransporteActividadModificar.setEnabled(false);

		localizacionActividadModificar = new JTextField();
		localizacionActividadModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (localizacionActividadModificar.getText().length() == 80) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		localizacionActividadModificar.setBounds(142, 149, 86, 20);
		modificarActividades.add(localizacionActividadModificar);
		localizacionActividadModificar.setColumns(10);
		localizacionActividadModificar.setEnabled(false);

		codigoActividadModificar = new JTextField();
		codigoActividadModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (codigoActividadModificar.getText().length() == 20) {
					e.consume();
				}
				if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		codigoActividadModificar.setBounds(142, 179, 86, 20);
		modificarActividades.add(codigoActividadModificar);
		codigoActividadModificar.setColumns(10);
		codigoActividadModificar.setEnabled(false);

		TimePicker timePickerHoraModificarActividades = new TimePicker(timeSettings);
		timePickerHoraModificarActividades.setBounds(423, 26, 165, 26);
		modificarActividades.add(timePickerHoraModificarActividades);
		timePickerHoraModificarActividades.setEnabled(false);
		DatePicker calendarioModificarActividades = new DatePicker(dateSettingsModificarActividades);
		dateSettingsModificarActividades.setDateRangeLimits(LocalDate.now(), null);
		calendarioModificarActividades.setDateToToday();
		calendarioModificarActividades.setBounds(422, 62, 166, 26);
		modificarActividades.add(calendarioModificarActividades);

		JSpinner aforoModificarActividades = new JSpinner();
		aforoModificarActividades.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) aforoModificarActividades.getValue() < 0) {
					aforoModificarActividades.setValue(0);
					JOptionPane.showMessageDialog(empleados, "El aforo no puede ser inferior a 0");
				} else if ((int) aforoModificarActividades.getValue() > 30) {
					aforoModificarActividades.setValue(30);
					JOptionPane.showMessageDialog(empleados, "El aforo no puede ser superior a 30 personas");
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

		codigoActividadAModificar = new JTextField();
		codigoActividadAModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (codigoActividadAModificar.getText().length() == 20) {
					e.consume();
				}
				if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
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
		rdbtnTipoModificarActividades.setBounds(6, 96, 130, 23);
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
		rdbtnMedioTransporte.setBounds(6, 122, 130, 23);
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
		rdbtnLocalizacion.setBounds(6, 148, 130, 23);
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
		rdbtnCodigo.setBounds(6, 178, 109, 23);
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

		JButton btnModificar_1 = new JButton("Modificar");
		btnModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String datoModificar = "";
				String datoNuevo = "";
				boolean existe = false;
				boolean modificar = false;
				boolean datoValido = false;
				try {
					if (rdbtnDescripcion.isSelected()) {
						datoModificar = "descripcion";
						datoNuevo = descripcionModificar.getText();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 300) {
							datoValido = true;
						}
					} else if (rdbtnTipoModificarActividades.isSelected()) {
						datoModificar = "tipo";
						datoNuevo = (String) comboBoxTipoActividadesModificar.getSelectedItem();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
							datoValido = true;
						}
					} else if (rdbtnMedioTransporte.isSelected()) {
						datoModificar = "medio de transporte";
						datoNuevo = medioTransporteActividadModificar.getText();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
							datoValido = true;
						}
					} else if (rdbtnLocalizacion.isSelected()) {
						datoModificar = "localizacion";
						datoNuevo = localizacionActividadModificar.getText();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 80) {
							datoValido = true;
						}
					} else if (rdbtnCodigo.isSelected()) {
						datoModificar = "codigo";
						datoNuevo = codigoActividadModificar.getText();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
							datoValido = true;
						}
					} else if (rdbtnHora.isSelected()) {
						datoModificar = "hora";
						datoNuevo = timePickerHoraModificarActividades.toString();
						datoValido = true;
					} else if (rdbtnFecha.isSelected()) {
						datoModificar = "fecha";
						datoNuevo = calendarioModificarActividades.toString();
						datoValido = true;
					} else if (rdbtnAforo.isSelected()) {
						datoModificar = "aforo";
						datoNuevo = String.valueOf(aforoModificarActividades.getValue());
						if (Integer.parseInt(datoNuevo) > 0) {
							datoValido = true;
						}
					} else if (rdbtnDuracion.isSelected()) {
						datoModificar = "duracion";
						datoNuevo = timePickerDuracionModificarActividades.getTime().toString();
						datoValido = true;
					}
					String codigo = codigoActividadAModificar.getText();
					if (codigo.length() > 0 && datoValido) {
						existe = gesBBDD.actividadExiste(codigo, empleados);
						if (existe) {
							modificar = gesBBDD.modificarActividadesIndividual(codigo, datoModificar, datoNuevo);
							if (modificar) {
								descripcionModificar.setBackground(Color.white);
								comboBoxTipoActividadesModificar.setBackground(Color.white);
								medioTransporteActividadModificar.setBackground(Color.white);
								localizacionActividadModificar.setBackground(Color.white);
								codigoActividadModificar.setBackground(Color.white);
								timePickerHoraModificarActividades.setBackground(Color.white);
								calendarioModificarActividades.setBackground(Color.white);
								aforoModificarActividades.setBackground(Color.white);
								timePickerDuracionModificarActividades.setBackground(Color.white);
								JOptionPane.showMessageDialog(empleados, "Actividad modificada correctamente");
								listaActividades = gesBBDD.mostrarActividades(empleados);
								modelo.rellenarTabla(listaActividades, true);
								listaActividades.clear();
								codigoActividadAModificar.setText(null);
							} else {
								if (rdbtnDescripcion.isSelected()) {
									descripcionModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnTipoModificarActividades.isSelected()) {
									comboBoxTipoActividadesModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnMedioTransporte.isSelected()) {
									medioTransporteActividadModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnLocalizacion.isSelected()) {
									localizacionActividadModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnCodigo.isSelected()) {
									codigoActividadModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnHora.isSelected()) {
									timePickerHoraModificarActividades.setBackground(new Color(240, 128, 128));
								} else if (rdbtnFecha.isSelected()) {
									calendarioModificarActividades.setBackground(new Color(240, 128, 128));
								} else if (rdbtnAforo.isSelected()) {
									aforoModificarActividades.setBackground(new Color(240, 128, 128));
								} else if (rdbtnDuracion.isSelected()) {
									timePickerDuracionModificarActividades.setBackground(new Color(240, 128, 128));
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
		superficieModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (superficieModificar.getText().length() == 2) {
					JOptionPane.showMessageDialog(empleados, "La superficie no puede ser mayor a 99 m\u00B2");
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
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
					JOptionPane.showMessageDialog(empleados, "El numero de ba�os no puede ser inferior a 0");
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
		numHabitacionModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		numHabitacionModificar.setBounds(306, 137, 86, 20);
		modificarHabitaciones.add(numHabitacionModificar);
		numHabitacionModificar.setColumns(10);
		numHabitacionModificar.setEnabled(false);

		precioHabitacionesModificar = new JTextField();
		precioHabitacionesModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
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
		numHabitacionAModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
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
				boolean datoValido = false;
				try {
					if (rdbtnSuperficie.isSelected()) {
						datoModificar = "superficie";
						datoNuevo = superficieModificar.getText();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
							datoValido = true;
						}
					} else if (rdbtnTipo.isSelected()) {
						datoModificar = "tipo";
						datoNuevo = (String) comboBoxTipoHabitacionesModificar.getSelectedItem();
						if (datoNuevo.length() > 0 && datoNuevo.length() <= 20) {
							datoValido = true;
						}
					} else if (rdbtnNumeroDeBanos.isSelected()) {
						datoModificar = "numero de ba�os";
						datoNuevo = String.valueOf(numBanosModificar.getValue());
						if (Integer.parseInt(datoNuevo) > 0) {
							datoValido = true;
						}
					} else if (rdbtnNumeroDeCamas.isSelected()) {
						datoModificar = "numero de camas";
						datoNuevo = String.valueOf(numCamasModificar.getValue());
						if (Integer.parseInt(datoNuevo) > 0) {
							datoValido = true;
						}
					} else if (rdbtnNumeroHabitacionModificar.isSelected()) {
						datoModificar = "numero de la habitacion";
						datoNuevo = numHabitacionModificar.getText();
						if (Integer.parseInt(datoNuevo) > 0) {
							datoValido = true;
						}
					} else if (rdbtnPrecioHabitacion.isSelected()) {
						datoModificar = "precio de la habitacion";
						datoNuevo = precioHabitacionesModificar.getText();
						if (Double.parseDouble(datoNuevo) > 0) {
							datoValido = true;
						}
					} else if (rdbtnJacuzzi.isSelected()) {
						datoModificar = "jacuzzi";
						if (chckbxJacuzziModificar.isSelected()) {
							datoNuevo = "si";
							datoValido = true;
						} else {
							datoNuevo = "no";
							datoValido = true;
						}
					} else if (rdbtnMatrimonio.isSelected()) {
						datoModificar = "matrimonio";
						if (checkBoxMatrimonioModificar.isSelected()) {
							datoNuevo = "si";
							datoValido = true;
						} else {
							datoNuevo = "no";
							datoValido = true;
						}
					} else if (rdbtnTerraza.isSelected()) {
						datoModificar = "terraza";
						if (checkBoxTerraza.isSelected()) {
							datoNuevo = "si";
							datoValido = true;
						} else {
							datoNuevo = "no";
							datoValido = true;
						}
					}
					int numHabitacion = Integer.parseInt(numHabitacionAModificar.getText());
					if (numHabitacion > 0 && datoValido) {
						existe = gesBBDD.habitacionExiste(numHabitacion, empleados);
						if (existe) {
							modificar = gesBBDD.modificarHabitaciones(numHabitacion, datoNuevo, datoModificar);
							if (modificar) {
								superficieModificar.setBackground(Color.white);
								comboBoxTipoHabitacionesModificar.setBackground(Color.white);
								numBanosModificar.setBackground(Color.white);
								numCamasModificar.setBackground(Color.white);
								numHabitacionModificar.setBackground(Color.white);
								precioHabitacionesModificar.setBackground(Color.white);
								chckbxJacuzziModificar.setBackground(Color.white);
								checkBoxMatrimonioModificar.setBackground(Color.white);
								checkBoxTerraza.setBackground(Color.white);
								JOptionPane.showMessageDialog(empleados, "Habitaci�n modificada correctamente");
								listaHabitaciones = gesBBDD.mostrarHabitaciones();
								modelo.rellenarTabla(listaHabitaciones, true);
								listaHabitaciones.clear();
								numHabitacionAModificar.setText(null);
							} else {
								if (rdbtnSuperficie.isSelected()) {
									superficieModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnTipo.isSelected()) {
									comboBoxTipoHabitacionesModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnNumeroDeBanos.isSelected()) {
									numBanosModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnNumeroDeCamas.isSelected()) {
									numCamasModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnNumeroHabitacionModificar.isSelected()) {
									numHabitacionModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnPrecioHabitacion.isSelected()) {
									precioHabitacionesModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnJacuzzi.isSelected()) {
									chckbxJacuzziModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnMatrimonio.isSelected()) {
									checkBoxMatrimonioModificar.setBackground(new Color(240, 128, 128));
								} else if (rdbtnTerraza.isSelected()) {
									checkBoxTerraza.setBackground(new Color(240, 128, 128));
								}
								JOptionPane.showMessageDialog(empleados, "No ha sido posible modificar la habitaci�n");
							}
						}
					} else {
						JOptionPane.showMessageDialog(empleados, "El dato introducido no es v�lido");
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
		dniEmpleadoEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniEmpleadoEliminar.getText().length() == 9) {
					e.consume();
				}
			}
		});
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
					dniEmpleadoEliminar.setBackground(Color.white);
					gesBBDD.eliminarEmpleados(dni, empleados);
					gesBBDD.eliminarPersonas(dni, empleados);
				} else {
					dniEmpleadoEliminar.setBackground(new Color(240, 128, 128));
					JOptionPane.showMessageDialog(empleados, "El DNI introducido no es v�lido");
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
		nombreEmpleadoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (nombreEmpleadoNuevo.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		nombreEmpleadoNuevo.setBounds(121, 8, 86, 20);
		anadirEmpleado.add(nombreEmpleadoNuevo);
		nombreEmpleadoNuevo.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 36, 101, 14);
		anadirEmpleado.add(lblApellidos);

		apellidosEmpleadoNuevo = new JTextField();
		apellidosEmpleadoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (apellidosEmpleadoNuevo.getText().length() == 40) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		apellidosEmpleadoNuevo.setBounds(121, 33, 86, 20);
		anadirEmpleado.add(apellidosEmpleadoNuevo);
		apellidosEmpleadoNuevo.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 61, 101, 14);
		anadirEmpleado.add(lblDni);

		dniEmpleadoNuevo = new JTextField();
		dniEmpleadoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniEmpleadoNuevo.getText().length() == 9) {
					e.consume();
				}
			}
		});
		dniEmpleadoNuevo.setBounds(121, 58, 86, 20);
		anadirEmpleado.add(dniEmpleadoNuevo);
		dniEmpleadoNuevo.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 86, 101, 14);
		anadirEmpleado.add(lblTelefono);

		telefono = new JTextField();
		telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		telefono.setBounds(121, 83, 86, 20);
		anadirEmpleado.add(telefono);
		telefono.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(391, 36, 101, 14);
		anadirEmpleado.add(lblContrasena);

		passwdEmpleado = new JPasswordField();
		passwdEmpleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (passwdEmpleado.getText().length() == 20) {
					e.consume();
				}
			}
		});
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
		emailEmpleadoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (emailEmpleadoNuevo.getText().length() == 50) {
					e.consume();
				}
			}
		});
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
		salarioEmpleadoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		salarioEmpleadoNuevo.setBounds(502, 58, 86, 20);
		anadirEmpleado.add(salarioEmpleadoNuevo);
		salarioEmpleadoNuevo.setColumns(10);

		JLabel lblAntigedad = new JLabel("Antig\u00FCedad");
		lblAntigedad.setBounds(391, 86, 101, 14);
		anadirEmpleado.add(lblAntigedad);

		antiguedadEmpleadoNuevo = new JTextField();
		antiguedadEmpleadoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		antiguedadEmpleadoNuevo.setBounds(502, 83, 86, 20);
		anadirEmpleado.add(antiguedadEmpleadoNuevo);
		antiguedadEmpleadoNuevo.setColumns(10);

		JLabel lblTipoEmpleadoNuevo = new JLabel("Tipo:");
		lblTipoEmpleadoNuevo.setBounds(391, 118, 36, 14);
		anadirEmpleado.add(lblTipoEmpleadoNuevo);

		JComboBox comboBoxTipoEmpleadoNuevo = new JComboBox();
		comboBoxTipoEmpleadoNuevo.setBounds(422, 112, 166, 20);
		anadirEmpleado.add(comboBoxTipoEmpleadoNuevo);
		comboBoxTipoEmpleadoNuevo.addItem("Administrativo de recepci�n");
		comboBoxTipoEmpleadoNuevo.addItem("Conserje");
		comboBoxTipoEmpleadoNuevo.addItem("Recepcionista");

		JButton btnInsertar_1 = new JButton("Insertar");
		btnInsertar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean emailValido = false;
				boolean insertar = false;
				boolean dniValido = false;
				try {
					String nombre = nombreEmpleadoNuevo.getText();
					if (nombre.length() > 0 && nombre.length() <= 20) {
						nombreEmpleadoNuevo.setBackground(Color.white);
						String apellidos = apellidosEmpleadoNuevo.getText();
						if (apellidos.length() > 0 && apellidos.length() <= 40) {
							apellidosEmpleadoNuevo.setBackground(Color.white);
							String dni = dniEmpleadoNuevo.getText();
							dniValido = val.comprobarDNI(dni);
							if (dniValido) {
								dniEmpleadoNuevo.setBackground(Color.white);
								String telefonoCadena = telefono.getText();
								if (telefonoCadena.trim().length() == 9) {
									telefono.setBackground(Color.white);
									int telefonoInt = Integer.parseInt(telefonoCadena.trim());
									LocalDate fechaNacimiento = calendarioAnadirEmpleado.getDate();
									int edad = (int) Period.between(fechaNacimiento, LocalDate.now()).getYears();
									if (edad >= 16 && edad <= 67) {
										calendarioAnadirEmpleado.setBackground(Color.white);
										String emailString = emailEmpleadoNuevo.getText();
										if (emailString.length() > 0 && emailString.length() <= 50) {
											emailValido = val.comprobarEmail(emailString);
											if (emailValido) {
												emailEmpleadoNuevo.setBackground(Color.white);
												String contrasena = passwdEmpleado.getText();
												if (contrasena.length() >= 6 && contrasena.length() <= 20) {
													passwdEmpleado.setBackground(Color.white);
													double salario = Double.parseDouble(salarioEmpleadoNuevo.getText());
													if (salario >= 900) {
														salarioEmpleadoNuevo.setBackground(Color.white);
														int antiguedadInt = Integer
																.parseInt(antiguedadEmpleadoNuevo.getText());
														if (antiguedadInt >= 0) {
															antiguedadEmpleadoNuevo.setBackground(Color.white);
															String tipo = (String) comboBoxTipoEmpleadoNuevo
																	.getSelectedItem();
															Empleados empleado = new Empleados(nombre, apellidos, dni,
																	telefonoInt, contrasena, edad, emailString, salario,
																	antiguedadInt, tipo);
															insertar = gesBBDD.insertarPersonas(empleado);
															if (insertar) {
																JOptionPane.showMessageDialog(empleados,
																		"Empleado insertado con �xito");
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
																		.setSelectedItem("Administrativo de recepci�n");
															} else {
																JOptionPane.showMessageDialog(empleados,
																		"No se ha podido insertar el empleado");
															}
														} else {
															antiguedadEmpleadoNuevo
																	.setBackground(new Color(240, 128, 128));
															JOptionPane.showMessageDialog(empleados,
																	"La antiguedad no puede ser inferior a 0");
														}
													} else {
														salarioEmpleadoNuevo.setBackground(new Color(240, 128, 128));
														JOptionPane.showMessageDialog(empleados,
																"El salario no puede ser inferior a 900�");
													}
												} else {
													passwdEmpleado.setBackground(new Color(240, 128, 128));
													JOptionPane.showMessageDialog(empleados,
															"La contrase�a debe tener m�nimo 6 caract�res y m�ximo 20");
												}
											} else {
												emailEmpleadoNuevo.setBackground(new Color(240, 128, 128));
												JOptionPane.showMessageDialog(empleados, "El correo no es v�lido");
											}
										} else {
											emailEmpleadoNuevo.setBackground(new Color(240, 128, 128));
											JOptionPane.showMessageDialog(empleados,
													"El e-mail no puede estar vac�o y tiene una longitud m�xima de 50 caract�res");
										}
									} else {
										calendarioAnadirEmpleado.setBackground(new Color(240, 128, 128));
										JOptionPane.showMessageDialog(empleados,
												"El empleado debe tener entre 16 y 67 a�os");
									}
								} else {
									telefono.setBackground(new Color(240, 128, 128));
									JOptionPane.showMessageDialog(empleados, "El tel�fono debe tener 9 n�meros");
								}
							} else {
								dniEmpleadoNuevo.setBackground(new Color(240, 128, 128));
								JOptionPane.showMessageDialog(empleados, "El DNI introducido no es v�lido");
							}
						} else {
							apellidosEmpleadoNuevo.setBackground(new Color(240, 128, 128));
							JOptionPane.showMessageDialog(empleados,
									"La longitud de los apellidos no puede superar los 40 car�cteres (espacios incluidos), ni estar vac�o");
						}
					} else {
						nombreEmpleadoNuevo.setBackground(new Color(240, 128, 128));
						JOptionPane.showMessageDialog(empleados,
								"La longitud del nombre no puede superar los 20 car�cteres ni estar vac�o");
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
		codActividadEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (codActividadEliminar.getText().length() == 20) {
					e.consume();
				}
			}
		});
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
					codActividadEliminar.setBackground(Color.white);
					gesBBDD.eliminarActividades(codigo, empleados);
					JOptionPane.showMessageDialog(empleados, "Actividad eliminada correctamente");
					listaActividades = gesBBDD.mostrarActividades(empleados);
					modelo.rellenarTabla(listaActividades, true);
					listaActividades.clear();
				} else {
					codActividadEliminar.setBackground(new Color(240, 128, 128));
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
		codigoActividad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (codigoActividad.getText().length() == 20) {
					e.consume();
				}
			}
		});
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
		localizacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (localizacion.getText().length() == 80) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
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
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		scrollPane_1.setViewportView(descripcion);

		JLabel lblMedioDeTransporte = new JLabel("Medio de transporte:");
		lblMedioDeTransporte.setBounds(355, 111, 120, 14);
		anadirActividades.add(lblMedioDeTransporte);

		medioTransporte = new JTextField();
		medioTransporte.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (medioTransporte.getText().length() == 20) {
					e.consume();
				}
				if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE)
						&& !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
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
				} else if ((int) spinnerAforo.getValue() > 30) {
					spinnerAforo.setValue(30);
					JOptionPane.showMessageDialog(empleados, "El aforo no puede ser superior a 30 personas");
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

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dniValido = false;
				boolean insertar = false;
				try {
					String codActividad = codigoActividad.getText();
					if (codActividad.length() > 0 && codActividad.length() <= 20) {
						codigoActividad.setBackground(Color.white);
						String tipoActividad = (String) comboBoxTipoActividad.getSelectedItem();
						if (tipoActividad.length() > 0 && tipoActividad.length() <= 20) {
							String localizacionString = localizacion.getText();
							if (localizacionString.length() > 0 && localizacionString.length() <= 80) {
								localizacion.setBackground(Color.white);
								LocalTime horaActividad = timePicker.getTime();
								LocalDate fechaActividad = calendario.getDate();
								String duracionString = timePickerDuracion.getTime().toString();
								if (!duracionString.equals("00:00")) {
									timePickerDuracion.setBackground(Color.white);
									String descripcionString = descripcion.getText();
									if (descripcionString.length() > 0 && descripcionString.length() <= 300) {
										descripcion.setBackground(Color.white);
										String medioTransporteString = medioTransporte.getText();
										if (medioTransporteString.length() > 0
												&& medioTransporteString.length() <= 20) {
											medioTransporte.setBackground(Color.white);
											int aforo = (int) spinnerAforo.getValue();
											String DNIEmpleado = dniEmpleadoActividades.getText();
											dniValido = val.comprobarDNI(DNIEmpleado);
											if (dniValido) {
												dniEmpleadoActividades.setBackground(Color.white);

												Actividades actividad = new Actividades(descripcionString,
														tipoActividad, medioTransporteString, localizacionString,
														codActividad, horaActividad, fechaActividad, aforo,
														duracionString);

												insertar = gesBBDD.insertarActividades(actividad, DNIEmpleado,
														empleados);

												if (insertar) {
													JOptionPane.showMessageDialog(empleados,
															"Actividad insertada con �xito");
													codigoActividad.setText(null);
													comboBoxTipoActividad.setSelectedItem("Interna");
													localizacion.setText(null);
													calendario.setDateToToday();
													descripcion.setText(null);
													medioTransporte.setText("----");
													spinnerAforo.setValue(0);
													dniEmpleadoActividades.setText(null);
													contadorCaracteres.setText("0");
												} else {
													JOptionPane.showMessageDialog(empleados,
															"La actividad no ha podido ser insertada");
												}
											} else {
												dniEmpleadoActividades.setBackground(new Color(240, 128, 128));
												JOptionPane.showMessageDialog(empleados,
														"El DNI introducido no es v�lido");
											}
										} else {
											medioTransporte.setBackground(new Color(240, 128, 128));
											JOptionPane.showMessageDialog(empleados,
													"El medio de transporte debe ser inferior o igual a 20 caract�res");
										}
									} else {
										descripcion.setBackground(new Color(240, 128, 128));
										JOptionPane.showMessageDialog(empleados,
												"La descripci�n debe ser inferior o igual a 300 carat�res");
									}
								} else {
									timePickerDuracion.setBackground(new Color(240, 128, 128));
									JOptionPane.showMessageDialog(empleados, "La duraci�n debe ser superior a 00:00");
								}
							} else {
								localizacion.setBackground(new Color(240, 128, 128));
								JOptionPane.showMessageDialog(empleados,
										"La descripci�n debe ser superior a 0 caract�res e inferior o igual a 80");
							}
						}
					} else {
						codigoActividad.setBackground(new Color(240, 128, 128));
						JOptionPane.showMessageDialog(empleados,
								"La longitud del c�digo debe ser superior a 0 caract�res e inferior o igual a 20");
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
		numHabitacionEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
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
					JOptionPane.showMessageDialog(empleados, "Debes introducir un n�mero");
					numHabitacionEliminar.setBackground(new Color(240, 128, 128));
				}
				if (numero) {
					numHabitacionEliminar.setBackground(Color.white);
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
					} else {
						numHabitacionEliminar.setBackground(new Color(240, 128, 128));
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
		numHabitacionEmpleados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		numHabitacionEmpleados.setToolTipText("");
		numHabitacionEmpleados.setColumns(10);
		numHabitacionEmpleados.setBounds(146, 14, 116, 22);
		anadirHabitaciones.add(numHabitacionEmpleados);

		JLabel label_4 = new JLabel("N\u00FAmero ba\u00F1os:");
		label_4.setBounds(10, 46, 124, 16);
		anadirHabitaciones.add(label_4);

		JSpinner numBanosEmpleados = new JSpinner();
		numBanosEmpleados.setValue(1);
		numBanosEmpleados.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ((int) numBanosEmpleados.getValue() > 2) {
					JOptionPane.showMessageDialog(empleados, "El n�mero de ba�os no puede ser superior a 2");
					numBanosEmpleados.setValue(2);
				} else if ((int) numBanosEmpleados.getValue() < 1) {
					JOptionPane.showMessageDialog(empleados, "El n�mero de ba�os no puede ser inferior a 1");
					numBanosEmpleados.setValue(1);
				}
			}
		});
		numBanosEmpleados.setBounds(146, 43, 116, 22);
		anadirHabitaciones.add(numBanosEmpleados);

		JLabel label_5 = new JLabel("N\u00FAmero camas:");
		label_5.setBounds(10, 78, 124, 16);
		anadirHabitaciones.add(label_5);

		JSpinner numCamasEmpleados = new JSpinner();
		numCamasEmpleados.setValue(1);
		numCamasEmpleados.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if ((int) numCamasEmpleados.getValue() > 4) {
					JOptionPane.showMessageDialog(empleados, "El n�mero de camas no puede ser superior a 4");
					numCamasEmpleados.setValue(4);
				} else if ((int) numCamasEmpleados.getValue() < 1) {
					JOptionPane.showMessageDialog(empleados, "El n�mero de camas no puede ser inferior a 1");
					numCamasEmpleados.setValue(1);
				}
			}
		});
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
		superficieHabitacionEmpleados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (superficieHabitacionEmpleados.getText().length() == 2) {
					JOptionPane.showMessageDialog(empleados, "La superficie no puede ser mayor a 99 m\u00B2");
					e.consume();
				}
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
		superficieHabitacionEmpleados.setColumns(10);
		superficieHabitacionEmpleados.setBounds(146, 133, 116, 22);
		anadirHabitaciones.add(superficieHabitacionEmpleados);

		JLabel label_8 = new JLabel("Precio habitaciones:");
		label_8.setBounds(336, 14, 116, 16);
		anadirHabitaciones.add(label_8);

		precioHabitacionesEmpleados = new JTextField();
		precioHabitacionesEmpleados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == e.VK_BACK_SPACE)) {
					e.consume();
				} else if ((e.getKeyChar() == e.VK_SPACE)) {
					e.consume();
				} else if (e.getKeyChar() == '-' || e.getKeyChar() == '_') {
					e.consume();
				}
			}
		});
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
														"Habitaci�n insertada con �xito");
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
														"La habitaci�n no ha podido ser insertada");
											}
										} else {
											JOptionPane.showMessageDialog(empleados, "El DNI introducido no es v�lido");
											dniHabitacionEmpleados.setBackground(new Color(240, 128, 128));
										}
									} else {
										JOptionPane.showMessageDialog(empleados,
												"El precio de la habitaci�n debe ser superior a 0");
										precioHabitacionesEmpleados.setBackground(new Color(240, 128, 128));
									}
								} else {
									JOptionPane.showMessageDialog(empleados,
											"La superficie debe ser inferior o igual a 20 caract�res");
									superficieHabitacionEmpleados.setBackground(new Color(240, 128, 128));
								}
							} else {
								JOptionPane.showMessageDialog(empleados, "El numero de camas debe ser superior a 0");
								numCamasEmpleados.setBackground(new Color(240, 128, 128));
							}
						} else {
							JOptionPane.showMessageDialog(empleados, "El numero de ba�os debe ser superior a 0");
							numBanosEmpleados.setBackground(new Color(248, 128, 128));
						}
					} else {
						JOptionPane.showMessageDialog(empleados, "El numero de la habitaci�n debe ser superior a 0");
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
				mostrarReservas.setVisible(false);
			}
		});
		btnAnadirHabitaciones.setBounds(10, 36, 214, 23);
		empleados.add(btnAnadirHabitaciones);

		JButton btnEliminarHabitaciones = new JButton("Eliminar habitaciones");
		btnEliminarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(true);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
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
				mostrarReservas.setVisible(false);
			}
		});
		btnModificarDatosPersonales.setBounds(10, 512, 214, 23);
		empleados.add(btnModificarDatosPersonales);

		JButton btnMostrarReservas = new JButton("Mostrar reservas");
		btnMostrarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
				mostrarReservas.setVisible(true);
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
							frmHotel.setTitle("Hotel River Camps: Gerente");
							lblTipo.setText(lblTipo.getText() + " Gerente");
						} else if (tipoEmpleado.equalsIgnoreCase("administrativo de recepci�n")) {
							frmHotel.setTitle("Hotel River Camps: Admin. de recepci�n");
							lblTipo.setText(lblTipo.getText() + " Admin. de recepci�n");
							btnAnadirActividades.setEnabled(false);
							btnBorrarActividades.setEnabled(false);
							btnModificarActividades.setEnabled(false);
							btnMostrarActividades.setEnabled(false);
							btnAnadirEmpleado.setEnabled(false);
							btnBorrarEmpleado.setEnabled(false);
							btnMostrarEmpleados.setEnabled(false);
							btnMostrarMovimientos.setEnabled(false);
						} else if (tipoEmpleado.equalsIgnoreCase("conserje")) {
							frmHotel.setTitle("Hotel River Camps: Conserje");
							lblTipo.setText(lblTipo.getText() + " Conserje");
							btnAnadirHabitaciones.setEnabled(false);
							btnEliminarHabitaciones.setEnabled(false);
							btnMostrarHabitaciones.setEnabled(false);
							btnModificarHabitaciones.setEnabled(false);
							btnAnadirEmpleado.setEnabled(false);
							btnBorrarEmpleado.setEnabled(false);
							btnMostrarEmpleados.setEnabled(false);
							btnMostrarMovimientos.setEnabled(false);
							btnMostrarReservas.setEnabled(false);
							btnMostrarClientes.setEnabled(false);
						} else if (tipoEmpleado.equalsIgnoreCase("recepcionista")) {
							frmHotel.setTitle("Hotel River Camps: Recepcionista");
							lblTipo.setText(lblTipo.getText() + " Recepcionista");
							btnAnadirHabitaciones.setEnabled(false);
							btnEliminarHabitaciones.setEnabled(false);
							btnModificarHabitaciones.setEnabled(false);
							btnAnadirEmpleado.setEnabled(false);
							btnBorrarEmpleado.setEnabled(false);
							btnMostrarEmpleados.setEnabled(false);
							btnMostrarMovimientos.setEnabled(false);
							btnAnadirActividades.setEnabled(false);
							btnBorrarActividades.setEnabled(false);
							btnModificarActividades.setEnabled(false);
						}
					} else {
						idClientePersona = gesBBDD.inicioSesionCliente(emailString, contrasena);
						if (idClientePersona > 0) {
							inicio.setVisible(false);
							// clientes.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(frmHotel, "Usuario y/o contrase�a incorrectos");
						}
					}
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(inicio, "Fallo en la conexi�n con la base de datos");
				}
			}
		});

		JButton btnCerrarSesionEmpleados = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesionEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAnadirHabitaciones.setEnabled(true);
				btnEliminarHabitaciones.setEnabled(true);
				btnMostrarHabitaciones.setEnabled(true);
				btnAnadirActividades.setEnabled(true);
				btnBorrarActividades.setEnabled(true);
				btnModificarActividades.setEnabled(true);
				btnMostrarActividades.setEnabled(true);
				btnModificarHabitaciones.setEnabled(true);
				btnAnadirEmpleado.setEnabled(true);
				btnBorrarEmpleado.setEnabled(true);
				btnMostrarEmpleados.setEnabled(true);
				btnMostrarMovimientos.setEnabled(true);
				btnMostrarReservas.setEnabled(true);
				btnMostrarClientes.setEnabled(true);
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				modelo.vaciarTabla();
				empleados.setVisible(false);
				lblBienvenido.setText("Bienvenido");
				lblTipo.setText("Tipo:");
				frmHotel.setTitle("Hotel River Camps");
				email.setText(null);
				passwd.setText(null);
				JOptionPane.showMessageDialog(frmHotel, "Has cerrado sesi�n correctamente");
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
