package tela;

import Interfaces.Constants;

public class CadastraAutor extends Cadastro implements Constants{

	public CadastraAutor(){
		setLayout(null);
		setSize(ALTURA,LARGURA);
		
		
		
		
		
		
		configuraPaineis();
		
		setVisible(true);
	}

	private void configuraPaineis() {

		//alterando cor de fundo
		fundo.setBackground(AZUL);
		painel.setBackground(FUNDOPRETO);
		
		//posicionando
		painel.setBounds(DISTANCIA_ESQUERDA,DISTANCIA_ALTURA, 1000, 800);
		adicionaComp();
		cancelar();
	}

	@Override
	void confirmar() {
		
	}

	@Override
	void limpar() {
		
	}
}
