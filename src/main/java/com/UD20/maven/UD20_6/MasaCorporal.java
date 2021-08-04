package com.UD20.maven.UD20_6;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MasaCorporal {
	
	//método que cálcula el índice corporal a partir del peso y altura,
	public static double calcularIndice(double altura, int peso, Component parentComponent) {
		
		if (altura > 0) {
			return (double) Math.round( peso / (Math.pow(altura, 2) ) * 100) / 100; 
		}
		else {
			JOptionPane.showMessageDialog(parentComponent, "Altura no puede ser zero");
			return 0;
		}		
	}

}
