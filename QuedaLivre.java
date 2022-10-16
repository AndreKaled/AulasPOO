package Classes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuedaLivre extends JFrame {
	private static JPanel chao;
	private static JPanel corpo;
	private int altura, tempo;
	private int aceleracao = 1;

	public QuedaLivre() {
		setSize(500, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		chao = new JPanel();
		chao.setBounds(0, 675, 500, 25);
		chao.setBackground(Color.BLACK);
		add(chao);

		corpo = new JPanel();
		corpo.setBounds(0, 0, 25, 25);
		corpo.setBackground(Color.DARK_GRAY);
		add(corpo);

		setVisible(true);
	}

	public void move() {
		new Simula();
	}

	public void defineAltura(int distancia) {
		altura = distancia;
	}

	public void defineGravidade(int aceleracao) {
		this.aceleracao = aceleracao;
	}

	public int calculaTempo(){
		return (int) (2*aceleracao*altura);
	}

	public int metodoTorricelli(){
		return (int) Math.sqrt(2*aceleracao*altura);
	}

	public class Simula extends Thread {
		public void run() {
			tempo = calculaTempo();
			tempo/=2;
			while (corpo.getY() + corpo.getHeight() < chao.getY()) {
				try {
				//	if(tempo > 0){
				//		sleep(tempo);
				//		System.out.println(tempo);
				//		tempo = (int) (tempo / 1.5);
				//	}else{
						sleep(2);
				//	}
				} catch (Exception e) {}
				corpo.setBounds(corpo.getX(),corpo.getY()+aceleracao,corpo.getHeight(),corpo.getWidth());
				aceleracao *=1.9;
			}
			interrupt();
		}

		public Simula() {
			start();
		}
	}

	public static void main(String[] args) {
		QuedaLivre o = new QuedaLivre();
		
		o.defineGravidade(1);
		o.defineAltura(chao.getY()-(corpo.getY()+corpo.getHeight()));
		o.move();
	}
}
