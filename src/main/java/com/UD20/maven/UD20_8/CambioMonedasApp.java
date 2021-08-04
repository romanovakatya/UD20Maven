package com.UD20.maven.UD20_8;

import java.awt.EventQueue;

public class CambioMonedasApp 
{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioMonedasGUI frame = new CambioMonedasGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
