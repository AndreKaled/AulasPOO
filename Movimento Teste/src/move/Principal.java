package move;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args){
		AreaTeste areaDeTeste;
		try {
			areaDeTeste = new AreaTeste();
			areaDeTeste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			areaDeTeste.setSize(1000,600);
			areaDeTeste.setVisible(true);
			AreaTeste.setLarguraJanela(1000);
			AreaTeste.setAlturaJanela(600);
			Scanner s = new Scanner(System.in);
			System.out.println("Direção X:");
			int x = s.nextInt();
			System.out.println("Direção Y:");
			int y = s.nextInt();
			AreaTeste.mudaDirecao(x, y);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
