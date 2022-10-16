package Interfaces;
/**
 * Autor: André Kaled Duarte
 * Data: 16/10/2022
 * 
 * Interface usual que facilite a codificação de Interfaces Graficas
 * com paineis
 * */

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface InterfacePanel extends Components{
	
	/*---------------------------------------------------------------------------*/
	/*---------------------------- Panel/Painel ---------------------------------*/
	/*---------------------------------------------------------------------------*/
	default JPanel novoPanel(Color cor) {
		JPanel painel = new JPanel();
		painel.setBackground(cor);
		return painel;
	}

	default JPanel novoPanel(JButton botao) {
		JPanel painel = new JPanel();
		painel.add(botao);
		return painel;
	}

	default JPanel novoPanel(JLabel textinho) {
		JPanel painel = new JPanel();
		painel.add(textinho);
		return painel;
	}

	default JPanel novoPanel(JTextField textField) {
		JPanel painel = new JPanel();
		painel.add(textField);
		return painel;
	}

	default void panelNaoOpaco(JPanel painel) {
		painel.setOpaque(false);
	}
	
}
