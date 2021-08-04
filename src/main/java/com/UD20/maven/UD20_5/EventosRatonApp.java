package com.UD20.maven.UD20_5;

import java.awt.EventQueue;

public class EventosRatonApp 
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventosRatonGUI frame = new EventosRatonGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
