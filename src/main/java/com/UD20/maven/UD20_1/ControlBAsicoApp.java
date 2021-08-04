package com.UD20.maven.UD20_1;

import java.awt.EventQueue;

public class ControlBAsicoApp 
{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlBasicoGUI frame = new ControlBasicoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
