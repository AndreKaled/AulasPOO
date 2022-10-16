package Interfaces;

/**
 * Autor: André Kaled Duarte
 * Data: 16/10/2022
 * 
 * Interface usual que facilite a codificação de Interfaces Graficas
 * com botoes
 * */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public interface InterfaceButton extends Components{
	/*---------------------------------------------------------------------------*/
	/*-------------------------------- Botoes -----------------------------------*/
	/*---------------------------------------------------------------------------*/
	default JButton novoBotao(String nome) {
		JButton botao = new JButton(nome);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		return botao;
	}

	default JButton novoBotao(String nome, Font fonte) {
		JButton botao = new JButton(nome);
		botao.setFont(fonte);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, Color corFrente) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setForeground(corFrente);
		return botao;
	}

	default JButton novoBotao(String nome, int largura, int altura) {
		JButton botao = new JButton(nome);
		botao.setBounds(0, 0, largura, altura);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, int largura,
			int altura) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setBounds(0, 0, largura, altura);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, Font fonte) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setFont(fonte);
		return botao;
	}

	default JButton novoBotao(String nome, Color corFundo, Color corFrente,
			Font fonte) {
		JButton botao = new JButton(nome);
		botao.setBackground(corFundo);
		botao.setForeground(corFrente);
		botao.setFont(fonte);
		return botao;
	}

	default void removeFoco(JButton botao) {
		botao.setFocusable(false);
	}

	default void removeFocoEBorda(JButton botao) {
		removeFoco(botao);
		botao.setBorder(null);
	}

	default void removeFundo(JButton botao) {
		removeFocoEBorda(botao);
		botao.setContentAreaFilled(false);
	}
}
