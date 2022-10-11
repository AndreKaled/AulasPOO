package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Interfaces.Constants;

public class PesquisarLivro extends JFrame implements Constants{

	Date dataHoje = new Date();
	DateFormat formataData = DateFormat.getDateInstance(DateFormat.FULL);
	ButtonGroup gpBts;
	JPanel titulo, panelTabela, container;
	JLabel lbTitulo, lbDadosFuncionario, lbDadosLivro;
	JLabel nomeAdvocacia, data, lbEmprestar;
	String[] colunas = { "N° EXEMPLAR", "NOME", "AUTOR", "EDITORA",
			"PREVISÃO DEVOLUÇÃO" };
	Object[][] conteudo = {};
	JScrollPane scroll;
	TableModel tableModel;
	JTable tabela;
	JRadioButton btAutor,btLivro,btEditora; 
	private JLabel tipoDePesquisa, textinhoBonito;
	private JPanel painelPesquisa;
	JTextField txtPesquisa;
	JButton btPesquisar,btNovaPesquisa;
	private JPanel painelResultado;
	private JLabel resultado;
	
	public PesquisarLivro(){
		setSize(1030,830);
		setLayout(null);
		
		container = (JPanel) getContentPane();
		container.setBackground(AZUL);
		
		configuraTitulo();
		configuraTipoPesquisa();
		configuraResultado();
		eventos();
		
		setVisible(true);
	}
	
	public void eventos(){
		btNovaPesquisa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtPesquisa.setText(null);
				gpBts.clearSelection();
			}
			
		});
	}
	
	public void configuraResultado(){
		//instanciando componentes
		painelResultado = new JPanel();
		painelResultado.setLayout(null);
		resultado = new JLabel("RESULTADOS ENCONTRADOS");
		tableModel = new DefaultTableModel(conteudo,colunas);
		tabela = new JTable(tableModel);
		scroll = new JScrollPane(tabela);
		
		//posicionando componentes
		painelResultado.setBounds(DISTANCIA_ESQUERDA,DISTANCIA_ALTURA+painelPesquisa.getHeight()+220,1000,300);
		resultado.setBounds(10,10,200,20);
		scroll.setBounds(10, 30, 980, 260);
		
		//alterando fontes
		resultado.setFont(fonteTexto);
		
		//mudando cores
		painelResultado.setBackground(FUNDOPRETO);
		resultado.setForeground(Color.WHITE);
		
		//adicionando componentes
		painelResultado.add(resultado);
		painelResultado.add(scroll);
		add(painelResultado);
	}
	
	public void configuraTipoPesquisa(){
		painelPesquisa = new JPanel();
		JPanel panelGpBts = new JPanel();
		tipoDePesquisa = new JLabel("Selecione o tipo de pesquisa");
		painelPesquisa.setLayout(null);
		gpBts = new ButtonGroup();
		btAutor = new JRadioButton("Autor");
		btLivro = new JRadioButton("Livro");
		btEditora = new JRadioButton("Editora");
		textinhoBonito = new JLabel("Digite a palavra chave para pesquisar e clique no botão Pesquisar");
		txtPesquisa = new JTextField();
		btPesquisar = new JButton("PESQUISAR");
		btNovaPesquisa = new JButton("NOVA PESQUISA");
		
		tipoDePesquisa.setFont(new Font("Arial", 1,18));
		btPesquisar.setFont(btFonte);
		btNovaPesquisa.setFont(btFonte);
		
		//posicionando componentes
		painelPesquisa.setBounds(DISTANCIA_ESQUERDA,DISTANCIA_ALTURA+titulo.getHeight()+10,1000,130);
		tipoDePesquisa.setBounds(10,10,280,30);
		panelGpBts.setBounds(10,40,350,30);
		textinhoBonito.setBounds(10,70,390,20);
		txtPesquisa.setBounds(10,90,390,25);
		btPesquisar.setBounds(410,90,150,25);
		btNovaPesquisa.setBounds(570,90,150,25);
		
		//alterando fundo
		painelPesquisa.setBackground(FUNDOPRETO);
		panelGpBts.setOpaque(false);
		btAutor.setOpaque(false);
		btLivro.setOpaque(false);
		btEditora.setOpaque(false);
		
		//alterando cor do texto
		tipoDePesquisa.setForeground(Color.WHITE);
		btAutor.setForeground(Color.WHITE);
		btEditora.setForeground(Color.WHITE);
		btLivro.setForeground(Color.WHITE);
		textinhoBonito.setForeground(Color.WHITE);
		
		//adicionando no painel
		painelPesquisa.add(tipoDePesquisa);
		panelGpBts.add(btAutor);
		panelGpBts.add(btLivro);
		panelGpBts.add(btEditora);
		gpBts.add(btAutor);
		gpBts.add(btLivro);
		gpBts.add(btEditora);
		painelPesquisa.add(panelGpBts);
		painelPesquisa.add(textinhoBonito);
		painelPesquisa.add(txtPesquisa);
		painelPesquisa.add(btNovaPesquisa);
		painelPesquisa.add(btPesquisar);
		add(painelPesquisa);
	}
	
	public void configuraTitulo() {
		titulo = new JPanel();

		lbTitulo = new JLabel("Sistema Para Controle de Biblioteca");
		lbDadosFuncionario = new JLabel("Dados do Funcionario");
		lbDadosLivro = new JLabel("Dados dos Livros");

		titulo.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA, 1000, 200);
		titulo.setLayout(null);

		titulo.add(lbTitulo);

		lbEmprestar = new JLabel("Pesquisar livros");
		nomeAdvocacia = new JLabel("Kauadré Advocacia");
		data = new JLabel("" +formataData.format(dataHoje));

		data.setBounds(770, 170, 230, 20);
		lbTitulo.setBounds(370, 100, 350, 20);
		lbEmprestar.setBounds(20, 170, 150, 20);
		nomeAdvocacia.setBounds(20, 10, 150, 20);
		lbTitulo.setFont(new Font("Arial", 1, 20));

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

}
