package com.UD20.maven.UD20_9;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class JuegoButtons extends JToggleButton {

	// atributos,
	private static final long serialVersionUID = 1L;
	private JToggleButton[] arrayButtons = new JToggleButton[16];
	private Color[] arrayColoresDisponibles = { Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange,
			Color.pink, Color.red, Color.YELLOW };
	private Color[] arrayColoresDuplicated = new Color[arrayColoresDisponibles.length * 2];


	
	// constructor,
	public JuegoButtons(JPanel panel) {

		// inicializamos el array de botónes,
		for (int i = 0; i < 16; i++) {
			JToggleButton tglbtnNewToggleButton = new JToggleButton("?", true);
			panel.add(tglbtnNewToggleButton);

			this.arrayButtons[i] = tglbtnNewToggleButton;
		}

		// inicializamos el array de colores mezclados,
		this.llenarArrayColores();
		this.colorShuffle(this.arrayColoresDuplicated);
	}

	// para abrir un botón y mostrar que color tiene su reverse,
	protected void showColorOfButton() {
		


		for (int i = 0; i < this.arrayButtons.length; i++) {
			
			final int innerI = i;
			
			
			this.arrayButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int contador = 0;
					//System.out.println(arrayButtons[innerI].isSelected());
					
					if (arrayButtons[innerI].isSelected()) {
						arrayButtons[innerI].setText("?");
						contador++;
						
System.out.println("contador: " + contador);
					}else {
						//mostramos el color,
						arrayButtons[innerI].setBackground(arrayColoresDuplicated[innerI]);
						arrayButtons[innerI].setText("");
					}
					
					
				}
				
				
			});
			
			
		}
	}

	// para rellenar el array de colores duplicados,
	protected void llenarArrayColores() {

		System.arraycopy(this.arrayColoresDisponibles, 0, this.arrayColoresDuplicated, 0,
				this.arrayColoresDisponibles.length);
		System.arraycopy(this.arrayColoresDisponibles, 0, this.arrayColoresDuplicated,
				this.arrayColoresDisponibles.length, this.arrayColoresDisponibles.length);

	}

	// mostrar el contenido de array de colores duplicados,
	protected void getArrayColoresDuplicated() {
		for (int i = 0; i < this.arrayColoresDuplicated.length; i++) {
			System.out.println(this.arrayColoresDuplicated[i].toString());
		}
	}

	// para mezclar colores dentro del array,
	protected void colorShuffle(Color[] arrayColores) {

		List<Color> colores = Arrays.asList(arrayColores);
		Collections.shuffle(colores);
		// System.out.println(colores);
	}
}
