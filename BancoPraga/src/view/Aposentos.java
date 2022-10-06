package view;

import java.awt.Color;
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
import model.Aposento;

public class Aposentos extends JFrame{
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnRemover;
	private static JTable tabela;
	private static String [] colunas = {"Código", "Número", "Descrição", "Valor"};
	
	private static Object [][] dados = {};

	public Aposentos() {
		super("Aposentos");
		initComponents();
        atualizaTabela();
        setVisible(true);
	}
	
	private void initComponents() {
		btnNovo = new JButton("Novo");
		btnNovo.setToolTipText("Novo");
		btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Alterar");
		btnRemover = new JButton("Remover");
		btnRemover.setToolTipText("Remover");
		
		btnNovo.setBackground(new Color(85, 237, 133));
		btnAlterar.setBackground(new Color(242, 245, 66));
		btnRemover.setBackground(new Color(252, 109, 109));
		
		TableModel tableModel = new DefaultTableModel(dados,colunas);
		//tabela = new JTable(dados,colunas);
		tabela = new JTable(tableModel);
		tabela.setBackground(new Color(200, 227, 247));
		JScrollPane barraRolagem = new JScrollPane(tabela);	
		//tabela.setBackground(new Color(220, 226, 252));
		
		setLayout(null);
		add(btnNovo);
		add(btnAlterar);
		add(btnRemover);
		getContentPane().add(barraRolagem);
		
		btnNovo.setBounds(10, 20, 102, 20);
		btnAlterar.setBounds(107, 20, 102, 20);
		btnRemover.setBounds(207, 20, 102, 20);
		barraRolagem.setBounds(10,40,300,100);
		setSize(400,200);
		
		btnNovo.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						InserirAposento janela = new InserirAposento();
						janela.setVisible(true);
					}
				});
		
		btnAlterar.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tabela.getSelectedRow();
						
						if(linhaSelecionada >= 0) {
							AlterarAposento janelaAlterar = new AlterarAposento(linhaSelecionada);
							janelaAlterar.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "É necessário selecionar um aposento", "Aposento",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
		btnRemover.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tabela.getSelectedRow();
						
						if(linhaSelecionada >= 0) {
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o aposento?");
							
							if(resposta == JOptionPane.YES_OPTION) {
								 Aposento aposento = BancoDados.getAposentos().get(linhaSelecionada);
						         BancoDados.removeAposento(aposento);

						         atualizaTabela();
							}
						}else {
							JOptionPane.showMessageDialog(null, "É necessário selecionar um aposento", "Aposento",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
	}
	
	public static void atualizaTabela(){
        TableModel tTabela = (DefaultTableModel) tabela.getModel();
        ((DefaultTableModel) tTabela).setNumRows(0);

        List<Aposento> aposentos = BancoDados.getAposentos();

        for (int linha = 0; linha < aposentos.size(); linha++){
            Aposento aposento = aposentos.get(linha);

            ((DefaultTableModel) tTabela).addRow(new Object[]{1});

            tabela.setValueAt(aposento.getCodigo(), linha, 0);
            tabela.setValueAt(aposento.getNumero(), linha, 1);
            tabela.setValueAt(aposento.getDescricao(), linha, 2);
            tabela.setValueAt(aposento.getValor(), linha, 3);
        }

    }
	
}
