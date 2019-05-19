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

import d_tablas.TableableModel;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

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

	private JTable tablaClientes;
	private JTextField modificarNombre;
	private JTextField modificarApellidos;
	private JTextField modificarTelefono;
	private JTextField modificarEmail;
	private JPasswordField modificarClave;
	private JTextField modificarInteres;
	private JTextField bajaCliente;
	private ArrayList<Actividades> listaActividadesClientes = new ArrayList<>();
	private ArrayList<Habitaciones> listaHabitacionesClientes = new ArrayList<>();
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
	private JTextField dniEmpleadoEliminarPropio;

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
		Validar val = new Validar();

		frmHotel = new JFrame();
		frmHotel.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/logos/logoJava.png")));
		frmHotel.setResizable(false);
		frmHotel.setTitle("Hotel River Camps");
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

		JSeparator separatorEmpleados = new JSeparator();
		separatorEmpleados.setOrientation(SwingConstants.VERTICAL);
		separatorEmpleados.setBounds(234, 289, 2, 290);
		empleados.add(separatorEmpleados);

		JPanel inicio = new JPanel();
		inicio.setBounds(0, 0, 842, 580);
		frmHotel.getContentPane().add(inicio);
		inicio.setLayout(null);

		JLabel label = new JLabel("Iniciar Sesi\u00F3n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(371, 171, 100, 16);
		inicio.add(label);

		JLabel label_1 = new JLabel("E-mail:");
		label_1.setBounds(290, 210, 56, 16);
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
		email.setBounds(370, 207, 196, 22);
		inicio.add(email);

		JLabel label_2 = new JLabel("Contrase\u00F1a:");
		label_2.setBounds(290, 248, 75, 16);
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
		passwd.setBounds(370, 245, 196, 22);
		inicio.add(passwd);

		JButton iniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		iniciarSesion.setBounds(290, 288, 116, 25);
		inicio.add(iniciarSesion);

		JLabel lblBienvenidoEmpleados = new JLabel("Bienvenido");
		lblBienvenidoEmpleados.setBounds(10, 5, 214, 14);
		empleados.add(lblBienvenidoEmpleados);

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
				listaReservas = gesBBDD.mostrarReservasHabitacionesEmpleados(empleados);
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
		comboBoxTipoEmpleadoModificar.addItem("Administrativo de recepcion");
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

		JRadioButton rdbtnApellidosEmpleados = new JRadioButton("Apellidos:");
		rdbtnApellidosEmpleados.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnApellidosEmpleados.isSelected()) {
					apellidosEmpleadoModificar.setEnabled(true);
				} else {
					apellidosEmpleadoModificar.setEnabled(false);
					apellidosEmpleadoModificar.setText(null);
				}
			}
		});
		rdbtnApellidosEmpleados.setBounds(10, 52, 109, 23);
		modificarDatosPersonalesEmpleados.add(rdbtnApellidosEmpleados);

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
		grupoRadioButtonsModificarEmpleado.add(rdbtnApellidosEmpleados);
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
				} else if (rdbtnApellidosEmpleados.isSelected()) {
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
					Empleados empleadoModificar = gesBBDD.buscarUnEmpleado(emailEmpleado, passwdEmpleado, empleados);
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
								} else if (rdbtnApellidosEmpleados.isSelected()) {
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
													"El e-mail no puede tener más de 50 caracteres");
										}
									} else {
										modificarValido = false;
										JOptionPane.showMessageDialog(empleados, "El e-mail introducido no es valido");
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
									} else if (rdbtnApellidosEmpleados.isSelected()) {
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
						JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
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
							modificar = gesBBDD.modificarActividadesIndividual(codigo, datoModificar, datoNuevo,
									empleados);
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
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
				} catch (Exception excepcionGenerica) {
					JOptionPane.showMessageDialog(empleados, "El dato introducido no es valido");
				}
			}
		});
		btnModificar_1.setBounds(499, 256, 89, 23);
		modificarActividades.add(btnModificar_1);

		JButton btnOcultar_5Empleados = new JButton("Ocultar");
		btnOcultar_5Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarActividades.setVisible(false);
			}
		});
		btnOcultar_5Empleados.setBounds(10, 256, 89, 23);
		modificarActividades.add(btnOcultar_5Empleados);

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

		JButton btnModificarHabitacionEmpleado = new JButton("Modificar");
		btnModificarHabitacionEmpleado.addActionListener(new ActionListener() {
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
						datoModificar = "numero de baños";
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
							modificar = gesBBDD.modificarHabitaciones(numHabitacion, datoNuevo, datoModificar,
									empleados);
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
								JOptionPane.showMessageDialog(empleados, "Habitación modificada correctamente");
								listaHabitaciones = gesBBDD.mostrarHabitaciones(empleados);
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
								JOptionPane.showMessageDialog(empleados, "No ha sido posible modificar la habitación");
							}
						}
					} else {
						JOptionPane.showMessageDialog(empleados, "El dato introducido no es válido");
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
		btnModificarHabitacionEmpleado.setBounds(499, 256, 89, 23);
		modificarHabitaciones.add(btnModificarHabitacionEmpleado);

		JButton btnOcultar_4Empleados = new JButton("Ocultar");
		btnOcultar_4Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarHabitaciones.setVisible(false);
			}
		});
		btnOcultar_4Empleados.setBounds(10, 256, 89, 23);
		modificarHabitaciones.add(btnOcultar_4Empleados);

		JPanel borrarEmpleado = new JPanel();
		borrarEmpleado.setBounds(234, 289, 609, 290);
		empleados.add(borrarEmpleado);
		borrarEmpleado.setLayout(null);
		borrarEmpleado.setVisible(false);

		JLabel lblDniDelEmpleado = new JLabel("DNI del empleado:");
		lblDniDelEmpleado.setBounds(10, 11, 117, 14);
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
		dniEmpleadoEliminar.setBounds(130, 8, 86, 20);
		borrarEmpleado.add(dniEmpleadoEliminar);
		dniEmpleadoEliminar.setColumns(10);

		dniEmpleadoEliminarPropio = new JTextField();
		dniEmpleadoEliminarPropio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (dniEmpleadoEliminarPropio.getText().length() == 9) {
					e.consume();
				}
			}
		});
		
		JLabel lblDniEmpleadoQueElimina = new JLabel("Introduce tu DNI:");
		lblDniEmpleadoQueElimina.setBounds(10, 35, 117, 14);
		borrarEmpleado.add(lblDniEmpleadoQueElimina);
		dniEmpleadoEliminarPropio.setBounds(130, 32, 86, 20);
		borrarEmpleado.add(dniEmpleadoEliminarPropio);
		dniEmpleadoEliminarPropio.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dniValido = false;
				String dni = dniEmpleadoEliminar.getText();
				dniValido = val.comprobarDNI(dni);
				if (dniValido) {
					String dniEmpleadoGerente=dniEmpleadoEliminarPropio.getText();
					dniValido = val.comprobarDNI(dniEmpleadoGerente);
					if (dniValido) {
						if (!dni.equalsIgnoreCase(dniEmpleadoGerente)) {
							dniEmpleadoEliminar.setBackground(Color.white);
							dniEmpleadoEliminarPropio.setBackground(Color.white);
							gesBBDD.eliminarEmpleados(dni, empleados);
							gesBBDD.eliminarPersonas(dni, empleados);
							dniEmpleadoEliminar.setText("");
							dniEmpleadoEliminarPropio.setText("");
						} else {
							dniEmpleadoEliminarPropio.setBackground(new Color(240, 128, 128));
							dniEmpleadoEliminar.setBackground(new Color(240, 128, 128));
							JOptionPane.showMessageDialog(empleados, "No puedes eliminarte a ti mismo");
						}
					} else {
						dniEmpleadoEliminarPropio.setBackground(new Color(240, 128, 128));
						JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
					}
				} else {
					dniEmpleadoEliminar.setBackground(new Color(240, 128, 128));
					JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
				}
			}
		});
		
		btnEliminar.setBounds(499, 256, 89, 23);
		borrarEmpleado.add(btnEliminar);

		JButton btnOcultar_3Empleados = new JButton("Ocultar");
		btnOcultar_3Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarEmpleado.setVisible(false);
			}
		});
		btnOcultar_3Empleados.setBounds(10, 256, 89, 23);
		borrarEmpleado.add(btnOcultar_3Empleados);

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

		JLabel lblEmailEmpleadoNuevo = new JLabel("E-mail:");
		lblEmailEmpleadoNuevo.setBounds(391, 11, 101, 14);
		anadirEmpleado.add(lblEmailEmpleadoNuevo);

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
		comboBoxTipoEmpleadoNuevo.addItem("Administrativo de recepción");
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
															insertar = gesBBDD.insertarPersonas(empleado, empleados);
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
														} else {
															antiguedadEmpleadoNuevo
																	.setBackground(new Color(240, 128, 128));
															JOptionPane.showMessageDialog(empleados,
																	"La antiguedad no puede ser inferior a 0");
														}
													} else {
														salarioEmpleadoNuevo.setBackground(new Color(240, 128, 128));
														JOptionPane.showMessageDialog(empleados,
																"El salario no puede ser inferior a 900€");
													}
												} else {
													passwdEmpleado.setBackground(new Color(240, 128, 128));
													JOptionPane.showMessageDialog(empleados,
															"La contraseña debe tener mínimo 6 caractéres y máximo 20");
												}
											} else {
												emailEmpleadoNuevo.setBackground(new Color(240, 128, 128));
												JOptionPane.showMessageDialog(empleados, "El correo no es válido");
											}
										} else {
											emailEmpleadoNuevo.setBackground(new Color(240, 128, 128));
											JOptionPane.showMessageDialog(empleados,
													"El e-mail no puede estar vacío y tiene una longitud máxima de 50 caractéres");
										}
									} else {
										calendarioAnadirEmpleado.setBackground(new Color(240, 128, 128));
										JOptionPane.showMessageDialog(empleados,
												"El empleado debe tener entre 16 y 67 años");
									}
								} else {
									telefono.setBackground(new Color(240, 128, 128));
									JOptionPane.showMessageDialog(empleados, "El teléfono debe tener 9 números");
								}
							} else {
								dniEmpleadoNuevo.setBackground(new Color(240, 128, 128));
								JOptionPane.showMessageDialog(empleados, "El DNI introducido no es válido");
							}
						} else {
							apellidosEmpleadoNuevo.setBackground(new Color(240, 128, 128));
							JOptionPane.showMessageDialog(empleados,
									"La longitud de los apellidos no puede superar los 40 carácteres (espacios incluidos), ni estar vacío");
						}
					} else {
						nombreEmpleadoNuevo.setBackground(new Color(240, 128, 128));
						JOptionPane.showMessageDialog(empleados,
								"La longitud del nombre no puede superar los 20 carácteres ni estar vacío");
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
		btnInsertar_1.setBounds(499, 256, 89, 23);
		anadirEmpleado.add(btnInsertar_1);

		JButton btnOcultar_2Empleados = new JButton("Ocultar");
		btnOcultar_2Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirEmpleado.setVisible(false);
			}
		});
		btnOcultar_2Empleados.setBounds(10, 256, 89, 23);
		anadirEmpleado.add(btnOcultar_2Empleados);

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

		JButton btnOcultar_1Empleados = new JButton("Ocultar");
		btnOcultar_1Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarActividades.setVisible(false);
			}
		});
		btnOcultar_1Empleados.setBounds(10, 256, 89, 23);
		borrarActividades.add(btnOcultar_1Empleados);
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
															"Actividad insertada con éxito");
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
														"El DNI introducido no es válido");
											}
										} else {
											medioTransporte.setBackground(new Color(240, 128, 128));
											JOptionPane.showMessageDialog(empleados,
													"El medio de transporte debe ser inferior o igual a 20 caractéres");
										}
									} else {
										descripcion.setBackground(new Color(240, 128, 128));
										JOptionPane.showMessageDialog(empleados,
												"La descripción debe ser inferior o igual a 300 caratéres");
									}
								} else {
									timePickerDuracion.setBackground(new Color(240, 128, 128));
									JOptionPane.showMessageDialog(empleados, "La duración debe ser superior a 00:00");
								}
							} else {
								localizacion.setBackground(new Color(240, 128, 128));
								JOptionPane.showMessageDialog(empleados,
										"La descripción debe ser superior a 0 caractéres e inferior o igual a 80");
							}
						}
					} else {
						codigoActividad.setBackground(new Color(240, 128, 128));
						JOptionPane.showMessageDialog(empleados,
								"La longitud del código debe ser superior a 0 caractéres e inferior o igual a 20");
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

		JButton btnOcultarEmpleados = new JButton("Ocultar");
		btnOcultarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadirActividades.setVisible(false);
			}
		});
		btnOcultarEmpleados.setBounds(10, 256, 89, 23);
		anadirActividades.add(btnOcultarEmpleados);

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
					JOptionPane.showMessageDialog(empleados, "Debes introducir un número");
					numHabitacionEliminar.setBackground(new Color(240, 128, 128));
				}
				if (numero) {
					numHabitacionEliminar.setBackground(Color.white);
					habitacionExiste = gesBBDD.habitacionExiste(numHabitacionInt, empleados);
					if (habitacionExiste) {
						gesBBDD.eliminarHabitaciones(numHabitacionInt, empleados);
						numHabitacionEliminar.setText(null);
						try {
							listaHabitaciones = gesBBDD.mostrarHabitaciones(empleados);
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
					JOptionPane.showMessageDialog(empleados, "El número de baños no puede ser superior a 2");
					numBanosEmpleados.setValue(2);
				} else if ((int) numBanosEmpleados.getValue() < 1) {
					JOptionPane.showMessageDialog(empleados, "El número de baños no puede ser inferior a 1");
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
					JOptionPane.showMessageDialog(empleados, "El número de camas no puede ser superior a 4");
					numCamasEmpleados.setValue(4);
				} else if ((int) numCamasEmpleados.getValue() < 1) {
					JOptionPane.showMessageDialog(empleados, "El número de camas no puede ser inferior a 1");
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
				listaHabitaciones = gesBBDD.mostrarHabitaciones(empleados);
				modelo.rellenarTabla(listaHabitaciones, true);
				listaHabitaciones.clear();
			}
		});
		btnEliminarHabitaciones.setBounds(10, 70, 214, 23);
		empleados.add(btnEliminarHabitaciones);

		JButton btnMostrarHabitacionesEmpleados = new JButton("Mostrar habitaciones");
		btnMostrarHabitacionesEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaHabitaciones = gesBBDD.mostrarHabitaciones(empleados);
				modelo.rellenarTabla(listaHabitaciones, true);
				listaHabitaciones.clear();
			}
		});
		btnMostrarHabitacionesEmpleados.setBounds(10, 138, 214, 23);
		empleados.add(btnMostrarHabitacionesEmpleados);

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
				listaActividades = gesBBDD.mostrarActividades(empleados);
				modelo.rellenarTabla(listaActividades, true);
				listaActividades.clear();
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
				listaActividades = gesBBDD.mostrarActividades(empleados);
				modelo.rellenarTabla(listaActividades, true);
				listaActividades.clear();
			}
		});
		btnModificarActividades.setBounds(10, 240, 214, 23);
		empleados.add(btnModificarActividades);

		JButton btnMostrarActividadesEmpleados = new JButton("Mostrar actividades");
		btnMostrarActividadesEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaActividades = gesBBDD.mostrarActividades(empleados);
				modelo.rellenarTabla(listaActividades, true);
				listaActividades.clear();
			}
		});
		btnMostrarActividadesEmpleados.setBounds(10, 274, 214, 23);
		empleados.add(btnMostrarActividadesEmpleados);

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
				listaHabitaciones = gesBBDD.mostrarHabitaciones(empleados);
				modelo.rellenarTabla(listaHabitaciones, true);
				listaHabitaciones.clear();
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
				listaMovimientos = gesBBDD.consultarMovimientos(empleados);
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

				listaActividadesClientes = gesBBDD.mostrarActividades(invitado);
				modelo.rellenarTabla(listaActividadesClientes, true);
				listaActividadesClientes.clear();

			}
		});
		btnMostrarActividades.setBounds(10, 36, 214, 23);
		invitado.add(btnMostrarActividades);

		JButton btnMostrarHabitaciones = new JButton("Mostrar Habitaciones");
		btnMostrarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaHabitacionesClientes = gesBBDD.mostrarHabitaciones(invitado);
				modelo.rellenarTabla(listaHabitacionesClientes, true);
				listaHabitacionesClientes.clear();
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
				int idPersonas = 0;
				int idPersonasEmail=0;

				try {

					String nombre = NombreRegistro.getText();

					if (nombre.length() > 0 && nombre.length() <= 20) {

						String apellidos = apellidosRegistro.getText();
						if (apellidos.length() > 0 && apellidos.length() <= 40) {

							String dni = dniRegisro.getText();
							validarDni = val.comprobarDNI(dni);
							if (validarDni) {
								idPersonas = gesBBDD.buscarPersonas(dni, registrarse);
								if (idPersonas == 0) {
									LocalDate fechaNacimiento = RegistroClientes.getDate();
									int edad = (int) Period.between(fechaNacimiento, LocalDate.now()).getYears();

									if (edad >= 18 && edad < 99) {

										String telefono = telefonoRegistro.getText();
										if (telefono.length() == 9) {
											int telefonoInt = Integer.parseInt(telefono);
											String email = emailRegistro.getText();

											if (email.length() > 0 && email.length() <= 50) {

												validarEmail = val.comprobarEmail(email);
												if (validarEmail) {
													idPersonasEmail=gesBBDD.buscarEmailRepetido(email, registrarse);
													if (idPersonasEmail==0) {
														String clave = claveRegistro.getText();

														if (clave.length() > 0 && clave.length() <= 20) {

															String confirClave = confirmarClave.getText();

															if (clave.equalsIgnoreCase(confirClave)) {

																String interes = interesRegistro.getText();

																if (interes.length() > 0 && interes.length() <= 40) {

																	Clientes cliente = new Clientes(nombre, apellidos, dni,
																			telefonoInt, clave, edad, email, interes);

																	boolean insertar = gesBBDD.insertarPersonas(cliente,
																			clientes);

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
														JOptionPane.showMessageDialog(registrarse, "El email introducido ya está registrado");
													}
												} else {
													JOptionPane.showMessageDialog(registrarse,
															"El email no es valido.");
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
									JOptionPane.showMessageDialog(registrarse,
											"El DNI introducido ya está registrado en la base de datos");
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
				CancelarReservaHabitacion.setVisible(false);
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

				int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente, clientes);

				if (cliente > 0) {

					Clientes clienteMostrar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente, clientes);
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

				int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente, clientes);

				if (cliente > 0) {

					Clientes clienteMostrar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente, clientes);
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

					Clientes clienteCancelacionActividad = gesBBDD.buscarUnCliente(emailCliente, passwdCliente,
							clientes);

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
				boolean emailValido = false;
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

					int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente, clientes);

					if (cliente > 0) {

						Clientes clienteModificar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente, clientes);
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
							passwd.setText(datoNuevo);
						} else if (rdbtnMoEmail.isSelected()) {
							opcion = "email";
							emailValido = val.comprobarEmail(modificarEmail.getText());
							if (emailValido) {
								datoNuevo = modificarEmail.getText();
								email.setText(datoNuevo);
							} else {
								JOptionPane.showMessageDialog(clientes, "El e-mail introducido no es válido");
							}
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

		JButton btnEnviarReservaActividades = new JButton("Enviar"); 
		btnEnviarReservaActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean enviar = false;
				boolean validado = false;
				boolean existenciaActividad = false;
				int disponibilidad = 0;

				try {

					String dni = dniReservaActividades.getText();
					validado = val.comprobarDNI(dni);

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
		dateSettingsReservarHabitacionesEntrada.setFormatForDatesCommonEra("yyyy-MM-dd");
		dateSettingsReservarHabitacionesEntrada.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
		dateSettingsReservarHabitacionesEntrada.setGapBeforeButtonPixels(0);
		DatePicker calendarioReservarHabitaciones = new DatePicker(dateSettingsReservarHabitacionesEntrada);
		dateSettingsReservarHabitacionesEntrada.setDateRangeLimits(LocalDate.now(), null);
		calendarioReservarHabitaciones.setDateToToday();
		calendarioReservarHabitaciones.setBounds(388, 79, 166, 26);
		reservarHabitaciones.add(calendarioReservarHabitaciones);

		DatePickerSettings dateSettingsReservarHabitacionesSalida = new DatePickerSettings();
		dateSettingsReservarHabitacionesSalida.setFirstDayOfWeek(DayOfWeek.MONDAY);
		dateSettingsReservarHabitacionesSalida.setFormatForDatesCommonEra("yyyy-MM-dd");
		dateSettingsReservarHabitacionesSalida.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
		dateSettingsReservarHabitacionesSalida.setGapBeforeButtonPixels(0);
		DatePicker calendarioReservarHabitacionesSalida = new DatePicker(dateSettingsReservarHabitacionesSalida);
		dateSettingsReservarHabitacionesSalida.setDateRangeLimits(LocalDate.now(), null);
		calendarioReservarHabitacionesSalida.setDateToToday();
		calendarioReservarHabitacionesSalida.setBounds(388, 134, 166, 26);
		reservarHabitaciones.add(calendarioReservarHabitacionesSalida);
		calendarioReservarHabitacionesSalida.addDateChangeListener(new DateChangeListener() {
			public void dateChanged(DateChangeEvent arg0) {
				modelo.vaciarTabla();
				LocalDate fechaEntrada=calendarioReservarHabitaciones.getDate();
				LocalDate fechaSalida=calendarioReservarHabitacionesSalida.getDate();
				listaHabitacionesClientes=gesBBDD.mostrarHabitacionesDisponibles(fechaEntrada, fechaSalida, clientes);
				modelo.rellenarTabla(listaHabitacionesClientes, true);
				listaHabitacionesClientes.clear();
			}
		});

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

		JButton btnEnviar = new JButton("Enviar");// RESERVAR HABITACIONES
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

						validado = val.comprobarDNI(dni);

						if (validado) {

							int numPersonas = (int) spinnerReservarHabitacion.getValue();

							if (numPersonas > 0) {

								LocalDate fechaentrada = calendarioReservarHabitaciones.getDate();

								LocalDate fechasalida = calendarioReservarHabitacionesSalida.getDate();

								if (fechaentrada.isBefore(fechasalida) && fechasalida.isAfter(fechaentrada)) {

									Reserva reservaHabitacion = new Reserva(fechaentrada, fechasalida, numPersonas);
									disponibilidad = gesBBDD.comprobarDisponibilidadHabitaciones(numeroHabitacion,
											reservaHabitacion, clientes);
									if (disponibilidad) {

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
					validacion = val.comprobarDNI(DNI);

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
				listaActividadesClientes = gesBBDD.mostrarActividades(clientes);
				modelo.rellenarTabla(listaActividadesClientes, true);
				listaActividadesClientes.clear();

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
				listaHabitacionesClientes = gesBBDD.mostrarHabitaciones(clientes);
				modelo.rellenarTabla(listaHabitacionesClientes, true);
				listaHabitacionesClientes.clear();
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

				int cliente = gesBBDD.inicioSesionCliente(emailCliente, passwdCliente, clientes);

				if (cliente > 0) {

					Clientes clienteMostrar = gesBBDD.buscarUnCliente(emailCliente, passwdCliente, clientes);
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

		JButton Registrarse = new JButton("Registrarse");
		Registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				registrarse.setVisible(true);
				inicio.setVisible(false);
				invitado.setVisible(false);
				clientes.setVisible(false);

			}
		});
		Registrarse.setBounds(449, 288, 116, 25);
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
		entrarComoInvitado.setBounds(290, 324, 275, 23);
		inicio.add(entrarComoInvitado);

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
						Empleados empleado = gesBBDD.buscarUnEmpleado(emailString, contrasena, inicio);
						empleados.setVisible(true);
						inicio.setVisible(false);
						tipoEmpleado = empleado.getTipo();
						nombreEmpleado = empleado.getNombre() + " " + empleado.getApellidos();
						lblBienvenidoEmpleados.setText(lblBienvenidoEmpleados.getText() + " " + nombreEmpleado);
						if (tipoEmpleado.trim().equalsIgnoreCase("gerente")) {
							frmHotel.setTitle("Hotel River Camps: Gerente");
							lblTipo.setText(lblTipo.getText() + " Gerente");
						} else if (tipoEmpleado.equalsIgnoreCase("administrativo de recepción")) {
							frmHotel.setTitle("Hotel River Camps: Admin. de recepción");
							lblTipo.setText(lblTipo.getText() + " Admin. de recepción");
							btnAnadirActividades.setEnabled(false);
							btnBorrarActividades.setEnabled(false);
							btnModificarActividades.setEnabled(false);
							btnMostrarActividadesEmpleados.setEnabled(false);
							btnAnadirEmpleado.setEnabled(false);
							btnBorrarEmpleado.setEnabled(false);
							btnMostrarEmpleados.setEnabled(false);
							btnMostrarMovimientos.setEnabled(false);
						} else if (tipoEmpleado.equalsIgnoreCase("conserje")) {
							frmHotel.setTitle("Hotel River Camps: Conserje");
							lblTipo.setText(lblTipo.getText() + " Conserje");
							btnAnadirHabitaciones.setEnabled(false);
							btnEliminarHabitaciones.setEnabled(false);
							btnMostrarHabitacionesEmpleados.setEnabled(false);
							btnModificarHabitaciones.setEnabled(false);
							btnAnadirEmpleado.setEnabled(false);
							btnBorrarEmpleado.setEnabled(false);
							btnMostrarEmpleados.setEnabled(false);
							btnMostrarMovimientos.setEnabled(false);
							btnMostrarReservasHabitaciones.setEnabled(false);
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
						idClientePersona = gesBBDD.inicioSesionCliente(emailString, contrasena, inicio);
						if (idClientePersona > 0) {
							inicio.setVisible(false);
							clientes.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(frmHotel, "Usuario y/o contraseña incorrectos");
						}
					}
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(inicio,
							"Fallo en la conexión con la base de datos.\nComprueba que el servidor está encendido");
				}

			}
		});

		JButton btnCerrarSesionEmpleados = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesionEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAnadirHabitaciones.setEnabled(true);
				btnEliminarHabitaciones.setEnabled(true);
				btnMostrarHabitacionesEmpleados.setEnabled(true);
				btnAnadirActividades.setEnabled(true);
				btnBorrarActividades.setEnabled(true);
				btnModificarActividades.setEnabled(true);
				btnMostrarActividadesEmpleados.setEnabled(true);
				btnModificarHabitaciones.setEnabled(true);
				btnAnadirEmpleado.setEnabled(true);
				btnBorrarEmpleado.setEnabled(true);
				btnMostrarEmpleados.setEnabled(true);
				btnMostrarMovimientos.setEnabled(true);
				btnMostrarReservas.setEnabled(true);
				btnMostrarReservasHabitaciones.setEnabled(true);
				btnMostrarClientes.setEnabled(true);
				anadirHabitaciones.setVisible(false);
				eliminarHabitaciones.setVisible(false);
				anadirActividades.setVisible(false);
				borrarActividades.setVisible(false);
				anadirEmpleado.setVisible(false);
				borrarEmpleado.setVisible(false);
				modificarHabitaciones.setVisible(false);
				modificarActividades.setVisible(false);
				modificarDatosPersonalesEmpleados.setVisible(false);
				mostrarReservas.setVisible(false);
				modelo.vaciarTabla();
				empleados.setVisible(false);
				lblBienvenidoEmpleados.setText("Bienvenido");
				lblTipo.setText("Tipo:");
				frmHotel.setTitle("Hotel River Camps");
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