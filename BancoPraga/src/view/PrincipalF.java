package view;

	import java.awt.Color;
	import java.awt.Container;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;

	import view.Aposentos;

	public class PrincipalF extends JFrame{


		private JButton btnAposentos;
		private JButton btnFuncionario;
		
		public PrincipalF() {
			super("Hotel KauDré");
			Container cont = getContentPane();
	    	cont.setBackground(new Color(200,200,200));
	    	
			btnAposentos = new JButton("Aposentos");
			btnAposentos.addActionListener(
				new ActionListener() {	//classe interna anônima			
					@Override
					public void actionPerformed(ActionEvent e) {
						Aposentos aposentos = new Aposentos();
				        aposentos.setVisible(true);
					}
				}
			);
			
			btnFuncionario = new JButton("Funcionarios");
			btnFuncionario.addActionListener(
				new ActionListener() {	//classe interna anônima			
					@Override
					public void actionPerformed(ActionEvent e) {
						Funcionarios funcionarios = new Funcionarios();
				        funcionarios.setVisible(true);
					}
				}
			);
			
			setLayout(null);
	    	cont.add(btnAposentos);
	    	btnAposentos.setBounds(15, 20, 300, 100);
	    	cont.add(btnFuncionario);
	    	btnFuncionario.setBounds(320, 20, 300, 100);
			setSize(820,400);
			setVisible(true);
	}
		
	public static void main(String[] args) {
		new PrincipalF();
	}

}
