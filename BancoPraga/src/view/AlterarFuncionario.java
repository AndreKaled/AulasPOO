package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Hotel.BancoDados;
import model.Funcionario;

public class AlterarFuncionario extends JFrame{
	private JLabel lblNome;
	private JLabel lblCargo;
	private JLabel lblCpf;
	private JLabel lblSalario;
	private JLabel lblTelefone;
	private JLabel lblCodigo;
	
	private JButton btnOk;
	private JButton btnCancelar;
	
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSalario;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private int linhaSelecionada;
	
	public AlterarFuncionario(int linhaSelecionada) {
		super("Alterar Funcionário");
	
		lblNome = new JLabel("Nome");
		lblCargo = new JLabel("Cargo");
		lblSalario = new JLabel("Salário");
		lblCpf = new JLabel("Cpf");
		lblCodigo = new JLabel("Código");
		lblTelefone =  new JLabel("Telefone");
		
		txtNome = new JTextField();
		txtCargo = new JTextField();
		txtSalario = new JTextField();
		txtCpf = new JTextField();
		txtTelefone = new JTextField();
		txtCodigo = new JTextField();
		
		btnOk = new JButton("OK");
		btnCancelar = new JButton("Cancelar");
		
		setLayout(null);
		add(lblNome);
		add(txtNome);
		add(lblCargo);
		add(txtCargo);
		add(lblSalario);
		add(txtSalario);
		add(lblCpf);
		add(txtCpf);
		add(lblTelefone);
		add(txtTelefone);
		add(lblCodigo);
		add(txtCodigo);
		add(btnOk);
		add(btnCancelar);
		
		lblNome.setBounds(10, 10, 60, 20);
		txtNome.setBounds(70, 10, 60, 20);
		lblCargo.setBounds(140, 10, 60, 20);
		txtCargo.setBounds(200, 10, 60, 20);
		lblSalario.setBounds(10, 40, 60, 20);
		txtSalario.setBounds(70, 40, 60, 20);
		lblCpf.setBounds(140, 40, 60, 20);
		txtCpf.setBounds(200, 40, 60, 20);
		btnOk.setBounds(100, 80, 60, 20);
		btnCancelar.setBounds(170, 80, 90, 20);
		lblTelefone.setBounds(140,70,60,20);
		txtTelefone.setBounds(200,70,60,20);
		lblCodigo.setBounds(140,100,60,20);
		txtCodigo.setBounds(200,100,60,20);
		
		setSize(300,150);
		
		this.linhaSelecionada = linhaSelecionada;
		Funcionario aposento = BancoDados.getFuncionario().get(linhaSelecionada);
	    txtCodigo.setText(String.valueOf(aposento.getCodigo()));
	    txtNome.setText(String.valueOf(aposento.getNome()));
	    txtSalario.setText(String.valueOf(aposento.getSalario()));
	    txtCargo.setText(String.valueOf(aposento.getCargo()));
	    txtCpf.setText(String.valueOf(aposento.getCpf()));
	    txtTelefone.setText(String.valueOf(aposento.getTelefone()));
	    
		btnOk.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String iNome = txtNome.getText();
						int iCodigo = Integer.parseInt(txtCodigo.getText());
				        String iCargo = txtCargo.getText();
				        String telefone = txtTelefone.getText();
				        double Salario = Double.parseDouble(txtSalario.getText());
				        String dCpf = txtCpf.getText();
				    
				        Funcionario funcionario = new Funcionario();
				        funcionario.setCodigo(iCodigo);
				        funcionario.setNome(iNome);
				        funcionario.setCargo(iCargo);
				        funcionario.setSalario(Salario);
				        funcionario.setCpf(dCpf);
				        funcionario.setTelefone(telefone);
				      
				        BancoDados.atualizaFuncionario(linhaSelecionada, funcionario);
				        Funcionarios.atualizaTabelaF();
				        dispose();						
					}
				});
		
		btnCancelar.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
	}
}
