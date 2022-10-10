package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends JFrame {

	JButton btDevolver, btEmprestar;
	JPanel container, painelBotoes;

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
		painelBotoes.setBounds(6, 6, 1000, 200);

		btDevolver = new JButton("DEVOLVER");
		btEmprestar = new JButton("EMPRESTAR");

		btDevolver.setBounds(10, 10, 480, 90);
		btEmprestar.setBounds(500, 10, 480, 90);

		painelBotoes.add(btEmprestar);
		painelBotoes.add(btDevolver);

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
	}

	public static void main(String[] args) {
		new Principal();
	}
}
