package com.UD20.maven.UD20_6;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasaCorporalGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	private JTextField textField_IMC;

	/**
	 * Create the frame.
	 */
	public MasaCorporalGUI() {
		setTitle("Índice de Masa Corporal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblAltura = new JLabel("Altura (metros)");
		panel.add(lblAltura);

		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		panel.add(textFieldAltura);

		JLabel lblPeso = new JLabel("Peso (kg)");
		panel.add(lblPeso);

		textFieldPeso = new JTextField();
		panel.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		JButton btnCalcular = new JButton("Calcular IMC");

		panel_1.add(btnCalcular);

		JLabel lblIMC = new JLabel("IMC");
		panel_1.add(lblIMC);

		textField_IMC = new JTextField();
		textField_IMC.setEditable(false);
		panel_1.add(textField_IMC);
		textField_IMC.setColumns(10);

		// listener que escucha cuando se pulsa el botón Calcular,
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double altura = 1;
				int peso = 0;

				// comprobamos que altura es un número y no es ni null, ni String,
				try {
					altura = Double.parseDouble(textFieldAltura.getText());

					// comprobamos que peso no es ni null, ni String,
					try {
						peso = Integer.parseInt(textFieldPeso.getText());

						// calculamos el índice y lo mostramos en un textField,
						textField_IMC.setText(MasaCorporal.calcularIndice(altura, peso, contentPane) + "");

					} catch (NumberFormatException ex2) {
						JOptionPane.showMessageDialog(contentPane, "Peso tiene que ser un número entero");
						textFieldPeso.setText("");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "Altura tiene que ser un número");
					textFieldAltura.setText("");
				}
			}
		});
	}
}
