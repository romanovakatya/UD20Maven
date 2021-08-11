package com.UD20.maven.UD20_9;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameButtons extends JButton {

	// atributos,
	private static final long serialVersionUID = 1L;
	private JButton[] arrayButtons = new JButton[16];
	private Color[] arrayAvailableColors = { Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange,
			Color.pink, Color.red, Color.YELLOW };
	private Color[] arrayColorsDuplicate = new Color[arrayAvailableColors.length * 2];
	private JLabel lblMensaje;
	private ArrayList<JButton> pair = new ArrayList<JButton>();
	private int counter = 0;
	private int endGame = 0;

	// constructores,
	public GameButtons(JPanel panel, JLabel lblMensaje) {

		this.lblMensaje = lblMensaje;
		// inicializamos el array de 16 toggle botónes,
		for (int i = 0; i < 16; i++) {
			JButton button = new JButton("?");
			button.setBackground(new Color(230, 230, 250));

			this.arrayButtons[i] = button;
			this.arrayButtons[i].setName(i + "");
			panel.add(this.arrayButtons[i]);
		}

		// inicializamos el array de colores duplicados,
		this.llenarArrayColores();
		// mezclamos colores entre si,
		this.colorShuffle(this.arrayColorsDuplicate);
	}

	// métodos,

	// para abrir cada botón dentro de un array de botónes,
	// y mostrar que color tiene su reverse,
	protected void showColorOfButton() {

		for (int i = 0; i < this.arrayButtons.length; i++) {

			final int innerI = i;

			this.arrayButtons[innerI].addMouseListener(addListenerToChangeColor(innerI));
		}
	}

	// listener que se ejecuta todo el juego,
	protected MouseAdapter addListenerToChangeColor(int innerI) {
		return new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				// comprobación si hay dos cartas parecidas,
				checkPair();

				// cuando hay dos cartas en el array de comparación,
				// las eliminamos para añadir otras dos,
				if (pair.size() == 2) {
					pair.remove(1);
					pair.remove(0);
				}

				// cuando carta tiene el color inicial,
				if (isSameColor(arrayButtons[innerI].getBackground(), new Color(230, 230, 250))) {

					// mostramos su color de otro lado,
					arrayButtons[innerI].setBackground(arrayColorsDuplicate[innerI]);
					arrayButtons[innerI].setText("");

					// añadimos al array para comparar colores,
					pair.add(arrayButtons[innerI]);

				} else {

					// cambiamos el color de carta al inicial si está habilitada,
					if (arrayButtons[innerI].isEnabled()) {

						// volvemos el color anterior,
						arrayButtons[innerI].setText("?");
						arrayButtons[innerI].setBackground(new Color(230, 230, 250));
					}
				}

				// para controlar fin del juego,
				// contamos cuantos cartas emparejadas quedan,
				for (int i = 0; i < arrayButtons.length; i++) {
					if (arrayButtons[i].getText() == "?") {
						endGame++;
					}
				}

				// cuando no quedan cartas emparejadas acabamos el juego,
				if (endGame == 0) {
					JOptionPane.showMessageDialog(getParent(), "Enhoranuena!!!! Ha ganado");

					lblMensaje.setText("Ha acabado el juego con " + counter + " intentos.");
				}
			}
		};
	}

	// método que comprueba si dos cartas tienen el mismo color,
	protected void checkPair() {

		this.endGame = 0;

		if (this.pair.size() == 2) {

			// si dos cartas tienen el mismo color las disabilitamos,
			if (this.pair.get(0).getBackground().getRGB() == (this.pair.get(1).getBackground().getRGB())) {

				// para hacer que se desaparecen cartas del mismo color se puede cambiando el
				// color,
				// del Background de esas cartas a blanco, por ejemplo, no lo he hecho porque me
				// gusta
				// más cuando se ven las cartas acertadas,
				this.pair.get(0).setEnabled(false);
				this.pair.get(1).setEnabled(false);

			} else {
				// si no son iguales les devolvemos el color inicial,
				this.pair.get(0).setText("?");
				this.pair.get(0).setBackground(new Color(230, 230, 250));

				this.pair.get(1).setText("?");
				this.pair.get(1).setBackground(new Color(230, 230, 250));
			}

			// contador de intentos,
			this.counter++;
			lblMensaje.setText("Intentos: " + this.counter);

		}
	}

	// método para comparar dos colores,
	protected boolean isSameColor(Color color1, Color color2) {

		return color1.equals(color2);
	}

	// para rellenar el array de colores duplicados,
	// en un array nuevo añado dos veces el array de colores,
	protected void llenarArrayColores() {

		System.arraycopy(this.arrayAvailableColors, 0, this.arrayColorsDuplicate, 0, this.arrayAvailableColors.length);
		System.arraycopy(this.arrayAvailableColors, 0, this.arrayColorsDuplicate, this.arrayAvailableColors.length,
				this.arrayAvailableColors.length);

	}

	// mostrar el contenido de array de colores duplicados,
	protected void getArrayColoresDuplicated() {
		for (int i = 0; i < this.arrayColorsDuplicate.length; i++) {
			System.out.println(this.arrayColorsDuplicate[i].toString());
		}
	}

	// para mezclar el contenido de un array de colores,
	protected void colorShuffle(Color[] arrayColores) {

		List<Color> colores = Arrays.asList(arrayColores);
		Collections.shuffle(colores);
	}
}
