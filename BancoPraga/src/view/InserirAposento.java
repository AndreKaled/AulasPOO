package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Hotel.BancoDados;
import model.Aposento;

public class InserirAposento extends JFrame {
	private JLabel lblCodigo;
	private JLabel lblNumero;
	private JLabel lblDescricao;
	private JLabel lblValor;
	private JButton btnOk;
	private JButton btnCancelar;
	private JTextField txtCodigo;
	private JTextField txtNumero;
	private JTextField txtDescricao;
	private JTextField txtValor;
	JPanel c = (JPanel) getContentPane();

	public InserirAposento() {
		super("Inserir Aposento");

		lblCodigo = new JLabel("Código");
		lblNumero = new JLabel("Número");
		lblDescricao = new JLabel("Descrição");
		lblValor = new JLabel("Valor");
		txtCodigo = new JTextField();
		txtNumero = new JTextField();
		txtDescricao = new JTextField();
		txtValor = new JTextField();
		btnOk = new JButton("OK");
		btnCancelar = new JButton("Cancelar");

		setLayout(null);
		c.add(lblCodigo);
		c.add(txtCodigo);
		c.add(lblNumero);
		c.add(txtNumero);
		c.add(lblDescricao);
		c.add(txtDescricao);
		c.add(lblValor);
		c.add(txtValor);
		c.add(btnOk);
		c.add(btnCancelar);

		lblCodigo.setBounds(10, 10, 60, 20);
		txtCodigo.setBounds(70, 10, 60, 20);
		lblNumero.setBounds(140, 10, 60, 20);
		txtNumero.setBounds(200, 10, 60, 20);
		lblDescricao.setBounds(10, 40, 60, 20);
		txtDescricao.setBounds(70, 40, 60, 20);
		lblValor.setBounds(140, 40, 60, 20);
		txtValor.setBounds(200, 40, 60, 20);
		btnOk.setBounds(100, 80, 60, 20);
		btnCancelar.setBounds(170, 80, 90, 20);

		Color cor = new Color(15, 60, 209);
		c.setBackground(cor);

		setSize(300, 150);

		txtCodigo.setBorder(null);
		txtNumero.setBorder(null);
		txtDescricao.setBorder(null);
		txtValor.setBorder(null);
		
		
		
		lblCodigo.setForeground(Color.WHITE);
		lblNumero.setForeground(Color.WHITE);
		lblDescricao.setForeground(Color.WHITE);
		lblValor.setForeground(Color.WHITE);
		btnOk.setBackground(new Color(11, 163, 23));
		btnCancelar.setBackground(new Color(255, 71, 20));
		btnCancelar.setForeground(Color.WHITE);
		btnOk.setForeground(Color.WHITE);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int iCodigo = Integer.parseInt(txtCodigo.getText());
				int iNumero = Integer.parseInt(txtNumero.getText());
				String sDescricao = txtDescricao.getText();
				double dValor = Double.parseDouble(txtValor.getText());
				Aposento aposento = new Aposento();
				aposento.setCodigo(iCodigo);
				aposento.setNumero(iNumero);
				aposento.setDescricao(sDescricao);
				aposento.setValor(dValor);

				BancoDados.addAposento(aposento);
				Aposentos.atualizaTabela();
				dispose();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}
}
