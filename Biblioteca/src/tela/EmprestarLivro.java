package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EmprestarLivro extends JFrame {
	JPanel titulo, dadosFuncionario, dadosLivro,panelTabela, container;
	JLabel lbTitulo, lbDadosFuncionario, lbDadosLivro;
	JLabel nomeAdvocacia, data, lbEmprestar;
	JLabel matricula, numeroOAB, nome;
	JLabel numeroExemplar;
	JTextField txtNumeroExemplar;
	JTextField txtMatricula, txtNumeroOAB, txtNome;
	String[] colunas = {"N° EXEMPLAR","NOME","EDITORA","AÇÃO"};
	Object[][] conteudo = {};
	JScrollPane scroll;
	TableModel tableModel;
	JTable tabela;
	Font fonteTexto, fonte, btFonte;
	final static Color FUNDOPRETO = new Color(29, 34, 36), AZUL = new Color(74, 149, 168);
	JButton pesquisarLivro, pesquisarMatricula, btLimpar,btPesquisaExemplar;
	final int DISTANCIA_ESQUERDA = 6,DISTANCIA_ALTURA = 6;

	public EmprestarLivro() {
		super("Emprestar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1030, 830);
		setLayout(null);
		container = (JPanel) getContentPane();
		
		//pensei num vermelho mas nao ficou legal: 227, 32, 32. então vou deixar azul
		container.setBackground(AZUL);

		titulo = new JPanel();
		dadosFuncionario = new JPanel();
		dadosLivro = new JPanel();
		
		configuraTitulo();
		configuraDadosFuncionario();
		configuraTabela();
		configuraDadosLivro();
		tratandoEventos();
		
		add(titulo);
		pesquisarLivro = new JButton("PESQUISAR");
		dadosLivro.add(pesquisarLivro);
		setVisible(true);
	}
	
	public void configuraTitulo() {
		dadosFuncionario.setLayout(null);

		lbTitulo = new JLabel("Sistema Para Controle de Biblioteca");
		lbDadosFuncionario = new JLabel("Dados do Funcionario");
		lbDadosLivro = new JLabel("Dados dos Livros");

		titulo.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA, 1000, 200);
		titulo.setLayout(null);
		
		

		dadosLivro.add(lbDadosLivro);
		dadosFuncionario.add(lbDadosFuncionario);
		titulo.add(lbTitulo);

		lbEmprestar = new JLabel("Emprestar livros");
		nomeAdvocacia = new JLabel("Kauadré Advocacia");
		data = new JLabel("DATA");

		data.setBounds(930, 170, 100, 20);
		lbTitulo.setBounds(370, 100, 350, 20);
		lbEmprestar.setBounds(20, 170, 150, 20);
		nomeAdvocacia.setBounds(20, 10, 150, 20);
		lbTitulo.setFont(new Font("Arial", 2, 20));

		titulo.add(nomeAdvocacia);
		titulo.add(data);
		titulo.add(lbEmprestar);
		titulo.add(new JPanel());
		
		//mudando cores do texto
		data.setForeground(Color.WHITE);
		nomeAdvocacia.setForeground(Color.WHITE);
		lbEmprestar.setForeground(Color.WHITE);
		lbTitulo.setForeground(Color.WHITE);
		
		//mudando cor do fundo do painel
		titulo.setBackground(FUNDOPRETO);
	}

	public void configuraDadosFuncionario(){
		dadosFuncionario.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA+210, 1000, 150);
		
		// instanciando componentes de Dados Funcionario
				matricula = new JLabel("Matrícula");
				btLimpar = new JButton("LIMPAR");
				nome = new JLabel("Nome");
				txtNome = new JTextField();
				txtMatricula = new JTextField();
				pesquisarMatricula = new JButton("PESQUISAR");
				numeroOAB = new JLabel("Número OAB");
				txtNumeroOAB = new JTextField();
				

				// organizando fontes
				fonte = new Font("Arial", 1, 16);
				btFonte = new Font("Arial", 1, 13);
				fonteTexto = new Font("Arial", 1, 13);
				txtNome.setFont(fonte);
				pesquisarMatricula.setFont(btFonte);
				btLimpar.setFont(btFonte);
				txtNumeroOAB.setFont(fonte);
				txtMatricula.setFont(fonte);
				matricula.setFont(fonteTexto);
				nome.setFont(fonteTexto);
				numeroOAB.setFont(fonteTexto);

				// posicionando componentes
				btLimpar.setBounds(850, 30, 110, 25);
				nome.setBounds(340, 10, 100, 20);
				txtNome.setBounds(340, 30, 500, 25);
				txtNumeroOAB.setBounds(240, 30, 80, 25);
				numeroOAB.setBounds(240, 10, 100, 20);
				pesquisarMatricula.setBounds(115, 30, 110, 25);
				txtMatricula.setBounds(30, 30, 80, 25);
				matricula.setBounds(30, 10, 100, 20);

				// adicionando no painel
				dadosFuncionario.add(pesquisarMatricula);
				dadosFuncionario.add(numeroOAB);
				dadosFuncionario.add(txtNumeroOAB);
				dadosFuncionario.add(txtMatricula);
				dadosFuncionario.add(matricula);
				dadosFuncionario.add(nome);
				dadosFuncionario.add(txtNome);
				dadosFuncionario.add(btLimpar);
				add(dadosFuncionario);
				
				//mudando cores do texto
				numeroOAB.setForeground(Color.WHITE);
				matricula.setForeground(Color.WHITE);
				nome.setForeground(Color.WHITE);
				
				//mudando fundo do painel
				dadosFuncionario.setBackground(FUNDOPRETO);
	}
	public void configuraDadosLivro(){
		dadosLivro.setLayout(null);
		dadosLivro.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA+370, 1000, 100);
		
		//instanciando componentes do painel
		btPesquisaExemplar = new JButton("PESQUISAR");
		numeroExemplar = new JLabel("N° Exemplar");
		txtNumeroExemplar = new JTextField();
		
		//posicionando componentes do painel
		numeroExemplar.setBounds(10,20,100,20);
		txtNumeroExemplar.setBounds(10,50,100,25);
		btPesquisaExemplar.setBounds(120,50,110,25);
		
		//configurando fontes
		numeroExemplar.setFont(fonteTexto);
		txtNumeroExemplar.setFont(fonte);
		btPesquisaExemplar.setFont(btFonte);
		
		//adicionando os componentes
		dadosLivro.add(numeroExemplar);
		dadosLivro.add(txtNumeroExemplar);
		dadosLivro.add(btPesquisaExemplar);
		add(dadosLivro);
		
		//mudando cor do texto
		numeroExemplar.setForeground(Color.WHITE);
		
		//mudando fundo do painel
		dadosLivro.setBackground(FUNDOPRETO);
	}
	
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
	
	public void tratandoEventos() {
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//limpando todos os campus no painel
				txtNumeroOAB.setText(null);
				txtNome.setText(null);
				txtMatricula.setText(null);
				
			}
			
		});
	}
	
}