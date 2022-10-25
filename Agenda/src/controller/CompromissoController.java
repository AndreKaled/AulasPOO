package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CompromissoDao;
import dao.ContatoDao;
import model.Compromisso;
import model.Contato;
import util.Util;

public class CompromissoController {

	public void salvar(Date dataCompromisso, String horaCompromisso, String nomeContato, String observacao)
			throws SQLException, ParseException {
		Compromisso compromisso = new Compromisso();
		compromisso.setDataCompromisso(dataCompromisso);

		Contato contato = new ContatoController().buscaContatoPorNome(nomeContato);

		compromisso.setContato(contato);
		compromisso.setObservacao(observacao);
		compromisso.setHoraCompromisso(horaCompromisso);

		new CompromissoDao().salvar(compromisso);
	}

	public void alterar(int codigo, String observacao, String dataCompromisso, String horaCompromisso,
			String nomeContato) throws ParseException, SQLException {

		Compromisso compromisso = new Compromisso();
		compromisso.setCodigo(codigo);
		compromisso.setObservacao(observacao);
		compromisso.setDataCompromisso(Util.formatarData(dataCompromisso));
		compromisso.setHoraCompromisso(horaCompromisso);

		Contato contato = new ContatoController().buscaContatoPorNome(nomeContato);

		compromisso.setContato(contato);

		new CompromissoDao().alterar(compromisso);
	}

	public List listaCompromissos() {
		CompromissoDao dao = new CompromissoDao();
		try {
			return dao.findCompromissos();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas ao localizar compromisso" + e.getLocalizedMessage());
		}
		return null;
	}
	
	public void excluir(long id) throws SQLException {
        new CompromissoDao().excluir(id);
	}
	
	public Compromisso buscaCompromissoPorCodigo(int codigo) throws SQLException {
        CompromissoDao dao = new CompromissoDao();
        return dao.findByCodigo(codigo);
    }
}
