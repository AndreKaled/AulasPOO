package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface InterfaceGeral {

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
	
	default void panelNaoOpaco(JPanel painel){
		painel.setOpaque(false);
	}
	
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

	// metodos de configuracoes de botoes
	/*---------------------------------------------------------------------------*/
	/*-------------------------------- Botoes -----------------------------------*/
	/*---------------------------------------------------------------------------*/
	default JButton novoBotao(String nome) {
		JButton botao = new JButton(nome);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		return botao;
	}

	default JButton novoBotao(String nome, Font fonte) {
		JButton botao = new JButton(nome);
		botao.setFont(fonte);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, Color corFrente) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setForeground(corFrente);
		return botao;
	}

	default JButton novoBotao(String nome, int largura, int altura) {
		JButton botao = new JButton(nome);
		botao.setBounds(0, 0, largura, altura);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, int largura,
			int altura) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setBounds(0, 0, largura, altura);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, Font fonte) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setFont(fonte);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, Color corFrente,
			Font fonte) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setForeground(corFrente);
		botao.setFont(fonte);
		return botao;
	}

	default void removeFoco(JButton botao) {
		botao.setFocusable(false);
	}

	default void removeFocoEBorda(JButton botao) {
		removeFoco(botao);
		botao.setBorder(null);
	}

	default void removeFundo(JButton botao) {
		removeFocoEBorda(botao);
		botao.setContentAreaFilled(false);
	}

	/*---------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------*/

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
