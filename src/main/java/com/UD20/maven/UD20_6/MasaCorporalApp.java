package com.UD20.maven.UD20_6;

import java.awt.EventQueue;

public class MasaCorporalApp 
{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasaCorporalGUI frame = new MasaCorporalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
