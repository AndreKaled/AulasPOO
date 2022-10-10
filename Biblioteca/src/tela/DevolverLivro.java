package tela;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DevolverLivro extends EmprestarLivro{
	
	public DevolverLivro() {
		reconfiguraTabela();
	}
	
	public void reconfiguraTabela() {
		
		configuraTabela();
	}
	
	//precisa refazer a coluna de ação ;-;
	@Override
	public void configuraTabela(){
		panelTabela = new JPanel();
		panelTabela.setLayout(null);
		
		//instanciacao de componentes do painel
		tableModel = new DefaultTableModel(conteudo,colunas);
		tabela = new JTable(tableModel);
		scroll = new JScrollPane(tabela);
		
		//posicionando componentes
		panelTabela.setBounds(DISTANCIA_ESQUERDA,DISTANCIA_ALTURA+480,1000,300);
		scroll.setBounds(10,10,980,280);
		
		//adicionando componentes
		panelTabela.add(scroll);
		add(panelTabela);
		
		//mudando fundo do painel
		panelTabela.setBackground(FUNDOPRETO);
	}
}