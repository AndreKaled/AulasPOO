package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Interfaces.Constants;

public abstract class Cadastro extends JFrame implements Constants{
	
	//declaração de componentes e instanciacao
	JLabel titulo = new JLabel("CADASTRAR");
	JButton btConfirma = new JButton("COMFIRMAR"),btCancela = new JButton("CANCELAR"),btLimpa = new JButton("LIMPAR");
	JPanel painel = new JPanel(),fundo = (JPanel) getContentPane();
	JTextField txt = new JTextField();
	
	//metodos para especializar depois
	abstract void confirmar();
	abstract void limpar();
	
	//cancelando cadastro e retornando a tela anterior
	void cancelar(){
		btCancela.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Principal();
				
			}});
		
	}
	
	void adicionaComp(){
		painel.add(titulo);
		painel.add(btConfirma);
		painel.add(btCancela);
		painel.add(btLimpa);
		add(painel);
		painel.add(txt);
	}
	
}
