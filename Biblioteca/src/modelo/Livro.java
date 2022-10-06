package modelo;

public class Livro{
	String nome, area, codigo, dataDeAqs; 
	double preco;
	String[] autores;
	
	public Livro(){
		
	}
	
	public Livro(String nome, String area, String codigo, String dataDeAqs, double preco, String[] autores) {
		this.nome = nome;
		this.area = area;
		this.codigo = codigo;
		this.dataDeAqs = dataDeAqs;
		this.preco = preco;
		this.autores = autores;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDataDeAqs() {
		return dataDeAqs;
	}
	public void setDataDeAqs(String dataDeAqs) {
		this.dataDeAqs = dataDeAqs;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String[] getAutores() {
		return autores;
	}
	public void setAutores(String[] autores) {
		this.autores = autores;
	}
	
	
}
