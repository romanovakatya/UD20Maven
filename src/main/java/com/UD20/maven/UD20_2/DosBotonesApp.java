package com.UD20.maven.UD20_2;

import java.awt.EventQueue;

public class DosBotonesApp 
{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DosBotonesGUI frame = new DosBotonesGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
