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
		save(insert,compromisso.getDataCompromisso(),compromisso.getContato().getNome(),compromisso.getObservacao(),compromisso.getHoraCompromisso());
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
    
    public Compromisso findByName(String name) throws SQLException {
        String select = "SELECT * FROM COMPROMISSO WHERE contato = ?";
        Compromisso compromisso = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            compromisso = new Compromisso();
            compromisso.setCodigo(rs.getInt("codigo"));
            compromisso.setDataCompromisso(rs.getDate("dataCompromisso"));
           
            Contato contato = new Contato();
            contato.setNome((rs.getString("contato")));
            
            compromisso.setContato(contato);
            compromisso.setObservacao(rs.getString("observacao"));
            compromisso.setHoraCompromisso(rs.getString("horaCompromisso"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return compromisso;
    }
}
