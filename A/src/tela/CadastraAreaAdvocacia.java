package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class CadastraAreaAdvocacia extends CadastraAutor {

	JLabel nomeArea;

	public CadastraAreaAdvocacia() {
		super();
		setTitle("Cadastra Area de Advocacia");

		configuraComponentes();
	}

	public void configuraComponentes() {
		painel.remove(nomeAutor);

		nomeArea = new JLabel("Área de Advocacia...");

		titulo.setText("CADASTRAR ADVOCACIA");
		titulo.setBounds(180, 10, 300, 25);
		nomeArea.setBounds(nomeAutor.getBounds());
		nomeArea.setFont(nomeAutor.getFont());
		nomeArea.setForeground(nomeAutor.getForeground());

		painel.add(nomeArea);
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
