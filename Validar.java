import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {

	protected boolean comprobarDNI(String dniAComprobar) {

		char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		String num = "";
		int ind = 0;
		boolean valido = true;
		if (dniAComprobar.length() == 9 || dniAComprobar.length() == 8) {
			if (dniAComprobar.length() == 8) {
				dniAComprobar = "0" + dniAComprobar;

			}
			if (!Character.isLetter(dniAComprobar.charAt(8))) {
				valido = false;
			}
			if (dniAComprobar.length() != 9) {
				valido = false;
			}
			for (int i = 0; i < 8; i++) {
				if (!Character.isDigit(dniAComprobar.charAt(i))) {
					valido = false;
				}
				num += dniAComprobar.charAt(i);
			}
			ind = Integer.parseInt(num);
			ind %= 23;
			if ((Character.toUpperCase(dniAComprobar.charAt(8))) != letraDni[ind]) {
				valido = false;
			}
		} else {
			System.out.println("El DNI debe contener 8 numeros y 1 letra.");
			valido = false;
		}
		return valido;
	} // fin comprobarDni

	protected boolean comprobarEmail(String email) {
		boolean valido = false;
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.find()) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	} // fin comprobarEmail
}
