package Interfaces;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Views {

	//iniciando um painel JPanel
	public static JPanel iniciaPanel(){
		return new JPanel();
	}
	
	public static JPanel iniciaPanel(Color corFundo){
		JPanel painel = new JPanel();
		painel.setBackground(corFundo);
		return painel;
	}
	
	public static JPanel iniciaPanel(Color corFundo, JLabel label){
		JPanel painel = new JPanel();
		painel.setBackground(corFundo);
		painel.add(label);
		return painel;
	}
	
	public static JPanel iniciaPanel(JLabel label){
		JPanel painel = new JPanel();
		painel.add(label);
		return painel;
	}
	
	//iniciando label
	
}
