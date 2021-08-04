package com.UD20.maven.UD20_8;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambioMonedasGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldRes;

	/**
	 * Create the frame.
	 */
	public CambioMonedasGUI() {
		setTitle("Calculadora cambio de monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCantidad = new JLabel("Cantidad a convertir");
		lblCantidad.setForeground(new Color(0, 0, 0));
		panel.add(lblCantidad);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		panel.add(lblResultado);
		
		textFieldRes = new JTextField();
		textFieldRes.setEditable(false);
		panel.add(textFieldRes);
		textFieldRes.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnMonedas = new JButton("Euros a ptas");
		
		//cuando usuario pulsa el botón monedas se hace el cambio,
		//y se muestra el resultado,
		btnMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = 0;								
				double resultado;
				
				//controlamos que la cantidad era un número entero,
				try {
					cantidad = Integer.parseInt( textField.getText());
					
					resultado = CambioMonedas.cambiarMonedas(cantidad, btnMonedas.getText());
				
					textFieldRes.setText(resultado + "");
				} 
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane, "La cantidad tiene que ser un número entero");
					textField.setText("");
				}								
			}
		});
		panel_1.add(btnMonedas);
		
		JButton btnCambiar = new JButton("Cambiar");
		
		//listener para cambiar monedas de euros a pesetas y viceversa,
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnMonedas.getText().equalsIgnoreCase("Euros a ptas")) {
					btnMonedas.setText("Ptas a Euros");
				}
				else {
					btnMonedas.setText("Euros a ptas");
				}
			}
		});
		panel_1.add(btnCambiar);
		
		JButton btnBorrar = new JButton("Borrar");
		//escuchamos cuando usuario pulsa el botón Borrar para vaciar los inputs,
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldRes.setText("");
				textField.setText("");			
			}
		});
		panel_1.add(btnBorrar);
	}

}
