package controller;

import javax.swing.*;

import dao.ContatoDao;
import model.Contato;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import util.Util;

public class ContatoController {

    public void salvar(String nome, String apelido, String dtNascimento) 
		throws SQLException, ParseException 
	{
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(Util.formatarData(dtNascimento));

        new ContatoDao().salvar(contato);
    }

    public void alterar(long id, String nome, String apelido, String dtNascimento) 
		throws ParseException, SQLException 
	{
        
		Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(Util.formatarData(dtNascimento));

        new ContatoDao().alterar(contato);
    }

    public List listaContatos() {
        ContatoDao dao = new ContatoDao();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar contaton" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(long id) throws SQLException {
        new ContatoDao().excluir(id);
    }

    public Contato buscaContatoPorNome(String nome) throws SQLException {
        ContatoDao dao = new ContatoDao();
        return dao.findByName(nome);
    }
    
    public Contato buscaPorApelido(String apelido) throws SQLException{
    	ContatoDao dao = new ContatoDao();
    	return dao.findByNickName(apelido);
    }
}