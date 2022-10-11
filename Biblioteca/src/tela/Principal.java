package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Interfaces.Constants;

public class Principal extends JFrame implements Constants{

	JButton btDevolver, btEmprestar,btVisualizar;
	JPanel container, painelBotoes;
	private JButton btPesquisar;

	public Principal() {
		setSize(1030, 830);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		container = (JPanel) getContentPane();
		container.setBackground(EmprestarLivro.AZUL);
		configuraBotoes();
		tratandoEventos();

		setVisible(true);
	}

	public void configuraBotoes() {
		painelBotoes = new JPanel();
		painelBotoes.setBackground(EmprestarLivro.FUNDOPRETO);
		painelBotoes.setLayout(null);
		painelBotoes.setBounds(DISTANCIA_ESQUERDA, DISTANCIA_ALTURA, 1000, 800);

		btDevolver = new JButton("DEVOLVER");
		btEmprestar = new JButton("EMPRESTAR");
		btVisualizar = new JButton("VISUALIZAR EMPRÉSTIMOS");
		btPesquisar = new JButton("PESQUISAR");

		btDevolver.setBounds(10, 10, 480, 390);
		btEmprestar.setBounds(510, 10, 480, 390);
		btVisualizar.setBounds(10,410,480,390);
		btPesquisar.setBounds(510,410,480,480);

		painelBotoes.add(btEmprestar);
		painelBotoes.add(btDevolver);
		painelBotoes.add(btVisualizar);
		painelBotoes.add(btPesquisar);

		add(painelBotoes);
	}

	public void tratandoEventos() {
		btEmprestar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EmprestarLivro();

			}

		});

		btDevolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DevolverLivro();

			}

		});
		
		btVisualizar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VisualizarEmprestimos();
				
			}
			
		});
		
		btPesquisar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PesquisarLivro();
				
			}
			
		});
	}

	public static void main(String[] args) {
		new Principal();
	}
}
