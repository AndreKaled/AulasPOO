package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectaBanco {

	Connection conexao;
	PreparedStatement state;
	String comando = "insert into Teste values ('Abacate')";
	
	public ConnectaBanco() throws SQLException {
		 conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblio", "root", "root");
		 state = conexao.prepareStatement(comando);
		 state.execute();
	}
	
	public static void main(String[] args){
		try{
			new ConnectaBanco();
			System.out.println("Foi");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
