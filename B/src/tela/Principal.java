package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Interfaces.Constants;

public class Principal extends JFrame implements Constants {

	JBackgroundPanel panelDevolver, panelEmprestar, panelVisualizar;
	JPanel container, painelBotoes;
	private JBackgroundPanel btPesquisar;
	JMenuBar menu;
	private JPanel titulo;
	private JLabel lbTitulo, lbEmprestar, lbDevolver, lbPesquisar, lbVisualizar;
	private JMenuItem emprestarItem;
	private JMenuItem pesquisarItem;
	private JMenuItem devolverItem;
	private JMenuItem visualizarItem;
	private JMenuItem funcionarioItem;
	private JMenuItem editoraItem;
	private JMenuItem areaItem;
	private JMenuItem livroItem;
	private JMenuItem autorItem;
	private JMenuItem sairItem;
	private JMenu menuCadastro;
	private JMenu menuOperacoes;

	public Principal() {
		setSize(ALTURA,LARGURA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Abacate");
		setLayout(null);

		container = (JPanel) getContentPane();
		container.setBackground(EmprestarLivro.AZUL);
		configuraBotoes();
		confMenuBar();
		confTitulo();
		
		tratandoEventos();
		setVisible(true);
	}

	public void confTitulo() {
		titulo = new JPanel();
		titulo.setBounds(10, 10, 980, 35);
		titulo.setBackground(new Color(38, 133, 212));
		lbTitulo = new JLabel("Sistema de Biblioteca");
		titulo.add(lbTitulo);
		lbTitulo.setForeground(Color.WHITE);
		painelBotoes.add(titulo);
	}

	public void confMenuBar() {
		menu = new JMenuBar();
		menu.setBounds(10, 50, 980, 35);
		Color fundoMenu = new Color(38, 133, 212), frenteMenu = Color.WHITE;
		menu.setBackground(fundoMenu);
		painelBotoes.add(menu);

		menuCadastro = new JMenu("Cadastro");
		menuOperacoes = new JMenu("Operações");

		// alterando cor do texto do menu
		menuCadastro.setForeground(Color.WHITE);
		menuOperacoes.setForeground(Color.WHITE);

		funcionarioItem = new JMenuItem("Funcionário");
		livroItem = new JMenuItem("Livros");
		editoraItem = new JMenuItem("Editora");
		autorItem = new JMenuItem("Autor");
		areaItem = new JMenuItem("Area advocacia");
		sairItem = new JMenuItem("Sair");
		
		emprestarItem = new JMenuItem("Emprestar");
		devolverItem = new JMenuItem("Devolver");
		pesquisarItem = new JMenuItem("Pesquisar");
		visualizarItem = new JMenuItem("Visualizar");
		
		menuCadastro.add(funcionarioItem);
		menuCadastro.add(livroItem);
		menuCadastro.add(editoraItem);
		menuCadastro.add(autorItem);
		menuCadastro.add(areaItem);
		menuCadastro.add(sairItem);

		//adicionando teclas de atalho
		sairItem.setMnemonic('S');
		funcionarioItem.setMnemonic('F');
		livroItem.setMnemonic('L');
		editoraItem.setMnemonic('E');
		autorItem.setMnemonic('A');
		areaItem.setMnemonic('r');
		emprestarItem.setMnemonic('E');
		devolverItem.setMnemonic('D');
		pesquisarItem.setMnemonic('P');
		visualizarItem.setMnemonic('V');
		menuCadastro.setMnemonic('C');
		menuOperacoes.setMnemonic('O');

		// alterando fundo e texto dos itens
		emprestarItem.setBackground(fundoMenu);
		devolverItem.setBackground(fundoMenu);
		pesquisarItem.setBackground(fundoMenu);
		visualizarItem.setBackground(fundoMenu);

		visualizarItem.setForeground(frenteMenu);
		pesquisarItem.setForeground(frenteMenu);
		devolverItem.setForeground(frenteMenu);
		emprestarItem.setForeground(frenteMenu);

		funcionarioItem.setBackground(fundoMenu);
		livroItem.setBackground(fundoMenu);
		editoraItem.setBackground(fundoMenu);
		autorItem.setBackground(fundoMenu);
		areaItem.setBackground(fundoMenu);
		sairItem.setBackground(fundoMenu);

		funcionarioItem.setForeground(frenteMenu);
		livroItem.setForeground(frenteMenu);
		editoraItem.setForeground(frenteMenu);
		autorItem.setForeground(frenteMenu);
		areaItem.setForeground(frenteMenu);
		sairItem.setForeground(frenteMenu);

		menuOperacoes.add(emprestarItem);
		menuOperacoes.add(visualizarItem);
		menuOperacoes.add(pesquisarItem);
		menuOperacoes.add(devolverItem);

		menu.add(menuCadastro);
		menu.add(menuOperacoes);
	}

	public void configuraBotoes() {
		painelBotoes = new JPanel();
		painelBotoes.setBackground(EmprestarLivro.FUNDOPRETO);
		painelBotoes.setLayout(null);
		painelBotoes.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA, 1000, 800);

		try {
			panelDevolver = new JBackgroundPanel("livroFechado.jpg");
			panelEmprestar = new JBackgroundPanel("livro.png");
			panelVisualizar = new JBackgroundPanel("olho.png");
			btPesquisar = new JBackgroundPanel("lupa.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		panelDevolver.setBounds(100, 100, 380, 320);
		panelEmprestar.setBounds(550, 100, 380, 320);
		panelVisualizar.setBounds(100, 450, 380, 320);
		btPesquisar.setBounds(550, 450, 380, 320);

		lbEmprestar = new JLabel("Emprestar");
		lbDevolver = new JLabel("Devolver");
		lbVisualizar = new JLabel("Visualizar");
		lbPesquisar = new JLabel("Pesquisar");

		panelEmprestar.add(lbEmprestar);
		btPesquisar.add(lbPesquisar);
		panelDevolver.add(lbDevolver);
		panelVisualizar.add(lbVisualizar);

		painelBotoes.add(panelEmprestar);
		painelBotoes.add(panelDevolver);
		painelBotoes.add(panelVisualizar);
		painelBotoes.add(btPesquisar);

		add(painelBotoes);
	}

	public void tratandoEventos() {
		visualizarItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VisualizarEmprestimos();
				
			}
			
		});
		
		emprestarItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new EmprestarLivro();
				
			}
			
		});
		
		pesquisarItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new PesquisarLivro();
				
			}
			
		});
		
		devolverItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new DevolverLivro();
				
			}
			
		});
		
		sairItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		
		panelEmprestar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new EmprestarLivro();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		panelDevolver.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new DevolverLivro();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		panelVisualizar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new VisualizarEmprestimos();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		btPesquisar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new PesquisarLivro();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public static void main(String[] args) {
		new Principal();
	}
}
