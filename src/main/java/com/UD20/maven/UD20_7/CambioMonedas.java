package com.UD20.maven.UD20_7;

public class CambioMonedas {
	
	//método que realiza cambio de monedas,
	public static double cambiarMonedas(int cantidad, String moneda) {
		
		if (moneda.equalsIgnoreCase("Euros a ptas")) {
			return cantidad * 166.386;
		}
		else {
			return (double) Math.round(cantidad / 166.386 * 100) / 100;
		}
		
	}

}
