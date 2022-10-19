package tela;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Interfaces.Constants;

public class VisualizarEmprestimos extends JFrame implements Constants {

	Date dataHoje = new Date();
	DateFormat formataData = DateFormat.getDateInstance(DateFormat.FULL);
	JPanel titulo, panelTabela, container;
	JLabel lbTitulo, lbDadosFuncionario, lbDadosLivro;
	JLabel nomeAdvocacia, data, lbEmprestar;
	String[] colunas = { "N° EXEMPLAR", "NOME", "ADVOGADO", "EMPRÉSTIMO",
			"DEVOLUÇÃO", "ENTREGA" };
	Object[][] conteudo = {};
	JScrollPane scroll;
	TableModel tableModel;
	JTable tabela;

	public VisualizarEmprestimos() {
		setSize(ALTURA,LARGURA);
		setLayout(null);
		container = (JPanel) getContentPane();
		container.setBackground(AZUL);

		configuraTitulo();
		configuraTabela();

		setVisible(true);
	}

	public void configuraTitulo() {
		titulo = new JPanel();

		lbTitulo = new JLabel("Sistema Para Controle de Biblioteca");
		lbDadosFuncionario = new JLabel("Dados do Funcionario");
		lbDadosLivro = new JLabel("Dados dos Livros");

		titulo.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA, 1000, 200);
		titulo.setLayout(null);

		titulo.add(lbTitulo);

		lbEmprestar = new JLabel("Visualizar Empréstimos");
		nomeAdvocacia = new JLabel("Kauadré Advocacia");
		data = new JLabel("" +formataData.format(dataHoje));

		data.setBounds(770, 170, 230, 20);
		lbTitulo.setBounds(370, 100, 350, 20);
		lbEmprestar.setBounds(20, 170, 150, 20);
		nomeAdvocacia.setBounds(20, 10, 150, 20);
		lbTitulo.setFont(new Font("Arial", 2, 20));

		titulo.add(nomeAdvocacia);
		titulo.add(data);
		titulo.add(lbEmprestar);
		titulo.add(new JPanel());

		// mudando cores do texto
		data.setForeground(Color.WHITE);
		nomeAdvocacia.setForeground(Color.WHITE);
		lbEmprestar.setForeground(Color.WHITE);
		lbTitulo.setForeground(Color.WHITE);

		// mudando cor do fundo do painel
		titulo.setBackground(FUNDOPRETO);

		add(titulo);
	}

	public void configuraTabela() {
		panelTabela = new JPanel();
		panelTabela.setLayout(null);

		// instanciacao de componentes do painel
		tableModel = new DefaultTableModel(conteudo, colunas);
		tabela = new JTable(tableModel);
		scroll = new JScrollPane(tabela);

		// posicionando componentes
		panelTabela.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA + 220, 1000,
				300);
		scroll.setBounds(10, 10, 980, 280);

		// adicionando componentes
		panelTabela.add(scroll);
		add(panelTabela);

		// mudando fundo do painel
		panelTabela.setBackground(FUNDOPRETO);
	}
}
