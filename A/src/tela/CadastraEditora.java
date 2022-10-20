package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class CadastraEditora extends CadastraAutor {

	JLabel nomeEditora;
	public CadastraEditora() {
		super();
		setTitle("Cadastro de editora");
		
		configuraComponentes();
	}

	public void configuraComponentes() {
		painel.remove(nomeAutor);

		nomeEditora = new JLabel("Nome da editora...");

		titulo.setText("CADASTRAR EDITORA");
	
		nomeEditora.setBounds(nomeAutor.getBounds());
		nomeEditora.setFont(nomeAutor.getFont());
		nomeEditora.setForeground(nomeAutor.getForeground());

		painel.add(nomeEditora);
	}

	@Override
	void confirmar() {

	}

	@Override
	void limpar() {
		btLimpa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txt.setText(null);

			}

		});
	}
}
