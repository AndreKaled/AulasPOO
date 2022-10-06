package Hotel;

import java.util.ArrayList;
import java.util.List;

import model.Aposento;
import model.Funcionario;

public class BancoDados {
	
	private static List<Aposento> aposentos = new ArrayList<Aposento>();
	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public static List<Aposento> getAposentos(){
		return aposentos;
	}
	
	public static void addAposento(Aposento aposento){
		aposentos.add(aposento);
	}
	
	public static void removeAposento(Aposento aposento){
		aposentos.remove(aposento);
	}
	
	public static void atualizaAposentos(int linhaSelecionada, Aposento aposento){
		aposentos.set(linhaSelecionada, aposento);
	}
	
//	Funcionário
	
	public static List<Funcionario> getFuncionario(){
		return funcionarios;
	}
	
	public static void addFuncionario(Funcionario funcionario){
		funcionarios.add(funcionario);
	}
	
	public static void removeFuncionario(Funcionario funcionario){
		funcionarios.remove(funcionario);
	}
	
	public static void atualizaFuncionario(int linhaSelecionada, Funcionario funcionario){
		funcionarios.set(linhaSelecionada, funcionario);
	}
	
}
