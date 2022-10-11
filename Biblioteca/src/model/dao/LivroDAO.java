package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import modelo.Livro;

public class LivroDAO {

	private Connection con;
	
	public LivroDAO() {
		// TODO Auto-generated constructor stub
		con = ConnectionFactory.getConnection();
	}
	
	
	public boolean updateLivros(Livro livroAntigo, Livro livroNovo){
		
		String sql = "update livro set nome = ? where nome = ?";
		
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, livroNovo.getNome());
			stmt.setString(2, livroAntigo.getNome());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public List<Livro> selectLivros(){
		
		String sql = "select * from livro";
		
		ArrayList<Livro> livros = new ArrayList<>();
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Livro livro = new Livro();
				
				livro.setNome(rs.getString("nome"));
				
				livros.add(livro);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
			
		}
		
		
		return livros;
	}
	
	
}
