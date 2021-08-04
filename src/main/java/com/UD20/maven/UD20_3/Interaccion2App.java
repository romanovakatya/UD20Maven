package com.UD20.maven.UD20_3;

import java.awt.EventQueue;

public class Interaccion2App 
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interaccion2GUI frame = new Interaccion2GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
