package move;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AreaTeste extends JFrame {

	private JPanel c;
	private static JBackgroundPanel panelTerra;
	private URL imagemTerra;
	static int largura = 200;
	static int altura = 200;
	static int larguraJanela, alturaJanela;
	static boolean armaX = false,armaY = false;

	public AreaTeste() throws IOException {
		setLayout(null);
		c = (JPanel) getContentPane();
		c.setBackground(Color.BLACK);
		panelTerra = new JBackgroundPanel(getClass().getResource("terra.jpg"));
		configuraTerra();
	}

	// configurando tamanho do planeta
	public void configuraTerra() {
		panelTerra.setBounds(200, 200, largura, altura);
		add(panelTerra);
	}

	// tratando evento para mover o planeta
	public static void mudaDirecao(int x, int y) {
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (panelTerra.getX() + panelTerra.getWidth() >= getLarguraJanela()||panelTerra.getX()<=0){
				x *= -1;
			}
			if(panelTerra.getY() + panelTerra.getHeight() >= getAlturaJanela()||panelTerra.getY()<=0){
				y *= -1;
			}
				velocidadeX(x);
			velocidadeY(y);
		}
	}

	public static void velocidadeX(int x) {
		panelTerra.setBounds(panelTerra.getX() + x, panelTerra.getY(), largura,
				altura);

	}

	public static void velocidadeY(int y) {
		panelTerra.setBounds(panelTerra.getX(), panelTerra.getY() + y, largura,
				altura);
	}

	//metodos de acesso
	public static void setLarguraJanela(int largura) {
		larguraJanela = largura;
	}

	public static int getLarguraJanela() {
		return larguraJanela;
	}

	public static void setAlturaJanela(int altura) {
		alturaJanela = altura;
	}

	public static int getAlturaJanela() {
		return alturaJanela;
	}
}
