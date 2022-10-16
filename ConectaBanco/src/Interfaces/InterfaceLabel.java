package Interfaces;

/**
 * Autor: André Kaled Duarte
 * Data: 16/10/2022
 * 
 * Interface usual que facilite a codificação de Interfaces Graficas
 * com labels
 * */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public interface InterfaceLabel extends Components{
	/*---------------------------------------------------------------------------*/
	/*----------------------------- Label/Texto ---------------------------------*/
	/*---------------------------------------------------------------------------*/
	default JLabel novoLabel(String conteudo) {
		JLabel label = new JLabel("<html>" + conteudo + "<html>");
		label.setFont(fonte());
		return label;
	}

	default JLabel novoLabel(String conteudo, Font fonte) {
		JLabel label = new JLabel("<html>" + conteudo + "<html>");
		label.setFont(fonte);
		return label;
	}

	default JLabel novoLabel(String conteudo, Color corTexto) {
		JLabel label = new JLabel("<html>" + conteudo + "<html>");
		label.setForeground(corTexto);
		return label;
	}

	default JLabel novoLabel(String conteudo, Font fonte, Color corTexto) {
		JLabel label = new JLabel("<html>" + conteudo + "<html>");
		label.setForeground(corTexto);
		label.setFont(fonte);
		return label;
	}

	default JLabel novoLabel(String conteudo, int fonte, Color corTexto) {
		JLabel label = new JLabel("<html>" + conteudo + "<html>");
		label.setForeground(corTexto);
		label.setFont(fonte(fonte));
		return label;
	}
}
