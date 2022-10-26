package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CompromissoController;
import model.Compromisso;

public class CompromissoFrame extends JFrame{
	private JLabel lbHoraC, lbDataC, lbContatoC, lbObservacaoC,lbLocaliza;
	private JTextField txtHoraC, txtDataC, txtContatoC, txtLocaliza;
	JTextArea txtObservacaoC;
	private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
	private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;
	
	public CompromissoFrame(){
		super("Compromissos");
		setLayout(null);
		setSize(400, 350);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        
		configuraLabels();
		configuraTextos();
		configuraBotoes();
		adicionaEventos();
		
		 setVisible(true);
	}

	private void configuraLabels() {
		// instanciacao
		lbHoraC = new JLabel("Hora");
		lbDataC = new JLabel("Data");
		lbContatoC = new JLabel("Nome do contato");
		lbObservacaoC = new JLabel("Observação");
		lbLocaliza = new JLabel("Localizar por contato");
		
		//posicionando
		lbDataC.setBounds(10, 10, 240, 15);
		lbHoraC.setBounds(10, 35, 240, 15);
		lbContatoC.setBounds(10,60,240,15);
		lbObservacaoC.setBounds(10,100,240,15);
		lbLocaliza.setBounds(10,220,240,15);
		
		//adicionando
		add(lbHoraC);
		add(lbDataC);
		add(lbContatoC);
		add(lbObservacaoC);
		add(lbLocaliza);
	}

	private void configuraTextos() {
		//instanciando
		txtDataC = new JTextField();
		txtHoraC = new JTextField();
		txtContatoC = new JTextField();
		txtObservacaoC = new JTextArea();
		txtLocaliza = new JTextField();
		
		//posicionando
		txtDataC.setBounds(45,8,70,20);
		txtHoraC.setBounds(45,33,70,20);
		txtContatoC.setBounds(10,78,240,20);
		txtLocaliza.setBounds(10,240,240,20);
		
		JScrollPane scroll = new JScrollPane(txtObservacaoC);
		scroll.setBounds(10,118,240,75);
		
		//adicionando
		add(txtDataC);
		add(txtHoraC);
		add(txtContatoC);
		add(scroll);
		add(txtLocaliza);
	}

	private void configuraBotoes() {
		//instanciando
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnClear = new JButton("Limpar");
		btnLocalizar = new JButton("Localizar");
		
		//posicionando
		btnSalvar.setBounds(280, 25, 80, 20);
		btnAlterar.setBounds(280, 65, 80, 20);
		btnExcluir.setBounds(280,105,80,20);
		btnClear.setBounds(280,145,80,20);
		btnLocalizar.setBounds(10,270,240,20);
		
		//adicionando
		add(btnSalvar);
		add(btnAlterar);
		add(btnExcluir);
		add(btnClear);
		add(btnLocalizar);
	}

	private void adicionaEventos() {
		// adicionando eventinhos Listeners nos botoezinhos
		btnClear.addActionListener(new ActionListener(){

			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtDataC.setText(null);
				txtHoraC.setText(null);
				txtContatoC.setText(null);
				txtObservacaoC.setText(null);
				txtLocaliza.setText(null);
			}
			
		});
		
		btnSalvar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CompromissoController cc = new CompromissoController();
				try {
					cc.salvar(new SimpleDateFormat("dd/MM/yyyy").parse(txtDataC.getText()), txtHoraC.getText(), txtContatoC.getText(), txtObservacaoC.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(ParseException e){
					e.printStackTrace();
				}
			}
			
		});
		
		btnLocalizar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					localizar();
			}
		});
	}
	
	private void localizar() {
		// TODO Auto-generated method stub
		CompromissoController comp = new CompromissoController();
		try {
			Compromisso c = comp.buscaCompromissoPorNome(txtLocaliza.getText());
			txtDataC.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getDataCompromisso()));
			txtHoraC.setText(c.getHoraCompromisso());
			txtContatoC.setText(c.getContato().getNome());
			txtObservacaoC.setText(c.getObservacao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CompromissoFrame();
	}          
}
