package model;

public class Conta {

	private int codigo;
	private double valortotal;
	private boolean pago;
	
	
	public Conta(){
		
	}
	
	public Conta(int codigo, double valortotal, boolean pago) {
	
		this.codigo = codigo;
		this.valortotal = valortotal;
		this.pago = pago;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValortotal() {
		return valortotal;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	
	
}
