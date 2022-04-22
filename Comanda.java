package restaurante;

public class Comanda {
	private String nomeCliente;
	private int cod;
	private int numMesa;
	private double valor;
	private Comanda prox;
	
	public Comanda (int cod, String nomeCliente) {
		this.cod = cod;
		this.nomeCliente = nomeCliente;
		this.numMesa = 0;
		this.valor = 0;
		this.prox = null;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Comanda getProx() {
		return prox;
	}

	public void setProx(Comanda prox) {
		this.prox = prox;
	}
	
	
	

}
