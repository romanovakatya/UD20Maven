package com.UD20.maven.UD20_4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class VentanaOyenteGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private String eventos = "";

	/**
	 * Create the frame.
	 */
	public VentanaOyenteGUI() {
		setTitle("Ventana oyente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		//evento de toda la ventana,
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {

				eventos += "Cambio del tamaño de ventana \n";

				textArea.setText(eventos);
			}
		});

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 0));

		//evento para label,
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				eventos += "Mouse Dragged \n";

				textArea.setText(eventos);
			}
		});
	
		contentPane.add(lblEventos, BorderLayout.WEST);

		textArea = new JTextArea();
		
		//eventos para textarea,
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {

				eventos += "Ratón ha salido de textarea \n";

				textArea.setText(eventos);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				eventos += "Ratón está en textarea \n";

				textArea.setText(eventos);
			}
		});

		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				eventos += "Textarea está en focus\n";

				textArea.setText(eventos);
			}

		});
		textArea.setWrapStyleWord(true);
		textArea.setRows(3);
		textArea.setTabSize(4);
		contentPane.add(textArea, BorderLayout.CENTER);
	}
}
