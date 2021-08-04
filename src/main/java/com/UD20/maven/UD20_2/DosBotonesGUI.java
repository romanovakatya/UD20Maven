package com.UD20.maven.UD20_2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DosBotonesGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DosBotonesGUI() {
		setTitle("Ventana con interacción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblLastAction = new JLabel();
		contentPane.add(lblLastAction);

		JButton btnButton1 = new JButton("Boton 1");
		//escuchamos si usuario ha oulsado botón 1 y lo mostramos en label,
		btnButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblLastAction.setText("Has pulsado: " + btnButton1.getText());
			}
		});

		contentPane.add(btnButton1);

		JButton btnButton2 = new JButton("Boton 2");
		//escuchamos si usuario ha oulsado botón 2 y lo mostramos en label,
		btnButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblLastAction.setText("Has pulsado: " + btnButton2.getText());
			}
		});
		contentPane.add(btnButton2);
	}

}
