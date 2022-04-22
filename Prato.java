package restaurante;

public class Prato {
	private int dado;
	private Prato prox;
	
	public Prato(int dado) {
		super();
		this.dado = dado;
		this.prox = null;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public Prato getProx() {
		return prox;
	}

	public void setProx(Prato prox) {
		this.prox = prox;
	}
	
	
	

}
