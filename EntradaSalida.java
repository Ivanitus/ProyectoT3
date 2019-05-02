
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaSalida {
	protected void ejecucion() {
		// Pruebas
		Scanner sc = new Scanner(System.in);
		GestionBBDD gesBBDD = new GestionBBDD();
		String superficie;
		String tipo;
		boolean disponible;
		int numero_banos = 0;
		int camas;
		int numero_habitacion;
		final int camaIndividual = 1;
		double precio_habitaciones;
		boolean jacuzzi = true;
		boolean matrimonio = false;
		boolean terraza = false;
		String jacuzziCadena, matrimonioCadena, terrazaCadena;
		boolean tipoIncorrecto = true, tipoDatoIncorrecto = true, habitacionEncontrada = false;
		/*
		 * System.out.println("Introduce la superficie de la habitacion: "); superficie
		 * = sc.nextLine(); do {
		 * System.out.println("Introduce el tipo (individual,matrimonio,suite): "); tipo
		 * = sc.nextLine(); if (tipo.trim().equalsIgnoreCase("individual") ||
		 * tipo.trim().equalsIgnoreCase("matrimonio") ||
		 * tipo.trim().equalsIgnoreCase("suite")) { tipoIncorrecto = false; } else {
		 * System.out.
		 * println("El tipo introducido no es válido. Debe ser individual, matriomonio o suite"
		 * ); tipoIncorrecto = true; } } while (tipoIncorrecto); do { try {
		 * System.out.println("Introduce el numero de baños de la habitacion: ");
		 * numero_banos = sc.nextInt(); sc.nextLine(); tipoDatoIncorrecto = false; }
		 * catch (InputMismatchException e) {
		 * System.out.println("El dato introducido debe ser un numero entero");
		 * sc.nextLine(); tipoDatoIncorrecto = true; } } while (tipoDatoIncorrecto); if
		 * (!tipo.trim().equalsIgnoreCase("individual")) {
		 * System.out.println("Introduce el numero de camas de la habitacion: "); camas
		 * = sc.nextInt(); sc.nextLine(); } else { camas = camaIndividual; }
		 * System.out.println("Introduce el numero de la habitacion: ");
		 * numero_habitacion = sc.nextInt(); sc.nextLine();
		 * System.out.println("Introduce el precio de la habitacion: ");
		 * precio_habitaciones = sc.nextDouble(); sc.nextLine();
		 * System.out.println("¿Tiene jacuzzi? (si/no)"); jacuzziCadena = sc.nextLine();
		 * System.out.println("¿Tiene cama de matrimonio? (si/no)"); matrimonioCadena =
		 * sc.nextLine(); System.out.println("¿Tiene terraza? (si/no)"); terrazaCadena =
		 * sc.nextLine(); if (jacuzziCadena.trim().equalsIgnoreCase("si")) { jacuzzi =
		 * true; } else if (jacuzziCadena.trim().equalsIgnoreCase("no")) { jacuzzi =
		 * false; } if (matrimonioCadena.trim().equalsIgnoreCase("si")) { matrimonio =
		 * true; } else if (matrimonioCadena.trim().equalsIgnoreCase("no")) { matrimonio
		 * = false; } if (terrazaCadena.trim().equalsIgnoreCase("si")) { terraza = true;
		 * } else if (terrazaCadena.trim().equalsIgnoreCase("no")) { terraza = false; }
		 * Habitaciones habitacion = new Habitaciones(superficie, tipo, numero_banos,
		 * camas, numero_habitacion, precio_habitaciones, jacuzzi, matrimonio, terraza);
		 * gesBBDD.insertarHabitaciones(habitacion, "05994241G");
		 */
		/*
		 * System.out.
		 * println("Introduce el numero de la habitacion que deseas eliminar: ");
		 * numero_habitacion=sc.nextInt();sc.nextLine();
		 * habitacionEncontrada=gesBBDD.habitacionExiste(numero_habitacion); if
		 * (habitacionEncontrada) { gesBBDD.eliminarHabitaciones(numero_habitacion); }
		 * else {
		 * System.out.println("No se puede eliminar una habitación que no existe"); }
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		System.out.println("Introduce la fecha de entrada: (dia/mes/año)");
		String fechaEntrada = sc.nextLine();
		System.out.println("Introduce la fecha de salida: (dia/mes/año)");
		String fechaSalida = sc.nextLine();
		LocalDate fechaEntradaLocalDate = LocalDate.parse(fechaEntrada, formatter);
		LocalDate fechaSalidaLocalDate = LocalDate.parse(fechaSalida, formatter);
		Reserva reservaNueva = new Reserva(fechaEntradaLocalDate, fechaSalidaLocalDate, 650.51, 2);
		System.out.println("Introduce el numero de la habitacion: ");
		numero_habitacion = sc.nextInt();
		sc.nextLine();
		disponible = gesBBDD.comprobarDisponibilidadHabitaciones(numero_habitacion, reservaNueva);
		if (disponible) {
			gesBBDD.reservarHabitaciones(numero_habitacion, "97647185H", reservaNueva);
		} else {
			System.out.println("No es posible hacer la reserva");
		}
	}
}
