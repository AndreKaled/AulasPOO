package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Hotel.BancoDados;
import model.Funcionario;

public class Funcionarios extends JFrame{
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnRemover;
	private static JTable tabela;
	private static String [] colunas = {"Código", "Nome","Cargo", "Salário", "Cpf", "Telefone"};
	
	private static Object [][] dados = {};

	public Funcionarios() {
		super("Funcionário");
		initComponents();
        atualizaTabelaF();
        setVisible(true);
	}
	
	private void initComponents() {
		btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Novo");
		btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Alterar");
		btnRemover = new JButton("Remover");
		btnRemover.setToolTipText("Remover");
		
		TableModel tableModel = new DefaultTableModel(dados,colunas);
		//tabela = new JTable(dados,colunas);
		tabela = new JTable(tableModel);
		JScrollPane barraRolagem = new JScrollPane(tabela);		
		
		setLayout(null);
		add(btnNovo);
		add(btnAlterar);
		add(btnRemover);
		getContentPane().add(barraRolagem);
		
		btnNovo.setBounds(10, 20, 100, 20);
		btnAlterar.setBounds(105, 20, 100, 20);
		btnRemover.setBounds(205, 20, 100, 20);
		barraRolagem.setBounds(10,40,400,100);
		setSize(400,200);
		
		btnNovo.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						InserirFuncionario janela = new InserirFuncionario();
						janela.setVisible(true);
					}
				});
		
		btnAlterar.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tabela.getSelectedRow();
						
						if(linhaSelecionada >= 0) {
							AlterarFuncionario janelaAlterar = new AlterarFuncionario(linhaSelecionada);
							janelaAlterar.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "É necessário selecionar um funcionário", "Funcionário",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
		btnRemover.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tabela.getSelectedRow();
						
						if(linhaSelecionada >= 0) {
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o funcionário?");
							
							if(resposta == JOptionPane.YES_OPTION) {
								 Funcionario funcionario = BancoDados.getFuncionario().get(linhaSelecionada);
						         BancoDados.removeFuncionario(funcionario);

						         atualizaTabelaF();
							}
						}else {
							JOptionPane.showMessageDialog(null, "É necessário selecionar um funcionário", "Funcionário",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
	}
	
	public static void atualizaTabelaF(){
        TableModel tTabela = (DefaultTableModel) tabela.getModel();
        ((DefaultTableModel) tTabela).setNumRows(0);

        List<Funcionario> funcionarios = BancoDados.getFuncionario();

        for (int linha = 0; linha < funcionarios.size(); linha++){
            Funcionario funcionario = funcionarios.get(linha);

            ((DefaultTableModel) tTabela).addRow(new Object[]{1});

            tabela.setValueAt(funcionario.getCodigo(), linha, 0);
            tabela.setValueAt(funcionario.getNome(), linha, 1);
            tabela.setValueAt(funcionario.getCargo(), linha, 2);
            tabela.setValueAt(funcionario.getSalario(), linha, 3);
            tabela.setValueAt(funcionario.getCpf(), linha, 4);
            tabela.setValueAt(funcionario.getTelefone(), linha, 5);
        }

    }
}
