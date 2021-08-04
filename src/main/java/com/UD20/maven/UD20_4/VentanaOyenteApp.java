package com.UD20.maven.UD20_4;

import java.awt.EventQueue;

public class VentanaOyenteApp 
{
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOyenteGUI frame = new VentanaOyenteGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
