package Interfaces;

/**
 * Autor: André Kaled Duarte
 * Data: 16/10/2022
 * 
 * Interface usual que facilite a codificação de Interfaces Graficas
 * com textField
 * */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public interface InterfaceTextField extends Components{
	/*---------------------------------------------------------------------------*/
	/*--------------------------- Caixas de texto -------------------------------*/
	/*---------------------------------------------------------------------------*/
	default JTextField novaCaixaTxt(int tamanhoFonte) {
		JTextField textField = new JTextField();
		textField.setFont(fonte(tamanhoFonte));
		return textField;
	}

	default JTextField novaCaixaTxt(Font fonte) {
		JTextField textField = new JTextField();
		textField.setFont(fonte);
		return textField;
	}

	default JTextField novaCaixaTxt(Color corFundo) {
		JTextField textField = new JTextField();
		textField.setBackground(corFundo);
		return textField;
	}

	default JTextField novaCaixaTxt(Color corFundo, Color corFrente) {
		JTextField textField = new JTextField();
		textField.setBackground(corFundo);
		textField.setForeground(corFrente);
		return textField;
	}

	default JTextField novaCaixaTxt(Font fonte, Color corFundo) {
		JTextField textField = new JTextField();
		textField.setFont(fonte);
		textField.setBackground(corFundo);
		return textField;
	}

	default JTextField novaCaixaTxt(int tamanhoFonte, Color corFundo) {
		JTextField textField = new JTextField();
		textField.setFont(fonte(tamanhoFonte));
		textField.setBackground(corFundo);
		return textField;
	}

	default JTextField novaCaixaTxt(int tamanhoFonte, Color corFundo,
			Color corFrente) {
		JTextField textField = new JTextField();
		textField.setFont(fonte(tamanhoFonte));
		textField.setBackground(corFundo);
		textField.setForeground(corFrente);
		return textField;
	}

	default void fundoTransparente(JTextField textField) {
		textField.setOpaque(false);
	}

	default void fundoPerso(JTextField textField) {
		fundoTransparente(textField);
		textField.setBorder(null);
	}
}
