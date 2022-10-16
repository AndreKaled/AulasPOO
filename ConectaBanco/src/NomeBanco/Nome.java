package NomeBanco;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Interfaces.InterfaceGeral;
import Interfaces.SmallTela;

public class Nome extends JFrame implements SmallTela,InterfaceGeral{
	//variaveis de instancia
	JButton btBuscar,btLimpar, btAlterar;
	JTextField txtNome,txtApelido,txtDataNasc;
	JLabel lbNome,lbApelido,lbDataNasc;
	JPanel c;
	Color fundoLimpa,frenteLimpa;
	
	//inicializando componentes do frame
	public Nome(){
		super("Salva Info");
		setSize(TAMANHOFRAME);
		setDefaultCloseOperation(FECHAPROGRAMA);
		setLayout(null);
		
		configLabels();
		configTxts();
		configButtons();
		
		setVisible(true);
	}

	private void configLabels() {
		
		// TODO Auto-generated method stub
		lbNome = new JLabel("Nome:");
		lbNome.setBounds(posicionaLb(lbNome,10,15));
		add(lbNome);
		
		lbApelido = new JLabel("Apelido:");
		lbApelido.setBounds(posicionaLb(lbApelido,10,70));
		add(lbApelido);
		
		lbDataNasc = new JLabel("Data de Nascimento:");
		lbDataNasc.setBounds(posicionaLb(lbDataNasc,10,130));
		add(lbDataNasc);
	}

	private void configTxts() {
		// TODO Auto-generated method stub
		int largTexto = 250, altTexto = 25;
		
		txtNome = new JTextField();
		txtNome.setBounds(posicionaTxt(txtNome,10,35));
		txtNome.setBounds(tamanhoTexto(txtNome,largTexto,altTexto));
		add(txtNome);
		
		txtApelido = new JTextField();
		txtApelido.setBounds(posicionaTxt(txtApelido,10,90));
		txtApelido.setBounds(tamanhoTexto(txtApelido,largTexto,altTexto));
		add(txtApelido);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(posicionaTxt(txtDataNasc,10,150));
		txtDataNasc.setBounds(tamanhoTexto(txtDataNasc,largTexto,altTexto));
		add(txtDataNasc);
	}

	private void configButtons() {
		btBuscar = novoBotao("BUSCAR",Color.GREEN);
		btBuscar.setBounds(posicionaBt(btBuscar,15,190));
		removeFoco(btBuscar);
		add(btBuscar);
		
		btLimpar = novoBotao("LIMPAR",Color.RED, Color.WHITE);
		btLimpar.setBounds(posicionaBt(btLimpar,150,190));
		removeFoco(btLimpar);
		add(btLimpar);
		
		btAlterar = novoBotao("ALTERAR",Color.ORANGE);
		btAlterar.setBounds(15,225,235,25);
		removeFoco(btAlterar);
		add(btAlterar);
	}
	
	public static void main(String[] args){
		new Nome();
	}
}
