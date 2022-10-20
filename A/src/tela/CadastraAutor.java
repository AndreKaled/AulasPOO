package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Interfaces.Constants;
import Interfaces.InterfaceGeral;

public class CadastraAutor extends Cadastro implements Constants,InterfaceGeral{

	JLabel nomeAutor;
	public CadastraAutor(){
		setLayout(null);
		setSize(600,250);
		
		configuraPaineis();
		configuraComponentes();
		eventos();
		
		setVisible(true);
	}

	private void eventos() {
		limpar();
		
	}

	private void configuraComponentes(){
		nomeAutor = new JLabel("Nome do autor...");
		
		titulo.setBounds(200,10,200,25);
		nomeAutor.setBounds(30,50,200,25);
		txt.setBounds(30,75,500,25);
		btConfirma.setBounds(30,130,150,30);
		btCancela.setBounds(200,130,150,30);
		btLimpa.setBounds(370,130,150,30);
		
		titulo.setText(titulo.getText() +" AUTORES");
		
		titulo.setFont(fonte);
		nomeAutor.setFont(fonte);
		txt.setFont(fonte);
		
		//btConfirma.setBorder(new RoundedBorder(100));
		
		titulo.setForeground(CINZA_WHITE);
		nomeAutor.setForeground(CINZA_WHITE);
		btConfirma.setForeground(PRETO);
		btConfirma.setBackground(Color.GREEN);
		btCancela.setForeground(PRETO);
		btCancela.setBackground(Color.RED);
		btLimpa.setForeground(PRETO);
		btLimpa.setBackground(Color.RED);
		
		painel.add(nomeAutor);
	}
	
	private void configuraPaineis() {

		//alterando cor de fundo
		fundo.setBackground(AZUL);
		painel.setBackground(FUNDOPRETO);
		painel.setLayout(null);
		
		//posicionando
		painel.setBounds(DISTANCIA_ESQUERDA,DISTANCIA_ALTURA, 570, 200);
		adicionaComp();
		cancelar();
	}

	@Override
	void confirmar() {
		
	}

	@Override
	void limpar() {
		btLimpa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txt.setText(null);
				
			}
			
		});
	}
}
