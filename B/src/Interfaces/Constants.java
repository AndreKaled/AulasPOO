package Interfaces;

import java.awt.Color;
import java.awt.Font;

public interface Constants {
	final static Color FUNDOPRETO = new Color(29, 34, 36), AZUL = new Color(100,200,200), PRETO = FUNDOPRETO, CINZA_WHITE = new Color(219, 219, 219);
	final int DISTANCIA_ESQUERDA = 6,DISTANCIA_ALTURA = 6;
	final static Font fonteTexto = fonte(13), fonte = fonte(16), btFonte = fonte(13);
	final static int ALTURA = 1030, LARGURA = 830;
	
	public static Font fonte(int tamanhinho){
		return new Font("Arial", 1, tamanhinho);
	}
}
