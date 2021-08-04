package com.UD20.maven.UD20_3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interaccion2GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int contador1 = 0;
	private int contador2 = 0;
	JLabel lblBoton1;
	JLabel lblBoton2;

	/**
	 * Create the frame.
	 */
	public Interaccion2GUI() {
		setTitle("Ventana con más interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 0));

		lblBoton1 = new JLabel("Boton 1: ");
		lblBoton1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBoton1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblBoton1);

		lblBoton2 = new JLabel("Boton 2:");
		lblBoton2.setHorizontalAlignment(SwingConstants.LEFT);
		lblBoton2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblBoton2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);

		JButton btnBoton1 = new JButton("Boton 1");
		// escuchamos cuando usuario clickea el botón 1,
		// contamos cuantos veces y mostramos,
		btnBoton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contador1++;
				lblBoton1.setText("Boton 1: " + contador1 + " veces");
			}
		});
		panel_1.add(btnBoton1);

		JButton btnBoton2 = new JButton("Boton 2");

		// escuchamos cuando usuario clickea el botón 2,
		// contamos cuantos veces y mostramos,
		btnBoton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				contador2++;
				lblBoton2.setText("Boton 2: " + contador2 + " veces");
			}
		});
		panel_1.add(btnBoton2);
	}
}
