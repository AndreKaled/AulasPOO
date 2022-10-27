package model;

import java.util.Date;

public class Compromisso {

	private Contato contato;
	private String observacao, horaCompromisso;
	private long codigo;
	private Date dataCompromisso;
	
	public Compromisso(){
		
	}
	
	public Compromisso(Contato contato, String observacao, String horaCompromisso, int codigo, Date dataCompromisso) {
		super();
		this.contato = contato;
		this.observacao = observacao;
		this.horaCompromisso = horaCompromisso;
		this.codigo = codigo;
		this.dataCompromisso = dataCompromisso;
	}
	
	public Contato getContato() {
		return contato;
	}



	public void setContato(Contato contato) {
		this.contato = contato;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public String getHoraCompromisso() {
		return horaCompromisso;
	}



	public void setHoraCompromisso(String horaCompromisso) {
		this.horaCompromisso = horaCompromisso;
	}



	public long getCodigo() {
		return codigo;
	}



	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}



	public Date getDataCompromisso() {
		return dataCompromisso;
	}



	public void setDataCompromisso(Date dataCompromisso) {
		this.dataCompromisso = dataCompromisso;
	}

}
