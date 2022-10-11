package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Biblioteca extends JFrame {
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

	JButton pesquisarLivro, pesquisarMatricula, btLimpar,btPesquisaExemplar;

	public Biblioteca() {
		super("Bibloteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1020, 850);
		setLayout(null);

		titulo = new JPanel();
		dadosFuncionario = new JPanel();
		dadosLivro = new JPanel();
		container = (JPanel) getContentPane();
		container.setBackground(Color.WHITE);
		dadosFuncionario.setLayout(null);

		lbTitulo = new JLabel("Sistema Para Controle de Biblioteca");
		lbDadosFuncionario = new JLabel("Dados do Funcionario");
		lbDadosLivro = new JLabel("Dados dos Livros");

		titulo.setBounds(0, 0, 1000, 200);
		titulo.setLayout(new BorderLayout());
		dadosFuncionario.setBounds(0, 230, 1000, 150);
		dadosLivro.setBounds(0, 410, 1000, 100);

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
		lbTitulo.setFont(new Font("Arial", 1, 20));

		titulo.add(nomeAdvocacia);
		titulo.add(data);
		titulo.add(lbEmprestar);
		titulo.add(new JPanel());

		configuraDadosFuncionario();
		configuraTabela();
		configuraDadosLivro();

		
		
		add(titulo);
		pesquisarLivro = new JButton("PESQUISAR");
		dadosLivro.add(pesquisarLivro);
		setVisible(true);
	}

	public void configuraDadosFuncionario(){
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
	}
	public void configuraDadosLivro(){
		dadosLivro.setLayout(null);
		
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
	}
	
	public void configuraTabela(){
		panelTabela = new JPanel();
		panelTabela.setLayout(null);
		
		//instanciação de componentes do painel
		tableModel = new DefaultTableModel(conteudo,colunas);
		tabela = new JTable(tableModel);
		scroll = new JScrollPane(tabela);
		
		//posicionando componentes
		panelTabela.setBounds(0,520,1000,300);
		scroll.setBounds(10,10,980,290);
		
		//adicionando componentes
		panelTabela.add(scroll);
		add(panelTabela);
	}
	public static void main(String[] args) {
		new Biblioteca();
	}
}