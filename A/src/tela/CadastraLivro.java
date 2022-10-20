package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Interfaces.Constants;

public class CadastraLivro extends CadastraAutor implements Constants{
	
	JLabel nomeLivro;
	
	public CadastraLivro(){
		super();
		setSize(600, 250);
		setLayout(null);
		
		confFormulario();
		
		setVisible(true);
	}
		public void confFormulario(){
			painel.remove(nomeAutor);
			nomeLivro = new JLabel("Nome da editora...");

			titulo.setText("CADASTRAR EDITORA");
		
			nomeLivro.setBounds(nomeAutor.getBounds());
			nomeLivro.setFont(nomeAutor.getFont());
			nomeLivro.setForeground(nomeAutor.getForeground());

			painel.add(nomeLivro);
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
