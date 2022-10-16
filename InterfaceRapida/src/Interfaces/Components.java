package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface Components {

	final String NOME_FONTE = "Arial";

	// metodo de cor personalizada
	default Color corPerso(Color corPadrao) {
		return corPadrao;
	}

	default Color corPerso(int red, int green, int blue) {
		return new Color(red, green, blue);
	}

	// metodos de configuracao de fonte
	default Font fonte() {
		Font fonte = new Font(NOME_FONTE, 0, 15);
		return fonte;
	}

	default Font fonte(int tamanho) {
		Font fonte = new Font(NOME_FONTE, 0, tamanho);
		return fonte;
	}

	default Font fonte(int tamanho, int tipoTexto) {
		Font fonte = new Font(NOME_FONTE, tipoTexto, tamanho);
		return fonte;
	}

	// metodos de configuracao de componente genericos
	default JComponent mudaComp(JComponent componente, Font fonte,
			Color corFundo, Color corFrente) {
		componente.setFont(fonte);
		componente.setBackground(corFundo);
		componente.setForeground(corFrente);
		return componente;
	}

	default JComponent mudaComp(JComponent componente, Font fonte,
			Color corFundo) {
		componente.setFont(fonte);
		componente.setBackground(corFundo);
		return componente;
	}

	default JComponent mudaComp(JComponent componente, Font fonte) {
		componente.setFont(fonte);
		return componente;
	}

	default JComponent mudaComp(JComponent componente, Color corFundo,
			Color corFrente) {
		componente.setBackground(corFundo);
		componente.setForeground(corFrente);
		return componente;
	}

	default JComponent mudaComp(JComponent componente, Color corFundo) {
		componente.setBackground(corFundo);
		return componente;
	}


	default Rectangle posicionaBt(JButton botao, int posicaoX, int posicaoY) {
		botao.setBounds(posicaoX, posicaoY, 100, 25);
		return botao.getBounds();
	}

	// posicionamento de label
	default Rectangle posicionaLb(JLabel lb, int largura, int altura) {
		lb.setBounds(largura, altura, 200, 25);
		return lb.getBounds();
	}

	// posicionamento de TextField
	default Rectangle posicionaTxt(JTextField textField, int posicaoX,
			int posicaoY) {
		textField.setBounds(posicaoX, posicaoY, 100, 25);
		return textField.getBounds();
	}

	default Rectangle tamanhoTexto(JTextField text, int largura, int altura) {
		text.setBounds(text.getX(), text.getY(), largura, altura);
		return text.getBounds();
	}
}
