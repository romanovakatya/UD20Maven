package com.UD20.maven.UD20_1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ControlBasicoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTest;

	/**
	 * Create the frame.
	 */
	public ControlBasicoGUI() {
		setTitle("Control Básico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		lblTest = new JLabel("Control Básico");
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTest);
		
		JSpinner spinner = new JSpinner();
		
		spinner.addChangeListener(new ChangeListener() {
			
			//para guardar valor anterior del spinner,
			int spinnerValueAnterior;
									
			public void stateChanged(ChangeEvent e) {
				
				int spinnerValue;
				
				//cojo el valor que tiene spinner,
				spinnerValue = Integer.parseInt(spinner.getValue().toString());
					
				//compruebo el valor nuevo del spinner con el anterior,
				//y si es menor que el anterior el tamaño de label se hace más pequeño,
					if (spinnerValueAnterior > spinnerValue) {
						lblTest.setFont(new Font("Tahoma", Font.BOLD, lblTest.getFont().getSize() - 1));
					}
				//y si es mayor el tamaño de label se hace más grande,
					else {
						lblTest.setFont(new Font("Tahoma", Font.BOLD, lblTest.getFont().getSize() + 1));
					}
				
				spinnerValueAnterior = spinnerValue;
			}			
		});
		
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		contentPane.add(spinner);
	}

}
