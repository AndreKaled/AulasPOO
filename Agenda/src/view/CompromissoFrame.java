package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CompromissoController;
import controller.ContatoController;
import model.Compromisso;
import model.Contato;

public class CompromissoFrame extends JFrame {
	private JLabel lbHoraC, lbDataC, lbContatoC, lbObservacaoC, lbLocaliza;
	private JTextField txtHoraC, txtDataC, txtContatoC, txtLocaliza;
	JTextArea txtObservacaoC;
	private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
	private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;

	private List compromissoList = new CompromissoController().listaCompromissos();
	private int registroAtual = 0;
	private Long key;

	public CompromissoFrame() {
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
		lbLocaliza = new JLabel("Localizar por nome do contato");

		// posicionando
		lbDataC.setBounds(10, 10, 240, 15);
		lbHoraC.setBounds(10, 35, 240, 15);
		lbContatoC.setBounds(10, 60, 240, 15);
		lbObservacaoC.setBounds(10, 100, 240, 15);
		lbLocaliza.setBounds(10, 220, 240, 15);

		// adicionando
		add(lbHoraC);
		add(lbDataC);
		add(lbContatoC);
		add(lbObservacaoC);
		add(lbLocaliza);
	}

	private void configuraTextos() {
		// instanciando
		txtDataC = new JTextField();
		txtHoraC = new JTextField();
		txtContatoC = new JTextField();
		txtObservacaoC = new JTextArea();
		txtLocaliza = new JTextField();

		// posicionando
		txtDataC.setBounds(45, 8, 70, 20);
		txtHoraC.setBounds(45, 33, 70, 20);
		txtContatoC.setBounds(10, 78, 240, 20);
		txtLocaliza.setBounds(10, 240, 240, 20);

		JScrollPane scroll = new JScrollPane(txtObservacaoC);
		scroll.setBounds(10, 118, 240, 75);

		// adicionando
		add(txtDataC);
		add(txtHoraC);
		add(txtContatoC);
		add(scroll);
		add(txtLocaliza);
	}

	private void configuraBotoes() {
		// instanciando
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnClear = new JButton("Limpar");
		btnLocalizar = new JButton("Localizar");

		// posicionando
		btnSalvar.setBounds(280, 25, 80, 20);
		btnAlterar.setBounds(280, 65, 80, 20);
		btnExcluir.setBounds(280, 105, 80, 20);
		btnClear.setBounds(280, 145, 80, 20);
		btnLocalizar.setBounds(10, 270, 240, 20);

		// adicionando
		add(btnSalvar);
		add(btnAlterar);
		add(btnExcluir);
		add(btnClear);
		add(btnLocalizar);
	}

	private void adicionaEventos() {
		// adicionando eventinhos Listeners nos botoezinhos
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}

		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				salvar();
			}
		});

		btnLocalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				localizar();
			}
		});

		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alterar();
			}

		});

		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excluir();
			}

		});
	}

	public void salvar() {
		CompromissoController cc = new CompromissoController();
		try {
			cc.salvar(new SimpleDateFormat("dd/MM/yyyy").parse(txtDataC.getText()), txtHoraC.getText(),
					txtContatoC.getText(), txtObservacaoC.getText());
			JOptionPane.showMessageDialog(null, "Compromisso Salvo com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Impossível salvar compromisso!");
		}  catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Complete os dados antes de salvar!\n");
		}catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Data possui formato inválido!\n");
		}
		compromissoList = new CompromissoController().listaCompromissos();
		limpar();
	}

	protected void excluir() {
		// TODO Auto-generated method stub
		CompromissoController cc = new CompromissoController();

		try {
			long id = ((Compromisso) compromissoList.get(registroAtual)).getCodigo();
			cc.excluir(id);
			JOptionPane.showMessageDialog(this, "Compromisso excluido!");
			limpar();
			compromissoList = new ContatoController().listaContatos();
		} catch (SQLException | ClassCastException e) {
			JOptionPane.showMessageDialog(this, "Impossível excluir compromisso!\n" + e.getLocalizedMessage());
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this,
					"Nenhum compromisso selecionado!\n quer que eu exclua como sem saber qq é pra excluir?");
		}
	}

	/*
	 * private void getValores(int index) { if (index <= compromissoList.size()
	 * - 1) { Compromisso CompromissoAtual = (Compromisso)
	 * compromissoList.get(index);
	 * txtContatoC.setText(CompromissoAtual.getContato().getNome());
	 * txtDataC.setText(new
	 * SimpleDateFormat("dd/MM/yyyy").format(CompromissoAtual.getDataCompromisso
	 * ())) ; txtHoraC.setText(CompromissoAtual.getHoraCompromisso());
	 * txtObservacaoC.setText(CompromissoAtual.getObservacao()); } }
	 * 
	 * private void onClickUltimo() { registroAtual = compromissoList.size() -
	 * 1; getValores(registroAtual); }
	 * 
	 * private void onClickProximo() { if (registroAtual !=
	 * compromissoList.size() - 1) { getValores(++registroAtual); } }
	 * 
	 * private void onClickAnterior() { if (registroAtual != 0) {
	 * getValores(--registroAtual); } }
	 * 
	 * private void onClickPrimeiro() { registroAtual = 0;
	 * getValores(registroAtual); }
	 */

	private void limpar() {
		txtDataC.setText(null);
		txtHoraC.setText(null);
		txtContatoC.setText(null);
		txtObservacaoC.setText(null);
		txtLocaliza.setText(null);

		registroAtual = 0;
	}

	private void localizar() {
		// TODO Auto-generated method stub
		String recupera = null;
		if (txtLocaliza.getText().equals("") || txtLocaliza.getText() == null)
			recupera = JOptionPane.showInputDialog(this, "Insira um nome para localizar seus compromissos!");
		CompromissoController comp = new CompromissoController();
		try {
			Compromisso c = new Compromisso();
			if (recupera != null)
				c = comp.buscaCompromissoPorNome(recupera);
			else
				c = comp.buscaCompromissoPorNome("");
			
			txtDataC.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getDataCompromisso()));
			txtHoraC.setText(c.getHoraCompromisso());
			txtContatoC.setText(c.getContato().getNome());
			txtObservacaoC.setText(c.getObservacao());
			
			key = c.getCodigo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,
					"Impossível localizar Compromisso com o nome inserido!\n" + e.getLocalizedMessage());

		} catch (NullPointerException e) {
			limpar();
			e.printStackTrace();
			switch (JOptionPane.showOptionDialog(this,
					"Algo não está certo, o usuário pode não ter compromissos ou existir! :(\n Deseja adicionar contato?",
					"Contato não existe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null,
					null)) {
			case 0:
				this.dispose();
				new ContatoFrame();
				System.out.println("Selecionou: sim, adicionando contato");
				break;
			case 1:
				System.out.println("Selecionou: não, não adiciona contato");
				break;
			case 2:
				System.out.println("Selecionou: cancelar");
			}
		}
	}

	private void alterar() {
		CompromissoController comp = new CompromissoController();
		long cod = 0L;

		if (key == null) {
			if (registroAtual != 0)
				cod = ((Compromisso) compromissoList.get(registroAtual)).getCodigo();
			else
				JOptionPane.showMessageDialog(this, "Nenhum compromisso selecionado");
		} else {
			cod = key;
			key = null;
		}

		try {
			comp.alterar(cod, txtObservacaoC.getText(), txtDataC.getText(), txtHoraC.getText(), txtContatoC.getText());
			JOptionPane.showMessageDialog(this, "Compromisso alterado com sucesso!");
			limpar();
			compromissoList = new CompromissoController().listaCompromissos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Nao foi possível alterar seu compromisso!" + e.getLocalizedMessage());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this,
					"Data possui formato inválido!\n Coloque a data no formato bonito BR: dia/mês/ano");
		}
	}

	public static void main(String[] args) {
		new CompromissoFrame();
	}
}
