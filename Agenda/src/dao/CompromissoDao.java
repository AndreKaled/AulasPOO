package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compromisso;
import model.Contato;

public class CompromissoDao extends GenericDao{

	public void salvar(Compromisso compromisso) throws SQLException{
		String insert = "INSERT INTO compromisso (dataCompromisso,contato,observacao,horaCompromisso) VALUES (?,?,?,?)";
		save(insert,compromisso.getDataCompromisso(),compromisso.getContato(),compromisso.getObservacao(),compromisso.getHoraCompromisso());
	}
	
	public void alterar (Compromisso compromisso) throws SQLException {
		 String update = "UPDATE COMPROMISSO " +
	                "SET dataCompromisso = ?, contato = ?, observacao = ? , horaCompromisso = ?" +
	                "WHERE codigo = ?";
	        update(update, compromisso.getCodigo(), compromisso.getDataCompromisso(), 
	        		compromisso.getContato(), compromisso.getObservacao(), compromisso.getHoraCompromisso());
	}
	
    public void excluir(long codigo) throws SQLException {
        String delete = "DELETE FROM COMPROMISSO WHERE codigo = ?";
        delete(delete, codigo);
    }
    
    public List findCompromissos() throws SQLException {
        List compromissos = new ArrayList();

        String select = "SELECT * FROM CONTATOS";

        PreparedStatement stmt = 
	    getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Compromisso compromisso = new Compromisso();
            compromisso.setCodigo(rs.getInt("cod"));
            compromisso.setDataCompromisso(rs.getDate("dataCompromisso"));
            
     
            
            //compromisso.setContato(contato);
            compromisso.setObservacao(rs.getString("observacao"));
            compromisso.setHoraCompromisso(rs.getString("horaCompromisso"));
            compromissos.add(compromisso);
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return compromissos;
    }
    
    public Compromisso findByCodigo(int codigo) throws SQLException {
        String select = "SELECT * FROM COMPROMISSOS WHERE codigo = ?";
        Compromisso compromisso = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setInt(1, codigo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            compromisso = new Compromisso();
            compromisso.setCodigo(rs.getInt("cod"));
            compromisso.setDataCompromisso(rs.getDate("dataCompromisso"));
           
            
            //compromisso.setContato(rs.getInt("contato"));
            compromisso.setObservacao(rs.getString("observacao"));
            compromisso.setHoraCompromisso(rs.getString("horaCompromisso"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return compromisso;
    }
}
