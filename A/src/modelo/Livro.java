package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.LivroDAO;

public class Livro {

	// atributos da classe
	private String nome;
	private AreaAdvocacia area;
	private Editora editora;
	private Autor autor;
	private int cod;
	private java.sql.Date dataAquisicao;
	private double precoPago;

	public static void main(String[] args){
		LivroDAO o = new LivroDAO();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date d = java.sql.Date.valueOf(formattedDate);
		if(o.insertLivro(new Livro("Raposu Lindo", new AreaAdvocacia("Liberdade"), new Editora("Andre o proprio"),
				new Autor("Euzinho andré"),01, d, 10.99))){
			System.out.println("foi suave, verifica la");
		}else{
			System.out.println("deu caca, verifica o erro ae");
		}
	}
	// construtor da classe
	public Livro() {
		// default
	}

	public Livro(String nome, AreaAdvocacia area, Editora editora, Autor autor,
			int cod, java.sql.Date dataAquisicao, double precoPago) {
		super();
		this.nome = nome;
		this.area = area;
		this.editora = editora;
		this.autor = autor;
		this.cod = cod;
		this.dataAquisicao = dataAquisicao;
		this.precoPago = precoPago;
	}



	// metodos de acesso
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area.toString();
	}

	public void setArea(AreaAdvocacia area) {
		this.area = area;
	}

	public String getEditora() {
		return editora.toString();
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor.toString();
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public java.sql.Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(java.sql.Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public double getPrecoPago() {
		return precoPago;
	}

	public void setPrecoPago(double precoPago) {
		this.precoPago = precoPago;
	}

	public String toString() {
		return nome;
	}

	// metodos da classe
	public void manter() {
		// a codificar
	}

	public void selecionar() {
		// a codificar
	}

}