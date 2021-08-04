package com.UD20.maven.UD20_5;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventosRatonGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String eventosRaton = "";
	JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public EventosRatonGUI() {
		setTitle("Todos los eventos del ratón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnLimpiar = new JButton("Limpiar");

		//evento que limpia el textarea,
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eventosRaton = "";
				textArea.setText(eventosRaton);
			}
		});

		panel.add(btnLimpiar);

		textArea = new JTextArea();
		
		//eventos de ratón,
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				eventosRaton += e.paramString() + "\n";

				textArea.setText(eventosRaton);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				eventosRaton += e.paramString() + "\n";

				textArea.setText(eventosRaton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				eventosRaton += e.paramString() + "\n";

				textArea.setText(eventosRaton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				eventosRaton += e.paramString() + "\n";

				textArea.setText(eventosRaton);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				eventosRaton += e.paramString() + "\n";

				textArea.setText(eventosRaton);
			}
		});
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}
