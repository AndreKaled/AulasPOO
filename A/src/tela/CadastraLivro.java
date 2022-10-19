package tela;

import java.awt.Color;

import javax.swing.*;

import Interfaces.Constants;

public class CadastraLivro extends JFrame implements Constants{
	JPanel c, panelTitulo,panelCadastro;
	JTextField txtNome;
	JLabel lbNome, lbAutor;
	private JPanel panelNome, panelAutor, panelEditora,panelAreaAdvocacia;
	
	public CadastraLivro(){
		setSize(600, 250);
		c = (JPanel) getContentPane();
		c.setBackground(AZUL);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		confFormulario();
		setVisible(true);
		
		
	}
		public void confFormulario(){
			txtNome = new JTextField();
			panelNome = new JPanel();
			panelAutor = new JPanel();
			panelEditora = new JPanel();
			panelAreaAdvocacia = new JPanel();
			
			txtNome.setBounds(100, 30, 400, 30);
			panelNome.setBackground(CINZA_WHITE);
			panelNome.setBounds(50,30,50,30);
			
			lbNome = iniciaLabel("Nome",panelNome);
			lbAutor = iniciaLabel("Autor",50,70,panelAutor);
			
			add(panelAutor);
			add(panelNome);
			add(txtNome);
		}
		
		public JLabel iniciaLabel(String nome){
			JLabel label = new JLabel(nome);
			label.setBackground(PRETO);
			label.setFont(Constants.fonte(15));
			return label;
		}
		
		
		public JLabel iniciaLabel(String nome, JPanel painelDeAdicao){
			JLabel label = new JLabel(nome);
			painelDeAdicao.add(label);
			label.setBackground(PRETO);
			label.setFont(Constants.fonte(15));
			return label;
		}
		
		
		public JLabel iniciaLabel(String nome, int posicaoX,int posicaoY){
			JLabel label = new JLabel(nome);
			label.setBounds(posicaoX,posicaoY,50,30);
			label.setBackground(PRETO);
			label.setFont(Constants.fonte(15));
			return label;
		}
		
		public JLabel iniciaLabel(String nome, int posicaoXPanel, int posicaoYPanel,JPanel painelDeAdicao){
			JLabel label = new JLabel(nome);
			painelDeAdicao.setBounds(posicaoXPanel,posicaoYPanel,50,30);
			label.setBackground(PRETO);
			label.setFont(Constants.fonte(15));
			painelDeAdicao.add(label);
			return label;
		}
		
		public static void main(String[] args) {
			new CadastraLivro();
		}
}
